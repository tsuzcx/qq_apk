package com.tencent.av;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class VideoController$QQPhoneStatusListener
  implements PhoneStatusMonitor.PhoneStatusListener
{
  public VideoController$QQPhoneStatusListener(VideoController paramVideoController)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "new QQPhoneStatusListener");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SessionInfo localSessionInfo = this.a.a();
    boolean bool2 = localSessionInfo.T;
    long l = AudioHelper.b();
    boolean bool1;
    if (QLog.isColorLevel())
    {
      String str = VideoController.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("onCallStateChanged, isCalling[").append(localSessionInfo.b).append("->").append(paramBoolean).append("], mVcCtrl[");
      if (this.a.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null)
      {
        bool1 = true;
        QLog.w(str, 1, bool1 + "], sessionInfo state[" + localSessionInfo.jdField_g_of_type_Int + "], isPeerOnPhone[" + bool2 + "], seq[" + l + "]");
      }
    }
    else
    {
      if (this.a.jdField_a_of_type_ComTencentAvCoreVcControllerImpl != null) {
        break label147;
      }
    }
    for (;;)
    {
      return;
      bool1 = false;
      break;
      label147:
      if (paramBoolean) {
        switch (localSessionInfo.jdField_g_of_type_Int)
        {
        }
      }
      while (!bool2)
      {
        this.a.a(true, paramBoolean);
        return;
        this.a.a(localSessionInfo.d, 218);
        this.a.b(218);
        this.a.b(localSessionInfo.d, 0);
        continue;
        this.a.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.rejectVideo(localSessionInfo.d, this.a.c(), 65535);
        this.a.a(localSessionInfo.d, 219);
        this.a.b(219);
        this.a.b(localSessionInfo.d, 1);
        continue;
        this.a.a(l, 3, Long.valueOf(localSessionInfo.d).longValue());
        if (QLog.isColorLevel())
        {
          QLog.e(VideoController.jdField_a_of_type_JavaLangString, 2, "Reject Video Request when chating");
          continue;
          this.a.a(true);
          continue;
          this.a.a(l, this.a.h, this.a.c);
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.a.c), Integer.valueOf(3) });
          continue;
          this.a.a(UITools.b(localSessionInfo.j), localSessionInfo.jdField_g_of_type_Long, 86);
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(localSessionInfo.jdField_g_of_type_Long) });
          continue;
          switch (localSessionInfo.jdField_g_of_type_Int)
          {
          case 2: 
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          default: 
            break;
          case 3: 
          case 4: 
          case 9: 
          case 10: 
            this.a.a(false);
          }
        }
      }
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "finalize QQPhoneStatusListener");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoController.QQPhoneStatusListener
 * JD-Core Version:    0.7.0.1
 */