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
import android.widget.Button;
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
  private float jdField_a_of_type_Float;
  public int a;
  Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new EditTextDialog.9(this);
  public View a;
  public ViewGroup a;
  public ViewTreeObserver.OnGlobalLayoutListener a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  public RelativeLayout a;
  DynamicTextBuilder jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextBuilder;
  public DynamicTextItem.TextMap a;
  public DynamicTextItem a;
  EditTextPreView jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView;
  private PressScaleTextView jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewPressScaleTextView;
  public TextInfo a;
  public AEHorizontalSelectColorLayout a;
  public EditTextDialog.EditTextDialogEventListener a;
  EditTextPanel jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextPanel;
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  public FitSystemWindowsRelativeLayout a;
  public XPanelContainer a;
  public String a;
  protected final MqqHandler a;
  private boolean jdField_a_of_type_Boolean;
  private InputFilter[] jdField_a_of_type_ArrayOfAndroidTextInputFilter = { new EditTextDialog.LengthInputFilter(20) };
  private float jdField_b_of_type_Float;
  public int b;
  public DynamicTextItem b;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  private InputFilter[] jdField_b_of_type_ArrayOfAndroidTextInputFilter = new InputFilter[0];
  public int c;
  private boolean c;
  public int d;
  private boolean d;
  public int e;
  private boolean e;
  public int f = -1;
  public int g;
  public int h;
  public int i;
  private int j = 580;
  private int k = 0;
  private int l = NormalTextItem.jdField_c_of_type_Int;
  private int m = 0;
  private int n;
  
  public EditTextDialog(Context paramContext)
  {
    super(paramContext, 2131755348);
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = EditDialogStrokeStrategy.a(false);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerModelTextInfo = new TextInfo();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.jdField_e_of_type_Int = XPanelContainer.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = this.jdField_a_of_type_AndroidContentContext;
    if ((paramContext instanceof Activity)) {
      this.n = ((Activity)paramContext).getIntent().getIntExtra("capture_operation_in", -1);
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131559075, null));
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new EditTextDialog.LayoutChangeListener(this, null);
    this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new EditTextDialog.InitialLayoutListener(this, null));
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout = ((FitSystemWindowsRelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376831));
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout.setFitsSystemWindows(true);
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout.setOnTouchListener(new EditTextDialog.1(this));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376809));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378545));
    this.jdField_a_of_type_AndroidWidgetEditText.setHighlightColor(Color.parseColor("#cceae8"));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378536);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextPanel = ((EditTextPanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366095).findViewById(2131372290));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextPanel.setPanelListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextPanel.a(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextPanel.setOpIn(this.n);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextPanel.setEditPhoto(this.jdField_e_of_type_Boolean);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewPressScaleTextView = ((PressScaleTextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378514));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378515));
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewPressScaleTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewPressScaleTextView.setOnClickListener(new EditTextDialog.2(this));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new EditTextDialog.3(this));
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView = ((EditTextPreView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378548));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView.setOnClickListener(new EditTextDialog.4(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new EditTextDialog.5(this));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new EditTextDialog.6(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new EditTextDialog.7(this));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout = ((AEHorizontalSelectColorLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371812));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout.setColorSelectListener(new EditTextDialog.8(this));
  }
  
  private boolean a()
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
  
  private void b()
  {
    Object localObject = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    if (this.jdField_a_of_type_Boolean)
    {
      localLayoutParams.height = com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil.b(getContext());
      if (LiuHaiUtils.f())
      {
        int[] arrayOfInt = LiuHaiUtils.a(this.jdField_a_of_type_AndroidContentContext);
        if ((arrayOfInt.length == 2) && (arrayOfInt[0] > 0) && (arrayOfInt[1] > 0))
        {
          localLayoutParams.height = arrayOfInt[1];
          int i1;
          if ((a()) && (com.tencent.mobileqq.mini.util.DisplayUtil.checkNavigationBarShow(this.jdField_a_of_type_AndroidContentContext))) {
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
            localLayoutParams.height -= com.tencent.mobileqq.mini.util.DisplayUtil.getNavigationBarHeight(this.jdField_a_of_type_AndroidContentContext);
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
      localObject = new SystemBarCompact(this, true, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(17170445));
      ((SystemBarCompact)localObject).setStatusBarDrawable(null);
      ((SystemBarCompact)localObject).init();
    }
    setCanceledOnTouchOutside(false);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt != 0) && (paramInt != 32) && (paramInt != 31) && (paramInt != 30) && (paramInt != 33);
  }
  
  private void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
    if (localObject1 != null)
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView == null) {
        return;
      }
      Object localObject2 = ((DynamicTextItem)localObject1).a(this.k);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "";
      }
      localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView;
      if (localObject2 != null)
      {
        ((EditTextPreView)localObject2).setPreViewDrawer(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView.setText(this.k, (String)localObject1);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("text size changednow text size:");
        ((StringBuilder)localObject1).append(this.l);
        QLog.d("EditTextDialog", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private void c(int paramInt)
  {
    Iterator localIterator = AEColorBarManage.a.iterator();
    int i1 = 0;
    while ((localIterator.hasNext()) && (paramInt != ((Integer)localIterator.next()).intValue())) {
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout.a(AEColorBarManage.a, i1, false);
  }
  
  private void d(int paramInt)
  {
    this.m = paramInt;
    paramInt = this.m;
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
      if (localObject != null)
      {
        ((DynamicTextItem)localObject).b();
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView;
        if (localObject != null) {
          ((EditTextPreView)localObject).invalidate();
        }
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
      if (localObject != null)
      {
        paramInt = ((DynamicTextItem)localObject).b();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a(paramInt, true);
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView;
        if (localObject != null) {
          ((EditTextPreView)localObject).invalidate();
        }
      }
    }
  }
  
  protected int a()
  {
    int i1 = this.jdField_a_of_type_AndroidWidgetEditText.getTop();
    int i2 = b();
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidWidgetEditText.getPaint();
    return (int)(i1 + i2 + this.jdField_a_of_type_AndroidWidgetEditText.getBaseline() + localTextPaint.ascent());
  }
  
  public View a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreatePanel id = ");
      localStringBuilder.append(paramInt);
      QLog.d("EditTextDialog", 2, localStringBuilder.toString());
    }
    XPanelContainer.jdField_a_of_type_Int = (int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 50.0F);
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      XPanelContainer.jdField_a_of_type_Int += this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
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
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0, paramInt1, paramInt2).sendToTarget();
  }
  
  public void a(DynamicTextBuilder paramDynamicTextBuilder)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextBuilder = paramDynamicTextBuilder;
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
      ((AEBaseDataReporter)localObject).q(localStringBuilder.toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
    if ((localObject != null) && (this.jdField_a_of_type_AndroidWidgetEditText != null) && (paramDynamicTextConfigBean != null))
    {
      ((DynamicTextItem)localObject).b();
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a();
      if (paramDynamicTextConfigBean.text_id != this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.c())
      {
        localObject = DynamicTextBuilder.a(DynamicTextBuilder.a(paramDynamicTextConfigBean.text_id), this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem);
        this.jdField_a_of_type_MqqOsMqqHandler.post(new EditTextDialog.11(this));
      }
      paramDynamicTextConfigBean = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextBuilder.a(paramDynamicTextConfigBean.text_id, (List)localObject);
      paramDynamicTextConfigBean.c(paramDynamicTextConfigBean.d());
      this.l = paramDynamicTextConfigBean.d();
      paramDynamicTextConfigBean.a = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a;
      paramDynamicTextConfigBean.b(0);
      paramDynamicTextConfigBean.a(0, paramDynamicTextConfigBean.a(0));
      if ((paramDynamicTextConfigBean instanceof NormalTextItem))
      {
        localObject = (NormalTextItem)paramDynamicTextConfigBean;
        ((NormalTextItem)localObject).a(this.jdField_c_of_type_Int);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout.setVisibility(0);
        c(((NormalTextItem)localObject).e());
      }
      else
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a();
      if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.equals(paramDynamicTextConfigBean)) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem = paramDynamicTextConfigBean;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView.setPreViewDrawer(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a(-1, this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView, true, 3000, 500, new EditTextDialog.12(this));
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(this.jdField_b_of_type_ArrayOfAndroidTextInputFilter);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a());
      if (b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.c())) {
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a() == null) {
          this.jdField_a_of_type_AndroidWidgetEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
        } else {
          this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a() });
        }
      }
      paramDynamicTextConfigBean = this.jdField_a_of_type_AndroidWidgetEditText;
      paramDynamicTextConfigBean.setSelection(paramDynamicTextConfigBean.length());
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a().equals(DynamicTextBuilder.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.c(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.b())))
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelectAllOnFocus(true);
        if (this.jdField_a_of_type_AndroidWidgetEditText.hasFocus()) {
          this.jdField_a_of_type_AndroidWidgetEditText.selectAll();
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(null);
        this.jdField_a_of_type_AndroidWidgetEditText.setSelectAllOnFocus(false);
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      }
      this.f = paramInt;
    }
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    this.k = paramInt;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem = paramDynamicTextItem;
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem = paramDynamicTextItem;
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
    if (localObject1 == null) {
      return;
    }
    this.l = ((DynamicTextItem)localObject1).d();
    this.i = this.l;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a(this.k);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("normalTextSize");
      ((StringBuilder)localObject1).append(this.l);
      QLog.d("EditTextDialog", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a(paramInt);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "";
    }
    localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView;
    if (localObject2 != null)
    {
      ((EditTextPreView)localObject2).setPreViewDrawer(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView.setText(paramInt, (String)localObject1);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(this.jdField_b_of_type_ArrayOfAndroidTextInputFilter);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a(paramInt, (String)localObject1);
    this.jdField_a_of_type_JavaLangString = ((String)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("setTextInfo:");
    ((StringBuilder)localObject2).append(paramDynamicTextItem);
    ((StringBuilder)localObject2).append(" index:");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(" text:");
    ((StringBuilder)localObject2).append((String)localObject1);
    SLog.b("EditTextDialog", ((StringBuilder)localObject2).toString());
    localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerModelTextInfo;
    ((TextInfo)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(((TextInfo)localObject2).jdField_a_of_type_JavaLangString);
    if (b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.c())) {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a() == null) {
        this.jdField_a_of_type_AndroidWidgetEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
      } else {
        this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a() });
      }
    }
    localObject1 = this.jdField_a_of_type_AndroidWidgetEditText;
    ((EditText)localObject1).setSelection(((EditText)localObject1).length());
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a().equals(DynamicTextBuilder.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.c(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.b())))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelectAllOnFocus(true);
      if (this.jdField_a_of_type_AndroidWidgetEditText.hasFocus()) {
        this.jdField_a_of_type_AndroidWidgetEditText.selectAll();
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(null);
    }
    paramInt = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextBuilder.a(paramDynamicTextItem);
    paramDynamicTextItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextPanel;
    if (paramDynamicTextItem != null) {
      this.f = paramDynamicTextItem.a(paramInt);
    }
    if (this.m == 0) {
      d(0);
    }
    paramDynamicTextItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
    if ((paramDynamicTextItem instanceof NormalTextItem))
    {
      localObject1 = (NormalTextItem)paramDynamicTextItem;
      this.jdField_a_of_type_Float = paramDynamicTextItem.b();
      this.jdField_b_of_type_Float = ((NormalTextItem)localObject1).f();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout.setVisibility(0);
      this.h = ((NormalTextItem)localObject1).e();
      c(this.h);
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout.setVisibility(8);
  }
  
  public void a(EditTextDialog.EditTextDialogEventListener paramEditTextDialogEventListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener = paramEditTextDialogEventListener;
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
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidViewViewGroup.getWindowToken(), 0);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener.a(false);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener.a(c(), d());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView.setPreViewDrawer(null);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem, paramBoolean ^ true, this.g, this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_Boolean = false;
    super.dismiss();
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  protected int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
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
      if (this.f == -1)
      {
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
        if (localObject != null)
        {
          i1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextBuilder.a((DynamicTextItem)localObject);
          this.f = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextPanel.a(i1);
        }
      }
      int i1 = this.f;
      if (i1 != -1) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextPanel.a(-1, i1);
      }
      d(1);
    }
    else if (paramInt2 == 1)
    {
      d(0);
    }
    else if (paramInt2 == 0)
    {
      d(1);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new EditTextDialog.10(this, paramInt1, paramInt2));
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  protected int c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView;
    int i1;
    if (localObject != null) {
      i1 = ((EditTextPreView)localObject).getWidth() / 2 + this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView.getLeft();
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
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  protected int d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView;
    int i1;
    if (localObject != null) {
      i1 = ((EditTextPreView)localObject).getHeight() / 2 + this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView.getTop();
    } else {
      i1 = 0;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getPreViewCenterY()=");
    ((StringBuilder)localObject).append(i1);
    SLog.b("EditTextDialog", ((StringBuilder)localObject).toString());
    return i1;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
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
    DynamicTextItem localDynamicTextItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
    if (localDynamicTextItem != null) {
      localDynamicTextItem.jdField_d_of_type_Boolean = true;
    }
    a(true);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    XPanelContainer.jdField_a_of_type_Int = this.jdField_e_of_type_Int;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener == null) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "";
    }
    localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
    if (localObject2 != null)
    {
      localObject2 = ((DynamicTextItem)localObject2).a();
      DynamicTextItem localDynamicTextItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
      if ((!localDynamicTextItem.a(localDynamicTextItem.b()).equals(localObject1)) && (!this.jdField_c_of_type_Boolean))
      {
        localDynamicTextItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
        localDynamicTextItem.a(localDynamicTextItem.b(), (String)localObject1);
      }
      if ((!((DynamicTextItem.TextMap)localObject2).equals(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap)) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.e())) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a(false);
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap = null;
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    ((Activity)this.jdField_a_of_type_AndroidContentContext).dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void s() {}
  
  public void setContentView(int paramInt)
  {
    this.jdField_a_of_type_Int = AIOUtils.b(100.0F, getContext().getResources());
    b();
    a();
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void show()
  {
    super.show();
    DynamicTextItem localDynamicTextItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
    if (localDynamicTextItem != null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap = localDynamicTextItem.a();
      if (this.m == 0)
      {
        localDynamicTextItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
        localDynamicTextItem.a(localDynamicTextItem.b(), true);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem$TextMap = null;
    }
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem instanceof NormalTextItem)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout.setVisibility(0);
    } else {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout.setVisibility(8);
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog
 * JD-Core Version:    0.7.0.1
 */