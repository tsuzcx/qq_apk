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
  private byte jdField_a_of_type_Byte = 3;
  protected float a;
  protected int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new NonMainProcAvatarLoader.1(this);
  protected Context a;
  public Bitmap a;
  protected Handler a;
  protected LruCache<String, Bitmap> a;
  protected ArrayList<String> a;
  protected HashSet<String> a;
  final List<FaceObserver> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  protected Handler b;
  protected LruCache<String, String> b;
  
  public NonMainProcAvatarLoader(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(60);
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(120);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new NonMainProcAvatarLoader.2(this, Looper.getMainLooper());
    this.jdField_b_of_type_AndroidOsHandler = new NonMainProcAvatarLoader.3(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = paramInt;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BaseImageUtil.f();
      return;
    }
    catch (OutOfMemoryError paramContext) {}
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  protected Bitmap a(Bitmap paramBitmap)
  {
    float f2 = this.jdField_a_of_type_Float;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      float f3 = i;
      float f4 = 50;
      f1 = f2;
      if (f3 < f2 * f4) {
        f1 = f3 / f4;
      }
    }
    i = (int)(50 * f1);
    return BaseImageUtil.a(paramBitmap, i, i, i);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean, Bitmap paramBitmap)
  {
    Object localObject1;
    try
    {
      localObject1 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
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
      if (!TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString)))
      {
        localObject1 = new ArrayList(1);
        localObject2 = Message.obtain();
        ((ArrayList)localObject1).add(paramString);
        ((Message)localObject2).obj = localObject1;
        ((Message)localObject2).what = 1001;
        this.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
        return paramBitmap;
      }
      if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 50L);
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
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.qqhead.permission.getheadresp", null);
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
    this.jdField_a_of_type_Byte = paramByte;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(FaceObserver paramFaceObserver)
  {
    if (paramFaceObserver == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramFaceObserver)) {
        this.jdField_a_of_type_JavaUtilList.add(paramFaceObserver);
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilHashSet.size());
      ((StringBuilder)localObject).append(" cacheSize:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidSupportV4UtilLruCache.size());
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_AndroidSupportV4UtilLruCache.size());
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
        if (!this.jdField_a_of_type_JavaUtilHashSet.contains(str)) {
          ((ArrayList)localObject).add(str);
        }
      }
      paramArrayList = new Intent("com.tencent.qqhead.getheadreq");
      paramArrayList.setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
      paramArrayList.putExtra("faceType", this.jdField_a_of_type_Int);
      paramArrayList.putStringArrayListExtra("uinList", (ArrayList)localObject);
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramArrayList, "com.tencent.qqhead.permission.getheadresp");
      this.jdField_a_of_type_JavaUtilHashSet.addAll((Collection)localObject);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NonMainAppHeadLoader", 2, "destroy");
    }
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
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
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilHashSet.clear();
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_b_of_type_AndroidSupportV4UtilLruCache.evictAll();
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
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
  
  public void b(FaceObserver paramFaceObserver)
  {
    if (paramFaceObserver == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramFaceObserver);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.NonMainProcAvatarLoader
 * JD-Core Version:    0.7.0.1
 */