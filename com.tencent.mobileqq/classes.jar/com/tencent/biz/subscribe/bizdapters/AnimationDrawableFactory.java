package com.tencent.biz.subscribe.bizdapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AnimationDrawableFactory
{
  private static volatile AnimationDrawableFactory jdField_a_of_type_ComTencentBizSubscribeBizdaptersAnimationDrawableFactory;
  private MQLruCache<String, AnimationDrawable> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(10);
  
  private Bitmap a(File paramFile)
  {
    QLog.i("AnimationDrawableFactory", 2, "getBitMapFromFile fileName:" + paramFile.getName());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFile.exists())
    {
      localObject1 = localObject2;
      if (paramFile.isFile()) {
        localObject1 = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
      }
    }
    return localObject1;
  }
  
  public static AnimationDrawableFactory a()
  {
    if (jdField_a_of_type_ComTencentBizSubscribeBizdaptersAnimationDrawableFactory == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizSubscribeBizdaptersAnimationDrawableFactory == null) {
        jdField_a_of_type_ComTencentBizSubscribeBizdaptersAnimationDrawableFactory = new AnimationDrawableFactory();
      }
      return jdField_a_of_type_ComTencentBizSubscribeBizdaptersAnimationDrawableFactory;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) && (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString) != null)) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
    }
  }
  
  @Deprecated
  public void a(String paramString, int paramInt, AnimationDrawableFactory.CreateDrawableResultListener paramCreateDrawableResultListener, boolean paramBoolean)
  {
    QLog.i("AnimationDrawableFactory", 2, "createFromDirectory dirPath=" + paramString + " allDuration=" + paramInt + " useCache=" + paramBoolean);
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AnimationDrawableFactory", 2, "createFromDirectory error dirPath is invalid");
      if (paramCreateDrawableResultListener != null) {
        paramCreateDrawableResultListener.a(false, null);
      }
    }
    RFThreadManager.execute(new AnimationDrawableFactory.1(this, paramBoolean, paramString, paramInt, paramCreateDrawableResultListener), RFThreadManager.Normal);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.AnimationDrawableFactory
 * JD-Core Version:    0.7.0.1
 */