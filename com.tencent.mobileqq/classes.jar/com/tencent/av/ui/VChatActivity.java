package com.tencent.av.ui;

import Override;
import SharpSvrPack.SharpVideoMsg;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import lbu;
import lcs;
import lct;
import lez;
import lhu;
import lhw;
import mqq.app.AccountNotMatchException;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqq.app.Packet;
import mta;

public class VChatActivity
  extends BaseActivity
{
  public VideoController a;
  public VideoAppInterface a;
  private boolean a;
  
  private void a(FromServiceMsg paramFromServiceMsg, String paramString)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getWupBuffer() != null) && ("SharpSvr.s2c".equalsIgnoreCase(paramString))) {}
    try
    {
      SharpVideoMsg localSharpVideoMsg = (SharpVideoMsg)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "SharpVideoMsg", new SharpVideoMsg());
      lct locallct;
      String str1;
      String str2;
      int i;
      if (localSharpVideoMsg != null)
      {
        locallct = lcs.a(localSharpVideoMsg.video_buff);
        if ((locallct != null) && (locallct.a()))
        {
          lhw.a(34);
          str1 = String.valueOf(locallct.c);
          str2 = lbu.a(3, str1, new int[0]);
          lez locallez = lbu.a().c(str2);
          QLog.d("VChatActivity", 1, "onCreate--onRequestVideo,  VideoPacket[" + locallct + "], session[" + locallez + "]");
          if (locallez == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("tagSharpSvr", 2, "<-- VChatActivity cmd = " + paramString + " , msg_type = " + localSharpVideoMsg.msg_type + ", bodyType = " + locallct.jdField_a_of_type_Int);
            }
            mta.a("VChatActivity", str2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, locallct);
            paramFromServiceMsg = paramFromServiceMsg.getAttribute("__timestamp_net2msf");
            if (paramFromServiceMsg != null)
            {
              long l = ((Long)paramFromServiceMsg).longValue();
              this.jdField_a_of_type_ComTencentAvVideoController.a(str1, l);
            }
            i = locallct.e;
            paramFromServiceMsg = mta.a(locallct);
            if (locallct.d != 1) {
              break label320;
            }
          }
        }
      }
      label320:
      for (boolean bool = true;; bool = false)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(i, str1, paramFromServiceMsg, null, bool, null, 0, locallct.b);
        paramFromServiceMsg = lbu.a().c(str2);
        if (paramFromServiceMsg != null) {
          paramFromServiceMsg.d(locallct.jdField_a_of_type_Long);
        }
        return;
      }
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      MobileQQ.sMobileQQ.getAppRuntime(paramString);
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      do
      {
        QLog.d("VChatActivity", 1, "AV_UIN_NOT_MATCH, MSFUIN: " + paramString + " AVUIN:" + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        HashMap localHashMap = new HashMap();
        localHashMap.put("avuin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        localHashMap.put("msfuin", String.valueOf(paramString));
        StatisticCollector.getInstance(super.getApplicationContext()).collectPerformance(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "AV_UIN_NOT_MATCH", false, 0L, 0L, localHashMap, "", true);
      } while (paramString.equals("0"));
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramString);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    QLog.w("VChatActivity", 1, "exitVideoProcess, reason[" + paramInt + "], seq[" + paramLong + "]");
    super.finish();
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramLong, paramInt);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
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
    super.onCreate(paramBundle);
    QLog.d("VChatActivity", 1, "onCreate()");
    if ((super.getAppRuntime() instanceof VideoAppInterface)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      QLog.d("VChatActivity", 1, "onCreate mApp is null! ");
      super.finish();
    }
    String str;
    FromServiceMsg localFromServiceMsg;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(false);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      paramBundle = super.getIntent();
      str = paramBundle.getStringExtra("uin");
      localFromServiceMsg = (FromServiceMsg)paramBundle.getParcelableExtra("fromServiceMsg");
      paramBundle = null;
      if (localFromServiceMsg != null) {
        paramBundle = localFromServiceMsg.getServiceCmd();
      }
      QLog.d("VChatActivity", 1, "onCreate fromServiceMsg =  " + localFromServiceMsg + ",cmd = " + paramBundle);
    } while (str == null);
    a(str);
    a(localFromServiceMsg, paramBundle);
    super.finish();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.d("VChatActivity", 1, "onDestroy()");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    super.finish();
    long l = AudioHelper.b();
    QLog.w("VChatActivity", 1, "exit when KEYCODE_BACK, seq[" + l + "]");
    a(l, 1009);
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    QLog.d("VChatActivity", 1, "onNewIntent()");
    lhu.a();
  }
  
  public void onPause()
  {
    super.onPause();
    QLog.d("VChatActivity", 1, "onPause()");
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.d("VChatActivity", 1, "onResume()  mIsEffectiveRequest = " + this.jdField_a_of_type_Boolean);
    if (!this.jdField_a_of_type_Boolean) {
      super.finish();
    }
  }
  
  public void onStop()
  {
    QLog.d("VChatActivity", 1, "onStop()");
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VChatActivity
 * JD-Core Version:    0.7.0.1
 */