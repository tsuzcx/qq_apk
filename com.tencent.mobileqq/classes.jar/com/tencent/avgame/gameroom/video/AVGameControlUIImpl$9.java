package com.tencent.avgame.gameroom.video;

import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.qav.SecurityPolicyChecker;
import com.tencent.avgame.qav.SecurityPolicyChecker.CheckSecurityPolicyCallback;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AVGameControlUIImpl$9
  implements SecurityPolicyChecker.CheckSecurityPolicyCallback
{
  AVGameControlUIImpl$9(AVGameControlUIImpl paramAVGameControlUIImpl) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.a.a()) {
      return;
    }
    Object localObject1 = AVGameBusinessCtrl.b();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((AVGameBusinessCtrl)localObject1).a();
    if (localObject1 == null) {
      return;
    }
    AVGameControlUIImpl.a(this.a, "CheckDisableSmallPicTask");
    if ((this.a.a != null) && (paramBoolean))
    {
      boolean bool1 = false;
      paramBoolean = false;
      boolean bool2 = SecurityPolicyChecker.a().b();
      Object localObject2 = new ArrayList();
      ((AVGameSession)localObject1).b((List)localObject2);
      if (((List)localObject2).size() > 0)
      {
        localObject1 = ((List)localObject2).iterator();
        for (;;)
        {
          bool1 = paramBoolean;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (AVGameUserInfo)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((AVGameUserInfo)localObject2).hasVideo()) && (!((AVGameUserInfo)localObject2).mIsSelf))
          {
            if (((AVGameUserInfo)localObject2).mBigVideo) {}
            while (!bool2)
            {
              paramBoolean = true;
              break;
            }
          }
        }
      }
      if (bool1) {
        this.a.c();
      } else {
        this.a.e();
      }
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkDisableSmallPic, [");
        ((StringBuilder)localObject1).append(bool2);
        ((StringBuilder)localObject1).append("], needRequest[");
        ((StringBuilder)localObject1).append(bool1);
        ((StringBuilder)localObject1).append("]");
        QLog.i("AVGameControlUIImpl", 4, ((StringBuilder)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.9
 * JD-Core Version:    0.7.0.1
 */