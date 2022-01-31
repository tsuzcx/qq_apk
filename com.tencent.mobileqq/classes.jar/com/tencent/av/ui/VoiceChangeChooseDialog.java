package com.tencent.av.ui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kcn;
import kco;
import kcp;
import kcq;

public class VoiceChangeChooseDialog
  extends Dialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new kco(this);
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  View jdField_a_of_type_AndroidViewView = null;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new kcq(this);
  Button jdField_a_of_type_AndroidWidgetButton = null;
  GridView jdField_a_of_type_AndroidWidgetGridView = null;
  public TextView a;
  public VideoController a;
  VoiceChangeAdapter.ICallback jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter$ICallback = new kcp(this);
  VoiceChangeAdapter jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter = null;
  public Runnable a;
  public boolean a;
  View jdField_b_of_type_AndroidViewView = null;
  Button jdField_b_of_type_AndroidWidgetButton = null;
  boolean jdField_b_of_type_Boolean = false;
  View jdField_c_of_type_AndroidViewView = null;
  boolean jdField_c_of_type_Boolean = false;
  
  public VoiceChangeChooseDialog(Context paramContext, VideoController paramVideoController)
  {
    super(paramContext, 2131624574);
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRunnable = new kcn(this);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      getWindow().addFlags(67108864);
    }
    super.getWindow().addFlags(524288);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    super.setContentView(2130969374);
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131366320));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131366317);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366318);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131366321);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366319));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131366322));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131366282));
    this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
    this.jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter = new VoiceChangeAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvVideoController.a().S, this.jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter$ICallback);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().S == 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131429603);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      a();
      c();
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131429604);
    }
  }
  
  private void b()
  {
    int i = 2130840361;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().aC) {
      i = 2130840362;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Boolean = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio")).isWiredHeadsetOn();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    try
    {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VoiceChangeChooseDialog", 2, "registerForVideoBroadcasts e = " + localException);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      AVLog.e("VoiceChangeChooseDialog", "updateDialogStyle mVideoController is null!!");
      return;
    }
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4))
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if (!this.jdField_b_of_type_Boolean) {
        break label121;
      }
      this.jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter.a(-1);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(16777216);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-534962398);
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetButton.setTextColor(-1);
    }
    for (;;)
    {
      b();
      return;
      bool = false;
      break;
      label121:
      this.jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter.a(-16777216);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-2147483648);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(-2170912);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8947849);
      this.jdField_b_of_type_AndroidWidgetButton.setTextColor(-16777216);
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    switch (paramView.getId())
    {
    default: 
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = true;
        paramView = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2131034229);
        paramView.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_a_of_type_AndroidViewView.startAnimation(paramView);
      }
    case 2131366318: 
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().aC)
    {
      paramView.aC = bool;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().S != 0)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().aC);
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().aC) {
          break label190;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131429604);
      }
    }
    for (;;)
    {
      b();
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().aC) {
        break label219;
      }
      EffectToolbar.showCloseEarbackToast(this.jdField_a_of_type_AndroidContentContext);
      VoiceChangeDataReport.a("0X8007EF4", "");
      return;
      bool = false;
      break;
      label190:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131429606);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Int = 0;
    }
    label219:
    VoiceChangeDataReport.a("0X8007EF3", "");
  }
  
  public void show()
  {
    super.show();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.startAnimation(AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2131034230));
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().S == 0) {
      this.jdField_a_of_type_ComTencentAvUiVoiceChangeAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeChooseDialog
 * JD-Core Version:    0.7.0.1
 */