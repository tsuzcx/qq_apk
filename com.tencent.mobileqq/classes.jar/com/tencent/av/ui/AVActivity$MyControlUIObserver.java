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
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.core.VcControllerImpl.DeviceCMDTLV;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.av.utils.AVTraceUtil;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      if (this.a.isDestroyed()) {
        return;
      }
      String str = this.a.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnNotify_Effect_Toolbar_Selected, btnId[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      if (paramInt == 100) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
      }
      if (paramInt == 4)
      {
        boolean bool = EffectFilterTools.a(this.a.getBaseContext());
        EffectFilterTools.DataReport.a(bool);
        if (bool)
        {
          if (this.a.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel == null) {
            this.a.h();
          }
          if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f() != 3) && (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f() != 4)) {
            this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a("onChangeUI_EffectToolbarSelected");
          }
          bool = this.a.jdField_a_of_type_ComTencentAvVideoController.a().e;
          this.a.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel.a(this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i(), bool);
          ThreadManager.getUIHandler().post(new AVActivity.MyControlUIObserver.4(this));
        }
      }
      else
      {
        this.a.i();
      }
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCheckPtuResRet, [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i("PtuResCheck", 2, localStringBuilder.toString());
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && (paramBoolean) && (PtuResChecker.b(paramInt)) && (PtuResChecker.b())) {
      this.a.runOnUiThread(new AVActivity.MyControlUIObserver.5(this));
    }
  }
  
  protected void a(long paramLong)
  {
    if (!this.a.isDestroyed())
    {
      if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
        return;
      }
      SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onChangeUI_DobuleAudio2MultiAudio, isBackground_Stop[");
        ((StringBuilder)localObject1).append(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundStop);
        ((StringBuilder)localObject1).append("], ActivityState[");
        ((StringBuilder)localObject1).append(this.a.b());
        ((StringBuilder)localObject1).append("], getVideoAbilityLevel[");
        ((StringBuilder)localObject1).append(this.a.jdField_a_of_type_ComTencentAvVideoController.g());
        ((StringBuilder)localObject1).append("], session[");
        ((StringBuilder)localObject1).append(localSessionInfo);
        ((StringBuilder)localObject1).append("], seq[");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append("]");
        QLog.w("double_2_multi", 2, ((StringBuilder)localObject1).toString());
      }
      int j = this.a.jdField_b_of_type_Int;
      String str = this.a.jdField_d_of_type_JavaLangString;
      int k = this.a.jdField_d_of_type_Int;
      if ((this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0)) {
        this.a.a(paramLong, "onChangeUI_DobuleAudio2MultiAudio", false);
      }
      if ((localSessionInfo.az) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)) {
        this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
      }
      if ((localSessionInfo.aA) || ((this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d() != 1)))
      {
        localSessionInfo.aA = false;
        this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.m();
      }
      boolean bool = localSessionInfo.jdField_g_of_type_Boolean;
      if (localSessionInfo.jdField_g_of_type_Int == 11)
      {
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(null);
        }
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController.g() == 4) && (QAVConfigUtils.b())) {
          i = 3;
        } else {
          i = 4;
        }
        this.a.a(i, false);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, localSessionInfo.c, 1, false, false, false);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramLong);
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
      }
      Object localObject1 = this.a;
      ((AVActivity)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = null;
      ((AVActivity)localObject1).a("onChangeUI_DobuleAudio2MultiAudio", false);
      this.a.jdField_b_of_type_Int = localSessionInfo.jdField_d_of_type_Int;
      if (this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) {
        this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.f();
      }
      if (!VcSystemInfo.isNormalSharp())
      {
        this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.closeCamera(paramLong, true);
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, false, false);
        }
        localSessionInfo.b(paramLong, false);
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
      long l1 = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      if (localSessionInfo.c == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->Peer uin is null!!!!!!!!!");
        }
        return;
      }
      localSessionInfo.jdField_g_of_type_Long = Long.valueOf(localSessionInfo.c).longValue();
      long l2 = localSessionInfo.f;
      if ((localSessionInfo.k != 1) && (localSessionInfo.k == 3000)) {
        localSessionInfo.a = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(l2));
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onChangeUI_DobuleAudio2MultiAudio uinList[");
        if (localSessionInfo.a == null) {
          localObject1 = "null";
        } else {
          localObject1 = Integer.valueOf(localSessionInfo.a.length);
        }
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append("]");
        QLog.i("double_2_multi", 4, ((StringBuilder)localObject2).toString());
      }
      localObject1 = localSessionInfo.a;
      Object localObject2 = new ArrayList();
      int i = 0;
      while ((localObject1 != null) && (i < localObject1.length))
      {
        if ((localObject1[i] != l1) && (localObject1[i] != localSessionInfo.jdField_g_of_type_Long)) {
          ((ArrayList)localObject2).add(Long.valueOf(localSessionInfo.a[i]));
        }
        i += 1;
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        i = ((ArrayList)localObject2).size();
        l1 = ((Long)((ArrayList)localObject2).get(0)).longValue();
        int m = AVUtil.c(localSessionInfo.E);
        localObject2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(m, String.valueOf(l1), String.valueOf(localSessionInfo.f));
        localObject1 = localObject2;
        if (((String)localObject2).length() > 7)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(((String)localObject2).substring(0, 6));
          ((StringBuilder)localObject1).append("...");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        localObject2 = localObject1;
        if (i > 1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131701083));
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131701082));
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        localObject1 = String.format(this.a.getString(2131695900), new Object[] { localObject2 });
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c((String)localObject1);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->inviteList is null");
      }
      if (bool) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.onChangeUI_DobuleAudio2MultiAudio", l2, false, false, -1);
      }
      localSessionInfo.e("onChangeUI_DobuleAudio2MultiAudio", 0);
      this.a.jdField_a_of_type_ComTencentAvVideoController.i(false);
      this.a.jdField_a_of_type_ComTencentAvVideoController.j(false);
      this.a.jdField_d_of_type_Int = localSessionInfo.k;
      if (this.a.jdField_b_of_type_Int == 4) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.a.jdField_b_of_type_Int, false, false);
      }
      this.a.jdField_d_of_type_JavaLangString = String.valueOf(localSessionInfo.f);
      if (this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null) {
        this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onChangeUI_DobuleAudio2MultiAudio end, oldSessionType[");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append("], oldUinType[");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append("], oldRelationId[");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("], mRelationId[");
      ((StringBuilder)localObject1).append(this.a.jdField_d_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("], sessionInfo[");
      ((StringBuilder)localObject1).append(localSessionInfo);
      ((StringBuilder)localObject1).append("]");
      QLog.w("double_2_multi", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    String str = this.a.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNotify_MenuView_Changed, menuType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
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
    long l = paramLong;
    Object localObject2 = paramArrayList;
    if ((this.a.jdField_a_of_type_Int != 4) && (this.a.jdField_a_of_type_Int != 5) && (this.a.jdField_a_of_type_Int != 3))
    {
      Object localObject3 = null;
      Object localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject1 = localObject3;
        if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
          localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a((ArrayList)localObject2);
        }
      }
      Object localObject4;
      if (QLog.isColorLevel())
      {
        localObject3 = this.a.jdField_b_of_type_JavaLangString;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("onRequest_ShowVideo, infoLogs[");
        ((StringBuilder)localObject4).append((String)localObject1);
        ((StringBuilder)localObject4).append("], seq[");
        ((StringBuilder)localObject4).append(l);
        ((StringBuilder)localObject4).append("]");
        QLog.w((String)localObject3, 1, ((StringBuilder)localObject4).toString());
      }
      if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (localObject2 != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null))
      {
        int i = this.a.jdField_a_of_type_ComTencentAvVideoController.g();
        Collections.sort((List)localObject2, new AVActivity.MyControlUIObserver.1(this));
        if (QLog.isColorLevel())
        {
          localObject2 = this.a.jdField_b_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onRequest_ShowVideo, after sort infoLogs[");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append("], seq[");
          ((StringBuilder)localObject3).append(l);
          ((StringBuilder)localObject3).append("]");
          QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
        }
        int j = 0;
        while (j < paramArrayList.size())
        {
          localObject3 = (VideoViewInfo)paramArrayList.get(j);
          localObject4 = CharacterUtil.a(((VideoViewInfo)localObject3).jdField_a_of_type_Long);
          int m = ((VideoViewInfo)localObject3).jdField_a_of_type_Int;
          boolean bool1 = ((VideoViewInfo)localObject3).jdField_a_of_type_Boolean;
          boolean bool4 = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a((String)localObject4, m);
          int k = AVUtil.b(this.a.jdField_d_of_type_Int);
          localObject2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(k, (String)localObject4, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().f));
          if (((VideoViewInfo)localObject3).jdField_b_of_type_Boolean)
          {
            boolean bool2;
            if (!((String)localObject4).equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
            {
              localObject1 = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
              if ((((VideoViewInfo)localObject3).jdField_b_of_type_Long != 5L) && (((VideoViewInfo)localObject3).jdField_b_of_type_Long != 14L)) {
                bool2 = false;
              } else {
                bool2 = true;
              }
              boolean bool3 = bool1;
              ((VideoLayerUI)localObject1).a(paramLong, (String)localObject4, m, true, bool3, bool2);
              if (bool3) {
                if (!((VideoViewInfo)localObject3).d)
                {
                  if (CharacterUtil.a((String)localObject2) > 20)
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append(CharacterUtil.a((String)localObject2, 0, 20));
                    ((StringBuilder)localObject1).append("...");
                    localObject1 = ((StringBuilder)localObject1).toString();
                  }
                  else
                  {
                    localObject1 = localObject2;
                  }
                  if (m == 2)
                  {
                    localObject1 = String.format(this.a.getString(2131695521), new Object[] { localObject1 });
                    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof MultiVideoCtrlLayerUIBase))) {
                      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(1036, (String)localObject1);
                    } else {
                      TipsUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036, (String)localObject1);
                    }
                  }
                  else
                  {
                    localObject1 = String.format(this.a.getString(2131695522), new Object[] { localObject1 });
                    if (QLog.isColorLevel())
                    {
                      String str = this.a.jdField_b_of_type_JavaLangString;
                      StringBuilder localStringBuilder = new StringBuilder();
                      localStringBuilder.append("onRequest_ShowVideo, will loading name[");
                      localStringBuilder.append((String)localObject2);
                      localStringBuilder.append("]");
                      QLog.d(str, 1, localStringBuilder.toString());
                    }
                    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof MultiVideoCtrlLayerUIBase))) {
                      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(1037, (String)localObject1);
                    } else {
                      TipsUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037, (String)localObject1);
                    }
                  }
                }
                else {}
              }
            }
            else
            {
              bool2 = bool1;
              if ((((String)localObject4).equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) && (m == 2)) {
                k = 1;
              } else {
                k = 0;
              }
              if (k != 0)
              {
                this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, true, bool2);
              }
              else
              {
                this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.openCamera(paramLong);
                this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, true, bool2);
                k = 1;
                break label887;
              }
            }
          }
          k = 0;
          label887:
          if (k == 0)
          {
            AVActivity.a(this.a);
            if ((!((VideoViewInfo)localObject3).jdField_b_of_type_Boolean) && (!((VideoViewInfo)localObject3).jdField_a_of_type_Boolean))
            {
              if (i != 4)
              {
                if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().E == 2) {
                  ReportController.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
                } else if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 10) {
                  ReportController.b(null, "CliOper", "", "", "0X800594A", "0X800594A", 0, 0, "", "", "", "");
                } else {
                  ReportController.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
                }
                if (this.a.jdField_a_of_type_AndroidGraphicsBitmap == null)
                {
                  localObject1 = this.a;
                  ((AVActivity)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = UITools.a(((AVActivity)localObject1).getApplicationContext(), 2130842205);
                }
                this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, (String)localObject4, m, this.a.jdField_a_of_type_AndroidGraphicsBitmap, ((VideoViewInfo)localObject3).jdField_b_of_type_Boolean, ((VideoViewInfo)localObject3).jdField_a_of_type_Boolean);
              }
              else
              {
                this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, (String)localObject4, m, this.a.jdField_b_of_type_AndroidGraphicsBitmap, ((VideoViewInfo)localObject3).jdField_b_of_type_Boolean, ((VideoViewInfo)localObject3).jdField_a_of_type_Boolean);
              }
            }
            else {
              this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, (String)localObject4, m, this.a.jdField_b_of_type_AndroidGraphicsBitmap, ((VideoViewInfo)localObject3).jdField_b_of_type_Boolean, ((VideoViewInfo)localObject3).jdField_a_of_type_Boolean);
            }
          }
          if ((!bool4) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().y))
          {
            float f = 12.0F;
            if ((bool1) && (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f() != 3)) {
              f = 18.0F;
            }
            f = UITools.a(this.a.getApplicationContext(), f);
            this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a((String)localObject4, m, (String)localObject2, f, -1);
            this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a((String)localObject4, m);
          }
          j += 1;
        }
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.h, false);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong, this.a.h);
      }
      if ((this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int != 2)) {
        this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.setRotation(this.a.h);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVoiceChangeChooseDialog.b();
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null) {
        this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "onRequest_ShowVideo ignore ");
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWatchTogetherModeChange, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], enter[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      int i = ((SessionInfo)localObject).jdField_d_of_type_Int;
      if (paramBoolean)
      {
        if (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.b(0)) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a.a(paramLong, 0, true);
        }
        if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.i())) {
          this.a.g(false);
        }
        if (this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null) {
          this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.c(3);
        }
        if ((((SessionInfo)localObject).az) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)) {
          this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
        }
        new ControlUIObserver.ZimuRequest(paramLong, "onWatchTogetherModeChange", 2, null).a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        this.a.i();
        localObject = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a();
        if (localObject != null) {
          ((EffectSettingUi)localObject).a();
        }
      }
      else if (((i == 1) || (i == 3)) && ((!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h) || (!this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i())))
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(0);
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.C(paramLong);
    }
  }
  
  protected void a(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    if (this.a.isDestroyed()) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) {
        return;
      }
      boolean bool = true;
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(true);
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.n();
      }
      if ((paramBoolean1) && (paramBoolean2)) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.m(false);
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        this.a.a(paramLong1, 50L);
        this.a.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(paramLong1, this.a, 2, 2);
      }
      this.a.a(Integer.valueOf(6503), Boolean.valueOf(paramBoolean2), null);
      AVActivity localAVActivity = this.a;
      if ((!paramBoolean1) && (!paramBoolean2)) {
        paramBoolean1 = bool;
      } else {
        paramBoolean1 = false;
      }
      localAVActivity.b(paramLong1, "onNotify_SwitchToolbarAnimation", paramBoolean1);
    }
  }
  
  protected void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, " onChangeUI_receiveTransferMsg ");
    }
    if (this.a.jdField_d_of_type_Int == 9500)
    {
      if ((paramObject instanceof VcControllerImpl.DeviceCMDTLV))
      {
        paramObject = (VcControllerImpl.DeviceCMDTLV)paramObject;
        if (paramObject.jdField_a_of_type_Int == 6)
        {
          if ((paramObject.jdField_b_of_type_Int & 0x1) == 1)
          {
            if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))
            {
              this.a.jdField_a_of_type_ComTencentAvVideoController.m = true;
              ((DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(2131373353, true, 2130842081);
            }
          }
          else if (((paramObject.jdField_b_of_type_Int & 0x1) == 0) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
          {
            this.a.jdField_a_of_type_ComTencentAvVideoController.m = false;
            ((DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).a(2131373353, false, 2130842081);
          }
          if (((paramObject.jdField_b_of_type_Int & 0x4) == 4) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
          {
            this.a.jdField_a_of_type_ComTencentAvVideoController.n = true;
            ((DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI).K();
          }
          if (((paramObject.jdField_b_of_type_Int & 0x8) == 8) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
          {
            this.a.jdField_a_of_type_ComTencentAvVideoController.o = false;
            DoubleVideoCtrlUI localDoubleVideoCtrlUI = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
            this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new AVActivity.MyControlUIObserver.3(this, localDoubleVideoCtrlUI), 500L);
          }
          if (((paramObject.jdField_b_of_type_Int & 0x2) == 2) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
          {
            paramObject = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().c(0L, false);
          }
        }
        else if (paramObject.jdField_a_of_type_Int == 5)
        {
          if (paramObject.jdField_b_of_type_Int == 2)
          {
            if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))
            {
              paramObject = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
              paramObject.a(2131695907, 2, 0, paramObject.a.getDimensionPixelSize(2131299168));
            }
          }
          else if ((paramObject.jdField_b_of_type_Int == 3) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
          {
            paramObject = (DoubleVideoCtrlUI)this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI;
            paramObject.a(2131695906, 1, 0, paramObject.a.getDimensionPixelSize(2131299168));
          }
        }
      }
    }
    else if ((paramObject instanceof VcControllerImpl.DeviceCMDTLV))
    {
      paramObject = (VcControllerImpl.DeviceCMDTLV)paramObject;
      if ((paramObject.jdField_a_of_type_Int == 11) && (paramObject.jdField_b_of_type_Int == 1) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
      {
        this.a.jdField_a_of_type_ComTencentAvVideoController.p = true;
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_b_of_type_JavaLangString, 2, "receiveTransferMsg xiaowei Device");
        }
      }
    }
  }
  
  protected void a(String paramString)
  {
    if (paramString != null) {
      if (paramString.equals("1"))
      {
        if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().J)
        {
          this.a.b(null);
          if (!this.a.isResume()) {
            this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(false);
          }
        }
      }
      else if (paramString.startsWith("START"))
      {
        paramString = paramString.substring(6);
        this.a.b(paramString);
      }
    }
  }
  
  protected void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString1, paramInt1, paramString2, paramInt2);
    }
  }
  
  protected void a(String paramString, AVFunChat.AVFunChatMessage paramAVFunChatMessage) {}
  
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
      Object localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayList);
      String str;
      Object localObject2;
      if (QLog.isColorLevel())
      {
        str = this.a.jdField_b_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onChangeUI_CloseVideo, seq[");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append("], infoLogs[");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("]");
        QLog.w(str, 1, ((StringBuilder)localObject2).toString());
      }
      Collections.sort(paramArrayList, new AVActivity.MyControlUIObserver.2(this));
      int i = 0;
      while (i < paramArrayList.size())
      {
        localObject1 = (VideoViewInfo)paramArrayList.get(i);
        str = CharacterUtil.a(((VideoViewInfo)localObject1).jdField_a_of_type_Long);
        boolean bool2 = ((VideoViewInfo)localObject1).jdField_a_of_type_Boolean;
        int j = ((VideoViewInfo)localObject1).jdField_a_of_type_Int;
        if (!str.equals(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
        {
          if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(str, j))
          {
            if ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof MultiVideoCtrlLayerUIBase))) {
              this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(1037);
            }
            TipsUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
          }
          localObject2 = this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
          boolean bool1;
          if ((((VideoViewInfo)localObject1).jdField_b_of_type_Long != 5L) && (((VideoViewInfo)localObject1).jdField_b_of_type_Long != 14L)) {
            bool1 = false;
          } else {
            bool1 = true;
          }
          ((VideoLayerUI)localObject2).a(l, str, j, false, bool2, bool1);
        }
        else
        {
          if (((VideoViewInfo)localObject1).jdField_a_of_type_Int == 2) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0) {
            this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(l, false, false);
          }
        }
        i += 1;
      }
      this.a.i();
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
    if (this.a.jdField_a_of_type_Int == 4) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi != null) {
      this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.openCamera(paramLong);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      AVActivity.a(this.a);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, true, paramBoolean);
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().y))
      {
        String str1 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        int i = AVUtil.b(this.a.jdField_d_of_type_Int);
        String str2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, str1, String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().f));
        float f = 12.0F;
        if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(str1, 1)) {
          f = 18.0F;
        }
        f = UITools.a(this.a.getApplicationContext(), f);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(str1, 1, str2, f, -1);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, str1, 1, this.a.jdField_b_of_type_AndroidGraphicsBitmap, true, true);
      }
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null) {
      this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a();
    }
  }
  
  protected void b()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.l)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.l = false;
      AVActivity localAVActivity = this.a;
      localAVActivity.e = true;
      localAVActivity.finish();
    }
  }
  
  protected void b(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  protected void b(int paramInt, long paramLong)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNotify_ChatRoom_InputPanelChange, lastPanelState[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.i("ChatRoomUtil", 4, localStringBuilder.toString());
    }
    this.a.a(paramLong, 1);
  }
  
  protected void b(long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onChangeUI_Normal2Meeting, cur[");
      ((StringBuilder)localObject1).append(localSessionInfo);
      ((StringBuilder)localObject1).append("]");
      QLog.i("normal_2_meeting", 2, ((StringBuilder)localObject1).toString());
    }
    int i = this.a.jdField_b_of_type_Int;
    Object localObject1 = this.a.jdField_d_of_type_JavaLangString;
    int j = this.a.jdField_d_of_type_Int;
    if ((this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0)) {
      this.a.a(paramLong, "onChangeUI_Normal2Meeting", false);
    }
    if ((localSessionInfo.az) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.c();
    }
    if ((localSessionInfo.aA) || ((this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.d() != 1)))
    {
      localSessionInfo.aA = false;
      this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.m();
    }
    boolean bool = localSessionInfo.jdField_g_of_type_Boolean;
    if (localSessionInfo.jdField_g_of_type_Int == 16)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(null);
      }
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      this.a.a(4, false);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramLong, localSessionInfo.c, 1, false, false, false);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramLong);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
    }
    Object localObject2 = this.a;
    ((AVActivity)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    ((AVActivity)localObject2).a("onChangeUI_Normal2Meeting", true);
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
      this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.closeCamera(paramLong, true);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(paramLong, false, false);
      }
      localSessionInfo.b(paramLong, false);
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
    if (localSessionInfo.c == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("double_2_multi", 2, "onChangeUI_Normal2Meeting-->Peer uin is null!!!!!!!!!");
      }
      return;
    }
    long l = localSessionInfo.f;
    localSessionInfo.jdField_g_of_type_Long = Long.valueOf(localSessionInfo.c).longValue();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(null);
    }
    if (bool) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a("AVActivity.onChangeUI_Normal2Meeting", l, false, false, -1);
    }
    localSessionInfo.d("AVActivity.onChangeUI_Normal2Meeting", false);
    this.a.jdField_d_of_type_Int = localSessionInfo.k;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, localSessionInfo.jdField_d_of_type_Int, false, true);
    if ((localSessionInfo.jdField_j_of_type_Boolean) || (localSessionInfo.aw)) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, localSessionInfo.jdField_d_of_type_Int, false, false);
    }
    this.a.jdField_d_of_type_JavaLangString = String.valueOf(localSessionInfo.f);
    if (this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null) {
      this.a.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onChangeUI_Normal2Meeting end, oldSessionType[");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("], oldUinType[");
    ((StringBuilder)localObject2).append(j);
    ((StringBuilder)localObject2).append("], oldRelationId[");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("], mRelationId[");
    ((StringBuilder)localObject2).append(this.a.jdField_d_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("], sessionInfo[");
    ((StringBuilder)localObject2).append(localSessionInfo);
    ((StringBuilder)localObject2).append("]");
    QLog.w("normal_2_meeting", 1, ((StringBuilder)localObject2).toString());
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
    if (QLog.isColorLevel())
    {
      String str = this.a.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChangeUI_ChildLockStateChange, lock[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
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
    ViewGroup localViewGroup = (ViewGroup)this.a.findViewById(2131363127);
    if (localViewGroup != null) {
      DoodleUtils.a(localViewGroup);
    }
  }
  
  protected void c(int paramInt)
  {
    int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    if (i != 1)
    {
      if (i == 3) {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f()) {
        return;
      }
      if ((this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.a())) {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
      {
        if ((this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi == null) && ((this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI)))
        {
          AVActivity localAVActivity1 = this.a;
          VideoAppInterface localVideoAppInterface = localAVActivity1.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
          AVActivity localAVActivity2 = this.a;
          localAVActivity1.jdField_a_of_type_ComTencentAvUiChildGuideUi = new ChildGuideUi(localVideoAppInterface, localAVActivity2, localAVActivity2.jdField_a_of_type_ComTencentAvUiVideoControlUI, (RelativeLayout)AVActivity.a(this.a, 2131373364));
        }
        if ((this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi != null) && (this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.c()))
        {
          this.a.jdField_a_of_type_ComTencentAvUiChildGuideUi.e();
          ReportController.b(null, "CliOper", "", "", "0X80061F6", "0X80061F6", 0, 0, "", "", "", "");
          return;
        }
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramInt);
      }
    }
  }
  
  protected void c(long paramLong)
  {
    this.a.a(paramLong);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChangeUI_NotifyChangedZimuPeer id=");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.startsWith("SUPPORT"))) {
      d(2);
    }
  }
  
  public void d()
  {
    AVActivity localAVActivity = this.a;
    localAVActivity.b(-1048L, "onChangeUI_RecordStateChange", localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.i() ^ true);
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
    if (this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi != null) {
      this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.switchCamera(paramLong);
    }
  }
  
  protected void e() {}
  
  protected void e(int paramInt)
  {
    long l = AudioHelper.b();
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2)
    {
      localObject = this.a.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChangeUI_MagicFacePlayStateChange, state[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      localObject = this.a;
      ((AVActivity)localObject).b(l, "onChangeUI_MagicFacePlayStateChange", ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoControlUI.i() ^ true);
    }
    if ((this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView != null) && (this.a.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView.getVisibility() == 0) && (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null)) {
      this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.n();
    }
    Object localObject = this.a;
    if (paramInt != 5) {
      bool1 = false;
    }
    ((AVActivity)localObject).d(bool1);
  }
  
  protected void e(long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.C(paramLong);
    }
  }
  
  protected void f()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.k(false);
    }
  }
  
  protected void f(long paramLong)
  {
    AVActivity.a(this.a, paramLong);
  }
  
  protected void g()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.k(true);
    }
  }
  
  public void h()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      AVActivity localAVActivity = this.a;
      localAVActivity.b(-1050L, "onRequest_RefreshRecordBtn", localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.i() ^ true);
    }
  }
  
  protected void i()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      String str = this.a.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChangeUI_SmallView_Position_change, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
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
    this.a.g(true);
  }
  
  protected void k()
  {
    TipsUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1008, 2131695485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.MyControlUIObserver
 * JD-Core Version:    0.7.0.1
 */