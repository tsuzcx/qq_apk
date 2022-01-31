package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.app.PeakAppInterface;
import java.util.HashSet;

public class PeakFragmentActivity
  extends FragmentActivity
{
  public static final HashSet a;
  protected AppInterface a;
  @Deprecated
  protected PeakAppInterface a;
  protected boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public PeakFragmentActivity()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.getIntent().putExtra("fling_action_key", 0);
    if (AIOGalleryUtils.a != null) {
      AIOGalleryUtils.a.removeMessages(1);
    }
    String str = getClass().getName() + "@" + hashCode();
    jdField_a_of_type_JavaUtilHashSet.add(str);
    super.doOnCreate(paramBundle);
    if ((getAppRuntime() instanceof PeakAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface = ((PeakAppInterface)getAppRuntime());
    }
    if ((getAppRuntime() instanceof AppInterface)) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getAppRuntime());
    }
    setVolumeControlStream(3);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    String str = getClass().getName() + "@" + hashCode();
    jdField_a_of_type_JavaUtilHashSet.remove(str);
    if ((jdField_a_of_type_JavaUtilHashSet.size() == 0) && (AIOGalleryUtils.a != null)) {
      AIOGalleryUtils.a.removeMessages(1);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Boolean)
    {
      NativeVideoImage.pauseAll();
      AbstractGifImage.pauseAll();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    NativeVideoImage.resumeAll();
    AbstractGifImage.resumeAll();
  }
  
  protected String getModuleId()
  {
    return "peak";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity
 * JD-Core Version:    0.7.0.1
 */