package com.tencent.mobileqq.avatar.dynamicavatar;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.face.DynamicFaceDrawable;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class DynamicAvatarManager$3
  implements Runnable
{
  DynamicAvatarManager$3(DynamicAvatarManager paramDynamicAvatarManager, DynamicFaceDrawable paramDynamicFaceDrawable, String paramString) {}
  
  public void run()
  {
    synchronized (this.this$0.i)
    {
      boolean bool1 = this.this$0.i.contains(this.a.x);
      if (bool1)
      {
        if (DynamicFaceDrawable.f) {
          synchronized (this.this$0.i)
          {
            this.this$0.i.remove(this.a.x);
            synchronized (this.this$0.j)
            {
              if (!this.this$0.j.contains(this.a.x)) {
                this.this$0.j.add(this.this$0.j.size(), this.a.x);
              }
            }
          }
        }
        if ((!TextUtils.isEmpty(this.a.n)) && (!this.a.r))
        {
          DynamicAvatarManager.a(this.this$0, this.b, this.a.n, this.a.o);
          return;
        }
        Object localObject4 = null;
        try
        {
          ??? = this.this$0.a(this.a.l, this.a.j);
        }
        catch (NullPointerException localNullPointerException)
        {
          ??? = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.dynamicAvatar", 2, localNullPointerException.getMessage(), localNullPointerException);
            ??? = localObject4;
          }
        }
        if (??? != null)
        {
          int i = this.a.s;
          boolean bool2 = true;
          if ((i == 1) || (this.a.s == 0))
          {
            if (this.a.s == 0 ? !DynamicAvatarManager.b(this.this$0).n : !DynamicAvatarManager.b(this.this$0).o) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            if ((!bool1) || (!DynamicUtils.a(System.currentTimeMillis(), ((DynamicAvatar)???).playTimeStamp))) {
              bool2 = false;
            }
            if (bool2)
            {
              if (QLog.isColorLevel())
              {
                ??? = new StringBuilder();
                ((StringBuilder)???).append("oneDayOnce:");
                ((StringBuilder)???).append(bool1);
                ((StringBuilder)???).append(" playedSameDay:");
                ((StringBuilder)???).append(bool2);
                ((StringBuilder)???).append(" uin:");
                ((StringBuilder)???).append(this.b);
                QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)???).toString());
              }
              synchronized (this.this$0.i)
              {
                this.this$0.i.remove(this.a.x);
                return;
              }
            }
          }
        }
        Object localObject6 = DynamicAvatarManager.a(this.this$0, this.a.l, this.a.j);
        bool1 = DynamicAvatarManager.a(this.this$0, (DynamicAvatar)???, (Setting)localObject6, this.a.k);
        if (QLog.isColorLevel())
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("execute loadDynamicAvatarInfo runnable. isNeed2GetDynamicAvatarInfo: ");
          ((StringBuilder)localObject6).append(bool1);
          QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)localObject6).toString());
        }
        if ((!bool1) && (!this.a.r))
        {
          localObject6 = DynamicAvatarManager.a(this.a.k, this.a.m, (DynamicAvatar)???);
          ??? = DynamicAvatarManager.a(this.a.k, 640, (DynamicAvatar)???);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("execute loadDynamicAvatarInfo runnable. url : ");
            localStringBuilder.append((String)localObject6);
            QLog.i("Q.dynamicAvatar", 2, localStringBuilder.toString());
          }
          DynamicAvatarManager.a(this.this$0, this.b, (String)localObject6, (String)???);
          return;
        }
        for (;;)
        {
          try
          {
            ((DynamicAvatarInfoHandler)DynamicAvatarManager.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.DYNAMIC_AVATAR_HANDLER)).a(Long.valueOf(this.a.j), this.a.l, this.a.k, this.a.m, this.a.g);
            return;
          }
          catch (Exception localException)
          {
            continue;
          }
          synchronized (this.this$0.i)
          {
            this.this$0.i.remove(this.a.x);
            return;
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.3
 * JD-Core Version:    0.7.0.1
 */