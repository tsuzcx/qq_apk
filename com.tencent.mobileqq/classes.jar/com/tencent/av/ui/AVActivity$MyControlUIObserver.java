package com.tencent.av.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.av.AVFunChat.AVFunChatMessage;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.filter.EffectFilterTools.DataReport;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.business.manager.zimu.ARZimuTask;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcControllerImpl.DeviceCMDTLV;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.effects.AEKitAbilityInfo;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.av.utils.AVTraceUtil;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import mqq.os.MqqHandler;

class AVActivity$MyControlUIObserver
  extends ControlUIObserver
{
  AVActivity$MyControlUIObserver(AVActivity paramAVActivity) {}
  
  protected void a()
  {
    this.a.g(-1032L);
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null) && ((2 == this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int) || (this.a.jdField_g_of_type_Boolean)) && (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.l)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(-1032L, "onChangeUI_ShowControlUI");
    }
  }
  
  protected void a(int paramInt) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt1, paramInt2, paramString);
    }
  }
  
  protected void a(int paramInt, long paramLong)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.a.isDestroyed())) {}
    do
    {
      return;
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "OnNotify_Effect_Toolbar_Selected, btnId[" + paramInt + "], seq[" + paramLong + "]");
      if (paramInt == 100) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
      }
      if (paramInt != 4) {
        break;
      }
      bool = EffectFilterTools.a(this.a.getBaseContext());
      EffectFilterTools.DataReport.a(bool);
    } while (!bool);
    if (this.a.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel == null) {
      this.a.g();
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f() != 3) && (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f() != 4)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a("onChangeUI_EffectToolbarSelected");
    }
    boolean bool = this.a.jdField_a_of_type_ComTencentAvVideoController.a().e;
    this.a.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.a(this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), bool);
    ThreadManager.getUIHandler().post(new AVActivity.MyControlUIObserver.4(this));
    return;
    this.a.h();
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtuResCheck", 2, "onCheckPtuResRet, [" + paramInt + "," + paramBoolean + "]");
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (paramBoolean) && (PtuResChecker.b(paramInt)) && (PtuResChecker.b())) {
      this.a.runOnUiThread(new AVActivity.MyControlUIObserver.5(this));
    }
  }
  
  protected void a(long paramLong)
  {
    if ((this.a.isDestroyed()) || (this.a.jdField_a_of_type_ComTencentAvVideoController == null)) {}
    SessionInfo localSessionInfo;
    int j;
    String str;
    int k;
    boolean bool;
    do
    {
      return;
      localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if (QLog.isColorLevel()) {
        QLog.w("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio, isBackground_Stop[" + this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundStop + "], ActivityState[" + this.a.b() + "], getVideoAbilityLevel[" + this.a.jdField_a_of_type_ComTencentAvVideoController.g() + "], session[" + localSessionInfo + "], seq[" + paramLong + "]");
      }
      j = this.a.jdField_b_of_type_Int;
      str = this.a.jdField_d_of_type_JavaLangString;
      k = this.a.jdField_d_of_type_Int;
      if ((this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0)) {
        this.a.a(paramLong, "onChangeUI_DobuleAudio2MultiAudio", false);
      }
      if ((localSessionInfo.B) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)) {
        this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
      }
      if ((localSessionInfo.C) || ((this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d() != 1)))
      {
        localSessionInfo.C = false;
        this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.m();
      }
      bool = localSessionInfo.jdField_g_of_type_Boolean;
      if (localSessionInfo.i != 11) {
        break;
      }
    } while (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
    this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(null);
    return;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.g() != 4) || (!QAVConfigUtils.c())) {
        break label596;
      }
    }
    long l2;
    label596:
    for (int i = 3;; i = 4)
    {
      this.a.a(i, false);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, localSessionInfo.jdField_d_of_type_JavaLangString, 1, false, false, false);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramLong);
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
      }
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      this.a.a("onChangeUI_DobuleAudio2MultiAudio", false);
      this.a.jdField_b_of_type_Int = localSessionInfo.jdField_d_of_type_Int;
      if (this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) {
        this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.f();
      }
      if (!VcSystemInfo.isNormalSharp())
      {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong, true);
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, false, false);
        }
        localSessionInfo.a(paramLong, false);
      }
      DoodleLogic.a().a();
      this.a.a(paramLong, true);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong);
        if (this.a.jdField_a_of_type_Int != 4) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong);
        }
      }
      l2 = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      if (localSessionInfo.jdField_d_of_type_JavaLangString != null) {
        break label601;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->Peer uin is null!!!!!!!!!");
      return;
    }
    label601:
    localSessionInfo.h = Long.valueOf(localSessionInfo.jdField_d_of_type_JavaLangString).longValue();
    long l1 = localSessionInfo.jdField_g_of_type_Long;
    Object localObject2;
    Object localObject1;
    if (localSessionInfo.jdField_j_of_type_Int == 1)
    {
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder().append("onChangeUI_DobuleAudio2MultiAudio uinList[");
        if (localSessionInfo.a != null) {
          break label782;
        }
        localObject1 = "null";
        label667:
        QLog.i("double_2_multi", 4, localObject1 + "]");
      }
      localObject1 = localSessionInfo.a;
      localObject2 = new ArrayList();
      i = 0;
      label706:
      if ((localObject1 == null) || (i >= localObject1.length)) {
        break label815;
      }
      if ((localObject1[i] != l2) && (localObject1[i] != localSessionInfo.h)) {
        break label796;
      }
    }
    for (;;)
    {
      i += 1;
      break label706;
      if (localSessionInfo.jdField_j_of_type_Int != 3000) {
        break;
      }
      localSessionInfo.a = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(l1));
      break;
      label782:
      localObject1 = Integer.valueOf(localSessionInfo.a.length);
      break label667;
      label796:
      ((ArrayList)localObject2).add(Long.valueOf(localSessionInfo.a[i]));
    }
    label815:
    if (((ArrayList)localObject2).size() > 0)
    {
      i = ((ArrayList)localObject2).size();
      l2 = ((Long)((ArrayList)localObject2).get(0)).longValue();
      int m = AVUtil.c(localSessionInfo.F);
      localObject2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(m, String.valueOf(l2), String.valueOf(localSessionInfo.jdField_g_of_type_Long));
      localObject1 = localObject2;
      if (((String)localObject2).length() > 7) {
        localObject1 = ((String)localObject2).substring(0, 6) + "...";
      }
      localObject2 = localObject1;
      if (i > 1) {
        localObject2 = (String)localObject1 + HardCodeUtil.a(2131700940) + i + HardCodeUtil.a(2131700939);
      }
      localObject1 = String.format(this.a.getString(2131695888), new Object[] { localObject2 });
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c((String)localObject1);
      }
    }
    for (;;)
    {
      if (bool) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.onChangeUI_DobuleAudio2MultiAudio", l1, false, false, -1);
      }
      localSessionInfo.d("onChangeUI_DobuleAudio2MultiAudio", 0);
      this.a.jdField_a_of_type_ComTencentAvVideoController.j(false);
      this.a.jdField_a_of_type_ComTencentAvVideoController.k(false);
      this.a.jdField_d_of_type_Int = localSessionInfo.jdField_j_of_type_Int;
      if (this.a.jdField_b_of_type_Int == 4) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.a.jdField_b_of_type_Int, false, false);
      }
      this.a.jdField_d_of_type_JavaLangString = String.valueOf(localSessionInfo.jdField_g_of_type_Long);
      if (this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null) {
        this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a();
      }
      QLog.w("double_2_multi", 1, "onChangeUI_DobuleAudio2MultiAudio end, oldSessionType[" + j + "], oldUinType[" + k + "], oldRelationId[" + str + "], mRelationId[" + this.a.jdField_d_of_type_JavaLangString + "], sessionInfo[" + localSessionInfo + "]");
      return;
      if (QLog.isColorLevel()) {
        QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->inviteList is null");
      }
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onNotify_MenuView_Changed, menuType[" + paramInt + "], seq[" + paramLong + "]");
    this.a.g(paramLong);
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong, paramInt1, paramInt2);
    }
  }
  
  protected void a(long paramLong, ArrayList<VideoViewInfo> paramArrayList)
  {
    if ((this.a.jdField_a_of_type_Int == 4) || (this.a.jdField_a_of_type_Int == 5) || (this.a.jdField_a_of_type_Int == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onRequest_ShowVideo ignore ");
      }
      return;
    }
    String str1 = null;
    Object localObject = str1;
    if (paramArrayList != null)
    {
      localObject = str1;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onRequest_ShowVideo, infoLogs[" + (String)localObject + "], seq[" + paramLong + "]");
    }
    int k;
    int j;
    VideoViewInfo localVideoViewInfo;
    String str2;
    int m;
    boolean bool2;
    boolean bool3;
    int i;
    boolean bool1;
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (paramArrayList != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      k = this.a.jdField_a_of_type_ComTencentAvVideoController.g();
      Collections.sort(paramArrayList, new AVActivity.MyControlUIObserver.1(this));
      if (QLog.isColorLevel()) {
        QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onRequest_ShowVideo, after sort infoLogs[" + (String)localObject + "], seq[" + paramLong + "]");
      }
      j = 0;
      if (j < paramArrayList.size())
      {
        localVideoViewInfo = (VideoViewInfo)paramArrayList.get(j);
        str2 = CharacterUtil.a(localVideoViewInfo.jdField_a_of_type_Long);
        m = localVideoViewInfo.jdField_a_of_type_Int;
        bool2 = localVideoViewInfo.jdField_a_of_type_Boolean;
        bool3 = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m);
        i = AVUtil.b(this.a.jdField_d_of_type_Int);
        str1 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str2, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long));
        if (!localVideoViewInfo.jdField_b_of_type_Boolean) {
          break label1362;
        }
        if (!str2.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
        {
          localObject = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if ((localVideoViewInfo.jdField_b_of_type_Long == 5L) || (localVideoViewInfo.jdField_b_of_type_Long == 14L))
          {
            bool1 = true;
            label413:
            ((VideoLayerUI)localObject).a(paramLong, str2, m, true, bool2, bool1);
            if ((!bool2) || (localVideoViewInfo.d)) {
              break label1362;
            }
            if (CharacterUtil.a(str1) <= 20) {
              break label1355;
            }
            localObject = CharacterUtil.a(str1, 0, 20) + "...";
            label480:
            if (m != 2) {
              break label836;
            }
            localObject = String.format(this.a.getString(2131695510), new Object[] { localObject });
            if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (!(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof MultiVideoCtrlLayerUIBase))) {
              break label817;
            }
            this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(1036, (String)localObject);
            label548:
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      label551:
      if (i == 0)
      {
        AVActivity.a(this.a);
        if ((localVideoViewInfo.jdField_b_of_type_Boolean) || (localVideoViewInfo.jdField_a_of_type_Boolean)) {
          break label1179;
        }
        if (k == 4) {
          break label1144;
        }
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().F != 2) {
          break label1054;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
        label635:
        if (this.a.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          this.a.jdField_a_of_type_AndroidGraphicsBitmap = UITools.a(this.a.getApplicationContext(), 2130842307);
        }
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str2, m, this.a.jdField_a_of_type_AndroidGraphicsBitmap, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
      }
      for (;;)
      {
        if ((!bool3) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().J))
        {
          float f2 = 12.0F;
          float f1 = f2;
          if (bool2)
          {
            f1 = f2;
            if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f() != 3) {
              f1 = 18.0F;
            }
          }
          f1 = UITools.a(this.a.getApplicationContext(), f1);
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m, str1, f1, -1);
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str2, m);
        }
        j += 1;
        break;
        bool1 = false;
        break label413;
        label817:
        TipsUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036, (String)localObject);
        break label548;
        label836:
        localObject = String.format(this.a.getString(2131695511), new Object[] { localObject });
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_b_of_type_JavaLangString, 1, "onRequest_ShowVideo, will loading name[" + str1 + "]");
        }
        if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof MultiVideoCtrlLayerUIBase)))
        {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(1037, (String)localObject);
          break label548;
        }
        TipsUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037, (String)localObject);
        break label548;
        if ((str2.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) && (m == 2)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label1022;
          }
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, true, bool2);
          i = 0;
          break;
        }
        label1022:
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, true, bool2);
        i = 1;
        break label551;
        label1054:
        if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D == 10)
        {
          ReportController.b(null, "CliOper", "", "", "0X800594A", "0X800594A", 0, 0, "", "", "", "");
          break label635;
        }
        ReportController.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
        break label635;
        label1144:
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str2, m, this.a.jdField_b_of_type_AndroidGraphicsBitmap, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
        continue;
        label1179:
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str2, m, this.a.jdField_b_of_type_AndroidGraphicsBitmap, localVideoViewInfo.jdField_b_of_type_Boolean, localVideoViewInfo.jdField_a_of_type_Boolean);
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.h, false);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong, this.a.h);
      }
      if ((this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().D != 2)) {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.a.h);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog.b();
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller == null) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a();
      return;
      label1355:
      localObject = str1;
      break label480;
      label1362:
      i = 0;
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.jdField_b_of_type_JavaLangString, 2, "onWatchTogetherModeChange, seq[" + paramLong + "], enter[" + paramBoolean + "]");
    }
    int i;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      i = ((SessionInfo)localObject).jdField_d_of_type_Int;
      if (!paramBoolean) {
        break label262;
      }
      if (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(0)) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
      }
      if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i())) {
        this.a.h(false);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null) {
        this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.c(3);
      }
      if ((((SessionInfo)localObject).B) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)) {
        this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
      }
      new ControlUIObserver.ZimuRequest(paramLong, "onWatchTogetherModeChange", 2, null).a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.a.h();
      localObject = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a();
      if (localObject != null) {
        ((EffectSettingUi)localObject).a();
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.D(paramLong);
      return;
      label262:
      if (((i == 1) || (i == 3)) && ((!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h) || (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i()))) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(0);
      }
    }
  }
  
  protected void a(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    boolean bool = true;
    if (this.a.isDestroyed()) {}
    while ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) || (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h())) {
      return;
    }
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.l(true);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.n();
    }
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.l(false);
    }
    if ((paramBoolean1) && (!paramBoolean2))
    {
      this.a.a(paramLong1, 50L);
      this.a.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong1, this.a, 2, 2);
    }
    ARZimuTask.a(paramBoolean2);
    this.a.a(Integer.valueOf(6503), Boolean.valueOf(paramBoolean2), null);
    AVActivity localAVActivity = this.a;
    if ((!paramBoolean1) && (!paramBoolean2)) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      localAVActivity.b(paramLong1, "onNotify_SwitchToolbarAnimation", paramBoolean1);
      return;
    }
  }
  
  protected void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, " onChangeUI_receiveTransferMsg ");
    }
    if (this.a.jdField_d_of_type_Int == 9500) {
      if ((paramObject instanceof VcControllerImpl.DeviceCMDTLV))
      {
        paramObject = (VcControllerImpl.DeviceCMDTLV)paramObject;
        if (paramObject.jdField_a_of_type_Int != 6) {
          break label334;
        }
        if ((paramObject.jdField_b_of_type_Int & 0x1) != 1) {
          break label278;
        }
        if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.n = true;
          ((DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(2131373781, true, 2130842183);
        }
      }
    }
    label277:
    label278:
    label334:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                break label277;
                break label277;
                break label277;
                break label277;
                for (;;)
                {
                  if (((paramObject.jdField_b_of_type_Int & 0x4) == 4) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
                  {
                    this.a.jdField_a_of_type_ComTencentAvVideoController.o = true;
                    ((DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).K();
                  }
                  if (((paramObject.jdField_b_of_type_Int & 0x8) == 8) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
                  {
                    this.a.jdField_a_of_type_ComTencentAvVideoController.p = false;
                    DoubleVideoCtrlUI localDoubleVideoCtrlUI = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
                    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new AVActivity.MyControlUIObserver.3(this, localDoubleVideoCtrlUI), 500L);
                  }
                  if (((paramObject.jdField_b_of_type_Int & 0x2) == 2) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
                  {
                    paramObject = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
                    this.a.jdField_a_of_type_ComTencentAvVideoController.a().b(0L, false);
                  }
                  return;
                  if (((paramObject.jdField_b_of_type_Int & 0x1) == 0) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
                  {
                    this.a.jdField_a_of_type_ComTencentAvVideoController.n = false;
                    ((DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(2131373781, false, 2130842183);
                  }
                }
              } while (paramObject.jdField_a_of_type_Int != 5);
              if (paramObject.jdField_b_of_type_Int != 2) {
                break;
              }
            } while (!(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI));
            paramObject = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
            paramObject.a(2131695892, 2, 0, paramObject.a.getDimensionPixelSize(2131299166));
            return;
          } while ((paramObject.jdField_b_of_type_Int != 3) || (!(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)));
          paramObject = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
          paramObject.a(2131695891, 1, 0, paramObject.a.getDimensionPixelSize(2131299166));
          return;
        } while (!(paramObject instanceof VcControllerImpl.DeviceCMDTLV));
        paramObject = (VcControllerImpl.DeviceCMDTLV)paramObject;
      } while ((paramObject.jdField_a_of_type_Int != 11) || (paramObject.jdField_b_of_type_Int != 1) || (!(this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)));
      this.a.jdField_a_of_type_ComTencentAvVideoController.q = true;
    } while (!QLog.isColorLevel());
    QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "receiveTransferMsg xiaowei Device");
  }
  
  protected void a(String paramString)
  {
    if (paramString != null)
    {
      if (!paramString.equals("1")) {
        break label63;
      }
      if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().U)
      {
        this.a.b(null);
        if (!this.a.isResume()) {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(false);
        }
      }
    }
    label63:
    while (!paramString.startsWith("START")) {
      return;
    }
    paramString = paramString.substring("START_".length());
    this.a.b(paramString);
  }
  
  protected void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString1, paramInt1, paramString2, paramInt2);
    }
  }
  
  protected void a(String paramString, AVFunChat.AVFunChatMessage paramAVFunChatMessage)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAVFunChatMessage == null)) {
      if (QLog.isColorLevel()) {
        QLog.i(this.a.jdField_b_of_type_JavaLangString, 2, "onReceiveCreativeCopMsg, invalid params.");
      }
    }
    for (;;)
    {
      return;
      long l1 = AudioHelper.b();
      int i = paramAVFunChatMessage.enum_operator.get();
      long l2 = paramAVFunChatMessage.uint64_type.get();
      String str = paramAVFunChatMessage.str_msg.get();
      boolean bool = AEKitAbilityInfo.b();
      if ((l2 == 14L) && (bool))
      {
        if (i != 1) {
          break label337;
        }
        if (!"SUPPORT_CREATIVECOP_TRUE".equals(str)) {
          break label213;
        }
        ((EffectSupportManager)this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5)).a(3, 14, "SUPPORT_CREATIVECOP_TRUE");
      }
      while (QLog.isColorLevel())
      {
        QLog.i(this.a.jdField_b_of_type_JavaLangString, 2, "onReceiveCreativeCopMsg, fromUin[" + paramString + "], msg[" + paramAVFunChatMessage.uint64_type.get() + ", " + paramAVFunChatMessage.enum_operator.get() + ", " + paramAVFunChatMessage.str_msg.get() + "]");
        return;
        label213:
        if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i())) {
          this.a.h(false);
        }
        Object localObject;
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
        {
          localObject = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a();
          if (localObject == null) {
            break label311;
          }
          ((EffectSettingUi)localObject).setSelectedBtn(2);
        }
        for (;;)
        {
          if (TextUtils.isEmpty(str)) {
            break label335;
          }
          new ControlUIObserver.RequestPlayMagicFace(l1, str, false, 4).a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          break;
          label311:
          localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
          if (localObject != null) {
            ((SessionInfo)localObject).Y = 2;
          }
        }
        label335:
        continue;
        label337:
        if (i == 0) {
          this.a.a(Integer.valueOf(6101), null, Boolean.valueOf(false));
        }
      }
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) {
      this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(paramString1, paramString2);
    }
  }
  
  protected void a(ArrayList<VideoViewInfo> paramArrayList)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (paramArrayList != null))
    {
      long l = AudioHelper.b();
      Object localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onChangeUI_CloseVideo, seq[" + l + "], infoLogs[" + (String)localObject + "]");
      }
      Collections.sort(paramArrayList, new AVActivity.MyControlUIObserver.2(this));
      int i = 0;
      if (i < paramArrayList.size())
      {
        localObject = (VideoViewInfo)paramArrayList.get(i);
        String str = CharacterUtil.a(((VideoViewInfo)localObject).jdField_a_of_type_Long);
        boolean bool2 = ((VideoViewInfo)localObject).jdField_a_of_type_Boolean;
        int j = ((VideoViewInfo)localObject).jdField_a_of_type_Int;
        boolean bool1;
        if (!str.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
        {
          if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(str, j))
          {
            if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof MultiVideoCtrlLayerUIBase))) {
              this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(1037);
            }
            TipsUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
          }
          VideoLayerUI localVideoLayerUI = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          if ((((VideoViewInfo)localObject).jdField_b_of_type_Long == 5L) || (((VideoViewInfo)localObject).jdField_b_of_type_Long == 14L))
          {
            bool1 = true;
            label260:
            localVideoLayerUI.a(l, str, j, false, bool2, bool1);
          }
        }
        label324:
        for (;;)
        {
          i += 1;
          break;
          bool1 = false;
          break label260;
          if (((VideoViewInfo)localObject).jdField_a_of_type_Int == 2) {}
          for (j = 1;; j = 0)
          {
            if (j == 0) {
              break label324;
            }
            this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(l, false, false);
            break;
          }
        }
      }
      this.a.h();
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog.b();
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null) {
      this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a();
    }
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    if (this.a.jdField_a_of_type_Int == 4) {}
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        boolean bool = paramBoolean;
        if (!paramBoolean) {
          bool = RedBagUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, "onRequest_OpenCamera");
        }
        AVActivity.a(this.a);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, true, bool);
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().J))
        {
          String str1 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
          int i = AVUtil.b(this.a.jdField_d_of_type_Int);
          String str2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str1, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_g_of_type_Long));
          float f = 12.0F;
          if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(str1, 1)) {
            f = 18.0F;
          }
          f = UITools.a(this.a.getApplicationContext(), f);
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str1, 1, str2, f, -1);
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str1, 1, this.a.jdField_b_of_type_AndroidGraphicsBitmap, true, true);
        }
      }
    } while (this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller == null);
    this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a();
  }
  
  protected void b()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.m)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.m = false;
      this.a.e = true;
      this.a.finish();
    }
  }
  
  protected void b(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  protected void b(int paramInt, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ChatRoomUtil", 4, "onNotify_ChatRoom_InputPanelChange, lastPanelState[" + paramInt + "], seq[" + paramLong + "]");
    }
    this.a.a(paramLong, 1);
  }
  
  protected void b(long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    SessionInfo localSessionInfo;
    int i;
    String str;
    int j;
    boolean bool;
    do
    {
      do
      {
        return;
        localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
        if (QLog.isColorLevel()) {
          QLog.i("normal_2_meeting", 2, "onChangeUI_Normal2Meeting, cur[" + localSessionInfo + "]");
        }
        i = this.a.jdField_b_of_type_Int;
        str = this.a.jdField_d_of_type_JavaLangString;
        j = this.a.jdField_d_of_type_Int;
        if ((this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0)) {
          this.a.a(paramLong, "onChangeUI_Normal2Meeting", false);
        }
        if ((localSessionInfo.B) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)) {
          this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
        }
        if ((localSessionInfo.C) || ((this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d() != 1)))
        {
          localSessionInfo.C = false;
          this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.m();
        }
        bool = localSessionInfo.jdField_g_of_type_Boolean;
        if (localSessionInfo.i != 16) {
          break;
        }
      } while (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(null);
      return;
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        this.a.a(4, false);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, localSessionInfo.jdField_d_of_type_JavaLangString, 1, false, false, false);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramLong);
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
      }
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      this.a.a("onChangeUI_Normal2Meeting", true);
      if (localSessionInfo.jdField_d_of_type_Int == 2)
      {
        localSessionInfo.jdField_d_of_type_Int = 1;
        if (QLog.isColorLevel()) {
          QLog.i("normal_2_meeting", 2, "onChangeUI_Normal2Meeting video to audio .");
        }
      }
      this.a.jdField_b_of_type_Int = localSessionInfo.jdField_d_of_type_Int;
      if (this.a.jdField_b_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("normal_2_meeting", 2, "onChangeUI_Normal2Meeting illegal session type.");
        }
        this.a.jdField_b_of_type_Int = 1;
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) {
        this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.f();
      }
      if (!VcSystemInfo.isNormalSharp())
      {
        this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(paramLong, true);
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, false, false);
        }
        localSessionInfo.a(paramLong, false);
      }
      DoodleLogic.a().a();
      this.a.a(paramLong, true);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong);
        if (this.a.jdField_a_of_type_Int != 4) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong);
        }
      }
      if (localSessionInfo.jdField_d_of_type_JavaLangString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("double_2_multi", 2, "onChangeUI_Normal2Meeting-->Peer uin is null!!!!!!!!!");
    return;
    long l = localSessionInfo.jdField_g_of_type_Long;
    localSessionInfo.h = Long.valueOf(localSessionInfo.jdField_d_of_type_JavaLangString).longValue();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(null);
    }
    if (bool) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.onChangeUI_Normal2Meeting", l, false, false, -1);
    }
    localSessionInfo.f("AVActivity.onChangeUI_Normal2Meeting", false);
    this.a.jdField_d_of_type_Int = localSessionInfo.jdField_j_of_type_Int;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, localSessionInfo.jdField_d_of_type_Int, false, true);
    if ((localSessionInfo.jdField_j_of_type_Boolean) || (localSessionInfo.aJ)) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, localSessionInfo.jdField_d_of_type_Int, false, false);
    }
    this.a.jdField_d_of_type_JavaLangString = String.valueOf(localSessionInfo.jdField_g_of_type_Long);
    if (this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null) {
      this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a();
    }
    QLog.w("normal_2_meeting", 1, "onChangeUI_Normal2Meeting end, oldSessionType[" + i + "], oldUinType[" + j + "], oldRelationId[" + str + "], mRelationId[" + this.a.jdField_d_of_type_JavaLangString + "], sessionInfo[" + localSessionInfo + "]");
  }
  
  protected void b(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.g(paramString);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onChangeUI_ChildLockStateChange, lock[" + paramBoolean + "], seq[" + l + "]");
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(l, 2048);
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.n();
    }
  }
  
  protected void c()
  {
    ViewGroup localViewGroup = (ViewGroup)this.a.findViewById(2131363187);
    if (localViewGroup != null) {
      DoodleUtils.a(localViewGroup);
    }
  }
  
  protected void c(int paramInt)
  {
    int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    if ((i == 1) || (i == 3)) {}
    while ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().h()) || ((this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.a())) || (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)) {
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi == null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))) {
      this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi = new ChildGuideUi(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.a, this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI, (RelativeLayout)AVActivity.a(this.a, 2131373792));
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.c()))
    {
      this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.e();
      ReportController.b(null, "CliOper", "", "", "0X80061F6", "0X80061F6", 0, 0, "", "", "", "");
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramInt);
  }
  
  protected void c(long paramLong)
  {
    this.a.a(paramLong);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onChangeUI_NotifyChangedZimuPeer id=" + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.startsWith("SUPPORT"))) {
      d(2);
    }
  }
  
  public void d()
  {
    AVActivity localAVActivity = this.a;
    if (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i()) {}
    for (boolean bool = true;; bool = false)
    {
      localAVActivity.b(-1048L, "onChangeUI_RecordStateChange", bool);
      return;
    }
  }
  
  public void d(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) {
      this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.g(paramInt);
    }
  }
  
  protected void d(long paramLong)
  {
    AVTraceUtil.a("switch_camera", "onRequest_SwitchCamera", 3, new Object[] { Long.valueOf(paramLong) });
    if (this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils != null) {
      this.a.jdField_a_of_type_ComTencentAvCameraCameraUtils.d(paramLong);
    }
  }
  
  protected void e() {}
  
  protected void e(int paramInt)
  {
    boolean bool2 = true;
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onChangeUI_MagicFacePlayStateChange, state[" + paramInt + "], seq[" + l + "]");
    }
    AVActivity localAVActivity;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      localAVActivity = this.a;
      if (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i())
      {
        bool1 = true;
        localAVActivity.b(l, "onChangeUI_MagicFacePlayStateChange", bool1);
      }
    }
    else
    {
      if ((this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)) {
        this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.n();
      }
      localAVActivity = this.a;
      if (paramInt != 5) {
        break label169;
      }
    }
    label169:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localAVActivity.d(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected void e(long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.D(paramLong);
    }
  }
  
  protected void f()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.j(false);
    }
  }
  
  protected void f(long paramLong)
  {
    AVActivity.a(this.a, paramLong);
  }
  
  protected void g()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.j(true);
    }
  }
  
  public void h()
  {
    AVActivity localAVActivity;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      localAVActivity = this.a;
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i()) {
        break label42;
      }
    }
    label42:
    for (boolean bool = true;; bool = false)
    {
      localAVActivity.b(-1050L, "onRequest_RefreshRecordBtn", bool);
      return;
    }
  }
  
  protected void i()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.jdField_b_of_type_JavaLangString, 1, "onChangeUI_SmallView_Position_change, seq[" + l + "]");
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((2 == this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int) || (this.a.jdField_g_of_type_Boolean))) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(l, "onChangeUI_SmallView_Position_change");
    }
  }
  
  protected void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.jdField_b_of_type_JavaLangString, 2, "onChangeUI_quitDoubleScreenStatus");
    }
    this.a.h(true);
  }
  
  protected void k()
  {
    TipsUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1008, 2131695474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.MyControlUIObserver
 * JD-Core Version:    0.7.0.1
 */