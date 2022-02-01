package com.tencent.mobileqq.bubble;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

public class BubbleDiyFetcher
{
  public static BubbleDiyFetcher a;
  public static boolean f = false;
  public static volatile long l;
  public final int b = 64;
  public final Map<String, String> c = Collections.synchronizedMap(new LRULinkedHashMap(32));
  public final Map<String, HashMap<String, String>> d = Collections.synchronizedMap(new LRULinkedHashMap(64));
  public final Handler e = new Handler(Looper.getMainLooper());
  public final CopyOnWriteArrayList<VipBubbleDrawable> g = new CopyOnWriteArrayList();
  public final CopyOnWriteArraySet<String> h = new CopyOnWriteArraySet();
  public final CopyOnWriteArraySet<String> i = new CopyOnWriteArraySet();
  public final CopyOnWriteArraySet<String> j = new CopyOnWriteArraySet();
  public final ConcurrentHashMap<Integer, HashMap<String, DiyBubbleConfig>> k = new ConcurrentHashMap();
  public final Runnable m = new BubbleDiyFetcher.1(this);
  
  @Nullable
  private Bitmap a(File paramFile, String paramString, Bitmap paramBitmap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".png");
    paramFile = new File(paramFile, localStringBuilder.toString());
    if (paramFile.exists())
    {
      a(paramFile.getAbsolutePath(), "decode and put scale bitmap into BaseApplicationImpl.sImageCache, ");
      paramFile = BitmapManager.a(paramFile.getAbsolutePath());
      paramBitmap = paramFile;
      if (paramFile != null)
      {
        paramBitmap = GlobalImageCache.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("BubbleDiyFetcher_");
        localStringBuilder.append(paramString);
        paramBitmap.put(localStringBuilder.toString(), paramFile);
        paramBitmap = paramFile;
      }
    }
    return paramBitmap;
  }
  
  public static BubbleDiyFetcher a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new BubbleDiyFetcher();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      QLog.i("BubbleDiyFetcher", 2, localStringBuilder.toString());
    }
  }
  
  private void a(Set<String> paramSet)
  {
    this.e.post(new BubbleDiyFetcher.3(this, paramSet));
  }
  
  private boolean c(VipBubbleDrawable paramVipBubbleDrawable, DiyBubbleConfig.DiyBubblePasterConfig paramDiyBubblePasterConfig)
  {
    return (paramVipBubbleDrawable == null) || (paramDiyBubblePasterConfig == null) || (TextUtils.isEmpty(paramVipBubbleDrawable.c));
  }
  
  private void d(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new BubbleDiyFetcher.4(this, paramQQAppInterface), 5, null, false);
  }
  
  public Bitmap a(VipBubbleDrawable paramVipBubbleDrawable, DiyBubbleConfig.DiyBubblePasterConfig paramDiyBubblePasterConfig)
  {
    if (paramVipBubbleDrawable != null)
    {
      if (paramDiyBubblePasterConfig == null) {
        return null;
      }
      paramVipBubbleDrawable = new StringBuilder();
      paramVipBubbleDrawable.append("BubbleDiyFetcher_");
      paramVipBubbleDrawable.append(paramDiyBubblePasterConfig.c);
      paramVipBubbleDrawable.append("_");
      paramVipBubbleDrawable.append(paramDiyBubblePasterConfig.a.toUpperCase());
      paramVipBubbleDrawable.append("_");
      paramVipBubbleDrawable.append("chartlet");
      paramVipBubbleDrawable = paramVipBubbleDrawable.toString();
      paramDiyBubblePasterConfig = (Bitmap)GlobalImageCache.a.get(paramVipBubbleDrawable);
      if (paramDiyBubblePasterConfig != null)
      {
        this.j.remove(paramVipBubbleDrawable);
        return paramDiyBubblePasterConfig;
      }
      this.j.add(paramVipBubbleDrawable);
      paramVipBubbleDrawable = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramVipBubbleDrawable instanceof QQAppInterface)) {
        a((QQAppInterface)paramVipBubbleDrawable, 500);
      }
    }
    return null;
  }
  
  public String a(VipBubbleDrawable paramVipBubbleDrawable, String paramString)
  {
    if ((paramVipBubbleDrawable != null) && (!TextUtils.isEmpty(paramString)))
    {
      String str = (String)this.c.get(paramString);
      if (str != null) {
        return str;
      }
      this.h.add(paramString);
      a(" and post delay 0.5s to load bubble diy!", "fetchDiyText: put VipBubbleDrawable into mNotRefreshAIODrawables");
      this.g.add(paramVipBubbleDrawable);
      paramVipBubbleDrawable = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramVipBubbleDrawable instanceof QQAppInterface)) {
        a((QQAppInterface)paramVipBubbleDrawable, 500);
      }
      return null;
    }
    return "";
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (!f)
    {
      f = true;
      ThreadManager.post(new BubbleDiyFetcher.2(this, paramQQAppInterface), 5, null, false);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if ((!this.h.isEmpty()) || (!this.i.isEmpty()) || (!this.j.isEmpty()))
    {
      if (paramInt <= 0)
      {
        this.e.removeCallbacks(this.m);
        b(paramQQAppInterface);
        return;
      }
      if (System.currentTimeMillis() > l)
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("postLoadBubbleDiyTexts delay:  ");
          paramQQAppInterface.append(paramInt);
          QLog.i("BubbleDiyFetcher", 2, paramQQAppInterface.toString());
        }
        paramQQAppInterface = this.e;
        Runnable localRunnable = this.m;
        long l1 = paramInt;
        paramQQAppInterface.postDelayed(localRunnable, l1);
        l = System.currentTimeMillis() + l1;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, String.format("uinAndDiyId %s, text cache is %b, diy paster cache is %b", new Object[] { paramString, Boolean.valueOf(this.c.containsKey(paramString)), Boolean.valueOf(this.d.containsKey(paramString)) }));
      }
      if ((this.c.containsKey(paramString)) && (this.d.containsKey(paramString)))
      {
        paramQQAppInterface = new BubbleDiyEntity();
        paramQQAppInterface.uinAndDiyId = paramString;
        paramQQAppInterface.diyText = ((String)this.c.get(paramQQAppInterface.uinAndDiyId));
        BubbleDiyEntity.parsePasterMap(paramQQAppInterface, (HashMap)this.d.get(paramString));
        paramString = new ArrayList();
        paramString.add(paramQQAppInterface);
        if (paramBusinessObserver != null) {
          paramBusinessObserver.onUpdate(1, true, paramString);
        }
        return;
      }
      Object localObject = (BubbleDiyEntity)paramQQAppInterface.getEntityManagerFactory().createEntityManager().find(BubbleDiyEntity.class, " uinAndDiyId=? ", new String[] { paramString });
      if (localObject != null)
      {
        a(paramString, "query bubbleDiy from database, uinAndDiyId: ");
        this.c.put(paramString, ((BubbleDiyEntity)localObject).diyText);
        this.d.put(paramString, ((BubbleDiyEntity)localObject).convertToPasterMap());
        paramQQAppInterface = new ArrayList();
        paramQQAppInterface.add(localObject);
        if (paramBusinessObserver != null) {
          paramBusinessObserver.onUpdate(1, true, paramQQAppInterface);
        }
        return;
      }
      a(paramString, "start request diy id ");
      this.h.add(paramString);
      localObject = new ArrayList();
      ((List)localObject).add(paramString);
      ((BubbleDiyHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BUBBLE_DIYTEXT_HANDLER)).a((List)localObject, paramBusinessObserver);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, List<BubbleDiyEntity> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BubbleDiyEntity localBubbleDiyEntity = (BubbleDiyEntity)paramList.next();
        if (paramBoolean) {
          paramQQAppInterface.getEntityManagerFactory().createEntityManager().persistOrReplace(localBubbleDiyEntity);
        }
        this.h.remove(localBubbleDiyEntity.uinAndDiyId);
        this.c.put(localBubbleDiyEntity.uinAndDiyId, localBubbleDiyEntity.diyText);
        this.d.put(localBubbleDiyEntity.uinAndDiyId, localBubbleDiyEntity.convertToPasterMap());
        if (!TextUtils.isEmpty(localBubbleDiyEntity.topLeftId)) {
          a(localBubbleDiyEntity.topLeftId);
        }
        if (!TextUtils.isEmpty(localBubbleDiyEntity.topRightId)) {
          a(localBubbleDiyEntity.topRightId);
        }
        if (!TextUtils.isEmpty(localBubbleDiyEntity.bottomLeftId)) {
          a(localBubbleDiyEntity.bottomLeftId);
        }
        if (!TextUtils.isEmpty(localBubbleDiyEntity.bottomRightId)) {
          a(localBubbleDiyEntity.bottomRightId);
        }
      }
      b();
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.endsWith(paramString)) {
          e(str);
        }
      }
    }
  }
  
  public Bitmap b(VipBubbleDrawable paramVipBubbleDrawable, DiyBubbleConfig.DiyBubblePasterConfig paramDiyBubblePasterConfig)
  {
    if (c(paramVipBubbleDrawable, paramDiyBubblePasterConfig)) {
      return null;
    }
    if (this.d.containsKey(paramVipBubbleDrawable.c))
    {
      Object localObject = (HashMap)this.d.get(paramVipBubbleDrawable.c);
      if ((localObject != null) && (((HashMap)localObject).containsKey(paramDiyBubblePasterConfig.a.toUpperCase())))
      {
        localObject = (String)((HashMap)localObject).get(paramDiyBubblePasterConfig.a.toUpperCase());
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("diy id ");
            ((StringBuilder)localObject).append(paramVipBubbleDrawable.c);
            ((StringBuilder)localObject).append(" has no pasterId for align: ");
            ((StringBuilder)localObject).append(paramDiyBubblePasterConfig.a.toUpperCase());
            QLog.i("BubbleDiyFetcher", 2, ((StringBuilder)localObject).toString());
          }
          return null;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("BubbleDiyFetcher_");
        localStringBuilder.append(paramDiyBubblePasterConfig.c);
        localStringBuilder.append("_");
        localStringBuilder.append(paramDiyBubblePasterConfig.a.toUpperCase());
        localStringBuilder.append("_");
        localStringBuilder.append((String)localObject);
        paramDiyBubblePasterConfig = localStringBuilder.toString();
        localObject = (Bitmap)GlobalImageCache.a.get(paramDiyBubblePasterConfig);
        if (localObject != null)
        {
          this.i.remove(paramDiyBubblePasterConfig);
          return localObject;
        }
        a(paramDiyBubblePasterConfig, "can not found bitmap cache in BaseApplicationImpl.sImageCache! ");
        this.i.add(paramDiyBubblePasterConfig);
      }
      else
      {
        return null;
      }
    }
    else
    {
      a(paramVipBubbleDrawable.c, "can not found cache in diyPasterCache! ");
      this.h.add(paramVipBubbleDrawable.c);
    }
    a(" and post delay 0.5s to load bubble diy!", "fetchDiyPaster: put VipBubbleDrawable into mNotRefreshAIODrawables");
    this.g.add(paramVipBubbleDrawable);
    paramVipBubbleDrawable = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramVipBubbleDrawable instanceof QQAppInterface)) {
      a((QQAppInterface)paramVipBubbleDrawable, 500);
    }
    return null;
  }
  
  @TargetApi(11)
  public void b()
  {
    HashSet localHashSet = new HashSet(this.g.size());
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      VipBubbleDrawable localVipBubbleDrawable = (VipBubbleDrawable)localIterator.next();
      if ((localVipBubbleDrawable != null) && (localVipBubbleDrawable.getCallback() != null) && (b(localVipBubbleDrawable.c))) {
        localHashSet.add(localVipBubbleDrawable.c);
      }
    }
    if (localHashSet.size() > 0)
    {
      a(TextUtils.join(",", localHashSet), "refreshDrawableOnUiThread: ");
      a(localHashSet);
    }
  }
  
  @TargetApi(11)
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a(paramQQAppInterface);
    if ((!this.h.isEmpty()) || (!this.i.isEmpty()) || (!this.g.isEmpty()) || (!this.j.isEmpty())) {
      d(paramQQAppInterface);
    }
  }
  
  public boolean b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.c.containsKey(paramString)) && (this.d.containsKey(paramString)))
    {
      paramString = (HashMap)this.d.get(paramString);
      boolean bool2 = true;
      Iterator localIterator = this.i.iterator();
      String[] arrayOfString;
      do
      {
        bool1 = bool2;
        if (!localIterator.hasNext()) {
          break;
        }
        arrayOfString = ((String)localIterator.next()).split("_");
      } while ((arrayOfString.length != 4) || (!paramString.containsValue(arrayOfString[3])));
      boolean bool1 = false;
      return bool1;
    }
    return false;
  }
  
  public void c()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      d();
      if (!this.i.isEmpty())
      {
        IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)((AppRuntime)localObject1).getRuntimeService(IVasQuickUpdateService.class, "");
        ArrayList localArrayList = new ArrayList(this.i);
        Iterator localIterator = localArrayList.iterator();
        Object localObject2 = null;
        int n = 0;
        while (localIterator.hasNext())
        {
          Object localObject3 = ((String)localIterator.next()).split("_");
          if (localObject3.length == 4)
          {
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new String[localArrayList.size()];
            }
            localObject2 = localObject3[3];
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("bubble.paster.");
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append(".png");
            localObject1[n] = ((StringBuilder)localObject3).toString();
            n += 1;
            localObject2 = localObject1;
          }
        }
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          a(TextUtils.join(",", (Object[])localObject2), "now download from VasUpdateConstants list: ");
          localIVasQuickUpdateService.downloadGatherItem(2L, localObject2[0], (String[])localObject2, "0");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("BubbleDiyFetcher", 2, "all paster has decode!");
      }
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    if (this.h.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "mUnCacheDiyId size is 0!");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new ArrayList(this.h);
    int i1 = ((ArrayList)localObject1).size();
    Object localObject2 = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    int n = 0;
    while (n < i1)
    {
      BubbleDiyEntity localBubbleDiyEntity = (BubbleDiyEntity)((EntityManager)localObject2).find(BubbleDiyEntity.class, (String)((ArrayList)localObject1).get(n));
      if (localBubbleDiyEntity != null) {
        localArrayList.add(localBubbleDiyEntity);
      }
      n += 1;
    }
    localObject1 = localArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BubbleDiyEntity)((Iterator)localObject1).next();
      this.h.remove(((BubbleDiyEntity)localObject2).uinAndDiyId);
    }
    if (!localArrayList.isEmpty()) {
      a(paramQQAppInterface, false, localArrayList);
    }
  }
  
  public void c(String paramString)
  {
    a(paramString, "notifyPasterDownloadComplete ");
    if (!TextUtils.isEmpty(paramString))
    {
      a(paramString);
      b();
    }
  }
  
  public void d()
  {
    if (this.i.size() > 0)
    {
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext()) {
        e((String)localIterator.next());
      }
      b();
    }
  }
  
  public void d(String paramString)
  {
    Object localObject1 = (BubbleManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    Object localObject2 = paramString.split("_");
    if (localObject2.length == 4)
    {
      Object localObject3 = localObject2[1];
      Object localObject4 = localObject2[2];
      if (GlobalImageCache.a.get(paramString) == null)
      {
        localObject1 = new File(((BubbleManager)localObject1).a(), String.valueOf(localObject3)).getAbsolutePath();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(File.separatorChar);
        ((StringBuilder)localObject2).append("chartlet");
        ((StringBuilder)localObject2).append(File.separatorChar);
        ((StringBuilder)localObject2).append("chartlet.png");
        Object localObject5 = ((StringBuilder)localObject2).toString();
        localObject1 = GlobalImageCache.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("BubbleDiyFetcher_");
        ((StringBuilder)localObject2).append((String)localObject3);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append("chartlet");
        localObject2 = (Bitmap)((MQLruCache)localObject1).get(((StringBuilder)localObject2).toString());
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject5 = new File((String)localObject5);
          localObject1 = localObject2;
          if (((File)localObject5).exists())
          {
            a(((File)localObject5).getAbsolutePath(), "createStaticBitmapCache: decode and put scale bitmap into BaseApplicationImpl.sImageCache, ");
            localObject2 = BitmapManager.a(((File)localObject5).getAbsolutePath());
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              localObject1 = GlobalImageCache.a;
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("BubbleDiyFetcher_");
              ((StringBuilder)localObject5).append((String)localObject3);
              ((StringBuilder)localObject5).append("_");
              ((StringBuilder)localObject5).append("chartlet");
              ((MQLruCache)localObject1).put(((StringBuilder)localObject5).toString(), localObject2);
              localObject1 = localObject2;
            }
          }
        }
        if (localObject1 != null)
        {
          localObject2 = null;
          try
          {
            localObject3 = (HashMap)this.k.get(Integer.valueOf(Integer.parseInt((String)localObject3)));
            localObject2 = localObject3;
          }
          catch (Exception localException)
          {
            QLog.e("BubbleDiyFetcher", 1, "createStaticBitmapCache error!", localException);
          }
          if ((localObject2 != null) && (((HashMap)localObject2).containsKey(localObject4)))
          {
            localObject2 = (DiyBubbleConfig)((HashMap)localObject2).get(localObject4);
            localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, localObject2.b[2], localObject2.b[3], true);
            GlobalImageCache.a.put(paramString, localObject1);
            this.j.remove(paramString);
          }
        }
      }
    }
  }
  
  public void e()
  {
    this.g.clear();
  }
  
  public void e(String paramString)
  {
    File localFile = ((BubbleManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER)).b();
    Object localObject1 = paramString.split("_");
    if (localObject1.length == 4)
    {
      String str2 = localObject1[3];
      String str1 = localObject1[1];
      Object localObject3 = localObject1[2];
      if (GlobalImageCache.a.get(paramString) == null)
      {
        localObject1 = GlobalImageCache.a;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("BubbleDiyFetcher_");
        ((StringBuilder)localObject2).append(str2);
        localObject2 = (Bitmap)((MQLruCache)localObject1).get(((StringBuilder)localObject2).toString());
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = a(localFile, str2, (Bitmap)localObject2);
        }
        if (localObject1 != null)
        {
          localFile = null;
          try
          {
            localObject2 = (HashMap)this.k.get(Integer.valueOf(Integer.parseInt(str1)));
          }
          catch (Exception localException)
          {
            localObject2 = localFile;
            if (QLog.isColorLevel())
            {
              QLog.e("BubbleDiyFetcher", 2, "", localException);
              localObject2 = localFile;
            }
          }
          if ((localObject2 != null) && (((HashMap)localObject2).containsKey(localObject3)))
          {
            localObject2 = (DiyBubbleConfig)((HashMap)localObject2).get(localObject3);
            localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, localObject2.b[2], localObject2.b[3], true);
            GlobalImageCache.a.put(paramString, localObject1);
            this.i.remove(paramString);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyFetcher
 * JD-Core Version:    0.7.0.1
 */