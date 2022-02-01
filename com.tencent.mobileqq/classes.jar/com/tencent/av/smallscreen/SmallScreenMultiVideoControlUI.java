package com.tencent.av.smallscreen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.GAudioSoundUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.api.ITraeMediaPlayerApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class SmallScreenMultiVideoControlUI
  extends SmallScreenVideoControlUI
{
  static int a = 16;
  int b = -1;
  int c = -1;
  int d = 0;
  long[] e = null;
  long f = 0L;
  Runnable g = null;
  Runnable h = null;
  Runnable i = null;
  Runnable j = null;
  boolean k = false;
  String l = null;
  QAVNotification m = null;
  ITraeMediaPlayerApi n = null;
  GAudioUIObserver o = new SmallScreenMultiVideoControlUI.MyGAudioUIObserver(this, null);
  SmallScreenMultiVideoControlUI.StartRecvVideoRunnable p = new SmallScreenMultiVideoControlUI.StartRecvVideoRunnable(this);
  
  static
  {
    int i1;
    if (Build.VERSION.SDK_INT >= 21) {
      i1 = 16;
    } else {
      i1 = 9;
    }
    a = i1;
  }
  
  SmallScreenMultiVideoControlUI(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramSmallScreenService, paramControlUIObserver);
  }
  
  protected void a(int paramInt)
  {
    if ((this.B != null) && (paramInt > 0)) {
      this.B.setText(paramInt);
    }
  }
  
  void a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    long l1 = AudioHelper.c();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("drawUI, type[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], uin[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], fresh[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], originalType[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w("SmallScreenMultiVideoControlUI", 1, localStringBuilder.toString());
    }
    if (this.z == null) {
      return;
    }
    if ((paramInt1 == 0) && (this.z != null) && (paramLong != this.f) && (this.z.k().bv) && (this.z.k().o != 2)) {
      TraeHelper.a().a(l1, this.y, 2131230808, null, 0, null);
    }
    if ((paramInt1 != 0) && (paramInt1 != 1))
    {
      if ((paramInt1 != 5) && (paramInt1 != 6))
      {
        if ((paramInt1 != 7) && (paramInt1 != 8))
        {
          if ((paramInt1 != 97) && (paramInt1 != 98))
          {
            if (paramInt1 == 10) {
              a(l1, paramInt1);
            }
          }
          else if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Request remote video failed.Uin = ");
            localStringBuilder.append(paramLong);
            localStringBuilder.append(",type=");
            localStringBuilder.append(paramInt1);
            QLog.e("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
          }
        }
        else {
          b(l1, paramInt1, paramLong);
        }
      }
      else {
        a(l1, paramInt1, paramLong);
      }
    }
    else {
      b(paramInt1);
    }
  }
  
  public void a(long paramLong)
  {
    this.y.b(this.o);
    this.y.a().removeCallbacks(this.g);
    this.y.a().removeCallbacks(this.h);
    this.y.a().removeCallbacks(this.i);
    this.y.a().removeCallbacks(this.j);
    this.g = null;
    this.h = null;
    this.i = null;
    this.j = null;
    ITraeMediaPlayerApi localITraeMediaPlayerApi = this.n;
    if (localITraeMediaPlayerApi != null)
    {
      localITraeMediaPlayerApi.stopRing(paramLong);
      this.n = null;
    }
    super.a(paramLong);
  }
  
  void a(long paramLong, int paramInt)
  {
    boolean bool = k();
    if ((this.z.k().bv) && (bool))
    {
      if (this.r >= 4) {
        return;
      }
      if ((!NetworkUtil.isWifiConnected((Context)this.x.get())) && (this.z.k().B() == -1) && (!this.z.k().bA))
      {
        this.z.k().a(paramLong, "drawUI.3", true, true);
        q();
        a(true, true, true);
        return;
      }
      this.y.a().removeCallbacks(this.p);
      SmallScreenMultiVideoControlUI.StartRecvVideoRunnable localStartRecvVideoRunnable = this.p;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DrawUI:TYPE=");
      localStringBuilder.append(String.valueOf(paramInt));
      localStartRecvVideoRunnable.a = localStringBuilder.toString();
      this.y.a().postDelayed(this.p, 1000L);
    }
  }
  
  void a(long paramLong1, int paramInt, long paramLong2)
  {
    int i1;
    if (paramLong2 == this.f) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool1;
    if (paramInt == 6)
    {
      boolean bool2 = k();
      bool1 = bool2;
      if (i1 != 0)
      {
        bool1 = bool2;
        if (!this.z.k().by)
        {
          this.z.a(this.f, this.z.k().bi, this.z.k().bk, 1, false);
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = true;
    }
    if ((this.z.k().bv) && (bool1))
    {
      if (this.r >= 4) {
        return;
      }
      if ((!NetworkUtil.isWifiConnected((Context)this.x.get())) && (this.z.k().B() == -1) && (!this.z.k().bA))
      {
        if (i1 == 0)
        {
          this.z.k().a(paramLong1, "drawUI.1", true, true);
          q();
          a(true, true, true);
        }
      }
      else
      {
        Object localObject;
        StringBuilder localStringBuilder;
        if (i1 == 0)
        {
          this.y.a().removeCallbacks(this.p);
          localObject = this.p;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DrawUI:TYPE=");
          localStringBuilder.append(String.valueOf(paramInt));
          ((SmallScreenMultiVideoControlUI.StartRecvVideoRunnable)localObject).a = localStringBuilder.toString();
          this.y.a().postDelayed(this.p, 1000L);
          return;
        }
        i1 = this.z.k().b(this.f, 1);
        int i2 = this.z.k().B();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onSelfVideoIn.-->FirstVideo=");
          ((StringBuilder)localObject).append(i2);
          ((StringBuilder)localObject).append(",index=");
          ((StringBuilder)localObject).append(i1);
          QLog.d("SmallScreenMultiVideoControlUI", 2, ((StringBuilder)localObject).toString());
        }
        if ((i2 == -1) || ((i1 == i2) && (i1 != 0)))
        {
          this.y.a().removeCallbacks(this.p);
          localObject = this.p;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DrawUI:TYPE=");
          localStringBuilder.append(String.valueOf(paramInt));
          ((SmallScreenMultiVideoControlUI.StartRecvVideoRunnable)localObject).a = localStringBuilder.toString();
          this.y.a().postDelayed(this.p, 1000L);
        }
      }
    }
  }
  
  void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshUI-->uin=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" type=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" isRefreshTitle=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" originalType=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("SmallScreenMultiVideoControlUI", 2, ((StringBuilder)localObject).toString());
    }
    if (paramLong == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshUI-->uin == 0");
      }
      return;
    }
    if (this.y != null)
    {
      localObject = new SmallScreenMultiVideoControlUI.RefreshUIRunnable(this, paramInt1, paramLong, paramBoolean, paramInt2);
      this.y.a().post((Runnable)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshUI-->mApp == null");
    }
  }
  
  void a(long paramLong, ArrayList<VideoViewInfo> paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      VideoViewInfo localVideoViewInfo = (VideoViewInfo)paramArrayList.get(i1);
      if ((localVideoViewInfo.a == this.f) && (localVideoViewInfo.b == 1) && (!this.z.k().H))
      {
        paramArrayList.remove(i1);
        break;
      }
      i1 += 1;
    }
    this.A.update(null, new Object[] { Integer.valueOf(103), paramArrayList, Long.valueOf(paramLong) });
  }
  
  void a(long paramLong, boolean paramBoolean)
  {
    int i1 = this.b;
    if ((i1 != 0) && (i1 != 1))
    {
      Object localObject;
      if (i1 == 2)
      {
        if (this.z.k().i == 9)
        {
          this.t = true;
          localObject = this.w.getString(2131893631);
          if (this.B != null) {
            this.B.setText((CharSequence)localObject);
          }
        }
        else
        {
          this.t = false;
        }
        v();
      }
      else if (this.z.k().h())
      {
        this.t = true;
        localObject = this.w.getString(2131893631);
        if (this.B != null) {
          this.B.setText((CharSequence)localObject);
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleExterData-->Wrong gaudioStatusType-->type=");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(",relationId=");
        ((StringBuilder)localObject).append(r());
        ((StringBuilder)localObject).append(",relationType=");
        ((StringBuilder)localObject).append(this.d);
        QLog.e("SmallScreenMultiVideoControlUI", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      l();
      b(paramLong, paramBoolean);
    }
    f();
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RequestVideoTimeoutRunnable-->Add-->functionName=");
      localStringBuilder.append(paramString);
      QLog.d("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
    }
    if (this.h != null) {
      this.y.a().removeCallbacks(this.h);
    } else {
      this.h = new SmallScreenMultiVideoControlUI.RequestVideoTimeOutRunnable(this);
    }
    this.y.a().postDelayed(this.h, 30000L);
  }
  
  public void a(boolean paramBoolean)
  {
    long l1 = AudioHelper.c();
    super.a(paramBoolean);
    this.y.a(this.o);
    h();
    if (this.z.k().b())
    {
      String str = this.z.k().aD;
      TraeHelper.a().a(l1, this.D, str);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCreate, switchToGaudio, mAudioSesstionType[");
        localStringBuilder.append(this.D);
        localStringBuilder.append("], deviceName[");
        localStringBuilder.append(str);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(l1);
        localStringBuilder.append("]");
        QLog.w("SmallScreenMultiVideoControlUI", 1, localStringBuilder.toString());
      }
      TraeHelper.a().a(l1, str);
    }
    a(l1, paramBoolean);
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      int i1 = this.d;
      if (i1 == 2)
      {
        if (!NetworkUtil.isWifiConnected((Context)this.x.get())) {
          ReportController.b(null, "CliOper", "", "", "0X8004CF4", "0X8004CF4", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X8004CF7", "0X8004CF7", 0, 0, "", "", "", "");
        }
      }
      else if (i1 == 1) {
        if (NetworkUtil.isWifiConnected((Context)this.x.get())) {
          ReportController.b(null, "CliOper", "", "", "0X8004F5B", "0X8004F5B", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X8004F58", "0X8004F58", 0, 0, "", "", "", "");
        }
      }
      if (paramBoolean2) {
        TipsUtil.a(this.y, 3013);
      } else {
        TipsUtil.b(this.y, 3013);
      }
    }
    else
    {
      TipsUtil.b(this.y, 3013);
      TipsUtil.b(this.y, 1030);
    }
    if (paramBoolean3) {
      a(AudioHelper.c(), this.z.k().bi);
    }
  }
  
  void b(int paramInt)
  {
    if (this.z.k().i == 9)
    {
      String str = this.w.getString(2131893631);
      if (this.B != null) {
        this.B.setText(str);
      }
      if (this.s) {
        this.t = true;
      }
      UITools.a(this.B, str);
    }
    else if (paramInt == 0)
    {
      this.t = false;
      v();
    }
    m();
  }
  
  void b(long paramLong)
  {
    this.z.ad();
    this.z.k().a(paramLong, "goOffStage", false, false);
    this.A.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
    q();
  }
  
  void b(long paramLong1, int paramInt, long paramLong2)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt == 8)
    {
      localObject1 = new VideoViewInfo();
      ((VideoViewInfo)localObject1).a = paramLong2;
      ((VideoViewInfo)localObject1).b = 2;
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      this.A.update(null, new Object[] { Integer.valueOf(104), localObject2 });
    }
    else if (this.d == 2)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004CF0", "0X8004CF0", 0, 0, "", "", "", "");
    }
    boolean bool;
    if (paramInt == 8) {
      bool = k();
    } else {
      bool = true;
    }
    if (((this.z.k().am) || (this.z.k().bv)) && (bool))
    {
      if (this.r >= 4) {
        return;
      }
      if ((!NetworkUtil.isWifiConnected((Context)this.x.get())) && (!NetworkUtil.isMobileNetWork((Context)this.x.get())) && (this.z.k().B() == -1) && (!this.z.k().bA))
      {
        this.z.k().a(paramLong1, "drawUI.2", true, true);
        q();
        a(true, true, true);
        return;
      }
      this.y.a().removeCallbacks(this.p);
      localObject1 = this.p;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("DrawUI:TYPE=");
      ((StringBuilder)localObject2).append(String.valueOf(paramInt));
      ((SmallScreenMultiVideoControlUI.StartRecvVideoRunnable)localObject1).a = ((StringBuilder)localObject2).toString();
      this.y.a().postDelayed(this.p, 1000L);
    }
  }
  
  void b(long paramLong, boolean paramBoolean)
  {
    long l1 = r();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createOrEnterGAudio, mType[");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("], relationType[");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("], groupId[");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], isDoubleAudioToMultiAudio[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenMultiVideoControlUI", 1, ((StringBuilder)localObject).toString());
    }
    if (l1 == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "createOrEnterGAudio-->mGroupId == 0");
      }
      return;
    }
    Object localObject = this.w.getString(2131893625);
    if (this.B != null) {
      this.B.setText((CharSequence)localObject);
    }
    int i1 = this.b;
    if (i1 == 0)
    {
      if ((this.e == null) && (this.d == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.e("SmallScreenMultiVideoControlUI", 2, "createOrEnterGAudio uinList is null");
        }
        d(true);
      }
    }
    else if ((i1 == 1) && (paramBoolean)) {
      this.z.a(paramLong, this.d, l1, this.e, false);
    }
  }
  
  void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RequestVideoTimeoutRunnable-->Remove-->functionName=");
      localStringBuilder.append(paramString);
      QLog.d("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
    }
    if (this.h != null) {
      this.y.a().removeCallbacks(this.h);
    }
  }
  
  void c(boolean paramBoolean)
  {
    long l1 = AudioHelper.c();
    ITraeMediaPlayerApi localITraeMediaPlayerApi = this.n;
    if (localITraeMediaPlayerApi == null)
    {
      this.n = ((ITraeMediaPlayerApi)QRoute.api(ITraeMediaPlayerApi.class));
      this.n.init((Context)this.x.get(), null);
    }
    else
    {
      localITraeMediaPlayerApi.stopRing(l1);
    }
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      if (GAudioSoundUtil.a("qav_gaudio_muted.mp3"))
      {
        localITraeMediaPlayerApi = this.n;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(GAudioSoundUtil.a());
        localStringBuilder.append("qav_gaudio_muted.mp3");
        localITraeMediaPlayerApi.playRing(l1, 2, 0, null, localStringBuilder.toString(), false, 1, false, true, 0);
      }
    }
    else if (GAudioSoundUtil.a("qav_gaudio_cancel_muted.mp3"))
    {
      localITraeMediaPlayerApi = this.n;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(GAudioSoundUtil.a());
      localStringBuilder.append("qav_gaudio_cancel_muted.mp3");
      localITraeMediaPlayerApi.playRing(l1, 2, 0, null, localStringBuilder.toString(), false, 1, false, true, 0);
    }
  }
  
  void d(boolean paramBoolean)
  {
    this.k = paramBoolean;
    this.y.a(new Object[] { Integer.valueOf(28), String.valueOf(r()), Boolean.valueOf(paramBoolean) });
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "onResume");
    }
    if (this.z != null)
    {
      if (this.z.j)
      {
        this.z.K();
        if (this.z.k().i == 9)
        {
          this.t = true;
          localObject = this.w.getString(2131893631);
          if (this.B != null) {
            this.B.setText((CharSequence)localObject);
          }
        }
        else
        {
          this.t = false;
        }
        v();
      }
      Object localObject = this.m;
      if (localObject != null) {
        ((QAVNotification)localObject).a(this.z.k().f);
      }
      this.z.k().by = false;
      if (this.z.j) {
        i();
      }
      f();
    }
  }
  
  void f()
  {
    boolean bool = this.z.j;
    long l1 = r();
    this.y.b(this.c, String.valueOf(l1));
  }
  
  public void g()
  {
    super.g();
    if ((this.z != null) && (this.x != null) && (!NetworkUtil.isWifiConnected((Context)this.x.get())) && (this.z.k().B() != -1)) {
      this.z.f("Small_onPause");
    }
  }
  
  void h()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("processExtraData-->mType=");
      ((StringBuilder)localObject).append(this.z.k().aP);
      ((StringBuilder)localObject).append(" IntentGroupId=");
      ((StringBuilder)localObject).append(this.z.k().aN);
      ((StringBuilder)localObject).append(" isInRoom=");
      ((StringBuilder)localObject).append(this.z.j);
      ((StringBuilder)localObject).append(" mRoomDiscussionId=");
      ((StringBuilder)localObject).append(this.z.k);
      QLog.d("SmallScreenMultiVideoControlUI", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.z.k();
    if (localObject != null)
    {
      this.c = ((SessionInfo)localObject).p;
      int i1 = this.c;
      if (i1 == 3000) {
        this.d = 2;
      } else if (i1 == 1) {
        this.d = 1;
      } else if (i1 == 0) {
        this.d = 3;
      } else {
        this.d = ((SessionInfo)localObject).aQ;
      }
      this.b = ((SessionInfo)localObject).aP;
      this.e = ((SessionInfo)localObject).aO;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("processExtraData mGroupId = ");
      ((StringBuilder)localObject).append(r());
      QLog.d("SmallScreenMultiVideoControlUI", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "resumeVideo");
    }
    if (this.g == null) {
      this.g = new SmallScreenMultiVideoControlUI.AutoCheckRunnable(this);
    } else {
      this.y.a().removeCallbacks(this.g);
    }
    this.y.a().postDelayed(this.g, 500L);
  }
  
  protected void j()
  {
    super.j();
    if (this.z.k().i == 9)
    {
      String str = this.w.getString(2131893631);
      if (this.B != null) {
        this.B.setText(str);
      }
    }
    if ((this.z.k().b()) && (this.z.k().E)) {
      this.z.a("SmallScreenMultiVideoControlUI.initUI", this.z.k().aN, false);
    }
  }
  
  boolean k()
  {
    if (this.z.k().bi.size() == 0)
    {
      l();
      a(false, false, false);
      return false;
    }
    if ((this.z.k().bi.size() == 1) && (((VideoViewInfo)this.z.k().bi.get(0)).a == this.f))
    {
      a(false, false, false);
      b("checkRemoteVideo");
      return false;
    }
    return true;
  }
  
  void l()
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("closeRemoteVideo, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w("SmallScreenMultiVideoControlUI", 1, localStringBuilder.toString());
    }
    if (this.z != null)
    {
      this.z.f("Meeting_closeRemoteVideo");
      this.z.k().a(l1, "closeRemoteVideo", false, true);
      q();
    }
    b("closeRemoteVideo");
    if (this.z != null) {
      this.A.update(null, new Object[] { Integer.valueOf(104), this.z.k().bi });
    }
  }
  
  void m()
  {
    n();
  }
  
  void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenMultiVideoControlUI", 2, "refreshGAFList");
    }
    if ((this.z == null) && (QLog.isColorLevel())) {
      QLog.e("SmallScreenMultiVideoControlUI", 2, "refreshGAFList-->mVideoContrl is null");
    }
  }
  
  void o()
  {
    if (this.z == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->mVideoControl is null");
      }
      return;
    }
    StringBuilder localStringBuilder;
    if (!this.z.j)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("enterOrResumeRemoteOrLocalVideo-->mVideoController.mGAudioInRoom =");
        localStringBuilder.append(this.z.j);
        QLog.e("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
      }
      return;
    }
    int i1 = this.z.k().b(this.f, 1);
    int i2 = this.z.q();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("enterOrResumeRemoteOrLocalVideo-->index=");
      localStringBuilder.append(i1);
      localStringBuilder.append(", onstageNum=");
      localStringBuilder.append(i2);
      QLog.d("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
    }
    if ((!NetworkUtil.isWifiConnected((Context)this.x.get())) && (!NetworkUtil.isMobileNetWork((Context)this.x.get())) && (!this.z.k().bA))
    {
      if (i1 != -1)
      {
        this.z.a(this.f, this.z.k().bi, this.z.k().bk, 1, false);
        this.z.ab();
      }
      if (this.z.k().bi.size() > 0)
      {
        this.z.k().a(-1023L, "enterOrResumeRemoteOrLocalVideo", true, true);
        q();
        a(true, true, true);
      }
    }
    else
    {
      if (i1 != -1) {
        if (this.z.q() < a)
        {
          if ((this.z.k().H) && (!this.z.ac()) && (QLog.isColorLevel())) {
            QLog.e("SmallScreenMultiVideoControlUI", 2, "enterOrResumeRemoteOrLocalVideo-->go on stage fail,can not find the session");
          }
        }
        else
        {
          this.z.a(this.f, this.z.k().bi, this.z.k().bk, 1, false);
          this.z.ab();
        }
      }
      if (this.z.k().bi.size() > 0) {
        p();
      }
    }
  }
  
  boolean p()
  {
    if (this.z == null) {
      return false;
    }
    int i2 = this.z.k().bi.size();
    int i1 = i2;
    if (this.z.k().H) {
      i1 = i2 - 1;
    }
    if (i1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenMultiVideoControlUI", 2, "startRecvAllVideo-->There is no dispaly view");
      }
      return false;
    }
    if (Utils.a(this.y.getApp()) == 1) {
      return false;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005617", "0X8005617", 0, 0, "", "", "", "");
    i1 = this.z.X();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startRecvAllVideo-->VideoAblityLevel=");
      localStringBuilder.append(i1);
      QLog.d("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
    }
    if (i1 != 4)
    {
      if (this.d == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8004CF6", "0X8004CF6", 0, 0, "", "", "", "");
      }
      TipsUtil.a(this.y, 3007);
    }
    this.z.k().bl.clear();
    long l1 = Long.parseLong(this.y.getCurrentAccountUin());
    i1 = 0;
    while (i1 < this.z.k().bi.size())
    {
      if ((((VideoViewInfo)this.z.k().bi.get(i1)).e) && (l1 != ((VideoViewInfo)this.z.k().bi.get(i1)).a)) {
        this.z.k().bl.add(this.z.k().bi.get(i1));
      }
      i1 += 1;
    }
    a(false, false, false);
    return this.z.b(false);
  }
  
  @SuppressLint({"NewApi"})
  void q()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchUIMode, sessionType = ");
      localStringBuilder.append(this.z.k().g);
      QLog.d("SmallScreenMultiVideoControlUI", 2, localStringBuilder.toString());
    }
    this.y.a(new Object[] { Integer.valueOf(102) });
  }
  
  long r()
  {
    if (this.z != null) {
      return this.z.k().aN;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI
 * JD-Core Version:    0.7.0.1
 */