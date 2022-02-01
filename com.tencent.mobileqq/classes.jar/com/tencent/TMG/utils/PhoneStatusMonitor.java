package com.tencent.TMG.utils;

import android.content.Context;
import android.content.IntentFilter;
import android.telephony.PhoneStateListener;

public class PhoneStatusMonitor
{
  static final String TAG = "PhoneStatusMonitor";
  Context mContext;
  boolean mIsCalling = false;
  PhoneStateListener mPhoneStateListener;
  PhoneStatusMonitor.PhoneStatusListener mPhoneStatusListener;
  PhoneStatusMonitor.PhoneStatusReceiver mPhoneStatusReceiver;
  
  public PhoneStatusMonitor(Context paramContext, PhoneStatusMonitor.PhoneStatusListener paramPhoneStatusListener)
  {
    this.mContext = paramContext;
    this.mPhoneStatusListener = paramPhoneStatusListener;
    this.mPhoneStateListener = new PhoneStatusMonitor.QQPhoneStateListener(this);
    this.mPhoneStatusReceiver = new PhoneStatusMonitor.PhoneStatusReceiver(this);
    PhoneStatusTools.listen(paramContext, this.mPhoneStateListener, 32);
    paramPhoneStatusListener = new IntentFilter();
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE");
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE2");
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE_2");
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE_EXT");
    paramPhoneStatusListener.addAction("android.intent.action.NEW_OUTGOING_CALL");
    paramContext.registerReceiver(this.mPhoneStatusReceiver, paramPhoneStatusListener);
  }
  
  protected void finalize()
  {
    super.finalize();
  }
  
  public boolean isCalling()
  {
    return this.mIsCalling;
  }
  
  public void uninit()
  {
    PhoneStatusTools.listen(this.mContext, this.mPhoneStateListener, 0);
    this.mContext.unregisterReceiver(this.mPhoneStatusReceiver);
    this.mPhoneStatusListener = null;
    this.mPhoneStatusReceiver = null;
    this.mPhoneStateListener = null;
    this.mContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.utils.PhoneStatusMonitor
 * JD-Core Version:    0.7.0.1
 */