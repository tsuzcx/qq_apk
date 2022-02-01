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
  public static volatile long a = 0L;
  public static BubbleDiyFetcher a;
  public static boolean a = false;
  public final int a;
  public final Handler a;
  public final Runnable a;
  public final Map<String, String> a;
  public final ConcurrentHashMap<Integer, HashMap<String, DiyBubbleConfig>> a;
  public final CopyOnWriteArrayList<VipBubbleDrawable> a;
  public final CopyOnWriteArraySet<String> a;
  public final Map<String, HashMap<String, String>> b;
  public final CopyOnWriteArraySet<String> b;
  public final CopyOnWriteArraySet<String> c = new CopyOnWriteArraySet();
  
  private BubbleDiyFetcher()
  {
    this.jdField_a_of_type_Int = 64;
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LRULinkedHashMap(32));
    this.jdField_b_of_type_JavaUtilMap = Collections.synchronizedMap(new LRULinkedHashMap(64));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangRunnable = new BubbleDiyFetcher.1(this);
  }
  
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
    if (jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher == null) {
          jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher = new BubbleDiyFetcher();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher;
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
    this.jdField_a_of_type_AndroidOsHandler.post(new BubbleDiyFetcher.3(this, paramSet));
  }
  
  private boolean a(VipBubbleDrawable paramVipBubbleDrawable, DiyBubbleConfig.DiyBubblePasterConfig paramDiyBubblePasterConfig)
  {
    return (paramVipBubbleDrawable == null) || (paramDiyBubblePasterConfig == null) || (TextUtils.isEmpty(paramVipBubbleDrawable.jdField_a_of_type_JavaLangString));
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
      paramVipBubbleDrawable.append(paramDiyBubblePasterConfig.jdField_a_of_type_Int);
      paramVipBubbleDrawable.append("_");
      paramVipBubbleDrawable.append(paramDiyBubblePasterConfig.jdField_a_of_type_JavaLangString.toUpperCase());
      paramVipBubbleDrawable.append("_");
      paramVipBubbleDrawable.append("chartlet");
      paramVipBubbleDrawable = paramVipBubbleDrawable.toString();
      paramDiyBubblePasterConfig = (Bitmap)GlobalImageCache.a.get(paramVipBubbleDrawable);
      if (paramDiyBubblePasterConfig != null)
      {
        this.c.remove(paramVipBubbleDrawable);
        return paramDiyBubblePasterConfig;
      }
      this.c.add(paramVipBubbleDrawable);
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
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (str != null) {
        return str;
      }
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramString);
      a(" and post delay 0.5s to load bubble diy!", "fetchDiyText: put VipBubbleDrawable into mNotRefreshAIODrawables");
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramVipBubbleDrawable);
      paramVipBubbleDrawable = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramVipBubbleDrawable instanceof QQAppInterface)) {
        a((QQAppInterface)paramVipBubbleDrawable, 500);
      }
      return null;
    }
    return "";
  }
  
  @TargetApi(11)
  public void a()
  {
    HashSet localHashSet = new HashSet(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      VipBubbleDrawable localVipBubbleDrawable = (VipBubbleDrawable)localIterator.next();
      if ((localVipBubbleDrawable != null) && (localVipBubbleDrawable.getCallback() != null) && (a(localVipBubbleDrawable.jdField_a_of_type_JavaLangString))) {
        localHashSet.add(localVipBubbleDrawable.jdField_a_of_type_JavaLangString);
      }
    }
    if (localHashSet.size() > 0)
    {
      a(TextUtils.join(",", localHashSet), "refreshDrawableOnUiThread: ");
      a(localHashSet);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      ThreadManager.post(new BubbleDiyFetcher.2(this, paramQQAppInterface), 5, null, false);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if ((!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) || (!this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) || (!this.c.isEmpty()))
    {
      if (paramInt <= 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        b(paramQQAppInterface);
        return;
      }
      if (System.currentTimeMillis() > jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("postLoadBubbleDiyTexts delay:  ");
          paramQQAppInterface.append(paramInt);
          QLog.i("BubbleDiyFetcher", 2, paramQQAppInterface.toString());
        }
        paramQQAppInterface = this.jdField_a_of_type_AndroidOsHandler;
        Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
        long l = paramInt;
        paramQQAppInterface.postDelayed(localRunnable, l);
        jdField_a_of_type_Long = System.currentTimeMillis() + l;
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
        QLog.i("BubbleDiyFetcher", 2, String.format("uinAndDiyId %s, text cache is %b, diy paster cache is %b", new Object[] { paramString, Boolean.valueOf(this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)), Boolean.valueOf(this.jdField_b_of_type_JavaUtilMap.containsKey(paramString)) }));
      }
      if ((this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (this.jdField_b_of_type_JavaUtilMap.containsKey(paramString)))
      {
        paramQQAppInterface = new BubbleDiyEntity();
        paramQQAppInterface.uinAndDiyId = paramString;
        paramQQAppInterface.diyText = ((String)this.jdField_a_of_type_JavaUtilMap.get(paramQQAppInterface.uinAndDiyId));
        BubbleDiyEntity.parsePasterMap(paramQQAppInterface, (HashMap)this.jdField_b_of_type_JavaUtilMap.get(paramString));
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
        this.jdField_a_of_type_JavaUtilMap.put(paramString, ((BubbleDiyEntity)localObject).diyText);
        this.jdField_b_of_type_JavaUtilMap.put(paramString, ((BubbleDiyEntity)localObject).convertToPasterMap());
        paramQQAppInterface = new ArrayList();
        paramQQAppInterface.add(localObject);
        if (paramBusinessObserver != null) {
          paramBusinessObserver.onUpdate(1, true, paramQQAppInterface);
        }
        return;
      }
      a(paramString, "start request diy id ");
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramString);
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
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localBubbleDiyEntity.uinAndDiyId);
        this.jdField_a_of_type_JavaUtilMap.put(localBubbleDiyEntity.uinAndDiyId, localBubbleDiyEntity.diyText);
        this.jdField_b_of_type_JavaUtilMap.put(localBubbleDiyEntity.uinAndDiyId, localBubbleDiyEntity.convertToPasterMap());
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
      a();
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.endsWith(paramString)) {
          d(str);
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (this.jdField_b_of_type_JavaUtilMap.containsKey(paramString)))
    {
      paramString = (HashMap)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      boolean bool2 = true;
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
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
  
  public Bitmap b(VipBubbleDrawable paramVipBubbleDrawable, DiyBubbleConfig.DiyBubblePasterConfig paramDiyBubblePasterConfig)
  {
    if (a(paramVipBubbleDrawable, paramDiyBubblePasterConfig)) {
      return null;
    }
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(paramVipBubbleDrawable.jdField_a_of_type_JavaLangString))
    {
      Object localObject = (HashMap)this.jdField_b_of_type_JavaUtilMap.get(paramVipBubbleDrawable.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (((HashMap)localObject).containsKey(paramDiyBubblePasterConfig.jdField_a_of_type_JavaLangString.toUpperCase())))
      {
        localObject = (String)((HashMap)localObject).get(paramDiyBubblePasterConfig.jdField_a_of_type_JavaLangString.toUpperCase());
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("diy id ");
            ((StringBuilder)localObject).append(paramVipBubbleDrawable.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject).append(" has no pasterId for align: ");
            ((StringBuilder)localObject).append(paramDiyBubblePasterConfig.jdField_a_of_type_JavaLangString.toUpperCase());
            QLog.i("BubbleDiyFetcher", 2, ((StringBuilder)localObject).toString());
          }
          return null;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("BubbleDiyFetcher_");
        localStringBuilder.append(paramDiyBubblePasterConfig.jdField_a_of_type_Int);
        localStringBuilder.append("_");
        localStringBuilder.append(paramDiyBubblePasterConfig.jdField_a_of_type_JavaLangString.toUpperCase());
        localStringBuilder.append("_");
        localStringBuilder.append((String)localObject);
        paramDiyBubblePasterConfig = localStringBuilder.toString();
        localObject = (Bitmap)GlobalImageCache.a.get(paramDiyBubblePasterConfig);
        if (localObject != null)
        {
          this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramDiyBubblePasterConfig);
          return localObject;
        }
        a(paramDiyBubblePasterConfig, "can not found bitmap cache in BaseApplicationImpl.sImageCache! ");
        this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramDiyBubblePasterConfig);
      }
      else
      {
        return null;
      }
    }
    else
    {
      a(paramVipBubbleDrawable.jdField_a_of_type_JavaLangString, "can not found cache in diyPasterCache! ");
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramVipBubbleDrawable.jdField_a_of_type_JavaLangString);
    }
    a(" and post delay 0.5s to load bubble diy!", "fetchDiyPaster: put VipBubbleDrawable into mNotRefreshAIODrawables");
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramVipBubbleDrawable);
    paramVipBubbleDrawable = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramVipBubbleDrawable instanceof QQAppInterface)) {
      a((QQAppInterface)paramVipBubbleDrawable, 500);
    }
    return null;
  }
  
  public void b()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      c();
      if (!this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty())
      {
        IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)((AppRuntime)localObject1).getRuntimeService(IVasQuickUpdateService.class, "");
        ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet);
        Iterator localIterator = localArrayList.iterator();
        Object localObject2 = null;
        int i = 0;
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
            localObject1[i] = ((StringBuilder)localObject3).toString();
            i += 1;
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
  
  @TargetApi(11)
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    a(paramQQAppInterface);
    if ((!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) || (!this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) || (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) || (!this.c.isEmpty())) {
      d(paramQQAppInterface);
    }
  }
  
  public void b(String paramString)
  {
    a(paramString, "notifyPasterDownloadComplete ");
    if (!TextUtils.isEmpty(paramString))
    {
      a(paramString);
      a();
    }
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size() > 0)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext()) {
        d((String)localIterator.next());
      }
      a();
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "mUnCacheDiyId size is 0!");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet);
    int j = ((ArrayList)localObject1).size();
    Object localObject2 = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    int i = 0;
    while (i < j)
    {
      BubbleDiyEntity localBubbleDiyEntity = (BubbleDiyEntity)((EntityManager)localObject2).find(BubbleDiyEntity.class, (String)((ArrayList)localObject1).get(i));
      if (localBubbleDiyEntity != null) {
        localArrayList.add(localBubbleDiyEntity);
      }
      i += 1;
    }
    localObject1 = localArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BubbleDiyEntity)((Iterator)localObject1).next();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(((BubbleDiyEntity)localObject2).uinAndDiyId);
    }
    if (!localArrayList.isEmpty()) {
      a(paramQQAppInterface, false, localArrayList);
    }
  }
  
  public void c(String paramString)
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
            localObject3 = (HashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(Integer.parseInt((String)localObject3)));
            localObject2 = localObject3;
          }
          catch (Exception localException)
          {
            QLog.e("BubbleDiyFetcher", 1, "createStaticBitmapCache error!", localException);
          }
          if ((localObject2 != null) && (((HashMap)localObject2).containsKey(localObject4)))
          {
            localObject2 = (DiyBubbleConfig)((HashMap)localObject2).get(localObject4);
            localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, localObject2.a[2], localObject2.a[3], true);
            GlobalImageCache.a.put(paramString, localObject1);
            this.c.remove(paramString);
          }
        }
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void d(String paramString)
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
            localObject2 = (HashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(Integer.parseInt(str1)));
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
            localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, localObject2.a[2], localObject2.a[3], true);
            GlobalImageCache.a.put(paramString, localObject1);
            this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramString);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyFetcher
 * JD-Core Version:    0.7.0.1
 */