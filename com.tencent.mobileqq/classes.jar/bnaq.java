import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class bnaq
  extends Dialog
  implements TextWatcher, View.OnClickListener, TextView.OnEditorActionListener, xnn
{
  private int jdField_a_of_type_Int = 1;
  protected Context a;
  private View jdField_a_of_type_AndroidViewView;
  protected EditText a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bmki jdField_a_of_type_Bmki;
  private bmkl jdField_a_of_type_Bmkl;
  private FitSystemWindowsRelativeLayout jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout;
  private String jdField_a_of_type_JavaLangString = "";
  xnj jdField_a_of_type_Xnj;
  private xnr jdField_a_of_type_Xnr;
  protected boolean a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  
  public bnaq(@NonNull Context paramContext, @NonNull bmki parambmki, bmkl parambmkl, int paramInt)
  {
    super(paramContext, 2131755180);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bmki = parambmki;
    this.jdField_a_of_type_Bmkl = parambmkl;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void a()
  {
    Object localObject = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = bmtu.b(getContext());
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
    setCanceledOnTouchOutside(true);
  }
  
  private void a(CharSequence paramCharSequence)
  {
    if (this.jdField_b_of_type_Int == 0) {}
    for (int i = 36;; i = 16)
    {
      int j = bdje.b(paramCharSequence.toString());
      if (i - j > 6) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s/%s", new Object[] { Integer.valueOf(j / 2), Integer.valueOf(i / 2) }));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramCharSequence);
      this.jdField_a_of_type_AndroidWidgetEditText.getText().clear();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramCharSequence);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout = ((FitSystemWindowsRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376002));
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout.setFitsSystemWindows(true);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380041));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363041).setOnClickListener(this);
    this.jdField_a_of_type_Xnj = xni.a(this.jdField_a_of_type_AndroidContentContext, 0, 0, null);
    this.jdField_a_of_type_Xnj.a(false);
    this.jdField_a_of_type_Xnj.a().b(alpo.a(2131717245));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_Xnj.a();
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_Xnj.a(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131380033));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380042));
    if (this.jdField_a_of_type_Bmkl == null)
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Xnr = this.jdField_a_of_type_Xnj.a();
      this.jdField_a_of_type_Int = 1;
      a(this.jdField_a_of_type_Xnr.b(), true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Xnr.a(true);
      a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      return;
      if (this.jdField_b_of_type_Int >= 0) {
        break;
      }
      localObject = this.jdField_a_of_type_Xnj.a();
      i = 0;
      while (i < localObject.length)
      {
        localObject[i].a(this.jdField_a_of_type_Bmkl.a[i]);
        i += 1;
      }
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Xnr = this.jdField_a_of_type_Xnj.a();
      this.jdField_a_of_type_Int = 2;
      a(this.jdField_a_of_type_Xnr.a(), false);
    }
    localObject = this.jdField_a_of_type_Xnj.a();
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i].a(this.jdField_a_of_type_Bmkl.a[i]);
      i += 1;
    }
    if (this.jdField_b_of_type_Int == 0) {}
    for (this.jdField_a_of_type_Xnr = this.jdField_a_of_type_Xnj.a();; this.jdField_a_of_type_Xnr = this.jdField_a_of_type_Xnj.a(this.jdField_b_of_type_Int - 1))
    {
      this.jdField_a_of_type_Int = 3;
      a(this.jdField_a_of_type_Bmkl.a[this.jdField_b_of_type_Int], false);
      break;
    }
  }
  
  public void a(xnj paramxnj, xnr paramxnr)
  {
    if ((paramxnr instanceof xnp))
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Xnr.a(false);
      this.jdField_a_of_type_Xnr = paramxnr;
      this.jdField_a_of_type_Xnr.a(true);
      if (this.jdField_a_of_type_Int != 1) {
        break label119;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Xnr.a())) {
        break label104;
      }
      a(this.jdField_a_of_type_Xnr.b(), true);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      return;
      if (!(paramxnr instanceof xno)) {
        break;
      }
      this.jdField_b_of_type_Int = (((xno)paramxnr).a() + 1);
      break;
      label104:
      a(this.jdField_a_of_type_Xnr.a(), false);
      continue;
      label119:
      a(this.jdField_a_of_type_Xnr.a(), false);
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_Xnr != null) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Xnr.a().toString();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    dismiss();
  }
  
  public void onDetachedFromWindow()
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_Xnj.a();
    int k = localObject.length;
    int i = 0;
    boolean bool = false;
    xnr[] arrayOfxnr;
    if (i < k)
    {
      arrayOfxnr = localObject[i];
      arrayOfxnr.a(false);
      if (((arrayOfxnr instanceof xno)) && (TextUtils.isEmpty(arrayOfxnr.a()))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((arrayOfxnr instanceof xno)) {
          bool = true;
        }
      }
    }
    localObject = this.jdField_a_of_type_Xnj.a();
    if (localObject != null)
    {
      arrayOfxnr = this.jdField_a_of_type_Xnj.a();
      Rect[] arrayOfRect = new Rect[arrayOfxnr.length];
      String[] arrayOfString = new String[arrayOfxnr.length];
      i = j;
      while (i < arrayOfxnr.length)
      {
        arrayOfRect[i] = arrayOfxnr[i].a();
        arrayOfString[i] = arrayOfxnr[i].a().toString();
        i += 1;
      }
      if (this.jdField_a_of_type_Bmki != null) {
        this.jdField_a_of_type_Bmki.a(arrayOfString, (Bitmap)localObject, arrayOfRect, bool);
      }
    }
    super.onDetachedFromWindow();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      if (this.jdField_a_of_type_Xnr != null)
      {
        paramTextView = this.jdField_a_of_type_AndroidWidgetEditText.getText();
        this.jdField_a_of_type_Xnr.a(paramTextView);
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return true;
      case 1: 
        if (this.jdField_b_of_type_Int < this.jdField_a_of_type_Xnj.a())
        {
          if (this.jdField_b_of_type_Int == this.jdField_a_of_type_Xnj.a() - 1)
          {
            dismiss();
            return true;
          }
          if (this.jdField_a_of_type_Xnr != null) {
            this.jdField_a_of_type_Xnr.a(false);
          }
          this.jdField_b_of_type_Int += 1;
          this.jdField_a_of_type_Xnr = this.jdField_a_of_type_Xnj.a(this.jdField_b_of_type_Int - 1);
          if (TextUtils.isEmpty(this.jdField_a_of_type_Xnr.a())) {
            a(this.jdField_a_of_type_Xnr.b(), true);
          }
          for (;;)
          {
            a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
            this.jdField_a_of_type_Xnr.a(true);
            return true;
            a(this.jdField_a_of_type_Xnr.a(), false);
          }
        }
        dismiss();
        return true;
      case 2: 
        dismiss();
        return true;
      }
      dismiss();
      return true;
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (this.jdField_b_of_type_Int == 0)
    {
      paramInt1 = 24;
      paramInt2 = bdje.b(paramCharSequence.toString());
      if (paramInt1 - paramInt2 > 6) {
        break label171;
      }
      if (paramInt1 - paramInt2 >= 0) {
        break label185;
      }
      localObject = bdje.b(paramCharSequence.toString(), 0, paramInt1);
      paramInt2 = bdje.b(((CharSequence)localObject).toString());
      a((CharSequence)localObject, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s/%s", new Object[] { Integer.valueOf(paramInt2 / 2), Integer.valueOf(paramInt1 / 2) }));
      for (;;)
      {
        this.jdField_a_of_type_Xnr.a((CharSequence)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          a(this.jdField_a_of_type_Xnr.b(), true);
        }
        if ((this.jdField_a_of_type_JavaLangString != null) && (!paramCharSequence.toString().equals(this.jdField_a_of_type_JavaLangString))) {
          this.jdField_a_of_type_Boolean = true;
        }
        return;
        paramInt1 = 16;
        break;
        label171:
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        localObject = paramCharSequence;
      }
      label185:
      localObject = paramCharSequence;
    }
  }
  
  public void setContentView(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(paramInt, null);
    a();
    b();
    super.setContentView(this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnaq
 * JD-Core Version:    0.7.0.1
 */