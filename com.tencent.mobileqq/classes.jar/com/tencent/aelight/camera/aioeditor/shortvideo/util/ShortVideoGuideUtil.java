package com.tencent.aelight.camera.aioeditor.shortvideo.util;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.api.IQIMWebEffectUnit;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.QLog;

public class ShortVideoGuideUtil
{
  public static String a = "ShortVideoGuideUtil";
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startPTVActivity , supportVideo:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", supportPhoto:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", cameraMode:");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(", beauty:");
      localStringBuilder.append(paramString4);
      localStringBuilder.append(", unfoldDDStr:");
      localStringBuilder.append(paramString6);
      localStringBuilder.append(", dDItemID:");
      localStringBuilder.append(paramString7);
      localStringBuilder.append(", entranceType=");
      localStringBuilder.append(paramInt);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    boolean bool1 = "1".equals(paramString1);
    boolean bool2 = "1".equals(paramString2);
    int i;
    if ("1".equals(paramString3)) {
      i = 2;
    } else {
      i = 1;
    }
    boolean bool3 = "1".equals(paramString4);
    boolean bool4 = "1".equals(paramString5);
    boolean bool5 = "1".equals(paramString8);
    boolean bool6 = "1".equals(paramString6);
    if (!((ICaptureUtil)QRoute.api(ICaptureUtil.class)).supportCapture())
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "supportMediaCodec = false");
      }
      return false;
    }
    paramString1 = ((IQIMWebEffectUnit)QRoute.api(IQIMWebEffectUnit.class)).generateArgs(bool1, bool2, i, bool3, bool4, bool6, paramString7, bool5, paramInt);
    paramString2 = new Intent(paramActivity, StoryTransitionActivity.class);
    paramString2.putExtras(paramString1);
    paramString2.putExtra("jump_action", 7);
    paramActivity.startActivity(paramString2);
    return true;
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    if (VideoEnvironment.getShortVideoSoLibName() == null) {
      return false;
    }
    if (!ShortVideoUtils.isVideoSoLibLoaded()) {
      if (ShortVideoUtils.checkShortVideoSoReadyToLoad(paramAppInterface)) {
        ThreadManager.excute(new ShortVideoGuideUtil.1(), 64, null, false);
      } else {
        return false;
      }
    }
    if (((IAEResUtil)QRoute.api(IAEResUtil.class)).isLightCameraBaseResNotAllExist()) {
      return false;
    }
    if (!GestureMgr.a().a()) {
      return false;
    }
    return PtvFilterSoLoad.a() != 2;
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    if (VideoEnvironment.getShortVideoSoLibName() == null) {
      return false;
    }
    if (!ShortVideoUtils.isVideoSoLibLoaded())
    {
      VideoEnvironment.loadAVCodecSo();
      if (!ShortVideoUtils.isVideoSoLibLoaded()) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.util.ShortVideoGuideUtil
 * JD-Core Version:    0.7.0.1
 */