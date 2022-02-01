package com.tencent.mobileqq.activity.aio.item;

import android.widget.RelativeLayout;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.multimsg.save.FileSaveReq;
import com.tencent.mobileqq.multimsg.save.FileSaveResult;
import com.tencent.mobileqq.multimsg.save.FileSaveToastUtils;
import com.tencent.mobileqq.multimsg.save.ISingleFileSaveCallBack;
import com.tencent.qphone.base.util.QLog;

class BasePicItemBuilder$1
  implements ISingleFileSaveCallBack
{
  BasePicItemBuilder$1(BasePicItemBuilder paramBasePicItemBuilder, BasePicItemBuilder.Holder paramHolder, String paramString) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
  }
  
  public void a(FileSaveResult paramFileSaveResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "dealFileSaveUI onSaveComplete");
    }
    if (paramFileSaveResult != null)
    {
      if (paramFileSaveResult.jdField_a_of_type_Int == 0) {
        FileSaveToastUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder.a);
      } else {
        FileSaveToastUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder.a);
      }
      paramFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.b(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.b(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProcessor(null);
      ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
    }
  }
  
  public void a(FileSaveResult paramFileSaveResult, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemBasePicItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.invalidate();
    }
  }
  
  public void b(FileSaveResult paramFileSaveResult) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.BasePicItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */