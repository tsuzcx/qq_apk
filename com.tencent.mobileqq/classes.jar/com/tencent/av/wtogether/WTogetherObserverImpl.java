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
  private long jdField_a_of_type_Long = 0L;
  protected final Handler a;
  protected final VideoAppInterface a;
  private String jdField_a_of_type_JavaLangString = null;
  
  protected WTogetherObserverImpl(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private void a(WatchTogetherMediaPlayCtrl paramWatchTogetherMediaPlayCtrl, int paramInt, float paramFloat)
  {
    WTogetherObserverImpl.2 local2 = new WTogetherObserverImpl.2(this, paramWatchTogetherMediaPlayCtrl, paramInt, paramFloat);
    if (paramWatchTogetherMediaPlayCtrl.e())
    {
      paramWatchTogetherMediaPlayCtrl.a(local2);
      if (QLog.isColorLevel()) {
        QLog.d("WTogether.ObserverImpl", 2, "updatePlayState playInfo with delay task");
      }
      return;
    }
    if (!paramWatchTogetherMediaPlayCtrl.a()) {
      paramWatchTogetherMediaPlayCtrl.c();
    }
    if (paramWatchTogetherMediaPlayCtrl.c())
    {
      paramWatchTogetherMediaPlayCtrl.a(local2);
      return;
    }
    local2.run();
  }
  
  protected SessionInfo a()
  {
    return SessionMgr.a().a();
  }
  
  protected WTogetherMng a()
  {
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localVideoAppInterface != null) {
      return (WTogetherMng)localVideoAppInterface.a(16);
    }
    return null;
  }
  
  protected WTogetherRoom a()
  {
    SessionInfo localSessionInfo = a();
    WTogetherMng localWTogetherMng = a();
    Object localObject = null;
    if (localWTogetherMng != null)
    {
      localObject = localWTogetherMng.b(localSessionInfo);
      if (localObject == null) {
        return null;
      }
      localObject = ((WatchTogetherInfo)localObject).a;
    }
    return localObject;
  }
  
  protected abstract void a();
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WTogetherObserverImpl.1(this, paramInt));
  }
  
  protected void a(WTogetherPlayInfo paramWTogetherPlayInfo, int paramInt, boolean paramBoolean)
  {
    if (paramWTogetherPlayInfo != null)
    {
      if (!paramBoolean) {
        return;
      }
      Object localObject = VideoController.a().a();
      if (localObject == null) {
        return;
      }
      boolean bool = ((WatchTogetherMediaPlayCtrl)localObject).i();
      long l = paramWTogetherPlayInfo.a();
      float f = paramWTogetherPlayInfo.a();
      int i = paramWTogetherPlayInfo.jdField_a_of_type_Int;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            ((WatchTogetherMediaPlayCtrl)localObject).g();
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
      if (paramReqComResult.b == 1019) {
        a(2131696012);
      } else if (paramReqComResult.b == 1020) {
        a(2131695999);
      } else if (paramReqComResult.b == 1021) {
        a(2131696000);
      } else {
        a(2131696017);
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
      WTogetherRoom localWTogetherRoom = a();
      boolean bool1;
      if (localWTogetherRoom != null)
      {
        paramWTReqUrlResult = localWTogetherRoom.a;
        bool1 = localWTogetherRoom.e();
        paramBoolean = localWTogetherRoom.b();
      }
      else
      {
        bool1 = false;
        paramBoolean = false;
      }
      if ((paramWTReqUrlResult != null) && (paramWTReqUrlResult.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo != null))
      {
        boolean bool2 = true;
        a(bool1, paramWTReqUrlResult);
        bool1 = bool2;
      }
      else
      {
        bool1 = false;
      }
      WTogetherMng localWTogetherMng = a();
      if ((localWTogetherMng != null) && (paramWTReqUrlResult != null)) {
        localWTogetherMng.a(a(), paramWTReqUrlResult.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo, bool1);
      }
      if (paramBoolean) {
        localWTogetherRoom.b(false, "onReqVideoUrlResult");
      }
    }
    else
    {
      paramWTReqUrlResult = a();
      if (paramWTReqUrlResult != null) {
        paramWTReqUrlResult.a(a(), null, false);
      }
      a(2131695984);
    }
  }
  
  protected void a(boolean paramBoolean, WTogetherPlayInfo paramWTogetherPlayInfo)
  {
    if (paramWTogetherPlayInfo != null)
    {
      if (paramWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo == null) {
        return;
      }
      long l = SystemClock.elapsedRealtime();
      Object localObject = paramWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo.a();
      if ((TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString)) && (Math.abs(l - this.jdField_a_of_type_Long) < 500L))
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
      WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.a().a();
      if (localWatchTogetherMediaPlayCtrl != null)
      {
        this.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_JavaLangString = ((String)localObject);
        localWatchTogetherMediaPlayCtrl.a(paramWTogetherPlayInfo, (int)paramWTogetherPlayInfo.jdField_a_of_type_Long);
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.a().a();
    if (localWatchTogetherMediaPlayCtrl != null) {
      localWatchTogetherMediaPlayCtrl.a();
    }
  }
  
  protected abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString);
  
  protected void b()
  {
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.a().a();
    if (localWatchTogetherMediaPlayCtrl == null) {
      return;
    }
    localWatchTogetherMediaPlayCtrl.f();
    if (QLog.isColorLevel()) {
      QLog.d("WTogether.ObserverImpl", 2, "onResourceExpire");
    }
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
      localObject = VideoController.a().a();
      if ((localObject != null) && (!((WatchTogetherMediaPlayCtrl)localObject).h())) {
        ((WatchTogetherMediaPlayCtrl)localObject).a(true, paramBoolean2);
      } else if ((localObject != null) && (((WatchTogetherMediaPlayCtrl)localObject).i() != paramBoolean2)) {
        ((WatchTogetherMediaPlayCtrl)localObject).a(paramBoolean2, "onWatchTogetherModeChange");
      }
    }
    else
    {
      localObject = VideoController.a().a();
      if ((localObject != null) && (((WatchTogetherMediaPlayCtrl)localObject).h())) {
        ((WatchTogetherMediaPlayCtrl)localObject).a(false, paramBoolean2);
      } else if ((localObject != null) && (((WatchTogetherMediaPlayCtrl)localObject).i() != paramBoolean2)) {
        ((WatchTogetherMediaPlayCtrl)localObject).a(paramBoolean2, "onWatchTogetherModeChange");
      }
    }
    a(paramBoolean1, paramBoolean2, paramString);
  }
  
  protected void c(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    WTogetherRoom localWTogetherRoom = a();
    if (paramBoolean)
    {
      WTogetherPlayInfo localWTogetherPlayInfo;
      if (localWTogetherRoom == null) {
        localWTogetherPlayInfo = null;
      } else {
        localWTogetherPlayInfo = localWTogetherRoom.a;
      }
      if ((localWTogetherRoom != null) && (localWTogetherRoom.b()))
      {
        a(true, localWTogetherRoom.e());
        localWTogetherRoom.b(false, "onQueryRoomInfoRet");
      }
      if ((localWTogetherPlayInfo != null) && (localWTogetherRoom.a()))
      {
        int i;
        if (paramReqComResult.jdField_a_of_type_ComTencentAvWtogetherDataReqVideoAction == null) {
          i = -1;
        } else {
          i = paramReqComResult.jdField_a_of_type_ComTencentAvWtogetherDataReqVideoAction.jdField_a_of_type_Int;
        }
        a(localWTogetherPlayInfo, i, localWTogetherRoom.a());
        localWTogetherRoom.a(false, "onQueryRoomInfoRet");
      }
    }
    else if ((localWTogetherRoom == null) || (localWTogetherRoom.a == null) || (!localWTogetherRoom.a.c()))
    {
      a(2131695984);
    }
    if ((!paramReqComResult.jdField_a_of_type_Boolean) && (paramReqComResult.b == 1009)) {
      a();
    }
  }
  
  protected void d(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    a(paramBoolean, paramReqComResult.jdField_a_of_type_ComTencentAvWtogetherDataReqVideoAction);
    if (!paramBoolean) {
      a(2131696003);
    }
  }
  
  protected void e(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    WTogetherRoom localWTogetherRoom = a();
    boolean bool = true;
    if (paramBoolean)
    {
      if ((localWTogetherRoom != null) && (localWTogetherRoom.a != null) && (!localWTogetherRoom.a.b())) {
        a(true, localWTogetherRoom.e());
      }
    }
    else
    {
      if ((localWTogetherRoom != null) && (localWTogetherRoom.e())) {
        paramBoolean = bool;
      } else {
        paramBoolean = false;
      }
      a(false, paramBoolean);
      if (paramReqComResult.b == 1020)
      {
        a(2131695999);
        return;
      }
      if (paramReqComResult.b == 1021)
      {
        a(2131696000);
        return;
      }
      a(2131695984);
    }
  }
  
  protected void f(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    if (paramBoolean)
    {
      WTogetherRoom localWTogetherRoom = a();
      WTogetherPlayInfo localWTogetherPlayInfo;
      if (localWTogetherRoom == null) {
        localWTogetherPlayInfo = null;
      } else {
        localWTogetherPlayInfo = localWTogetherRoom.a;
      }
      if ((localWTogetherPlayInfo != null) && (localWTogetherPlayInfo.a()))
      {
        b();
      }
      else if ((localWTogetherPlayInfo != null) && (localWTogetherRoom.a()))
      {
        a(localWTogetherPlayInfo, -1, localWTogetherRoom.a());
        localWTogetherRoom.a(false, "onSyncPlayInfoRet");
      }
    }
    if ((!paramReqComResult.jdField_a_of_type_Boolean) && (paramReqComResult.b == 1009)) {
      a();
    }
  }
  
  protected void g(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    b(false, false, "onQuitRoomRet");
  }
  
  protected void h(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    if ((!paramBoolean) && (paramReqComResult.b != 1009)) {
      a(2131695990);
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