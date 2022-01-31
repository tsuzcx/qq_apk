package com.tencent.av.gaudio;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.QavInOutAnimation;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import jja;
import jjb;
import jjc;

public class GaInviteLockActivity
  extends GaInviteActivity
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  public QavInOutAnimation a;
  public QavPanel a;
  TextView c;
  
  public GaInviteLockActivity()
  {
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
  }
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X800420D", "0X800420D", 0, 0, "", "", "", "");
    g();
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)super.findViewById(2131365908));
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(3);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
    this.jdField_a_of_type_ComTencentAvUiQavPanel.a(new jja(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365934));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365935));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365942));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BitmapTools.a(super.getApplicationContext(), 2130840203);
    View localView = super.findViewById(2131365932);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      localView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365938));
      if ((!NetworkUtil.h(super.getApplicationContext())) && ((NetworkUtil.c(super.getApplicationContext())) || (NetworkUtil.b(super.getApplicationContext()))))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131429060);
      }
      super.c();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = new QavInOutAnimation(this, this.jdField_a_of_type_ComTencentAvVideoController, 1, this.jdField_a_of_type_ComTencentAvUiQavPanel, null, super.findViewById(2131365941), this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_AndroidWidgetTextView, null);
      if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) {
        this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a();
      }
      return;
      localView.setBackgroundResource(2130840203);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new jjb(this));
      return;
    }
    super.e();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onCreate");
    }
    this.jdField_c_of_type_Int = UITools.a(getApplicationContext());
    this.d = UITools.b(getApplicationContext());
    super.setContentView(2130969286);
    super.onCreate(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    paramBundle.addAction("tencent.notify.cancel.videorequest");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new jjc(this);
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(1024);
    if (ImmersiveUtils.a()) {
      ImmersiveUtils.a(getWindow(), true);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavPanel.h();
      this.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null)
    {
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.b();
      this.jdField_a_of_type_ComTencentAvUiQavInOutAnimation = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      ReportController.b(null, "CliOper", "", "", "0X800420F", "0X800420F", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity
 * JD-Core Version:    0.7.0.1
 */