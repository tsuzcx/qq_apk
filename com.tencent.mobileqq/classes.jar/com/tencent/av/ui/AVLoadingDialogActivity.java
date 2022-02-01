package com.tencent.av.ui;

import Override;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;
import mca;
import mcb;

public class AVLoadingDialogActivity
  extends BaseActivity
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new mca(this);
  Handler jdField_a_of_type_AndroidOsHandler = new mcb(this.jdField_a_of_type_JavaLangString);
  final String jdField_a_of_type_JavaLangString = "AVLoadingDialogActivity_" + AudioHelper.b();
  
  Dialog a()
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131755824);
    localReportDialog.setContentView(2131559572);
    localReportDialog.setCancelable(false);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131372578);
    if (localTextView != null) {
      localTextView.setText(2131695277);
    }
    return localReportDialog;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "avideo doOnCreate");
    paramBundle = getIntent();
    String str = this.jdField_a_of_type_JavaLangString + ".doOnCreate";
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getExtras();; paramBundle = null)
    {
      AudioHelper.a(str, paramBundle);
      return bool;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doOnDestroy");
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doOnResume");
    showDialog(0);
    WeakReference localWeakReference = new WeakReference(this);
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.obj = localWeakReference;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 300L);
    localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = localWeakReference;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 5000L);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return a();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVLoadingDialogActivity
 * JD-Core Version:    0.7.0.1
 */