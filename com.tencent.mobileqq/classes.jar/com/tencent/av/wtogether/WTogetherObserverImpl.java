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
    WTogetherMng localWTogetherMng = null;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      localWTogetherMng = (WTogetherMng)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15);
    }
    return localWTogetherMng;
  }
  
  protected WTogetherRoom a()
  {
    Object localObject = a();
    WTogetherMng localWTogetherMng = a();
    if (localWTogetherMng != null)
    {
      localObject = localWTogetherMng.b((SessionInfo)localObject);
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    return ((WatchTogetherInfo)localObject).a;
  }
  
  protected abstract void a();
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WTogetherObserverImpl.1(this, paramInt));
  }
  
  protected void a(WTogetherPlayInfo paramWTogetherPlayInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramWTogetherPlayInfo == null) || (!paramBoolean)) {}
    for (;;)
    {
      return;
      WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.a().a();
      if (localWatchTogetherMediaPlayCtrl != null)
      {
        boolean bool = localWatchTogetherMediaPlayCtrl.i();
        long l = paramWTogetherPlayInfo.a();
        float f = paramWTogetherPlayInfo.a();
        switch (paramWTogetherPlayInfo.jdField_a_of_type_Int)
        {
        }
        while (QLog.isColorLevel())
        {
          QLog.d("WTogether.ObserverImpl", 2, "updatePlayState playInfo[" + paramWTogetherPlayInfo + "], forceFromAdmin[" + paramBoolean + "], isAdmin[" + bool + "], action[" + paramInt + "], curPlayTimeMs[" + l + "], curPlayRate[" + f + "]");
          return;
          localWatchTogetherMediaPlayCtrl.a();
          localWatchTogetherMediaPlayCtrl.a(f);
          continue;
          a(localWatchTogetherMediaPlayCtrl, (int)l, f);
          continue;
          localWatchTogetherMediaPlayCtrl.g();
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString) {}
  
  protected void a(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    if (!paramBoolean)
    {
      if (paramReqComResult.b != 1019) {
        break label29;
      }
      a(2131695997);
    }
    for (;;)
    {
      b(paramBoolean, true, "onStartWTogetherRet");
      return;
      label29:
      if (paramReqComResult.b == 1020) {
        a(2131695984);
      } else if (paramReqComResult.b == 1021) {
        a(2131695985);
      } else {
        a(2131696002);
      }
    }
  }
  
  protected void a(boolean paramBoolean, ReqVideoAction paramReqVideoAction)
  {
    QLog.d("WTogether.ObserverImpl", 1, "onAdminUpdatePlayStateResult isSuccess：=" + paramBoolean + ";action:=" + paramReqVideoAction.toString());
  }
  
  protected void a(boolean paramBoolean, WTReqUrlResult paramWTReqUrlResult)
  {
    WTogetherRoom localWTogetherRoom;
    boolean bool1;
    if (paramBoolean)
    {
      localWTogetherRoom = a();
      if (localWTogetherRoom == null) {
        break label129;
      }
      paramWTReqUrlResult = localWTogetherRoom.a;
      bool1 = localWTogetherRoom.e();
      paramBoolean = localWTogetherRoom.b();
    }
    for (;;)
    {
      boolean bool2;
      if ((paramWTReqUrlResult != null) && (paramWTReqUrlResult.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo != null))
      {
        bool2 = true;
        a(bool1, paramWTReqUrlResult);
      }
      for (bool1 = bool2;; bool1 = false)
      {
        WTogetherMng localWTogetherMng = a();
        if ((localWTogetherMng != null) && (paramWTReqUrlResult != null)) {
          localWTogetherMng.a(a(), paramWTReqUrlResult.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo, bool1);
        }
        if (paramBoolean) {
          localWTogetherRoom.b(false, "onReqVideoUrlResult");
        }
        return;
        paramWTReqUrlResult = a();
        if (paramWTReqUrlResult != null) {
          paramWTReqUrlResult.a(a(), null, false);
        }
        a(2131695969);
        return;
      }
      label129:
      paramWTReqUrlResult = null;
      paramBoolean = false;
      bool1 = false;
    }
  }
  
  protected void a(boolean paramBoolean, WTogetherPlayInfo paramWTogetherPlayInfo)
  {
    if ((paramWTogetherPlayInfo == null) || (paramWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo == null)) {}
    long l;
    String str;
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl;
    do
    {
      do
      {
        return;
        l = SystemClock.elapsedRealtime();
        str = paramWTogetherPlayInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo.a();
        if ((!TextUtils.equals(str, this.jdField_a_of_type_JavaLangString)) || (Math.abs(l - this.jdField_a_of_type_Long) >= 500L)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("WTogether.ObserverImpl", 2, "startPlay, too frequency play same video. [" + paramWTogetherPlayInfo + "]");
      return;
      localWatchTogetherMediaPlayCtrl = VideoController.a().a();
    } while (localWatchTogetherMediaPlayCtrl == null);
    this.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_JavaLangString = str;
    localWatchTogetherMediaPlayCtrl.a(paramWTogetherPlayInfo, (int)paramWTogetherPlayInfo.jdField_a_of_type_Long);
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
    if (localWatchTogetherMediaPlayCtrl == null) {}
    do
    {
      return;
      localWatchTogetherMediaPlayCtrl.f();
    } while (!QLog.isColorLevel());
    QLog.d("WTogether.ObserverImpl", 2, "onResourceExpire");
  }
  
  protected void b(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    b(false, true, "onCloseWTogetherRet");
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    QLog.d("WTogether.ObserverImpl", 1, "onWatchTogetherModeChange, [ start:=" + paramBoolean1 + ",isAdmin:=" + paramBoolean2 + "], from[" + paramString + "]");
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl;
    if (paramBoolean1)
    {
      localWatchTogetherMediaPlayCtrl = VideoController.a().a();
      if ((localWatchTogetherMediaPlayCtrl != null) && (!localWatchTogetherMediaPlayCtrl.h())) {
        localWatchTogetherMediaPlayCtrl.a(true, paramBoolean2);
      }
    }
    for (;;)
    {
      a(paramBoolean1, paramBoolean2, paramString);
      return;
      if ((localWatchTogetherMediaPlayCtrl != null) && (localWatchTogetherMediaPlayCtrl.i() != paramBoolean2))
      {
        localWatchTogetherMediaPlayCtrl.a(paramBoolean2, "onWatchTogetherModeChange");
        continue;
        localWatchTogetherMediaPlayCtrl = VideoController.a().a();
        if ((localWatchTogetherMediaPlayCtrl != null) && (localWatchTogetherMediaPlayCtrl.h())) {
          localWatchTogetherMediaPlayCtrl.a(false, paramBoolean2);
        } else if ((localWatchTogetherMediaPlayCtrl != null) && (localWatchTogetherMediaPlayCtrl.i() != paramBoolean2)) {
          localWatchTogetherMediaPlayCtrl.a(paramBoolean2, "onWatchTogetherModeChange");
        }
      }
    }
  }
  
  protected void c(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    WTogetherRoom localWTogetherRoom = a();
    WTogetherPlayInfo localWTogetherPlayInfo;
    int i;
    if (paramBoolean) {
      if (localWTogetherRoom == null)
      {
        localWTogetherPlayInfo = null;
        if ((localWTogetherRoom != null) && (localWTogetherRoom.b()))
        {
          a(true, localWTogetherRoom.e());
          localWTogetherRoom.b(false, "onQueryRoomInfoRet");
        }
        if ((localWTogetherPlayInfo != null) && (localWTogetherRoom.a()))
        {
          if (paramReqComResult.jdField_a_of_type_ComTencentAvWtogetherDataReqVideoAction != null) {
            break label125;
          }
          i = -1;
          label72:
          a(localWTogetherPlayInfo, i, localWTogetherRoom.a());
          localWTogetherRoom.a(false, "onQueryRoomInfoRet");
        }
      }
    }
    for (;;)
    {
      if ((!paramReqComResult.jdField_a_of_type_Boolean) && (paramReqComResult.b == 1009)) {
        a();
      }
      return;
      localWTogetherPlayInfo = localWTogetherRoom.a;
      break;
      label125:
      i = paramReqComResult.jdField_a_of_type_ComTencentAvWtogetherDataReqVideoAction.jdField_a_of_type_Int;
      break label72;
      if ((localWTogetherRoom == null) || (localWTogetherRoom.a == null) || (!localWTogetherRoom.a.c())) {
        a(2131695969);
      }
    }
  }
  
  protected void d(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    a(paramBoolean, paramReqComResult.jdField_a_of_type_ComTencentAvWtogetherDataReqVideoAction);
    if (!paramBoolean) {
      a(2131695988);
    }
  }
  
  protected void e(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    boolean bool = true;
    WTogetherRoom localWTogetherRoom = a();
    if (paramBoolean)
    {
      if ((localWTogetherRoom != null) && (localWTogetherRoom.a != null) && (!localWTogetherRoom.a.b())) {
        a(true, localWTogetherRoom.e());
      }
      return;
    }
    if ((localWTogetherRoom != null) && (localWTogetherRoom.e())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      a(false, paramBoolean);
      if (paramReqComResult.b != 1020) {
        break;
      }
      a(2131695984);
      return;
    }
    if (paramReqComResult.b == 1021)
    {
      a(2131695985);
      return;
    }
    a(2131695969);
  }
  
  protected void f(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    WTogetherRoom localWTogetherRoom;
    WTogetherPlayInfo localWTogetherPlayInfo;
    if (paramBoolean)
    {
      localWTogetherRoom = a();
      if (localWTogetherRoom != null) {
        break label54;
      }
      localWTogetherPlayInfo = null;
      if ((localWTogetherPlayInfo == null) || (!localWTogetherPlayInfo.a())) {
        break label63;
      }
      b();
    }
    for (;;)
    {
      if ((!paramReqComResult.jdField_a_of_type_Boolean) && (paramReqComResult.b == 1009)) {
        a();
      }
      return;
      label54:
      localWTogetherPlayInfo = localWTogetherRoom.a;
      break;
      label63:
      if ((localWTogetherPlayInfo != null) && (localWTogetherRoom.a()))
      {
        a(localWTogetherPlayInfo, -1, localWTogetherRoom.a());
        localWTogetherRoom.a(false, "onSyncPlayInfoRet");
      }
    }
  }
  
  protected void g(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    b(false, false, "onQuitRoomRet");
  }
  
  protected void h(boolean paramBoolean, ReqComResult paramReqComResult)
  {
    if ((!paramBoolean) && (paramReqComResult.b != 1009)) {
      a(2131695975);
    }
    b(paramBoolean, false, "onEnterRoomRet");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherObserverImpl
 * JD-Core Version:    0.7.0.1
 */