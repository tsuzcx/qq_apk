package com.tencent.av.compat;

import android.content.Intent;
import android.graphics.Bitmap;
import bcef;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import lbu;
import lcw;
import lez;
import mqu;
import msw;

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
    paramIntent = lbu.a(i, String.valueOf(l1), new int[0]);
    Object localObject = lbu.a().c(paramIntent);
    if ((localObject != null) && (((lez)localObject).j()))
    {
      i = ((lez)localObject).j;
      String str = ((lez)localObject).f;
      Bitmap localBitmap = paramVideoAppInterface.a(i, String.valueOf(l1), str, true, true);
      localObject = paramVideoAppInterface.getDisplayName(mqu.c(((lez)localObject).F), String.valueOf(l2), String.valueOf(((lez)localObject).s));
      str = paramVideoAppInterface.getDisplayName(i, String.valueOf(l1), str);
      msw.a(paramVideoAppInterface).a(true, paramIntent, (String)localObject, localBitmap, String.valueOf(l1), 61, i, 3, str);
      lcw.a();
    }
    if (QLog.isColorLevel()) {
      QLog.i("InviteUIChecker", 2, "showInviteNotifyForGroup session[" + paramIntent + "]");
    }
  }
  
  public void b(VideoAppInterface paramVideoAppInterface, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("uinType", -1);
    int j;
    Object localObject1;
    String str;
    Object localObject2;
    Object localObject3;
    if (mqu.b(i))
    {
      long l1 = paramIntent.getLongExtra("discussId", 0L);
      j = paramIntent.getIntExtra("relationType", 0);
      long l2 = paramIntent.getLongExtra("friendUin", 0L);
      localObject1 = lbu.a(j, String.valueOf(l1), new int[0]);
      paramIntent = lbu.a().c((String)localObject1);
      if ((paramIntent != null) && (paramIntent.j()))
      {
        str = paramIntent.f;
        localObject2 = paramVideoAppInterface.a(i, String.valueOf(l1), str, true, true);
        localObject3 = paramVideoAppInterface.getDisplayName(mqu.c(paramIntent.F), String.valueOf(l2), String.valueOf(paramIntent.s));
        str = paramVideoAppInterface.getDisplayName(i, String.valueOf(l1), str);
        msw.a(paramVideoAppInterface).a(paramIntent.c, (String)localObject3, (Bitmap)localObject2, String.valueOf(l1), 57, i, 3, str);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("InviteUIChecker", 2, "showInviteNotifyForMultiIncomingCall session[" + (String)localObject1 + "]");
      }
      return;
      localObject2 = paramIntent.getStringExtra("peerUin");
      j = paramIntent.getIntExtra("relationType", 0);
      boolean bool = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
      if (bool) {}
      for (paramIntent = lbu.a(100, (String)localObject2, new int[0]);; paramIntent = lbu.a(3, (String)localObject2, new int[0]))
      {
        localObject3 = lbu.a().c(paramIntent);
        localObject1 = paramIntent;
        if (localObject3 == null) {
          break;
        }
        localObject1 = paramIntent;
        if (!((lez)localObject3).j()) {
          break;
        }
        localObject1 = paramIntent;
        if (j != 3) {
          break;
        }
        str = ((lez)localObject3).f;
        localObject1 = paramVideoAppInterface.a(i, (String)localObject2, str, true, true);
        localObject2 = paramVideoAppInterface.getDisplayName(i, (String)localObject2, str);
        paramVideoAppInterface = msw.a(paramVideoAppInterface);
        if ((((lez)localObject3).S) || (bool)) {
          break label367;
        }
        paramVideoAppInterface.a(((lez)localObject3).c, (String)localObject2, (Bitmap)localObject1, null, 56, i, 2);
        localObject1 = paramIntent;
        break;
      }
      label367:
      paramVideoAppInterface.a(((lez)localObject3).c, (String)localObject2, (Bitmap)localObject1, null, 55, i, 1);
      localObject1 = paramIntent;
    }
  }
  
  public void c(VideoAppInterface paramVideoAppInterface, Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("peerUin");
    int i = paramIntent.getIntExtra("relationType", 0);
    Bitmap localBitmap;
    if (paramIntent.getBooleanExtra("isDoubleVideoMeeting", false))
    {
      paramIntent = lbu.a(100, str1, new int[0]);
      lez locallez = lbu.a().c(paramIntent);
      if ((locallez != null) && (locallez.j()) && (i == 3))
      {
        i = locallez.j;
        String str2 = locallez.f;
        localBitmap = paramVideoAppInterface.a(i, str1, str2, true, true);
        str1 = paramVideoAppInterface.getDisplayName(i, str1, str2);
        paramVideoAppInterface = msw.a(paramVideoAppInterface);
        if (!locallez.S) {
          break label183;
        }
        paramVideoAppInterface.a(true, paramIntent, str1, localBitmap, null, 45, i, 1, null);
      }
    }
    for (;;)
    {
      lcw.a();
      if (QLog.isColorLevel()) {
        QLog.i("InviteUIChecker", 2, "showInviteNotifyForDouble sessionId[" + paramIntent + "]");
      }
      return;
      paramIntent = lbu.a(3, str1, new int[0]);
      break;
      label183:
      paramVideoAppInterface.a(true, paramIntent, str1, localBitmap, null, 40, i, 2, null);
    }
  }
  
  public void run()
  {
    VideoAppInterface localVideoAppInterface = (VideoAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localVideoAppInterface == null)
    {
      QLog.e("InviteUIChecker", 1, "CheckTask app is null.");
      return;
    }
    for (;;)
    {
      try
      {
        if (VideoInviteActivity.class.getName().equals(this.jdField_a_of_type_JavaLangString))
        {
          c(localVideoAppInterface, this.jdField_a_of_type_AndroidContentIntent);
          bcef.b(null, "dc00898", "", "", "0X800A2C4", "0X800A2C4", 0, 0, "", "", "", "");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("InviteUIChecker", 2, "CheckTask className[" + this.jdField_a_of_type_JavaLangString + "]");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("InviteUIChecker", 1, "CheckTask  fail.", localThrowable);
        return;
      }
      if (GaInviteLockActivity.class.getName().equals(this.jdField_a_of_type_JavaLangString)) {
        a(localThrowable, this.jdField_a_of_type_AndroidContentIntent);
      } else if (MultiIncomingCallsActivity.class.getName().equals(this.jdField_a_of_type_JavaLangString)) {
        b(localThrowable, this.jdField_a_of_type_AndroidContentIntent);
      }
    }
  }
  
  public String toString()
  {
    return "CheckTask{" + this.jdField_a_of_type_Long + ", " + this.jdField_a_of_type_JavaLangString + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.compat.InviteUIChecker.CheckTask
 * JD-Core Version:    0.7.0.1
 */