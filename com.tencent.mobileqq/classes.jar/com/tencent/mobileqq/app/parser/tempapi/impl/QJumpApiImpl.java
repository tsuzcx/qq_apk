package com.tencent.mobileqq.app.parser.tempapi.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.parser.tempapi.IQJumpApi;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.nearby.gameroom.GameRoomUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qqprotect.qsec.QSecFramework;
import mqq.app.AppRuntime;

public class QJumpApiImpl
  implements IQJumpApi
{
  public static final String REPORT_INVALID = "-1";
  public static QQMapActivityProxy mQQMapActivityProxy;
  
  public boolean backToFileScheme()
  {
    return ForwardUtils.b();
  }
  
  public void buildMapActivityProxy(String paramString)
  {
    if (mQQMapActivityProxy == null) {
      mQQMapActivityProxy = new QQMapActivityProxy(paramString);
    }
  }
  
  public void checkDevLockStatus(QBaseActivity paramQBaseActivity)
  {
    EquipmentLockImpl.a().a((QQAppInterface)paramQBaseActivity.getAppRuntime(), paramQBaseActivity.getAppRuntime().getCurrentAccountUin(), ((JumpActivity)paramQBaseActivity).mWtLoginObserver);
  }
  
  public void devlockUpdate(byte[] paramArrayOfByte)
  {
    DevlockPhoneStatus.a().a(paramArrayOfByte);
  }
  
  public String forwardGetFilePath(Context paramContext, Uri paramUri)
  {
    return ForwardFileOption.a(paramContext, paramUri);
  }
  
  public boolean gestureGetJumpLock(Context paramContext, String paramString)
  {
    return GesturePWDUtils.getJumpLock(paramContext, paramString);
  }
  
  public String getSecurityVerifyPluginDataKey()
  {
    return "extra_data";
  }
  
  public void handleByColorNote()
  {
    ((IColorNoteController)QRoute.api(IColorNoteController.class)).setSmallScreenShouldShow(false, 0);
  }
  
  public void handleStartGroupAudio(QBaseActivity paramQBaseActivity, String paramString)
  {
    QJumpApiImpl.1 local1 = new QJumpApiImpl.1(this, paramQBaseActivity);
    if (ChatActivityUtils.a((QQAppInterface)paramQBaseActivity.getAppRuntime(), paramQBaseActivity, 3000, paramString, true, true, local1, null)) {
      paramQBaseActivity.finish();
    }
  }
  
  public void nearByEnterNewGame(Context paramContext)
  {
    GameRoomUtils.a(paramContext, 16);
  }
  
  public String parseJumpActionName(AppRuntime paramAppRuntime, Context paramContext, String paramString)
  {
    paramAppRuntime = JumpParser.a((QQAppInterface)paramAppRuntime, paramContext, paramString);
    if (paramAppRuntime == null) {
      return "-1";
    }
    return paramAppRuntime.e;
  }
  
  public String parseJumpServerName(AppRuntime paramAppRuntime, Context paramContext, String paramString)
  {
    paramAppRuntime = JumpParser.a((QQAppInterface)paramAppRuntime, paramContext, paramString);
    if (paramAppRuntime == null) {
      return "-1";
    }
    return paramAppRuntime.d;
  }
  
  public Boolean qserIsOn()
  {
    return QSecFramework.c().a(1003);
  }
  
  public void qzoneLaunchForPreview(Context paramContext, Bundle paramBundle)
  {
    StoryPublishLauncher.a().b(paramContext, paramBundle);
  }
  
  public void releaseMapActivityProxy()
  {
    if (mQQMapActivityProxy != null) {
      mQQMapActivityProxy = null;
    }
  }
  
  public void startForwardActivity(Context paramContext, Intent paramIntent)
  {
    ForwardBaseOption.a(paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.tempapi.impl.QJumpApiImpl
 * JD-Core Version:    0.7.0.1
 */