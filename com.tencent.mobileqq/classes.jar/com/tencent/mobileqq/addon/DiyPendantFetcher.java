package com.tencent.mobileqq.addon;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontSoLoader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class DiyPendantFetcher
{
  public static DiyPendantFetcher a;
  public static boolean b;
  public static volatile long l;
  public final int c = 64;
  public final LRULinkedHashMap<String, DiyPendantEntity> d = new LRULinkedHashMap(64);
  public final LRULinkedHashMap<Integer, FontInfo> e = new LRULinkedHashMap(16);
  public final LRULinkedHashMap<String, Bitmap> f = new LRULinkedHashMap(10);
  public final CopyOnWriteArraySet<String> g = new CopyOnWriteArraySet();
  public final CopyOnWriteArraySet<String> h = new CopyOnWriteArraySet();
  public final CopyOnWriteArrayList<DiyPendantFetcher.Invalidatable> i = new CopyOnWriteArrayList();
  ETEngine j = ETEngine.getInstanceForDiyPendant();
  AtomicBoolean k = new AtomicBoolean(false);
  public final Runnable m = new DiyPendantFetcher.1(this);
  
  public static DiyPendantFetcher a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new DiyPendantFetcher();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void c(String paramString)
  {
    Object localObject2 = paramString.split("_");
    if (localObject2.length == 3)
    {
      Object localObject1 = localObject2[2];
      localObject2 = localObject2[1];
      if (GlobalImageCache.a.get(paramString) == null)
      {
        localObject1 = new File(AvatarPendantUtil.f((String)localObject1));
        if (((File)localObject1).exists())
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("decode and put scale bitmap into BaseApplicationImpl.sImageCache, ");
            ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
            QLog.i("DiyPendantFetcher", 2, ((StringBuilder)localObject2).toString());
          }
          localObject1 = BitmapManager.a(((File)localObject1).getAbsolutePath());
          if (localObject1 != null)
          {
            GlobalImageCache.a.put(paramString, localObject1);
            this.h.remove(paramString);
          }
        }
      }
    }
  }
  
  public Bitmap a(DiyPendantDrawable paramDiyPendantDrawable, int paramInt)
  {
    if (paramDiyPendantDrawable != null)
    {
      if (TextUtils.isEmpty(paramDiyPendantDrawable.h)) {
        return null;
      }
      Object localObject1;
      if (this.d.containsKey(paramDiyPendantDrawable.h))
      {
        localObject1 = (DiyPendantEntity)this.d.get(paramDiyPendantDrawable.h);
        if (((DiyPendantEntity)localObject1).getStickerInfoList().size() > paramInt)
        {
          localObject1 = a((DiyPendantSticker)((DiyPendantEntity)localObject1).getStickerInfoList().get(paramInt));
          Object localObject2 = (Bitmap)GlobalImageCache.a.get(localObject1);
          if (localObject2 != null)
          {
            this.h.remove(localObject1);
            return localObject2;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("can not found bitmap cache in BaseApplicationImpl.sImageCache! ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.i("DiyPendantFetcher", 2, ((StringBuilder)localObject2).toString());
          }
          this.h.add(localObject1);
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("can not found cache in DiyPendantCache! ");
          ((StringBuilder)localObject1).append(paramDiyPendantDrawable.h);
          QLog.i("DiyPendantFetcher", 2, ((StringBuilder)localObject1).toString());
        }
        this.g.add(paramDiyPendantDrawable.h);
      }
      if (QLog.isColorLevel()) {
        QLog.i("DiyPendantFetcher", 2, "fetchDiyPaster: put DiyPendantDrawable into mNotRefreshAIODrawables and post delay 0.5s to load bubble diy!");
      }
      this.i.add(paramDiyPendantDrawable);
      paramDiyPendantDrawable = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramDiyPendantDrawable instanceof QQAppInterface)) {
        a((QQAppInterface)paramDiyPendantDrawable, 500);
      }
    }
    return null;
  }
  
  public Bitmap a(DiyPendantFetcher.Invalidatable paramInvalidatable, String paramString, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    String str;
    if ((!TextUtils.isEmpty(paramString)) && (paramInt1 > 0))
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(paramString);
      ((StringBuilder)???).append("_");
      ((StringBuilder)???).append(paramInt1);
      ((StringBuilder)???).append("_");
      ((StringBuilder)???).append(paramInt2);
      ((StringBuilder)???).append("_");
      ((StringBuilder)???).append(paramFloat);
      ((StringBuilder)???).append("_");
      ((StringBuilder)???).append(paramInt3);
      ((StringBuilder)???).append("_");
      ((StringBuilder)???).append(paramInt4);
      ((StringBuilder)???).append("_");
      ((StringBuilder)???).append(paramInt5);
      str = ((StringBuilder)???).toString();
      if (this.f.containsKey(str)) {
        return (Bitmap)this.f.get(str);
      }
    }
    label703:
    label708:
    label711:
    for (;;)
    {
      synchronized (this.j)
      {
        if (!this.k.get()) {
          b();
        }
        if ((this.k.get()) && (!TextUtils.isEmpty(paramString)))
        {
          Object localObject2 = AvatarPendantUtil.c(String.valueOf(paramInt1));
          if (!this.j.native_isFontLoaded(paramInt1))
          {
            this.i.add(paramInvalidatable);
            if (AvatarPendantUtil.b(String.valueOf(paramInt1)))
            {
              if (QLog.isColorLevel())
              {
                paramInvalidatable = new StringBuilder();
                paramInvalidatable.append("found font res but can not load the font, font id = ");
                paramInvalidatable.append(paramInt1);
                QLog.i("DiyPendantFetcher", 2, paramInvalidatable.toString());
              }
              ThreadManager.executeOnFileThread(new DiyPendantFetcher.3(this, (String)localObject2, paramInt1));
            }
            else
            {
              if (QLog.isColorLevel())
              {
                paramInvalidatable = new StringBuilder();
                paramInvalidatable.append("can not found font res! font id = ");
                paramInvalidatable.append(paramInt1);
                QLog.i("DiyPendantFetcher", 2, paramInvalidatable.toString());
              }
              a(paramInt1, paramInt2);
            }
            QLog.d("DiyPendantFetcher", 1, "fetchTextWithFont fail font not exist!");
            return null;
          }
          localObject2 = new ETFont(paramInt1, (String)localObject2, paramFloat);
          ((ETFont)localObject2).setColor(paramInt3);
          try
          {
            paramInvalidatable = Bitmap.createBitmap(paramInt4, paramInt5, Bitmap.Config.ARGB_8888);
            if (!this.j.native_isPaintableChar(paramString.charAt(0), (ETFont)localObject2)) {
              break label711;
            }
            paramInt1 = this.j.native_spaceMeasureText(paramString, 0, paramString.length(), (ETFont)localObject2, paramPaint);
            if (paramInt1 > paramInt4)
            {
              ((ETFont)localObject2).mFontSize -= 1;
              paramInt1 = this.j.native_spaceMeasureText(paramString, 0, paramString.length(), (ETFont)localObject2, paramPaint);
              continue;
            }
            paramInt2 = (paramInt4 - paramInt1) / 2;
            paramPaint = new Paint.FontMetrics();
            if (!this.j.native_getFontMetrics(paramPaint, (ETFont)localObject2)) {
              break label703;
            }
            paramFloat = paramPaint.bottom;
            float f1 = paramPaint.top;
            paramInt1 = (int)((paramInt5 - (paramFloat - f1)) / 2.0F);
            if (this.j.native_drawText(paramString, paramInvalidatable, paramInt2, paramInt1, (ETFont)localObject2)) {
              break label708;
            }
            paramInvalidatable = new StringBuilder();
            paramInvalidatable.append("fetchTextWithFont fail font not support: ");
            paramInvalidatable.append(paramString.charAt(0));
            QLog.d("DiyPendantFetcher", 1, paramInvalidatable.toString());
            return null;
          }
          catch (OutOfMemoryError paramInvalidatable)
          {
            paramString = new StringBuilder();
            paramString.append("fetchTextWithFont Bitmap.createBitmap OutOfMemoryError: ");
            paramString.append(paramInvalidatable.getMessage());
            QLog.d("DiyPendantFetcher", 1, paramString.toString());
            return null;
          }
          if (paramInvalidatable != null) {
            this.f.put(str, paramInvalidatable);
          }
          return paramInvalidatable;
        }
        paramInvalidatable = new StringBuilder();
        paramInvalidatable.append("fetchTextWithFont fail EnigeReady = ");
        paramInvalidatable.append(this.k.get());
        paramInvalidatable.append(" text = ");
        paramInvalidatable.append(paramString);
        QLog.d("DiyPendantFetcher", 1, paramInvalidatable.toString());
        return null;
      }
      return null;
      paramInt1 = 0;
      continue;
    }
  }
  
  public Typeface a(DiyPendantFetcher.Invalidatable paramInvalidatable, int paramInt1, int paramInt2)
  {
    if (paramInvalidatable != null)
    {
      if (paramInt1 <= 0) {
        return null;
      }
      Object localObject = (FontInfo)this.e.get(Integer.valueOf(paramInt1));
      if ((localObject != null) && (((FontInfo)localObject).d != null)) {
        return ((FontInfo)localObject).d;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("can not found typeface in the cache! font id = ");
        ((StringBuilder)localObject).append(paramInt1);
        QLog.i("DiyPendantFetcher", 2, ((StringBuilder)localObject).toString());
      }
      this.i.add(paramInvalidatable);
      a(paramInt1, paramInt2);
    }
    return null;
  }
  
  public DiyPendantEntity a(QQAppInterface paramQQAppInterface, String paramString, BusinessObserver paramBusinessObserver)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      if (this.d.containsKey(paramString))
      {
        paramQQAppInterface = new ArrayList();
        paramQQAppInterface.add(this.d.get(paramString));
        if (paramBusinessObserver != null) {
          paramBusinessObserver.onUpdate(1, true, paramQQAppInterface);
        }
        return (DiyPendantEntity)this.d.get(paramString);
      }
      Object localObject = (DiyPendantEntity)paramQQAppInterface.getEntityManagerFactory().createEntityManager().find(DiyPendantEntity.class, " uinAndDiyId=? ", new String[] { paramString });
      if (localObject != null)
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("query diy pendant from database, uinAndDiyId: ");
          paramQQAppInterface.append(paramString);
          QLog.i("DiyPendantFetcher", 2, paramQQAppInterface.toString());
        }
        this.d.put(paramString, localObject);
        paramQQAppInterface = new ArrayList();
        paramQQAppInterface.add(localObject);
        if (paramBusinessObserver != null) {
          paramBusinessObserver.onUpdate(1, true, paramQQAppInterface);
        }
        return localObject;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("start request diy id ");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("DiyPendantFetcher", 2, ((StringBuilder)localObject).toString());
      }
      this.g.add(paramString);
      localObject = new ArrayList();
      ((List)localObject).add(Long.valueOf(Long.parseLong(paramString.split("_")[0])));
      ((DiyPendantHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DIY_PENDANT_HANDLER)).a((List)localObject, paramBusinessObserver);
    }
    return null;
  }
  
  public String a(DiyPendantSticker paramDiyPendantSticker)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DiyPendantFetcher_");
    localStringBuilder.append(paramDiyPendantSticker.type);
    localStringBuilder.append("_");
    localStringBuilder.append(paramDiyPendantSticker.stickerId);
    return localStringBuilder.toString();
  }
  
  public List<DiyPendantSticker> a(DiyPendantDrawable paramDiyPendantDrawable)
  {
    if (paramDiyPendantDrawable != null)
    {
      if (TextUtils.isEmpty(paramDiyPendantDrawable.h)) {
        return null;
      }
      if (this.d.containsKey(paramDiyPendantDrawable.h)) {
        return ((DiyPendantEntity)this.d.get(paramDiyPendantDrawable.h)).getStickerInfoList();
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("can not found cache in DiyPendantCache! ");
        localStringBuilder.append(paramDiyPendantDrawable.h);
        QLog.i("DiyPendantFetcher", 2, localStringBuilder.toString());
      }
      this.g.add(paramDiyPendantDrawable.h);
      if (QLog.isColorLevel()) {
        QLog.i("DiyPendantFetcher", 2, "fetchDiyBaseInfo: put DiyPendantDrawable into mNotRefreshAIODrawables and post delay 0.5s to load bubble diy!");
      }
      this.i.add(paramDiyPendantDrawable);
      paramDiyPendantDrawable = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramDiyPendantDrawable instanceof QQAppInterface)) {
        a((QQAppInterface)paramDiyPendantDrawable, 500);
      }
    }
    return null;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    String str = AvatarPendantUtil.c(String.valueOf(paramInt1));
    if (!this.e.containsKey(Integer.valueOf(paramInt1)))
    {
      FontInfo localFontInfo = new FontInfo(paramInt1, str);
      localFontInfo.c = paramInt2;
      this.e.put(Integer.valueOf(paramInt1), localFontInfo);
    }
    ThreadManager.executeOnFileThread(new DiyPendantFetcher.4(this, paramInt1, str));
  }
  
  public void a(DiyPendantEntity paramDiyPendantEntity)
  {
    paramDiyPendantEntity = paramDiyPendantEntity.getStickerInfoList().iterator();
    while (paramDiyPendantEntity.hasNext())
    {
      String str = a((DiyPendantSticker)paramDiyPendantEntity.next());
      if (this.h.contains(str)) {
        c(str);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    b(paramQQAppInterface);
    if ((!this.g.isEmpty()) || (!this.h.isEmpty()) || (!this.i.isEmpty())) {
      ThreadManager.post(new DiyPendantFetcher.2(this, paramQQAppInterface), 5, null, false);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if ((!this.g.isEmpty()) || (!this.h.isEmpty()))
    {
      if (paramInt <= 0)
      {
        ThreadManager.getUIHandler().removeCallbacks(this.m);
        a(paramQQAppInterface);
        return;
      }
      if (System.currentTimeMillis() > l)
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("postLoadPendantDiy delay:  ");
          paramQQAppInterface.append(paramInt);
          QLog.i("DiyPendantFetcher", 2, paramQQAppInterface.toString());
        }
        paramQQAppInterface = ThreadManager.getUIHandler();
        Runnable localRunnable = this.m;
        long l1 = paramInt;
        paramQQAppInterface.postDelayed(localRunnable, l1);
        l = System.currentTimeMillis() + l1;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, List<DiyPendantEntity> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DiyPendantEntity localDiyPendantEntity = (DiyPendantEntity)paramList.next();
        if (paramBoolean)
        {
          paramQQAppInterface.getEntityManagerFactory().createEntityManager().persistOrReplace(localDiyPendantEntity);
          ExtensionInfo localExtensionInfo = localFriendsManager.x(localDiyPendantEntity.uinAndDiyId.split("_")[0]);
          if ((localExtensionInfo != null) && (localExtensionInfo.pendantDiyId != localDiyPendantEntity.diyId))
          {
            localExtensionInfo.pendantDiyId = localDiyPendantEntity.diyId;
            localArrayList.add(localExtensionInfo);
          }
        }
        this.g.remove(localDiyPendantEntity.uinAndDiyId);
        this.d.put(localDiyPendantEntity.uinAndDiyId, localDiyPendantEntity);
        a(localDiyPendantEntity);
      }
      localFriendsManager.b(localArrayList);
      e();
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyPasterDownloadComplete ");
      localStringBuilder.append(paramString);
      QLog.i("DiyPendantFetcher", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.h.contains(paramString)) {
        c(paramString);
      }
      e();
    }
  }
  
  void b()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      if (this.j.initEngine(16, 1048576))
      {
        this.k.set(true);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("DIY Pendant init Font Engine time = ");
          localStringBuilder1.append(l2 - l1);
          localStringBuilder1.append("ms");
          QLog.d("DiyPendantFetcher", 2, localStringBuilder1.toString());
        }
      }
      else
      {
        if (this.j.isEngineInited.compareAndSet(false, true)) {
          FontSoLoader.c();
        }
        this.k.set(false);
        QLog.d("DiyPendantFetcher", 1, "vip font not downloaded, start early download.");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      this.k.set(false);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("initETEngine Exception:");
      localStringBuilder2.append(localThrowable.getMessage());
      QLog.e("DiyPendantFetcher", 1, localStringBuilder2.toString());
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (!b)
    {
      b = true;
      ThreadManager.post(new DiyPendantFetcher.5(this, paramQQAppInterface), 5, null, false);
    }
  }
  
  public void b(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyFontDownloadComplete, scid =");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("DiyPendantFetcher", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.replace("faceAddon.stickerFont.android.", "");
      localObject = (FontInfo)this.e.get(Integer.valueOf(Integer.parseInt(paramString)));
      if (localObject != null) {
        if (((FontInfo)localObject).c == 1)
        {
          if (!this.k.get()) {
            b();
          }
          if ((this.k.get()) && (this.j.native_loadFont(((FontInfo)localObject).b, Integer.parseInt(paramString), true))) {
            e();
          }
        }
        else if (new File(((FontInfo)localObject).b).exists())
        {
          ((FontInfo)localObject).d = Typeface.createFromFile(((FontInfo)localObject).b);
        }
      }
    }
  }
  
  public void c()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      d();
      if (!this.h.isEmpty())
      {
        IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)((AppRuntime)localObject1).getRuntimeService(IVasQuickUpdateService.class, "");
        Iterator localIterator = this.h.iterator();
        Object localObject2 = null;
        int n = 0;
        while (localIterator.hasNext())
        {
          Object localObject3 = ((String)localIterator.next()).split("_");
          if (localObject3.length == 3)
          {
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new String[this.h.size()];
            }
            localObject2 = localObject3[2];
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("faceAddon.sticker.");
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append(".png");
            localObject1[n] = ((StringBuilder)localObject3).toString();
            n += 1;
            localObject2 = localObject1;
          }
        }
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("now download from VasUpdateConstants list: ");
            ((StringBuilder)localObject1).append(TextUtils.join(",", (Object[])localObject2));
            QLog.i("DiyPendantFetcher", 2, ((StringBuilder)localObject1).toString());
          }
          localIVasQuickUpdateService.downloadGatherItem(4L, localObject2[0], (String[])localObject2, "DiyPendantFetcher");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("DiyPendantFetcher", 2, "all paster has decode!");
      }
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    if (this.g.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DiyPendantFetcher", 2, "mUnCacheDiyId size is 0!");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new ArrayList(this.g);
    int i1 = ((ArrayList)localObject1).size();
    Object localObject2 = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    int n = 0;
    while (n < i1)
    {
      DiyPendantEntity localDiyPendantEntity = (DiyPendantEntity)((EntityManager)localObject2).find(DiyPendantEntity.class, (String)((ArrayList)localObject1).get(n));
      if (localDiyPendantEntity != null) {
        localArrayList.add(localDiyPendantEntity);
      }
      n += 1;
    }
    localObject1 = localArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DiyPendantEntity)((Iterator)localObject1).next();
      this.g.remove(((DiyPendantEntity)localObject2).uinAndDiyId);
    }
    if (!localArrayList.isEmpty()) {
      a(paramQQAppInterface, false, localArrayList);
    }
  }
  
  public void d()
  {
    if (this.h.size() > 0)
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext()) {
        c((String)localIterator.next());
      }
      e();
    }
  }
  
  @TargetApi(11)
  public void e()
  {
    ThreadManager.getUIHandler().post(new DiyPendantFetcher.6(this));
  }
  
  public void f()
  {
    this.i.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantFetcher
 * JD-Core Version:    0.7.0.1
 */