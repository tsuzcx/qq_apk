package com.tencent.aelight.camera.ae.biz.circle;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.aelight.camera.aebase.QIMCameraLifeCycleBaseUnit;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;

public class AECirclePhotoUnit
  extends QIMCameraLifeCycleBaseUnit
{
  private AECirclePhotoListFragment jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListFragment;
  private ICameraEntrance jdField_a_of_type_ComTencentAelightCameraAioeditorSettingICameraEntrance;
  private IQIMCameraContainer jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer;
  
  public AECirclePhotoUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer = paramIQIMCameraContainer;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingICameraEntrance = paramICameraEntrance;
  }
  
  public void I()
  {
    super.I();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().getLayoutInflater().inflate(2064318611, null);
  }
  
  public void a()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().getIntent();
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListFragment = new AECirclePhotoListFragment();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().getFragmentManager().beginTransaction().add(2064122201, this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListFragment).commit();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  public boolean a()
  {
    AECirclePhotoListFragment localAECirclePhotoListFragment = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListFragment;
    if (localAECirclePhotoListFragment != null) {
      return localAECirclePhotoListFragment.b();
    }
    return true;
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().finish();
  }
  
  public boolean i()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer == null) {
      return false;
    }
    AECirclePhotoListFragment localAECirclePhotoListFragment = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListFragment;
    if ((localAECirclePhotoListFragment != null) && (localAECirclePhotoListFragment.a())) {
      return true;
    }
    localAECirclePhotoListFragment = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListFragment;
    if ((localAECirclePhotoListFragment != null) && (localAECirclePhotoListFragment.a != null)) {
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListFragment.a.a(null);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoUnit
 * JD-Core Version:    0.7.0.1
 */