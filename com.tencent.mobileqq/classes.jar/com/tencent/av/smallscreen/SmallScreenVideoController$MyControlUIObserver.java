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
    if (this.a.u != null) {
      this.a.u.a(0, 0, true);
    }
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onChangeUI_DobuleAudio2MultiAudio, isBackground_Stop[");
      ((StringBuilder)localObject).append(this.a.r.isBackgroundStop);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("double_2_multi", 1, ((StringBuilder)localObject).toString());
    }
    if (this.a.s == null) {
      return;
    }
    SmallScreenVideoController.a(this.a, 1);
    Object localObject = this.a.s.k();
    if (((SessionInfo)localObject).j == 11) {
      return;
    }
    if (this.a.u != null) {
      this.a.u.a(((SessionInfo)localObject).s, 1, false, false, false);
    }
    if (this.a.t != null)
    {
      this.a.t.a(paramLong);
      this.a.t = null;
    }
    SmallScreenVideoController localSmallScreenVideoController = this.a;
    localSmallScreenVideoController.q = false;
    localSmallScreenVideoController.g = ((SessionInfo)localObject).g;
    this.a.h = ((SessionInfo)localObject).h;
    if (!VcSystemInfo.isNormalSharp())
    {
      this.a.u.a(false, false);
      ((SessionInfo)localObject).b(paramLong, false);
    }
    this.a.a(true);
    if (this.a.t != null)
    {
      this.a.t.b();
      if (this.a.f != 2) {
        this.a.t.e();
      }
    }
    if (((SessionInfo)localObject).s == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->Peer uin is null!!!!!!!!!");
      }
      return;
    }
    ((SessionInfo)localObject).aX = Long.valueOf(((SessionInfo)localObject).s).longValue();
    long l = ((SessionInfo)localObject).aN;
    if (((SessionInfo)localObject).p == 3000) {
      ((SessionInfo)localObject).aO = this.a.r.g(String.valueOf(l));
    }
    ((SessionInfo)localObject).e("onChangeUI_DobuleAudio2MultiAudio", 0);
    this.a.s.p(false);
    this.a.s.q(false);
    this.a.i = ((SessionInfo)localObject).p;
    if (this.a.g == 4) {
      this.a.s.a(paramLong, this.a.g, false, false);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.r.b().p(this.a.r.b().k().s));
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    MagicDataReport.a(this.a.r, (String)localObject);
    MagicDataReport.a(2, (String)localObject);
    MagicDataReport.a(2);
  }
  
  protected void a(long paramLong, ArrayList<VideoViewInfo> paramArrayList)
  {
    if ((this.a.u != null) && (paramArrayList != null))
    {
      Object localObject1 = this.a.s.a(paramArrayList);
      int k = this.a.s.X();
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
        localObject2 = String.valueOf(((VideoViewInfo)localObject1).a);
        int m = ((VideoViewInfo)localObject1).b;
        boolean bool3 = ((VideoViewInfo)localObject1).c;
        i = -1;
        if (this.a.i == 3000) {
          i = 1004;
        } else if (this.a.i == 1) {
          i = 1000;
        } else if (this.a.i == 0) {
          i = 0;
        }
        String str = this.a.r.a(i, (String)localObject2, String.valueOf(this.a.s.k().aN));
        if ((((VideoViewInfo)localObject1).d) && (!this.a.s.ag())) {
          if (!((String)localObject2).equals(this.a.r.getCurrentAccountUin()))
          {
            SmallScreenVideoLayerUI localSmallScreenVideoLayerUI = this.a.u;
            if ((((VideoViewInfo)localObject1).g != 5L) && (((VideoViewInfo)localObject1).g != 14L)) {
              bool1 = false;
            } else {
              bool1 = true;
            }
            localSmallScreenVideoLayerUI.a((String)localObject2, m, true, bool3, bool1);
          }
          else
          {
            this.a.v.openCamera(paramLong);
            this.a.u.a(true, bool3);
            i = 1;
            break label383;
          }
        }
        i = 0;
        label383:
        if (i == 0)
        {
          if ((!((VideoViewInfo)localObject1).d) && (!((VideoViewInfo)localObject1).c) && (k != 4)) {
            if (this.a.s.k().aQ == 2) {
              ReportController.b(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
            } else {
              ReportController.b(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
            }
          }
          this.a.u.a((String)localObject2, m, this.a.w, ((VideoViewInfo)localObject1).d, ((VideoViewInfo)localObject1).c);
        }
        if (!this.a.s.k().am)
        {
          float f = UITools.a(this.a.c, 12.0F);
          if (!((String)localObject2).equals(this.a.r.getCurrentAccountUin())) {
            this.a.u.a((String)localObject2, m, str, f, -1);
          }
          this.a.u.d((String)localObject2, m);
        }
        j += 1;
      }
      paramArrayList = this.a.u;
      i = this.a.y;
      if (this.a.x == null) {
        bool1 = bool2;
      } else {
        bool1 = this.a.x.c;
      }
      paramArrayList.a(i, bool1);
    }
    int i = this.a.y;
    int j = this.a.a.getRotation();
    if (this.a.t != null) {
      this.a.t.d((i + j * 90) % 360);
    }
    if (this.a.v != null) {
      this.a.v.setRotation(this.a.y);
    }
  }
  
  protected void a(String paramString)
  {
    if ((paramString != null) && (paramString.equals("1")) && (!this.a.s.k().aM))
    {
      this.a.s.k().a(true);
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
    if (this.a.s == null) {
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
        this.a.s.k().cA = true;
        this.a.s.k().cz = Math.max(this.a.s.k().cz, 730);
      }
      else if (paramString2.startsWith("SUPPORT_TRUE_7.3.5"))
      {
        this.a.s.k().cA = true;
        this.a.s.k().cz = Math.max(this.a.s.k().cz, 735);
        j = QavRecordUtils.a(paramString2, QavRecordDpc.a().i);
        paramString1 = new StringBuilder();
        paramString1.append("onChangeUi_ReceiveRecordMsg, SUPPORT_735 val=");
        paramString1.append(j);
        QLog.i("SmallScreenVideoController", 1, paramString1.toString());
        this.a.s.k().cC = (j * 60 * 1000L);
      }
    }
    int j = this.a.s.k().g;
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
            this.a.s.e(8, String.valueOf(6));
            break label531;
          }
        }
        this.a.s.e(8, String.valueOf(4));
        this.a.s.k().cD = false;
      }
    }
    else
    {
      this.a.s.e(8, String.valueOf(2));
      this.a.s.at();
      this.a.s.k().cD = true;
    }
    label531:
    d();
  }
  
  protected void a(ArrayList<VideoViewInfo> paramArrayList)
  {
    if ((this.a.u != null) && (paramArrayList != null))
    {
      Object localObject1 = this.a.s.a(paramArrayList);
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
        localObject2 = String.valueOf(((VideoViewInfo)localObject1).a);
        boolean bool2 = ((VideoViewInfo)localObject1).c;
        int j = ((VideoViewInfo)localObject1).b;
        if (!((String)localObject2).equals(this.a.r.getCurrentAccountUin()))
        {
          if (this.a.u.c((String)localObject2, j))
          {
            TipsUtil.b(this.a.r, 1036);
            TipsUtil.b(this.a.r, 1037);
          }
          SmallScreenVideoLayerUI localSmallScreenVideoLayerUI = this.a.u;
          boolean bool1;
          if ((((VideoViewInfo)localObject1).g != 5L) && (((VideoViewInfo)localObject1).g != 14L)) {
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
    if (this.a.f == 2) {
      return;
    }
    if ((this.a.v != null) && (!this.a.r.m())) {
      this.a.v.openCamera(paramLong);
    }
    if (this.a.u != null)
    {
      this.a.u.a(true, paramBoolean);
      this.a.u.c(paramLong, this.a.v.isFrontCamera());
    }
  }
  
  protected void b()
  {
    if (this.a.s.X)
    {
      this.a.s.X = false;
      SmallScreenVideoController localSmallScreenVideoController = this.a;
      localSmallScreenVideoController.o = true;
      localSmallScreenVideoController.d();
    }
  }
  
  protected void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onChangeUI_Normal2Meeting, isBackground_Stop[");
      ((StringBuilder)localObject).append(this.a.r.isBackgroundStop);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], session[");
      ((StringBuilder)localObject).append(this.a.s.k());
      ((StringBuilder)localObject).append("]");
      QLog.w("normal_2_meeting", 1, ((StringBuilder)localObject).toString());
    }
    if (this.a.s == null) {
      return;
    }
    SmallScreenVideoController.a(this.a, 1);
    Object localObject = this.a.s.k();
    if (((SessionInfo)localObject).j == 16) {
      return;
    }
    if (this.a.u != null) {
      this.a.u.a(((SessionInfo)localObject).s, 1, false, false, false);
    }
    if (this.a.t != null)
    {
      this.a.t.a(paramLong);
      this.a.t = null;
    }
    ((SessionInfo)localObject).f("onChangeUI_Normal2Meeting", true);
    SmallScreenVideoController localSmallScreenVideoController = this.a;
    localSmallScreenVideoController.q = true;
    localSmallScreenVideoController.g = 1;
    localSmallScreenVideoController.h = ((SessionInfo)localObject).h;
    if (!VcSystemInfo.isNormalSharp())
    {
      this.a.u.a(false, false);
      ((SessionInfo)localObject).b(paramLong, false);
    }
    this.a.a(true);
    if (this.a.t != null)
    {
      this.a.t.b();
      if (this.a.f != 2) {
        this.a.t.e();
      }
    }
    if (((SessionInfo)localObject).s == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("double_2_multi", 2, "onChangeUI_Normal2Meeting-->Peer uin is null!");
      }
      return;
    }
    ((SessionInfo)localObject).d("SmallScreen.onChangeUI_Normal2Meeting", false);
    localObject = this.a;
    ((SmallScreenVideoController)localObject).i = 0;
    ((SmallScreenVideoController)localObject).s.a(paramLong, this.a.g, false, true);
  }
  
  protected void c()
  {
    SmallScreenRelativeLayout localSmallScreenRelativeLayout;
    if (this.a.b == null) {
      localSmallScreenRelativeLayout = null;
    } else {
      localSmallScreenRelativeLayout = this.a.b.b(1);
    }
    if (localSmallScreenRelativeLayout != null) {
      DoodleUtils.a(localSmallScreenRelativeLayout);
    }
  }
  
  protected void c(long paramLong)
  {
    if (this.a.u != null)
    {
      this.a.u.a(false, false);
      SmallScreenVideoController.a(this.a, 1);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onChangeUI_RecordStateChange:");
    }
    Object localObject1;
    if (this.a.b == null) {
      localObject1 = null;
    } else {
      localObject1 = this.a.b.b(1);
    }
    if ((this.a.b != null) && (this.a.s != null))
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
      if ((!this.a.s.k().cD) && (!this.a.s.k().cB))
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
      if ((this.a.s.k().cB) && (this.a.s.k().cD))
      {
        ((TextView)((View)localObject1).findViewById(2013331472)).setText(2131893531);
      }
      else
      {
        if (this.a.s.k().cB)
        {
          ((TextView)((View)localObject1).findViewById(2013331472)).setText(2131893532);
          break label277;
        }
        ((TextView)((View)localObject1).findViewById(2013331472)).setText(2131893530);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.MyControlUIObserver
 * JD-Core Version:    0.7.0.1
 */