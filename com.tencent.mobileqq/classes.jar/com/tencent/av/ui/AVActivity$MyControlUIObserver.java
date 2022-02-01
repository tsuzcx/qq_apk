package com.tencent.av.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.av.AVFunChat.AVFunChatMessage;
import com.tencent.av.VideoController;
import com.tencent.av.abtest.QavEffectUIABTestUtils;
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
import com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView;
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
    this.a.h(-1032L);
    if ((this.a.K != null) && (this.a.I != null) && ((2 == this.a.I.k().g) || (this.a.A)) && (!this.a.K.bi)) {
      this.a.K.c(-1032L, "onChangeUI_ShowControlUI");
    }
  }
  
  protected void a(int paramInt) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (this.a.K != null) {
      this.a.K.a(paramInt1, paramInt2, paramString);
    }
  }
  
  protected void a(int paramInt, long paramLong)
  {
    if (this.a.K != null)
    {
      if (this.a.isDestroyed()) {
        return;
      }
      String str = this.a.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnNotify_Effect_Toolbar_Selected, btnId[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      if (paramInt == 100) {
        this.a.K.aA.a(paramLong, 0, true);
      }
      if (paramInt == 4)
      {
        boolean bool = EffectFilterTools.a(this.a.getBaseContext());
        EffectFilterTools.DataReport.a(bool);
        if (bool)
        {
          if (this.a.aa == null) {
            this.a.k();
          }
          if ((this.a.L.B() != 3) && (this.a.L.B() != 4)) {
            this.a.L.a("onChangeUI_EffectToolbarSelected");
          }
          bool = this.a.I.k().B;
          this.a.aa.a(this.a.L.V(), bool);
          ThreadManager.getUIHandler().post(new AVActivity.MyControlUIObserver.4(this));
        }
      }
      else
      {
        this.a.l();
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
    if ((this.a.K != null) && (paramBoolean) && (PtuResChecker.b(paramInt)) && (PtuResChecker.c())) {
      this.a.runOnUiThread(new AVActivity.MyControlUIObserver.5(this));
    }
  }
  
  protected void a(long paramLong)
  {
    if (!this.a.isDestroyed())
    {
      if (this.a.I == null) {
        return;
      }
      SessionInfo localSessionInfo = this.a.I.k();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onChangeUI_DobuleAudio2MultiAudio, isBackground_Stop[");
        ((StringBuilder)localObject1).append(this.a.H.isBackgroundStop);
        ((StringBuilder)localObject1).append("], ActivityState[");
        ((StringBuilder)localObject1).append(this.a.s());
        ((StringBuilder)localObject1).append("], getVideoAbilityLevel[");
        ((StringBuilder)localObject1).append(this.a.I.X());
        ((StringBuilder)localObject1).append("], session[");
        ((StringBuilder)localObject1).append(localSessionInfo);
        ((StringBuilder)localObject1).append("], seq[");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append("]");
        QLog.w("double_2_multi", 2, ((StringBuilder)localObject1).toString());
      }
      int j = this.a.b;
      String str = this.a.k;
      int k = this.a.e;
      if ((this.a.ac != null) && (this.a.ac.getVisibility() == 0)) {
        this.a.a(paramLong, "onChangeUI_DobuleAudio2MultiAudio", false);
      }
      if ((localSessionInfo.cB) && (this.a.ad != null)) {
        this.a.ad.e();
      }
      if ((localSessionInfo.cD) || ((this.a.ad != null) && (this.a.ad.o() != 1)))
      {
        localSessionInfo.cD = false;
        this.a.ad.D();
      }
      boolean bool = localSessionInfo.E;
      if (localSessionInfo.j == 11)
      {
        if (this.a.K != null) {
          this.a.K.c(null);
        }
        return;
      }
      if (this.a.L != null)
      {
        if ((this.a.I.X() == 4) && (QAVConfigUtils.c())) {
          i = 3;
        } else {
          i = 4;
        }
        this.a.a(i, false);
        this.a.L.a(paramLong, localSessionInfo.s, 1, false, false, false);
      }
      if (this.a.K != null)
      {
        this.a.K.d(paramLong);
        this.a.K = null;
      }
      Object localObject1 = this.a;
      ((AVActivity)localObject1).G = null;
      ((AVActivity)localObject1).a("onChangeUI_DobuleAudio2MultiAudio", false);
      this.a.b = localSessionInfo.g;
      if (this.a.N != null) {
        this.a.N.g();
      }
      if (!VcSystemInfo.isNormalSharp())
      {
        this.a.M.closeCamera(paramLong, true);
        if (this.a.L != null) {
          this.a.L.b(paramLong, false, false);
        }
        localSessionInfo.b(paramLong, false);
      }
      DoodleLogic.b().a();
      this.a.a(paramLong, true);
      if (this.a.K != null)
      {
        this.a.K.a(paramLong);
        if (this.a.a != 4) {
          this.a.K.b(paramLong);
        }
      }
      long l1 = Long.valueOf(this.a.H.getCurrentAccountUin()).longValue();
      if (localSessionInfo.s == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->Peer uin is null!!!!!!!!!");
        }
        return;
      }
      localSessionInfo.aX = Long.valueOf(localSessionInfo.s).longValue();
      long l2 = localSessionInfo.aN;
      if ((localSessionInfo.p != 1) && (localSessionInfo.p == 3000)) {
        localSessionInfo.aO = this.a.H.g(String.valueOf(l2));
      }
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onChangeUI_DobuleAudio2MultiAudio uinList[");
        if (localSessionInfo.aO == null) {
          localObject1 = "null";
        } else {
          localObject1 = Integer.valueOf(localSessionInfo.aO.length);
        }
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append("]");
        QLog.i("double_2_multi", 4, ((StringBuilder)localObject2).toString());
      }
      localObject1 = localSessionInfo.aO;
      Object localObject2 = new ArrayList();
      int i = 0;
      while ((localObject1 != null) && (i < localObject1.length))
      {
        if ((localObject1[i] != l1) && (localObject1[i] != localSessionInfo.aX)) {
          ((ArrayList)localObject2).add(Long.valueOf(localSessionInfo.aO[i]));
        }
        i += 1;
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        i = ((ArrayList)localObject2).size();
        l1 = ((Long)((ArrayList)localObject2).get(0)).longValue();
        int m = AVUtil.d(localSessionInfo.aQ);
        localObject2 = this.a.H.a(m, String.valueOf(l1), String.valueOf(localSessionInfo.aN));
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
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131899103));
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131899102));
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        localObject1 = String.format(this.a.getString(2131893661), new Object[] { localObject2 });
        if (this.a.K != null) {
          this.a.K.c((String)localObject1);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->inviteList is null");
      }
      if (bool) {
        this.a.I.a("AVActivity.onChangeUI_DobuleAudio2MultiAudio", l2, false, false, -1);
      }
      localSessionInfo.e("onChangeUI_DobuleAudio2MultiAudio", 0);
      this.a.I.p(false);
      this.a.I.q(false);
      this.a.e = localSessionInfo.p;
      if (this.a.b == 4) {
        this.a.I.a(paramLong, this.a.b, false, false);
      }
      this.a.k = String.valueOf(localSessionInfo.aN);
      if (this.a.ai != null) {
        this.a.ai.e();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onChangeUI_DobuleAudio2MultiAudio end, oldSessionType[");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append("], oldUinType[");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append("], oldRelationId[");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("], mRelationId[");
      ((StringBuilder)localObject1).append(this.a.k);
      ((StringBuilder)localObject1).append("], sessionInfo[");
      ((StringBuilder)localObject1).append(localSessionInfo);
      ((StringBuilder)localObject1).append("]");
      QLog.w("double_2_multi", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    String str = this.a.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNotify_MenuView_Changed, menuType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.a.h(paramLong);
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.a.K != null) {
      this.a.K.a(paramLong, paramInt1, paramInt2);
    }
  }
  
  protected void a(long paramLong, ArrayList<VideoViewInfo> paramArrayList)
  {
    long l = paramLong;
    Object localObject2 = paramArrayList;
    if ((this.a.a != 4) && (this.a.a != 5) && (this.a.a != 3))
    {
      Object localObject3 = null;
      Object localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject1 = localObject3;
        if (this.a.I != null) {
          localObject1 = this.a.I.a((ArrayList)localObject2);
        }
      }
      Object localObject4;
      if (QLog.isColorLevel())
      {
        localObject3 = this.a.i;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("onRequest_ShowVideo, infoLogs[");
        ((StringBuilder)localObject4).append((String)localObject1);
        ((StringBuilder)localObject4).append("], seq[");
        ((StringBuilder)localObject4).append(l);
        ((StringBuilder)localObject4).append("]");
        QLog.w((String)localObject3, 1, ((StringBuilder)localObject4).toString());
      }
      if ((this.a.L != null) && (localObject2 != null) && (this.a.I != null))
      {
        int i = this.a.I.X();
        Collections.sort((List)localObject2, new AVActivity.MyControlUIObserver.1(this));
        if (QLog.isColorLevel())
        {
          localObject2 = this.a.i;
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
          localObject4 = CharacterUtil.a(((VideoViewInfo)localObject3).a);
          int m = ((VideoViewInfo)localObject3).b;
          boolean bool1 = ((VideoViewInfo)localObject3).c;
          boolean bool4 = this.a.L.b((String)localObject4, m);
          int k = AVUtil.c(this.a.e);
          localObject2 = this.a.H.a(k, (String)localObject4, String.valueOf(this.a.I.k().aN));
          if (((VideoViewInfo)localObject3).d)
          {
            boolean bool2;
            if (!((String)localObject4).equals(this.a.H.getCurrentAccountUin()))
            {
              localObject1 = this.a.L;
              if ((((VideoViewInfo)localObject3).g != 5L) && (((VideoViewInfo)localObject3).g != 14L)) {
                bool2 = false;
              } else {
                bool2 = true;
              }
              boolean bool3 = bool1;
              ((VideoLayerUI)localObject1).a(paramLong, (String)localObject4, m, true, bool3, bool2);
              if (bool3) {
                if (!((VideoViewInfo)localObject3).f)
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
                    localObject1 = String.format(this.a.getString(2131893280), new Object[] { localObject1 });
                    if ((this.a.K != null) && ((this.a.K instanceof MultiVideoCtrlLayerUIBase))) {
                      this.a.K.a(1036, (String)localObject1);
                    } else {
                      TipsUtil.a(this.a.H, 1036, (String)localObject1);
                    }
                  }
                  else
                  {
                    localObject1 = String.format(this.a.getString(2131893281), new Object[] { localObject1 });
                    if (QLog.isColorLevel())
                    {
                      String str = this.a.i;
                      StringBuilder localStringBuilder = new StringBuilder();
                      localStringBuilder.append("onRequest_ShowVideo, will loading name[");
                      localStringBuilder.append((String)localObject2);
                      localStringBuilder.append("]");
                      QLog.d(str, 1, localStringBuilder.toString());
                    }
                    if ((this.a.K != null) && ((this.a.K instanceof MultiVideoCtrlLayerUIBase))) {
                      this.a.K.a(1037, (String)localObject1);
                    } else {
                      TipsUtil.a(this.a.H, 1037, (String)localObject1);
                    }
                  }
                }
                else {}
              }
            }
            else
            {
              bool2 = bool1;
              if ((((String)localObject4).equals(this.a.H.getCurrentAccountUin())) && (m == 2)) {
                k = 1;
              } else {
                k = 0;
              }
              if (k != 0)
              {
                this.a.L.a(paramLong, true, bool2);
              }
              else
              {
                this.a.M.openCamera(paramLong);
                this.a.L.b(paramLong, true, bool2);
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
            if ((!((VideoViewInfo)localObject3).d) && (!((VideoViewInfo)localObject3).c))
            {
              if (i != 4)
              {
                if (this.a.I.k().aQ == 2) {
                  ReportController.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
                } else if (this.a.I.k().o == 10) {
                  ReportController.b(null, "CliOper", "", "", "0X800594A", "0X800594A", 0, 0, "", "", "", "");
                } else {
                  ReportController.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
                }
                if (this.a.O == null)
                {
                  localObject1 = this.a;
                  ((AVActivity)localObject1).O = UITools.a(((AVActivity)localObject1).getApplicationContext(), 2130843140);
                }
                this.a.L.a(paramLong, (String)localObject4, m, this.a.O, ((VideoViewInfo)localObject3).d, ((VideoViewInfo)localObject3).c);
              }
              else
              {
                this.a.L.a(paramLong, (String)localObject4, m, this.a.P, ((VideoViewInfo)localObject3).d, ((VideoViewInfo)localObject3).c);
              }
            }
            else {
              this.a.L.a(paramLong, (String)localObject4, m, this.a.P, ((VideoViewInfo)localObject3).d, ((VideoViewInfo)localObject3).c);
            }
          }
          if ((!bool4) && (!this.a.I.k().am))
          {
            float f = 12.0F;
            if ((bool1) && (this.a.L.B() != 3)) {
              f = 18.0F;
            }
            f = UITools.a(this.a.getApplicationContext(), f);
            this.a.L.a((String)localObject4, m, (String)localObject2, f, -1);
            this.a.L.d((String)localObject4, m);
          }
          j += 1;
        }
        this.a.L.a(this.a.V, false);
      }
      if (this.a.K != null) {
        this.a.K.b(paramLong, this.a.V);
      }
      if ((this.a.M != null) && (this.a.I != null) && (this.a.I.k().o != 2)) {
        this.a.M.setRotation(this.a.V);
      }
      if (this.a.J != null) {
        this.a.J.b();
      }
      if (this.a.ai != null) {
        this.a.ai.e();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.i, 2, "onRequest_ShowVideo ignore ");
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWatchTogetherModeChange, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], enter[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.a.K != null)
    {
      localObject = this.a.I.k();
      int i = ((SessionInfo)localObject).g;
      if (paramBoolean)
      {
        if (!this.a.K.aA.i(0)) {
          this.a.K.aA.a(paramLong, 0, true);
        }
        if ((this.a.L != null) && (this.a.L.V())) {
          this.a.h(false);
        }
        if (this.a.ai != null) {
          this.a.ai.c(3);
        }
        if ((((SessionInfo)localObject).cB) && (this.a.ad != null)) {
          this.a.ad.e();
        }
        new ControlUIObserver.ZimuRequest(paramLong, "onWatchTogetherModeChange", 2, null).a(this.a.H);
        this.a.l();
        localObject = this.a.K.am();
        if (localObject != null) {
          ((QavEffectBaseMenuView)localObject).c();
        }
      }
      else if (((i == 1) || (i == 3)) && ((!this.a.K.af) || (!this.a.K.ab())))
      {
        this.a.K.d(0);
      }
      this.a.K.I(paramLong);
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void a(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    if (this.a.isDestroyed()) {
      return;
    }
    if (this.a.K != null)
    {
      if (this.a.K.V()) {
        return;
      }
      boolean bool = true;
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        this.a.K.p(true);
        this.a.K.p();
      }
      if ((paramBoolean1) && (paramBoolean2)) {
        this.a.K.p(false);
      }
      if ((paramBoolean1) && (!paramBoolean2)) {
        this.a.ab.a(paramLong1, this.a, 2, 2);
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
      QLog.d(this.a.i, 2, " onChangeUI_receiveTransferMsg ");
    }
    if (this.a.e == 9500)
    {
      if ((paramObject instanceof VcControllerImpl.DeviceCMDTLV))
      {
        paramObject = (VcControllerImpl.DeviceCMDTLV)paramObject;
        if (paramObject.b == 6)
        {
          if ((paramObject.c & 0x1) == 1)
          {
            if ((this.a.K instanceof DoubleVideoCtrlUI))
            {
              this.a.I.aa = true;
              ((DoubleVideoCtrlUI)this.a.K).a(2131441025, true, 2130843005);
            }
          }
          else if (((paramObject.c & 0x1) == 0) && ((this.a.K instanceof DoubleVideoCtrlUI)))
          {
            this.a.I.aa = false;
            ((DoubleVideoCtrlUI)this.a.K).a(2131441025, false, 2130843005);
          }
          if (((paramObject.c & 0x4) == 4) && ((this.a.K instanceof DoubleVideoCtrlUI)))
          {
            this.a.I.ab = true;
            ((DoubleVideoCtrlUI)this.a.K).ac();
          }
          if (((paramObject.c & 0x8) == 8) && ((this.a.K instanceof DoubleVideoCtrlUI)))
          {
            this.a.I.ac = false;
            DoubleVideoCtrlUI localDoubleVideoCtrlUI = (DoubleVideoCtrlUI)this.a.K;
            this.a.H.a().postDelayed(new AVActivity.MyControlUIObserver.3(this, localDoubleVideoCtrlUI), 500L);
          }
          if (((paramObject.c & 0x2) == 2) && ((this.a.K instanceof DoubleVideoCtrlUI)))
          {
            paramObject = (DoubleVideoCtrlUI)this.a.K;
            this.a.I.k().c(0L, false);
          }
        }
        else if (paramObject.b == 5)
        {
          if (paramObject.c == 2)
          {
            if ((this.a.K instanceof DoubleVideoCtrlUI))
            {
              paramObject = (DoubleVideoCtrlUI)this.a.K;
              paramObject.a(2131893668, 2, 0, paramObject.aj.getDimensionPixelSize(2131299920));
            }
          }
          else if ((paramObject.c == 3) && ((this.a.K instanceof DoubleVideoCtrlUI)))
          {
            paramObject = (DoubleVideoCtrlUI)this.a.K;
            paramObject.a(2131893667, 1, 0, paramObject.aj.getDimensionPixelSize(2131299920));
          }
        }
      }
    }
    else if ((paramObject instanceof VcControllerImpl.DeviceCMDTLV))
    {
      paramObject = (VcControllerImpl.DeviceCMDTLV)paramObject;
      if ((paramObject.b == 11) && (paramObject.c == 1) && ((this.a.K instanceof DoubleVideoCtrlUI)))
      {
        this.a.I.ad = true;
        if (QLog.isColorLevel()) {
          QLog.d(this.a.i, 2, "receiveTransferMsg xiaowei Device");
        }
      }
    }
  }
  
  protected void a(String paramString)
  {
    if (paramString != null) {
      if (paramString.equals("1"))
      {
        if (!this.a.I.k().aM)
        {
          this.a.b(null);
          if (!this.a.isResume()) {
            this.a.I.k().a(false);
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
    if (this.a.K != null) {
      this.a.K.a(paramString1, paramInt1, paramString2, paramInt2);
    }
  }
  
  protected void a(String paramString, AVFunChat.AVFunChatMessage paramAVFunChatMessage) {}
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.a.ad != null) {
      this.a.ad.a(paramString1, paramString2);
    }
  }
  
  protected void a(ArrayList<VideoViewInfo> paramArrayList)
  {
    if ((this.a.L != null) && (paramArrayList != null))
    {
      long l = AudioHelper.c();
      Object localObject1 = this.a.I.a(paramArrayList);
      String str;
      Object localObject2;
      if (QLog.isColorLevel())
      {
        str = this.a.i;
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
        str = CharacterUtil.a(((VideoViewInfo)localObject1).a);
        boolean bool2 = ((VideoViewInfo)localObject1).c;
        int j = ((VideoViewInfo)localObject1).b;
        if (!str.equals(this.a.H.getCurrentAccountUin()))
        {
          if (this.a.L.c(str, j))
          {
            if ((this.a.K != null) && ((this.a.K instanceof MultiVideoCtrlLayerUIBase))) {
              this.a.K.k(1037);
            }
            TipsUtil.b(this.a.H, 1037);
          }
          localObject2 = this.a.L;
          boolean bool1;
          if ((((VideoViewInfo)localObject1).g != 5L) && (((VideoViewInfo)localObject1).g != 14L)) {
            bool1 = false;
          } else {
            bool1 = true;
          }
          ((VideoLayerUI)localObject2).a(l, str, j, false, bool2, bool1);
        }
        else
        {
          if (((VideoViewInfo)localObject1).b == 2) {
            j = 1;
          } else {
            j = 0;
          }
          if (j != 0) {
            this.a.L.a(l, false, false);
          }
        }
        i += 1;
      }
      this.a.l();
    }
    if (this.a.J != null) {
      this.a.J.b();
    }
    if (this.a.ai != null) {
      this.a.ai.e();
    }
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    if (this.a.a == 4) {
      return;
    }
    if (this.a.M != null) {
      this.a.M.openCamera(paramLong);
    }
    if (this.a.L != null)
    {
      AVActivity.a(this.a);
      if (this.a.I.k().cx) {
        this.a.L.c(paramLong, Boolean.valueOf(paramBoolean));
      } else {
        this.a.L.b(paramLong, true, paramBoolean);
      }
      if ((this.a.I.k().g == 4) && (!this.a.I.k().am))
      {
        String str1 = this.a.H.getCurrentAccountUin();
        int i = AVUtil.c(this.a.e);
        String str2 = this.a.H.a(i, str1, String.valueOf(this.a.I.k().aN));
        float f = 12.0F;
        if (this.a.L.c(str1, 1)) {
          f = 18.0F;
        }
        f = UITools.a(this.a.getApplicationContext(), f);
        this.a.L.a(str1, 1, str2, f, -1);
        this.a.L.a(paramLong, str1, 1, this.a.P, true, true);
      }
    }
    if (this.a.ai != null) {
      this.a.ai.e();
    }
  }
  
  protected void b()
  {
    if (this.a.I.X)
    {
      this.a.I.X = false;
      AVActivity localAVActivity = this.a;
      localAVActivity.y = true;
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
    if (this.a.I == null) {
      return;
    }
    SessionInfo localSessionInfo = this.a.I.k();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onChangeUI_Normal2Meeting, cur[");
      ((StringBuilder)localObject1).append(localSessionInfo);
      ((StringBuilder)localObject1).append("]");
      QLog.i("normal_2_meeting", 2, ((StringBuilder)localObject1).toString());
    }
    int i = this.a.b;
    Object localObject1 = this.a.k;
    int j = this.a.e;
    if ((this.a.ac != null) && (this.a.ac.getVisibility() == 0)) {
      this.a.a(paramLong, "onChangeUI_Normal2Meeting", false);
    }
    if ((localSessionInfo.cB) && (this.a.ad != null)) {
      this.a.ad.e();
    }
    if ((localSessionInfo.cD) || ((this.a.ad != null) && (this.a.ad.o() != 1)))
    {
      localSessionInfo.cD = false;
      this.a.ad.D();
    }
    boolean bool = localSessionInfo.E;
    if (localSessionInfo.j == 16)
    {
      if (this.a.K != null) {
        this.a.K.c(null);
      }
      return;
    }
    if (this.a.L != null)
    {
      this.a.a(4, false);
      this.a.L.a(paramLong, localSessionInfo.s, 1, false, false, false);
    }
    if (this.a.K != null)
    {
      this.a.K.d(paramLong);
      this.a.K = null;
    }
    Object localObject2 = this.a;
    ((AVActivity)localObject2).G = null;
    ((AVActivity)localObject2).a("onChangeUI_Normal2Meeting", true);
    if (localSessionInfo.g == 2)
    {
      localSessionInfo.g = 1;
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "onChangeUI_Normal2Meeting video to audio .");
      }
    }
    this.a.b = localSessionInfo.g;
    if (this.a.b == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "onChangeUI_Normal2Meeting illegal session type.");
      }
      this.a.b = 1;
    }
    if (this.a.N != null) {
      this.a.N.g();
    }
    if (!VcSystemInfo.isNormalSharp())
    {
      this.a.M.closeCamera(paramLong, true);
      if (this.a.L != null) {
        this.a.L.b(paramLong, false, false);
      }
      localSessionInfo.b(paramLong, false);
    }
    DoodleLogic.b().a();
    this.a.a(paramLong, true);
    if (this.a.K != null)
    {
      this.a.K.a(paramLong);
      if (this.a.a != 4) {
        this.a.K.b(paramLong);
      }
    }
    if (localSessionInfo.s == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("double_2_multi", 2, "onChangeUI_Normal2Meeting-->Peer uin is null!!!!!!!!!");
      }
      return;
    }
    long l = localSessionInfo.aN;
    localSessionInfo.aX = Long.valueOf(localSessionInfo.s).longValue();
    if (this.a.K != null) {
      this.a.K.c(null);
    }
    if (bool) {
      this.a.I.a("AVActivity.onChangeUI_Normal2Meeting", l, false, false, -1);
    }
    localSessionInfo.d("AVActivity.onChangeUI_Normal2Meeting", false);
    this.a.e = localSessionInfo.p;
    this.a.I.a(paramLong, localSessionInfo.g, false, true);
    if ((localSessionInfo.H) || (localSessionInfo.cn)) {
      this.a.I.a(paramLong, localSessionInfo.g, false, false);
    }
    this.a.k = String.valueOf(localSessionInfo.aN);
    if (this.a.ai != null) {
      this.a.ai.e();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onChangeUI_Normal2Meeting end, oldSessionType[");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("], oldUinType[");
    ((StringBuilder)localObject2).append(j);
    ((StringBuilder)localObject2).append("], oldRelationId[");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("], mRelationId[");
    ((StringBuilder)localObject2).append(this.a.k);
    ((StringBuilder)localObject2).append("], sessionInfo[");
    ((StringBuilder)localObject2).append(localSessionInfo);
    ((StringBuilder)localObject2).append("]");
    QLog.w("normal_2_meeting", 1, ((StringBuilder)localObject2).toString());
  }
  
  protected void b(String paramString)
  {
    if (this.a.K != null) {
      this.a.K.h(paramString);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = this.a.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChangeUI_ChildLockStateChange, lock[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.a.K != null) {
      this.a.K.f(l, 2048);
    }
    if ((this.a.ac != null) && (this.a.ac.getVisibility() == 0) && (this.a.ad != null)) {
      this.a.ad.E();
    }
  }
  
  protected void c()
  {
    ViewGroup localViewGroup = (ViewGroup)this.a.findViewById(2131428980);
    if (localViewGroup != null) {
      DoodleUtils.a(localViewGroup);
    }
  }
  
  protected void c(int paramInt)
  {
    int i = this.a.I.k().g;
    if (i != 1)
    {
      if (i == 3) {
        return;
      }
      if (this.a.I.k().f()) {
        return;
      }
      if ((this.a.N != null) && (this.a.N.e())) {
        return;
      }
      if (this.a.K != null)
      {
        if ((this.a.N == null) && ((this.a.K instanceof DoubleVideoCtrlUI)))
        {
          AVActivity localAVActivity1 = this.a;
          VideoAppInterface localVideoAppInterface = localAVActivity1.H;
          AVActivity localAVActivity2 = this.a;
          localAVActivity1.N = new ChildGuideUi(localVideoAppInterface, localAVActivity2, localAVActivity2.K, (RelativeLayout)AVActivity.a(this.a, 2131441037));
        }
        if ((this.a.N != null) && (this.a.N.i()))
        {
          this.a.N.f();
          ReportController.b(null, "CliOper", "", "", "0X80061F6", "0X80061F6", 0, 0, "", "", "", "");
          return;
        }
        this.a.K.e(paramInt);
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
      String str = this.a.i;
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
    localAVActivity.b(-1048L, "onChangeUI_RecordStateChange", localAVActivity.K.ab() ^ true);
  }
  
  public void d(int paramInt)
  {
    if (this.a.ad != null) {
      this.a.ad.g(paramInt);
    }
  }
  
  protected void d(long paramLong)
  {
    AVTraceUtil.a("switch_camera", "onRequest_SwitchCamera", 3, new Object[] { Long.valueOf(paramLong) });
    if (this.a.M != null) {
      this.a.M.switchCamera(paramLong);
    }
  }
  
  protected void e() {}
  
  protected void e(int paramInt)
  {
    long l = AudioHelper.c();
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2)
    {
      localObject = this.a.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChangeUI_MagicFacePlayStateChange, state[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (this.a.K != null)
    {
      localObject = this.a;
      ((AVActivity)localObject).b(l, "onChangeUI_MagicFacePlayStateChange", ((AVActivity)localObject).K.ab() ^ true);
    }
    if ((this.a.ac != null) && (this.a.ac.getVisibility() == 0) && (this.a.ad != null)) {
      this.a.ad.E();
    }
    Object localObject = this.a;
    if (paramInt != 5) {
      bool1 = false;
    }
    ((AVActivity)localObject).e(bool1);
  }
  
  protected void e(long paramLong)
  {
    if (this.a.K != null)
    {
      if (QavEffectUIABTestUtils.b(this.a.H.getCurrentAccountUin()))
      {
        this.a.K.I(-1056L);
        return;
      }
      this.a.K.I(paramLong);
    }
  }
  
  protected void f()
  {
    if (this.a.L != null)
    {
      this.a.L.i(6);
      this.a.L.m(6);
    }
  }
  
  protected void f(long paramLong)
  {
    AVActivity.a(this.a, paramLong);
  }
  
  protected void g()
  {
    if (this.a.L != null)
    {
      this.a.L.i(1);
      this.a.L.m(1);
    }
  }
  
  protected void h()
  {
    this.a.K.e(AudioHelper.c(), null);
  }
  
  protected void i()
  {
    if (this.a.K != null) {
      this.a.K.n(false);
    }
  }
  
  protected void j()
  {
    if (this.a.K != null) {
      this.a.K.n(true);
    }
  }
  
  public void k()
  {
    if (this.a.K != null)
    {
      AVActivity localAVActivity = this.a;
      localAVActivity.b(-1050L, "onRequest_RefreshRecordBtn", localAVActivity.K.ab() ^ true);
    }
  }
  
  protected void l()
  {
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = this.a.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChangeUI_SmallView_Position_change, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if ((this.a.K != null) && ((2 == this.a.I.k().g) || (this.a.A))) {
      this.a.K.c(l, "onChangeUI_SmallView_Position_change");
    }
  }
  
  protected void m()
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.i, 2, "onChangeUI_quitDoubleScreenStatus");
    }
    this.a.h(true);
  }
  
  protected void n()
  {
    TipsUtil.a(this.a.H, 1008, 2131893244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.MyControlUIObserver
 * JD-Core Version:    0.7.0.1
 */