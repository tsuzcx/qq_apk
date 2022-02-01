package com.tencent.av.ui;

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
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;

public class AVLoadingDialogActivity
  extends BaseActivity
{
  final String a;
  Handler b;
  BroadcastReceiver c = new AVLoadingDialogActivity.1(this);
  
  public AVLoadingDialogActivity()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AVLoadingDialogActivity_");
    localStringBuilder.append(AudioHelper.c());
    this.a = localStringBuilder.toString();
    this.b = new AVLoadingDialogActivity.MyHandler(this.a);
  }
  
  Dialog a()
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131953338);
    localReportDialog.setContentView(2131625585);
    localReportDialog.setCancelable(false);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131440191);
    if (localTextView != null) {
      localTextView.setText(2131893648);
    }
    return localReportDialog;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH");
    registerReceiver(this.c, paramBundle);
    QLog.d(this.a, 1, "avideo doOnCreate");
    paramBundle = getIntent();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(".doOnCreate");
    localObject = ((StringBuilder)localObject).toString();
    if (paramBundle != null) {
      paramBundle = paramBundle.getExtras();
    } else {
      paramBundle = null;
    }
    AudioHelper.a((String)localObject, paramBundle);
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    QLog.d(this.a, 1, "doOnDestroy");
    this.b.removeMessages(0);
    this.b.removeMessages(1);
    unregisterReceiver(this.c);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    QLog.d(this.a, 1, "doOnResume");
    showDialog(0);
    WeakReference localWeakReference = new WeakReference(this);
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.obj = localWeakReference;
    this.b.sendMessageDelayed(localMessage, 300L);
    localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = localWeakReference;
    this.b.sendMessageDelayed(localMessage, 5000L);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    if (paramInt != 0) {
      return null;
    }
    return a();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVLoadingDialogActivity
 * JD-Core Version:    0.7.0.1
 */