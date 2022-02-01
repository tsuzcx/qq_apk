package com.tencent.av.smallscreen;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.wtogether.SmallScreenDavWTObserver;
import com.tencent.qphone.base.util.QLog;

public class SmallScreenDoubleVideoControlUI
  extends SmallScreenVideoControlUI
{
  boolean a = false;
  SmallScreenDavWTObserver b = null;
  Runnable c = new SmallScreenDoubleVideoControlUI.2(this);
  
  public SmallScreenDoubleVideoControlUI(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramSmallScreenService, paramControlUIObserver);
  }
  
  public void a()
  {
    super.a();
    if (this.B != null) {
      this.B.setText(2131893625);
    }
    String str = this.z.k().s;
    int i = this.z.g(str);
    int j = this.z.i(str);
    if (i == 5)
    {
      if (this.z.k().bw)
      {
        v();
        return;
      }
      this.y.a().postDelayed(this.c, 5000L);
      this.a = true;
      return;
    }
    if (!this.z.m())
    {
      if (this.z.k().bw)
      {
        v();
        return;
      }
      this.y.a().postDelayed(this.c, 5000L);
      this.a = true;
      return;
    }
    if (!this.z.k().j())
    {
      this.y.a().postDelayed(this.c, 5000L);
      this.a = true;
      return;
    }
    if (j > 18)
    {
      if ((this.z.k().bw) && (this.z.k().bx))
      {
        v();
        return;
      }
      this.y.a().postDelayed(this.c, 5000L);
      this.a = true;
      return;
    }
    if (this.z.k().bw)
    {
      v();
      return;
    }
    this.y.a().postDelayed(this.c, 5000L);
    this.a = true;
  }
  
  protected void a(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<<<setInvitingState(), resId =");
      localStringBuilder.append(paramInt);
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, localStringBuilder.toString());
    }
    if ((this.z.k().p == 1011) && (paramInt != 2131893625) && (paramInt != 2131917846)) {
      return;
    }
    if ((this.B != null) && (paramInt > 0)) {
      this.B.setText(paramInt);
    }
  }
  
  public void a(long paramLong)
  {
    if ((this.a) && (this.y != null)) {
      this.y.a().removeCallbacks(this.c);
    }
    if ((this.b != null) && (this.y != null))
    {
      this.y.removeObserver(this.b);
      this.b = null;
    }
    super.a(paramLong);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInviteReached remotePhoneState = ");
      localStringBuilder.append(this.z.k().W);
      localStringBuilder.append(" # remoteTerminal = ");
      localStringBuilder.append(this.z.k().K);
      localStringBuilder.append(" # phoneOnLine = ");
      localStringBuilder.append(this.z.k().V);
      localStringBuilder.append(" # pcOnLine = ");
      localStringBuilder.append(this.z.k().U);
      localStringBuilder.append(" # subState = ");
      localStringBuilder.append(this.z.k().aq);
      localStringBuilder.append(" # isPeerNetworkWell = ");
      localStringBuilder.append(this.z.k().P);
      QLog.d("SmallScreenDoubleVideoControlUI", 2, localStringBuilder.toString());
    }
    if ((this.z != null) && (this.z.k().f()) && (!this.z.k().br))
    {
      if (this.z.k().p == 1011) {
        return;
      }
      if ((this.z.k().s.contains(paramString1)) && (this.z.k().W >= 0) && (this.B != null))
      {
        if (TextUtils.isEmpty(paramString2))
        {
          this.B.setText(2131893743);
          return;
        }
        this.B.setText(paramString2);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onPeerSwitchTerminal, bStartSwitch : ");
      paramString.append(paramBoolean);
      QLog.d("SmallScreenDoubleVideoControlUI", 2, paramString.toString());
    }
    paramString = DoodleLogic.b();
    if (paramBoolean)
    {
      paramString.k = false;
      paramString.l = 0;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("WL_DEBUG onPeerSwitchTerminal mPeerVersion = ");
        localStringBuilder.append(paramString.l);
        localStringBuilder.append(", mIsPeerSupport = ");
        localStringBuilder.append(paramString.k);
        QLog.e("SmallScreenDoubleVideoControlUI", 2, localStringBuilder.toString());
      }
      SmallScreenUtils.a();
      this.y.a(new Object[] { Integer.valueOf(127) });
      return;
    }
    paramString.e();
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    SessionInfo localSessionInfo = this.z.k();
    long l = AudioHelper.c();
    if (this.b == null)
    {
      this.b = new SmallScreenDavWTObserver(this.y);
      this.y.addObserver(this.b);
    }
    if (localSessionInfo.i())
    {
      if (localSessionInfo.aK) {
        i = 2131893262;
      } else {
        i = 2131917920;
      }
      this.B.setText(i);
      return;
    }
    paramBoolean = localSessionInfo.f();
    int i = 2131893743;
    int j;
    if (paramBoolean)
    {
      paramBoolean = localSessionInfo.br;
      j = 2131893625;
      if (paramBoolean) {
        i = 2131893625;
      }
      if (localSessionInfo.p == 1011) {
        i = j;
      }
      this.B.setText(i);
      return;
    }
    if (localSessionInfo.h())
    {
      if ((localSessionInfo.g == 0) && (localSessionInfo.B))
      {
        j = i;
        if (localSessionInfo.h == 1) {
          break label195;
        }
        if (localSessionInfo.h == 2)
        {
          j = i;
          break label195;
        }
      }
      j = 2131893456;
      label195:
      this.B.setText(j);
      return;
    }
    if ((localSessionInfo.m()) || (localSessionInfo.n()))
    {
      if (localSessionInfo.p == 1011) {
        this.B.setText(2131893639);
      }
      this.y.a().postDelayed(new SmallScreenDoubleVideoControlUI.1(this, l), 150L);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (this.z != null))
    {
      String str = this.z.k().s;
      if (paramBoolean2)
      {
        if (!this.z.k().E) {
          this.z.a(true, str);
        }
      }
      else if (!this.z.k().E) {
        this.z.a(false, str);
      }
    }
  }
  
  public void b()
  {
    super.b();
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">>>onStart(), ts=");
      localStringBuilder.append(l1);
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, localStringBuilder.toString());
    }
    if ((this.z != null) && (this.z.k().f()) && (this.z.k().W >= 0) && (this.B != null)) {
      if (this.z.k().p == 1011) {
        this.B.setText(2131893625);
      } else {
        this.B.setText(2131893743);
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<<<onStart(), ts=");
      localStringBuilder.append(l2);
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, localStringBuilder.toString());
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, String.format("onStart(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNotRecvAudioData bNotRecv = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("SmallScreenDoubleVideoControlUI", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      return;
    }
    if (this.a) {
      this.y.a().removeCallbacks(this.c);
    }
    if (this.z.k().aq != 1L) {
      v();
    }
  }
  
  public void c()
  {
    String str = this.z.k().s;
    int i = this.z.g(str);
    int j = this.z.i(str);
    if (i != 5)
    {
      if (i == 0) {
        return;
      }
      if (this.z.m())
      {
        if (!this.z.k().j()) {
          return;
        }
        if ((j > 18) && (this.z.k().bw))
        {
          if (this.a) {
            this.y.a().removeCallbacks(this.c);
          }
          v();
        }
      }
    }
  }
  
  public void d()
  {
    String str = this.z.k().s;
    int i = this.z.g(str);
    int j = this.z.i(str);
    if ((i != 5) && (i != 0))
    {
      if (!this.z.m())
      {
        if (this.a) {
          this.y.a().removeCallbacks(this.c);
        }
        if (this.z.k().aq != 1L) {
          v();
        }
      }
      else
      {
        if (!this.z.k().j()) {
          return;
        }
        if (j > 18)
        {
          if (this.z.k().bx)
          {
            if (this.a) {
              this.y.a().removeCallbacks(this.c);
            }
            if (this.z.k().aq != 1L) {
              v();
            }
          }
        }
        else
        {
          if (this.a) {
            this.y.a().removeCallbacks(this.c);
          }
          if (this.z.k().aq != 1L) {
            v();
          }
        }
      }
    }
    else
    {
      if (this.a) {
        this.y.a().removeCallbacks(this.c);
      }
      if (this.z.k().aq != 1L) {
        v();
      }
    }
  }
  
  public void e()
  {
    super.e();
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">>>onResume(), ts=");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, localStringBuilder.toString());
    }
    if ((this.z != null) && (this.z.k().j()) && (this.z.k().aq != 1L)) {
      v();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<<<onResume(), ts=");
      localStringBuilder.append(l2);
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, localStringBuilder.toString());
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI
 * JD-Core Version:    0.7.0.1
 */