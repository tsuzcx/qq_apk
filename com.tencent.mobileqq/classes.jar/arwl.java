import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.forward.ForwardNewVersionDialog.7;
import com.tencent.mobileqq.forward.ForwardNewVersionDialog.8;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MaxHeightRelativelayout;
import java.lang.ref.SoftReference;

public class arwl
  extends bdgv
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  private int jdField_a_of_type_Int = 7;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected ScrollView a;
  private bdiz jdField_a_of_type_Bdiz;
  bdjb jdField_a_of_type_Bdjb = new arwm(this);
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private MaxHeightRelativelayout jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout;
  private SoftReference<Context> jdField_a_of_type_JavaLangRefSoftReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public arwl(@NonNull Context paramContext)
  {
    super(paramContext, 2131755801);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (localLayoutParams != null) {
      localLayoutParams.gravity = 17;
    }
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramContext);
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    getWindow().setSoftInputMode(19);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams(-1, bdiz.a(0), 2, 32, -1);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 81;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131755184;
    setContentView(2131558938);
  }
  
  private int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  private void a()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = -2;
      this.jdField_a_of_type_AndroidViewView.requestLayout();
    }
  }
  
  private void a(Context paramContext)
  {
    Object localObject = new arws(this);
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext instanceof QQAppInterface))
    {
      int i = getContext().getResources().getDimensionPixelSize(2131298914);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(getContext(), 2131559057, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack((appt)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
      if (this.jdField_a_of_type_Int == 7) {}
      for (boolean bool = true;; bool = false)
      {
        ((EmoticonMainPanel)localObject).b = bool;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a((QQAppInterface)paramContext, 100003, getContext(), i, null, null, false);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.k();
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_b_of_type_Int;
        return;
      }
    }
    QLog.e("Forward.NewVersion.Dialog", 1, "get QQAppInterface fail");
  }
  
  public arwl a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramString);
    this.lBtn.setVisibility(0);
    this.lBtn.setContentDescription(paramString + getContext().getString(2131691158));
    this.lBtn.setOnClickListener(new arwt(this, paramOnClickListener));
    return this;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new arwr(this, paramInt));
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.addView(paramView);
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    this.title.setText(paramString1);
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramString2);
    a(paramString3, paramOnClickListener2);
    b(paramString4, paramOnClickListener1);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public arwl b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramString);
    this.rBtn.setContentDescription(paramString + getContext().getString(2131691158));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new arwn(this, paramOnClickListener));
    return this;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.setMaxHeight(aekt.a(paramInt, getContext().getResources()));
  }
  
  public EditText getEditText()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText;
  }
  
  public String getInputValue()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
  }
  
  public void hideSoftInputFromWindow()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365643)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          a();
          this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839716);
          this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130839716));
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ForwardNewVersionDialog.7(this), 200L);
          paramView = getWindow().getAttributes();
          paramView.y = 0;
          getWindow().setAttributes(paramView);
        }
      }
      else {
        return;
      }
      paramView = this.jdField_a_of_type_AndroidWidgetImageView.getTag();
      if ((paramView != null) && ((paramView instanceof Integer)) && (((Integer)paramView).intValue() == 2130839717))
      {
        bhoc.a(this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839716);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130839716));
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      bhoc.b(this.jdField_a_of_type_AndroidWidgetEditText);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839717);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130839717));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setMinimumHeight(bdiz.a(0));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ForwardNewVersionDialog.8(this), 200L);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      a();
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
      this.jdField_a_of_type_Boolean = false;
      paramView = getWindow().getAttributes();
      paramView.y = 0;
      getWindow().setAttributes(paramView);
    }
    bhoc.b(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.g();
    }
    if (this.jdField_a_of_type_Bdiz != null) {
      this.jdField_a_of_type_Bdiz.a();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
      this.jdField_a_of_type_Boolean = false;
      WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
      localLayoutParams.y = 0;
      getWindow().setAttributes(localLayoutParams);
      a();
    }
    bhoc.b(this.jdField_a_of_type_AndroidWidgetEditText);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout = ((MaxHeightRelativelayout)findViewById(2131375849));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379156));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131368332));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365643));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368344));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365227);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(baiq.a(16));
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setMaxLines(2);
    a(this.jdField_a_of_type_AndroidContentResResources.getInteger(2131427338));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new arwo(this));
    Object localObject = (Context)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    if (localObject == null) {
      return;
    }
    aacm.a((Context)localObject, this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_Bdiz = new bdiz(((ViewGroup)getWindow().getDecorView().findViewById(16908290)).getChildAt(0), this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getHeight(), this.jdField_a_of_type_Bdjb);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Bdiz.a();
    this.jdField_b_of_type_Int = bdiz.a(this.jdField_b_of_type_Int);
    setOnDismissListener(this);
    a((Context)localObject);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setDispatchKeyEventListener(new arwp(this));
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131376144);
    if ((localObject instanceof ScrollView)) {
      this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)localObject);
    }
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new arwq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwl
 * JD-Core Version:    0.7.0.1
 */