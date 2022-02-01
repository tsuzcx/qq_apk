package com.tencent.av.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoPackageUtils.VideoPacket;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.qphone.base.util.QLog;

public class QAVNotificationUtil
{
  public static int a(VideoAppInterface paramVideoAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt1 == 19) && (!TextUtils.isEmpty(paramString))) {
      return paramVideoAppInterface.m(paramString);
    }
    return VideoController.a(paramInt1, false, paramInt2);
  }
  
  public static Intent a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = SessionMgr.a().d(paramString);
    if (paramString == null) {
      return null;
    }
    try
    {
      paramContext = new Intent(paramContext, GaInviteLockActivity.class);
      paramContext.addFlags(268435456);
      a(paramContext, paramString);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      QLog.i("QAVNotificationUtil", 1, "getGroupInviteIntent error", paramContext);
    }
    return null;
  }
  
  public static String a(VideoPackageUtils.VideoPacket paramVideoPacket)
  {
    long l = paramVideoPacket.l;
    int i = paramVideoPacket.k;
    if ((i != 4) && (i != 5)) {
      switch (i)
      {
      default: 
        return String.valueOf(l);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramVideoPacket.b);
    localStringBuilder.append(paramVideoPacket.a);
    return localStringBuilder.toString();
  }
  
  public static void a(Intent paramIntent, SessionInfo paramSessionInfo)
  {
    long l;
    try
    {
      l = Long.parseLong(paramSessionInfo.aW);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      l = 0L;
    }
    paramIntent.putExtra("uinType", paramSessionInfo.p);
    paramIntent.putExtra("peerUin", paramSessionInfo.aW);
    paramIntent.putExtra("friendUin", l);
    paramIntent.putExtra("relationType", paramSessionInfo.aQ);
    paramIntent.putExtra("MultiAVType", paramSessionInfo.o);
    paramIntent.putExtra("discussId", paramSessionInfo.aN);
    paramIntent.putExtra("memberList", paramSessionInfo.aO);
  }
  
  public static void a(String paramString1, String paramString2, VideoAppInterface paramVideoAppInterface, VideoPackageUtils.VideoPacket paramVideoPacket)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showInviteNotification videoPacket[");
      ((StringBuilder)localObject).append(paramVideoPacket);
      ((StringBuilder)localObject).append("], session[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("], from[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("]");
      QLog.i("CompatModeTag", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = String.valueOf(paramVideoPacket.h);
    int i = a(paramVideoAppInterface, paramVideoPacket.k, (String)localObject, 0);
    String str = a(paramVideoPacket);
    boolean bool;
    if (paramVideoPacket.i == 1) {
      bool = true;
    } else {
      bool = false;
    }
    int j = paramVideoPacket.f;
    try
    {
      if (!paramVideoAppInterface.b().a(i, (String)localObject, str, null, bool, null, 0, j))
      {
        QLog.w("CompatModeTag", 1, "showNotification() return ! isRequestVideo = false");
        return;
      }
      QAVNotification localQAVNotification = QAVNotification.a(paramVideoAppInterface);
      Bitmap localBitmap = paramVideoAppInterface.a(i, (String)localObject, str, true, true);
      paramString1 = paramVideoAppInterface.a(i, (String)localObject, str);
      if (AVUtil.b())
      {
        if (bool) {
          localQAVNotification.a(true, paramString2, paramString1, localBitmap, null, 45, i, 1, null);
        } else {
          localQAVNotification.a(true, paramString2, paramString1, localBitmap, null, 40, i, 2, null);
        }
      }
      else
      {
        j = i;
        if (bool) {
          localQAVNotification.a(false, paramString2, paramString1, localBitmap, null, 45, j, 1);
        } else {
          localQAVNotification.a(false, paramString2, paramString1, localBitmap, null, 40, j, 2);
        }
      }
      if (QLog.isColorLevel())
      {
        paramVideoAppInterface = new StringBuilder(200);
        paramVideoAppInterface.append("showNotification, isAudioMode=");
        paramVideoAppInterface.append(bool);
        paramVideoAppInterface.append(", sessionId=");
        paramVideoAppInterface.append(paramString2);
        paramVideoAppInterface.append(", uinType=");
        paramVideoAppInterface.append(i);
        paramVideoAppInterface.append(", peerUin=");
        paramVideoAppInterface.append((String)localObject);
        paramVideoAppInterface.append(", extraUin=");
        paramVideoAppInterface.append(str);
        paramVideoAppInterface.append(", face=");
        paramVideoAppInterface.append(localBitmap);
        paramVideoAppInterface.append(", peerName=");
        paramVideoAppInterface.append(paramString1);
        paramVideoAppInterface.append(", videoPacket=");
        paramVideoAppInterface.append(paramVideoPacket);
        QLog.i("CompatModeTag", 2, paramVideoAppInterface.toString());
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.w("CompatModeTag", 1, "showNotification() return ! Exception = ", paramString1);
    }
  }
  
  public static boolean a(Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringExtra("Fromwhere");
    } else {
      paramIntent = null;
    }
    return (paramIntent != null) && (paramIntent.compareTo("AVNotification") == 0);
  }
  
  public static Intent b(Context paramContext, String paramString)
  {
    paramContext = new Intent(paramContext, MultiIncomingCallsActivity.class);
    if (TextUtils.isEmpty(paramString)) {
      return paramContext;
    }
    paramString = SessionMgr.a().d(paramString);
    if (paramString == null) {
      return paramContext;
    }
    paramContext.putExtra("sessionType", paramString.g);
    if (AVUtil.e(paramString.p))
    {
      a(paramContext, paramString);
      return paramContext;
    }
    b(paramContext, paramString);
    return paramContext;
  }
  
  public static void b(Intent paramIntent, SessionInfo paramSessionInfo)
  {
    paramIntent.putExtra("uinType", paramSessionInfo.p);
    paramIntent.putExtra("relationType", UITools.b(paramSessionInfo.p));
    paramIntent.putExtra("peerUin", paramSessionInfo.s);
    paramIntent.putExtra("extraUin", paramSessionInfo.u);
    paramIntent.putExtra("isAudioMode", paramSessionInfo.aK);
    paramIntent.putExtra("isDoubleVideoMeeting", paramSessionInfo.am);
    paramIntent.putExtra("bindType", paramSessionInfo.az);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.QAVNotificationUtil
 * JD-Core Version:    0.7.0.1
 */