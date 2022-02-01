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
  private IQIMCameraContainer a;
  private ICameraEntrance b;
  private AECirclePhotoListFragment c;
  
  public AECirclePhotoUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    this.a = paramIQIMCameraContainer;
    this.b = paramICameraEntrance;
  }
  
  public void a()
  {
    Intent localIntent = this.a.getActivity().getIntent();
    if (localIntent.getBooleanExtra("BUNDLE_KEY_FS_CAN_ONLY_EDIT_VIDEO", false)) {
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 35);
    } else {
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
    }
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    this.c = new AECirclePhotoListFragment();
    this.a.getActivity().getFragmentManager().beginTransaction().add(2063991080, this.c).commit();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    AECirclePhotoListFragment localAECirclePhotoListFragment = this.c;
    if (localAECirclePhotoListFragment != null) {
      localAECirclePhotoListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  public void ai()
  {
    super.ai();
  }
  
  public boolean ak()
  {
    if (this.a == null) {
      return false;
    }
    AECirclePhotoListFragment localAECirclePhotoListFragment = this.c;
    if ((localAECirclePhotoListFragment != null) && (localAECirclePhotoListFragment.f())) {
      return true;
    }
    localAECirclePhotoListFragment = this.c;
    if ((localAECirclePhotoListFragment != null) && (localAECirclePhotoListFragment.a != null)) {
      this.c.a.a(null);
    }
    return true;
  }
  
  public boolean b()
  {
    AECirclePhotoListFragment localAECirclePhotoListFragment = this.c;
    if (localAECirclePhotoListFragment != null) {
      return localAECirclePhotoListFragment.g();
    }
    return true;
  }
  
  public View j()
  {
    return this.a.getActivity().getLayoutInflater().inflate(2064056490, null);
  }
  
  public void m()
  {
    super.m();
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoUnit
 * JD-Core Version:    0.7.0.1
 */