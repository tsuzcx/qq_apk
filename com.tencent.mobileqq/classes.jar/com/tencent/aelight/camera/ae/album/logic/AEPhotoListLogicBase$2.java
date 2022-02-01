package com.tencent.aelight.camera.ae.album.logic;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoGridAdapter;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.PhotoVH;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import java.util.ArrayList;
import mqq.util.WeakReference;

class AEPhotoListLogicBase$2
  implements View.OnTouchListener
{
  AEPhotoListLogicBase$2(AEPhotoListLogicBase paramAEPhotoListLogicBase, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoVH.a.isChecked())
    {
      paramView = (LocalMediaInfo)AEPhotoListLogicBase.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase).get(this.jdField_a_of_type_Int);
      AEPhotoListLogicBase.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase, this.jdField_a_of_type_Int, paramView, this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoVH);
      AEPhotoListLogicBase.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase, this.jdField_a_of_type_ComTencentAelightCameraAeAlbumFragmentAEAbstractPhotoListFragment$PhotoVH);
      AEPhotoListLogicBase.a(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase);
      if (AEPhotoListLogicBase.b(this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase).isEmpty()) {
        ((AEAbstractPhotoListFragment)this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEPhotoListLogicBase.a.get()).a.notifyDataSetChanged();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicBase.2
 * JD-Core Version:    0.7.0.1
 */