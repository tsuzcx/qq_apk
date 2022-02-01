package com.tencent.av.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AudioHelper;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().c));
    ((StringBuilder)localObject).append("");
    MagicDataReport.e(((StringBuilder)localObject).toString());
    if (AudioHelper.b())
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiAVActivity.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qav_double_screen_notify, click[");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      new ControlUIObserver.RequestPlayMagicFace(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, false, 4).a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.19
 * JD-Core Version:    0.7.0.1
 */