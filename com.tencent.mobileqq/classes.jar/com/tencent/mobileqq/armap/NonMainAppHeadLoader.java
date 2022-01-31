package com.tencent.mobileqq.armap;

import aavw;
import aavx;
import aavy;
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
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class NonMainAppHeadLoader
{
  protected float a;
  public int a;
  private BroadcastReceiver a;
  protected Context a;
  public Bitmap a;
  public Handler a;
  public LruCache a;
  public ArrayList a;
  public HashSet a;
  public List a;
  public Handler b;
  public LruCache b;
  
  public NonMainAppHeadLoader(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(60);
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(120);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aavw(this);
    this.jdField_a_of_type_AndroidOsHandler = new aavx(this, Looper.getMainLooper());
    this.jdField_b_of_type_AndroidOsHandler = new aavy(this, ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    float f2 = this.jdField_a_of_type_Float;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      f1 = f2;
      if (i < 50 * f2) {
        f1 = i / 50;
      }
    }
    i = (int)(50 * f1);
    int j = (int)(f1 * 50);
    return ImageUtil.a(paramBitmap, i, i, j);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean, Bitmap paramBitmap)
  {
    try
    {
      localObject = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
      if (localObject != null)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("NonMainAppHeadLoader", 2, "getFaceBitmap, hit cache:" + paramString);
          return localObject;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("NonMainAppHeadLoader", 2, "getFaceBitmap, not in cache:" + paramString);
        }
        if (!TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString)))
        {
          localObject = new ArrayList(1);
          Message localMessage = Message.obtain();
          ((ArrayList)localObject).add(paramString);
          localMessage.obj = localObject;
          localMessage.what = 1001;
          this.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
        }
        else if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 350L);
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        QLog.e("NonMainAppHeadLoader", 2, "getFaceBitmap, exception:" + paramString.toString());
        return paramBitmap;
        return localObject;
      }
    }
    return paramBitmap;
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
    catch (Exception localException)
    {
      QLog.d("NonMainAppHeadLoader", 1, "init register receiver fail!");
    }
  }
  
  public void a(NonMainAppHeadLoader.FaceObserver paramFaceObserver)
  {
    if (paramFaceObserver == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramFaceObserver);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NonMainAppHeadLoader", 2, "sendQQHeadRequest, reqSize:" + this.jdField_a_of_type_JavaUtilHashSet.size() + " cacheSize:" + this.jdField_a_of_type_AndroidSupportV4UtilLruCache.size() + " " + this.jdField_b_of_type_AndroidSupportV4UtilLruCache.size());
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(str)) {
        localArrayList.add(str);
      }
    }
    paramArrayList = new Intent("com.tencent.qqhead.getheadreq");
    paramArrayList.setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
    paramArrayList.putExtra("faceType", this.jdField_a_of_type_Int);
    paramArrayList.putStringArrayListExtra("uinList", localArrayList);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramArrayList, "com.tencent.qqhead.permission.getheadresp");
    this.jdField_a_of_type_JavaUtilHashSet.addAll(localArrayList);
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
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilHashSet.clear();
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_b_of_type_AndroidSupportV4UtilLruCache.evictAll();
          this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.e("NonMainAppHeadLoader", 2, "destroy:" + localException1.toString());
          }
        }
      }
      catch (Exception localException2)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("NonMainAppHeadLoader", 2, "destroy:" + localException2.toString());
      }
    }
  }
  
  public void b(NonMainAppHeadLoader.FaceObserver paramFaceObserver)
  {
    if (paramFaceObserver == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramFaceObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.NonMainAppHeadLoader
 * JD-Core Version:    0.7.0.1
 */