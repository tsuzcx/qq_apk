package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class VideoNetStateBar
{
  boolean a = false;
  boolean b = false;
  boolean c = false;
  boolean d = false;
  WeakReference<Context> e = null;
  VideoAppInterface f = null;
  VideoController g = null;
  WeakReference<ViewGroup> h = null;
  Resources i = null;
  Runnable j = null;
  ImageView k = null;
  ImageView l = null;
  View m = null;
  ImageView n = null;
  TextView o = null;
  int p = 0;
  int q = 0;
  String r = null;
  String s = null;
  boolean t = false;
  long u = -1L;
  GAudioUIObserver v = new VideoNetStateBar.1(this);
  private int w = 0;
  private boolean x = false;
  
  public VideoNetStateBar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "VideoNetStateBar");
    }
    this.e = new WeakReference(paramAVActivity);
    this.f = paramVideoAppInterface;
    this.h = new WeakReference(paramViewGroup);
    this.i = paramAVActivity.getResources();
    paramVideoAppInterface = this.f;
    if (paramVideoAppInterface != null) {
      this.g = paramVideoAppInterface.b();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onCreate");
    }
    l();
    this.a = false;
    this.b = false;
    this.c = false;
    this.q = 0;
    this.p = 0;
    this.r = null;
    this.s = null;
    this.u = -1L;
    b();
    Object localObject = this.f;
    if (localObject != null)
    {
      GAudioUIObserver localGAudioUIObserver = this.v;
      if (localGAudioUIObserver != null) {
        ((VideoAppInterface)localObject).a(localGAudioUIObserver);
      }
    }
    localObject = this.g;
    if (localObject != null)
    {
      localObject = ((VideoController)localObject).k();
      if (localObject != null)
      {
        if (((SessionInfo)localObject).ac)
        {
          ((SessionInfo)localObject).ac = false;
          if ((((SessionInfo)localObject).g == 1) || (((SessionInfo)localObject).g == 2) || (((SessionInfo)localObject).g == 3) || (((SessionInfo)localObject).g == 4))
          {
            this.q = ((SessionInfo)localObject).ad;
            this.p = ((SessionInfo)localObject).ae;
          }
        }
        this.b = ((SessionInfo)localObject).E;
        this.c = ((SessionInfo)localObject).F;
      }
    }
    b("onCreate");
  }
  
  public void a(int paramInt)
  {
    ImageView localImageView = this.l;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    boolean bool = QLog.isDevelopLevel();
    int i2 = 3;
    int i1 = 1;
    if (bool) {
      QLog.d("VideoNetStateBar", 4, String.format("setNetLevel, emNetLevel[%s], selfNetLevel[%s], peerNetLevel[%s], strDetail[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString }));
    }
    if (paramInt2 == paramInt3) {
      paramInt2 = i2;
    } else if (paramInt2 > 0) {
      paramInt2 = 1;
    } else if (paramInt3 > 0) {
      paramInt2 = 2;
    } else {
      paramInt2 = 0;
    }
    if ((this.q == paramInt1) && (paramInt2 == this.p) && (TextUtils.equals(this.r, paramString)))
    {
      paramInt1 = 0;
    }
    else
    {
      this.q = paramInt1;
      this.p = paramInt2;
      this.r = paramString;
      paramInt1 = i1;
    }
    if (paramInt1 != 0) {
      b("setNetLevel");
    }
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.o;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      b("setImmersiveFlag");
    }
  }
  
  void b()
  {
    WeakReference localWeakReference = this.h;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      this.k = ((ImageView)((ViewGroup)this.h.get()).findViewById(2131441219));
      this.l = ((ImageView)((ViewGroup)this.h.get()).findViewById(2131441220));
      this.m = ((ViewGroup)this.h.get()).findViewById(2131441221);
      this.n = ((ImageView)((ViewGroup)this.h.get()).findViewById(2131441218));
      this.o = ((TextView)((ViewGroup)this.h.get()).findViewById(2131431784));
      b(0);
      if (AudioHelper.a(0) == 1) {
        this.m.setBackgroundColor(-822034433);
      }
    }
  }
  
  void b(int paramInt)
  {
    ImageView localImageView = this.n;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
  }
  
  void b(String paramString)
  {
    if ((this.k != null) && (this.l != null))
    {
      if (this.n == null) {
        return;
      }
      if (this.i == null) {
        return;
      }
      int i1 = this.q;
      if (i1 == 0) {
        return;
      }
      int i3 = this.p;
      boolean bool = TextUtils.isEmpty(this.r);
      int i2 = 1;
      Object localObject;
      if (!bool) {
        localObject = this.r;
      } else if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i3 == 2) {
            localObject = this.i.getString(2131893482);
          } else if (i3 == 1) {
            localObject = this.i.getString(2131893485);
          } else {
            localObject = this.i.getString(2131893478);
          }
        }
        else if (i3 == 2) {
          localObject = this.i.getString(2131893483);
        } else if (i3 == 1) {
          localObject = this.i.getString(2131893486);
        } else {
          localObject = this.i.getString(2131893480);
        }
      }
      else if (i3 == 2) {
        localObject = this.i.getString(2131893481);
      } else if (i3 == 1) {
        localObject = this.i.getString(2131893484);
      } else {
        localObject = this.i.getString(2131893477);
      }
      c(0);
      if (this.d)
      {
        localObject = this.i.getString(2131893479);
        this.k.setImageResource(2130843235);
        this.n.setImageResource(2130843235);
        this.l.setImageResource(2130843235);
      }
      else if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            this.k.setImageResource(2130843231);
            this.n.setImageResource(2130843231);
            this.l.setImageResource(2130843231);
          }
          else
          {
            this.k.setImageResource(2130843231);
            this.n.setImageResource(2130843231);
            this.l.setImageResource(2130843231);
          }
        }
        else
        {
          this.k.setImageResource(2130843233);
          this.n.setImageResource(2130843233);
          this.l.setImageResource(2130843233);
        }
      }
      else
      {
        this.k.setImageResource(2130843229);
        this.n.setImageResource(2130843229);
        this.l.setImageResource(2130843229);
      }
      if (i1 == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.s = null;
      if ((!this.d) && (!bool))
      {
        TipsUtil.b(this.f, 3001);
      }
      else
      {
        i1 = i2;
        if (System.currentTimeMillis() - this.u <= 3000L) {
          if (this.d) {
            i1 = i2;
          } else {
            i1 = 0;
          }
        }
        if (i1 != 0) {
          TipsUtil.a(this.f, 3001, (String)localObject);
        }
      }
      if (this.a)
      {
        if ((!this.d) && (!bool))
        {
          localObject = this.m;
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
        }
        else
        {
          localObject = this.m;
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
          n();
        }
      }
      else
      {
        localObject = this.m;
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refreshNetLevelTextAndIcon, from[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("], noNet[");
        ((StringBuilder)localObject).append(this.d);
        ((StringBuilder)localObject).append("], bShowNetIcon[");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append("]");
        QLog.i("VideoNetStateBar", 4, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
    if (this.b) {
      m();
    }
    b("setSelfCloseMICFlag");
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onDestroy");
    }
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((VideoController)localObject).k();
      if (localObject != null)
      {
        ((SessionInfo)localObject).ae = this.p;
        ((SessionInfo)localObject).ad = this.q;
        ((SessionInfo)localObject).ac = true;
      }
    }
    localObject = this.f;
    if (localObject != null)
    {
      GAudioUIObserver localGAudioUIObserver = this.v;
      if (localGAudioUIObserver != null) {
        ((VideoAppInterface)localObject).b(localGAudioUIObserver);
      }
    }
    l();
    this.e = null;
    this.f = null;
    this.g = null;
    this.i = null;
    this.k = null;
    this.l = null;
    this.m = null;
    this.n = null;
    this.o = null;
    this.v = null;
    this.h = null;
  }
  
  void c(int paramInt)
  {
    ImageView localImageView = this.k;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (this.c) {
      m();
    }
    b("setPeerCloseMICFlag");
  }
  
  public void d() {}
  
  public void d(int paramInt)
  {
    Object localObject = this.m;
    if (localObject == null) {
      return;
    }
    localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
    if (localObject == null) {
      return;
    }
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = paramInt;
    this.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void d(boolean paramBoolean)
  {
    this.d = paramBoolean;
    b("setNoNetworkFlag");
  }
  
  public void e() {}
  
  public void e(int paramInt)
  {
    if (!this.x) {
      return;
    }
    if (paramInt == this.w) {
      return;
    }
    if (this.m == null) {
      return;
    }
    Object localObject = this.e;
    View localView = null;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (Context)((WeakReference)localObject).get();
    }
    if (localObject == null) {
      return;
    }
    if (this.h.get() != null) {
      localView = ((ViewGroup)this.h.get()).findViewById(2131441222);
    }
    if (localView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.m.getLayoutParams();
    if (localLayoutParams == null) {
      return;
    }
    this.w = paramInt;
    paramInt = this.w;
    if ((paramInt != 90) && (paramInt != 270))
    {
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      this.m.setLayoutParams(localLayoutParams);
      this.m.setRotation(0.0F);
      if (this.w == 0)
      {
        localView.setScaleY(1.0F);
        localView.setScaleX(1.0F);
        return;
      }
      localView.setScaleY(-1.0F);
      localView.setScaleX(-1.0F);
      return;
    }
    paramInt = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - ((Context)localObject).getResources().getDimensionPixelSize(2131298571);
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.m.setLayoutParams(localLayoutParams);
    this.m.setRotation(90.0F);
    if (this.w == 270)
    {
      localView.setScaleY(1.0F);
      localView.setScaleX(1.0F);
      return;
    }
    localView.setScaleY(-1.0F);
    localView.setScaleX(-1.0F);
  }
  
  public void e(boolean paramBoolean)
  {
    boolean bool = false;
    if (paramBoolean)
    {
      View localView;
      if (this.h.get() == null) {
        localView = null;
      } else {
        localView = ((ViewGroup)this.h.get()).findViewById(2131441222);
      }
      paramBoolean = bool;
      if (localView != null) {
        paramBoolean = true;
      }
      this.x = paramBoolean;
      return;
    }
    this.x = false;
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onDoubleConnected");
    }
    this.q = 3;
    this.u = System.currentTimeMillis();
    b("onDoubleConnected");
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onMultiConnected");
    }
    this.q = 3;
    b("onMultiConnected");
    j();
  }
  
  void j()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((VideoController)localObject).k();
      if ((localObject != null) && ((((SessionInfo)localObject).g == 3) || (((SessionInfo)localObject).g == 4))) {
        k();
      }
    }
  }
  
  void k()
  {
    if (this.f == null) {
      return;
    }
    if (this.j == null) {
      this.j = new VideoNetStateBar.GroupNetLevelRunnable(this);
    }
    if (this.j != null)
    {
      VideoController localVideoController = this.g;
      if ((localVideoController != null) && (localVideoController.aH() != null))
      {
        this.g.aH().removeCallbacks(this.j);
        this.g.aH().postDelayed(this.j, 2000L);
      }
    }
  }
  
  void l()
  {
    if (this.f == null) {
      return;
    }
    if (this.j != null)
    {
      VideoController localVideoController = this.g;
      if ((localVideoController != null) && (localVideoController.aH() != null)) {
        this.g.aH().removeCallbacks(this.j);
      }
    }
    this.j = null;
    this.t = false;
  }
  
  boolean m()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((VideoController)localObject).k();
      if (localObject != null)
      {
        if ((this.c) && ((((SessionInfo)localObject).g == 1) || (((SessionInfo)localObject).g == 2)))
        {
          ReportController.b(null, "CliOper", "", "", "0X8005966", "0X8005966", 0, 0, "", "", "", "");
          return true;
        }
        if ((this.b) && ((((SessionInfo)localObject).g == 3) || (((SessionInfo)localObject).g == 4)))
        {
          ReportController.b(null, "CliOper", "", "", "0X8005966", "0X8005966", 0, 0, "", "", "", "");
          return true;
        }
      }
    }
    return false;
  }
  
  void n()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((VideoController)localObject).k();
      if (localObject != null) {
        if ((!((SessionInfo)localObject).am) && (((SessionInfo)localObject).g != 1) && (((SessionInfo)localObject).g != 2))
        {
          if ((((SessionInfo)localObject).g == 3) || (((SessionInfo)localObject).g == 4)) {
            ReportController.b(null, "CliOper", "", "", "0X8005921", "0X8005921", 0, 0, "", "", "", "");
          }
        }
        else {
          ReportController.b(null, "CliOper", "", "", "0X8005922", "0X8005922", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public boolean o()
  {
    return this.t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoNetStateBar
 * JD-Core Version:    0.7.0.1
 */