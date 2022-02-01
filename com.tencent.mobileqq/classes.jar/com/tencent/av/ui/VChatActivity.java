package com.tencent.av.ui;

import SharpSvrPack.SharpVideoMsg;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoPackageUtils;
import com.tencent.av.VideoPackageUtils.VideoPacket;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.report.VideoBeaconReporter;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.QAVNotificationUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import mqq.app.AccountNotMatchException;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqq.app.Packet;

public class VChatActivity
  extends BaseActivity
{
  public VideoController a;
  public VideoAppInterface a;
  private boolean a;
  
  private void a(FromServiceMsg paramFromServiceMsg, String paramString)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getWupBuffer() != null) && ("SharpSvr.s2c".equalsIgnoreCase(paramString))) {}
    for (;;)
    {
      try
      {
        SharpVideoMsg localSharpVideoMsg = (SharpVideoMsg)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "SharpVideoMsg", new SharpVideoMsg());
        if (localSharpVideoMsg != null)
        {
          VideoPackageUtils.VideoPacket localVideoPacket = VideoPackageUtils.a(localSharpVideoMsg.video_buff);
          if ((localVideoPacket != null) && (localVideoPacket.a()))
          {
            VideoNodeManager.a(34);
            String str1 = String.valueOf(localVideoPacket.c);
            String str2 = SessionMgr.a(3, str1, new int[0]);
            Object localObject = SessionMgr.a().c(str2);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onCreate--onRequestVideo,  VideoPacket[");
            localStringBuilder.append(localVideoPacket);
            localStringBuilder.append("], session[");
            localStringBuilder.append(localObject);
            localStringBuilder.append("]");
            QLog.d("VChatActivity", 1, localStringBuilder.toString());
            if (localObject == null)
            {
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("<-- VChatActivity cmd = ");
                ((StringBuilder)localObject).append(paramString);
                ((StringBuilder)localObject).append(" , msg_type = ");
                ((StringBuilder)localObject).append(localSharpVideoMsg.msg_type);
                ((StringBuilder)localObject).append(", bodyType = ");
                ((StringBuilder)localObject).append(localVideoPacket.jdField_a_of_type_Int);
                QLog.d("tagSharpSvr", 2, ((StringBuilder)localObject).toString());
              }
              QAVNotificationUtil.a("VChatActivity", str2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localVideoPacket);
              paramFromServiceMsg = paramFromServiceMsg.getAttribute("__timestamp_net2msf");
              if (paramFromServiceMsg != null)
              {
                long l = ((Long)paramFromServiceMsg).longValue();
                this.jdField_a_of_type_ComTencentAvVideoController.b(str1, l);
              }
              int i = localVideoPacket.e;
              paramFromServiceMsg = QAVNotificationUtil.a(localVideoPacket);
              if (localVideoPacket.d != 1) {
                break label370;
              }
              bool = true;
              this.jdField_a_of_type_ComTencentAvVideoController.onRequestVideo(i, str1, paramFromServiceMsg, null, bool, null, 0, localVideoPacket.b);
              paramFromServiceMsg = SessionMgr.a().c(str2);
              if (paramFromServiceMsg != null)
              {
                paramFromServiceMsg.c(localVideoPacket.jdField_a_of_type_Long);
                return;
              }
            }
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
      return;
      label370:
      boolean bool = false;
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
      label9:
      Object localObject;
      break label9;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AV_UIN_NOT_MATCH, MSFUIN: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" AVUIN:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    QLog.d("VChatActivity", 1, ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    ((HashMap)localObject).put("avuin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    ((HashMap)localObject).put("msfuin", String.valueOf(paramString));
    StatisticCollector.getInstance(super.getApplicationContext()).collectPerformance(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "AV_UIN_NOT_MATCH", false, 0L, 0L, (HashMap)localObject, "", true);
    if (!paramString.equals("0")) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(paramString);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exitVideoProcess, reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("VChatActivity", 1, localStringBuilder.toString());
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.d("VChatActivity", 1, "onCreate()");
    if ((super.getAppRuntime() instanceof VideoAppInterface)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    }
    paramBundle = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (paramBundle == null)
    {
      QLog.d("VChatActivity", 1, "onCreate mApp is null! ");
      super.finish();
      return;
    }
    paramBundle.b(false);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    paramBundle = super.getIntent();
    String str = paramBundle.getStringExtra("uin");
    FromServiceMsg localFromServiceMsg = (FromServiceMsg)paramBundle.getParcelableExtra("fromServiceMsg");
    paramBundle = null;
    if (localFromServiceMsg != null) {
      paramBundle = localFromServiceMsg.getServiceCmd();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate fromServiceMsg =  ");
    localStringBuilder.append(localFromServiceMsg);
    localStringBuilder.append(",cmd = ");
    localStringBuilder.append(paramBundle);
    QLog.d("VChatActivity", 1, localStringBuilder.toString());
    if (str != null)
    {
      a(str);
      a(localFromServiceMsg, paramBundle);
      super.finish();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QLog.d("VChatActivity", 1, "onDestroy()");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 4) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    super.finish();
    long l = AudioHelper.b();
    paramKeyEvent = new StringBuilder();
    paramKeyEvent.append("exit when KEYCODE_BACK, seq[");
    paramKeyEvent.append(l);
    paramKeyEvent.append("]");
    QLog.w("VChatActivity", 1, paramKeyEvent.toString());
    a(l, 1009);
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    QLog.d("VChatActivity", 1, "onNewIntent()");
    VideoBeaconReporter.a();
  }
  
  protected void onPause()
  {
    super.onPause();
    QLog.d("VChatActivity", 1, "onPause()");
  }
  
  protected void onResume()
  {
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResume()  mIsEffectiveRequest = ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    QLog.d("VChatActivity", 1, localStringBuilder.toString());
    if (!this.jdField_a_of_type_Boolean) {
      super.finish();
    }
  }
  
  protected void onStop()
  {
    QLog.d("VChatActivity", 1, "onStop()");
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VChatActivity
 * JD-Core Version:    0.7.0.1
 */