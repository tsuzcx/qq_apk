package com.tencent.av.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.tips.TipsUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AVActivity$19
  implements View.OnClickListener
{
  AVActivity$19(AVActivity paramAVActivity, String paramString, long paramLong) {}
  
  public void onClick(View paramView)
  {
    TipsUtil.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1044);
    this.jdField_a_of_type_ComTencentAvUiAVActivity.a(2, false);
    MagicDataReport.e(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().d) + "");
    if (AudioHelper.e()) {
      QLog.w(this.jdField_a_of_type_ComTencentAvUiAVActivity.b, 1, "qav_double_screen_notify, click[" + this.jdField_a_of_type_JavaLangString + "], seq[" + this.jdField_a_of_type_Long + "]");
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      new ControlUIObserver.RequestPlayMagicFace(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, false, 4).a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.19
 * JD-Core Version:    0.7.0.1
 */