import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.DynamicTextItem.TextMap;
import dov.com.qq.im.capture.text.EditTextPreView;
import dov.com.qq.im.capture.view.PressScaleTextView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.10;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.12;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.13;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.14;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import java.util.List;
import mqq.os.MqqHandler;

public class bkbv
  extends Dialog
  implements Handler.Callback, View.OnClickListener, bfxd, bkgt
{
  private float jdField_a_of_type_Float;
  public int a;
  Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bkbx(this);
  public View a;
  public ViewGroup a;
  public ViewTreeObserver.OnGlobalLayoutListener a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  public RelativeLayout a;
  private bcpw jdField_a_of_type_Bcpw;
  bjgr jdField_a_of_type_Bjgr;
  public bkbf a;
  public bkcg a;
  public FitSystemWindowsRelativeLayout a;
  public XPanelContainer a;
  public DynamicTextItem.TextMap a;
  public DynamicTextItem a;
  public EditTextPreView a;
  private PressScaleTextView jdField_a_of_type_DovComQqImCaptureViewPressScaleTextView;
  EditTextPanel jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel;
  public HorizontalSelectColorLayout a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new EditTextDialog.10(this);
  public String a;
  protected final MqqHandler a;
  public boolean a;
  private InputFilter[] jdField_a_of_type_ArrayOfAndroidTextInputFilter = { new bkcj(20) };
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
  private int k;
  private int l = bjhs.jdField_b_of_type_Int;
  private int m;
  private int n;
  
  public bkbv(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, 2131755176);
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = bkol.a();
    this.jdField_a_of_type_Bkbf = new bkbf();
    this.jdField_a_of_type_MqqOsMqqHandler = new bfmt(Looper.getMainLooper(), this, true);
    this.jdField_e_of_type_Int = XPanelContainer.jdField_a_of_type_Int;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      this.n = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getIntExtra("capture_operation_in", -1);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131559001, null));
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new bkci(this, null);
    this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new bkch(this, null));
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout = ((FitSystemWindowsRelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375512));
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout.setFitsSystemWindows(true);
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout.setOnTouchListener(new bkbw(this));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375491));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377118));
    this.jdField_a_of_type_AndroidWidgetEditText.setHighlightColor(Color.parseColor("#cceae8"));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377109);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel = ((EditTextPanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365537).findViewById(2131371231));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.setPanelListener(this);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.a(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.setOpIn(this.n);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.setEditPhoto(this.jdField_e_of_type_Boolean);
    this.jdField_a_of_type_DovComQqImCaptureViewPressScaleTextView = ((PressScaleTextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377082));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377083));
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewPressScaleTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_DovComQqImCaptureViewPressScaleTextView.setOnClickListener(new bkby(this));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bkbz(this));
    }
    this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView = ((EditTextPreView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377121));
    this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setOnClickListener(new bkca(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new bkcb(this));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new bkcc(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new bkcd(this));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout = ((HorizontalSelectColorLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370770));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setStrokeStrategy(new bkol(), false, 0);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStrokeWithColor(bkol.a());
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setEditDialogMode(true);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnStrokeSelectedListener(new bkce(this));
  }
  
  private void b()
  {
    Object localObject = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    int[] arrayOfInt;
    if (this.jdField_b_of_type_Boolean)
    {
      localLayoutParams.height = bkht.b(getContext());
      if (bkur.f())
      {
        arrayOfInt = bkur.a(this.jdField_a_of_type_AndroidContentContext);
        if ((arrayOfInt.length != 2) || (arrayOfInt[0] <= 0) || (arrayOfInt[1] <= 0)) {}
      }
    }
    for (localLayoutParams.height = arrayOfInt[1];; localLayoutParams.height = -1)
    {
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
      return;
    }
  }
  
  private void b(int paramInt)
  {
    this.m = paramInt;
    switch (this.m)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem == null);
          this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b();
        } while (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView == null);
        this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.invalidate();
        return;
      } while (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem == null);
      paramInt = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b();
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a();
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(paramInt, true);
    } while (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView == null);
    this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.invalidate();
  }
  
  private void c()
  {
    getWindow().getDecorView().setSystemUiVisibility(4);
    getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new bkcf(this));
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem == null) || (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView == null)) {}
    do
    {
      return;
      String str2 = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(this.k);
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "";
      }
      if (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView != null)
      {
        this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setPreViewDrawer(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem);
        this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setText(this.k, str1);
      }
    } while (!QLog.isColorLevel());
    QLog.d("EditTextDialog", 2, "text size changednow text size:" + this.l);
  }
  
  public int a()
  {
    int i1 = this.jdField_a_of_type_AndroidWidgetEditText.getTop();
    int i2 = b();
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidWidgetEditText.getPaint();
    return (int)(i1 + i2 + this.jdField_a_of_type_AndroidWidgetEditText.getBaseline() + localTextPaint.ascent());
  }
  
  public View a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTextDialog", 2, "onCreatePanel id = " + paramInt);
    }
    XPanelContainer.jdField_a_of_type_Int = (int)(50.0F * this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density);
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
    if (QLog.isColorLevel()) {
      QLog.d("EditTextDialog", 2, "onPanelChanged oldPanel = " + paramInt1 + "newPanel=" + paramInt2);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0, paramInt1, paramInt2).sendToTarget();
  }
  
  public void a(bjgr parambjgr)
  {
    this.jdField_a_of_type_Bjgr = parambjgr;
  }
  
  public void a(bkcg parambkcg)
  {
    this.jdField_a_of_type_Bkcg = parambkcg;
  }
  
  public void a(DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTextDialog", 2, "onPanelItemClick position = " + paramInt);
    }
    Object localObject;
    if ((this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) && (this.jdField_a_of_type_AndroidWidgetEditText != null) && (paramDynamicTextConfigBean != null))
    {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b();
      localObject = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a();
      if (paramDynamicTextConfigBean.text_id != this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c()) {
        break label357;
      }
      paramDynamicTextConfigBean = this.jdField_a_of_type_Bjgr.a(paramDynamicTextConfigBean.text_id, (List)localObject);
      paramDynamicTextConfigBean.c(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.d());
      this.l = paramDynamicTextConfigBean.d();
      paramDynamicTextConfigBean.a = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a;
      paramDynamicTextConfigBean.b(0);
      paramDynamicTextConfigBean.a(0, paramDynamicTextConfigBean.a(0));
      if (!(paramDynamicTextConfigBean instanceof bjhs)) {
        break label391;
      }
      ((bjhs)paramDynamicTextConfigBean).a(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setVisibility(0);
      label165:
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a();
      if (!this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.equals(paramDynamicTextConfigBean)) {
        this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = paramDynamicTextConfigBean;
      }
      this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setPreViewDrawer(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem);
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(-1, this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView, true, 3000, 500, new EditTextDialog.14(this));
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(this.jdField_b_of_type_ArrayOfAndroidTextInputFilter);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a());
      if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c() != 0)
      {
        if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a() != null) {
          break label403;
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
      }
      label282:
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.length());
      if (!this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a().equals(bjgr.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c(), this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b()))) {
        break label427;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setSelectAllOnFocus(true);
      if (this.jdField_a_of_type_AndroidWidgetEditText.hasFocus()) {
        this.jdField_a_of_type_AndroidWidgetEditText.selectAll();
      }
    }
    for (;;)
    {
      this.f = paramInt;
      return;
      label357:
      localObject = bjgr.a(bjgr.a(paramDynamicTextConfigBean.text_id), this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem);
      this.jdField_a_of_type_MqqOsMqqHandler.post(new EditTextDialog.13(this));
      break;
      label391:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setVisibility(8);
      break label165;
      label403:
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a() });
      break label282;
      label427:
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(null);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelectAllOnFocus(false);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    }
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, int paramInt)
  {
    if (paramInt == -1) {}
    do
    {
      return;
      this.k = paramInt;
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = paramDynamicTextItem;
      this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextItem = paramDynamicTextItem;
    } while (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem == null);
    this.l = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.d();
    this.i = this.l;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(this.k);
    if (QLog.isColorLevel()) {
      QLog.d("EditTextDialog", 2, "normalTextSize" + this.l);
    }
    String str2 = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    if (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setPreViewDrawer(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem);
      this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setText(paramInt, str1);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(this.jdField_b_of_type_ArrayOfAndroidTextInputFilter);
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(paramInt, str1);
    this.jdField_a_of_type_JavaLangString = str1;
    veg.b("EditTextDialog", "setTextInfo:" + paramDynamicTextItem + " index:" + paramInt + " text:" + str1);
    this.jdField_a_of_type_Bkbf.jdField_a_of_type_JavaLangString = str1;
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_Bkbf.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c() != 0)
    {
      if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a() == null) {
        this.jdField_a_of_type_AndroidWidgetEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.length());
      if (!this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a().equals(bjgr.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c(), this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b()))) {
        break label483;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelectAllOnFocus(true);
      if (this.jdField_a_of_type_AndroidWidgetEditText.hasFocus()) {
        this.jdField_a_of_type_AndroidWidgetEditText.selectAll();
      }
    }
    for (;;)
    {
      paramInt = this.jdField_a_of_type_Bjgr.a(paramDynamicTextItem);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel != null) {
        this.f = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.a(paramInt);
      }
      if (this.m == 0) {
        b(0);
      }
      if (!(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem instanceof bjhs)) {
        break label494;
      }
      paramDynamicTextItem = (bjhs)this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
      this.jdField_a_of_type_Float = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b();
      this.jdField_b_of_type_Float = paramDynamicTextItem.f();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setVisibility(0);
      this.h = paramDynamicTextItem.e();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStrokeWithColor(this.h);
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a() });
      break;
      label483:
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(null);
    }
    label494:
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditTextDialog", 2, "dismiss isCancel:" + paramBoolean);
    }
    Object localObject = (InputMethodManager)getContext().getSystemService("input_method");
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidViewViewGroup.getWindowToken(), 0);
    }
    this.jdField_a_of_type_Bkcg.a(false);
    this.jdField_a_of_type_Bkcg.a(c(), d());
    this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setPreViewDrawer(null);
    localObject = this.jdField_a_of_type_Bkcg;
    DynamicTextItem localDynamicTextItem = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((bkcg)localObject).a(localDynamicTextItem, paramBoolean, this.g, this.jdField_c_of_type_Boolean);
      this.jdField_c_of_type_Boolean = false;
      getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(null);
      getWindow().getDecorView().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      super.dismiss();
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  protected int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTextDialog", 2, "doPanelChanged oldPanel = " + paramInt1 + "newPanel=" + paramInt2);
    }
    if (paramInt2 == 34)
    {
      if ((this.f == -1) && (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null))
      {
        int i1 = this.jdField_a_of_type_Bjgr.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem);
        this.f = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.a(i1);
      }
      if (this.f != -1) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiPanelEditTextPanel.a(-1, this.f);
      }
      b(1);
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new EditTextDialog.12(this, paramInt1, paramInt2));
      return;
      if (paramInt2 == 1) {
        b(0);
      } else if (paramInt2 == 0) {
        b(1);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public int c()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView != null) {
      i1 = this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.getWidth() / 2 + this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.getLeft();
    }
    veg.b("EditTextDialog", "getPreViewCenterX:" + i1);
    return i1;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public int d()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView != null) {
      i1 = this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.getHeight() / 2 + this.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.getTop();
    }
    veg.b("EditTextDialog", "getPreViewCenterY()=" + i1);
    return i1;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b(paramMessage.arg1, paramMessage.arg2);
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.jdField_d_of_type_Boolean = true;
    }
    a(true);
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.d("EditTextDialog", 2, "onClick getCurrentPanel = " + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    XPanelContainer.jdField_a_of_type_Int = this.jdField_e_of_type_Int;
    if (this.jdField_a_of_type_Bkcg == null) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "";
    }
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null)
    {
      localObject2 = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a();
      if (!this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b()).equals(localObject1)) {
        this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), (String)localObject1);
      }
      if ((!((DynamicTextItem.TextMap)localObject2).equals(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap)) && (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.e())) {
        this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(false);
      }
    }
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap = null;
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    ((Activity)this.jdField_a_of_type_AndroidContentContext).dispatchTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      getWindow().getDecorView().setSystemUiVisibility(4);
    }
  }
  
  public void r() {}
  
  public void setContentView(int paramInt)
  {
    this.jdField_a_of_type_Int = actn.a(100.0F, getContext().getResources());
    b();
    a();
    if ((!this.jdField_a_of_type_Boolean) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      c();
    }
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void show()
  {
    super.show();
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a();
      if (this.m == 0) {
        this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), true);
      }
      if (!(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem instanceof bjhs)) {
        break label76;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap = null;
      break;
      label76:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkbv
 * JD-Core Version:    0.7.0.1
 */