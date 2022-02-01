package com.tencent.av.ui;

import android.content.res.Resources;
import android.widget.Button;
import com.tencent.av.QavChannelProxy;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class MultiVideoEnterPageActivity$MyVideoObserver
  extends VideoObserver
{
  MultiVideoEnterPageActivity$MyVideoObserver(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null))
    {
      QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onKickOutResult, empty");
      return;
    }
    if (paramLong != this.a.jdField_a_of_type_Long)
    {
      QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onKickOutResult, ignore");
      return;
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin(), paramLong, this.a.b);
      this.a.b(paramInt2);
      return;
    }
    if (paramInt3 == -5)
    {
      if (this.a.jdField_a_of_type_Boolean) {
        if ((this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null) && (this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length > 1) && (this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1] != null)) {
          this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].b.setVisibility(8);
        }
      }
      for (;;)
      {
        QQToast.a(this.a, 2131693144, 1).b(MultiVideoEnterPageActivity.b(this.a).getDimensionPixelSize(2131299166));
        return;
        this.a.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity$MainUI.b.setVisibility(8);
      }
    }
    QQToast.a(this.a, 2131693143, 1).b(MultiVideoEnterPageActivity.c(this.a).getDimensionPixelSize(2131299166));
  }
  
  public void c(long paramLong)
  {
    super.c(paramLong);
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "TYPE_NOTIFY_FINFISH_MULTI_VIDEO_ENTER_PAGE_ACTIVITY disscussUin:" + paramLong + ", mRelationId = " + this.a.jdField_a_of_type_Long);
    }
    if ((paramLong != 0L) && (paramLong == this.a.jdField_a_of_type_Long))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "TYPE_NOTIFY_FINFISH_MULTI_VIDEO_ENTER_PAGE_ACTIVITY disscussUin matched");
      }
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.MyVideoObserver
 * JD-Core Version:    0.7.0.1
 */