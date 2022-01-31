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

public class biyd
  extends Dialog
  implements TextWatcher, View.OnClickListener, TextView.OnEditorActionListener, vmc
{
  private int jdField_a_of_type_Int = 1;
  protected Context a;
  private View jdField_a_of_type_AndroidViewView;
  protected EditText a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bihm jdField_a_of_type_Bihm;
  private bihp jdField_a_of_type_Bihp;
  private FitSystemWindowsRelativeLayout jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout;
  private String jdField_a_of_type_JavaLangString = "";
  vly jdField_a_of_type_Vly;
  private vmg jdField_a_of_type_Vmg;
  protected boolean a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  
  public biyd(@NonNull Context paramContext, @NonNull bihm parambihm, bihp parambihp, int paramInt)
  {
    super(paramContext, 2131689640);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bihm = parambihm;
    this.jdField_a_of_type_Bihp = parambihp;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void a()
  {
    Object localObject = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = biqy.b(getContext());
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
      int j = baip.b(paramCharSequence.toString());
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
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout = ((FitSystemWindowsRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131309756));
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout.setFitsSystemWindows(true);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131313500));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131297465).setOnClickListener(this);
    this.jdField_a_of_type_Vly = vlx.a(this.jdField_a_of_type_AndroidContentContext, 0, 0, null);
    this.jdField_a_of_type_Vly.a(false);
    this.jdField_a_of_type_Vly.a().b(ajjy.a(2131651071));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_Vly.a();
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_Vly.a(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131313492));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313501));
    if (this.jdField_a_of_type_Bihp == null)
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Vmg = this.jdField_a_of_type_Vly.a();
      this.jdField_a_of_type_Int = 1;
      a(this.jdField_a_of_type_Vmg.b(), true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Vmg.a(true);
      a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      return;
      if (this.jdField_b_of_type_Int >= 0) {
        break;
      }
      localObject = this.jdField_a_of_type_Vly.a();
      i = 0;
      while (i < localObject.length)
      {
        localObject[i].a(this.jdField_a_of_type_Bihp.a[i]);
        i += 1;
      }
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Vmg = this.jdField_a_of_type_Vly.a();
      this.jdField_a_of_type_Int = 2;
      a(this.jdField_a_of_type_Vmg.a(), false);
    }
    localObject = this.jdField_a_of_type_Vly.a();
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i].a(this.jdField_a_of_type_Bihp.a[i]);
      i += 1;
    }
    if (this.jdField_b_of_type_Int == 0) {}
    for (this.jdField_a_of_type_Vmg = this.jdField_a_of_type_Vly.a();; this.jdField_a_of_type_Vmg = this.jdField_a_of_type_Vly.a(this.jdField_b_of_type_Int - 1))
    {
      this.jdField_a_of_type_Int = 3;
      a(this.jdField_a_of_type_Bihp.a[this.jdField_b_of_type_Int], false);
      break;
    }
  }
  
  public void a(vly paramvly, vmg paramvmg)
  {
    if ((paramvmg instanceof vme))
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Vmg.a(false);
      this.jdField_a_of_type_Vmg = paramvmg;
      this.jdField_a_of_type_Vmg.a(true);
      if (this.jdField_a_of_type_Int != 1) {
        break label119;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Vmg.a())) {
        break label104;
      }
      a(this.jdField_a_of_type_Vmg.b(), true);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      return;
      if (!(paramvmg instanceof vmd)) {
        break;
      }
      this.jdField_b_of_type_Int = (((vmd)paramvmg).a() + 1);
      break;
      label104:
      a(this.jdField_a_of_type_Vmg.a(), false);
      continue;
      label119:
      a(this.jdField_a_of_type_Vmg.a(), false);
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_Vmg != null) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Vmg.a().toString();
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
    Object localObject = this.jdField_a_of_type_Vly.a();
    int k = localObject.length;
    int i = 0;
    boolean bool = false;
    vmg[] arrayOfvmg;
    if (i < k)
    {
      arrayOfvmg = localObject[i];
      arrayOfvmg.a(false);
      if (((arrayOfvmg instanceof vmd)) && (TextUtils.isEmpty(arrayOfvmg.a()))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((arrayOfvmg instanceof vmd)) {
          bool = true;
        }
      }
    }
    localObject = this.jdField_a_of_type_Vly.a();
    if (localObject != null)
    {
      arrayOfvmg = this.jdField_a_of_type_Vly.a();
      Rect[] arrayOfRect = new Rect[arrayOfvmg.length];
      String[] arrayOfString = new String[arrayOfvmg.length];
      i = j;
      while (i < arrayOfvmg.length)
      {
        arrayOfRect[i] = arrayOfvmg[i].a();
        arrayOfString[i] = arrayOfvmg[i].a().toString();
        i += 1;
      }
      if (this.jdField_a_of_type_Bihm != null) {
        this.jdField_a_of_type_Bihm.a(arrayOfString, (Bitmap)localObject, arrayOfRect, bool);
      }
    }
    super.onDetachedFromWindow();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      if (this.jdField_a_of_type_Vmg != null)
      {
        paramTextView = this.jdField_a_of_type_AndroidWidgetEditText.getText();
        this.jdField_a_of_type_Vmg.a(paramTextView);
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return true;
      case 1: 
        if (this.jdField_b_of_type_Int < this.jdField_a_of_type_Vly.a())
        {
          if (this.jdField_b_of_type_Int == this.jdField_a_of_type_Vly.a() - 1)
          {
            dismiss();
            return true;
          }
          if (this.jdField_a_of_type_Vmg != null) {
            this.jdField_a_of_type_Vmg.a(false);
          }
          this.jdField_b_of_type_Int += 1;
          this.jdField_a_of_type_Vmg = this.jdField_a_of_type_Vly.a(this.jdField_b_of_type_Int - 1);
          if (TextUtils.isEmpty(this.jdField_a_of_type_Vmg.a())) {
            a(this.jdField_a_of_type_Vmg.b(), true);
          }
          for (;;)
          {
            a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
            this.jdField_a_of_type_Vmg.a(true);
            return true;
            a(this.jdField_a_of_type_Vmg.a(), false);
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
      paramInt2 = baip.b(paramCharSequence.toString());
      if (paramInt1 - paramInt2 > 6) {
        break label171;
      }
      if (paramInt1 - paramInt2 >= 0) {
        break label185;
      }
      localObject = baip.b(paramCharSequence.toString(), 0, paramInt1);
      paramInt2 = baip.b(((CharSequence)localObject).toString());
      a((CharSequence)localObject, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s/%s", new Object[] { Integer.valueOf(paramInt2 / 2), Integer.valueOf(paramInt1 / 2) }));
      for (;;)
      {
        this.jdField_a_of_type_Vmg.a((CharSequence)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          a(this.jdField_a_of_type_Vmg.b(), true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biyd
 * JD-Core Version:    0.7.0.1
 */