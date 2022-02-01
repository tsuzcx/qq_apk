package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoConstants;
import com.tencent.av.utils.ScoreManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ScoreReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ScoreQAVFragment$3
  implements View.OnClickListener
{
  ScoreQAVFragment$3(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    long l1;
    if ((this.a.jdField_b_of_type_JavaLangString != null) && (!this.a.jdField_b_of_type_JavaLangString.isEmpty())) {
      l1 = ScoreManager.a(this.a.jdField_b_of_type_JavaLangString);
    } else {
      l1 = 0L;
    }
    SharedPreferences localSharedPreferences = SharedPreUtils.e(this.a.jdField_d_of_type_JavaLangString);
    long l2 = localSharedPreferences.getLong("qav_roomid", 0L);
    long l3 = localSharedPreferences.getLong(VideoConstants.g, 0L);
    ScoreReportController.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_Long, this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_d_of_type_Long, this.a.e, this.a.jdField_a_of_type_Int, l3, l1, l2, this.a.jdField_c_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportEvent beginTime: ");
      localStringBuilder.append(this.a.jdField_a_of_type_Long);
      localStringBuilder.append(", endTime: ");
      localStringBuilder.append(this.a.jdField_b_of_type_Long);
      localStringBuilder.append(", sdkVersion: ");
      localStringBuilder.append(this.a.jdField_a_of_type_Int);
      localStringBuilder.append(", peerSdkVersion: ");
      localStringBuilder.append(l3);
      localStringBuilder.append(", bussinessType: ");
      localStringBuilder.append(this.a.jdField_c_of_type_Long);
      localStringBuilder.append(", bussinessFlag: ");
      localStringBuilder.append(this.a.jdField_d_of_type_Long);
      localStringBuilder.append(", ip: ");
      localStringBuilder.append(this.a.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(", toUin: ");
      localStringBuilder.append(this.a.jdField_c_of_type_JavaLangString);
      localStringBuilder.append(", score: ");
      localStringBuilder.append(this.a.e);
      localStringBuilder.append(", problems: ");
      localStringBuilder.append(this.a.jdField_a_of_type_JavaLangString);
      QLog.d("ScoreActivity", 2, localStringBuilder.toString());
    }
    localSharedPreferences.edit().putBoolean(VideoConstants.l, true).commit();
    if (this.a.f != 0L) {
      try
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.a.jdField_c_of_type_JavaLangString, this.a.jdField_b_of_type_Int, this.a.f);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeMsgByUniseq : ");
          localStringBuilder.append(localException);
          QLog.w("ScoreActivity", 2, localStringBuilder.toString());
        }
      }
    }
    this.a.getBaseActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ScoreQAVFragment.3
 * JD-Core Version:    0.7.0.1
 */