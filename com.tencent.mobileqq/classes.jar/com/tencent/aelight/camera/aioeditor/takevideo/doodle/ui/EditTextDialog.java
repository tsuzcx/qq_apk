package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextBuilder;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.TextMap;
import com.tencent.aelight.camera.aioeditor.capture.text.EditTextPreView;
import com.tencent.aelight.camera.aioeditor.capture.text.NormalTextItem;
import com.tencent.aelight.camera.aioeditor.capture.view.PressScaleTextView;
import com.tencent.aelight.camera.aioeditor.takevideo.AEColorBarManage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.model.TextInfo;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel.EditTextPanelListener;
import com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.strategy.EditDialogStrokeStrategy;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class EditTextDialog
  extends Dialog
  implements Handler.Callback, EditTextPanel.EditTextPanelListener, XPanelContainer.PanelCallback
{
  public String A = "";
  public int B;
  public int C;
  private int D = 580;
  private float E;
  private float F;
  private int G = 0;
  private int H = NormalTextItem.b;
  private QQToast I;
  private int J = 0;
  private boolean K;
  private int L;
  private boolean M;
  private boolean N = false;
  private boolean O = false;
  private PressScaleTextView P;
  private View Q;
  private boolean R = false;
  private InputFilter[] S = { new EditTextDialog.LengthInputFilter(20) };
  private InputFilter[] T = new InputFilter[0];
  private View.OnClickListener U = new EditTextDialog.9(this);
  public ViewGroup a;
  public FitSystemWindowsRelativeLayout b;
  public XPanelContainer c;
  public EditText d;
  public View e;
  public AEHorizontalSelectColorLayout f;
  public EditTextDialog.EditTextDialogEventListener g;
  public ViewTreeObserver.OnGlobalLayoutListener h;
  public int i;
  public int j = -1;
  public String k;
  public int l = EditDialogStrokeStrategy.a(false);
  public int m;
  public TextInfo n = new TextInfo();
  protected final MqqHandler o = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  EditTextPanel p;
  public int q = XPanelContainer.a;
  public int r = -1;
  Context s;
  EditTextPreView t;
  DynamicTextBuilder u;
  public DynamicTextItem.TextMap v = null;
  public int w;
  public RelativeLayout x = null;
  public DynamicTextItem y;
  public DynamicTextItem z;
  
  public EditTextDialog(Context paramContext)
  {
    super(paramContext, 2131952047);
    this.s = paramContext;
    paramContext = this.s;
    if ((paramContext instanceof Activity)) {
      this.L = ((Activity)paramContext).getIntent().getIntExtra("capture_operation_in", -1);
    }
  }
  
  private void e()
  {
    this.a = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131624735, null));
    this.h = new EditTextDialog.LayoutChangeListener(this, null);
    this.a.getViewTreeObserver().addOnGlobalLayoutListener(new EditTextDialog.InitialLayoutListener(this, null));
    this.b = ((FitSystemWindowsRelativeLayout)this.a.findViewById(2131445162));
    this.b.setFitsSystemWindows(true);
    this.b.setOnTouchListener(new EditTextDialog.1(this));
    this.c = ((XPanelContainer)this.a.findViewById(2131445137));
    this.d = ((EditText)this.a.findViewById(2131447169));
    this.d.setHighlightColor(Color.parseColor("#cceae8"));
    this.e = this.a.findViewById(2131447159);
    this.p = ((EditTextPanel)this.a.findViewById(2131432375).findViewById(2131439801));
    this.p.setPanelListener(this);
    this.p.a(this.d);
    this.p.setOpIn(this.L);
    this.p.setEditPhoto(this.R);
    this.P = ((PressScaleTextView)this.a.findViewById(2131447130));
    this.Q = this.a.findViewById(2131447131);
    if (this.O)
    {
      this.P.setVisibility(0);
      this.Q.setVisibility(0);
      this.P.setOnClickListener(new EditTextDialog.2(this));
      this.Q.setOnClickListener(new EditTextDialog.3(this));
    }
    this.t = ((EditTextPreView)this.a.findViewById(2131447172));
    this.t.setOnClickListener(new EditTextDialog.4(this));
    this.d.setFocusableInTouchMode(true);
    this.d.setFocusable(true);
    this.d.setOnFocusChangeListener(new EditTextDialog.5(this));
    this.c.a(this.d);
    this.d.addTextChangedListener(new EditTextDialog.6(this));
    this.d.setOnTouchListener(new EditTextDialog.7(this));
    this.f = ((AEHorizontalSelectColorLayout)this.a.findViewById(2131439247));
    this.f.setColorSelectListener(new EditTextDialog.8(this));
  }
  
  public static boolean e(int paramInt)
  {
    return (paramInt != 0) && (paramInt != 32) && (paramInt != 31) && (paramInt != 30) && (paramInt != 33);
  }
  
  private void f(int paramInt)
  {
    Iterator localIterator = AEColorBarManage.a.iterator();
    int i1 = 0;
    while ((localIterator.hasNext()) && (paramInt != ((Integer)localIterator.next()).intValue())) {
      i1 += 1;
    }
    this.f.a(AEColorBarManage.a, i1, false);
  }
  
  private boolean f()
  {
    boolean bool2 = Build.MANUFACTURER.equalsIgnoreCase("HUAWEI");
    boolean bool1 = false;
    int i1;
    if ((!bool2) && (!Build.MANUFACTURER.equalsIgnoreCase("vivo"))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    int i2;
    if ((!Build.MODEL.equalsIgnoreCase("RedMI NOTE 8")) && (!Build.MODEL.equalsIgnoreCase("OPPO a5")) && (!Build.MODEL.equalsIgnoreCase("M2002J9E")) && (!Build.MODEL.equalsIgnoreCase("Redmi 7")) && (!Build.MODEL.equalsIgnoreCase("PCNM00")) && (!Build.MODEL.equalsIgnoreCase("PCHM10"))) {
      i2 = 0;
    } else {
      i2 = 1;
    }
    if ((i1 != 0) || (i2 != 0)) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void g()
  {
    Object localObject = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    if (this.K)
    {
      localLayoutParams.height = com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil.b(getContext());
      if (LiuHaiUtils.g())
      {
        int[] arrayOfInt = LiuHaiUtils.e(this.s);
        if ((arrayOfInt.length == 2) && (arrayOfInt[0] > 0) && (arrayOfInt[1] > 0))
        {
          localLayoutParams.height = arrayOfInt[1];
          int i1;
          if ((f()) && (com.tencent.mobileqq.mini.util.DisplayUtil.checkNavigationBarShow(this.s))) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          boolean bool;
          if ((i1 == 0) && (!com.tencent.mobileqq.mini.util.DisplayUtil.isFlymeOS7NavBarShow())) {
            bool = false;
          } else {
            bool = true;
          }
          QLog.d("EditTextDialog", 1, new Object[] { "isNavigationBarExist, ", Boolean.valueOf(bool), "  Build.MODEL: ", Build.MODEL });
          if (bool) {
            localLayoutParams.height -= com.tencent.mobileqq.mini.util.DisplayUtil.getNavigationBarHeight(this.s);
          }
        }
      }
    }
    else
    {
      localLayoutParams.height = -1;
    }
    localLayoutParams.flags |= 0x20;
    localLayoutParams.gravity = 80;
    ((Window)localObject).setAttributes(localLayoutParams);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getWindow().addFlags(67108864);
      localObject = new SystemBarCompact(this, true, this.s.getResources().getColor(17170445));
      ((SystemBarCompact)localObject).setStatusBarDrawable(null);
      ((SystemBarCompact)localObject).init();
    }
    setCanceledOnTouchOutside(false);
  }
  
  private void g(int paramInt)
  {
    this.J = paramInt;
    paramInt = this.J;
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      localObject = this.y;
      if (localObject != null)
      {
        ((DynamicTextItem)localObject).p();
        localObject = this.t;
        if (localObject != null) {
          ((EditTextPreView)localObject).invalidate();
        }
      }
    }
    else
    {
      localObject = this.y;
      if (localObject != null)
      {
        paramInt = ((DynamicTextItem)localObject).g();
        this.y.o();
        this.y.a(paramInt, true);
        localObject = this.t;
        if (localObject != null) {
          ((EditTextPreView)localObject).invalidate();
        }
      }
    }
  }
  
  private void h()
  {
    Object localObject1 = this.y;
    if (localObject1 != null)
    {
      if (this.t == null) {
        return;
      }
      Object localObject2 = ((DynamicTextItem)localObject1).b(this.G);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "";
      }
      localObject2 = this.t;
      if (localObject2 != null)
      {
        ((EditTextPreView)localObject2).setPreViewDrawer(this.y);
        this.t.setText(this.G, (String)localObject1);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("text size changednow text size:");
        ((StringBuilder)localObject1).append(this.H);
        QLog.d("EditTextDialog", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  protected int a()
  {
    int i1 = this.d.getTop();
    int i2 = b();
    TextPaint localTextPaint = this.d.getPaint();
    return (int)(i1 + i2 + this.d.getBaseline() + localTextPaint.ascent());
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPanelChanged oldPanel = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("newPanel=");
      localStringBuilder.append(paramInt2);
      QLog.d("EditTextDialog", 2, localStringBuilder.toString());
    }
    this.o.obtainMessage(0, paramInt1, paramInt2).sendToTarget();
  }
  
  public void a(DynamicTextBuilder paramDynamicTextBuilder)
  {
    this.u = paramDynamicTextBuilder;
  }
  
  public void a(DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPanelItemClick position = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("EditTextDialog", 2, ((StringBuilder)localObject).toString());
    }
    if (paramDynamicTextConfigBean != null)
    {
      localObject = AEBaseDataReporter.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramDynamicTextConfigBean.text_id);
      localStringBuilder.append("");
      ((AEBaseDataReporter)localObject).s(localStringBuilder.toString());
    }
    Object localObject = this.y;
    if ((localObject != null) && (this.d != null) && (paramDynamicTextConfigBean != null))
    {
      ((DynamicTextItem)localObject).g();
      localObject = this.y.j();
      if (paramDynamicTextConfigBean.text_id != this.y.k())
      {
        localObject = DynamicTextBuilder.a(DynamicTextBuilder.a(paramDynamicTextConfigBean.text_id), this.y);
        this.o.post(new EditTextDialog.11(this));
      }
      paramDynamicTextConfigBean = this.u.a(paramDynamicTextConfigBean.text_id, (List)localObject);
      paramDynamicTextConfigBean.g(paramDynamicTextConfigBean.t());
      this.H = paramDynamicTextConfigBean.t();
      paramDynamicTextConfigBean.m = this.y.m;
      paramDynamicTextConfigBean.e(0);
      paramDynamicTextConfigBean.a(0, paramDynamicTextConfigBean.b(0));
      if ((paramDynamicTextConfigBean instanceof NormalTextItem))
      {
        localObject = (NormalTextItem)paramDynamicTextConfigBean;
        ((NormalTextItem)localObject).a(this.l);
        this.f.setVisibility(0);
        f(((NormalTextItem)localObject).u());
      }
      else
      {
        this.f.setVisibility(8);
      }
      this.y.o();
      if (!this.y.equals(paramDynamicTextConfigBean)) {
        this.y = paramDynamicTextConfigBean;
      }
      this.t.setPreViewDrawer(this.y);
      this.y.a(-1, this.t, true, 3000, 500, new EditTextDialog.12(this));
      this.d.setFilters(this.T);
      this.d.setText(this.y.n());
      if (e(this.y.k())) {
        if (this.y.f() == null) {
          this.d.setFilters(this.S);
        } else {
          this.d.setFilters(new InputFilter[] { this.y.f() });
        }
      }
      paramDynamicTextConfigBean = this.d;
      paramDynamicTextConfigBean.setSelection(paramDynamicTextConfigBean.length());
      if (this.y.n().equals(DynamicTextBuilder.a(this.y.k(), this.y.g())))
      {
        this.d.setSelectAllOnFocus(true);
        if (this.d.hasFocus()) {
          this.d.selectAll();
        }
      }
      else
      {
        this.d.setOnClickListener(null);
        this.d.setSelectAllOnFocus(false);
        this.d.requestFocus();
      }
      this.r = paramInt;
    }
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    this.G = paramInt;
    this.y = paramDynamicTextItem;
    this.z = paramDynamicTextItem;
    Object localObject1 = this.y;
    if (localObject1 == null) {
      return;
    }
    this.H = ((DynamicTextItem)localObject1).t();
    this.C = this.H;
    this.A = this.y.b(this.G);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("normalTextSize");
      ((StringBuilder)localObject1).append(this.H);
      QLog.d("EditTextDialog", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.y.b(paramInt);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "";
    }
    localObject2 = this.t;
    if (localObject2 != null)
    {
      ((EditTextPreView)localObject2).setPreViewDrawer(this.y);
      this.t.setText(paramInt, (String)localObject1);
    }
    this.d.setFilters(this.T);
    this.y.a(paramInt, (String)localObject1);
    this.k = ((String)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("setTextInfo:");
    ((StringBuilder)localObject2).append(paramDynamicTextItem);
    ((StringBuilder)localObject2).append(" index:");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(" text:");
    ((StringBuilder)localObject2).append((String)localObject1);
    SLog.b("EditTextDialog", ((StringBuilder)localObject2).toString());
    localObject2 = this.n;
    ((TextInfo)localObject2).a = ((String)localObject1);
    this.d.setText(((TextInfo)localObject2).a);
    if (e(this.y.k())) {
      if (this.y.f() == null) {
        this.d.setFilters(this.S);
      } else {
        this.d.setFilters(new InputFilter[] { this.y.f() });
      }
    }
    localObject1 = this.d;
    ((EditText)localObject1).setSelection(((EditText)localObject1).length());
    if (this.y.n().equals(DynamicTextBuilder.a(this.y.k(), this.y.g())))
    {
      this.d.setOnClickListener(this.U);
      this.d.setSelectAllOnFocus(true);
      if (this.d.hasFocus()) {
        this.d.selectAll();
      }
    }
    else
    {
      this.d.setOnClickListener(null);
    }
    paramInt = this.u.a(paramDynamicTextItem);
    paramDynamicTextItem = this.p;
    if (paramDynamicTextItem != null) {
      this.r = paramDynamicTextItem.a(paramInt);
    }
    if (this.J == 0) {
      g(0);
    }
    paramDynamicTextItem = this.y;
    if ((paramDynamicTextItem instanceof NormalTextItem))
    {
      localObject1 = (NormalTextItem)paramDynamicTextItem;
      this.E = paramDynamicTextItem.d();
      this.F = ((NormalTextItem)localObject1).w();
      this.f.setVisibility(0);
      this.B = ((NormalTextItem)localObject1).u();
      f(this.B);
      return;
    }
    this.f.setVisibility(8);
  }
  
  public void a(EditTextDialog.EditTextDialogEventListener paramEditTextDialogEventListener)
  {
    this.g = paramEditTextDialogEventListener;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dismiss isCancel:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("EditTextDialog", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (InputMethodManager)getContext().getSystemService("input_method");
    if (this.d != null) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
    }
    this.g.a(false);
    this.g.a(c(), d());
    this.t.setPreViewDrawer(null);
    this.g.a(this.y, paramBoolean ^ true, this.w, this.M);
    this.M = false;
    super.dismiss();
  }
  
  protected int b()
  {
    return this.m;
  }
  
  public View b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreatePanel id = ");
      localStringBuilder.append(paramInt);
      QLog.d("EditTextDialog", 2, localStringBuilder.toString());
    }
    XPanelContainer.a = (int)(this.s.getResources().getDisplayMetrics().density * 50.0F);
    if (this.x != null) {
      XPanelContainer.a += this.x.getHeight();
    }
    return null;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doPanelChanged oldPanel = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("newPanel=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("EditTextDialog", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt2 == 34)
    {
      if (this.r == -1)
      {
        localObject = this.y;
        if (localObject != null)
        {
          i1 = this.u.a((DynamicTextItem)localObject);
          this.r = this.p.a(i1);
        }
      }
      int i1 = this.r;
      if (i1 != -1) {
        this.p.b(-1, i1);
      }
      g(1);
    }
    else if (paramInt2 == 1)
    {
      g(0);
    }
    else if (paramInt2 == 0)
    {
      g(1);
    }
    this.o.post(new EditTextDialog.10(this, paramInt1, paramInt2));
  }
  
  public void b(boolean paramBoolean)
  {
    this.O = paramBoolean;
  }
  
  protected int c()
  {
    Object localObject = this.t;
    int i1;
    if (localObject != null) {
      i1 = ((EditTextPreView)localObject).getWidth() / 2 + this.t.getLeft();
    } else {
      i1 = 0;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getPreViewCenterX:");
    ((StringBuilder)localObject).append(i1);
    SLog.b("EditTextDialog", ((StringBuilder)localObject).toString());
    return i1;
  }
  
  public void c(boolean paramBoolean)
  {
    this.R = paramBoolean;
  }
  
  public boolean c(int paramInt)
  {
    return false;
  }
  
  protected int d()
  {
    Object localObject = this.t;
    int i1;
    if (localObject != null) {
      i1 = ((EditTextPreView)localObject).getHeight() / 2 + this.t.getTop();
    } else {
      i1 = 0;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getPreViewCenterY()=");
    ((StringBuilder)localObject).append(i1);
    SLog.b("EditTextDialog", ((StringBuilder)localObject).toString());
    return i1;
  }
  
  public void d(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void d(boolean paramBoolean)
  {
    this.K = paramBoolean;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      b(paramMessage.arg1, paramMessage.arg2);
    }
    return false;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    DynamicTextItem localDynamicTextItem = this.y;
    if (localDynamicTextItem != null) {
      localDynamicTextItem.o = true;
    }
    a(true);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    XPanelContainer.a = this.q;
    if (this.g == null) {
      return;
    }
    Object localObject2 = this.d.getText().toString();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "";
    }
    localObject2 = this.y;
    if (localObject2 != null)
    {
      localObject2 = ((DynamicTextItem)localObject2).i();
      DynamicTextItem localDynamicTextItem = this.y;
      if ((!localDynamicTextItem.b(localDynamicTextItem.g()).equals(localObject1)) && (!this.N))
      {
        localDynamicTextItem = this.y;
        localDynamicTextItem.a(localDynamicTextItem.g(), (String)localObject1);
      }
      if ((!((DynamicTextItem.TextMap)localObject2).equals(this.v)) && (this.y.m())) {
        this.y.a(false);
      }
    }
    this.v = null;
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    ((Activity)this.s).dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setContentView(int paramInt)
  {
    this.i = AIOUtils.b(100.0F, getContext().getResources());
    g();
    e();
    super.setContentView(this.a);
  }
  
  public void show()
  {
    super.show();
    DynamicTextItem localDynamicTextItem = this.y;
    if (localDynamicTextItem != null)
    {
      this.v = localDynamicTextItem.i();
      if (this.J == 0)
      {
        localDynamicTextItem = this.y;
        localDynamicTextItem.a(localDynamicTextItem.g(), true);
      }
    }
    else
    {
      this.v = null;
    }
    if ((this.y instanceof NormalTextItem)) {
      this.f.setVisibility(0);
    } else {
      this.f.setVisibility(8);
    }
    this.M = false;
    this.c.a(1);
    this.c.setOnPanelChangeListener(this);
  }
  
  public void v() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog
 * JD-Core Version:    0.7.0.1
 */