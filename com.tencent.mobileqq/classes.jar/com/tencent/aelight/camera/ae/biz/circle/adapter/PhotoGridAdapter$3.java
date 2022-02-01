package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class PhotoGridAdapter$3
  implements View.OnClickListener
{
  PhotoGridAdapter$3(PhotoGridAdapter paramPhotoGridAdapter, LocalMediaInfo paramLocalMediaInfo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo))
    {
      QQToast.a(paramView.getContext(), HardCodeUtil.a(2064515223), 0).a();
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPhotoGridAdapter;
    PhotoGridAdapter.a(paramView, paramView.a, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoGridAdapter.3
 * JD-Core Version:    0.7.0.1
 */