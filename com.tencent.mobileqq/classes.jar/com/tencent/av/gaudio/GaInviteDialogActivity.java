package com.tencent.av.gaudio;

import Override;
import aebx;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import bdll;
import bhnv;
import bhoo;
import bhoq;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import lcb;
import lff;
import lnl;
import lzq;

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
    lzq.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_Int == 2)
    {
      String str = String.valueOf(this.jdField_a_of_type_Long);
      if (bhoq.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(str)))
      {
        aebx.a(this.jdField_b_of_type_JavaLangString, str, new lnl(this));
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
    case 2131373401: 
      bhoo.a(false);
      super.a(-1036L);
      return;
    }
    bhoo.a(true);
    if ((this.jdField_a_of_type_ComTencentAvVideoController.e) || (this.jdField_a_of_type_ComTencentAvVideoController.l())) {
      e();
    }
    for (;;)
    {
      bdll.b(null, "CliOper", "", "", "Multi_call", "Multi_call_join", 0, 0, "", "", "", "");
      return;
      long l = AudioHelper.b();
      sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
      sendBroadcast(new Intent("tencent.video.v2g.exitAVGame"));
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "BtnOnClick[qav_gaudio_join], relationId[" + this.jdField_a_of_type_Lff.g + "], mAnyChatCloseByFriend[" + this.jdField_a_of_type_ComTencentAvVideoController.f + "], seq[" + l + "]");
      if (this.jdField_a_of_type_ComTencentAvVideoController.f)
      {
        paramView = lcb.a().a();
        if (paramView != null) {
          paramView.b(l);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.g(true);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(308), Long.valueOf(this.jdField_a_of_type_Lff.g) });
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
    if ((!bhnv.h(super.getApplicationContext())) && ((bhnv.c(super.getApplicationContext())) || (bhnv.b(super.getApplicationContext())))) {
      this.jdField_h_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131373405));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131373386));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131373399));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131373401));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131373408));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839346);
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131365500);
    if (!this.jdField_h_of_type_Boolean) {
      ((TextView)super.findViewById(2131373411)).setVisibility(0);
    }
    super.c();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onCreate");
    }
    super.setTheme(2131755245);
    super.setContentView(2131559705);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteDialogActivity
 * JD-Core Version:    0.7.0.1
 */