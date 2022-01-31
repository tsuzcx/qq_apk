package com.tencent.av.gaudio;

import aagk;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import awqx;
import badq;
import baen;
import baep;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import ksn;
import kvq;
import ldl;
import lor;

public class GaInviteDialogActivity
  extends GaInviteActivity
{
  View jdField_a_of_type_AndroidViewView = null;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  Button b;
  public int g = 0;
  public int h;
  boolean h;
  
  public GaInviteDialogActivity()
  {
    this.jdField_b_of_type_AndroidWidgetButton = null;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_h_of_type_Int = 0;
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    lor.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_Int == 2)
    {
      String str = String.valueOf(this.jdField_a_of_type_Long);
      if (baep.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(str)))
      {
        aagk.a(this.jdField_b_of_type_JavaLangString, str, new ldl(this));
        return;
      }
      i();
      return;
    }
    i();
  }
  
  private void i()
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
    case 2131306580: 
      baen.a(false);
      super.a(-1036L);
      return;
    }
    baen.a(true);
    if ((this.jdField_a_of_type_ComTencentAvVideoController.e) || (this.jdField_a_of_type_ComTencentAvVideoController.l())) {
      e();
    }
    for (;;)
    {
      awqx.b(null, "CliOper", "", "", "Multi_call", "Multi_call_join", 0, 0, "", "", "", "");
      return;
      long l = AudioHelper.b();
      sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "BtnOnClick[qav_gaudio_join], relationId[" + this.jdField_a_of_type_Kvq.g + "], mAnyChatCloseByFriend[" + this.jdField_a_of_type_ComTencentAvVideoController.f + "], seq[" + l + "]");
      if (this.jdField_a_of_type_ComTencentAvVideoController.f)
      {
        paramView = ksn.a().a();
        if (paramView != null) {
          paramView.b(l);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.h(true);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(308), Long.valueOf(this.jdField_a_of_type_Kvq.g) });
      h();
    }
  }
  
  void b(Intent paramIntent)
  {
    paramIntent.putExtra("ConfAppID", this.g);
    paramIntent.putExtra("MeetingConfID", this.jdField_h_of_type_Int);
  }
  
  protected void c()
  {
    if ((!badq.h(super.getApplicationContext())) && ((badq.c(super.getApplicationContext())) || (badq.b(super.getApplicationContext())))) {
      this.jdField_h_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131306584));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131306565));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131306578));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131306580));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131306587));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839053);
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131299560);
    if (!this.jdField_h_of_type_Boolean) {
      ((TextView)super.findViewById(2131306590)).setVisibility(0);
    }
    super.c();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onCreate");
    }
    super.setTheme(2131689698);
    super.setContentView(2131493943);
    super.onCreate(paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    a(false);
  }
  
  public void onResume()
  {
    super.onResume();
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteDialogActivity
 * JD-Core Version:    0.7.0.1
 */