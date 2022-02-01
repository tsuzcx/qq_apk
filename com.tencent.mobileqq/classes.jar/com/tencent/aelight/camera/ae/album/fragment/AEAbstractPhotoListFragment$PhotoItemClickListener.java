package com.tencent.aelight.camera.ae.album.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogic;
import com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogic.IcheckBoxCallback;

public class AEAbstractPhotoListFragment$PhotoItemClickListener
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  
  public AEAbstractPhotoListFragment$PhotoItemClickListener(AEAbstractPhotoListFragment paramAEAbstractPhotoListFragment) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(CheckBox paramCheckBox)
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox = paramCheckBox;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.a.a != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment.a.a.a(paramView, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidWidgetCheckBox);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoItemClickListener
 * JD-Core Version:    0.7.0.1
 */