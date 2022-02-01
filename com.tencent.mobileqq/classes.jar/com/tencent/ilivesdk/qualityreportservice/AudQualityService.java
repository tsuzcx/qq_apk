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
    long l = this.startEnterTime;
    this.enterRoomTime = l;
    this.startPlayTime = l;
    this.switchEnterRoomTime = l;
    this.switchStartPlayTime = l;
    this.lastStartEnterTime = l;
    this.lastEnterRoomTime = l;
    this.isTaskEnd = false;
  }
  
  private void checkEndState()
  {
    int i = this.mEnterState;
    if ((i == 7) || (i == 3) || (i == 6)) {
      enterTaskEnd(0);
    }
    if (this.mEnterState == 5)
    {
      i = this.mPlayerState;
      if ((i == 2) || (i == 3)) {
        enterTaskEnd(0);
      }
    }
  }
  
  private void commonReportEnter(QualityReportTask paramQualityReportTask)
  {
    commonReportEnter(false, paramQualityReportTask);
  }
  
  private void commonReportEnter(boolean paramBoolean, QualityReportTask paramQualityReportTask)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void commonReportSwitch(QualityReportTask paramQualityReportTask)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void enterTaskEnd(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enterTaskEnd--mCurrentState=");
    ((StringBuilder)localObject).append(this.mCurrentState);
    Log.i("AudQualityService", ((StringBuilder)localObject).toString());
    this.isTaskEnd = true;
    localObject = this.dataReportInterface.newAudQualityTask().setActType("enterTaskEnd").setActTypeDesc("流程结束").addKeyValue("zt_str1", String.valueOf(this.mEnterState)).addKeyValue("zt_str2", String.valueOf(this.mPlayerState)).addKeyValue("zt_str3", String.valueOf(this.mCurrentState)).addKeyValue("zt_str4", String.valueOf(paramInt));
    if (this.mCurrentState == 0) {
      commonReportEnter((QualityReportTask)localObject);
    } else {
      commonReportSwitch((QualityReportTask)localObject);
    }
    this.mLastPlayerState = this.mPlayerState;
    this.mEnterState = 0;
    this.mPlayerState = 0;
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
    long l2;
    long l1;
    if (this.mCurrentState == 1)
    {
      l2 = System.currentTimeMillis();
      l1 = this.switchEnterRoomTime;
    }
    for (;;)
    {
      break;
      l2 = System.currentTimeMillis();
      if (paramLong == this.enterRoomCode) {
        l1 = this.enterRoomTime;
      } else {
        l1 = this.lastEnterRoomTime;
      }
    }
    long l3 = this.enterRoomCode;
    boolean bool2 = false;
    if (l3 != paramLong) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject = this.dataReportInterface.newAudQualityTask().setActType("exitRoom").setActTypeDesc("退出房间").addKeyValue("zt_str1", String.valueOf(this.mEnterState));
    int i;
    if ((this.enterRoomCode == paramLong) && (!this.isTaskEnd)) {
      i = this.mPlayerState;
    } else {
      i = this.mLastPlayerState;
    }
    commonReportEnter(bool1, ((QualityReportTask)localObject).addKeyValue("zt_str2", String.valueOf(i)).addKeyValue("zt_str3", String.valueOf(this.mCurrentState)).addKeyValue("zt_str4", String.valueOf(l2 - l1)));
    this.mLastPlayerState = 0;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportExitRoom--isTaskEnd=");
    ((StringBuilder)localObject).append(this.isTaskEnd);
    ((StringBuilder)localObject).append(", code = ");
    boolean bool1 = bool2;
    if (this.enterRoomCode == paramLong) {
      bool1 = true;
    }
    ((StringBuilder)localObject).append(bool1);
    Log.i("AudQualityService", ((StringBuilder)localObject).toString());
    if ((this.enterRoomCode == paramLong) && (!this.isTaskEnd)) {
      enterTaskEnd(3);
    }
    this.lastEnterRoomCode = this.enterRoomCode;
    this.lastStartEnterTime = this.startEnterTime;
    this.lastEnterRoomTime = this.enterRoomTime;
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
    if (paramBundle != null)
    {
      this.mRoomProcessState = paramBundle.getString("roomProcessState", "0");
      this.startEnterTime = paramBundle.getLong("startEnterTime", System.currentTimeMillis());
    }
    else
    {
      this.startEnterTime = System.currentTimeMillis();
    }
    commonReportEnter(this.dataReportInterface.newAudQualityTask().setActType("startEnterRoom").setActTypeDesc("点击进房"));
    if (this.isFirstEnter) {
      this.isFirstEnter = false;
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
    this.mPlayerState = 2;
    long l2 = System.currentTimeMillis() - this.switchStartPlayTime;
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = 0L;
    }
    commonReportSwitch(this.dataReportInterface.newAudQualityTask().setActType("switchFirstFrame").setActTypeDesc("切房音视频首帧").addKeyValue("zt_str1", l1));
    checkEndState();
  }
  
  public void reportSwitchFistPreloadFrame()
  {
    this.mPlayerState = 4;
    long l2 = System.currentTimeMillis() - this.switchStartPlayTime;
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = 0L;
    }
    commonReportSwitch(this.dataReportInterface.newAudQualityTask().setActType("switchPreloadFirstBmp").setActTypeDesc("切房音视频预加载截图").addKeyValue("zt_str1", l1));
    checkEndState();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.qualityreportservice.AudQualityService
 * JD-Core Version:    0.7.0.1
 */