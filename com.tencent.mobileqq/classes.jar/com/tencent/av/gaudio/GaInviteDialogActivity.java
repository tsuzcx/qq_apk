package com.tencent.av.gaudio;

import aapy;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import axqy;
import bbfj;
import bbgg;
import bbgi;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import lcx;
import lga;
import lnx;
import lze;

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
    lze.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_Int == 2)
    {
      String str = String.valueOf(this.jdField_a_of_type_Long);
      if (bbgi.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(str)))
      {
        aapy.a(this.jdField_b_of_type_JavaLangString, str, new lnx(this));
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
    case 2131372281: 
      bbgg.a(false);
      super.a(-1036L);
      return;
    }
    bbgg.a(true);
    if ((this.jdField_a_of_type_ComTencentAvVideoController.e) || (this.jdField_a_of_type_ComTencentAvVideoController.l())) {
      e();
    }
    for (;;)
    {
      axqy.b(null, "CliOper", "", "", "Multi_call", "Multi_call_join", 0, 0, "", "", "", "");
      return;
      long l = AudioHelper.b();
      sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "BtnOnClick[qav_gaudio_join], relationId[" + this.jdField_a_of_type_Lga.g + "], mAnyChatCloseByFriend[" + this.jdField_a_of_type_ComTencentAvVideoController.f + "], seq[" + l + "]");
      if (this.jdField_a_of_type_ComTencentAvVideoController.f)
      {
        paramView = lcx.a().a();
        if (paramView != null) {
          paramView.b(l);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.h(true);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(308), Long.valueOf(this.jdField_a_of_type_Lga.g) });
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
    if ((!bbfj.h(super.getApplicationContext())) && ((bbfj.c(super.getApplicationContext())) || (bbfj.b(super.getApplicationContext())))) {
      this.jdField_h_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372285));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372266));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131372279));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131372281));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131372288));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839081);
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131365127);
    if (!this.jdField_h_of_type_Boolean) {
      ((TextView)super.findViewById(2131372291)).setVisibility(0);
    }
    super.c();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onCreate");
    }
    super.setTheme(2131755235);
    super.setContentView(2131559511);
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