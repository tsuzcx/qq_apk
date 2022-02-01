package com.tencent.mobileqq.armap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class NonMainProcAvatarLoader
  implements INonMainProcAvatarLoader
{
  protected Context a;
  public Bitmap b = null;
  protected int c;
  protected LruCache<String, Bitmap> d = new LruCache(60);
  protected LruCache<String, String> e = new LruCache(120);
  protected HashSet<String> f = new HashSet();
  protected ArrayList<String> g = new ArrayList();
  final List<FaceObserver> h = Collections.synchronizedList(new ArrayList());
  protected Handler i = new NonMainProcAvatarLoader.2(this, Looper.getMainLooper());
  protected Handler j = new NonMainProcAvatarLoader.3(this, ThreadManager.getSubThreadLooper());
  protected float k = 1.0F;
  private byte l = 3;
  private BroadcastReceiver m = new NonMainProcAvatarLoader.1(this);
  
  public NonMainProcAvatarLoader(Context paramContext, int paramInt)
  {
    this.a = paramContext;
    this.k = this.a.getResources().getDisplayMetrics().density;
    this.c = paramInt;
    try
    {
      this.b = BaseImageUtil.k();
      return;
    }
    catch (OutOfMemoryError paramContext) {}
  }
  
  protected Bitmap a(Bitmap paramBitmap)
  {
    float f2 = this.k;
    int n = paramBitmap.getWidth();
    float f1 = f2;
    if (n > 0)
    {
      float f3 = n;
      float f4 = 50;
      f1 = f2;
      if (f3 < f2 * f4) {
        f1 = f3 / f4;
      }
    }
    n = (int)(50 * f1);
    return BaseImageUtil.a(paramBitmap, n, n, n);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, this.b);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean, Bitmap paramBitmap)
  {
    Object localObject1;
    try
    {
      localObject1 = (Bitmap)this.d.get(paramString);
      Object localObject2;
      if (localObject1 != null)
      {
        if (!QLog.isColorLevel()) {
          break label266;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getFaceBitmap, hit cache:");
        ((StringBuilder)localObject2).append(paramString);
        QLog.d("NonMainAppHeadLoader", 2, ((StringBuilder)localObject2).toString());
        return localObject1;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getFaceBitmap, not in cache:");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("NonMainAppHeadLoader", 2, ((StringBuilder)localObject1).toString());
      }
      if (!TextUtils.isEmpty((CharSequence)this.e.get(paramString)))
      {
        localObject1 = new ArrayList(1);
        localObject2 = Message.obtain();
        ((ArrayList)localObject1).add(paramString);
        ((Message)localObject2).obj = localObject1;
        ((Message)localObject2).what = 1001;
        this.j.sendMessage((Message)localObject2);
        return paramBitmap;
      }
      if ((paramBoolean) && (!this.g.contains(paramString)))
      {
        this.g.add(paramString);
        this.i.removeMessages(1000);
        this.i.sendEmptyMessageDelayed(1000, 50L);
        return paramBitmap;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getFaceBitmap, exception:");
        ((StringBuilder)localObject1).append(paramString.toString());
        QLog.e("NonMainAppHeadLoader", 2, ((StringBuilder)localObject1).toString());
      }
    }
    return paramBitmap;
    label266:
    return localObject1;
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qqhead.getheadresp");
    try
    {
      this.a.registerReceiver(this.m, localIntentFilter, "com.tencent.qqhead.permission.getheadresp", null);
      return;
    }
    catch (Throwable localThrowable)
    {
      label31:
      break label31;
    }
    QLog.d("NonMainAppHeadLoader", 1, "init register receiver fail!");
  }
  
  public void a(byte paramByte)
  {
    this.l = paramByte;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(FaceObserver paramFaceObserver)
  {
    if (paramFaceObserver == null) {
      return;
    }
    synchronized (this.h)
    {
      if (!this.h.contains(paramFaceObserver)) {
        this.h.add(paramFaceObserver);
      }
      return;
    }
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendQQHeadRequest, reqSize:");
      ((StringBuilder)localObject).append(this.f.size());
      ((StringBuilder)localObject).append(" cacheSize:");
      ((StringBuilder)localObject).append(this.d.size());
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.e.size());
      QLog.d("NonMainAppHeadLoader", 2, ((StringBuilder)localObject).toString());
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      localObject = new ArrayList(paramArrayList.size());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if (!this.f.contains(str)) {
          ((ArrayList)localObject).add(str);
        }
      }
      paramArrayList = new Intent("com.tencent.qqhead.getheadreq");
      paramArrayList.setPackage(this.a.getPackageName());
      paramArrayList.putExtra("faceType", this.c);
      paramArrayList.putStringArrayListExtra("uinList", (ArrayList)localObject);
      this.a.sendBroadcast(paramArrayList, "com.tencent.qqhead.permission.getheadresp");
      this.f.addAll((Collection)localObject);
    }
  }
  
  public Bitmap b()
  {
    return this.b;
  }
  
  public void b(FaceObserver paramFaceObserver)
  {
    if (paramFaceObserver == null) {
      return;
    }
    synchronized (this.h)
    {
      this.h.remove(paramFaceObserver);
      return;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NonMainAppHeadLoader", 2, "destroy");
    }
    try
    {
      this.a.unregisterReceiver(this.m);
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("destroy:");
        localStringBuilder1.append(localThrowable.toString());
        QLog.e("NonMainAppHeadLoader", 2, localStringBuilder1.toString());
      }
    }
    try
    {
      synchronized (this.h)
      {
        this.h.clear();
        this.f.clear();
        this.i.removeCallbacksAndMessages(null);
        this.j.removeCallbacksAndMessages(null);
        this.e.evictAll();
        this.d.evictAll();
        return;
      }
      StringBuilder localStringBuilder2;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("destroy:");
        localStringBuilder2.append(localException.toString());
        QLog.e("NonMainAppHeadLoader", 2, localStringBuilder2.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.NonMainProcAvatarLoader
 * JD-Core Version:    0.7.0.1
 */