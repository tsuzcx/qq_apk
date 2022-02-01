package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.av.AVLog;
import com.tencent.av.QavChannelProxy;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.AbstractOrientationEventListener;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import mqq.app.AppRuntime;

public class SmallScreenVideoController
  implements SmallScreenVideoLayerUI.SmallScreenListener
{
  int jdField_a_of_type_Int = -1;
  Context jdField_a_of_type_AndroidContentContext = null;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  Display jdField_a_of_type_AndroidViewDisplay = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  CameraObserver jdField_a_of_type_ComTencentAvCameraCameraObserver = new SmallScreenVideoController.2(this);
  ICameraManagerApi jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi;
  SmallScreenService jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService;
  SmallScreenVideoControlUI jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI;
  SmallScreenVideoController.MyVideoObserver jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver = new SmallScreenVideoController.MyVideoObserver(this);
  SmallScreenVideoLayerUI jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI;
  AbstractOrientationEventListener jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener = null;
  ControlUIObserver jdField_a_of_type_ComTencentAvUiControlUIObserver = new SmallScreenVideoController.MyControlUIObserver(this);
  String jdField_a_of_type_JavaLangString = null;
  Timer jdField_a_of_type_JavaUtilTimer = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 1;
  String jdField_b_of_type_JavaLangString = null;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  String jdField_c_of_type_JavaLangString = null;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = -1;
  boolean jdField_e_of_type_Boolean = false;
  int f;
  int g = 0;
  
  SmallScreenVideoController(SmallScreenService paramSmallScreenService)
  {
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService = paramSmallScreenService;
    this.jdField_a_of_type_AndroidContentContext = paramSmallScreenService.getApplicationContext();
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.getSystemService("window")).getDefaultDisplay();
  }
  
  public static void a(Context paramContext, VideoController paramVideoController)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "enterVideo start");
    }
    if ((paramContext != null) && (paramVideoController != null)) {
      if (MultiIncomingCallsActivity.jdField_e_of_type_Boolean)
      {
        paramVideoController = new Intent(paramContext, MultiIncomingCallsActivity.class);
        paramVideoController.addFlags(262144);
        paramVideoController.addFlags(268435456);
        paramVideoController.addFlags(4194304);
        try
        {
          paramContext.startActivity(paramVideoController);
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel())
          {
            paramVideoController = new StringBuilder();
            paramVideoController.append("enterVideo e = ");
            paramVideoController.append(paramContext);
            QLog.e("SmallScreenVideoController", 2, paramVideoController.toString());
          }
        }
      }
    }
    for (;;)
    {
      break;
      Object localObject = paramVideoController.a();
      int i = ((SessionInfo)localObject).jdField_d_of_type_Int;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("enterVideo sessionType =");
        localStringBuilder.append(i);
        QLog.d("SmallScreenVideoController", 2, localStringBuilder.toString());
      }
      if ((i != 1) && (i != 2))
      {
        long l = ((SessionInfo)localObject).jdField_f_of_type_Long;
        int j = ((SessionInfo)localObject).E;
        if (l != 0L)
        {
          paramVideoController = new Intent(paramContext, AVActivity.class);
          paramVideoController.addFlags(262144);
          paramVideoController.addFlags(268435456);
          paramVideoController.addFlags(4194304);
          paramVideoController.putExtra("GroupId", String.valueOf(l));
          paramVideoController.putExtra("Type", 2);
          paramVideoController.putExtra("sessionType", i);
          paramVideoController.putExtra("uinType", UITools.c(j));
          paramVideoController.putExtra("isDoubleVideoMeeting", ((SessionInfo)localObject).y);
          paramVideoController.putExtra("MultiAVType", ((SessionInfo)localObject).jdField_j_of_type_Int);
          paramVideoController.putExtra("Fromwhere", "SmallScreen");
          try
          {
            paramContext.startActivity(paramVideoController);
          }
          catch (Exception paramContext) {}
          if (QLog.isColorLevel())
          {
            paramVideoController = new StringBuilder();
            paramVideoController.append("enterVideo e = ");
            paramVideoController.append(paramContext);
            QLog.e("SmallScreenVideoController", 2, paramVideoController.toString());
          }
        }
        else if ((paramVideoController.e()) && (((SessionInfo)localObject).g()))
        {
          paramVideoController = new Intent(paramContext, VideoInviteActivity.class);
          paramVideoController.addFlags(268435456);
          paramVideoController.putExtra("uinType", ((SessionInfo)localObject).jdField_k_of_type_Int);
          paramVideoController.putExtra("peerUin", ((SessionInfo)localObject).jdField_c_of_type_JavaLangString);
          paramVideoController.putExtra("extraUin", ((SessionInfo)localObject).jdField_e_of_type_JavaLangString);
          boolean bool;
          if (((SessionInfo)localObject).jdField_e_of_type_Int == 1) {
            bool = true;
          } else {
            bool = false;
          }
          paramVideoController.putExtra("isAudioMode", bool);
          paramContext.startActivity(paramVideoController);
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("SmallScreenVideoController", 2, "enterVideo status error");
        }
      }
      else
      {
        paramVideoController = new Intent(paramContext, AVActivity.class);
        if (((SessionInfo)localObject).jdField_k_of_type_Int == 1011) {
          return;
        }
        paramVideoController.addFlags(262144);
        paramVideoController.addFlags(268435456);
        paramVideoController.addFlags(4194304);
        if (((SessionInfo)localObject).y)
        {
          ((SessionInfo)localObject).jdField_k_of_type_Int = 0;
          paramVideoController.putExtra("sessionType", ((SessionInfo)localObject).jdField_d_of_type_Int);
          paramVideoController.putExtra("GroupId", ((SessionInfo)localObject).jdField_c_of_type_JavaLangString);
          paramVideoController.putExtra("uin", ((SessionInfo)localObject).jdField_c_of_type_JavaLangString);
          paramVideoController.putExtra("isDoubleVideoMeeting", true);
          paramVideoController.putExtra("uinType", ((SessionInfo)localObject).jdField_k_of_type_Int);
          try
          {
            paramContext.startActivity(paramVideoController);
          }
          catch (Exception paramContext)
          {
            if (!QLog.isColorLevel()) {
              break label667;
            }
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("enterVideo e = ");
          ((StringBuilder)localObject).append(paramContext);
          QLog.e("SmallScreenVideoController", 2, ((StringBuilder)localObject).toString());
        }
        else
        {
          paramVideoController.putExtra("sessionType", i);
          paramVideoController.putExtra("uin", ((SessionInfo)localObject).jdField_c_of_type_JavaLangString);
        }
        try
        {
          paramContext.startActivity(paramVideoController);
        }
        catch (Exception paramContext)
        {
          label667:
          while (!QLog.isColorLevel()) {}
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("enterVideo e = ");
          ((StringBuilder)localObject).append(paramContext);
          QLog.e("SmallScreenVideoController", 2, ((StringBuilder)localObject).toString());
        }
        paramVideoController.putExtra("Fromwhere", "SmallScreen");
        break;
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenVideoController", 2, "enterVideo context or controller is null.");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "enterVideo end");
    }
  }
  
  private void a(SessionInfo paramSessionInfo)
  {
    int i = this.jdField_c_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if ((i != 3) && (i != 4)) {
            return;
          }
          if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) {
            if (this.jdField_d_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
              if (paramSessionInfo != null)
              {
                this.jdField_c_of_type_Int = paramSessionInfo.jdField_d_of_type_Int;
                this.jdField_d_of_type_Int = paramSessionInfo.jdField_e_of_type_Int;
              }
            }
            else
            {
              if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 2)
              {
                this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
                return;
              }
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
            }
          }
        }
        else if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
          if (paramSessionInfo != null)
          {
            this.jdField_c_of_type_Int = paramSessionInfo.jdField_d_of_type_Int;
            this.jdField_d_of_type_Int = paramSessionInfo.jdField_e_of_type_Int;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenDoubleVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
        }
      }
      else if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) {
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
          if (paramSessionInfo != null)
          {
            this.jdField_c_of_type_Int = paramSessionInfo.jdField_d_of_type_Int;
            this.jdField_d_of_type_Int = paramSessionInfo.jdField_e_of_type_Int;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenDoubleVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
        }
      }
    }
    else if ((paramSessionInfo != null) && (paramSessionInfo.jdField_e_of_type_Boolean) && ((paramSessionInfo.jdField_f_of_type_Int == 1) || (paramSessionInfo.jdField_f_of_type_Int == 2))) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenDoubleVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
    }
  }
  
  private void b(int paramInt)
  {
    long l = AudioHelper.b();
    if (AudioHelper.b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeVideoLayoutMode, mode[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], mVideoLayerUI[");
      boolean bool;
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenVideoController", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI;
    if (localObject != null)
    {
      if (paramInt == ((SmallScreenVideoLayerUI)localObject).f()) {
        return;
      }
      if (paramInt == 1) {
        a(Integer.valueOf(6101), null, Boolean.valueOf(false));
      }
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.g(paramInt);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(l);
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new SmallScreenVideoController.3(this), 50L);
  }
  
  void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilTimer;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    localObject = new SmallScreenVideoController.1(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule((TimerTask)localObject, 1000L);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(paramInt);
  }
  
  void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy, mActivityState[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append("->");
      ((StringBuilder)localObject).append(0);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenVideoController", 1, ((StringBuilder)localObject).toString());
    }
    this.jdField_b_of_type_Int = 0;
    Object localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((SmallScreenService)localObject).a(1);
    }
    if (localObject != null)
    {
      localObject = ((SmallScreenRelativeLayout)localObject).findViewById(2013331470);
      if (localObject != null) {
        ((View)localObject).findViewById(2013331471).clearAnimation();
      }
    }
    localObject = this.jdField_a_of_type_JavaUtilTimer;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi;
    if (localObject != null)
    {
      ((ICameraManagerApi)localObject).deleteObserver(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
      this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI;
    if (localObject != null)
    {
      ((SmallScreenVideoLayerUI)localObject).p();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI;
    if (localObject != null)
    {
      ((SmallScreenVideoControlUI)localObject).a(paramLong);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null)
    {
      ((VideoAppInterface)localObject).b(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().e("SmallScreen.onDestroy", 0);
    }
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener = null;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver = null;
  }
  
  protected void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyEvent :");
    localStringBuilder.append(paramInteger);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject2);
    AVLog.printColorLog("SmallScreenVideoController", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  void a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof VideoAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onCreate");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)paramAppRuntime);
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController$MyVideoObserver);
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvQavChannelProxy.sendGetGatewayMsg();
      j();
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().a()) {
        i();
      }
      GraphicRenderMgr.getInstance();
      a(false);
    }
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((localObject1 != null) && (QLog.isColorLevel()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onCreateUI SessionType = ");
      ((StringBuilder)localObject2).append(((SessionInfo)localObject1).jdField_d_of_type_Int);
      QLog.d("SmallScreenVideoController", 2, ((StringBuilder)localObject2).toString());
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = UITools.a(this.jdField_a_of_type_AndroidContentContext, 2130842022);
    if (this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi == null)
    {
      this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi = CameraUtils.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.addObserver(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
      this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.setCameraListener(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvVideoCameraListener);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1);
    if (localObject2 == null)
    {
      QLog.w("SmallScreenVideoController", 2, "onCreateUI videoToastView == null");
      return;
    }
    localObject2 = ((SmallScreenRelativeLayout)localObject2).findViewById(2013331458);
    SmallScreenVideoLayerUI localSmallScreenVideoLayerUI = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI;
    if (localSmallScreenVideoLayerUI == null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI = new SmallScreenVideoLayerUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, (View)localObject2, this);
    } else {
      localSmallScreenVideoLayerUI.c();
    }
    a((SessionInfo)localObject1);
    localObject2 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI;
    if (localObject2 != null) {
      ((SmallScreenVideoControlUI)localObject2).a(paramBoolean);
    }
    if ((localObject1 != null) && (((SessionInfo)localObject1).jdField_f_of_type_Int != 4) && (this.jdField_c_of_type_Int == 1) && (!this.jdField_a_of_type_Boolean))
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
      int i = VipFunCallUtil.a((AppRuntime)localObject1, ((VideoAppInterface)localObject1).getAccount(), 6, true, null);
      if (i > 0)
      {
        int j = VipFunCallUtil.a();
        localObject1 = VipFunCallUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i, j, null);
        if ((localObject1 != null) && (new File((String)localObject1).exists()))
        {
          localObject1 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI;
          if (localObject1 != null) {
            ((SmallScreenVideoLayerUI)localObject1).v();
          }
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().ap) {
      return false;
    }
    if (this.jdField_a_of_type_Int == paramInt) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI;
    if ((localObject != null) && ((localObject instanceof SmallScreenDoubleVideoControlUI)))
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Remote not has video, nOff=");
        ((StringBuilder)localObject).append(paramInt);
        AVLog.printErrorLog("SmallScreenVideoController", ((StringBuilder)localObject).toString());
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setGlassSwitch nOff=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", prior=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("SmallScreenVideoController", 1, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentAvVideoController.a().P = paramInt;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              return true;
            }
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.m();
            this.jdField_a_of_type_ComTencentAvVideoController.a(1);
            return true;
          }
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.n();
          this.jdField_a_of_type_ComTencentAvVideoController.a(1);
          return true;
        }
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.m();
        this.jdField_a_of_type_ComTencentAvVideoController.a(0);
        return true;
      }
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.n();
      this.jdField_a_of_type_ComTencentAvVideoController.a(0);
      return true;
    }
    return false;
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onClick start");
    }
    a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvVideoController);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onClick end");
    }
  }
  
  void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.stopSelf();
    }
  }
  
  void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService;
    SmallScreenRelativeLayout localSmallScreenRelativeLayout = null;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((SmallScreenService)localObject).a(1);
    }
    SmallScreenService localSmallScreenService = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService;
    if (localSmallScreenService != null) {
      localSmallScreenRelativeLayout = localSmallScreenService.a(1);
    }
    if ((this.jdField_b_of_type_Boolean) && (localObject != null) && (((SmallScreenToast)localObject).b()) && (localSmallScreenRelativeLayout != null) && (localSmallScreenRelativeLayout.getVisibility() != 8))
    {
      localSmallScreenRelativeLayout.e();
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService;
    if (localObject != null) {
      ((SmallScreenService)localObject).stopSelf();
    }
  }
  
  public void e()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(">>>onStart(), ts=");
      ((StringBuilder)localObject).append(l1);
      QLog.d("IVR_TS_SmallScreenVideoController", 4, ((StringBuilder)localObject).toString());
    }
    this.jdField_b_of_type_Int = 3;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onStart");
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI;
    if (localObject != null) {
      ((SmallScreenVideoControlUI)localObject).b();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<<<onStart(), ts=");
      ((StringBuilder)localObject).append(l2);
      QLog.d("IVR_TS_SmallScreenVideoController", 4, ((StringBuilder)localObject).toString());
      QLog.d("IVR_TS_SmallScreenVideoController", 4, String.format("onStart(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
  
  public void f()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 5;
    long l2 = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume, seq[");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenVideoController", 1, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new SmallScreenVideoController.OnResumeRunnable(this, l2), 200L);
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().j())
      {
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
        bool1 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Boolean;
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a((String)localObject, 1, bool1, false, this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_JavaLangString));
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b()))
        {
          this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.openCamera(l2);
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(true, false);
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.c(l2, this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.isFrontCamera());
        }
      }
      else if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().Y) && (!this.jdField_c_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().b(l2, true);
        this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.openCamera(l2);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(true, false);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.c(l2, this.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.isFrontCamera());
      }
    }
    else if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
    {
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList;
      int i = 0;
      while (i < ((ArrayList)localObject).size())
      {
        VideoViewInfo localVideoViewInfo = (VideoViewInfo)((ArrayList)localObject).get(i);
        String str = String.valueOf(localVideoViewInfo.jdField_a_of_type_Long);
        int j = localVideoViewInfo.jdField_a_of_type_Int;
        boolean bool2 = localVideoViewInfo.jdField_a_of_type_Boolean;
        boolean bool3 = localVideoViewInfo.jdField_b_of_type_Boolean;
        if ((localVideoViewInfo.jdField_b_of_type_Long != 5L) && (localVideoViewInfo.jdField_b_of_type_Long != 14L)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        if ((!str.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) && (bool3)) {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(str, j, bool3, bool2, bool1);
        }
        i += 1;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI;
    if (localObject != null) {
      ((SmallScreenVideoLayerUI)localObject).B_();
    }
    localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI;
    if (localObject != null) {
      ((SmallScreenVideoControlUI)localObject).e();
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(false);
    k();
    l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<<<onResume(), ts=");
      ((StringBuilder)localObject).append(l2);
      QLog.d("IVR_TS_SmallScreenVideoController", 4, ((StringBuilder)localObject).toString());
      QLog.d("IVR_TS_SmallScreenVideoController", 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
  
  protected void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onPause");
    }
    l();
    this.jdField_b_of_type_Int = 4;
    Object localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI;
    if (localObject != null) {
      ((SmallScreenVideoLayerUI)localObject).w();
    }
    localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI;
    if (localObject != null) {
      ((SmallScreenVideoControlUI)localObject).g();
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(true);
  }
  
  void h()
  {
    this.jdField_b_of_type_Int = 2;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onStop");
    }
    SmallScreenVideoControlUI localSmallScreenVideoControlUI = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI;
    if (localSmallScreenVideoControlUI != null) {
      localSmallScreenVideoControlUI.p();
    }
  }
  
  void i()
  {
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Int;
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().y;
    this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Int;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().A;
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().o;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean;
  }
  
  void j()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener == null) {
      this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener = new SmallScreenVideoController.VideoOrientationEventListener(this, this.jdField_a_of_type_AndroidContentContext, 2);
    }
  }
  
  void k()
  {
    AbstractOrientationEventListener localAbstractOrientationEventListener = this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener;
    if (localAbstractOrientationEventListener != null) {
      localAbstractOrientationEventListener.enable();
    }
  }
  
  void l()
  {
    AbstractOrientationEventListener localAbstractOrientationEventListener = this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener;
    if (localAbstractOrientationEventListener != null) {
      localAbstractOrientationEventListener.disable();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController
 * JD-Core Version:    0.7.0.1
 */