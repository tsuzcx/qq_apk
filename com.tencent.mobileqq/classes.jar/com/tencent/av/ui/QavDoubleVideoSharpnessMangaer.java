package com.tencent.av.ui;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QavDoubleVideoSharpnessMangaer
{
  private RelativeLayout a;
  private View b;
  private ViewStub c;
  private int d;
  private int e = -1;
  private ImageView[] f = new ImageView[4];
  private VideoController g;
  private AVActivity h;
  private long i = -1L;
  private Queue<Long> j = new LinkedList();
  private boolean k = false;
  private QavSharpnessSVIPHelper l;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private int q = 2;
  private BroadcastReceiver r = new QavDoubleVideoSharpnessMangaer.1(this);
  private View.OnTouchListener s = new QavDoubleVideoSharpnessMangaer.2(this);
  
  public QavDoubleVideoSharpnessMangaer(View paramView, ViewStub paramViewStub, int paramInt, VideoController paramVideoController, AVActivity paramAVActivity)
  {
    this.b = paramView;
    this.c = paramViewStub;
    this.d = paramInt;
    this.g = paramVideoController;
    this.h = paramAVActivity;
    this.l = new QavSharpnessSVIPHelper(paramVideoController, paramAVActivity);
    this.l.a();
    this.h.registerReceiver(this.r, new IntentFilter("tencent.video.q2v.SVIP.PAY"));
  }
  
  private void j()
  {
    Object localObject4 = (RelativeLayout)this.a.findViewById(2131441263);
    Object localObject3 = (RelativeLayout)this.a.findViewById(2131441266);
    Object localObject2 = (RelativeLayout)this.a.findViewById(2131441272);
    Object localObject1 = (RelativeLayout)this.a.findViewById(2131441268);
    int i1 = (int)UITools.a(this.g.e.getApp().getApplicationContext(), 4.0F);
    int i2 = (int)UITools.a(this.g.e.getApp().getApplicationContext(), 132.0F);
    int i3 = (int)UITools.a(this.g.e.getApp().getApplicationContext(), 8.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.width = i2;
    ((RelativeLayout)localObject4).setLayoutParams(localLayoutParams);
    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131441263);
    ((RelativeLayout.LayoutParams)localObject4).leftMargin = i1;
    ((RelativeLayout.LayoutParams)localObject4).width = i2;
    ((RelativeLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131441263);
    ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131441263);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131441263);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = i1;
    ((RelativeLayout.LayoutParams)localObject3).width = i2;
    ((RelativeLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131441266);
    ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131441266);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131441266);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = i1;
    ((RelativeLayout.LayoutParams)localObject2).width = i2;
    ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131441274);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = i3;
    ((TextView)this.a.findViewById(2131441275)).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131441270);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = i3;
    ((TextView)this.a.findViewById(2131441271)).setLayoutParams((ViewGroup.LayoutParams)localObject1);
  }
  
  private void k()
  {
    if (this.a == null)
    {
      this.c.inflate();
      this.a = ((RelativeLayout)this.b.findViewById(this.d));
      this.f[0] = ((ImageView)this.a.findViewById(2131441264));
      this.f[0].setOnTouchListener(this.s);
      this.f[1] = ((ImageView)this.a.findViewById(2131441267));
      this.f[1].setOnTouchListener(this.s);
      this.f[2] = ((ImageView)this.a.findViewById(2131441274));
      this.f[2].setOnTouchListener(this.s);
      ((TextView)this.a.findViewById(2131441275)).setText(this.g.k().al);
      if (AndroidCodec.sIsSupportHwCodec1080P)
      {
        this.a.findViewById(2131441268).setVisibility(0);
        this.f[3] = ((ImageView)this.a.findViewById(2131441270));
        this.f[3].setOnTouchListener(this.s);
        ((TextView)this.a.findViewById(2131441271)).setText(this.g.k().al);
        j();
      }
      this.a.setOnClickListener(new QavDoubleVideoSharpnessMangaer.5(this));
      this.e = 0;
      this.a.setVisibility(8);
      this.l.b();
    }
    this.e = this.g.k().ai;
    l();
  }
  
  private void l()
  {
    ImageView localImageView = this.f[0];
    Resources localResources = this.b.getResources();
    int i1;
    if (this.e == 0) {
      i1 = 2130843273;
    } else {
      i1 = 2130843272;
    }
    localImageView.setBackgroundDrawable(localResources.getDrawable(i1));
    localImageView = this.f[1];
    localResources = this.b.getResources();
    if (this.e == 1) {
      i1 = 2130843271;
    } else {
      i1 = 2130843270;
    }
    localImageView.setBackgroundDrawable(localResources.getDrawable(i1));
    localImageView = this.f[2];
    localResources = this.b.getResources();
    if (this.e == 2) {
      i1 = 2130843277;
    } else {
      i1 = 2130843276;
    }
    localImageView.setBackgroundDrawable(localResources.getDrawable(i1));
    if (AndroidCodec.sIsSupportHwCodec1080P)
    {
      localImageView = this.f[3];
      localResources = this.b.getResources();
      if (this.e == 3) {
        i1 = 2130843275;
      } else {
        i1 = 2130843274;
      }
      localImageView.setBackgroundDrawable(localResources.getDrawable(i1));
    }
  }
  
  private void m()
  {
    RelativeLayout localRelativeLayout = this.a;
    if (localRelativeLayout != null)
    {
      if (localRelativeLayout.getVisibility() != 0) {
        return;
      }
      a();
    }
  }
  
  private void n()
  {
    l();
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((VideoController)localObject).k();
      if (localObject != null) {
        this.g.a(Long.valueOf(((SessionInfo)localObject).s).longValue(), this.e);
      }
    }
  }
  
  public void a()
  {
    k();
    this.a.setVisibility(0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      if (((VideoController)localObject).e == null) {
        return;
      }
      localObject = this.g.k();
      if ((localObject != null) && (((SessionInfo)localObject).g == 2))
      {
        if (((SessionInfo)localObject).r()) {
          return;
        }
        if ((paramInt1 >= 1920) && (paramInt2 >= 1080))
        {
          if (!this.p)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onRecvVideoResolutionChanged. w = ");
            ((StringBuilder)localObject).append(paramInt1);
            ((StringBuilder)localObject).append(", h = ");
            ((StringBuilder)localObject).append(paramInt2);
            QLog.i("QavDoubleVideoSharpnessMangaer", 1, ((StringBuilder)localObject).toString());
            TipsUtil.a(this.g.e, 1058, this.g.e.getApp().getString(2131893546));
            this.p = true;
            ReportController.b(null, "CliOper", "", "", "0X800AA60", "0X800AA60", 4, 0, "", "", "", "");
          }
        }
        else if ((paramInt1 >= 1280) && (paramInt2 >= 720) && (!this.o))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onRecvVideoResolutionChanged. w = ");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(", h = ");
          ((StringBuilder)localObject).append(paramInt2);
          QLog.i("QavDoubleVideoSharpnessMangaer", 1, ((StringBuilder)localObject).toString());
          TipsUtil.a(this.g.e, 1058, this.g.e.getApp().getString(2131893547));
          this.o = true;
          ReportController.b(null, "CliOper", "", "", "0X800AA60", "0X800AA60", 3, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.j.size() < 5)
    {
      this.j.offer(Long.valueOf(paramLong2));
    }
    else
    {
      this.j.poll();
      this.j.offer(Long.valueOf(paramLong2));
    }
    if (this.j.size() == 5)
    {
      paramLong1 = 0L;
      Object localObject = this.j.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((Long)((Iterator)localObject).next()).longValue() < QAVConfigUtils.f()) {
          paramLong1 += 1L;
        }
      }
      if (paramLong1 >= 4L)
      {
        paramLong2 = System.currentTimeMillis();
        if (paramLong2 - this.i > 10000L)
        {
          this.i = paramLong2;
          TipsUtil.a(this.g.e, 1057, HardCodeUtil.a(2131906668));
          ReportController.b(null, "CliOper", "", "", "0X800A346", "0X800A346", 0, 0, "", "", "", "");
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onReceiveFrameRateInfo frameRate sum/5:=");
          ((StringBuilder)localObject).append(paramLong1 / 5L);
          QLog.w("QavDoubleVideoSharpnessMangaer", 1, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveFrameModeResultInfo. isS2CPush = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", retCode = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", wording = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", videoMode = ");
    localStringBuilder.append(paramInt2);
    QLog.i("QavDoubleVideoSharpnessMangaer", 1, localStringBuilder.toString());
    if (!paramBoolean)
    {
      if ((paramInt1 != 0) && (!TextUtils.isEmpty(paramString))) {
        TipsUtil.a(this.g.e, 1057, paramString);
      }
    }
    else
    {
      int i1;
      if (this.g.k().ai != paramInt2) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((paramInt1 == 0) && (paramInt2 >= 0) && (paramInt2 < 4))
      {
        this.g.k().ai = paramInt2;
        this.j.clear();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceiveFrameModeResultInfo. newSharpnessMode = ");
        localStringBuilder.append(paramInt2);
        QLog.i("QavDoubleVideoSharpnessMangaer", 1, localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceiveFrameModeResultInfo. error. newSharpnessMode = ");
        localStringBuilder.append(paramInt2);
        QLog.e("QavDoubleVideoSharpnessMangaer", 1, localStringBuilder.toString());
      }
      if (paramInt1 == 10000) {
        ReportController.b(null, "CliOper", "", "", "0X800AA5F", "0X800AA5F", 4, 0, "", "", "", "");
      }
      if (!TextUtils.isEmpty(paramString)) {
        TipsUtil.a(this.g.e, 1057, paramString);
      }
      if ((paramInt1 == 0) && (i1 != 0))
      {
        m();
        long l1 = AudioHelper.c();
        this.h.K.f(l1, 1024);
      }
      this.e = this.g.k().ai;
    }
  }
  
  public void b()
  {
    k();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.a, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.setStartDelay(300L);
    localObjectAnimator.addListener(new QavDoubleVideoSharpnessMangaer.3(this));
    localObjectAnimator.start();
  }
  
  public void c()
  {
    RelativeLayout localRelativeLayout = this.a;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(8);
    }
  }
  
  public int d()
  {
    return this.e + 1;
  }
  
  public boolean e()
  {
    RelativeLayout localRelativeLayout = this.a;
    return (localRelativeLayout != null) && (localRelativeLayout.getVisibility() == 0);
  }
  
  public void f()
  {
    k();
    boolean bool1 = this.l.b();
    int i3 = Calendar.getInstance().get(11) * 60 + Calendar.getInstance().get(12);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("switchToHDMode. curMinute = ");
    ((StringBuilder)localObject).append(i3);
    ((StringBuilder)localObject).append(", startTime = ");
    ((StringBuilder)localObject).append(this.g.k().aj);
    ((StringBuilder)localObject).append(", endTime = ");
    ((StringBuilder)localObject).append(this.g.k().ak);
    ((StringBuilder)localObject).append(", tips = ");
    ((StringBuilder)localObject).append(this.g.k().al);
    ((StringBuilder)localObject).append(", m1080PHDModeTipsHasShowed = ");
    ((StringBuilder)localObject).append(this.n);
    QLog.i("QavDoubleVideoSharpnessMangaer", 1, ((StringBuilder)localObject).toString());
    boolean bool2 = this.n;
    int i2 = 3;
    int i1;
    if (bool2) {
      i1 = 3;
    } else {
      i1 = 2;
    }
    ReportController.b(null, "CliOper", "", "", "0X800AA5E", "0X800AA5E", i1 + 1, 0, "", "", "", "");
    if ((!bool1) && ((this.g.k().aj > i3) || (i3 >= this.g.k().ak)))
    {
      this.k = true;
      localObject = new QavDoubleVideoSharpnessMangaer.4(this);
      localObject = DialogUtil.a(this.h, 0, HardCodeUtil.a(2131906665), null, HardCodeUtil.a(2131898212), HardCodeUtil.a(2131906666), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      if (localObject != null) {
        ((QQCustomDialog)localObject).show();
      }
      ReportController.b(null, "CliOper", "", "", "0X800A562", "0X800A562", 0, 0, "", "", "", "");
      return;
    }
    if (this.n) {
      i1 = i2;
    } else {
      i1 = 2;
    }
    this.e = i1;
    n();
  }
  
  public void g()
  {
    QavSharpnessSVIPHelper localQavSharpnessSVIPHelper = this.l;
    if (localQavSharpnessSVIPHelper != null) {
      localQavSharpnessSVIPHelper.c();
    }
  }
  
  public void h()
  {
    QavSharpnessSVIPHelper localQavSharpnessSVIPHelper = this.l;
    if (localQavSharpnessSVIPHelper != null) {
      localQavSharpnessSVIPHelper.e();
    }
  }
  
  public void i()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      ((QavSharpnessSVIPHelper)localObject).f();
      this.l = null;
    }
    localObject = this.h;
    if (localObject != null) {
      ((AVActivity)localObject).unregisterReceiver(this.r);
    }
    if (QLog.isColorLevel()) {
      QLog.w("QavDoubleVideoSharpnessMangaer", 1, "doDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavDoubleVideoSharpnessMangaer
 * JD-Core Version:    0.7.0.1
 */