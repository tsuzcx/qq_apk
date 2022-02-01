package com.tencent.av.wtogether;

import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerProxy;
import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerStatusCallback;
import com.tencent.av.wtogether.data.ReqVideoAction;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.av.wtogether.data.WTSyncPlayInfo;
import com.tencent.av.wtogether.data.WTogetherPlayInfo;
import com.tencent.av.wtogether.util.WatchTogetherDataReportHelper;
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
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng = ((WTogetherMng)paramVideoAppInterface.a(16));
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
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPlayRatioValueChange, seq[");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("], action[");
      ((StringBuilder)localObject).append(4);
      ((StringBuilder)localObject).append("], curPlayState[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("], curPlayTimeMs[");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("], curPlayRate[");
      ((StringBuilder)localObject).append(paramFloat);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.MngHelper", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ReqVideoAction(l1, 4, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a(localSessionInfo, (ReqVideoAction)localObject);
    AVUtil.a("0X800B635", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a();
    if ((QLog.isDevelopLevel()) && (localObject1 != null))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onVideoPrepared, ");
      ((StringBuilder)localObject2).append(((WTFileInfo)localObject1).toString());
      ((StringBuilder)localObject2).append("]");
      QLog.i("WTogether.MngHelper", 4, ((StringBuilder)localObject2).toString());
    }
    localObject1 = SessionMgr.a().a();
    WTDataReportUtil.a(this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a((SessionInfo)localObject1), paramInt);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    long l = AudioHelper.b();
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo.a(0, a(), a());
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a((SessionInfo)localObject1, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onPlayVideo, seq[");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("]");
      QLog.i("WTogether.MngHelper", 4, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new ReqVideoAction(l, 0, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a((SessionInfo)localObject1, (ReqVideoAction)localObject2);
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateAdminFlag, [");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        localStringBuilder.append("-->");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("], from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i("WTogether.MngHelper", 2, localStringBuilder.toString());
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
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPausePlay, seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.MngHelper", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ReqVideoAction(l, 1, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a(localSessionInfo, (ReqVideoAction)localObject);
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
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResumePlay, seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.MngHelper", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ReqVideoAction(l, 0, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a(localSessionInfo, (ReqVideoAction)localObject);
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
    long l1;
    if (localObject == null) {
      l1 = 0L;
    } else {
      l1 = ((WTogetherPlayInfo)localObject).a;
    }
    if (l3 < l1) {
      i = 3;
    }
    int j = this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo.a();
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo.a(j, l3, a());
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a(localSessionInfo, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSeekComplete, seq[");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("], action[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("], last[");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("], cur[");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.MngHelper", 4, ((StringBuilder)localObject).toString());
    }
    localObject = new ReqVideoAction(l2, i, this.jdField_a_of_type_ComTencentAvWtogetherDataWTSyncPlayInfo);
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng.a(localSessionInfo, (ReqVideoAction)localObject);
    AVUtil.a("0X800B633", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherMngHelper
 * JD-Core Version:    0.7.0.1
 */