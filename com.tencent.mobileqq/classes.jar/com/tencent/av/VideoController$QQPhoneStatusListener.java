package com.tencent.av;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.av.utils.UITools;
import com.tencent.qphone.base.util.QLog;

class VideoController$QQPhoneStatusListener
  implements PhoneStatusMonitor.PhoneStatusListener
{
  public VideoController$QQPhoneStatusListener(VideoController paramVideoController)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.a, 2, "new QQPhoneStatusListener");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.a.k();
    boolean bool2 = ((SessionInfo)localObject).aL;
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = VideoController.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCallStateChanged, isCalling[");
      localStringBuilder.append(((SessionInfo)localObject).q);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], mVcCtrl[");
      boolean bool1;
      if (this.a.d != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      localStringBuilder.append("], sessionInfo state[");
      localStringBuilder.append(((SessionInfo)localObject).i);
      localStringBuilder.append("], isPeerOnPhone[");
      localStringBuilder.append(bool2);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.a.d == null) {
      return;
    }
    if (paramBoolean)
    {
      switch (((SessionInfo)localObject).i)
      {
      case 5: 
      case 6: 
      case 11: 
      case 12: 
      default: 
        break;
      case 13: 
        this.a.a(l, 3, Long.valueOf(((SessionInfo)localObject).s).longValue());
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e(VideoController.a, 2, "Reject Video Request when chating");
        break;
      case 8: 
        this.a.a(UITools.b(((SessionInfo)localObject).p), ((SessionInfo)localObject).aN, 86);
        this.a.e.a(new Object[] { Integer.valueOf(66), Long.valueOf(((SessionInfo)localObject).aN) });
        break;
      case 7: 
        localObject = this.a;
        ((VideoController)localObject).a(l, ((VideoController)localObject).Z, this.a.Y);
        this.a.e.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.a.Y), Integer.valueOf(3) });
        break;
      case 3: 
      case 4: 
      case 9: 
      case 10: 
      case 14: 
        this.a.c(true);
        break;
      case 2: 
        this.a.d.rejectVideo(((SessionInfo)localObject).s, this.a.r(), 65535);
        this.a.a(((SessionInfo)localObject).s, 219);
        this.a.b(219);
        this.a.b(((SessionInfo)localObject).s, 1);
        break;
      case 1: 
        this.a.a(((SessionInfo)localObject).s, 218);
        this.a.b(218);
        this.a.b(((SessionInfo)localObject).s, 0);
        break;
      }
    }
    else
    {
      int i = ((SessionInfo)localObject).i;
      if ((i != 2) && ((i == 3) || (i == 4) || (i == 9) || (i == 10))) {
        this.a.c(false);
      }
    }
    if (!bool2) {
      this.a.a(true, paramBoolean);
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.a, 2, "finalize QQPhoneStatusListener");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoController.QQPhoneStatusListener
 * JD-Core Version:    0.7.0.1
 */