import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.widget.MyLinearLayout;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.5;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.6;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class bhqp
  extends bhqi
  implements View.OnClickListener
{
  public static final Integer a;
  public static final Integer b;
  final float jdField_a_of_type_Float = 267.0F;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  protected View.OnClickListener a;
  public View a;
  public WindowManager.LayoutParams a;
  public WindowManager a;
  public EditText a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  public MyLinearLayout a;
  public SoftReference<Context> a;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  final float b;
  public boolean b;
  final float c;
  public boolean c;
  
  static
  {
    jdField_a_of_type_JavaLangInteger = Integer.valueOf(1);
    jdField_b_of_type_JavaLangInteger = Integer.valueOf(2);
  }
  
  public bhqp(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_b_of_type_Float = 45.5F;
    this.jdField_c_of_type_Float = 39.0F;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bhqr(this);
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramContext);
    getWindow().setSoftInputMode(19);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  public int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetMyLinearLayout);
      this.jdField_b_of_type_Boolean = false;
      WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
      localLayoutParams.y = 0;
      getWindow().setAttributes(localLayoutParams);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new bhqs(this, paramInt));
    }
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetMyLinearLayout = ((MyLinearLayout)View.inflate(paramContext, 2131559025, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetMyLinearLayout.findViewById(2131370018).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetMyLinearLayout.setDispatchKeyEventListener(new bhqt(this));
  }
  
  public void a(String paramString)
  {
    if (paramString != null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    float f = getContext().getResources().getDisplayMetrics().density;
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetMyLinearLayout.findViewById(2131370015);
    localLinearLayout.removeAllViews();
    int i = 0;
    while (i < paramArrayList.size())
    {
      View localView = View.inflate(getContext(), 2131559026, null);
      localView.setTag(Integer.valueOf(i));
      localView.setClickable(true);
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((TextView)localView.findViewById(2131370014)).setText((CharSequence)paramArrayList.get(i));
      localLinearLayout.addView(localView, new LinearLayout.LayoutParams(-1, (int)(45.5F * f)));
      i += 1;
    }
    if (paramArrayList.size() >= 5) {}
    for (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams(-1, (int)(267.0F * f), 2, 32, -1);; this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams(-1, (int)((39.0F + paramArrayList.size() * 45.5F + 2.0F) * f), 2, 32, -1))
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 81;
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
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
    if (paramView.getId() == 2131368736) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetMyLinearLayout != null)
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label78;
        }
        a();
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847305);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130847305));
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QQCustomDialogWtihInputAndChoose.5(this), 200L);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label78:
      Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 2130847907))
      {
        blgx.a(this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847305);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130847305));
        this.jdField_b_of_type_Boolean = false;
      }
      else
      {
        blgx.b(this.jdField_a_of_type_AndroidWidgetEditText);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847907);
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130847907));
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QQCustomDialogWtihInputAndChoose.6(this), 200L);
        continue;
        if (paramView.getId() == 2131370018)
        {
          a();
        }
        else
        {
          a();
          blgx.b(this.jdField_a_of_type_AndroidWidgetEditText);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    a();
    blgx.b(this.jdField_a_of_type_AndroidWidgetEditText);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  @TargetApi(11)
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365515));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131368725));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368736));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    findViewById(2131377115).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setSingleLine(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new bhqq(this));
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    if (localContext == null) {
      return;
    }
    acid.a(localContext, this.jdField_a_of_type_AndroidWidgetEditText);
    a(localContext);
  }
  
  public void setEditLint(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramString);
  }
  
  public bhpc setMessage(CharSequence paramCharSequence)
  {
    TextView localTextView = (TextView)findViewById(2131365496);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      localTextView.setText(paramCharSequence);
      localTextView.setContentDescription(paramCharSequence);
      localTextView.setVisibility(0);
      return this;
    }
    localTextView.setVisibility(8);
    return this;
  }
  
  public bhpc setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramInt);
    this.lBtn.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131690962));
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new bhqu(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public bhpc setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setContentDescription(getContext().getString(paramInt));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new bhqv(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhqp
 * JD-Core Version:    0.7.0.1
 */