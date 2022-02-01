import android.annotation.SuppressLint;
import android.app.Activity;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.MaxHeightRelativelayout;
import java.lang.ref.SoftReference;

public class auhv
  extends bgqg
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
  private bgsk jdField_a_of_type_Bgsk;
  bgsm jdField_a_of_type_Bgsm = new auhw(this);
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private MaxHeightRelativelayout jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout;
  private SoftReference<Context> jdField_a_of_type_JavaLangRefSoftReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public auhv(@NonNull Context paramContext)
  {
    super(paramContext, 2131755823);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (localLayoutParams != null) {
      localLayoutParams.gravity = 17;
    }
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramContext);
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    getWindow().setSoftInputMode(19);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams(-1, bgsk.a(0), 2, 32, -1);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 81;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131755185;
    setContentView(2131559004);
  }
  
  private int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  private void a(Context paramContext)
  {
    Object localObject = new auic(this);
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext instanceof QQAppInterface))
    {
      int i = getContext().getResources().getDimensionPixelSize(2131298998);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(getContext(), 2131559123, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack((arxd)localObject);
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
  
  private boolean a()
  {
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    return ((localContext instanceof Activity)) && (((Activity)localContext).isFinishing());
  }
  
  private void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = -2;
      this.jdField_a_of_type_AndroidViewView.requestLayout();
    }
  }
  
  public auhv a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramString);
    this.lBtn.setVisibility(0);
    this.lBtn.setContentDescription(paramString + getContext().getString(2131690962));
    this.lBtn.setOnClickListener(new auid(this, paramOnClickListener));
    return this;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getTag();
    if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 2130840124))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840123);
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130840123));
      b();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
    }
  }
  
  public void a(int paramInt)
  {
    setContentView(paramInt);
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
  
  public auhv b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramString);
    this.rBtn.setContentDescription(paramString + getContext().getString(2131690962));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new auhx(this, paramOnClickListener));
    return this;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new auib(this, paramInt));
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.setMaxHeight(afur.a(paramInt, getContext().getResources()));
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
    Object localObject;
    if (paramView.getId() == 2131365878) {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label117;
        }
        b();
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840123);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130840123));
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ForwardNewVersionDialog.7(this), 200L);
        localObject = getWindow().getAttributes();
        ((WindowManager.LayoutParams)localObject).y = 0;
        getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label117:
      localObject = this.jdField_a_of_type_AndroidWidgetImageView.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 2130840124))
      {
        bkft.a(this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840123);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130840123));
        this.jdField_a_of_type_Boolean = false;
      }
      else
      {
        bkft.b(this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840124);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130840124));
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setMinimumHeight(bgsk.a(0));
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ForwardNewVersionDialog.8(this), 200L);
        continue;
        if (this.jdField_a_of_type_Boolean)
        {
          b();
          this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
          this.jdField_a_of_type_Boolean = false;
          localObject = getWindow().getAttributes();
          ((WindowManager.LayoutParams)localObject).y = 0;
          getWindow().setAttributes((WindowManager.LayoutParams)localObject);
        }
        bkft.b(this.jdField_a_of_type_AndroidWidgetEditText);
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.g();
    }
    if (this.jdField_a_of_type_Bgsk != null) {
      this.jdField_a_of_type_Bgsk.a();
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
      b();
    }
    bkft.b(this.jdField_a_of_type_AndroidWidgetEditText);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout = ((MaxHeightRelativelayout)findViewById(2131376641));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380139));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131368651));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365878));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368663));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365471);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(bdod.a(16));
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setMaxLines(2);
    b(this.jdField_a_of_type_AndroidContentResResources.getInteger(2131427338));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new auhy(this));
    Object localObject = (Context)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    if (localObject == null) {
      return;
    }
    acdz.a((Context)localObject, this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_Bgsk = new bgsk(((ViewGroup)getWindow().getDecorView().findViewById(16908290)).getChildAt(0), this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getHeight(), this.jdField_a_of_type_Bgsm);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Bgsk.a();
    this.jdField_b_of_type_Int = bgsk.a(this.jdField_b_of_type_Int);
    setOnDismissListener(this);
    a((Context)localObject);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setDispatchKeyEventListener(new auhz(this));
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131376969);
    if ((localObject instanceof ScrollView)) {
      this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)localObject);
    }
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new auia(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auhv
 * JD-Core Version:    0.7.0.1
 */