package com.tencent.av.ui;

import SharpSvrPack.SharpVideoMsg;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoPackageUtils;
import com.tencent.av.VideoPackageUtils.VideoPacket;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
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
    try
    {
      paramFromServiceMsg = (SharpVideoMsg)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "SharpVideoMsg", new SharpVideoMsg());
      int i;
      long l1;
      if (paramFromServiceMsg != null)
      {
        paramFromServiceMsg = VideoPackageUtils.a(paramFromServiceMsg.video_buff);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.a()))
        {
          VideoNodeManager.a(34);
          i = paramFromServiceMsg.e;
          paramString = String.valueOf(paramFromServiceMsg.c);
          l1 = paramFromServiceMsg.jdField_d_of_type_Long;
          if (paramFromServiceMsg.jdField_d_of_type_Int != 1) {
            break label214;
          }
        }
      }
      label214:
      for (boolean bool = true;; bool = false)
      {
        int j = paramFromServiceMsg.b;
        long l2 = paramFromServiceMsg.a;
        String str = SessionMgr.a(3, paramString, new int[0]);
        SessionInfo localSessionInfo = SessionMgr.a().a(str);
        QLog.d("VChatActivity", 1, "onCreate  = onRequestVideo " + paramFromServiceMsg.toString() + "|" + localSessionInfo);
        if (localSessionInfo == null)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(i, paramString, String.valueOf(l1), null, bool, null, 0, j);
          paramFromServiceMsg = SessionMgr.a().a(str);
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.a(l2);
          }
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
        StatisticCollector.a(super.getApplicationContext()).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "AV_UIN_NOT_MATCH", false, 0L, 0L, localHashMap, "", true);
      } while (paramString.equals("0"));
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(paramString);
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d("VChatActivity", 1, "exitVideoProcess reason = " + paramInt);
    super.finish();
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
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
  
  protected void onDestroy()
  {
    super.onDestroy();
    QLog.d("VChatActivity", 1, "avideo onDestroy");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    super.finish();
    QLog.d("VChatActivity", 1, "exit when KEYCODE_BACK");
    a(1009);
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    QLog.d("VChatActivity", 1, "onCreate onNewIntent =  ");
  }
  
  protected void onResume()
  {
    super.onResume();
    QLog.d("VChatActivity", 1, "onResume  " + this.jdField_a_of_type_Boolean);
    if (!this.jdField_a_of_type_Boolean) {
      super.finish();
    }
  }
  
  protected void onStop()
  {
    QLog.d("VChatActivity", 1, "avideo onStop");
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.VChatActivity
 * JD-Core Version:    0.7.0.1
 */