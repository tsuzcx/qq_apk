package com.tencent.mobileqq.activity.aio.audiopanel;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ptt.IPttAudioDataManager;
import com.tencent.mobileqq.ptt.IQQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.pttlogic.api.IPttPreSendService;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PressToChangeVoicePanel
  extends RelativeLayout
  implements View.OnTouchListener, AudioPanelCallback, IQQRecorder.OnQQRecorderListener
{
  public static String p;
  protected BaseChatPie a;
  protected QQAppInterface b;
  protected ViewGroup c;
  public AudioPanel d;
  protected ViewGroup e;
  protected ViewGroup f;
  protected ViewGroup g;
  protected ViewGroup h;
  protected VolumeChangeView i;
  protected VolumeChangeView j;
  protected ViewGroup k;
  protected PopupWindow l;
  protected View m;
  protected double n;
  protected IPttAudioDataManager o;
  public AudioPanelAdapter q;
  public boolean r;
  private TextView s;
  private ImageView t;
  private TextView u;
  private Handler v = new PressToChangeVoicePanel.1(this, Looper.getMainLooper());
  private boolean w = false;
  
  public PressToChangeVoicePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (p == null) {
        p = TraeHelper.b(BaseApplicationImpl.sApplication);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkVcSo sync:");
        localStringBuilder.append(p);
        QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
      }
    }
    if (p == null) {
      ThreadManager.post(new PressToChangeVoicePanel.2(paramBoolean, paramQQAppInterface, paramString), 5, null, false);
    }
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    int i2 = (int)paramMotionEvent.getRawY();
    int i3 = (int)paramMotionEvent.getRawX();
    if (i1 == 0) {
      if (((AudioPanelAioHelper)this.a.q(128)).d()) {
        ((AudioPanelAioHelper)this.a.q(128)).g(2);
      }
    }
    for (;;)
    {
      return true;
      if (i1 == 2)
      {
        paramMotionEvent = new int[2];
        paramView.getLocationOnScreen(paramMotionEvent);
        double d3 = paramView.getWidth();
        double d1 = paramView.getHeight();
        double d4 = paramMotionEvent[0];
        Double.isNaN(d4);
        Double.isNaN(d3);
        double d2 = paramMotionEvent[1];
        Double.isNaN(d2);
        Double.isNaN(d1);
        double d5 = i3;
        Double.isNaN(d5);
        if (Math.abs(d5 - (d4 + d3)) <= d3)
        {
          d3 = i2;
          Double.isNaN(d3);
          if (Math.abs(d3 - (d2 + d1)) <= d1) {}
        }
        else if (this.w)
        {
          this.w = false;
          if (((AudioPanelAioHelper)this.a.q(128)).d())
          {
            setClickable(false);
            ((AudioPanelAioHelper)this.a.q(128)).g(2);
          }
        }
        else
        {
          this.v.removeMessages(1);
          return true;
        }
      }
      else if ((i1 == 1) || (i1 == 3))
      {
        this.t.setPressed(false);
        if (!this.w) {
          break;
        }
        this.w = false;
        if (((AudioPanelAioHelper)this.a.q(128)).d())
        {
          setClickable(false);
          ((AudioPanelAioHelper)this.a.q(128)).g(2);
        }
      }
    }
    this.v.removeMessages(1);
    return true;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToSpeakPanel.prepareRecord() is called,time is:");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.q = true;
    this.s.setVisibility(8);
    this.g.setVisibility(0);
    this.h.setVisibility(8);
    this.t.setVisibility(0);
    this.i.setVisibility(8);
    this.j.setVisibility(8);
    this.c.setVisibility(4);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("level = ");
      localStringBuilder.append(paramInt);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    paramInt = this.o.a(paramInt);
    this.i.a(paramInt);
    this.j.a(paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3, ViewGroup paramViewGroup4, AudioPanelAdapter paramAudioPanelAdapter)
  {
    this.b = paramQQAppInterface;
    this.a = paramBaseChatPie;
    this.k = paramViewGroup1;
    this.d = paramAudioPanel;
    this.c = paramViewGroup2;
    this.e = paramViewGroup3;
    this.f = paramViewGroup4;
    this.q = paramAudioPanelAdapter;
    this.s = ((TextView)findViewById(2131440609));
    this.g = ((ViewGroup)findViewById(2131446307));
    this.h = ((ViewGroup)findViewById(2131435682));
    this.i = ((VolumeChangeView)findViewById(2131435684));
    this.j = ((VolumeChangeView)findViewById(2131435685));
    this.i.setColor(getResources().getColor(2131167984));
    this.j.setColor(getResources().getColor(2131167984));
    this.u = ((TextView)findViewById(2131446204));
    this.t = ((ImageView)findViewById(2131440603));
    this.t.setOnTouchListener(this);
    this.o = ((IPttUtils)QRoute.api(IPttUtils.class)).creatPttAudioDataManager();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangeVoice.init() is called");
    }
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
    {
      this.s.setTextColor(Color.parseColor("#FF737373"));
      this.u.setTextColor(Color.parseColor("#FF4A4A4A"));
      this.i.setColor(getResources().getColor(2131167984));
      this.j.setColor(getResources().getColor(2131167984));
    }
    if (QQTheme.isNowThemeSimpleNight()) {
      this.t.setImageResource(2130851890);
    } else {
      this.t.setImageResource(2130851889);
    }
    if (AppSetting.e)
    {
      ViewCompat.setImportantForAccessibility(this.s, 2);
      this.t.setContentDescription(getContext().getString(2131888054));
    }
  }
  
  public boolean b()
  {
    boolean bool = ((AudioPanelAioHelper)this.a.q(128)).g();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToChangeVoicePanel.onBackEvent() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      ((AudioPanelAioHelper)this.a.q(128)).g(2);
      return true;
    }
    return false;
  }
  
  public void c()
  {
    boolean bool = ((AudioPanelAioHelper)this.a.q(128)).g();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToChangeVoicePanel.onPause() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool) {
      ((AudioPanelAioHelper)this.a.q(128)).g(2);
    }
  }
  
  public void d()
  {
    boolean bool = ((AudioPanelAioHelper)this.a.q(128)).g();
    Object localObject;
    if ((this.a.aX() != null) && (!this.a.aX().isFinishing()))
    {
      localObject = this.l;
      if ((localObject != null) && (((PopupWindow)localObject).isShowing())) {
        this.l.dismiss();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PressToSpeakPanel.onDestroy() is called,isRecording is:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      ((AudioPanelAioHelper)this.a.q(128)).g(1);
      ((AudioPanelAioHelper)this.a.q(128)).f(1);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" PressToSpeakPanel.startRecord() is called, time is ");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    this.i.a();
    this.j.a();
    this.s.setVisibility(8);
    this.g.setVisibility(8);
    this.h.setVisibility(0);
    this.t.setVisibility(0);
    this.i.setVisibility(0);
    this.j.setVisibility(0);
    this.c.setVisibility(4);
  }
  
  public void f()
  {
    if (!this.r)
    {
      if (this.q.c == null)
      {
        localObject = (ListenChangeVoicePanel)LayoutInflater.from(this.b.getApp()).inflate(2131627264, null);
        ((ListenChangeVoicePanel)localObject).a(this.b, this.a, this.k);
        this.q.c = ((ViewGroup)localObject);
      }
      else
      {
        localObject = (ViewGroup)this.q.c.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.q.c);
        }
        ((ListenChangeVoicePanel)this.q.c).a(this.b, this.a, this.k);
      }
      Object localObject = (ListenChangeVoicePanel)this.q.c;
      ((ListenChangeVoicePanel)localObject).a();
      this.k.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
      ((ListenChangeVoicePanel)localObject).setVisibility(8);
      this.r = true;
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset() is called");
    }
    int i1 = 0;
    this.w = false;
    if (this.a.aX().isFinishing()) {
      return;
    }
    this.s.setVisibility(0);
    this.g.setVisibility(8);
    this.h.setVisibility(8);
    this.t.setVisibility(0);
    this.u.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(0.0D));
    this.i.setVisibility(8);
    this.j.setVisibility(8);
    this.c.setVisibility(0);
    this.d.setStatus(1);
    PopupWindow localPopupWindow = this.l;
    if (localPopupWindow != null)
    {
      if (localPopupWindow.isShowing()) {
        try
        {
          this.l.dismiss();
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
          }
        }
      }
      this.l = null;
    }
    Object localObject = this.m;
    if (localObject != null)
    {
      if (((View)localObject).getParent() != null) {
        ((ViewGroup)this.m.getParent()).removeView(this.m);
      }
      this.m = null;
    }
    localObject = (PanelIconLinearLayout)this.f;
    if (localObject != null)
    {
      ((PanelIconLinearLayout)localObject).setAllAlpha(1.0F);
      ((PanelIconLinearLayout)localObject).setAllEnable(true);
    }
    int i2 = this.e.getChildCount();
    while (i1 < i2)
    {
      localObject = this.e.getChildAt(i1);
      if (((View)localObject).getVisibility() != 8)
      {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 1.0F);
        localAlphaAnimation.setDuration(0L);
        localAlphaAnimation.setInterpolator(new LinearInterpolator());
        ((View)localObject).startAnimation(localAlphaAnimation);
      }
      i1 += 1;
    }
    i();
  }
  
  void h()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.9F, 1.0F, 0.9F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setStartOffset(0L);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setInterpolator(new LinearInterpolator());
    localAnimationSet.addAnimation(localScaleAnimation);
    localScaleAnimation = new ScaleAnimation(0.9F, 1.0F, 0.9F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setStartOffset(200L);
    localScaleAnimation.setDuration(150L);
    localScaleAnimation.setInterpolator(new LinearInterpolator());
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setAnimationListener(new PressToChangeVoicePanel.4(this));
    this.t.startAnimation(localAnimationSet);
  }
  
  @TargetApi(14)
  public void i()
  {
    if (AppSetting.e) {
      this.t.postDelayed(new PressToChangeVoicePanel.5(this), 500L);
    }
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onBeginReceiveData() is called");
    }
    ((IPttPreSendService)this.b.getRuntimeService(IPttPreSendService.class)).startPreSendIfNeed(paramString, paramRecorderParam, p);
    return ((AudioPanelAioHelper)this.a.q(128)).l();
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangePanel.onInitFailed() is called");
    }
    ((AudioPanelAioHelper)this.a.q(128)).a(paramString, true, false, paramRecorderParam);
    this.v.sendEmptyMessage(1006);
    ReportController.b(this.b, "CliOper", "", "", "0X8005A17", "0X8005A17", 3, 0, "", "", "", "8.8.17");
  }
  
  public void onInitSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToChangePanel.onInitSuccess() is called");
    }
  }
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    ((AudioPanelAioHelper)this.a.q(128)).a(paramString, true, false, paramRecorderParam);
    this.v.sendEmptyMessage(1006);
    ReportController.b(this.b, "CliOper", "", "", "0X8005A17", "0X8005A17", 4, 0, "", "", "", "8.8.17");
    ((IPttPreSendService)this.b.getRuntimeService(IPttPreSendService.class)).cleanUp();
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RecordSoundPanel.onRecorderEnd() is called,path is:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", type: ");
      ((StringBuilder)localObject).append(paramRecorderParam.c);
      ((StringBuilder)localObject).append(", time:");
      ((StringBuilder)localObject).append(this.n);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (this.n < 800.0D)
    {
      ((AudioPanelAioHelper)this.a.q(128)).a(paramString);
      localObject = new HashMap();
      ((HashMap)localObject).put(Integer.valueOf(0), paramString);
      ((HashMap)localObject).put(Integer.valueOf(1), paramRecorderParam);
      paramString = this.v;
      paramString.sendMessage(paramString.obtainMessage(1003, localObject));
      ((IPttPreSendService)this.b.getRuntimeService(IPttPreSendService.class)).cleanUp();
      ReportController.b(this.b, "CliOper", "", "", "0X8005A17", "0X8005A17", 1, 0, String.valueOf((int)this.n), "", "", "8.8.17");
      ReportController.b(this.b, "CliOper", "", "", "changevoice", "0X8006F4E", 0, 0, "1", "", "", "");
      return;
    }
    ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportGcAndMemoryUse(3, (int)this.n);
    ReportController.b(this.b, "CliOper", "", "", "changevoice", "0X8006F4E", 0, 0, "0", "", "", "");
    int i1 = ((AudioPanelAioHelper)this.a.q(128)).h();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fateOfRecorder is:");
      ((StringBuilder)localObject).append(i1);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (i1 == 2)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put(Integer.valueOf(0), paramString);
      ((HashMap)localObject).put(Integer.valueOf(1), paramRecorderParam);
      paramString = this.v;
      paramString.sendMessage(paramString.obtainMessage(1005, localObject));
      return;
    }
    if (i1 == 1)
    {
      ((IPttPreSendService)this.b.getRuntimeService(IPttPreSendService.class)).cleanUp();
      ((AudioPanelAioHelper)this.a.q(128)).c(paramString, 4, paramRecorderParam);
      paramRecorderParam = this.v;
      paramRecorderParam.sendMessage(paramRecorderParam.obtainMessage(1004, paramString));
    }
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToChangeVoicePanel.onRecorderError() is called,path is:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",errorCode is:");
      localStringBuilder.append(paramString2);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    ((AudioPanelAioHelper)this.a.q(128)).a(paramString1, false, false, paramRecorderParam);
    this.v.sendEmptyMessage(1006);
    ReportController.b(this.b, "CliOper", "", "", "0X8005A17", "0X8005A17", 2, 0, "", "", "", "8.8.17");
    ((IPttPreSendService)this.b.getRuntimeService(IPttPreSendService.class)).cleanUp();
  }
  
  public void onRecorderNotReady(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToChanegVoicePanel.onRecorderNotReady() is called,path is:");
      localStringBuilder.append(paramString);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
  }
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PressToChanegVoicePanel.onRecorderPrepare() is called,path is:");
      localStringBuilder.append(paramString);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    this.v.sendEmptyMessage(1001);
    ((AudioPanelAioHelper)this.a.q(128)).a(paramString, false, paramRecorderParam);
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    ((AudioPanelAioHelper)this.a.q(128)).a(paramString, paramArrayOfByte, paramInt1, paramInt2, paramDouble, paramRecorderParam);
    ((AudioPanelAioHelper)this.a.q(128)).b(paramString, (int)paramDouble, paramRecorderParam);
    ((IPttPreSendService)this.b.getRuntimeService(IPttPreSendService.class)).handleSliceData(paramArrayOfByte, paramInt1);
    if (this.o.a())
    {
      paramString = this.v;
      paramString.sendMessage(paramString.obtainMessage(1007, paramInt2, 0, Double.valueOf(paramDouble)));
    }
    this.n = paramDouble;
  }
  
  public int onRecorderStart()
  {
    this.n = 0.0D;
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onRecorderStart() is called");
    }
    this.v.sendEmptyMessage(1002);
    PttInfoCollector.reportCostUntilPrepare(0);
    return 350;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt)
  {
    ((AudioPanelAioHelper)this.a.q(128)).h(paramInt);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject = this.a;
    boolean bool = false;
    if ((localObject != null) && ((localObject instanceof DeviceMsgChatPie)))
    {
      QQToast.makeText(BaseApplication.getContext(), 2131888530, 0).show(this.a.aX().getTitleBarHeight());
      return false;
    }
    int i1 = paramMotionEvent.getAction();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PressToChangeVoice.onTouch() is called,action is:");
      ((StringBuilder)localObject).append(i1);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (paramView.getId() == 2131440603)
    {
      if (i1 == 0)
      {
        this.t.setPressed(true);
        paramView = new PressToChangeVoicePanel.3(this);
        paramView = Message.obtain(this.v, paramView);
        paramView.what = 1;
        this.v.sendMessageDelayed(paramView, 150L);
      }
      else if (this.a != null)
      {
        a(paramView, paramMotionEvent);
      }
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel
 * JD-Core Version:    0.7.0.1
 */