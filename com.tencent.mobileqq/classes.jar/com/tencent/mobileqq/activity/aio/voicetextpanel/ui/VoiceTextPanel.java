package com.tencent.mobileqq.activity.aio.voicetextpanel.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextScrollerListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextUserOpListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextStateModel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextUIState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextBottomViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextMaskViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSlideViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextUpViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.utils.ReportUtils;
import com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView;
import com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class VoiceTextPanel
  extends BaseVoicetoTextView
{
  public boolean a = true;
  private AppRuntime b;
  private BaseAIOContext c;
  private BaseSessionInfo d;
  private boolean e = false;
  private VoiceTextStateModel f;
  private VoiceTextSttProcessController g;
  private VoiceTextSlideViewHelper h;
  private VoiceTextBottomViewHelper i;
  private VoiceTextUpViewHelper j;
  private VoiceTextMaskViewHelper k;
  private VoiceTextScrollerListener l;
  private VoiceTextPanel.VoiceTextUserOpListenerImp m;
  
  public VoiceTextPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public VoiceTextPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VoiceTextPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void f()
  {
    this.g.a();
    this.j.a(this);
    this.i.a(this);
    this.h.a(this);
  }
  
  private void g()
  {
    this.g.i();
    this.f.b();
    this.j.b();
    this.k.e();
    this.h.d();
    this.i.c();
    this.a = false;
  }
  
  private void h()
  {
    this.g.h();
    this.k.b();
    this.j.d();
    this.h.e();
    this.g.k();
    ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).restoreChatPieOtherFunction(this.c);
    ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).setIsInVoiceTxt(false);
    this.a = true;
  }
  
  public void a()
  {
    this.k.c();
    if (this.k.d() != 0) {
      this.g.g();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VoiceTextPanel onXContainerLayout left=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("top=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" right=");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" bottom=");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append(" isShowEidt=");
      localStringBuilder.append(paramBoolean);
      QLog.d("VoiceTextPanel", 2, localStringBuilder.toString());
    }
    if (!this.e)
    {
      int n = ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).getCustomTitleViewBottom(this.c);
      if (paramInt2 != 0) {
        this.h.a(paramInt4);
      } else {
        paramInt2 += n;
      }
      if ((paramInt2 > n) && (getTop() == n) && (!this.a)) {
        this.k.a(getRight() - getLeft(), this.k.a());
      }
      if ((getTop() == paramInt2) && (paramInt4 == getBottom()) && (paramBoolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextPanel", 2, "onXContainerLayout edit state need no layout");
        }
        return;
      }
      if ((this.h.f() > 0) && (this.h.f() + getTop() - paramInt2 < ScreenUtil.dip2px(2.0F)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextPanel", 2, "onXContainerLayout normal state need no layout");
        }
        return;
      }
      measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt4 - paramInt2, 1073741824));
      layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, BaseAIOContext paramBaseAIOContext, BaseSessionInfo paramBaseSessionInfo, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    this.b = paramAppRuntime;
    this.d = paramBaseSessionInfo;
    this.c = paramBaseAIOContext;
    this.l = new VoiceTextPanel.VoiceTextScrollerListenerImp(this);
    this.m = new VoiceTextPanel.VoiceTextUserOpListenerImp(this);
    this.f = new VoiceTextStateModel();
    this.g = new VoiceTextSttProcessController(this.f, paramAppRuntime, this);
    this.j = new VoiceTextUpViewHelper();
    this.i = new VoiceTextBottomViewHelper();
    this.h = new VoiceTextSlideViewHelper();
    this.k = new VoiceTextMaskViewHelper();
    f();
    this.k.a(paramViewGroup2, this, paramViewGroup1, this.c);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VoiceTextPanel onSoftInputShowing  isShow=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" isDrag=");
      localStringBuilder.append(this.e);
      QLog.d("VoiceTextPanel", 2, localStringBuilder.toString());
    }
    this.f.e().a(paramBoolean);
    if (paramBoolean)
    {
      ReportUtils.a("0X800A1DC", 0, 0);
      this.h.b();
      this.i.a();
    }
    else
    {
      if (!this.e) {
        this.i.b();
      }
      this.h.c();
    }
    if ((!this.e) && (!this.a)) {
      this.k.a(paramBoolean);
    }
  }
  
  public void b()
  {
    this.j.c();
  }
  
  public void c()
  {
    measure(View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec(getBottom() - getTop(), 1073741824));
    layout(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void d()
  {
    if ((this.f.e().a()) && (!this.a))
    {
      this.k.a(getRight() - getLeft(), this.k.a());
      return;
    }
    h();
  }
  
  public void e()
  {
    h();
  }
  
  public VoiceTextScrollerListener getVoiceTextScrollerListener()
  {
    return this.l;
  }
  
  public VoiceTextUserOpListener getVoiceTextUserOpListener()
  {
    return this.m;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VoiceTextPanel onLayout  left=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" top=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" right=");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" bottom=");
      localStringBuilder.append(paramInt4);
      QLog.d("VoiceTextPanel", 2, localStringBuilder.toString());
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)getLayoutParams();
    localLayoutParams.bottomMargin = paramInt2;
    setLayoutParams(localLayoutParams);
  }
  
  public void setParam(String paramString1, RecordParams.RecorderParam paramRecorderParam, int paramInt, String paramString2)
  {
    this.j.a(paramString1, paramRecorderParam, paramInt, this);
    this.g.a(this.c, this.d, paramRecorderParam, paramInt, paramString2, paramString1);
    this.h.a();
    g();
    ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).hideChatPieOtherFunction(this.c);
    this.g.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel
 * JD-Core Version:    0.7.0.1
 */