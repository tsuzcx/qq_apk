package com.tencent.av.smallscreen;

import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.AbstractOrientationEventListener;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QavVideoRecordUICtrl.FadeInOutAnimation;
import com.tencent.av.ui.funchat.record.QavRecordDpc;
import com.tencent.av.ui.funchat.record.QavRecordUtils;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class SmallScreenVideoController$MyControlUIObserver
  extends ControlUIObserver
{
  SmallScreenVideoController$MyControlUIObserver(SmallScreenVideoController paramSmallScreenVideoController) {}
  
  protected void a()
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(0, 0, true);
    }
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onChangeUI_DobuleAudio2MultiAudio, isBackground_Stop[");
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundStop);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("double_2_multi", 1, ((StringBuilder)localObject).toString());
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    SmallScreenVideoController.a(this.a, 1);
    Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    if (((SessionInfo)localObject).jdField_g_of_type_Int == 11) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(((SessionInfo)localObject).c, 1, false, false, false);
    }
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramLong);
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
    }
    SmallScreenVideoController localSmallScreenVideoController = this.a;
    localSmallScreenVideoController.jdField_d_of_type_Boolean = false;
    localSmallScreenVideoController.c = ((SessionInfo)localObject).jdField_d_of_type_Int;
    this.a.jdField_d_of_type_Int = ((SessionInfo)localObject).e;
    if (!VcSystemInfo.isNormalSharp())
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(false, false);
      ((SessionInfo)localObject).b(paramLong, false);
    }
    this.a.a(true);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b();
      if (this.a.jdField_b_of_type_Int != 2) {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.e();
      }
    }
    if (((SessionInfo)localObject).c == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->Peer uin is null!!!!!!!!!");
      }
      return;
    }
    ((SessionInfo)localObject).jdField_g_of_type_Long = Long.valueOf(((SessionInfo)localObject).c).longValue();
    long l = ((SessionInfo)localObject).f;
    if (((SessionInfo)localObject).jdField_k_of_type_Int == 3000) {
      ((SessionInfo)localObject).a = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(l));
    }
    ((SessionInfo)localObject).e("onChangeUI_DobuleAudio2MultiAudio", 0);
    this.a.jdField_a_of_type_ComTencentAvVideoController.i(false);
    this.a.jdField_a_of_type_ComTencentAvVideoController.j(false);
    this.a.e = ((SessionInfo)localObject).jdField_k_of_type_Int;
    if (this.a.c == 4) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.a.c, false, false);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().c));
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    MagicDataReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (String)localObject);
    MagicDataReport.a(2, (String)localObject);
    MagicDataReport.a(2);
  }
  
  protected void a(long paramLong, ArrayList<VideoViewInfo> paramArrayList)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) && (paramArrayList != null))
    {
      Object localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      int k = this.a.jdField_a_of_type_ComTencentAvVideoController.g();
      boolean bool1 = QLog.isColorLevel();
      boolean bool2 = true;
      Object localObject2;
      if (bool1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onRequest_ShowVideo, seq[");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("], infoLogs[");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("]");
        QLog.w("SmallScreenVideoController", 1, ((StringBuilder)localObject2).toString());
      }
      j = 0;
      while (j < paramArrayList.size())
      {
        localObject1 = (VideoViewInfo)paramArrayList.get(j);
        localObject2 = String.valueOf(((VideoViewInfo)localObject1).jdField_a_of_type_Long);
        int m = ((VideoViewInfo)localObject1).jdField_a_of_type_Int;
        boolean bool3 = ((VideoViewInfo)localObject1).jdField_a_of_type_Boolean;
        i = -1;
        if (this.a.e == 3000) {
          i = 1004;
        } else if (this.a.e == 1) {
          i = 1000;
        } else if (this.a.e == 0) {
          i = 0;
        }
        String str = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, (String)localObject2, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().f));
        if ((((VideoViewInfo)localObject1).jdField_b_of_type_Boolean) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.n())) {
          if (!((String)localObject2).equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
          {
            SmallScreenVideoLayerUI localSmallScreenVideoLayerUI = this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI;
            if ((((VideoViewInfo)localObject1).jdField_b_of_type_Long != 5L) && (((VideoViewInfo)localObject1).jdField_b_of_type_Long != 14L)) {
              bool1 = false;
            } else {
              bool1 = true;
            }
            localSmallScreenVideoLayerUI.a((String)localObject2, m, true, bool3, bool1);
          }
          else
          {
            this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.openCamera(paramLong);
            this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(true, bool3);
            i = 1;
            break label383;
          }
        }
        i = 0;
        label383:
        if (i == 0)
        {
          if ((!((VideoViewInfo)localObject1).jdField_b_of_type_Boolean) && (!((VideoViewInfo)localObject1).jdField_a_of_type_Boolean) && (k != 4)) {
            if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().E == 2) {
              ReportController.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
            } else {
              ReportController.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
            }
          }
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a((String)localObject2, m, this.a.jdField_a_of_type_AndroidGraphicsBitmap, ((VideoViewInfo)localObject1).jdField_b_of_type_Boolean, ((VideoViewInfo)localObject1).jdField_a_of_type_Boolean);
        }
        if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().y)
        {
          float f = UITools.a(this.a.jdField_a_of_type_AndroidContentContext, 12.0F);
          if (!((String)localObject2).equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
            this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a((String)localObject2, m, str, f, -1);
          }
          this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a((String)localObject2, m);
        }
        j += 1;
      }
      paramArrayList = this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI;
      i = this.a.jdField_g_of_type_Int;
      if (this.a.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener == null) {
        bool1 = bool2;
      } else {
        bool1 = this.a.jdField_a_of_type_ComTencentAvUiAbstractOrientationEventListener.jdField_a_of_type_Boolean;
      }
      paramArrayList.a(i, bool1);
    }
    int i = this.a.jdField_g_of_type_Int;
    int j = this.a.jdField_a_of_type_AndroidViewDisplay.getRotation();
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.c((i + j * 90) % 360);
    }
    if (this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi != null) {
      this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.setRotation(this.a.jdField_g_of_type_Int);
    }
  }
  
  protected void a(String paramString)
  {
    if ((paramString != null) && (paramString.equals("1")) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().J))
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(true);
      SmallScreenVideoController.a(this.a, 2);
    }
  }
  
  protected void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  protected void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Qav.Record, onChangeUi_ReceiveRecordMsg, from=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", data=");
      localStringBuilder.append(paramString2);
      QLog.d("SmallScreenVideoController", 2, localStringBuilder.toString());
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramString2);
    }
    catch (NumberFormatException paramString1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Qav.Record, onChangeUi_ReceiveRecordMsg, ");
      localStringBuilder.append(paramString1.getMessage());
      QLog.d("SmallScreenVideoController", 1, localStringBuilder.toString());
      i = -1;
    }
    if (i == -1)
    {
      paramString1 = new StringBuilder();
      paramString1.append("onChangeUi_ReceiveRecordMsg, parse int failed, try parse SUPPORT, data=");
      paramString1.append(paramString2);
      QLog.d("SmallScreenVideoController", 1, paramString1.toString());
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if ("SUPPORT_TRUE".equals(paramString2))
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().ay = true;
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().af = Math.max(this.a.jdField_a_of_type_ComTencentAvVideoController.a().af, 730);
      }
      else if (paramString2.startsWith("SUPPORT_TRUE_7.3.5"))
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().ay = true;
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().af = Math.max(this.a.jdField_a_of_type_ComTencentAvVideoController.a().af, 735);
        j = QavRecordUtils.a(paramString2, QavRecordDpc.a().h);
        paramString1 = new StringBuilder();
        paramString1.append("onChangeUi_ReceiveRecordMsg, SUPPORT_735 val=");
        paramString1.append(j);
        QLog.i("SmallScreenVideoController", 1, paramString1.toString());
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_k_of_type_Long = (j * 60 * 1000L);
      }
    }
    int j = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("onChangeUi_ReceiveRecordMsg, session type=");
      paramString1.append(j);
      QLog.d("SmallScreenVideoController", 2, paramString1.toString());
    }
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            break label531;
          }
          if (i != 5)
          {
            if (i != 8) {
              break label531;
            }
          }
          else
          {
            this.a.jdField_a_of_type_ComTencentAvVideoController.a(8, String.valueOf(6));
            break label531;
          }
        }
        this.a.jdField_a_of_type_ComTencentAvVideoController.a(8, String.valueOf(4));
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().aA = false;
      }
    }
    else
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(8, String.valueOf(2));
      this.a.jdField_a_of_type_ComTencentAvVideoController.B();
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().aA = true;
    }
    label531:
    d();
  }
  
  protected void a(ArrayList<VideoViewInfo> paramArrayList)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) && (paramArrayList != null))
    {
      Object localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onChangeUI_CloseVideo-->infos=");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("SmallScreenVideoController", 2, ((StringBuilder)localObject2).toString());
      }
      int i = 0;
      while (i < paramArrayList.size())
      {
        localObject1 = (VideoViewInfo)paramArrayList.get(i);
        localObject2 = String.valueOf(((VideoViewInfo)localObject1).jdField_a_of_type_Long);
        boolean bool2 = ((VideoViewInfo)localObject1).jdField_a_of_type_Boolean;
        int j = ((VideoViewInfo)localObject1).jdField_a_of_type_Int;
        if (!((String)localObject2).equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
        {
          if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.b((String)localObject2, j))
          {
            TipsUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
            TipsUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
          }
          SmallScreenVideoLayerUI localSmallScreenVideoLayerUI = this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI;
          boolean bool1;
          if ((((VideoViewInfo)localObject1).jdField_b_of_type_Long != 5L) && (((VideoViewInfo)localObject1).jdField_b_of_type_Long != 14L)) {
            bool1 = false;
          } else {
            bool1 = true;
          }
          localSmallScreenVideoLayerUI.a((String)localObject2, j, false, bool2, bool1);
        }
        i += 1;
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    if (this.a.jdField_b_of_type_Int == 2) {
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi != null) && (!this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b())) {
      this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.openCamera(paramLong);
    }
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(true, paramBoolean);
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.c(paramLong, this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.isFrontCamera());
    }
  }
  
  protected void b()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.l)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.l = false;
      SmallScreenVideoController localSmallScreenVideoController = this.a;
      localSmallScreenVideoController.jdField_b_of_type_Boolean = true;
      localSmallScreenVideoController.d();
    }
  }
  
  protected void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onChangeUI_Normal2Meeting, isBackground_Stop[");
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundStop);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], session[");
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentAvVideoController.a());
      ((StringBuilder)localObject).append("]");
      QLog.w("normal_2_meeting", 1, ((StringBuilder)localObject).toString());
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    SmallScreenVideoController.a(this.a, 1);
    Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    if (((SessionInfo)localObject).jdField_g_of_type_Int == 16) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(((SessionInfo)localObject).c, 1, false, false, false);
    }
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramLong);
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
    }
    ((SessionInfo)localObject).f("onChangeUI_Normal2Meeting", true);
    SmallScreenVideoController localSmallScreenVideoController = this.a;
    localSmallScreenVideoController.jdField_d_of_type_Boolean = true;
    localSmallScreenVideoController.c = 1;
    localSmallScreenVideoController.jdField_d_of_type_Int = ((SessionInfo)localObject).e;
    if (!VcSystemInfo.isNormalSharp())
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(false, false);
      ((SessionInfo)localObject).b(paramLong, false);
    }
    this.a.a(true);
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b();
      if (this.a.jdField_b_of_type_Int != 2) {
        this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.e();
      }
    }
    if (((SessionInfo)localObject).c == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("double_2_multi", 2, "onChangeUI_Normal2Meeting-->Peer uin is null!");
      }
      return;
    }
    ((SessionInfo)localObject).d("SmallScreen.onChangeUI_Normal2Meeting", false);
    localObject = this.a;
    ((SmallScreenVideoController)localObject).e = 0;
    ((SmallScreenVideoController)localObject).jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.a.c, false, true);
  }
  
  protected void c()
  {
    SmallScreenRelativeLayout localSmallScreenRelativeLayout;
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService == null) {
      localSmallScreenRelativeLayout = null;
    } else {
      localSmallScreenRelativeLayout = this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1);
    }
    if (localSmallScreenRelativeLayout != null) {
      DoodleUtils.a(localSmallScreenRelativeLayout);
    }
  }
  
  protected void c(long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI.a(false, false);
      SmallScreenVideoController.a(this.a, 1);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onChangeUI_RecordStateChange:");
    }
    Object localObject1;
    if (this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService == null) {
      localObject1 = null;
    } else {
      localObject1 = this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1);
    }
    if ((this.a.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      if (localObject1 == null) {
        return;
      }
      localObject1 = ((SmallScreenRelativeLayout)localObject1).findViewById(2013331470);
      if (localObject1 == null)
      {
        QLog.d("SmallScreenVideoController", 1, "onChangeUI_RecordStateChange view is null");
        return;
      }
      ((View)localObject1).clearAnimation();
      if ((!this.a.jdField_a_of_type_ComTencentAvVideoController.a().aA) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().az))
      {
        ((View)localObject1).setVisibility(8);
        return;
      }
      int i = 0;
      ((View)localObject1).setVisibility(0);
      Object localObject2 = new QavVideoRecordUICtrl.FadeInOutAnimation();
      ((QavVideoRecordUICtrl.FadeInOutAnimation)localObject2).setDuration(1000L);
      ((QavVideoRecordUICtrl.FadeInOutAnimation)localObject2).setRepeatCount(-1);
      ((View)localObject1).findViewById(2013331471).startAnimation((Animation)localObject2);
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().az) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().aA))
      {
        ((TextView)((View)localObject1).findViewById(2013331472)).setText(2131695772);
      }
      else
      {
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().az)
        {
          ((TextView)((View)localObject1).findViewById(2013331472)).setText(2131695773);
          break label277;
        }
        ((TextView)((View)localObject1).findViewById(2013331472)).setText(2131695771);
      }
      i = 1;
      label277:
      if (i != 0)
      {
        localObject2 = Build.MANUFACTURER;
        String str = Build.MODEL;
        if (("Xiaomi".equalsIgnoreCase((String)localObject2)) && ("MI MAX".equalsIgnoreCase(str))) {
          ((TextView)((View)localObject1).findViewById(2013331472)).setTextSize(1, 8.0F);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.MyControlUIObserver
 * JD-Core Version:    0.7.0.1
 */