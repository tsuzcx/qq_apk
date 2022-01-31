package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.ui.RedPacketGameSmallScreenView;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.AbstractOrientationEventListener;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import jqx;
import jqz;
import jra;
import jrb;
import jrc;
import jrd;
import jrf;
import mqq.app.AppRuntime;

public class SmallScreenVideoController
  implements SmallScreenVideoLayerUI.SmallScreenListener
{
  public int a;
  public Context a;
  public Bitmap a;
  public Display a;
  public VideoController a;
  public VideoAppInterface a;
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new jrd(this);
  CameraObserver jdField_a_of_type_ComTencentAvCameraCameraObserver = new jqz(this);
  public CameraUtils a;
  public SmallScreenService a;
  public SmallScreenVideoControlUI a;
  public SmallScreenVideoLayerUI a;
  public AbstractOrientationEventListener a;
  public ControlUIObserver a;
  public String a;
  public Timer a;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  String b;
  public boolean b;
  public int c;
  String c;
  public boolean c;
  public int d;
  public boolean d;
  int jdField_e_of_type_Int = 0;
  boolean jdField_e_of_type_Boolean = false;
  public int f = 0;
  
  SmallScreenVideoController(SmallScreenService paramSmallScreenService)
  {
    this.jdField_a_of_type_AndroidViewDisplay = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilTimer = null;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener = null;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = new jrc(this);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService = paramSmallScreenService;
    this.jdField_a_of_type_AndroidContentContext = paramSmallScreenService.getApplicationContext();
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.getSystemService("window")).getDefaultDisplay();
  }
  
  public static void a(ViewGroup paramViewGroup)
  {
    RedPacketGameSmallScreenView localRedPacketGameSmallScreenView = (RedPacketGameSmallScreenView)paramViewGroup.findViewById(2131362543);
    if (localRedPacketGameSmallScreenView != null)
    {
      localRedPacketGameSmallScreenView.a();
      paramViewGroup.removeView(localRedPacketGameSmallScreenView);
    }
  }
  
  private void c(int paramInt)
  {
    AVLog.c("SmallScreenVideoController", "onChangeUI_DobuleAudio2MultiAudio 33:" + paramInt + "|" + this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI);
    if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI == null) || (paramInt == this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a())) {
      return;
    }
    if (paramInt == 1) {
      a(Integer.valueOf(6101), null, Boolean.valueOf(false));
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.b(paramInt);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.f();
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jrb(this), 50L);
  }
  
  public RedPacketGameSmallScreenView a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    RedPacketGameSmallScreenView localRedPacketGameSmallScreenView = (RedPacketGameSmallScreenView)paramViewGroup.findViewById(2131362543);
    if (localRedPacketGameSmallScreenView == null)
    {
      localRedPacketGameSmallScreenView = new RedPacketGameSmallScreenView(paramViewGroup.getContext());
      paramViewGroup.addView(localRedPacketGameSmallScreenView, new ViewGroup.LayoutParams(-1, -1));
    }
    for (paramViewGroup = localRedPacketGameSmallScreenView;; paramViewGroup = localRedPacketGameSmallScreenView)
    {
      paramViewGroup.setAVRedPacketManager((AVRedPacketManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6), paramBoolean);
      return paramViewGroup;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    jqx localjqx = new jqx(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(localjqx, 1000L);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(paramInt);
  }
  
  protected void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    AVLog.c("SmallScreenVideoController", "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
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
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvVideoController.c();
      k();
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().T) {
        j();
      }
      GraphicRenderMgr.getInstance();
      a(false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((localObject != null) && (QLog.isColorLevel())) {
      QLog.d("SmallScreenVideoController", 2, "onCreateUI SessionType = " + ((SessionInfo)localObject).jdField_d_of_type_Int);
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = UITools.a(this.jdField_a_of_type_AndroidContentContext, 2130840115);
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvVideoController);
    }
    View localView = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131365830);
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI == null)
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI = new SmallScreenVideoLayerUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, localView, this);
      switch (this.jdField_c_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null)) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenDoubleVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      }
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramBoolean);
      }
      if ((localObject != null) && (((SessionInfo)localObject).jdField_g_of_type_Int != 4) && (this.jdField_c_of_type_Int == 1) && (!this.jdField_a_of_type_Boolean))
      {
        int i = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), 6, true, null);
        if (i > 0)
        {
          int j = VipFunCallManager.a();
          localObject = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i, j, null);
          if (localObject != null)
          {
            localObject = new File((String)localObject);
            if ((localObject != null) && (((File)localObject).exists()) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)) {
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.m();
            }
          }
        }
      }
      return;
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.w();
      break;
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) {
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
          if (localObject != null) {
            this.jdField_c_of_type_Int = ((SessionInfo)localObject).jdField_d_of_type_Int;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenDoubleVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
          continue;
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenDoubleVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
          continue;
          if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) {
            if (this.jdField_d_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
              if (localObject != null) {
                this.jdField_c_of_type_Int = ((SessionInfo)localObject).jdField_d_of_type_Int;
              }
            }
            else if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)
            {
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
            }
            else
            {
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
              continue;
              if ((localObject != null) && (((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0)) {
                if (((SessionInfo)localObject).jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 3) {
                  this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
                } else {
                  this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenDoubleVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onClick start");
    }
    Intent localIntent1;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (MultiIncomingCallsActivity.jdField_e_of_type_Boolean))
    {
      localIntent1 = new Intent(this.jdField_a_of_type_AndroidContentContext, MultiIncomingCallsActivity.class);
      localIntent1.addFlags(262144);
      localIntent1.addFlags(268435456);
      localIntent1.addFlags(4194304);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent1);
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenVideoController", 2, "onClick end");
        }
        label95:
        return;
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SmallScreenVideoController", 2, "onClick e = " + localException1);
        continue;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
        int i = localSessionInfo.jdField_d_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenVideoController", 2, "onClick sessionType =" + i);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean) {
          i = 1;
        }
        Intent localIntent2;
        if ((i == 1) || (i == 2))
        {
          localIntent2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
          if ((localSessionInfo.i != 1011) && (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean))
          {
            localIntent2.addFlags(262144);
            localIntent2.addFlags(268435456);
            localIntent2.addFlags(4194304);
            if (localSessionInfo.G)
            {
              localIntent2.putExtra("sessionType", 3);
              localIntent2.putExtra("GroupId", localSessionInfo.jdField_c_of_type_JavaLangString);
              localIntent2.putExtra("isDoubleVideoMeeting", true);
            }
            for (;;)
            {
              try
              {
                this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent2);
                localIntent2.putExtra("Fromwhere", "SmallScreen");
              }
              catch (Exception localException3)
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("SmallScreenVideoController", 2, "onClick e = " + localException3);
                continue;
              }
              localIntent2.putExtra("sessionType", i);
              localIntent2.putExtra("uin", localException3.jdField_c_of_type_JavaLangString);
              try
              {
                this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent2);
              }
              catch (Exception localException4) {}
              if (QLog.isColorLevel()) {
                QLog.e("SmallScreenVideoController", 2, "onClick e = " + localException4);
              }
            }
          }
        }
        else
        {
          long l = localException4.jdField_f_of_type_Long;
          int j = localException4.F;
          if ((l != 0L) || (localException4.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0))
          {
            if (localException4.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_b_of_type_Int > 0) {
              if (localException4.jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long <= 0L) {}
            }
            Intent localIntent3;
            for (localIntent2 = new Intent(this.jdField_a_of_type_AndroidContentContext, GuildMultiActivity.class);; localIntent3 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class))
            {
              for (;;)
              {
                localIntent2.addFlags(262144);
                localIntent2.addFlags(268435456);
                localIntent2.addFlags(4194304);
                localIntent2.putExtra("GroupId", String.valueOf(l));
                localIntent2.putExtra("Type", 2);
                localIntent2.putExtra("sessionType", i);
                localIntent2.putExtra("uinType", UITools.b(j));
                localIntent2.putExtra("isDoubleVideoMeeting", localException4.G);
                localIntent2.putExtra("MultiAVType", localException4.D);
                localIntent2.putExtra("Fromwhere", "SmallScreen");
                try
                {
                  this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent2);
                }
                catch (Exception localException2) {}
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("SmallScreenVideoController", 2, "onClick e = " + localException2);
              break;
              if ((localException4.jdField_d_of_type_Int == 1) || (localException4.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 1) || (localException4.jdField_d_of_type_Int == 3) || (localException4.jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.jdField_a_of_type_Int == 3) || (!QLog.isColorLevel())) {
                break label95;
              }
              QLog.e("SmallScreenVideoController", 2, "onClick status error");
              return;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.e("SmallScreenVideoController", 2, "onClick status error");
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("SmallScreenVideoController", 2, "onClick app is null");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().aA) {}
    while ((this.jdField_a_of_type_Int == paramInt) || (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) || (!(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI instanceof SmallScreenDoubleVideoControlUI))) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean)
    {
      AVLog.e("SmallScreenVideoController", "Remote not has video, nOff=" + paramInt);
      return;
    }
    QLog.d("SmallScreenVideoController", 1, "setGlassSwitch nOff=" + paramInt + ", prior=" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvVideoController.a().P = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.h();
      this.jdField_a_of_type_ComTencentAvVideoController.a(0);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.g();
      this.jdField_a_of_type_ComTencentAvVideoController.a(0);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.h();
      this.jdField_a_of_type_ComTencentAvVideoController.a(1);
      return;
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.g();
    this.jdField_a_of_type_ComTencentAvVideoController.a(1);
  }
  
  void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.stopSelf();
    }
  }
  
  public void d()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast != null) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenToast.b()) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout != null) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() != 8))
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.e();
      return;
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.stopSelf();
  }
  
  public void e()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenVideoController", 4, ">>>onStart(), ts=" + l1);
    }
    this.jdField_b_of_type_Int = 3;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onStart");
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      QLog.d("IVR_TS_SmallScreenVideoController", 4, "<<<onStart(), ts=" + l2);
      QLog.d("IVR_TS_SmallScreenVideoController", 4, String.format("onStart(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
  
  public void f()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenVideoController", 4, ">>>onResume(), ts=" + l1);
    }
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 5;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onResume");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new jra(this), 200L);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().p) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(true, false);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.f(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
      }
    }
    boolean bool2;
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.q_();
        }
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.f();
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(false);
        l();
        long l2 = System.currentTimeMillis();
        if (QLog.isDevelopLevel())
        {
          QLog.d("IVR_TS_SmallScreenVideoController", 4, "<<<onResume(), ts=" + l2);
          QLog.d("IVR_TS_SmallScreenVideoController", 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
        }
        return;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 2) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().f())
        {
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
          bool2 = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Boolean;
          if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_JavaLangString) == 5) {}
          for (bool1 = true;; bool1 = false)
          {
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a((String)localObject, 1, bool2, false, bool1);
            if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d())) {
              break;
            }
            this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(true, false);
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.f(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
            break;
          }
        }
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().ak) && (!this.jdField_c_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils.c();
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(true, false);
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.f(this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
        }
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4);
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaUtilArrayList;
    int i = 0;
    label490:
    String str;
    int j;
    boolean bool3;
    if (i < ((ArrayList)localObject).size())
    {
      VideoViewInfo localVideoViewInfo = (VideoViewInfo)((ArrayList)localObject).get(i);
      str = String.valueOf(localVideoViewInfo.jdField_a_of_type_Long);
      j = localVideoViewInfo.jdField_a_of_type_Int;
      bool2 = localVideoViewInfo.jdField_a_of_type_Boolean;
      bool3 = localVideoViewInfo.jdField_b_of_type_Boolean;
      if (localVideoViewInfo.jdField_b_of_type_Long != 5L) {
        break label598;
      }
    }
    label598:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!str.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) && (bool3)) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(str, j, bool3, bool2, bool1);
      }
      i += 1;
      break label490;
      break;
    }
  }
  
  protected void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onPause");
    }
    m();
    this.jdField_b_of_type_Int = 4;
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.o();
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.h();
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(true);
  }
  
  void h()
  {
    this.jdField_b_of_type_Int = 2;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onStop");
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.s();
    }
  }
  
  void i()
  {
    this.jdField_b_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onDestroy");
    }
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService != null) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout != null))
    {
      localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131366263);
      if (localObject != null) {
        ((View)localObject).findViewById(2131366264).clearAnimation();
      }
    }
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils = null;
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.g();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI = null;
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.c();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().a("SmallScreen.onDestroy", false);
    }
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener = null;
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
    this.jdField_a_of_type_ComTencentAvAppVideoObserver = null;
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService != null)
    {
      localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout;
      if (localObject != null) {
        a((ViewGroup)localObject);
      }
    }
  }
  
  void j()
  {
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().G;
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().i;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().A;
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().n;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().e;
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Boolean;
  }
  
  void k()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener == null) {
      this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener = new jrf(this, this.jdField_a_of_type_AndroidContentContext, 2);
    }
  }
  
  void l()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener != null) {
      this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener.enable();
    }
  }
  
  void m()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener != null) {
      this.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener.disable();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController
 * JD-Core Version:    0.7.0.1
 */