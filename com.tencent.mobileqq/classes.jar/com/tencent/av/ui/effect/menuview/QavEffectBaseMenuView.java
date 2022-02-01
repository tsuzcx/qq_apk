package com.tencent.av.ui.effect.menuview;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.av.VideoController;
import com.tencent.av.abtest.QavAvatar2dEntranceABTestUtils;
import com.tencent.av.abtest.QavEffectUIABTestUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.redtouch.AVRedTouchUtil;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.AVEffectReport;
import com.tencent.av.ui.QavMenuBaseView;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.effect.toolbar.newversion.Avatar2dToolbarV2;
import com.tencent.av.ui.effect.toolbar.oldversion.Avatar2dToolbar;
import com.tencent.av.ui.effect.toolbar.oldversion.FaceToolbar;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.VideoUtil;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class QavEffectBaseMenuView
  extends QavMenuBaseView
{
  private VideoObserver a;
  protected WeakReference<AVActivity> j = null;
  protected SparseArray<BaseToolbar> k = new SparseArray();
  protected int l = -1;
  protected boolean m = false;
  
  public QavEffectBaseMenuView(Context paramContext)
  {
    super(paramContext);
    if ((paramContext instanceof AVActivity)) {
      this.j = new WeakReference((AVActivity)paramContext);
    }
  }
  
  private void setEnableAllEffect(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  int a(int paramInt)
  {
    int i = 0;
    while (i < this.k.size())
    {
      BaseToolbar localBaseToolbar = (BaseToolbar)this.k.valueAt(i);
      if ((localBaseToolbar != null) && (localBaseToolbar.getEffectBtnId() != paramInt) && (localBaseToolbar.isAvailable())) {
        return localBaseToolbar.getEffectBtnId();
      }
      i += 1;
    }
    return -1;
  }
  
  protected int a(int paramInt1, int paramInt2)
  {
    BaseToolbar localBaseToolbar = (BaseToolbar)this.k.get(paramInt1);
    if ((localBaseToolbar != null) && (localBaseToolbar.isAvailable()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(this.g, 4, String.format("checkAbility 期望的按钮可用, effectBtnID[%s]", new Object[] { Integer.valueOf(paramInt1) }));
      }
      setEnableAllEffect(true);
      return paramInt1;
    }
    paramInt1 = a(paramInt2);
    if ((BaseToolbar)this.k.get(paramInt1) != null)
    {
      setEnableAllEffect(true);
      return paramInt1;
    }
    setEnableAllEffect(false);
    return paramInt1;
  }
  
  protected BaseToolbar a(boolean paramBoolean, Class<? extends BaseToolbar> paramClass)
  {
    paramClass = BaseToolbar.createToolbar(this.h, (AVActivity)this.j.get(), paramClass);
    paramClass.initBtn(getBtnContainer(), paramBoolean, getBtnClickListener());
    this.k.put(paramClass.getEffectBtnId(), paramClass);
    paramClass.updateEffectBtnStatus();
    return paramClass;
  }
  
  public void a(QavPanel paramQavPanel)
  {
    super.a(paramQavPanel);
    g();
  }
  
  void a(String paramString)
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyStatusChange, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]from ");
      localStringBuilder.append(paramString);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (this.h == null) {
      return;
    }
    this.h.a().post(new QavEffectBaseMenuView.1(this, l1));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (!QavEffectUIABTestUtils.b(this.h.getCurrentAccountUin()))
    {
      localObject = (Avatar2dToolbar)this.k.get(9);
      if (localObject != null) {
        ((Avatar2dToolbar)localObject).notifyOpenAvatar2DRspStatus(paramBoolean1, paramBoolean2);
      }
    }
    else
    {
      localObject = (Avatar2dToolbarV2)this.k.get(9);
      if (localObject != null) {
        ((Avatar2dToolbarV2)localObject).notifyOpenAvatar2DRspStatus(paramBoolean1, paramBoolean2);
      }
    }
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    d();
    int i = this.l;
    if (paramInt != -1) {
      i = paramInt;
    }
    i = a(i, -1);
    Object localObject = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("show, EffectBtnID 原[");
    localStringBuilder.append(this.l);
    localStringBuilder.append("], 期望[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], 最终[");
    localStringBuilder.append(i);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (!this.m)
    {
      QQToast.makeText((Context)this.j.get(), ((AVActivity)this.j.get()).getString(2131893094), 1).show();
      AVEffectReport.a();
      return isShown();
    }
    GestureMgr.e().c();
    AVEffectReport.a(this.h.b().k().aQ, VideoUtil.d(this.h));
    localObject = (BaseToolbar)this.k.get(i);
    if (localObject != null) {
      ((BaseToolbar)localObject).performClick();
    }
    localObject = this.h.b().k();
    if ((localObject != null) && (((SessionInfo)localObject).f()) && (((SessionInfo)localObject).g == 2)) {
      ReportController.b(null, "dc00898", "", "", "0X8008AD5", "0X8008AD5", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  protected boolean a(long paramLong, int paramInt, boolean paramBoolean)
  {
    BaseToolbar.keepInToolbar(this.h, paramLong);
    BaseToolbar localBaseToolbar = (BaseToolbar)this.k.get(paramInt);
    int i1 = this.l;
    int n = 1;
    boolean bool;
    if (localBaseToolbar != null) {
      bool = localBaseToolbar.tryShowToolbar(paramLong, getToolbarContainer(), i1, paramBoolean);
    } else {
      bool = true;
    }
    Object localObject = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryShowToolbar, SelectedId[");
    localStringBuilder.append(i1);
    localStringBuilder.append("->");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], bFromPerformClick[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], showToolbar[");
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (bool)
    {
      int i = n;
      if (i1 != paramInt)
      {
        localObject = (BaseToolbar)this.k.get(i1);
        setCurSelectedId(paramInt, "tryShowToolbar");
        if ((localObject != null) && (this.l != i1)) {
          ((BaseToolbar)localObject).hideToolbar(paramLong);
        }
        ((AVActivity)this.j.get()).h(paramLong);
        i = n;
      }
      while (i <= 7)
      {
        localObject = (BaseToolbar)this.k.get(i);
        if ((localObject != null) && (i != paramInt) && (((BaseToolbar)localObject).isAvailable()))
        {
          ((BaseToolbar)localObject).hideToolbar(paramLong);
          if (QLog.isColorLevel())
          {
            localObject = this.g;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("tryShowToolbar, check fail, id[");
            localStringBuilder.append(i);
            localStringBuilder.append("]");
            QLog.i((String)localObject, 2, localStringBuilder.toString());
          }
        }
        i += 1;
      }
    }
    if (paramInt == 1) {
      if (VideoUtil.b(this.h)) {
        MultiVideoRichActionReportCollection.a("0X8007F27");
      } else if (VideoUtil.c(this.h)) {
        MultiVideoRichActionReportCollection.a("0X8007F2D");
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(this.g, 4, String.format("按钮点击失败, lastSelectedId[%s], newSelectId[%s]", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt) }));
    }
    if (localBaseToolbar != null)
    {
      localBaseToolbar.onButtonClick(i1, paramBoolean, bool);
      if (bool) {
        if ((localBaseToolbar instanceof FaceToolbar))
        {
          if (localBaseToolbar.mEffectBtnRedTouch != null)
          {
            AVRedTouchUtil.a(this.h, localBaseToolbar.mEffectBtnRedTouch, 3);
            localBaseToolbar.mEffectBtnRedTouch = null;
            return bool;
          }
        }
        else if (((localBaseToolbar instanceof Avatar2dToolbarV2)) && (localBaseToolbar.mEffectBtnRedTouch != null))
        {
          AVRedTouchUtil.a(this.h, localBaseToolbar.mEffectBtnRedTouch, 12);
          localBaseToolbar.mEffectBtnRedTouch = null;
        }
      }
    }
    return bool;
  }
  
  public void b(int paramInt)
  {
    long l1 = AudioHelper.c();
    Object localObject = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exitSubEffectPanel, ExitID[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mCurSelectedId[");
    localStringBuilder.append(this.l);
    localStringBuilder.append("], isShown[");
    localStringBuilder.append(isShown());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (this.l == paramInt)
    {
      int i = a(-1, paramInt);
      if (isShown())
      {
        if (i > paramInt)
        {
          c(l1);
          return;
        }
        b(i, paramInt);
        return;
      }
      localObject = (BaseToolbar)this.k.get(this.l);
      if (localObject != null) {
        ((BaseToolbar)localObject).hideToolbar(l1);
      }
      setCurSelectedId(-1, "exitSubEffectPanel");
    }
  }
  
  void b(int paramInt, boolean paramBoolean)
  {
    BaseToolbar localBaseToolbar = (BaseToolbar)this.k.get(paramInt);
    if (localBaseToolbar != null) {
      localBaseToolbar.setEffectBtnVisibility(paramBoolean);
    }
  }
  
  public void b(long paramLong)
  {
    h();
    d(paramLong);
    super.b(paramLong);
  }
  
  protected boolean b(int paramInt1, int paramInt2)
  {
    int i = a(paramInt1, paramInt2);
    Object localObject = (BaseToolbar)this.k.get(i);
    boolean bool;
    if (localObject != null)
    {
      ((BaseToolbar)localObject).performClick();
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reSelectBtn, effectBtnID[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], ignoreID[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], selectid[");
      localStringBuilder.append(i);
      localStringBuilder.append("], ret[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void c()
  {
    long l1 = AudioHelper.c();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exitSubEffectPanel, cur[");
      localStringBuilder.append(this.l);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    int i = this.l;
    if (i != -1)
    {
      localObject = (BaseToolbar)this.k.get(i);
      if (localObject != null) {
        ((BaseToolbar)localObject).hideToolbar(l1);
      }
      setCurSelectedId(-1, "exitSubEffectPanel");
    }
  }
  
  protected abstract void c(long paramLong);
  
  public void c(long paramLong, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBtnStatus, reselect[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], mCurSelectedId[");
      localStringBuilder.append(this.l);
      localStringBuilder.append("], isShown[");
      localStringBuilder.append(isShown());
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    int i = 0;
    while (i < this.k.size())
    {
      ((BaseToolbar)this.k.valueAt(i)).updateEffectBtnStatus();
      i += 1;
    }
    if (paramBoolean)
    {
      localObject = (BaseToolbar)this.k.get(this.l);
      if (localObject != null) {
        ((BaseToolbar)localObject).hideToolbar(paramLong);
      }
      setCurSelectedId(-1, "updateBtnStatus");
    }
    if (isShown()) {
      b(this.l, -1);
    }
  }
  
  public boolean c(int paramInt)
  {
    return (this.l == paramInt) && (isShown());
  }
  
  public void d()
  {
    Object localObject = this.h.b().k();
    boolean bool1 = ((SessionInfo)localObject).H;
    boolean bool2 = true;
    if ((bool1) && ((localObject == null) || (!((SessionInfo)localObject).cx)))
    {
      boolean bool3 = EffectsRenderController.c();
      localObject = (BaseToolbar)this.k.get(1);
      if (localObject != null) {
        ((BaseToolbar)localObject).updateEffectBtnStatus();
      }
      b(5, true);
      b(1, bool3);
      b(4, bool3);
      b(8, bool3);
      boolean bool4 = EffectZimuManager.a(this.h);
      boolean bool5 = VideoUtil.a(this.h, true);
      if ((bool5) && (bool3)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      b(3, bool1);
      if ((bool5) && (bool3)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      b(2, bool1);
      if ((bool4) && (bool5) && (bool3)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      b(6, bool1);
      if ((bool5) && (bool3)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      b(7, bool1);
      if ((bool5) && (f())) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      b(9, bool1);
      if (QLog.isDevelopLevel())
      {
        localObject = this.g;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtnUi, enableAE[");
        localStringBuilder.append(bool3);
        localStringBuilder.append("], isShowZimu[");
        localStringBuilder.append(bool4);
        localStringBuilder.append("], visibility[");
        localStringBuilder.append(bool5);
        localStringBuilder.append("]");
        QLog.i((String)localObject, 4, localStringBuilder.toString());
      }
    }
    else
    {
      b(5, true);
      b(9, f());
      b(3, false);
      b(2, false);
      b(6, false);
      b(7, false);
      b(1, false);
      b(4, false);
      b(8, false);
    }
  }
  
  void d(long paramLong)
  {
    int i = 0;
    while (i < this.k.size())
    {
      ((BaseToolbar)this.k.valueAt(i)).destroy(paramLong, this.h);
      i += 1;
    }
    this.k.clear();
  }
  
  public boolean e()
  {
    if (!((AVActivity)this.j.get()).K.ab()) {
      return false;
    }
    c(-1012L);
    return true;
  }
  
  public boolean f()
  {
    if (VideoUtil.a(this.h))
    {
      if (!QavAvatar2dEntranceABTestUtils.a(this.h.getCurrentAccountUin())) {
        return false;
      }
      if (!EffectsRenderController.c()) {
        return false;
      }
      boolean bool1 = EffectsRenderController.e();
      boolean bool2 = AEFilterSupport.b();
      if (QLog.isDevelopLevel()) {
        QLog.d(this.g, 4, String.format("变身按钮是否可用, bSuc[%s][%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      return bool1 & bool2;
    }
    return false;
  }
  
  public void g()
  {
    this.a = new QavEffectBaseMenuView.2(this);
    this.h.a(this.a);
  }
  
  protected abstract View.OnClickListener getBtnClickListener();
  
  protected abstract ViewGroup getBtnContainer();
  
  public int getCurSelectedId()
  {
    return this.l;
  }
  
  protected abstract ViewGroup getToolbarContainer();
  
  public void h()
  {
    this.h.b(this.a);
  }
  
  public boolean isShown()
  {
    return getVisibility() == 0;
  }
  
  public void setCurSelectedId(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCurSelectedId, [");
      localStringBuilder.append(this.l);
      localStringBuilder.append("--->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (this.l != paramInt) {
      this.l = paramInt;
    }
  }
  
  public abstract void setRootBackground(Boolean paramBoolean, int paramInt1, int paramInt2);
  
  public void setSelectedBtn(int paramInt)
  {
    if (paramInt == this.l) {
      return;
    }
    b(paramInt, -1);
    setCurSelectedId(paramInt, "setSelectedBtn");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView
 * JD-Core Version:    0.7.0.1
 */