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
  private final long jdField_a_of_type_Long = AudioHelper.b();
  private final Intent jdField_a_of_type_AndroidContentIntent;
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<VideoAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  private InviteUIChecker$CheckTask(String paramString, Intent paramIntent, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVideoAppInterface);
  }
  
  public void a(VideoAppInterface paramVideoAppInterface, Intent paramIntent)
  {
    long l1 = paramIntent.getLongExtra("discussId", 0L);
    int i = paramIntent.getIntExtra("relationType", 0);
    long l2 = paramIntent.getLongExtra("friendUin", 0L);
    paramIntent = SessionMgr.a(i, String.valueOf(l1), new int[0]);
    Object localObject = SessionMgr.a().c(paramIntent);
    if ((localObject != null) && (((SessionInfo)localObject).h()))
    {
      i = ((SessionInfo)localObject).k;
      String str = ((SessionInfo)localObject).e;
      Bitmap localBitmap = paramVideoAppInterface.a(i, String.valueOf(l1), str, true, true);
      localObject = paramVideoAppInterface.a(AVUtil.c(((SessionInfo)localObject).E), String.valueOf(l2), String.valueOf(((SessionInfo)localObject).r));
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
    if (AVUtil.b(i))
    {
      long l1 = paramIntent.getLongExtra("discussId", 0L);
      j = paramIntent.getIntExtra("relationType", 0);
      long l2 = paramIntent.getLongExtra("friendUin", 0L);
      str1 = SessionMgr.a(j, String.valueOf(l1), new int[0]);
      localSessionInfo = SessionMgr.a().c(str1);
      paramIntent = str1;
      if (localSessionInfo != null)
      {
        paramIntent = str1;
        if (localSessionInfo.h())
        {
          str2 = localSessionInfo.e;
          paramIntent = paramVideoAppInterface.a(i, String.valueOf(l1), str2, true, true);
          localObject = paramVideoAppInterface.a(AVUtil.c(localSessionInfo.E), String.valueOf(l2), String.valueOf(localSessionInfo.r));
          str2 = paramVideoAppInterface.a(i, String.valueOf(l1), str2);
          QAVNotification.a(paramVideoAppInterface).a(localSessionInfo.b, (String)localObject, paramIntent, String.valueOf(l1), 57, i, 3, str2);
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
      localSessionInfo = SessionMgr.a().c(paramIntent);
      if ((localSessionInfo != null) && (localSessionInfo.h()) && (j == 3))
      {
        str2 = localSessionInfo.e;
        localObject = paramVideoAppInterface.a(i, str1, str2, true, true);
        str1 = paramVideoAppInterface.a(i, str1, str2);
        paramVideoAppInterface = QAVNotification.a(paramVideoAppInterface);
        if ((!localSessionInfo.H) && (!bool)) {
          paramVideoAppInterface.a(localSessionInfo.b, str1, (Bitmap)localObject, null, 56, i, 2);
        } else {
          paramVideoAppInterface.a(localSessionInfo.b, str1, (Bitmap)localObject, null, 55, i, 1);
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
    SessionInfo localSessionInfo = SessionMgr.a().c(paramIntent);
    if ((localSessionInfo != null) && (localSessionInfo.h()) && (i == 3))
    {
      i = localSessionInfo.k;
      String str2 = localSessionInfo.e;
      Bitmap localBitmap = paramVideoAppInterface.a(i, str1, str2, true, true);
      str1 = paramVideoAppInterface.a(i, str1, str2);
      paramVideoAppInterface = QAVNotification.a(paramVideoAppInterface);
      if (localSessionInfo.H) {
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
    Object localObject = (VideoAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      QLog.e("InviteUIChecker", 1, "CheckTask app is null.");
      return;
    }
    try
    {
      if (VideoInviteActivity.class.getName().equals(this.jdField_a_of_type_JavaLangString)) {
        c((VideoAppInterface)localObject, this.jdField_a_of_type_AndroidContentIntent);
      } else if (GaInviteLockActivity.class.getName().equals(this.jdField_a_of_type_JavaLangString)) {
        a((VideoAppInterface)localObject, this.jdField_a_of_type_AndroidContentIntent);
      } else if (MultiIncomingCallsActivity.class.getName().equals(this.jdField_a_of_type_JavaLangString)) {
        b((VideoAppInterface)localObject, this.jdField_a_of_type_AndroidContentIntent);
      }
      ReportController.b(null, "dc00898", "", "", "0X800A2C4", "0X800A2C4", 0, 0, "", "", "", "");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CheckTask className[");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
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
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.compat.InviteUIChecker.CheckTask
 * JD-Core Version:    0.7.0.1
 */