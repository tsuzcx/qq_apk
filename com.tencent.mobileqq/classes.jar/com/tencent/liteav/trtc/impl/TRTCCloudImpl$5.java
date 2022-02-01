package com.tencent.liteav.trtc.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy.a;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.d;
import com.tencent.liteav.g;
import com.tencent.liteav.g.a;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;
import java.util.Iterator;
import java.util.Set;

class TRTCCloudImpl$5
  implements Runnable
{
  TRTCCloudImpl$5(TRTCCloudImpl paramTRTCCloudImpl1, TRTCCloudDef.TRTCParams paramTRTCParams, String paramString1, long paramLong1, long paramLong2, int paramInt1, String paramString2, int paramInt2, TRTCCloudImpl paramTRTCCloudImpl2) {}
  
  public void run()
  {
    Object localObject2 = this.val$roomParams.userId;
    int i = this.val$roomParams.sdkAppId;
    boolean bool = TextUtils.isEmpty(this.val$finalStrRoomId);
    String str2 = "";
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.val$roomId);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = this.val$finalStrRoomId;
    }
    Monitor.a((String)localObject2, i, (String)localObject1);
    i = this.this$0.mRoomState;
    bool = false;
    if (i != 0)
    {
      long l2;
      if ((TextUtils.isEmpty(this.val$finalStrRoomId)) || (!this.val$finalStrRoomId.equalsIgnoreCase(this.this$0.mRoomInfo.strRoomId)))
      {
        long l1 = this.this$0.mRoomInfo.roomId;
        l2 = this.val$roomId;
        if (l1 != l2) {}
      }
      else
      {
        this.this$0.apiLog(String.format("enter the same room[%d] again!!!", new Object[] { Long.valueOf(this.val$roomId) }));
        this.this$0.mRoomInfo.enterTime = this.val$enterTime;
        this.this$0.onEnterRoom(0, "enter the same room.");
        return;
      }
      this.this$0.apiLog(String.format("enter another room[%d] when in room[%d], exit the old room!!!", new Object[] { Long.valueOf(l2), Long.valueOf(this.this$0.mRoomInfo.roomId) }));
      localObject1 = this.this$0;
      ((TRTCCloudImpl)localObject1).mIsExitOldRoom = true;
      ((TRTCCloudImpl)localObject1).exitRoom();
    }
    this.this$0.apiLog("========================================================================================================");
    this.this$0.apiLog("========================================================================================================");
    this.this$0.apiLog(String.format("============= SDK Version:%s Device Name:%s System Version:%s =============", new Object[] { TXCCommonUtil.getSDKVersionStr(), f.c(), f.d() }));
    this.this$0.apiLog("========================================================================================================");
    this.this$0.apiLog("========================================================================================================");
    this.this$0.apiLog(String.format("enterRoom roomId:%d(%s)  userId:%s sdkAppId:%d scene:%d, bizinfo:%s", new Object[] { Long.valueOf(this.val$roomId), this.val$finalStrRoomId, this.val$roomParams.userId, Integer.valueOf(this.val$roomParams.sdkAppId), Integer.valueOf(this.val$appScene), this.val$finalStrBizInfo }));
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("enterRoom self:");
    ((StringBuilder)localObject1).append(this.this$0.hashCode());
    Object localObject3 = ((StringBuilder)localObject1).toString();
    i = this.val$appScene;
    localObject1 = "VideoCall";
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          if (i != 3)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("enter room scene:%u error! default to VideoCall! ");
            ((StringBuilder)localObject2).append(this.val$appScene);
            ((StringBuilder)localObject2).append(" self:");
            ((StringBuilder)localObject2).append(this.this$0.hashCode());
            TXCLog.w("TRTCCloudImpl", ((StringBuilder)localObject2).toString());
          }
        }
        for (j = 2;; j = 1)
        {
          i = 0;
          break;
          localObject1 = "VoiceChatRoom";
          j = 2;
          i = 1;
          break;
          localObject1 = "AudioCall";
        }
      }
      localObject1 = "Live";
      j = 2;
    }
    else
    {
      j = 1;
    }
    TXCAudioEngine.getInstance().setAudioQuality(j, 1);
    String str1 = this.val$finalStrBizInfo;
    if (this.val$finalRole == 20) {
      localObject2 = "Anchor";
    } else {
      localObject2 = "Audience";
    }
    Monitor.a(1, (String)localObject3, String.format("bussInfo:%s, appScene:%s, role:%s, streamid:%s", new Object[] { str1, localObject1, localObject2, this.val$roomParams.streamId }), 0);
    if (this.this$0.mAudioFrameListener != null) {
      TXCAudioEngine.setPlayoutDataListener(this.val$refThis);
    }
    TXCEventRecorderProxy.a("18446744073709551615", 5001, this.val$roomId, -1L, "", 0);
    TXCStatus.a("18446744073709551615", 10003, f.c());
    localObject1 = this.this$0;
    ((TRTCCloudImpl)localObject1).mRoomState = 1;
    if (((TRTCCloudImpl)localObject1).mNativeRtcContext == 0L)
    {
      localObject1 = TXCCommonUtil.getSDKVersion();
      if (localObject1.length >= 1) {
        j = localObject1[0];
      } else {
        j = 0;
      }
      int k;
      if (localObject1.length >= 2) {
        k = localObject1[1];
      } else {
        k = 0;
      }
      int m;
      if (localObject1.length >= 3) {
        m = localObject1[2];
      } else {
        m = 0;
      }
      localObject1 = this.this$0;
      ((TRTCCloudImpl)localObject1).mNativeRtcContext = ((TRTCCloudImpl)localObject1).nativeCreateContext(j, k, m);
    }
    this.this$0.updateAppScene(i);
    this.this$0.mCaptureAndEnc.a(this.this$0.mConfig);
    if ((this.val$appScene == 0) && (TRTCCloudImpl.access$200(this.this$0) == 2))
    {
      bool = true;
      i = 1;
    }
    else
    {
      i = 0;
    }
    this.this$0.mCaptureAndEnc.g(bool);
    localObject1 = this.this$0;
    TRTCCloudImpl.access$500((TRTCCloudImpl)localObject1, TRTCCloudImpl.access$300((TRTCCloudImpl)localObject1), TRTCCloudImpl.access$400(this.this$0));
    localObject1 = this.this$0;
    TRTCCloudImpl.access$600((TRTCCloudImpl)localObject1, 2, ((TRTCCloudImpl)localObject1).mRoomInfo.bigEncSize.a, this.this$0.mRoomInfo.bigEncSize.b, this.this$0.mConfig.h, this.this$0.mConfig.c, this.this$0.mConfig.p, this.this$0.mConfig.e);
    if (TRTCCloudImpl.access$700(this.this$0))
    {
      localObject1 = this.this$0;
      TRTCCloudImpl.access$600((TRTCCloudImpl)localObject1, 3, ((TRTCCloudImpl)localObject1).mRoomInfo.smallEncSize.a, this.this$0.mRoomInfo.smallEncSize.b, TRTCCloudImpl.access$800(this.this$0).videoFps, TRTCCloudImpl.access$800(this.this$0).videoBitrate, this.this$0.mConfig.p, TRTCCloudImpl.access$800(this.this$0).minVideoBitrate);
    }
    else
    {
      localObject1 = this.this$0;
      TRTCCloudImpl.access$900((TRTCCloudImpl)localObject1, 3, 0, 0, 0, 0, 0, ((TRTCCloudImpl)localObject1).mConfig.p, 0);
    }
    this.this$0.mCaptureAndEnc.a(TRTCCloudImpl.access$700(this.this$0), this.this$0.mRoomInfo.smallEncSize.a, this.this$0.mRoomInfo.smallEncSize.b, TRTCCloudImpl.access$800(this.this$0).videoFps, TRTCCloudImpl.access$800(this.this$0).videoBitrate, this.this$0.mConfig.i);
    localObject1 = f.d();
    localObject3 = f.c();
    TRTCCloudImpl.access$1000(this.this$0, (String)localObject3, (String)localObject1, this.val$roomParams.sdkAppId);
    localObject2 = new TXCKeyPointReportProxy.a();
    ((TXCKeyPointReportProxy.a)localObject2).d = this.val$appScene;
    ((TXCKeyPointReportProxy.a)localObject2).e = ((String)localObject3);
    ((TXCKeyPointReportProxy.a)localObject2).f = ((String)localObject1);
    if (this.this$0.mContext != null) {
      localObject1 = this.this$0.mContext.getPackageName();
    } else {
      localObject1 = "";
    }
    ((TXCKeyPointReportProxy.a)localObject2).h = ((String)localObject1);
    ((TXCKeyPointReportProxy.a)localObject2).b = this.val$roomParams.sdkAppId;
    ((TXCKeyPointReportProxy.a)localObject2).g = TXCCommonUtil.getSDKVersionStr();
    ((TXCKeyPointReportProxy.a)localObject2).c = TRTCCloudImpl.access$1100(this.this$0);
    TXCKeyPointReportProxy.a((TXCKeyPointReportProxy.a)localObject2);
    localObject1 = this.this$0;
    ((TRTCCloudImpl)localObject1).nativeSetPriorRemoteVideoStreamType(((TRTCCloudImpl)localObject1).mNativeRtcContext, this.this$0.mPriorStreamType);
    localObject1 = this.this$0.mRoomInfo.getToken(this.this$0.mContext);
    localObject2 = this.this$0;
    ((TRTCCloudImpl)localObject2).nativeInit(((TRTCCloudImpl)localObject2).mNativeRtcContext, this.val$roomParams.sdkAppId, this.val$roomParams.userId, this.val$roomParams.userSig, (byte[])localObject1);
    localObject1 = TRTCCloudImpl.access$1200(this.this$0).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      TRTCCloudImpl.access$1300(this.this$0, ((Integer)localObject2).intValue());
    }
    localObject1 = this.this$0;
    ((TRTCCloudImpl)localObject1).enableNetworkSmallStream(TRTCCloudImpl.access$700((TRTCCloudImpl)localObject1));
    localObject1 = this.this$0;
    ((TRTCCloudImpl)localObject1).enableNetworkBlackStream(((TRTCCloudImpl)localObject1).mCaptureAndEnc.i());
    if (this.val$roomParams.privateMapKey != null) {
      localObject1 = this.val$roomParams.privateMapKey;
    } else {
      localObject1 = "";
    }
    localObject2 = this.val$finalStrRoomId;
    if (localObject2 == null) {
      localObject2 = "";
    }
    localObject3 = this.val$finalStrBizInfo;
    if (localObject3 == null) {
      localObject3 = "";
    }
    if (this.val$roomParams.userDefineRecordId != null) {
      str1 = this.val$roomParams.userDefineRecordId;
    } else {
      str1 = "";
    }
    if (this.val$roomParams.streamId != null) {
      str2 = this.val$roomParams.streamId;
    }
    int j = TRTCCloudHevcUtil.getEnterRoomCodecSupportValue();
    TRTCCloudImpl localTRTCCloudImpl = this.this$0;
    localTRTCCloudImpl.nativeEnterRoom(localTRTCCloudImpl.mNativeRtcContext, this.val$roomId, (String)localObject3, (String)localObject1, (String)localObject2, this.val$finalRole, 255, i, this.val$appScene, this.this$0.mPerformanceMode, f.c(), f.d(), this.this$0.mRecvMode, str1, str2, j);
    localObject3 = this.this$0;
    i = this.val$finalRole;
    ((TRTCCloudImpl)localObject3).mCurrentRole = i;
    ((TRTCCloudImpl)localObject3).mTargetRole = i;
    if ((((TRTCCloudImpl)localObject3).mCurrentRole == 21) && ((TRTCCloudImpl.access$1400(this.this$0)) || (TRTCCloudImpl.access$1500(this.this$0)) || (TRTCCloudImpl.access$1600(this.this$0) != TRTCCloudImpl.VideoSourceType.NONE)))
    {
      this.this$0.runOnListenerThread(new TRTCCloudImpl.5.1(this));
      this.this$0.apiLog("ignore upstream for audience, when enter room!!");
    }
    this.this$0.mCaptureAndEnc.e();
    this.this$0.startCollectStatus();
    localObject3 = this.this$0;
    ((TRTCCloudImpl)localObject3).mLastStateTimeMs = 0L;
    ((TRTCCloudImpl)localObject3).mRoomInfo.init(this.val$roomId, this.val$roomParams.userId);
    this.this$0.mRoomInfo.strRoomId = ((String)localObject2);
    this.this$0.mRoomInfo.sdkAppId = this.val$roomParams.sdkAppId;
    this.this$0.mRoomInfo.userSig = this.val$roomParams.userSig;
    this.this$0.mRoomInfo.privateMapKey = ((String)localObject1);
    this.this$0.mRoomInfo.enterTime = this.val$enterTime;
    TXCEventRecorderProxy.a("18446744073709551615", 4007, this.this$0.mConfig.a, this.this$0.mConfig.b, "", 2);
    TXCEventRecorderProxy.a("18446744073709551615", 4008, this.this$0.mConfig.h, -1L, "", 2);
    TXCEventRecorderProxy.a("18446744073709551615", 4009, this.this$0.mConfig.c, -1L, "", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.5
 * JD-Core Version:    0.7.0.1
 */