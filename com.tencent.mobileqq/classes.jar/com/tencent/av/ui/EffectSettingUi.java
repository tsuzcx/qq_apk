package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.doodle.api.IDoodleApi;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.av.redtouch.AVRedTouchUtil;
import com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.effect.toolbar.oldversion.Avatar2dToolbar;
import com.tencent.av.ui.effect.toolbar.oldversion.BeautyToolbar;
import com.tencent.av.ui.effect.toolbar.oldversion.EffectToolbar;
import com.tencent.av.ui.effect.toolbar.oldversion.FaceToolbar;
import com.tencent.av.ui.effect.toolbar.oldversion.VoiceChangeToolbar;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class EffectSettingUi
  extends QavEffectBaseMenuView
{
  RelativeLayout a = null;
  LinearLayout b = null;
  EffectSettingBtn c;
  RelativeLayout d;
  RelativeLayout e;
  Runnable f = null;
  private View.OnClickListener n = new EffectSettingUi.1(this);
  
  public EffectSettingUi(Context paramContext)
  {
    super(paramContext);
    paramContext = new StringBuilder();
    paramContext.append("EffectSettingUi");
    paramContext.append(AudioHelper.c());
    this.g = paramContext.toString();
    setId(2131435282);
  }
  
  private void e(long paramLong)
  {
    Object localObject = this.h;
    boolean bool1 = true;
    boolean bool2 = VideoUtil.a((VideoAppInterface)localObject, true);
    boolean bool3 = PtuResChecker.a().a(this.h);
    localObject = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initBtn:");
    localStringBuilder.append(bool2);
    localStringBuilder.append("|");
    localStringBuilder.append(bool3);
    AVLog.printColorLog((String)localObject, localStringBuilder.toString());
    boolean bool4 = EffectZimuManager.a(this.h);
    boolean bool5 = f();
    a(bool3, EffectToolbar.class);
    a(bool5, Avatar2dToolbar.class);
    a(bool2, FaceToolbar.class);
    a(bool2, ((IDoodleApi)QRoute.api(IDoodleApi.class)).getDoodleToolbarClass());
    a(true, BeautyToolbar.class);
    a(true, VoiceChangeToolbar.class);
    if ((!bool2) || (!bool4)) {
      bool1 = false;
    }
    a(bool1, ZimuToolbar.class);
    int i = 0;
    while (i < this.k.size())
    {
      if ((this.k.valueAt(i) instanceof FaceToolbar))
      {
        if (((BaseToolbar)this.k.valueAt(i)).mEffectBtnRedTouch != null) {
          break;
        }
        ((BaseToolbar)this.k.valueAt(i)).mEffectBtnRedTouch = AVRedTouchUtil.a(this.h, ((BaseToolbar)this.k.valueAt(i)).mEffectBtn, 3);
        if (((BaseToolbar)this.k.valueAt(i)).mEffectBtnRedTouch == null) {
          break;
        }
        int j = (int)UITools.b(getContext(), ((BaseToolbar)this.k.valueAt(i)).mEffectBtn.getPaddingRight());
        int k = (int)UITools.b(getContext(), ((BaseToolbar)this.k.valueAt(i)).mEffectBtn.getPaddingTop());
        ((BaseToolbar)this.k.valueAt(i)).mEffectBtnRedTouch.a(0, j, k, 0).a();
        break;
      }
      i += 1;
    }
    localObject = this.h.b();
    if (localObject != null) {
      setSelectedBtn(((VideoController)localObject).k().cb);
    }
    a();
  }
  
  private void i()
  {
    HorizontalScrollView localHorizontalScrollView = (HorizontalScrollView)this.a.findViewById(2131435152);
    ViewTreeObserver localViewTreeObserver = localHorizontalScrollView.getViewTreeObserver();
    localViewTreeObserver.addOnGlobalLayoutListener(new EffectSettingUi.2(this, localViewTreeObserver, localHorizontalScrollView));
  }
  
  private void j()
  {
    Button localButton = (Button)this.a.findViewById(2131440997);
    localButton.setOnClickListener(new EffectSettingUi.3(this));
    if (AudioHelper.a(0) == 1) {
      localButton.setBackgroundColor(Color.argb(100, 0, 0, 0));
    }
  }
  
  void a()
  {
    if (this.j == null) {
      return;
    }
    Object localObject2 = (AVActivity)this.j.get();
    if (localObject2 == null) {
      return;
    }
    if (this.b == null) {
      return;
    }
    Object localObject3 = ((AVActivity)localObject2).getResources();
    Object localObject1 = (HorizontalScrollView)this.a.findViewById(2131435152);
    if (((HorizontalScrollView)localObject1).getTag() == null)
    {
      QLog.w(this.g, 1, "adjustScrollView, 等待onGlobalLayout");
      return;
    }
    int k = ((AVActivity)localObject2).getWindow().getDecorView().getWidth() - AIOUtils.b(60.0F, (Resources)localObject3);
    if (k == 0)
    {
      QLog.w(this.g, 1, "adjustScrollView, window没有高度");
      return;
    }
    int m = this.b.getMeasuredWidth();
    if (m < k)
    {
      localObject1 = this.g;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("adjustScrollView, 无需处理2, winShowW[");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append("], btnsW[");
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    int i1 = (int)((Resources)localObject3).getDimension(2131298429);
    int i2 = m - k;
    int i4 = i1 / 2;
    if (i2 < i4)
    {
      localObject1 = this.g;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("adjustScrollView, 无需处理3, hideW[");
      ((StringBuilder)localObject2).append(i2);
      ((StringBuilder)localObject2).append("], halfBtnW[");
      ((StringBuilder)localObject2).append(i4);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    int i3 = i2 % i1;
    int i5 = i2 / i1;
    int j = i4 - i3;
    int i = j;
    if (i5 > 0) {
      if (i3 < i4) {
        i = j;
      } else {
        i = i4 + i1 - i3;
      }
    }
    localObject3 = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adjustScrollView, winW[");
    localStringBuilder.append(((AVActivity)localObject2).getWindow().getDecorView().getWidth());
    localStringBuilder.append("], winShowW[");
    localStringBuilder.append(k);
    localStringBuilder.append("], btnsW[");
    localStringBuilder.append(m);
    localStringBuilder.append("], qav_effect_btn_width[");
    localStringBuilder.append(i1);
    localStringBuilder.append("], hideW[");
    localStringBuilder.append(i2);
    localStringBuilder.append("], oneHideW[");
    localStringBuilder.append(i3);
    localStringBuilder.append("], move[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    QLog.w((String)localObject3, 1, localStringBuilder.toString());
    localObject2 = (RelativeLayout.LayoutParams)((HorizontalScrollView)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, 0, 0, 0);
    ((HorizontalScrollView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      AVEffectReport.b((Context)this.j.get(), this.h.b().k().aQ, this.h.b().k().g, VideoUtil.d(this.h), paramBoolean);
      return;
    }
    if (paramInt == 2)
    {
      AVEffectReport.a(this.h, VideoUtil.d(this.h), paramBoolean);
      EffectSettingBtn localEffectSettingBtn = this.c;
      if (localEffectSettingBtn != null) {
        localEffectSettingBtn.a();
      }
    }
    else
    {
      if (paramInt == 4)
      {
        AVEffectReport.a((Context)this.j.get(), this.h.b().k().aQ, this.h.b().k().g, VideoUtil.d(this.h), paramBoolean);
        return;
      }
      if (paramInt == 3)
      {
        AVEffectReport.a(VideoUtil.d(this.h), paramBoolean);
        return;
      }
      if (paramInt == 5) {
        DataReport.f();
      }
    }
  }
  
  void a(long paramLong)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initUI, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    setGravity(80);
    this.a = ((RelativeLayout)((AVActivity)this.j.get()).getLayoutInflater().inflate(2131625726, this).findViewById(2131441057));
    this.a.setOnTouchListener(new EffectSettingUi.4(this));
    Object localObject = (ViewGroup)getParent();
    this.e = ((RelativeLayout)this.a.findViewById(2131441311));
    this.d = ((RelativeLayout)findViewById(2131441061));
    this.b = ((LinearLayout)this.d.findViewById(2131437249));
    this.h.a(0, null);
    this.h.a(1, null);
    this.h.a(2, null);
    i();
    e(paramLong);
    j();
    if (AudioHelper.a(0) == 1)
    {
      setBackgroundColor(-256);
      this.a.setBackgroundColor(-65281);
      this.e.setBackgroundColor(-16711936);
      ((ViewGroup)localObject).setBackgroundColor(-1);
      findViewById(2131441061).setBackgroundColor(-7829368);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    super.a(paramLong, paramBoolean);
  }
  
  public void a(QavPanel paramQavPanel)
  {
    super.a(paramQavPanel);
    a(-1013L);
  }
  
  public void b(long paramLong)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((EffectSettingBtn)localObject).c();
      this.c = null;
    }
    if (this.f != null)
    {
      this.h.a().removeCallbacks(this.f);
      this.f = null;
    }
    URLDrawable.clearMemoryCache();
    if (!((AVActivity)this.j.get()).y)
    {
      localObject = ((AVActivity)this.j.get()).I;
      if ((localObject != null) && (((VideoController)localObject).k().i != 0) && (((VideoController)localObject).k().i != 7)) {
        ((VideoController)localObject).k().cb = this.l;
      }
    }
    this.j = null;
    super.b(paramLong);
  }
  
  protected void c(long paramLong)
  {
    EffectSettingBtn localEffectSettingBtn = this.c;
    if (localEffectSettingBtn != null) {
      localEffectSettingBtn.b();
    }
    this.h.a(new Object[] { Integer.valueOf(6105), Integer.valueOf(100), Long.valueOf(paramLong) });
  }
  
  protected View.OnClickListener getBtnClickListener()
  {
    return this.n;
  }
  
  public ViewGroup getBtnContainer()
  {
    return this.b;
  }
  
  Resources getRes()
  {
    return ((AVActivity)this.j.get()).getResources();
  }
  
  protected ViewGroup getToolbarContainer()
  {
    return this.e;
  }
  
  public void setRootBackground(Boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.a != null)
    {
      if (paramBoolean.booleanValue())
      {
        this.a.setBackgroundColor(paramInt1);
        return;
      }
      this.a.setBackgroundResource(paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingUi
 * JD-Core Version:    0.7.0.1
 */