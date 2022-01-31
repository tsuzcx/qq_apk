package com.tencent.mobileqq.activity.aio.photo;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.app.PeakAppInterface;
import java.util.HashSet;

public class PeakActivity
  extends BaseActivity2
{
  public static final HashSet a;
  public AppInterface a;
  @Deprecated
  public PeakAppInterface a;
  public boolean c = true;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  protected String getModuleId()
  {
    return "peak";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (AIOGalleryUtils.a != null) {
      AIOGalleryUtils.a.removeMessages(1);
    }
    String str = getClass().getName() + "@" + hashCode();
    jdField_a_of_type_JavaUtilHashSet.add(str);
    super.onCreate(paramBundle);
    if ((getAppRuntime() instanceof PeakAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)getAppRuntime());
    }
    if ((getAppRuntime() instanceof AppInterface)) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getAppRuntime());
    }
    setVolumeControlStream(3);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    String str = getClass().getName() + "@" + hashCode();
    jdField_a_of_type_JavaUtilHashSet.remove(str);
    if ((jdField_a_of_type_JavaUtilHashSet.size() == 0) && (AIOGalleryUtils.a != null)) {
      AIOGalleryUtils.a.removeMessages(1);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.c)
    {
      NativeVideoImage.pauseAll();
      AbstractGifImage.pauseAll();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    NativeVideoImage.resumeAll();
    AbstractGifImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PeakActivity
 * JD-Core Version:    0.7.0.1
 */