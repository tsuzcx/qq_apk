package com.tencent.av.compat;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoRecoveryReporter;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.QAVNotification;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class InviteUIChecker$CheckTask
  implements Runnable
{
  private final long a = AudioHelper.c();
  private final String b;
  private final Intent c;
  private final WeakReference<VideoAppInterface> d;
  
  private InviteUIChecker$CheckTask(String paramString, Intent paramIntent, VideoAppInterface paramVideoAppInterface)
  {
    this.b = paramString;
    this.c = paramIntent;
    this.d = new WeakReference(paramVideoAppInterface);
  }
  
  public void a(VideoAppInterface paramVideoAppInterface, Intent paramIntent)
  {
    long l1 = paramIntent.getLongExtra("discussId", 0L);
    int i = paramIntent.getIntExtra("relationType", 0);
    long l2 = paramIntent.getLongExtra("friendUin", 0L);
    paramIntent = SessionMgr.a(i, String.valueOf(l1), new int[0]);
    Object localObject = SessionMgr.a().d(paramIntent);
    if ((localObject != null) && (((SessionInfo)localObject).h()))
    {
      i = ((SessionInfo)localObject).p;
      String str = ((SessionInfo)localObject).u;
      Bitmap localBitmap = paramVideoAppInterface.a(i, String.valueOf(l1), str, true, true);
      localObject = paramVideoAppInterface.a(AVUtil.d(((SessionInfo)localObject).aQ), String.valueOf(l2), String.valueOf(((SessionInfo)localObject).aW));
      str = paramVideoAppInterface.a(i, String.valueOf(l1), str);
      QAVNotification.a(paramVideoAppInterface).a(true, paramIntent, (String)localObject, localBitmap, String.valueOf(l1), 61, i, 3, str);
      VideoRecoveryReporter.a();
    }
    if (QLog.isColorLevel())
    {
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append("showInviteNotifyForGroup session[");
      paramVideoAppInterface.append(paramIntent);
      paramVideoAppInterface.append("]");
      QLog.i("InviteUIChecker", 2, paramVideoAppInterface.toString());
    }
  }
  
  public void b(VideoAppInterface paramVideoAppInterface, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uinType", -1);
    int j;
    String str1;
    SessionInfo localSessionInfo;
    String str2;
    Object localObject;
    if (AVUtil.e(i))
    {
      long l1 = paramIntent.getLongExtra("discussId", 0L);
      j = paramIntent.getIntExtra("relationType", 0);
      long l2 = paramIntent.getLongExtra("friendUin", 0L);
      str1 = SessionMgr.a(j, String.valueOf(l1), new int[0]);
      localSessionInfo = SessionMgr.a().d(str1);
      paramIntent = str1;
      if (localSessionInfo != null)
      {
        paramIntent = str1;
        if (localSessionInfo.h())
        {
          str2 = localSessionInfo.u;
          paramIntent = paramVideoAppInterface.a(i, String.valueOf(l1), str2, true, true);
          localObject = paramVideoAppInterface.a(AVUtil.d(localSessionInfo.aQ), String.valueOf(l2), String.valueOf(localSessionInfo.aW));
          str2 = paramVideoAppInterface.a(i, String.valueOf(l1), str2);
          QAVNotification.a(paramVideoAppInterface).a(localSessionInfo.f, (String)localObject, paramIntent, String.valueOf(l1), 57, i, 3, str2);
          paramIntent = str1;
        }
      }
    }
    else
    {
      str1 = paramIntent.getStringExtra("peerUin");
      j = paramIntent.getIntExtra("relationType", 0);
      boolean bool = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
      if (bool) {
        paramIntent = SessionMgr.a(100, str1, new int[0]);
      } else {
        paramIntent = SessionMgr.a(3, str1, new int[0]);
      }
      localSessionInfo = SessionMgr.a().d(paramIntent);
      if ((localSessionInfo != null) && (localSessionInfo.h()) && (j == 3))
      {
        str2 = localSessionInfo.u;
        localObject = paramVideoAppInterface.a(i, str1, str2, true, true);
        str1 = paramVideoAppInterface.a(i, str1, str2);
        paramVideoAppInterface = QAVNotification.a(paramVideoAppInterface);
        if ((!localSessionInfo.aK) && (!bool)) {
          paramVideoAppInterface.a(localSessionInfo.f, str1, (Bitmap)localObject, null, 56, i, 2);
        } else {
          paramVideoAppInterface.a(localSessionInfo.f, str1, (Bitmap)localObject, null, 55, i, 1);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append("showInviteNotifyForMultiIncomingCall session[");
      paramVideoAppInterface.append(paramIntent);
      paramVideoAppInterface.append("]");
      QLog.i("InviteUIChecker", 2, paramVideoAppInterface.toString());
    }
  }
  
  public void c(VideoAppInterface paramVideoAppInterface, Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("peerUin");
    int i = paramIntent.getIntExtra("relationType", 0);
    if (paramIntent.getBooleanExtra("isDoubleVideoMeeting", false)) {
      paramIntent = SessionMgr.a(100, str1, new int[0]);
    } else {
      paramIntent = SessionMgr.a(3, str1, new int[0]);
    }
    SessionInfo localSessionInfo = SessionMgr.a().d(paramIntent);
    if ((localSessionInfo != null) && (localSessionInfo.h()) && (i == 3))
    {
      i = localSessionInfo.p;
      String str2 = localSessionInfo.u;
      Bitmap localBitmap = paramVideoAppInterface.a(i, str1, str2, true, true);
      str1 = paramVideoAppInterface.a(i, str1, str2);
      paramVideoAppInterface = QAVNotification.a(paramVideoAppInterface);
      if (localSessionInfo.aK) {
        paramVideoAppInterface.a(true, paramIntent, str1, localBitmap, null, 45, i, 1, null);
      } else {
        paramVideoAppInterface.a(true, paramIntent, str1, localBitmap, null, 40, i, 2, null);
      }
      VideoRecoveryReporter.a();
    }
    if (QLog.isColorLevel())
    {
      paramVideoAppInterface = new StringBuilder();
      paramVideoAppInterface.append("showInviteNotifyForDouble sessionId[");
      paramVideoAppInterface.append(paramIntent);
      paramVideoAppInterface.append("]");
      QLog.i("InviteUIChecker", 2, paramVideoAppInterface.toString());
    }
  }
  
  public void run()
  {
    Object localObject = (VideoAppInterface)this.d.get();
    if (localObject == null)
    {
      QLog.e("InviteUIChecker", 1, "CheckTask app is null.");
      return;
    }
    try
    {
      if (VideoInviteActivity.class.getName().equals(this.b)) {
        c((VideoAppInterface)localObject, this.c);
      } else if (GaInviteLockActivity.class.getName().equals(this.b)) {
        a((VideoAppInterface)localObject, this.c);
      } else if (MultiIncomingCallsActivity.class.getName().equals(this.b)) {
        b((VideoAppInterface)localObject, this.c);
      }
      ReportController.b(null, "dc00898", "", "", "0X800A2C4", "0X800A2C4", 0, 0, "", "", "", "");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CheckTask className[");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append("]");
        QLog.i("InviteUIChecker", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("InviteUIChecker", 1, "CheckTask  fail.", localThrowable);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CheckTask{");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.compat.InviteUIChecker.CheckTask
 * JD-Core Version:    0.7.0.1
 */