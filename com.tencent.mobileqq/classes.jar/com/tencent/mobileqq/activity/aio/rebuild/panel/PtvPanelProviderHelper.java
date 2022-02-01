package com.tencent.mobileqq.activity.aio.rebuild.panel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.image.AbstractVideoImage;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.OnActivityResultCallback;
import com.tencent.mobileqq.activity.aio.helper.ReplyHelper;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CheckPtvListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import dov.com.qq.im.ae.current.SessionWrap;

public class PtvPanelProviderHelper
  implements OnFinishListener, ILifeCycleHelper, OnActivityResultCallback, PanelProvider<View>, CheckPtvListener
{
  public static boolean a = false;
  private AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  public boolean b = false;
  public boolean c = false;
  
  public PtvPanelProviderHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramBaseChatPie.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private void a()
  {
    ((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(BaseApplicationImpl.getContext(), new PtvPanelProviderHelper.1(this), null);
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getIntent();
    if (localIntent != null)
    {
      String str = localIntent.getStringExtra("panel");
      if ((str != null) && (str.equals("ptv")))
      {
        a(false);
        localIntent.removeExtra("panel");
      }
    }
  }
  
  private void b()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = PermissionUtils.isStorePermissionEnable(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
    } else {
      bool = true;
    }
    if (!bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().requestPermissions(new PtvPanelProviderHelper.2(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    a(true);
  }
  
  public int a()
  {
    if (this.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvPanelProviderHelper", 2, "onBackEvent() disableBackForPTV true");
      }
      return 2;
    }
    return 0;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = (FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(24);
    BaseSessionInfo localBaseSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    int i = localBaseSessionInfo.jdField_a_of_type_Int;
    int j = 0;
    if ((i != 1033) && (localBaseSessionInfo.jdField_a_of_type_Int != 1034)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject2 = (ReplyHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(119);
    if ((((FullScreenInputHelper)localObject1).c()) && ((i != 0) || (((ReplyHelper)localObject2).a())))
    {
      ((FullScreenInputHelper)localObject1).a(true);
      return;
    }
    ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(128)).f();
    boolean bool;
    if ((paramBoolean) && (((FullScreenInputHelper)localObject1).c())) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doShowPtv clickAioPanel:");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(", fullMode:");
      ((StringBuilder)localObject2).append(((FullScreenInputHelper)localObject1).c());
      QLog.i("PtvPanelProviderHelper", 2, ((StringBuilder)localObject2).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().isUsingCameraOnVideo())
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131695889, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299168));
    }
    else if (((ICaptureUtil)QRoute.api(ICaptureUtil.class)).supportCapture())
    {
      localObject1 = StoryPublishLauncher.a(new SessionWrap(localBaseSessionInfo.jdField_a_of_type_JavaLangString, localBaseSessionInfo.d, localBaseSessionInfo.jdField_a_of_type_Int, localBaseSessionInfo.b), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getClass().getName(), 10000, 100);
      ((Bundle)localObject1).putInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.e.a());
      if (bool) {
        i = 200;
      } else {
        i = 205;
      }
      ((Bundle)localObject1).putInt("AECAMERA_MODE", i);
      ((Bundle)localObject1).putInt("qq_sub_business_id", 106);
      ((Bundle)localObject1).putBoolean("input_full_screen_mode", bool);
      StoryPublishLauncher.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), (Bundle)localObject1, 11);
      ((IAELaunchRecorder)QRoute.api(IAELaunchRecorder.class)).print(false);
      ((IAELaunchRecorder)QRoute.api(IAELaunchRecorder.class)).endSession();
    }
    else
    {
      if (localBaseSessionInfo.jdField_a_of_type_Int == 9501) {
        try
        {
          localObject1 = SmartDeviceProxyMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), Long.parseLong(localBaseSessionInfo.jdField_a_of_type_JavaLangString));
          i = j;
          if (localObject1 != null) {
            i = ((DeviceInfo)localObject1).productId;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e("PtvPanelProviderHelper", 1, localNumberFormatException, new Object[0]);
        }
      } else {
        i = 0;
      }
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), localBaseSessionInfo, i, 1);
    }
    AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), "0X8005E91", localBaseSessionInfo.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a() == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.f();
    }
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvPanelProviderHelper", 2, "leftBackEvent() disableBackForPTV true");
      }
      return true;
    }
    return false;
  }
  
  public View createPanel(Context paramContext)
  {
    return null;
  }
  
  public void d(int paramInt) {}
  
  public View getPanel()
  {
    return null;
  }
  
  public int getPanelId()
  {
    return 6;
  }
  
  @NonNull
  public String getTag()
  {
    return "PtvPanelProviderHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 10, 11, 15 };
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10012)
    {
      if ((paramIntent != null) && (paramIntent.getIntExtra("camera_type", -1) == 103)) {
        a(false);
      }
    }
    else if (paramInt1 == 11000)
    {
      this.b = false;
      this.c = false;
    }
  }
  
  public void onHideAllPanel() {}
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 4)
      {
        if (paramInt != 15)
        {
          if (paramInt != 10)
          {
            if (paramInt != 11) {
              return;
            }
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a()) {
              AbstractVideoImage.pauseAll();
            }
            ShortVideoPTVItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a);
            ShortVideoItemBuilder.e();
            ShortVideoRealItemBuilder.e();
            return;
          }
          a();
          return;
        }
        jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().setCheckPtvListener(null);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().setCheckPtvListener(this);
      return;
    }
    this.b = false;
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    b();
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.PtvPanelProviderHelper
 * JD-Core Version:    0.7.0.1
 */