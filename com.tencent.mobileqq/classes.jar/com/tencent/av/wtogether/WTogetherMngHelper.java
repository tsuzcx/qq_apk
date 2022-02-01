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
  private final WTSyncPlayInfo a = new WTSyncPlayInfo();
  private VideoAppInterface b;
  private WTogetherMng c;
  private WatchTogetherMediaPlayerProxy d;
  private WatchTogetherDataReportHelper e;
  private boolean f;
  
  public WTogetherMngHelper(VideoAppInterface paramVideoAppInterface, boolean paramBoolean, WatchTogetherMediaPlayerProxy paramWatchTogetherMediaPlayerProxy)
  {
    this.b = paramVideoAppInterface;
    a(paramBoolean, "WTogetherMngHelper");
    this.d = paramWatchTogetherMediaPlayerProxy;
    this.e = paramWatchTogetherMediaPlayerProxy.m();
    this.c = ((WTogetherMng)paramVideoAppInterface.c(17));
  }
  
  public long a()
  {
    return this.d.e();
  }
  
  public void a(float paramFloat)
  {
    if (!this.f) {
      return;
    }
    SessionInfo localSessionInfo = SessionMgr.a().b();
    long l1 = AudioHelper.c();
    int i = this.a.a();
    long l2 = a();
    paramFloat = b();
    this.a.a(i, l2, paramFloat);
    this.c.a(localSessionInfo, this.a);
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
    Object localObject = new ReqVideoAction(l1, 4, this.a);
    this.c.a(localSessionInfo, (ReqVideoAction)localObject);
    AVUtil.a("0X800B635", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = this.d.l();
    if ((QLog.isDevelopLevel()) && (localObject1 != null))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onVideoPrepared, ");
      ((StringBuilder)localObject2).append(((WTFileInfo)localObject1).toString());
      ((StringBuilder)localObject2).append("]");
      QLog.i("WTogether.MngHelper", 4, ((StringBuilder)localObject2).toString());
    }
    localObject1 = SessionMgr.a().b();
    WTDataReportUtil.a(this.c.f((SessionInfo)localObject1), paramInt);
    if (!this.f) {
      return;
    }
    long l = AudioHelper.c();
    this.a.a(0, a(), b());
    this.c.a((SessionInfo)localObject1, this.a);
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onPlayVideo, seq[");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("]");
      QLog.i("WTogether.MngHelper", 4, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new ReqVideoAction(l, 0, this.a);
    this.c.a((SessionInfo)localObject1, (ReqVideoAction)localObject2);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    SessionInfo localSessionInfo = SessionMgr.a().b();
    paramInt2 = this.a.a();
    this.a.a(paramInt2, paramInt1, b());
    this.c.a(localSessionInfo, this.a);
  }
  
  public void a(String paramString)
  {
    if (!this.f) {}
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.MngHelper", 4, "onCompletion");
    }
    SessionInfo localSessionInfo = SessionMgr.a().b();
    WTDataReportUtil.a(this.c.f(localSessionInfo), "onCompletion");
    if (!this.f) {}
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.f != paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateAdminFlag, [");
        localStringBuilder.append(this.f);
        localStringBuilder.append("-->");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("], from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i("WTogether.MngHelper", 2, localStringBuilder.toString());
      }
      this.f = paramBoolean;
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
  
  public float b()
  {
    return this.d.g();
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void d()
  {
    if (!this.f) {
      return;
    }
    long l = AudioHelper.c();
    SessionInfo localSessionInfo = SessionMgr.a().b();
    this.a.a(1, a(), b());
    this.c.a(localSessionInfo, this.a);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPausePlay, seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.MngHelper", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ReqVideoAction(l, 1, this.a);
    this.c.a(localSessionInfo, (ReqVideoAction)localObject);
    AVUtil.a("0X800B634", 0, 0, "", "", "", "");
  }
  
  public void e()
  {
    if (!this.f) {
      return;
    }
    long l = AudioHelper.c();
    SessionInfo localSessionInfo = SessionMgr.a().b();
    this.a.a(0, a(), b());
    this.c.a(localSessionInfo, this.a);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResumePlay, seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether.MngHelper", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ReqVideoAction(l, 0, this.a);
    this.c.a(localSessionInfo, (ReqVideoAction)localObject);
  }
  
  public void f()
  {
    if (!this.f) {
      return;
    }
    SessionInfo localSessionInfo = SessionMgr.a().b();
    int i = 2;
    long l2 = AudioHelper.c();
    long l3 = a();
    Object localObject = this.c.f(localSessionInfo);
    long l1;
    if (localObject == null) {
      l1 = 0L;
    } else {
      l1 = ((WTogetherPlayInfo)localObject).d;
    }
    if (l3 < l1) {
      i = 3;
    }
    int j = this.a.a();
    this.a.a(j, l3, b());
    this.c.a(localSessionInfo, this.a);
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
    localObject = new ReqVideoAction(l2, i, this.a);
    this.c.a(localSessionInfo, (ReqVideoAction)localObject);
    AVUtil.a("0X800B633", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherMngHelper
 * JD-Core Version:    0.7.0.1
 */