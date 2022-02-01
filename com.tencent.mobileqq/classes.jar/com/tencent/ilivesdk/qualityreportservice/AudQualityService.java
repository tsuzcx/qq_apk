package com.tencent.ilivesdk.qualityreportservice;

import android.os.Bundle;
import android.util.Log;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.QualityReportTask;
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;

public class AudQualityService
  implements AudQualityServiceInterface
{
  private static final int CURRENT_ENTER_OUTER = 0;
  private static final int CURRENT_ENTER_SWITCH = 1;
  private static final int ENTER_STATE_ENTERROOM = 4;
  private static final int ENTER_STATE_ENTERROOM_FAIL = 6;
  private static final int ENTER_STATE_ENTERROOM_SUC = 5;
  private static final int ENTER_STATE_FIRSTFRAME = 2;
  private static final int ENTER_STATE_INIT = 0;
  private static final int ENTER_STATE_LIVEOVER = 7;
  private static final int ENTER_STATE_LOGIN_FAIL = 3;
  private static final int ENTER_STATE_LOGIN_SUC = 2;
  private static final int ENTER_STATE_PLAYERR = 3;
  private static final int ENTER_STATE_PLAYER_INIT = 0;
  private static final int ENTER_STATE_PLAYER_START = 1;
  private static final int ENTER_STATE_PRELOAD_FIRSTBITMAP = 4;
  private static final int ENTER_STATE_STARTENTER = 1;
  private static final int endWithExit = 3;
  private static final int endWithReEnter = 1;
  private static final int endWithSucOrFail = 0;
  private static final int endWithSwitch = 2;
  private final String TAG = "AudQualityService";
  private DataReportInterface dataReportInterface;
  private long enterRoomCode = 0L;
  private long enterRoomTime;
  private boolean isCurrentFirstEnter;
  private boolean isFirstEnter = true;
  private boolean isTaskEnd = false;
  private long lastEnterRoomCode;
  private long lastEnterRoomTime;
  private long lastStartEnterTime;
  private int mCurrentState;
  private int mEnterState;
  private boolean mHasLogin = false;
  private boolean mHasUrl;
  private boolean mIsPreloadedVideo;
  private int mLastPlayerState;
  private int mPlayerState;
  private long mRoomId;
  private String mRoomProcessState = "0";
  private boolean mSwitchHasUrl;
  private long mSwitchRoomId;
  private long startEnterTime;
  private long startPlayTime;
  private long startSwitchTime;
  private long switchEnterRoomTime;
  private long switchStartPlayTime;
  
  public AudQualityService(DataReportInterface paramDataReportInterface)
  {
    this.dataReportInterface = paramDataReportInterface;
    this.startEnterTime = System.currentTimeMillis();
    this.startSwitchTime = System.currentTimeMillis();
    this.mEnterState = 0;
    this.mPlayerState = 0;
    this.mCurrentState = 0;
    this.enterRoomTime = this.startEnterTime;
    this.startPlayTime = this.startEnterTime;
    this.switchEnterRoomTime = this.startEnterTime;
    this.switchStartPlayTime = this.startEnterTime;
    this.lastStartEnterTime = this.startEnterTime;
    this.lastEnterRoomTime = this.startEnterTime;
    this.isTaskEnd = false;
  }
  
  private void checkEndState()
  {
    if ((this.mEnterState == 7) || (this.mEnterState == 3) || (this.mEnterState == 6)) {
      enterTaskEnd(0);
    }
    if ((this.mEnterState == 5) && ((this.mPlayerState == 2) || (this.mPlayerState == 3))) {
      enterTaskEnd(0);
    }
  }
  
  private void commonReportEnter(QualityReportTask paramQualityReportTask)
  {
    commonReportEnter(false, paramQualityReportTask);
  }
  
  private void commonReportEnter(boolean paramBoolean, QualityReportTask paramQualityReportTask)
  {
    int j = 0;
    long l2 = System.currentTimeMillis();
    long l1;
    label55:
    int i;
    label86:
    label105:
    label124:
    QualityReportTask localQualityReportTask;
    if (paramBoolean)
    {
      l1 = this.lastStartEnterTime;
      l1 = l2 - l1;
      if (!paramBoolean) {
        break label235;
      }
      Log.i("AudQualityService", "commonReportEnter exit t = " + l1);
      paramQualityReportTask = paramQualityReportTask.addKeyValue("roomid", this.mRoomId).addKeyValue("timelong", l1);
      if (!this.mHasLogin) {
        break label264;
      }
      i = 1;
      paramQualityReportTask = paramQualityReportTask.addKeyValue("zt_int2", i);
      if (!this.mHasUrl) {
        break label269;
      }
      i = 1;
      paramQualityReportTask = paramQualityReportTask.addKeyValue("zt_int3", i);
      if (!this.isCurrentFirstEnter) {
        break label274;
      }
      i = 1;
      paramQualityReportTask = paramQualityReportTask.addKeyValue("zt_int4", i);
      i = j;
      if ("1".equals(this.mRoomProcessState)) {
        i = 1;
      }
      localQualityReportTask = paramQualityReportTask.addKeyValue("zt_int5", i);
      if (!this.mIsPreloadedVideo) {
        break label279;
      }
    }
    label264:
    label269:
    label274:
    label279:
    for (paramQualityReportTask = "1";; paramQualityReportTask = "0")
    {
      localQualityReportTask.addKeyValue("zt_str5", paramQualityReportTask).setRealTimeUpload(true).send();
      Log.i("AudQualityService", "commonReportEnter timelong = " + (System.currentTimeMillis() - this.startEnterTime));
      return;
      l1 = this.startEnterTime;
      break;
      label235:
      Log.i("AudQualityService", "commonReportEnter enter t = " + l1);
      break label55;
      i = 0;
      break label86;
      i = 0;
      break label105;
      i = 0;
      break label124;
    }
  }
  
  private void commonReportSwitch(QualityReportTask paramQualityReportTask)
  {
    paramQualityReportTask = paramQualityReportTask.addKeyValue("timelong", System.currentTimeMillis() - this.startSwitchTime).addKeyValue("roomid", this.mSwitchRoomId);
    int i;
    QualityReportTask localQualityReportTask;
    if (this.mSwitchHasUrl)
    {
      i = 1;
      localQualityReportTask = paramQualityReportTask.addKeyValue("zt_int3", i);
      if (!this.mIsPreloadedVideo) {
        break label83;
      }
    }
    label83:
    for (paramQualityReportTask = "1";; paramQualityReportTask = "0")
    {
      localQualityReportTask.addKeyValue("zt_str5", paramQualityReportTask).setRealTimeUpload(false).send();
      return;
      i = 0;
      break;
    }
  }
  
  private void enterTaskEnd(int paramInt)
  {
    Log.i("AudQualityService", "enterTaskEnd--mCurrentState=" + this.mCurrentState);
    this.isTaskEnd = true;
    QualityReportTask localQualityReportTask = this.dataReportInterface.newAudQualityTask().setActType("enterTaskEnd").setActTypeDesc("流程结束").addKeyValue("zt_str1", String.valueOf(this.mEnterState)).addKeyValue("zt_str2", String.valueOf(this.mPlayerState)).addKeyValue("zt_str3", String.valueOf(this.mCurrentState)).addKeyValue("zt_str4", String.valueOf(paramInt));
    if (this.mCurrentState == 0) {
      commonReportEnter(localQualityReportTask);
    }
    for (;;)
    {
      this.mLastPlayerState = this.mPlayerState;
      this.mEnterState = 0;
      this.mPlayerState = 0;
      return;
      commonReportSwitch(localQualityReportTask);
    }
  }
  
  public void reportEnterOver()
  {
    this.mEnterState = 7;
    commonReportEnter(this.dataReportInterface.newAudQualityTask().setActType("enterLiveOver").setActTypeDesc("进房结束"));
    checkEndState();
  }
  
  public void reportEnterRoom()
  {
    this.mEnterState = 4;
    this.lastEnterRoomTime = this.enterRoomTime;
    this.enterRoomTime = System.currentTimeMillis();
    commonReportEnter(this.dataReportInterface.newAudQualityTask().setActType("enterRoom").setActTypeDesc("开始进房"));
  }
  
  public void reportEnterRoomFail(int paramInt)
  {
    this.mEnterState = 6;
    commonReportEnter(this.dataReportInterface.newAudQualityTask().setActType("enterRoomFail").setActTypeDesc("进房失败").addKeyValue("zt_int1", paramInt));
    checkEndState();
  }
  
  public void reportEnterRoomSuc()
  {
    this.mEnterState = 5;
    commonReportEnter(this.dataReportInterface.newAudQualityTask().setActType("enterRoomSuc").setActTypeDesc("进房成功").addKeyValue("zt_str1", System.currentTimeMillis() - this.enterRoomTime));
    checkEndState();
  }
  
  public void reportExitRoom(long paramLong)
  {
    boolean bool2 = true;
    long l1;
    label33:
    Object localObject;
    int i;
    if (this.mCurrentState == 1)
    {
      l1 = System.currentTimeMillis() - this.switchEnterRoomTime;
      if (this.enterRoomCode == paramLong) {
        break label287;
      }
      bool1 = true;
      localObject = this.dataReportInterface.newAudQualityTask().setActType("exitRoom").setActTypeDesc("退出房间").addKeyValue("zt_str1", String.valueOf(this.mEnterState));
      if ((this.enterRoomCode == paramLong) && (!this.isTaskEnd)) {
        break label293;
      }
      i = this.mLastPlayerState;
      label95:
      commonReportEnter(bool1, ((QualityReportTask)localObject).addKeyValue("zt_str2", String.valueOf(i)).addKeyValue("zt_str3", String.valueOf(this.mCurrentState)).addKeyValue("zt_str4", String.valueOf(l1)));
      this.mLastPlayerState = 0;
      localObject = new StringBuilder().append("reportExitRoom--isTaskEnd=").append(this.isTaskEnd).append(", code = ");
      if (this.enterRoomCode != paramLong) {
        break label301;
      }
    }
    label287:
    label293:
    label301:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Log.i("AudQualityService", bool1);
      if ((this.enterRoomCode == paramLong) && (!this.isTaskEnd)) {
        enterTaskEnd(3);
      }
      this.lastEnterRoomCode = this.enterRoomCode;
      this.lastStartEnterTime = this.startEnterTime;
      this.lastEnterRoomTime = this.enterRoomTime;
      return;
      long l2 = System.currentTimeMillis();
      if (paramLong == this.enterRoomCode) {}
      for (l1 = this.enterRoomTime;; l1 = this.lastEnterRoomTime)
      {
        l1 = l2 - l1;
        break;
      }
      bool1 = false;
      break label33;
      i = this.mPlayerState;
      break label95;
    }
  }
  
  public void reportFirstFrame()
  {
    this.mPlayerState = 2;
    commonReportEnter(this.dataReportInterface.newAudQualityTask().setActType("videoFirstFrame").setActTypeDesc("音视频首帧").addKeyValue("zt_str1", System.currentTimeMillis() - this.startPlayTime));
    checkEndState();
  }
  
  public void reportFistPreloadFrame()
  {
    this.mPlayerState = 4;
    commonReportEnter(this.dataReportInterface.newAudQualityTask().setActType("videoPreloadFirstBmp").setActTypeDesc("音视频预加载截图").addKeyValue("zt_str1", System.currentTimeMillis() - this.startPlayTime));
    checkEndState();
  }
  
  public void reportLoginFail(int paramInt)
  {
    this.mEnterState = 3;
    commonReportEnter(this.dataReportInterface.newAudQualityTask().setActType("loginFail").setActTypeDesc("登录失败").addKeyValue("zt_int1", paramInt));
    checkEndState();
  }
  
  public void reportLoginSuc()
  {
    this.mEnterState = 2;
    commonReportEnter(this.dataReportInterface.newAudQualityTask().setActType("loginSuc").setActTypeDesc("登录成功"));
  }
  
  public void reportPlayFail(int paramInt)
  {
    this.mPlayerState = 3;
    commonReportEnter(this.dataReportInterface.newAudQualityTask().setActType("videoPlayError").setActTypeDesc("音视频播放失败").addKeyValue("zt_int1", paramInt));
    checkEndState();
  }
  
  public void reportSendGiftFail(long paramLong, int paramInt)
  {
    this.dataReportInterface.newAudQualityTask().setActType("sendGiftFail").setActTypeDesc("送礼失败").addKeyValue("zt_int1", paramInt).addKeyValue("zt_int2", paramLong).send();
  }
  
  public void reportSendGiftStart(long paramLong)
  {
    this.dataReportInterface.newAudQualityTask().setActType("sendGift").setActTypeDesc("开始送礼").addKeyValue("zt_int2", paramLong).send();
  }
  
  public void reportSendGiftSuc(long paramLong)
  {
    this.dataReportInterface.newAudQualityTask().setActType("sendGiftSuc").setActTypeDesc("送礼成功").addKeyValue("zt_int2", paramLong).send();
  }
  
  public void reportStartEnter(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle)
  {
    if (this.mEnterState != 0) {
      enterTaskEnd(1);
    }
    this.isTaskEnd = false;
    this.isCurrentFirstEnter = this.isFirstEnter;
    this.mCurrentState = 0;
    this.mEnterState = 1;
    this.mRoomId = paramLong;
    this.mHasUrl = paramBoolean1;
    this.mHasLogin = paramBoolean2;
    this.mIsPreloadedVideo = paramBoolean3;
    this.lastStartEnterTime = this.startEnterTime;
    if (paramBundle != null) {
      this.mRoomProcessState = paramBundle.getString("roomProcessState", "0");
    }
    for (this.startEnterTime = paramBundle.getLong("startEnterTime", System.currentTimeMillis());; this.startEnterTime = System.currentTimeMillis())
    {
      commonReportEnter(this.dataReportInterface.newAudQualityTask().setActType("startEnterRoom").setActTypeDesc("点击进房"));
      if (this.isFirstEnter) {
        this.isFirstEnter = false;
      }
      return;
    }
  }
  
  public void reportStartPlay()
  {
    this.mPlayerState = 1;
    this.startPlayTime = System.currentTimeMillis();
    commonReportEnter(this.dataReportInterface.newAudQualityTask().setActType("videoPlayStart").setActTypeDesc("开始加载音视频"));
  }
  
  public void reportSwitchEnterRoom()
  {
    this.mEnterState = 4;
    this.switchEnterRoomTime = System.currentTimeMillis();
    commonReportSwitch(this.dataReportInterface.newAudQualityTask().setActType("switchEnterRoom").setActTypeDesc("切房开始进房"));
  }
  
  public void reportSwitchEnterRoomFail(int paramInt)
  {
    this.mEnterState = 6;
    commonReportSwitch(this.dataReportInterface.newAudQualityTask().setActType("switchEnterRoomFail").setActTypeDesc("切房进房失败").addKeyValue("zt_int1", paramInt));
    checkEndState();
  }
  
  public void reportSwitchEnterRoomSuc()
  {
    this.mEnterState = 5;
    commonReportSwitch(this.dataReportInterface.newAudQualityTask().setActType("switchEnterRoomSuc").setActTypeDesc("切房进房成功").addKeyValue("zt_str1", System.currentTimeMillis() - this.switchEnterRoomTime));
    checkEndState();
  }
  
  public void reportSwitchFirstFrame()
  {
    long l1 = 0L;
    this.mPlayerState = 2;
    long l2 = System.currentTimeMillis() - this.switchStartPlayTime;
    if (l2 <= 0L) {}
    for (;;)
    {
      commonReportSwitch(this.dataReportInterface.newAudQualityTask().setActType("switchFirstFrame").setActTypeDesc("切房音视频首帧").addKeyValue("zt_str1", l1));
      checkEndState();
      return;
      l1 = l2;
    }
  }
  
  public void reportSwitchFistPreloadFrame()
  {
    long l1 = 0L;
    this.mPlayerState = 4;
    long l2 = System.currentTimeMillis() - this.switchStartPlayTime;
    if (l2 <= 0L) {}
    for (;;)
    {
      commonReportSwitch(this.dataReportInterface.newAudQualityTask().setActType("switchPreloadFirstBmp").setActTypeDesc("切房音视频预加载截图").addKeyValue("zt_str1", l1));
      checkEndState();
      return;
      l1 = l2;
    }
  }
  
  public void reportSwitchOver()
  {
    this.mEnterState = 7;
    commonReportSwitch(this.dataReportInterface.newAudQualityTask().setActType("switchLiveOver").setActTypeDesc("切房结束"));
    checkEndState();
  }
  
  public void reportSwitchPlayFail(int paramInt)
  {
    this.mPlayerState = 3;
    commonReportSwitch(this.dataReportInterface.newAudQualityTask().setActType("switcVideoPlayError").setActTypeDesc("切房播放失败").addKeyValue("zt_int1", paramInt));
    checkEndState();
  }
  
  public void reportSwitchRoom(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mEnterState != 0) {
      enterTaskEnd(2);
    }
    this.isTaskEnd = false;
    this.mCurrentState = 1;
    this.startSwitchTime = System.currentTimeMillis();
    this.mSwitchRoomId = paramLong;
    this.mSwitchHasUrl = paramBoolean1;
    this.mIsPreloadedVideo = paramBoolean2;
    this.mRoomId = paramLong;
    this.mEnterState = 0;
    this.mPlayerState = 0;
    commonReportSwitch(this.dataReportInterface.newAudQualityTask().setActType("switchRoom").setActTypeDesc("开始切房"));
  }
  
  public void reportSwitchStartPlay()
  {
    this.mPlayerState = 1;
    this.switchStartPlayTime = System.currentTimeMillis();
    commonReportSwitch(this.dataReportInterface.newAudQualityTask().setActType("switcVideoPlayStart").setActTypeDesc("切房开始播放"));
  }
  
  public void setEnterRoomCode(long paramLong)
  {
    if (this.lastEnterRoomCode == this.enterRoomCode) {
      this.lastEnterRoomCode = paramLong;
    }
    this.enterRoomCode = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.qualityreportservice.AudQualityService
 * JD-Core Version:    0.7.0.1
 */