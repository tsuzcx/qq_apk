package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.ptt.IPttAudioDataManager;
import com.tencent.mobileqq.ptt.IQQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class RecordSoundPanel
  extends RelativeLayout
  implements View.OnClickListener, AudioPanelCallback, IQQRecorder.OnQQRecorderListener
{
  protected BaseChatPie a;
  protected QQAppInterface b;
  protected ViewGroup c;
  protected AudioPanel d;
  protected ViewGroup e;
  protected ViewGroup f;
  protected TextView g;
  protected ViewGroup h;
  protected ViewGroup i;
  protected VolumeChangeView j;
  protected VolumeChangeView k;
  protected TextView l;
  protected ImageView m;
  protected boolean n = true;
  protected ViewGroup o;
  protected String p;
  protected PopupWindow q;
  protected View r;
  protected double s;
  protected IPttAudioDataManager t;
  protected boolean u = true;
  public Handler v = new RecordSoundPanel.1(this, Looper.getMainLooper());
  private boolean w = false;
  
  public RecordSoundPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecordSoundPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset() is called");
    }
    setClickable(true);
    Object localObject1 = this.g;
    int i1 = 0;
    ((TextView)localObject1).setVisibility(0);
    this.h.setVisibility(8);
    this.i.setVisibility(8);
    this.m.setVisibility(0);
    this.m.setContentDescription(HardCodeUtil.a(2131910762));
    this.l.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(0.0D));
    this.d.setStatus(1);
    this.c.setVisibility(0);
    localObject1 = this.q;
    if (localObject1 != null)
    {
      if (((PopupWindow)localObject1).isShowing()) {
        try
        {
          this.q.dismiss();
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
          }
        }
      }
      this.q = null;
    }
    Object localObject2 = this.r;
    if (localObject2 != null)
    {
      if (((View)localObject2).getParent() != null) {
        ((ViewGroup)this.r.getParent()).removeView(this.r);
      }
      this.r = null;
    }
    localObject2 = (PanelIconLinearLayout)this.f;
    if (localObject2 != null)
    {
      ((PanelIconLinearLayout)localObject2).setAllAlpha(1.0F);
      ((PanelIconLinearLayout)localObject2).setAllEnable(true);
    }
    int i2 = this.e.getChildCount();
    while (i1 < i2)
    {
      localObject2 = this.e.getChildAt(i1);
      if (((View)localObject2).getVisibility() != 8)
      {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 1.0F);
        localAlphaAnimation.setDuration(0L);
        localAlphaAnimation.setInterpolator(new LinearInterpolator());
        ((View)localObject2).startAnimation(localAlphaAnimation);
      }
      i1 += 1;
    }
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
    paramInt = this.t.a(paramInt);
    this.j.a(paramInt);
    this.k.a(paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3, ViewGroup paramViewGroup4)
  {
    this.b = paramQQAppInterface;
    this.a = paramBaseChatPie;
    this.o = paramViewGroup1;
    this.d = paramAudioPanel;
    this.c = paramViewGroup2;
    this.e = paramViewGroup3;
    this.f = paramViewGroup4;
    this.g = ((TextView)findViewById(2131440605));
    this.g.setContentDescription(HardCodeUtil.a(2131910760));
    this.h = ((ViewGroup)findViewById(2131446307));
    this.i = ((ViewGroup)findViewById(2131435682));
    this.j = ((VolumeChangeView)findViewById(2131435684));
    this.k = ((VolumeChangeView)findViewById(2131435685));
    this.j.setColor(getResources().getColor(2131167984));
    this.k.setColor(getResources().getColor(2131167984));
    this.l = ((TextView)findViewById(2131444501));
    this.m = ((ImageView)findViewById(2131444495));
    this.m.setOnClickListener(this);
    paramBaseChatPie.aX().getResources();
    setClickable(true);
    this.t = ((IPttUtils)QRoute.api(IPttUtils.class)).creatPttAudioDataManager();
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
    {
      this.g.setTextColor(Color.parseColor("#FF737373"));
      this.l.setTextColor(Color.parseColor("#FF4A4A4A"));
      this.j.setColor(getResources().getColor(2131167984));
      this.k.setColor(getResources().getColor(2131167984));
    }
    if (QQTheme.isNowThemeSimpleNight()) {
      this.m.setImageResource(2130846193);
    } else {
      this.m.setImageResource(2130846192);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("RecordSoundPanel.init() is called,time is:");
      paramQQAppInterface.append(System.currentTimeMillis());
      QLog.d("AIOAudioPanel", 2, paramQQAppInterface.toString());
    }
  }
  
  public boolean b()
  {
    boolean bool = ((AudioPanelAioHelper)this.a.q(128)).g();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onBackEvent() is called,isRecording is:");
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
      localStringBuilder.append("RecordSoundPanel.onPause() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool) {
      ((AudioPanelAioHelper)this.a.q(128)).g(2);
    }
  }
  
  public void d()
  {
    a();
    boolean bool = ((AudioPanelAioHelper)this.a.q(128)).g();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onDestroy() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      ((AudioPanelAioHelper)this.a.q(128)).g(1);
      ((AudioPanelAioHelper)this.a.q(128)).f(1);
    }
  }
  
  public void e()
  {
    this.g.setVisibility(8);
    this.h.setVisibility(0);
    this.i.setVisibility(8);
    this.m.setVisibility(0);
    this.c.setVisibility(4);
  }
  
  public void f()
  {
    VolumeChangeView localVolumeChangeView = this.j;
    if ((localVolumeChangeView != null) && (this.k != null))
    {
      localVolumeChangeView.a();
      this.k.a();
    }
    this.g.setVisibility(8);
    this.h.setVisibility(8);
    this.i.setVisibility(0);
    this.m.setVisibility(0);
    this.c.setVisibility(4);
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBeginReceiveData() is called");
    }
    return ((AudioPanelAioHelper)this.a.q(128)).l();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onClick() is called");
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.q = true;
    if (i1 == 2131444495)
    {
      boolean bool = ((AudioPanelAioHelper)this.a.q(128)).g();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isRecording is:");
        ((StringBuilder)localObject).append(bool);
        QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
      }
      if (bool)
      {
        if (((AudioPanelAioHelper)this.a.q(128)).d())
        {
          setClickable(false);
          ((AudioPanelAioHelper)this.a.q(128)).g(2);
        }
      }
      else
      {
        ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).setsCostUntilPrepare(SystemClock.uptimeMillis());
        i1 = this.a.aX().getTitleBarHeight();
        localObject = this.a.aU();
        if (!((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).checkExternalStorageForRecord())
        {
          QQToast.makeText(BaseApplication.getContext(), 2131916078, 0).show(i1);
        }
        else if (!((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).checkIntenalStorageForRecord(((RecordParams.RecorderParam)localObject).c))
        {
          QQToast.makeText(BaseApplication.getContext(), 2131890947, 0).show(i1);
        }
        else if (this.b.isVideoChatting())
        {
          QQToast.makeText(BaseApplication.getContext(), 2131892896, 0).show();
        }
        else if (AudioUtil.b(1))
        {
          ((IPttUtils)QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission(this.a.aX());
        }
        else
        {
          this.d.b(5);
          this.m.setImageResource(2130846194);
          this.m.setContentDescription(HardCodeUtil.a(2131910761));
          ((AudioPanelAioHelper)this.a.q(128)).a(this, this.u, (RecordParams.RecorderParam)localObject);
          ((AudioPanelAioHelper)this.a.q(128)).f(2);
          this.d.setStatus(3);
          localObject = new Rect();
          getWindowVisibleDisplayFrame((Rect)localObject);
          Rect localRect = new Rect();
          this.e.getGlobalVisibleRect(localRect);
          localRect = new Rect();
          if (ThemeUtil.isNowThemeIsSimple(this.b, false, null)) {
            this.e.getGlobalVisibleRect(localRect);
          } else {
            this.f.getGlobalVisibleRect(localRect);
          }
          int i2 = localRect.bottom;
          if (((!Build.MODEL.startsWith("Coolpad")) || (Build.VERSION.SDK_INT != 19)) && ((!Build.MODEL.startsWith("Coolpad A8")) || (Build.VERSION.SDK_INT != 22)) && ((!Build.MODEL.startsWith("Coolpad B770")) || (Build.VERSION.SDK_INT != 22)))
          {
            i1 = i2;
            if (Build.MODEL.startsWith("ivvi"))
            {
              i1 = i2;
              if (Build.VERSION.SDK_INT != 22) {}
            }
          }
          else
          {
            i1 = i2 - ((Rect)localObject).top;
          }
          if (localRect.top <= getResources().getDisplayMetrics().heightPixels) {
            this.q = AudioPanel.a(this.a.aX(), ((Rect)localObject).width(), i1, this, 0, 0, 0);
          }
          this.r = AudioPanel.a(this.a.aX(), this.e, this.f);
        }
        ReportController.b(this.b, "CliOper", "", "", "Voice_record", "Voice_record_clk", 0, 0, "", "", "", "");
        if ((this.a instanceof PublicAccountChatPie)) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.b, "P_CliOper", "Pb_account_lifeservice", "", "0X8005854", "0X8005854", 0, 0, "", "", Double.toString(this.s), "", false);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitFailed() is called");
    }
    ((AudioPanelAioHelper)this.a.q(128)).a(paramString, true, false, paramRecorderParam);
    this.v.post(new RecordSoundPanel.4(this));
  }
  
  public void onInitSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitSuccess() is called");
    }
  }
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    ((AudioPanelAioHelper)this.a.q(128)).a(paramString, true, false, paramRecorderParam);
    this.v.removeMessages(1);
    this.v.post(new RecordSoundPanel.6(this));
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onRecorderEnd() is called,path is:");
      localStringBuilder.append(paramString);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    this.v.removeMessages(1);
    if (this.s < 500.0D)
    {
      ((AudioPanelAioHelper)this.a.q(128)).a(paramString);
      this.v.post(new RecordSoundPanel.8(this, paramString, paramRecorderParam));
      return;
    }
    ((IPttInfoCollector)QRoute.api(IPttInfoCollector.class)).reportGcAndMemoryUse(2, (int)this.s);
    int i1 = ((AudioPanelAioHelper)this.a.q(128)).h();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fateOfRecorder is:");
      localStringBuilder.append(i1);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (i1 == 2)
    {
      this.v.post(new RecordSoundPanel.9(this, paramString, paramRecorderParam));
      return;
    }
    if (i1 == 1)
    {
      ((AudioPanelAioHelper)this.a.q(128)).c(paramString, 3, paramRecorderParam);
      this.v.post(new RecordSoundPanel.10(this, paramString));
    }
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("RecordSoundPanel.onRecorderError() is called,path is:");
      paramString2.append(paramString1);
      QLog.d("AIOAudioPanel", 2, paramString2.toString());
    }
    ((AudioPanelAioHelper)this.a.q(128)).a(paramString1, false, false, paramRecorderParam);
    this.v.removeMessages(1);
    this.v.post(new RecordSoundPanel.7(this));
  }
  
  public void onRecorderNotReady(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onRecorderNotReady() is called,path is:");
      localStringBuilder.append(paramString);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
  }
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderPrepare() is called");
    }
    this.v.post(new RecordSoundPanel.2(this, paramString));
    ((AudioPanelAioHelper)this.a.q(128)).a(paramString, false, paramRecorderParam);
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    ((AudioPanelAioHelper)this.a.q(128)).a(paramString, paramArrayOfByte, paramInt1, paramInt2, paramDouble, paramRecorderParam);
    ((AudioPanelAioHelper)this.a.q(128)).b(paramString, (int)paramDouble, paramRecorderParam);
    if (this.n)
    {
      this.n = false;
      this.v.removeMessages(1);
    }
    if (this.t.a()) {
      this.v.post(new RecordSoundPanel.5(this, paramInt2, paramDouble));
    }
    this.s = paramDouble;
  }
  
  public int onRecorderStart()
  {
    this.s = 0.0D;
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderStart() is called");
    }
    this.v.post(new RecordSoundPanel.3(this));
    this.v.removeMessages(1);
    this.v.sendEmptyMessageDelayed(1, 2000L);
    this.n = true;
    PttInfoCollector.reportCostUntilPrepare(2);
    return 350;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      ReportController.b(this.b, "CliOper", "", "", "0X800484D", "0X800484D", 0, 0, "", "", "", "");
    }
    ((AudioPanelAioHelper)this.a.q(128)).h(paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return ((AudioPanelAioHelper)this.a.q(128)).g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel
 * JD-Core Version:    0.7.0.1
 */