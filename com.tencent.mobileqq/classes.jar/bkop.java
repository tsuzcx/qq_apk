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

public class bkop
  extends Dialog
  implements TextWatcher, View.OnClickListener, TextView.OnEditorActionListener, vyy
{
  private int jdField_a_of_type_Int = 1;
  protected Context a;
  private View jdField_a_of_type_AndroidViewView;
  protected EditText a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bjyh jdField_a_of_type_Bjyh;
  private bjyk jdField_a_of_type_Bjyk;
  private FitSystemWindowsRelativeLayout jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout;
  private String jdField_a_of_type_JavaLangString = "";
  vyu jdField_a_of_type_Vyu;
  private vzc jdField_a_of_type_Vzc;
  protected boolean a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  
  public bkop(@NonNull Context paramContext, @NonNull bjyh parambjyh, bjyk parambjyk, int paramInt)
  {
    super(paramContext, 2131755176);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bjyh = parambjyh;
    this.jdField_a_of_type_Bjyk = parambjyk;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void a()
  {
    Object localObject = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = bkht.b(getContext());
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
      int j = bbjw.b(paramCharSequence.toString());
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
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout = ((FitSystemWindowsRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375512));
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout.setFitsSystemWindows(true);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379335));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363006).setOnClickListener(this);
    this.jdField_a_of_type_Vyu = vyt.a(this.jdField_a_of_type_AndroidContentContext, 0, 0, null);
    this.jdField_a_of_type_Vyu.a(false);
    this.jdField_a_of_type_Vyu.a().b(ajyc.a(2131716862));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_Vyu.a();
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_Vyu.a(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131379327));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379336));
    if (this.jdField_a_of_type_Bjyk == null)
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Vzc = this.jdField_a_of_type_Vyu.a();
      this.jdField_a_of_type_Int = 1;
      a(this.jdField_a_of_type_Vzc.b(), true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Vzc.a(true);
      a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      return;
      if (this.jdField_b_of_type_Int >= 0) {
        break;
      }
      localObject = this.jdField_a_of_type_Vyu.a();
      i = 0;
      while (i < localObject.length)
      {
        localObject[i].a(this.jdField_a_of_type_Bjyk.a[i]);
        i += 1;
      }
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Vzc = this.jdField_a_of_type_Vyu.a();
      this.jdField_a_of_type_Int = 2;
      a(this.jdField_a_of_type_Vzc.a(), false);
    }
    localObject = this.jdField_a_of_type_Vyu.a();
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i].a(this.jdField_a_of_type_Bjyk.a[i]);
      i += 1;
    }
    if (this.jdField_b_of_type_Int == 0) {}
    for (this.jdField_a_of_type_Vzc = this.jdField_a_of_type_Vyu.a();; this.jdField_a_of_type_Vzc = this.jdField_a_of_type_Vyu.a(this.jdField_b_of_type_Int - 1))
    {
      this.jdField_a_of_type_Int = 3;
      a(this.jdField_a_of_type_Bjyk.a[this.jdField_b_of_type_Int], false);
      break;
    }
  }
  
  public void a(vyu paramvyu, vzc paramvzc)
  {
    if ((paramvzc instanceof vza))
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Vzc.a(false);
      this.jdField_a_of_type_Vzc = paramvzc;
      this.jdField_a_of_type_Vzc.a(true);
      if (this.jdField_a_of_type_Int != 1) {
        break label119;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Vzc.a())) {
        break label104;
      }
      a(this.jdField_a_of_type_Vzc.b(), true);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      return;
      if (!(paramvzc instanceof vyz)) {
        break;
      }
      this.jdField_b_of_type_Int = (((vyz)paramvzc).a() + 1);
      break;
      label104:
      a(this.jdField_a_of_type_Vzc.a(), false);
      continue;
      label119:
      a(this.jdField_a_of_type_Vzc.a(), false);
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_Vzc != null) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Vzc.a().toString();
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
    Object localObject = this.jdField_a_of_type_Vyu.a();
    int k = localObject.length;
    int i = 0;
    boolean bool = false;
    vzc[] arrayOfvzc;
    if (i < k)
    {
      arrayOfvzc = localObject[i];
      arrayOfvzc.a(false);
      if (((arrayOfvzc instanceof vyz)) && (TextUtils.isEmpty(arrayOfvzc.a()))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((arrayOfvzc instanceof vyz)) {
          bool = true;
        }
      }
    }
    localObject = this.jdField_a_of_type_Vyu.a();
    if (localObject != null)
    {
      arrayOfvzc = this.jdField_a_of_type_Vyu.a();
      Rect[] arrayOfRect = new Rect[arrayOfvzc.length];
      String[] arrayOfString = new String[arrayOfvzc.length];
      i = j;
      while (i < arrayOfvzc.length)
      {
        arrayOfRect[i] = arrayOfvzc[i].a();
        arrayOfString[i] = arrayOfvzc[i].a().toString();
        i += 1;
      }
      if (this.jdField_a_of_type_Bjyh != null) {
        this.jdField_a_of_type_Bjyh.a(arrayOfString, (Bitmap)localObject, arrayOfRect, bool);
      }
    }
    super.onDetachedFromWindow();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      if (this.jdField_a_of_type_Vzc != null)
      {
        paramTextView = this.jdField_a_of_type_AndroidWidgetEditText.getText();
        this.jdField_a_of_type_Vzc.a(paramTextView);
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return true;
      case 1: 
        if (this.jdField_b_of_type_Int < this.jdField_a_of_type_Vyu.a())
        {
          if (this.jdField_b_of_type_Int == this.jdField_a_of_type_Vyu.a() - 1)
          {
            dismiss();
            return true;
          }
          if (this.jdField_a_of_type_Vzc != null) {
            this.jdField_a_of_type_Vzc.a(false);
          }
          this.jdField_b_of_type_Int += 1;
          this.jdField_a_of_type_Vzc = this.jdField_a_of_type_Vyu.a(this.jdField_b_of_type_Int - 1);
          if (TextUtils.isEmpty(this.jdField_a_of_type_Vzc.a())) {
            a(this.jdField_a_of_type_Vzc.b(), true);
          }
          for (;;)
          {
            a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
            this.jdField_a_of_type_Vzc.a(true);
            return true;
            a(this.jdField_a_of_type_Vzc.a(), false);
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
      paramInt2 = bbjw.b(paramCharSequence.toString());
      if (paramInt1 - paramInt2 > 6) {
        break label171;
      }
      if (paramInt1 - paramInt2 >= 0) {
        break label185;
      }
      localObject = bbjw.b(paramCharSequence.toString(), 0, paramInt1);
      paramInt2 = bbjw.b(((CharSequence)localObject).toString());
      a((CharSequence)localObject, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s/%s", new Object[] { Integer.valueOf(paramInt2 / 2), Integer.valueOf(paramInt1 / 2) }));
      for (;;)
      {
        this.jdField_a_of_type_Vzc.a((CharSequence)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          a(this.jdField_a_of_type_Vzc.b(), true);
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
 * Qualified Name:     bkop
 * JD-Core Version:    0.7.0.1
 */