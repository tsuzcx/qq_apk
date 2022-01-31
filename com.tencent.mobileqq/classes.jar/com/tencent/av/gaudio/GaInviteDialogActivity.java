package com.tencent.av.gaudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils.ConfIdownloadTask;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.qphone.base.util.QLog;
import jkn;

public class GaInviteDialogActivity
  extends GaInviteActivity
{
  View jdField_a_of_type_AndroidViewView = null;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  Button b;
  boolean d = true;
  int i = 0;
  int j = 0;
  public int k = 0;
  public int l = 0;
  
  public GaInviteDialogActivity()
  {
    this.jdField_b_of_type_AndroidWidgetButton = null;
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_Int == 2)
    {
      String str = String.valueOf(this.jdField_a_of_type_Long);
      if (QAVHrMeeting.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(str)))
      {
        ChatActivityUtils.ConfIdownloadTask.a(this.jdField_b_of_type_JavaLangString, str, new jkn(this));
        return;
      }
      h();
      return;
    }
    h();
  }
  
  private void h()
  {
    if (isFinishing()) {
      return;
    }
    d();
  }
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131365971: 
      QAVGroupConfig.Report.a(false);
      super.e();
      return;
    }
    QAVGroupConfig.Report.a(true);
    if ((this.jdField_a_of_type_ComTencentAvVideoController.e) || (this.jdField_a_of_type_ComTencentAvVideoController.l())) {
      f();
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Multi_call_join", 0, 0, "", "", "", "");
      return;
      sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "BtnOnClick[qav_gaudio_join], relationId[" + this.jdField_a_of_type_ComTencentAvAppSessionInfo.f + "], mAnyChatCloseByFriend[" + this.jdField_a_of_type_ComTencentAvVideoController.f + "]");
      if (this.jdField_a_of_type_ComTencentAvVideoController.f)
      {
        paramView = SessionMgr.a().a();
        if (paramView != null) {
          paramView.b();
        }
        this.jdField_a_of_type_ComTencentAvVideoController.h(true);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(308), Long.valueOf(this.jdField_a_of_type_ComTencentAvAppSessionInfo.f) });
      g();
    }
  }
  
  void b(Intent paramIntent)
  {
    paramIntent.putExtra("ConfAppID", this.k);
    paramIntent.putExtra("MeetingConfID", this.l);
  }
  
  protected void c()
  {
    if ((!NetworkUtil.h(super.getApplicationContext())) && ((NetworkUtil.c(super.getApplicationContext())) || (NetworkUtil.b(super.getApplicationContext())))) {
      this.d = false;
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365968));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365967));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365966));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131365971));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131365972));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838549);
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131364060);
    if (!this.d) {
      ((TextView)super.findViewById(2131365970)).setVisibility(0);
    }
    super.c();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onCreate");
    }
    super.setTheme(2131624599);
    super.setContentView(2130969284);
    super.onCreate(paramBundle);
  }
  
  protected void onPause()
  {
    super.onPause();
    a(false);
  }
  
  protected void onResume()
  {
    super.onResume();
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteDialogActivity
 * JD-Core Version:    0.7.0.1
 */