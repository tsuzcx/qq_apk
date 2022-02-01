package com.tencent.av.ui.effect.menuview;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.av.redtouch.AVRedTouchUtil;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.effect.toolbar.newversion.Avatar2dToolbarV2;
import com.tencent.av.ui.effect.toolbar.newversion.FilterToolbar;
import com.tencent.av.ui.effect.toolbar.newversion.InteractiveToolbar;
import com.tencent.av.ui.effect.toolbar.newversion.PendantToolbar;
import com.tencent.av.ui.effect.toolbar.newversion.SubtitlesToolbar;
import com.tencent.av.ui.effect.toolbar.newversion.VoiceChangeToolbar;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class QavEffectMenuView
  extends QavEffectBaseMenuView
{
  RelativeLayout a;
  RelativeLayout b;
  RelativeLayout c;
  LinearLayout d;
  private WeakReference<AVActivity> e = null;
  private final View.OnClickListener f = new QavEffectMenuView.2(this);
  
  public QavEffectMenuView(Context paramContext)
  {
    super(paramContext);
    if ((paramContext instanceof AVActivity)) {
      this.e = new WeakReference((AVActivity)paramContext);
    }
  }
  
  private void a()
  {
    this.h.a(0, null);
    this.h.a(1, null);
    this.h.a(2, null);
  }
  
  private void e(long paramLong)
  {
    Object localObject = this.h;
    boolean bool1 = true;
    boolean bool2 = VideoUtil.a((VideoAppInterface)localObject, true);
    boolean bool3 = PtuResChecker.a().a(this.h);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initBtn:");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(bool3);
    AVLog.printColorLog("QavEffectMenuView", ((StringBuilder)localObject).toString());
    boolean bool4 = EffectZimuManager.a(this.h);
    boolean bool5 = f();
    a(bool3, PendantToolbar.class);
    a(bool5, Avatar2dToolbarV2.class);
    a(bool2, InteractiveToolbar.class);
    a(true, FilterToolbar.class);
    a(true, VoiceChangeToolbar.class);
    if ((!bool2) || (!bool4)) {
      bool1 = false;
    }
    a(bool1, SubtitlesToolbar.class);
    int i = 0;
    while (i < this.k.size())
    {
      if ((this.k.valueAt(i) instanceof Avatar2dToolbarV2))
      {
        if (((BaseToolbar)this.k.valueAt(i)).mEffectBtnRedTouch != null) {
          break;
        }
        ((BaseToolbar)this.k.valueAt(i)).mEffectBtnRedTouch = AVRedTouchUtil.a(this.h, ((BaseToolbar)this.k.valueAt(i)).mEffectBtn, 12);
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
  }
  
  private void i() {}
  
  void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initUi, seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.i("QavEffectMenuView", 2, ((StringBuilder)localObject).toString());
    }
    setGravity(80);
    Object localObject = ((AVActivity)this.e.get()).getLayoutInflater().inflate(2131625725, this);
    this.a = ((RelativeLayout)((View)localObject).findViewById(2131444940));
    this.a.setOnTouchListener(new QavEffectMenuView.1(this));
    this.b = ((RelativeLayout)((View)localObject).findViewById(2131444941));
    this.c = ((RelativeLayout)((View)localObject).findViewById(2131444939));
    this.d = ((LinearLayout)((View)localObject).findViewById(2131437445));
    a();
    i();
    e(paramLong);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    super.a(paramLong, paramBoolean);
  }
  
  public void a(QavPanel paramQavPanel)
  {
    super.a(paramQavPanel);
    a(-1053L);
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(long paramLong)
  {
    
    if (!((AVActivity)this.e.get()).y)
    {
      VideoController localVideoController = ((AVActivity)this.e.get()).I;
      if ((localVideoController != null) && (localVideoController.k().i != 0) && (localVideoController.k().i != 7)) {
        localVideoController.k().cb = this.l;
      }
    }
    this.e = null;
    super.b(paramLong);
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    super.b(paramLong, paramBoolean);
  }
  
  protected void c(long paramLong)
  {
    this.h.a(new Object[] { Integer.valueOf(6105), Integer.valueOf(100), Long.valueOf(paramLong) });
  }
  
  protected View.OnClickListener getBtnClickListener()
  {
    return this.f;
  }
  
  protected ViewGroup getBtnContainer()
  {
    return this.d;
  }
  
  protected ViewGroup getToolbarContainer()
  {
    return this.b;
  }
  
  public void setRootBackground(Boolean paramBoolean, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.menuview.QavEffectMenuView
 * JD-Core Version:    0.7.0.1
 */