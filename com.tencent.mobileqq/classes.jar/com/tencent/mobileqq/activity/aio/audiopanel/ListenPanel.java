package com.tencent.mobileqq.activity.aio.audiopanel;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.ptt.IPttAudioDataManager;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioFileDataListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ListenPanel
  extends RelativeLayout
  implements Handler.Callback, View.OnClickListener, AudioPanelCallback, AudioTransitionAnimManager.TransitionAnimListener, IAudioFileDataListener, VoicePlayer.VoicePlayerListener
{
  public static int a = 1;
  public static int b = a + 1;
  private RecordParams.RecorderParam A;
  private int B = a;
  private Runnable C = new ListenPanel.2(this);
  int c;
  LottieDrawable d;
  Drawable e;
  private QQAppInterface f;
  private BaseChatPie g;
  private AudioPanel h;
  private ViewGroup i;
  private String j;
  private RecordParams.RecorderParam k;
  private VoicePlayer l;
  private TextView m;
  private CircleProgressView n;
  private LinearLayout o;
  private TextView p;
  private TextView q;
  private ViewGroup r;
  private Handler s;
  private int t;
  private double u;
  private boolean v = false;
  private boolean w = false;
  private VolumeChangeView x;
  private VolumeChangeView y;
  private IPttAudioDataManager z;
  
  public ListenPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public ListenPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private void a(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    if (this.A.c != 1) {
      i1 = 8;
    }
    this.x.setVisibility(i1);
    this.y.setVisibility(i1);
  }
  
  private boolean a(float paramFloat, int paramInt)
  {
    return Math.abs(paramFloat - paramInt) < 1.0E-007D;
  }
  
  private void c(int paramInt)
  {
    this.c = paramInt;
    AudioTransitionAnimManager localAudioTransitionAnimManager = AudioTransitionAnimManager.a();
    LottieDrawable localLottieDrawable = this.d;
    if ((localLottieDrawable != null) && (localAudioTransitionAnimManager.b(localLottieDrawable))) {
      localAudioTransitionAnimManager.a(this.d);
    }
    this.d = localAudioTransitionAnimManager.a(getContext(), this.c);
    if (this.d != null) {
      e();
    }
  }
  
  private void e()
  {
    if (this.d == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "playTransitionAnim mCurLottieDrawable == null");
      }
      return;
    }
    if (!(this.n.getDrawable() instanceof LottieDrawable)) {
      this.e = this.n.getDrawable();
    }
    if ((this.d.getIntrinsicWidth() > 0) && (a(this.d.getScale(), 1))) {
      this.d.setScale(this.n.getWidth() / this.d.getIntrinsicWidth(), this.n.getHeight() / this.d.getIntrinsicHeight());
    }
    AudioTransitionAnimManager.a().a(this.d, this.c, this.n, true);
  }
  
  private void setPlayImageState(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ListenPanel.setPlayImageState:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (XPanelContainer.a != (int)(getContext().getResources().getDisplayMetrics().density * 196.0F))
    {
      this.n.setBackgroundResource(2130851908);
      if (paramBoolean) {
        this.n.setImageDrawable(getContext().getResources().getDrawable(2130846188));
      } else {
        this.n.setImageDrawable(getContext().getResources().getDrawable(2130846190));
      }
      localObject = (RelativeLayout.LayoutParams)this.o.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(75.0F, getContext().getResources());
      this.o.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    this.n.setBackgroundResource(2130851909);
    if (paramBoolean) {
      this.n.setImageDrawable(getContext().getResources().getDrawable(2130846189));
    } else {
      this.n.setImageDrawable(getContext().getResources().getDrawable(2130846191));
    }
    Object localObject = (RelativeLayout.LayoutParams)this.o.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(64.0F, getContext().getResources());
    this.o.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ListenPanel. stopAudioPlayer ");
      ((StringBuilder)localObject).append(this.j);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    b(203);
    Object localObject = this.l;
    if (localObject != null)
    {
      ((VoicePlayer)localObject).f();
      this.l = null;
    }
  }
  
  public void a(int paramInt)
  {
    paramInt = this.z.a(paramInt);
    this.x.a(paramInt);
    this.y.a(paramInt);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.n.setProgress(0);
    setPlayImageState(true);
    this.n.setContentDescription(getContext().getString(2131888058));
    a(false);
    a();
  }
  
  public void a(Animator paramAnimator, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("ListenPanel onAnimationEnd  type=");
      paramAnimator.append(paramInt);
      QLog.d("AIOAudioPanel", 2, paramAnimator.toString());
    }
    if (AudioTransitionAnimUtils.b(paramInt)) {
      return;
    }
    paramAnimator = this.e;
    if (paramAnimator != null) {
      this.n.setImageDrawable(paramAnimator);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, int paramInt)
  {
    this.f = paramQQAppInterface;
    this.g = paramBaseChatPie;
    this.h = paramAudioPanel;
    this.i = paramViewGroup2;
    this.r = paramViewGroup1;
    this.t = paramInt;
    this.s = new Handler(Looper.getMainLooper(), this);
    this.m = ((TextView)findViewById(2131446204));
    this.m.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(0.0D));
    this.n = ((CircleProgressView)findViewById(2131437323));
    this.n.setPresenter(((IAudioPanelPresenterCreater)QRoute.api(IAudioPanelPresenterCreater.class)).createCircleProcessViewPresenter(this.n));
    this.p = ((TextView)findViewById(2131437322));
    this.o = ((LinearLayout)findViewById(2131437324));
    this.q = ((TextView)findViewById(2131437325));
    this.x = ((VolumeChangeView)findViewById(2131435684));
    this.y = ((VolumeChangeView)findViewById(2131435685));
    setPlayImageState(true);
    this.n.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.z = ((IPttUtils)QRoute.api(IPttUtils.class)).creatPttAudioDataManager();
    this.A = this.g.aU();
    this.x.setColor(getResources().getColor(2131167984));
    this.y.setColor(getResources().getColor(2131167984));
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null)) {
      this.m.setTextColor(Color.parseColor("#FF4A4A4A"));
    }
    this.n.setRingColor(getResources().getColor(2131167981));
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.init() is called");
    }
  }
  
  public void a(LottieDrawable paramLottieDrawable, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ListenPanel onDrawableLoaded mCurAnimType:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(",type= ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" drawable=");
      localStringBuilder.append(paramLottieDrawable);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (AudioTransitionAnimUtils.b(paramInt)) {
      return;
    }
    if (this.c == paramInt)
    {
      this.d = paramLottieDrawable;
      if (this.d != null)
      {
        ThreadManager.getUIHandler().removeCallbacks(this.C);
        ThreadManager.getUIHandler().post(this.C);
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      if (paramInt2 > paramInt1) {
        paramInt1 = 100;
      } else {
        paramInt1 = paramInt2 * 100 / paramInt1;
      }
    }
    else {
      paramInt1 = 0;
    }
    this.n.setProgress(paramInt1);
    this.m.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(paramInt2));
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (this.z.a()))
    {
      int i1 = (int)AudioHelper.a(this.f.getApplication().getApplicationContext(), paramArrayOfByte, paramArrayOfByte.length, 1.0F);
      paramArrayOfByte = this.s;
      paramArrayOfByte.sendMessage(paramArrayOfByte.obtainMessage(1, i1, 0));
    }
  }
  
  public void b(int paramInt)
  {
    paramInt = AudioTransitionAnimUtils.c(paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ListenPanel startPlayAnimByType:,type= ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" isEnabled()");
      localStringBuilder.append(isEnabled());
      localStringBuilder.append(" getVisibility=");
      localStringBuilder.append(getVisibility());
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (!AudioTransitionAnimManager.a().c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "fileNotExsit");
      }
      return;
    }
    if ((this.h.getCurrentItem() == 2) && (getVisibility() == 0) && (isEnabled()))
    {
      AudioTransitionAnimManager.a().a(this);
      this.h.g();
      c(paramInt);
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public boolean b()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ListenPanel.onBackEvent() is called,audioPath is:");
      ((StringBuilder)localObject).append(this.j);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    a();
    if (this.B == b) {
      i1 = 3;
    } else {
      i1 = 2;
    }
    ((AudioPanelAioHelper)this.g.q(128)).c(this.j, i1, this.k);
    ((AudioPanelAioHelper)this.g.q(128)).a(this.j, null);
    int i1 = this.t;
    if (i1 == 1)
    {
      setVisibility(8);
      localObject = (PressToSpeakPanel)this.r.findViewById(2131440608);
      ((PressToSpeakPanel)localObject).a();
      ((PressToSpeakPanel)localObject).setVisibility(0);
      return false;
    }
    if (i1 == 2)
    {
      setVisibility(8);
      localObject = (RecordSoundPanel)this.r.findViewById(2131444496);
      ((RecordSoundPanel)localObject).a();
      ((RecordSoundPanel)localObject).setVisibility(0);
    }
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ListenPanel.onPause() is called,audioPath is:");
      localStringBuilder.append(this.j);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (this.l != null)
    {
      a();
      this.m.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(this.u));
      this.n.setProgress(0);
      setPlayImageState(true);
      this.n.setContentDescription(getContext().getString(2131888058));
    }
  }
  
  public void d()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ListenPanel.onDestroy() is called,audioPath is:");
      ((StringBuilder)localObject).append(this.j);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    a();
    if (this.B == b) {
      i1 = 3;
    } else {
      i1 = 2;
    }
    ((AudioPanelAioHelper)this.g.q(128)).c(this.j, i1, this.k);
    ((AudioPanelAioHelper)this.g.q(128)).a(this.j, null);
    int i1 = this.t;
    if (i1 == 1)
    {
      setVisibility(8);
      localObject = (PressToSpeakPanel)this.r.findViewById(2131440608);
      ((PressToSpeakPanel)localObject).a();
      ((PressToSpeakPanel)localObject).setVisibility(0);
      return;
    }
    if (i1 == 2)
    {
      setVisibility(8);
      localObject = (RecordSoundPanel)this.r.findViewById(2131444496);
      ((RecordSoundPanel)localObject).a();
      ((RecordSoundPanel)localObject).setVisibility(0);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    a(paramMessage.arg1);
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i2 = paramView.getId();
    Object localObject;
    int i1;
    if (i2 == 2131437323)
    {
      if (AppSetting.e) {
        AudioUtil.b(2131230817, false);
      }
      if (!this.v)
      {
        this.v = true;
        localObject = this.f;
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.B == b) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        localStringBuilder.append(i1);
        localStringBuilder.append("");
        ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8004602", "0X8004602", 0, 0, localStringBuilder.toString(), "", "", "");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ListenPanel listened, jump source = ");
          ((StringBuilder)localObject).append(this.B);
          QLog.d("QQRecorder", 2, ((StringBuilder)localObject).toString());
        }
      }
      if (this.l == null)
      {
        this.l = new VoicePlayer(this.j, new Handler(), this.k.c);
        if ((this.w) && (this.l.b())) {
          this.l.a(this);
        }
        this.l.a(getContext());
        this.l.h();
        this.l.a(this);
        this.l.c();
        setPlayImageState(false);
        b(202);
        this.n.setContentDescription(getContext().getString(2131888059));
        a(true);
      }
      else
      {
        setPlayImageState(true);
        a();
        this.m.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(this.u));
        this.n.setProgress(0);
        this.n.setContentDescription(getContext().getString(2131888058));
        a(false);
      }
    }
    else
    {
      i1 = 3;
      if (i2 == 2131437322)
      {
        a();
        if (this.B != b) {
          i1 = 2;
        }
        ((AudioPanelAioHelper)this.g.q(128)).c(this.j, i1, this.k);
        ((AudioPanelAioHelper)this.g.q(128)).a(this.j, null);
        i1 = this.t;
        if (i1 == 1)
        {
          setVisibility(8);
          localObject = (PressToSpeakPanel)this.r.findViewById(2131440608);
          ((PressToSpeakPanel)localObject).a();
          ((PressToSpeakPanel)localObject).setVisibility(0);
        }
        else if (i1 == 2)
        {
          setVisibility(8);
          localObject = (RecordSoundPanel)this.r.findViewById(2131444496);
          ((RecordSoundPanel)localObject).a();
          ((RecordSoundPanel)localObject).setVisibility(0);
          ReportController.b(this.f, "CliOper", "", "", "Voice_record", "Voice_record _cancel", 0, 0, "", "", "", "");
          if ((this.g instanceof PublicAccountChatPie)) {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.f, "P_CliOper", "Pb_account_lifeservice", "", "0X8005856", "0X8005856", 0, 0, "", "", "", "", false);
          }
        }
        a(false);
      }
      else if (i2 == 2131437325)
      {
        a();
        i2 = (int)this.u;
        if (this.t == 2)
        {
          ReportController.b(this.f, "CliOper", "", "", "Voice_record", "Record_attribute", 0, 0, String.valueOf(i2), "", "", "");
          if ((this.g instanceof PublicAccountChatPie)) {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.f, "P_CliOper", "Pb_account_lifeservice", "", "0X8005855", "0X8005855", 0, 0, "", "", "", "", false);
          }
        }
        if (this.u < 1000.0D)
        {
          QQToast.makeText(this.g.aX(), this.g.aX().getString(2131896542), 0).show();
        }
        else
        {
          boolean bool = ((ReceiptHelper)this.g.q(118)).a;
          ((AudioPanelAioHelper)this.g.q(128)).a(this.j, null);
          if (this.B == a) {
            i1 = 2;
          } else {
            i1 = 3;
          }
          ((AudioPanelAioHelper)this.g.q(128)).a(this.j, i1, i2, this.k, 0, true, 0);
          if (bool)
          {
            localObject = (PressToSpeakPanel)this.r.findViewById(2131440608);
            ((PressToSpeakPanel)localObject).h();
            ((PressToSpeakPanel)localObject).a();
          }
          else
          {
            i1 = this.t;
            if (i1 == 1)
            {
              setVisibility(8);
              localObject = (PressToSpeakPanel)this.r.findViewById(2131440608);
              ((PressToSpeakPanel)localObject).a();
              ((PressToSpeakPanel)localObject).setVisibility(0);
            }
            else if (i1 == 2)
            {
              setVisibility(8);
              localObject = (RecordSoundPanel)this.r.findViewById(2131444496);
              ((RecordSoundPanel)localObject).a();
              ((RecordSoundPanel)localObject).setVisibility(0);
            }
            a(false);
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAudioPath(String paramString, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    this.j = paramString;
    this.u = paramDouble;
    this.k = paramRecorderParam;
    this.m.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(paramDouble));
    this.n.setProgress(0);
    this.n.setAnimFlag(true);
    setPlayImageState(true);
    this.n.setContentDescription(getContext().getString(2131888058));
    if (AppSetting.e)
    {
      this.m.setFocusable(true);
      ViewCompat.setAccessibilityDelegate(this.m, new ListenPanel.1(this));
      paramRecorderParam = this.p;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.p.getText());
      localStringBuilder.append(getContext().getString(2131888061));
      paramRecorderParam.setContentDescription(localStringBuilder.toString());
      paramRecorderParam = this.q;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.q.getText());
      localStringBuilder.append(getContext().getString(2131888061));
      paramRecorderParam.setContentDescription(localStringBuilder.toString());
      QQAppInterface.speak(getContext().getString(2131888056));
    }
    if (QLog.isColorLevel())
    {
      paramRecorderParam = new StringBuilder();
      paramRecorderParam.append("ListenPanel.setAudioPath() is called,path is:");
      paramRecorderParam.append(paramString);
      paramRecorderParam.append(",recordTime is:");
      paramRecorderParam.append(paramDouble);
      QLog.d("AIOAudioPanel", 2, paramRecorderParam.toString());
    }
  }
  
  public void setJumpSource(int paramInt)
  {
    this.B = paramInt;
  }
  
  public void setNeedAudioData(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel
 * JD-Core Version:    0.7.0.1
 */