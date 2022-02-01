package com.tencent.avgame.gameroom.video;

import android.os.Handler;
import com.tencent.avgame.callback.AVGameUIEventCallback;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qav.monitor.CallingStateMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AVGameControlUIImpl$2
  extends AVGameUIEventCallback
{
  AVGameControlUIImpl$2(AVGameControlUIImpl paramAVGameControlUIImpl) {}
  
  public void a()
  {
    AVGameHandler.a().b().post(new AVGameControlUIImpl.2.1(this));
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 != -1) {
      if (paramInt1 == 2) {
        AVGameControlUIImpl.b(this.a, 1);
      } else if (paramInt1 == 1) {
        AVGameControlUIImpl.b(this.a, 4);
      } else if (paramInt1 == 0) {
        if (paramInt2 == 0) {
          AVGameControlUIImpl.b(this.a, 5);
        } else {
          AVGameControlUIImpl.b(this.a, 6);
        }
      }
    }
    AVGameControlUIImpl.a(this.a).post(new AVGameControlUIImpl.2.5(this));
  }
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo) {}
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean) {}
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUserSpeaking userInfo:");
      localStringBuilder.append(paramMultiUserInfo.toString());
      localStringBuilder.append(" isSpeaking:");
      localStringBuilder.append(paramBoolean);
      QLog.i("AVGameControlUIImpl", 2, localStringBuilder.toString());
    }
    if (GameEngine.a().i()) {
      return;
    }
    AVGameHandler.a().b().post(new AVGameControlUIImpl.2.2(this, paramMultiUserInfo, paramBoolean));
  }
  
  public void a(List<QavDef.MultiUserInfo> paramList) {}
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (GameEngine.a().f()) && (!GameEngine.a().g())) {
      CallingStateMonitor.a().c();
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    AVGameHandler.a().b().post(new AVGameControlUIImpl.2.4(this, paramLong, paramBoolean, paramInt));
  }
  
  public void b(int paramInt)
  {
    AVGameSession localAVGameSession = AVGameBusinessCtrl.b().a();
    if (localAVGameSession != null)
    {
      if (localAVGameSession.e) {
        return;
      }
      AVGameHandler.a().b().post(new AVGameControlUIImpl.2.3(this, paramInt));
    }
  }
  
  public void b(QavDef.MultiUserInfo paramMultiUserInfo) {}
  
  public void b(boolean paramBoolean)
  {
    if (GameEngine.a().f()) {
      GameEngine.a().g();
    }
  }
  
  public void b(boolean paramBoolean, long paramLong, int paramInt)
  {
    AVGameHandler.a().b().post(new AVGameControlUIImpl.2.6(this, paramLong, paramBoolean, paramInt));
  }
  
  public void c(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2
 * JD-Core Version:    0.7.0.1
 */