package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.qphone.base.util.QLog;

class MultiVideoEnterPageActivity$1
  implements MultiVideoMembersClickListener
{
  MultiVideoEnterPageActivity$1(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  private void b()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().ad) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().ae)) {}
    for (boolean bool = true;; bool = false)
    {
      VideoMsgTools.a(this.a, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().g), bool, false);
      return;
    }
  }
  
  public void a() {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "MultiVideoMembersClickListener , Uin = " + paramLong + " , videoScr = " + paramInt1 + " , isNeedRequest " + paramBoolean + " , positon = " + paramInt2);
    }
    if ((paramInt2 == 7) && (paramBoolean)) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.1
 * JD-Core Version:    0.7.0.1
 */