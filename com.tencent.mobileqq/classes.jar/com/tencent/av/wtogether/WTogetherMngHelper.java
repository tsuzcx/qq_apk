package com.tencent.av.wtogether;

import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerProxy;
import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerStatusCallback;
import com.tencent.av.wtogether.data.ReqVideoAction;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.av.wtogether.data.WTSyncPlayInfo;
import com.tencent.av.wtogether.data.WTogetherPlayInfo;
import com.tencent.av.wtogether.util.WatchTogetherDataReportHelper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class WTogetherMngHelper
  implements WatchTogetherMediaPlayerStatusCallback
{
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private WTogetherMng jdField_a_of_type_ComTencentAvWtogetherWTogetherMng;
  private WatchTogetherMediaPlayerProxy jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
  private final WTSyncPlayInfo jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo = new WTSyncPlayInfo();
  private WatchTogetherDataReportHelper jdField_a_of_type_ComTencentAvWtogetherUtilWatchTogetherDataReportHelper;
  private boolean jdField_a_of_type_Boolean;
  
  public WTogetherMngHelper(VideoAppInterface paramVideoAppInterface, boolean paramBoolean, WatchTogetherMediaPlayerProxy paramWatchTogetherMediaPlayerProxy)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    a(paramBoolean, "WTogetherMngHelper");
    this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy = paramWatchTogetherMediaPlayerProxy;
    this.jdField_a_of_type_ComTencentAvWtogetherUtilWatchTogetherDataReportHelper = paramWatchTogetherMediaPlayerProxy.a();
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng = ((WTogetherMng)paramVideoAppInterface.a(15));
  }
  
  public float a()
  {
    return this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a();
  }
  
  public void a(float paramFloat)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    SessionInfo localSessionInfo = SessionMgr.a().a();
    long l1 = AudioHelper.b();
    int i = this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo.a();
    long l2 = a();
    paramFloat = a();
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo.a(i, l2, paramFloat);
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a(localSessionInfo, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.MngHelper", 4, "onPlayRatioValueChange, seq[" + l1 + "], action[" + 4 + "], curPlayState[" + i + "], curPlayTimeMs[" + l2 + "], curPlayRate[" + paramFloat + "]");
    }
    ReqVideoAction localReqVideoAction = new ReqVideoAction(l1, 4, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a(localSessionInfo, localReqVideoAction);
    AVUtil.a("0X800B635", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a();
    if ((QLog.isDevelopLevel()) && (localObject != null)) {
      QLog.i("WTogether.MngHelper", 4, "onVideoPrepared, " + ((WTFileInfo)localObject).toString() + "]");
    }
    localObject = SessionMgr.a().a();
    WTDataReportUtil.a(this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a((SessionInfo)localObject), paramInt);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    long l = AudioHelper.b();
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo.a(0, a(), a());
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a((SessionInfo)localObject, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.MngHelper", 4, "onPlayVideo, seq[" + l + "]");
    }
    ReqVideoAction localReqVideoAction = new ReqVideoAction(l, 0, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a((SessionInfo)localObject, localReqVideoAction);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    SessionInfo localSessionInfo = SessionMgr.a().a();
    paramInt2 = this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo.a();
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo.a(paramInt2, paramInt1, a());
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a(localSessionInfo, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {}
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.MngHelper", 4, "onCompletion");
    }
    SessionInfo localSessionInfo = SessionMgr.a().a();
    WTDataReportUtil.a(this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a(localSessionInfo), "onCompletion");
    if (!this.jdField_a_of_type_Boolean) {}
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.MngHelper", 2, "updateAdminFlag, [" + this.jdField_a_of_type_Boolean + "-->" + paramBoolean + "], from[" + paramString + "]");
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    return false;
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    long l = AudioHelper.b();
    SessionInfo localSessionInfo = SessionMgr.a().a();
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo.a(1, a(), a());
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a(localSessionInfo, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.MngHelper", 4, "onPausePlay, seq[" + l + "]");
    }
    ReqVideoAction localReqVideoAction = new ReqVideoAction(l, 1, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a(localSessionInfo, localReqVideoAction);
    AVUtil.a("0X800B634", 0, 0, "", "", "", "");
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    long l = AudioHelper.b();
    SessionInfo localSessionInfo = SessionMgr.a().a();
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo.a(0, a(), a());
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a(localSessionInfo, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.MngHelper", 4, "onResumePlay, seq[" + l + "]");
    }
    ReqVideoAction localReqVideoAction = new ReqVideoAction(l, 0, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a(localSessionInfo, localReqVideoAction);
  }
  
  public void e()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    SessionInfo localSessionInfo = SessionMgr.a().a();
    int i = 2;
    long l2 = AudioHelper.b();
    long l3 = a();
    Object localObject = this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a(localSessionInfo);
    if (localObject == null) {}
    for (long l1 = 0L;; l1 = ((WTogetherPlayInfo)localObject).a)
    {
      if (l3 < l1) {
        i = 3;
      }
      int j = this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo.a();
      this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo.a(j, l3, a());
      this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a(localSessionInfo, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.MngHelper", 4, "onSeekComplete, seq[" + l2 + "], action[" + i + "], last[" + l1 + "], cur[" + l3 + "]");
      }
      localObject = new ReqVideoAction(l2, i, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
      this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a(localSessionInfo, (ReqVideoAction)localObject);
      AVUtil.a("0X800B633", 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherMngHelper
 * JD-Core Version:    0.7.0.1
 */