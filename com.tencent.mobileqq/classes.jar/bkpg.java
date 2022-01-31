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

public class bkpg
  extends Dialog
  implements TextWatcher, View.OnClickListener, TextView.OnEditorActionListener, vyv
{
  private int jdField_a_of_type_Int = 1;
  protected Context a;
  private View jdField_a_of_type_AndroidViewView;
  protected EditText a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bjyy jdField_a_of_type_Bjyy;
  private bjzb jdField_a_of_type_Bjzb;
  private FitSystemWindowsRelativeLayout jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout;
  private String jdField_a_of_type_JavaLangString = "";
  vyr jdField_a_of_type_Vyr;
  private vyz jdField_a_of_type_Vyz;
  protected boolean a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  
  public bkpg(@NonNull Context paramContext, @NonNull bjyy parambjyy, bjzb parambjzb, int paramInt)
  {
    super(paramContext, 2131755176);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bjyy = parambjyy;
    this.jdField_a_of_type_Bjzb = parambjzb;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void a()
  {
    Object localObject = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = bkik.b(getContext());
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
      int j = bbkk.b(paramCharSequence.toString());
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
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout = ((FitSystemWindowsRelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375514));
    this.jdField_a_of_type_ComTencentWidgetFitSystemWindowsRelativeLayout.setFitsSystemWindows(true);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379340));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363005).setOnClickListener(this);
    this.jdField_a_of_type_Vyr = vyq.a(this.jdField_a_of_type_AndroidContentContext, 0, 0, null);
    this.jdField_a_of_type_Vyr.a(false);
    this.jdField_a_of_type_Vyr.a().b(ajya.a(2131716873));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_Vyr.a();
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_Vyr.a(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131379332));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379341));
    if (this.jdField_a_of_type_Bjzb == null)
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Vyz = this.jdField_a_of_type_Vyr.a();
      this.jdField_a_of_type_Int = 1;
      a(this.jdField_a_of_type_Vyz.b(), true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Vyz.a(true);
      a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      return;
      if (this.jdField_b_of_type_Int >= 0) {
        break;
      }
      localObject = this.jdField_a_of_type_Vyr.a();
      i = 0;
      while (i < localObject.length)
      {
        localObject[i].a(this.jdField_a_of_type_Bjzb.a[i]);
        i += 1;
      }
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Vyz = this.jdField_a_of_type_Vyr.a();
      this.jdField_a_of_type_Int = 2;
      a(this.jdField_a_of_type_Vyz.a(), false);
    }
    localObject = this.jdField_a_of_type_Vyr.a();
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i].a(this.jdField_a_of_type_Bjzb.a[i]);
      i += 1;
    }
    if (this.jdField_b_of_type_Int == 0) {}
    for (this.jdField_a_of_type_Vyz = this.jdField_a_of_type_Vyr.a();; this.jdField_a_of_type_Vyz = this.jdField_a_of_type_Vyr.a(this.jdField_b_of_type_Int - 1))
    {
      this.jdField_a_of_type_Int = 3;
      a(this.jdField_a_of_type_Bjzb.a[this.jdField_b_of_type_Int], false);
      break;
    }
  }
  
  public void a(vyr paramvyr, vyz paramvyz)
  {
    if ((paramvyz instanceof vyx))
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Vyz.a(false);
      this.jdField_a_of_type_Vyz = paramvyz;
      this.jdField_a_of_type_Vyz.a(true);
      if (this.jdField_a_of_type_Int != 1) {
        break label119;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Vyz.a())) {
        break label104;
      }
      a(this.jdField_a_of_type_Vyz.b(), true);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      return;
      if (!(paramvyz instanceof vyw)) {
        break;
      }
      this.jdField_b_of_type_Int = (((vyw)paramvyz).a() + 1);
      break;
      label104:
      a(this.jdField_a_of_type_Vyz.a(), false);
      continue;
      label119:
      a(this.jdField_a_of_type_Vyz.a(), false);
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_Vyz != null) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Vyz.a().toString();
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
    Object localObject = this.jdField_a_of_type_Vyr.a();
    int k = localObject.length;
    int i = 0;
    boolean bool = false;
    vyz[] arrayOfvyz;
    if (i < k)
    {
      arrayOfvyz = localObject[i];
      arrayOfvyz.a(false);
      if (((arrayOfvyz instanceof vyw)) && (TextUtils.isEmpty(arrayOfvyz.a()))) {}
      for (;;)
      {
        i += 1;
        break;
        if ((arrayOfvyz instanceof vyw)) {
          bool = true;
        }
      }
    }
    localObject = this.jdField_a_of_type_Vyr.a();
    if (localObject != null)
    {
      arrayOfvyz = this.jdField_a_of_type_Vyr.a();
      Rect[] arrayOfRect = new Rect[arrayOfvyz.length];
      String[] arrayOfString = new String[arrayOfvyz.length];
      i = j;
      while (i < arrayOfvyz.length)
      {
        arrayOfRect[i] = arrayOfvyz[i].a();
        arrayOfString[i] = arrayOfvyz[i].a().toString();
        i += 1;
      }
      if (this.jdField_a_of_type_Bjyy != null) {
        this.jdField_a_of_type_Bjyy.a(arrayOfString, (Bitmap)localObject, arrayOfRect, bool);
      }
    }
    super.onDetachedFromWindow();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      if (this.jdField_a_of_type_Vyz != null)
      {
        paramTextView = this.jdField_a_of_type_AndroidWidgetEditText.getText();
        this.jdField_a_of_type_Vyz.a(paramTextView);
      }
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return true;
      case 1: 
        if (this.jdField_b_of_type_Int < this.jdField_a_of_type_Vyr.a())
        {
          if (this.jdField_b_of_type_Int == this.jdField_a_of_type_Vyr.a() - 1)
          {
            dismiss();
            return true;
          }
          if (this.jdField_a_of_type_Vyz != null) {
            this.jdField_a_of_type_Vyz.a(false);
          }
          this.jdField_b_of_type_Int += 1;
          this.jdField_a_of_type_Vyz = this.jdField_a_of_type_Vyr.a(this.jdField_b_of_type_Int - 1);
          if (TextUtils.isEmpty(this.jdField_a_of_type_Vyz.a())) {
            a(this.jdField_a_of_type_Vyz.b(), true);
          }
          for (;;)
          {
            a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
            this.jdField_a_of_type_Vyz.a(true);
            return true;
            a(this.jdField_a_of_type_Vyz.a(), false);
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
      paramInt2 = bbkk.b(paramCharSequence.toString());
      if (paramInt1 - paramInt2 > 6) {
        break label171;
      }
      if (paramInt1 - paramInt2 >= 0) {
        break label185;
      }
      localObject = bbkk.b(paramCharSequence.toString(), 0, paramInt1);
      paramInt2 = bbkk.b(((CharSequence)localObject).toString());
      a((CharSequence)localObject, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s/%s", new Object[] { Integer.valueOf(paramInt2 / 2), Integer.valueOf(paramInt1 / 2) }));
      for (;;)
      {
        this.jdField_a_of_type_Vyz.a((CharSequence)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          a(this.jdField_a_of_type_Vyz.b(), true);
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
 * Qualified Name:     bkpg
 * JD-Core Version:    0.7.0.1
 */