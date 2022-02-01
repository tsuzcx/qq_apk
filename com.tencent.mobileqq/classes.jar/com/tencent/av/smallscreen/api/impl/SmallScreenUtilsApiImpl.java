package com.tencent.av.smallscreen.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.config.ConfigManager;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.smallscreen.api.ISmallScreenUtilsApi;
import com.tencent.av.smallscreen.config.SmallScreenConfigParser;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.SeqUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class SmallScreenUtilsApiImpl
  implements ISmallScreenUtilsApi
{
  private static final String TAG = "SmallScreenUtilsApiImpl";
  
  static SmallScreenConfigParser getSmallScreenConfigParser()
  {
    IConfigParser localIConfigParser = ConfigManager.c(BaseApplicationImpl.getContext());
    if (!localIConfigParser.isEmpty())
    {
      SmallScreenConfigParser localSmallScreenConfigParser = new SmallScreenConfigParser();
      if (!localSmallScreenConfigParser.a(localIConfigParser)) {
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getSmallScreenConfigParser --> parseConfig fail");
      }
      return localSmallScreenConfigParser;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getSmallScreenConfigParser --> Can not get PlayLoad Config");
    }
    return null;
  }
  
  public static void reportActionOn(Context paramContext, SessionInfo paramSessionInfo)
  {
    int i = paramSessionInfo.g;
    int j = paramSessionInfo.aQ;
    int k = paramSessionInfo.i;
    if (QLog.isColorLevel())
    {
      paramSessionInfo = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportActionOn sessionType = ");
      localStringBuilder.append(i);
      QLog.d(paramSessionInfo, 2, localStringBuilder.toString());
      paramSessionInfo = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportActionOn relationType = ");
      localStringBuilder.append(j);
      QLog.d(paramSessionInfo, 2, localStringBuilder.toString());
      paramSessionInfo = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportActionOn state = ");
      localStringBuilder.append(k);
      QLog.d(paramSessionInfo, 2, localStringBuilder.toString());
    }
    paramSessionInfo = null;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i == 4)
          {
            if (j == 1) {
              break label181;
            }
            if (j != 2) {
              break label266;
            }
          }
        }
      }
    }
    for (;;)
    {
      paramSessionInfo = "0X80057DF";
      continue;
      label181:
      paramSessionInfo = "0X80057E0";
      continue;
      if (j != 1)
      {
        if (j == 2) {
          paramSessionInfo = "0X8005A45";
        }
      }
      else
      {
        paramSessionInfo = "0X8005A46";
        continue;
        if (k != 1)
        {
          if (k == 4) {
            paramSessionInfo = "0X80057DD";
          }
        }
        else
        {
          paramSessionInfo = "0X80057DE";
          continue;
          if (k != 1)
          {
            if (k == 4) {
              paramSessionInfo = "0X8005A43";
            }
          }
          else {
            paramSessionInfo = "0X8005A44";
          }
        }
      }
    }
    label266:
    if ((paramSessionInfo != null) && (SmallScreenUtils.c(paramContext))) {
      ReportController.b(null, "CliOper", "", "", paramSessionInfo, paramSessionInfo, 0, 0, "", "", "", "");
    }
  }
  
  public void actionOff(long paramLong, int paramInt, Context paramContext)
  {
    Object localObject = VideoController.f();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt == 2)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 21)
      {
        bool1 = bool2;
        if (((VideoController)localObject).aE().e()) {
          bool1 = true;
        }
      }
    }
    localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo actionOff, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], isNeedBlock[");
    localStringBuilder.append(bool1);
    localStringBuilder.append("], actionOffFrom[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (bool1) {
      return;
    }
    localObject = new Intent(paramContext, SmallScreenService.class);
    try
    {
      paramContext.stopService((Intent)localObject);
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel())
      {
        localObject = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("actionOff e = ");
        localStringBuilder.append(paramContext);
        QLog.e((String)localObject, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void actionOn(long paramLong, int paramInt, Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Object localObject1 = new Intent(paramContext, SmallScreenService.class);
    try
    {
      paramContext.stopService((Intent)localObject1);
      paramContext.startService((Intent)localObject1);
      localObject1 = BaseApplicationImpl.getContext();
      try
      {
        if (isLock((Context)localObject1)) {
          break label105;
        }
        VideoNodeManager.a(32);
      }
      catch (Exception localException1) {}
      if (!QLog.isColorLevel()) {
        break label105;
      }
    }
    catch (Exception localException2) {}
    Object localObject2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("actionOn e = ");
    localStringBuilder.append(localException2);
    QLog.d((String)localObject2, 2, localStringBuilder.toString());
    label105:
    if (AudioHelper.e())
    {
      String str = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("avideo actionOn isFloatWindowOpAllowed, isFloatWindowOpAllowed[");
      ((StringBuilder)localObject2).append(SmallScreenUtils.c(paramContext));
      ((StringBuilder)localObject2).append("], isCalling[");
      ((StringBuilder)localObject2).append(PhoneStatusTools.e(paramContext));
      ((StringBuilder)localObject2).append("], isHome[");
      ((StringBuilder)localObject2).append(SmallScreenUtils.a(paramContext));
      ((StringBuilder)localObject2).append("], isNeedStartDialog[");
      ((StringBuilder)localObject2).append(paramBoolean1);
      ((StringBuilder)localObject2).append("], actionOnFrom[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.w(str, 1, ((StringBuilder)localObject2).toString());
    }
    if (SmallScreenUtils.a(paramContext, paramBoolean1, paramString, paramBoolean2)) {
      ReportController.b(null, "CliOper", "", "", "0X80057D8", "0X80057D8", 0, 0, "", "", "", "");
    }
  }
  
  public int getFinishAnimId(int paramInt)
  {
    int i = 2130772278;
    switch (paramInt)
    {
    default: 
      return 2130772278;
    case 10: 
      return 2130772277;
    case 8: 
      return 2130772279;
    case 7: 
      return 2130772281;
    case 6: 
      return 2130772280;
    case 5: 
      return 2130772272;
    case 4: 
      return 2130772273;
    case 3: 
      return 2130772274;
    case 2: 
      return 2130772276;
    case 1: 
      i = 2130772275;
    }
    return i;
  }
  
  public boolean isLock(Context paramContext)
  {
    boolean bool3 = VideoController.a(paramContext);
    boolean bool1 = Build.MANUFACTURER.equals("Xiaomi");
    boolean bool2 = false;
    int i;
    if (((!bool1) || (!Build.MODEL.equals("HM NOTE 1TD"))) && (!Build.MODEL.equals("MI 3C")) && (!Build.MODEL.equals("HM NOTE 1S"))) {
      i = 0;
    } else {
      i = 1;
    }
    bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (i == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isSupportSmallScreen()
  {
    boolean bool1 = ConfigSystemImpl.b();
    boolean bool2 = false;
    Object localObject;
    if (!bool1)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.e(TAG, 2, "isSupportSmallScreen --> Small Screen Switch Is Closed");
        bool1 = bool2;
      }
    }
    else
    {
      localObject = getSmallScreenConfigParser();
      if (localObject != null)
      {
        bool1 = bool2;
        if (((SmallScreenConfigParser)localObject).b > 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportSmallScreen result = ");
      localStringBuilder.append(bool1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public boolean isSupportSmallScreenAudio()
  {
    boolean bool1 = ConfigSystemImpl.b();
    boolean bool2 = false;
    Object localObject;
    if (!bool1)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.e(TAG, 2, "isSupportSmallScreenAudio --> Small Screen Switch Is Closed");
        bool1 = bool2;
      }
    }
    else
    {
      localObject = getSmallScreenConfigParser();
      if (localObject != null)
      {
        bool1 = bool2;
        if (((SmallScreenConfigParser)localObject).e > 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportSmallScreenAudio result = ");
      localStringBuilder.append(bool1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public boolean isSupportSmallScreenVideo()
  {
    boolean bool1 = ConfigSystemImpl.b();
    boolean bool2 = false;
    Object localObject;
    if (!bool1)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.e(TAG, 2, "isSupportSmallScreenVideo --> Small Screen Switch Is Closed");
        bool1 = bool2;
      }
    }
    else
    {
      localObject = getSmallScreenConfigParser();
      if (localObject != null)
      {
        bool1 = bool2;
        if (((SmallScreenConfigParser)localObject).d > 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportSmallScreenVideo result = ");
      localStringBuilder.append(bool1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public boolean sendSmallScreenStateBroadcast(long paramLong, BaseVideoAppInterface paramBaseVideoAppInterface, int paramInt)
  {
    boolean bool1 = paramBaseVideoAppInterface instanceof VideoAppInterface;
    boolean bool2 = false;
    if (bool1)
    {
      Object localObject1 = (VideoAppInterface)paramBaseVideoAppInterface;
      SmallScreenService.p = false;
      bool1 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        if (((VideoAppInterface)localObject1).getApplication() != null)
        {
          bool1 = bool2;
          if (((VideoAppInterface)localObject1).getApp() != null)
          {
            bool1 = bool2;
            if (((VideoAppInterface)localObject1).b() != null)
            {
              bool1 = bool2;
              if (((VideoAppInterface)localObject1).b().k() != null)
              {
                Object localObject2 = ((VideoAppInterface)localObject1).b().k();
                paramBaseVideoAppInterface = ((SessionInfo)localObject2).s;
                if ((((SessionInfo)localObject2).g == 3) || (((SessionInfo)localObject2).g == 4)) {
                  paramBaseVideoAppInterface = String.valueOf(((SessionInfo)localObject2).aN);
                }
                localObject2 = new Intent("tencent.video.v2q.SmallScreenState");
                ((Intent)localObject2).setPackage(((VideoAppInterface)localObject1).getApplication().getPackageName());
                ((Intent)localObject2).putExtra("SmallScreenState", paramInt);
                SeqUtil.a((Intent)localObject2, paramLong);
                ((Intent)localObject2).putExtra("uin", paramBaseVideoAppInterface);
                ((VideoAppInterface)localObject1).getApp().sendBroadcast((Intent)localObject2);
                if (QLog.isDevelopLevel())
                {
                  paramBaseVideoAppInterface = TAG;
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("sendSmallScreenStateBroadcast, state[");
                  ((StringBuilder)localObject1).append(paramInt);
                  ((StringBuilder)localObject1).append("], seq[");
                  ((StringBuilder)localObject1).append(paramLong);
                  ((StringBuilder)localObject1).append("]");
                  QLog.w(paramBaseVideoAppInterface, 1, ((StringBuilder)localObject1).toString());
                }
                bool1 = true;
              }
            }
          }
        }
      }
      return bool1;
    }
    QLog.e(TAG, 1, "invalid BaseVideoAppInterface");
    return false;
  }
  
  public void startSetVisibleAnimation(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramView != null)
    {
      Object localObject1 = paramView.getTag(2131440991);
      int i = 0;
      boolean bool;
      if (localObject1 == null) {
        bool = false;
      } else {
        bool = ((Boolean)localObject1).booleanValue();
      }
      if ((paramBoolean2) && (bool))
      {
        localObject1 = paramView.getTag(2131440992);
        if (localObject1 == null) {
          bool = false;
        } else {
          bool = ((Boolean)localObject1).booleanValue();
        }
        if ((paramView.getVisibility() == 0) && (bool)) {
          bool = true;
        } else {
          bool = false;
        }
        if (bool != paramBoolean1)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = TAG;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("startSetVisibleAnimation isVisible = ");
            ((StringBuilder)localObject2).append(paramBoolean1);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          }
          Object localObject2 = new AnimationSet(true);
          if (paramBoolean1) {
            localObject1 = new AlphaAnimation(0.0F, 1.0F);
          } else {
            localObject1 = new AlphaAnimation(1.0F, 0.0F);
          }
          ((AlphaAnimation)localObject1).setDuration(400L);
          ((AnimationSet)localObject2).addAnimation((Animation)localObject1);
          ((AnimationSet)localObject2).setAnimationListener(new SmallScreenUtilsApiImpl.1(this, paramView, paramBoolean1));
          paramView.startAnimation((Animation)localObject2);
          paramView.setVisibility(0);
        }
      }
      else
      {
        paramView.clearAnimation();
        if (!paramBoolean1) {
          i = 8;
        }
        paramView.setVisibility(i);
      }
      paramView.setTag(2131440992, Boolean.valueOf(paramBoolean1));
      paramView.setTag(2131440991, Boolean.valueOf(paramBoolean2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.api.impl.SmallScreenUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */