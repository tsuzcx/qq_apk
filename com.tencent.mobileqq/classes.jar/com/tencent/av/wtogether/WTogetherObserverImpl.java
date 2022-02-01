package com.tencent.av.wtogether;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.wtogether.data.ReqComResult;
import com.tencent.av.wtogether.data.ReqVideoAction;
import com.tencent.av.wtogether.data.WTReqUrlResult;
import com.tencent.av.wtogether.data.WTVideoInfo;
import com.tencent.av.wtogether.data.WTogetherPlayInfo;
import com.tencent.av.wtogether.data.WTogetherRoom;
import com.tencent.av.wtogether.data.WatchTogetherInfo;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.qphone.base.util.QLog;

public abstract class WTogetherObserverImpl
  extends WTogetherObserver
  implements Handler.Callback
{
  protected final Handler a = new Handler(Looper.getMainLooper(), this);
  protected final VideoAppInterface b;
  private long c = 0L;
  private String d = null;
  
  protected WTogetherObserverImpl(VideoAppInterface paramVideoAppInterface)
  {
    this.b = paramVideoAppInterface;
  }
  
  private void a(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl, int paramInt, float paramFloat)
  {
    WTogetherObserverImpl.2 local2 = new WTogetherObserverImpl.2(this, paramWatchTogetherMediaPlayCtrl, paramInt, paramFloat);
    if (paramWatchTogetherMediaPlayCtrl.j())
    {
      paramWatchTogetherMediaPlayCtrl.a(local2);
      if (QLog.isColorLevel()) {
        QLog.d("WTogether.ObserverImpl", 2, "updatePlayState playInfo with delay task");
      }
      return;
    }
    if (!paramWatchTogetherMediaPlayCtrl.d()) {
      paramWatchTogetherMediaPlayCtrl.c();
    }
    if (paramWatchTogetherMediaPlayCtrl.h())
    {
      paramWatchTogetherMediaPlayCtrl.a(local2);
      return;
    }
    local2.run();
  }
  
  protected abstract void a();
  
  protected void a(int paramInt)
  {
    this.a.post(new WTogetherObserverImpl.1(this, paramInt));
  }
  
  protected void a(WTogetherPlayInfo paramWTogetherPlayInfo, int paramInt, boolean paramBoolean)
  {
    if (paramWTogetherPlayInfo != null)
    {
      if (!paramBoolean) {
        return;
      }
      Object localObject = VideoController.f().aA();
      if (localObject == null) {
        return;
      }
      boolean bool = ((WatchTogetherMediaPlayCtrl)localObject).r();
      long l = paramWTogetherPlayInfo.e();
      float f = paramWTogetherPlayInfo.d();
      int i = paramWTogetherPlayInfo.c;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            ((WatchTogetherMediaPlayCtrl)localObject).z();
          }
        }
        else
        {
          ((WatchTogetherMediaPlayCtrl)localObject).a();
          ((WatchTogetherMediaPlayCtrl)localObject).a(f);
        }
      }
      else {
        a((WatchTogetherMediaPlayCtrl)localObject, (int)l, f);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updatePlayState playInfo[");
        ((StringBuilder)localObject).append(paramWTogetherPlayInfo);
        ((StringBuilder)localObject).append("], forceFromAdmin[");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append("], isAdmin[");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append("], action[");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("], curPlayTimeMs[");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append("], curPlayRate[");
        ((StringBuilder)localObject).append(f);
        ((StringBuilder)localObject).append("]");
        QLog.d("WTogether.ObserverImpl", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString) {}
  
  protected void a(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    if (!paramBoolean) {
      if (paramReqComResult.d == 1019) {
        a(2131893774);
      } else if (paramReqComResult.d == 1020) {
        a(2131893761);
      } else if (paramReqComResult.d == 1021) {
        a(2131893762);
      } else {
        a(2131893779);
      }
    }
    b(paramBoolean, true, "onStartWTogetherRet");
  }
  
  protected void a(boolean paramBoolean, ReqVideoAction paramReqVideoAction)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAdminUpdatePlayStateResult isSuccess：=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(";action:=");
    localStringBuilder.append(paramReqVideoAction.toString());
    QLog.d("WTogether.ObserverImpl", 1, localStringBuilder.toString());
  }
  
  protected void a(boolean paramBoolean, WTReqUrlResult paramWTReqUrlResult)
  {
    paramWTReqUrlResult = null;
    if (paramBoolean)
    {
      WTogetherRoom localWTogetherRoom = d();
      boolean bool1;
      if (localWTogetherRoom != null)
      {
        paramWTReqUrlResult = localWTogetherRoom.h;
        bool1 = localWTogetherRoom.i();
        paramBoolean = localWTogetherRoom.d();
      }
      else
      {
        bool1 = false;
        paramBoolean = false;
      }
      if ((paramWTReqUrlResult != null) && (paramWTReqUrlResult.b != null))
      {
        boolean bool2 = true;
        a(bool1, paramWTReqUrlResult);
        bool1 = bool2;
      }
      else
      {
        bool1 = false;
      }
      WTogetherMng localWTogetherMng = c();
      if ((localWTogetherMng != null) && (paramWTReqUrlResult != null)) {
        localWTogetherMng.a(b(), paramWTReqUrlResult.b, bool1);
      }
      if (paramBoolean) {
        localWTogetherRoom.b(false, "onReqVideoUrlResult");
      }
    }
    else
    {
      paramWTReqUrlResult = c();
      if (paramWTReqUrlResult != null) {
        paramWTReqUrlResult.a(b(), null, false);
      }
      a(2131893746);
    }
  }
  
  protected void a(boolean paramBoolean, WTogetherPlayInfo paramWTogetherPlayInfo)
  {
    if (paramWTogetherPlayInfo != null)
    {
      if (paramWTogetherPlayInfo.b == null) {
        return;
      }
      long l = SystemClock.elapsedRealtime();
      Object localObject = paramWTogetherPlayInfo.b.e();
      if ((TextUtils.equals((CharSequence)localObject, this.d)) && (Math.abs(l - this.c) < 500L))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("startPlay, too frequency play same video. [");
          ((StringBuilder)localObject).append(paramWTogetherPlayInfo);
          ((StringBuilder)localObject).append("]");
          QLog.i("WTogether.ObserverImpl", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.f().aA();
      if (localWatchTogetherMediaPlayCtrl != null)
      {
        this.c = l;
        this.d = ((String)localObject);
        localWatchTogetherMediaPlayCtrl.a(paramWTogetherPlayInfo, (int)paramWTogetherPlayInfo.d);
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.f().aA();
    if (localWatchTogetherMediaPlayCtrl != null) {
      localWatchTogetherMediaPlayCtrl.a();
    }
  }
  
  protected abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString);
  
  protected SessionInfo b()
  {
    return SessionMgr.a().b();
  }
  
  protected void b(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    b(false, true, "onCloseWTogetherRet");
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onWatchTogetherModeChange, [ start:=");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(",isAdmin:=");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append("], from[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    QLog.d("WTogether.ObserverImpl", 1, ((StringBuilder)localObject).toString());
    if (paramBoolean1)
    {
      localObject = VideoController.f().aA();
      if ((localObject != null) && (!((WatchTogetherMediaPlayCtrl)localObject).q())) {
        ((WatchTogetherMediaPlayCtrl)localObject).a(true, paramBoolean2);
      } else if ((localObject != null) && (((WatchTogetherMediaPlayCtrl)localObject).r() != paramBoolean2)) {
        ((WatchTogetherMediaPlayCtrl)localObject).a(paramBoolean2, "onWatchTogetherModeChange");
      }
    }
    else
    {
      localObject = VideoController.f().aA();
      if ((localObject != null) && (((WatchTogetherMediaPlayCtrl)localObject).q())) {
        ((WatchTogetherMediaPlayCtrl)localObject).a(false, paramBoolean2);
      } else if ((localObject != null) && (((WatchTogetherMediaPlayCtrl)localObject).r() != paramBoolean2)) {
        ((WatchTogetherMediaPlayCtrl)localObject).a(paramBoolean2, "onWatchTogetherModeChange");
      }
    }
    a(paramBoolean1, paramBoolean2, paramString);
  }
  
  protected WTogetherMng c()
  {
    VideoAppInterface localVideoAppInterface = this.b;
    if (localVideoAppInterface != null) {
      return (WTogetherMng)localVideoAppInterface.c(17);
    }
    return null;
  }
  
  protected void c(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    WTogetherRoom localWTogetherRoom = d();
    if (paramBoolean)
    {
      WTogetherPlayInfo localWTogetherPlayInfo;
      if (localWTogetherRoom == null) {
        localWTogetherPlayInfo = null;
      } else {
        localWTogetherPlayInfo = localWTogetherRoom.h;
      }
      if ((localWTogetherRoom != null) && (localWTogetherRoom.d()))
      {
        a(true, localWTogetherRoom.i());
        localWTogetherRoom.b(false, "onQueryRoomInfoRet");
      }
      if ((localWTogetherPlayInfo != null) && (localWTogetherRoom.c()))
      {
        int i;
        if (paramReqComResult.f == null) {
          i = -1;
        } else {
          i = paramReqComResult.f.b;
        }
        a(localWTogetherPlayInfo, i, localWTogetherRoom.c());
        localWTogetherRoom.a(false, "onQueryRoomInfoRet");
      }
    }
    else if ((localWTogetherRoom == null) || (localWTogetherRoom.h == null) || (!localWTogetherRoom.h.c()))
    {
      a(2131893746);
    }
    if ((!paramReqComResult.c) && (paramReqComResult.d == 1009)) {
      a();
    }
  }
  
  protected WTogetherRoom d()
  {
    SessionInfo localSessionInfo = b();
    WTogetherMng localWTogetherMng = c();
    Object localObject = null;
    if (localWTogetherMng != null)
    {
      localObject = localWTogetherMng.b(localSessionInfo);
      if (localObject == null) {
        return null;
      }
      localObject = ((WatchTogetherInfo)localObject).g;
    }
    return localObject;
  }
  
  protected void d(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    a(paramBoolean, paramReqComResult.f);
    if (!paramBoolean) {
      a(2131893765);
    }
  }
  
  protected void e()
  {
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.f().aA();
    if (localWatchTogetherMediaPlayCtrl == null) {
      return;
    }
    localWatchTogetherMediaPlayCtrl.y();
    if (QLog.isColorLevel()) {
      QLog.d("WTogether.ObserverImpl", 2, "onResourceExpire");
    }
  }
  
  protected void e(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    WTogetherRoom localWTogetherRoom = d();
    boolean bool = true;
    if (paramBoolean)
    {
      if ((localWTogetherRoom != null) && (localWTogetherRoom.h != null) && (!localWTogetherRoom.h.b())) {
        a(true, localWTogetherRoom.i());
      }
    }
    else
    {
      if ((localWTogetherRoom != null) && (localWTogetherRoom.i())) {
        paramBoolean = bool;
      } else {
        paramBoolean = false;
      }
      a(false, paramBoolean);
      if (paramReqComResult.d == 1020)
      {
        a(2131893761);
        return;
      }
      if (paramReqComResult.d == 1021)
      {
        a(2131893762);
        return;
      }
      a(2131893746);
    }
  }
  
  protected void f(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    if (paramBoolean)
    {
      WTogetherRoom localWTogetherRoom = d();
      WTogetherPlayInfo localWTogetherPlayInfo;
      if (localWTogetherRoom == null) {
        localWTogetherPlayInfo = null;
      } else {
        localWTogetherPlayInfo = localWTogetherRoom.h;
      }
      if ((localWTogetherPlayInfo != null) && (localWTogetherPlayInfo.a()))
      {
        e();
      }
      else if ((localWTogetherPlayInfo != null) && (localWTogetherRoom.c()))
      {
        a(localWTogetherPlayInfo, -1, localWTogetherRoom.c());
        localWTogetherRoom.a(false, "onSyncPlayInfoRet");
      }
    }
    if ((!paramReqComResult.c) && (paramReqComResult.d == 1009)) {
      a();
    }
  }
  
  protected void g(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    b(false, false, "onQuitRoomRet");
  }
  
  protected void h(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    if ((!paramBoolean) && (paramReqComResult.d != 1009)) {
      a(2131893752);
    }
    b(paramBoolean, false, "onEnterRoomRet");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherObserverImpl
 * JD-Core Version:    0.7.0.1
 */