import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.widget.XEditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bkiy
  extends Dialog
  implements TextWatcher, View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, TextView.OnEditorActionListener
{
  public static final String a;
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  bkiz jdField_a_of_type_Bkiz;
  XEditText jdField_a_of_type_ComTencentWidgetXEditText;
  boolean jdField_a_of_type_Boolean = false;
  String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajyc.a(2131706104);
  }
  
  public bkiy(@NonNull Context paramContext)
  {
    super(paramContext, 2131755176);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(bjwq parambjwq)
  {
    Window localWindow = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = vpp.b(getContext());
    localLayoutParams.flags |= 0x20;
    localLayoutParams.gravity = 80;
    localWindow.setAttributes(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131559008, null));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditText = ((XEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365493));
    this.jdField_a_of_type_ComTencentWidgetXEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365492);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    setOnDismissListener(parambjwq);
    this.jdField_a_of_type_Int = actn.a(100.0F, getContext().getResources());
    this.jdField_a_of_type_Bkiz = parambjwq;
    setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void a(String paramString)
  {
    int j = 0;
    int i = 0;
    super.show();
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditText.setText(paramString);
      XEditText localXEditText = this.jdField_a_of_type_ComTencentWidgetXEditText;
      if (paramString == null) {}
      for (;;)
      {
        localXEditText.setSelection(i);
        i = Color.parseColor("#FF212226");
        this.jdField_a_of_type_ComTencentWidgetXEditText.setTextColor(i);
        this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this);
        return;
        i = paramString.length();
      }
    }
    this.jdField_a_of_type_ComTencentWidgetXEditText.setText(this.b);
    paramString = this.jdField_a_of_type_ComTencentWidgetXEditText;
    if (this.b == null) {}
    for (i = j;; i = this.b.length())
    {
      paramString.setSelection(i);
      break;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = Color.parseColor("#FF212226");
    this.jdField_a_of_type_ComTencentWidgetXEditText.setTextColor(i);
    if (paramEditable != null)
    {
      if (paramEditable.length() == 0) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void dismiss()
  {
    super.dismiss();
    this.jdField_a_of_type_Boolean = false;
    this.b = this.jdField_a_of_type_ComTencentWidgetXEditText.getText().toString();
    this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      dismiss();
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXEditText.setText("");
    bjwq.a("clk_kbdelete", this.jdField_a_of_type_AndroidContentContext);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) && (this.jdField_a_of_type_Bkiz != null))
    {
      bjwq.a("clk_kbfinish", this.jdField_a_of_type_AndroidContentContext);
      paramTextView = this.jdField_a_of_type_ComTencentWidgetXEditText.getText().toString();
      if ((TextUtils.isEmpty(paramTextView)) || (!bbff.d.matcher(paramTextView).matches())) {
        break label138;
      }
    }
    label138:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        this.jdField_a_of_type_Bkiz.a(paramTextView);
        this.b = null;
        super.dismiss();
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        return true;
      }
      bjwq.a("exp_wronglink", this.jdField_a_of_type_AndroidContentContext);
      bcpw.a(getContext(), jdField_a_of_type_JavaLangString, 0).a();
      paramInt = Color.parseColor("#ff4222");
      this.jdField_a_of_type_ComTencentWidgetXEditText.setTextColor(paramInt);
      return true;
    }
  }
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_AndroidViewViewGroup.getBottom();
    int j = this.jdField_a_of_type_AndroidViewViewGroup.getRootView().getBottom();
    veg.b(getClass().getName(), "bottom = " + i + " , rootBottom = " + j + " , mMinKeyboardHeight = " + this.jdField_a_of_type_Int);
    if (j - i > this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Boolean = true;
      localObject = new Rect();
      this.jdField_a_of_type_AndroidViewView.getHitRect((Rect)localObject);
      ((Rect)localObject).top -= vzo.a(getContext(), 5.0F);
      ((Rect)localObject).bottom += vzo.a(getContext(), 5.0F);
      localObject = new TouchDelegate((Rect)localObject, this.jdField_a_of_type_AndroidViewView);
      ((View)this.jdField_a_of_type_AndroidViewView.getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
    while (!this.jdField_a_of_type_Boolean)
    {
      Object localObject;
      return;
    }
    dismiss();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkiy
 * JD-Core Version:    0.7.0.1
 */