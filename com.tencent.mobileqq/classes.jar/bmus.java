import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class bmus
  extends bmup
{
  private View jdField_a_of_type_AndroidViewView;
  private String jdField_a_of_type_JavaLangString = "";
  private xsa jdField_a_of_type_Xsa;
  protected boolean a;
  
  protected View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public bmur a()
  {
    return new bmur(this.jdField_a_of_type_Xsa.a(), this.jdField_a_of_type_Xsa.a(), this.jdField_a_of_type_Xsa.a(), this.jdField_a_of_type_Boolean);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xsa.a(new String[] { this.jdField_a_of_type_AndroidWidgetEditText.getText().toString() });
    this.jdField_a_of_type_Xsa.c(false);
  }
  
  public void a(Context paramContext, bmur parambmur, EditText paramEditText, TextView paramTextView, bmuq parambmuq)
  {
    super.a(paramContext, parambmur, paramEditText, paramTextView, parambmuq);
    this.jdField_a_of_type_Xsa = new xsa(paramContext);
    this.jdField_a_of_type_Xsa.b(false);
    this.jdField_a_of_type_Xsa.a(0.0F);
    this.jdField_a_of_type_Xsa.c(true);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Xsa.a();
    if (parambmur == null) {
      a(this.jdField_a_of_type_Xsa.a(), true);
    }
    for (;;)
    {
      a(paramEditText.getText().toString(), 24);
      return;
      this.jdField_a_of_type_Xsa.a(parambmur.a);
      a(parambmur.a[0], false);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_Xsa != null)
    {
      paramCharSequence = this.jdField_a_of_type_Xsa.a();
      if ((paramCharSequence != null) && (paramCharSequence.length > 0)) {
        this.jdField_a_of_type_JavaLangString = paramCharSequence[0];
      }
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      this.jdField_a_of_type_Xsa.a(new String[] { this.jdField_a_of_type_AndroidWidgetEditText.getText().toString() });
      this.jdField_a_of_type_Xsa.c(false);
      this.jdField_a_of_type_Bmuq.a();
      return true;
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = bdje.b(paramCharSequence.toString());
    if (24 - paramInt2 <= 6)
    {
      paramInt1 = paramInt2;
      Object localObject = paramCharSequence;
      if (24 - paramInt2 < 0)
      {
        localObject = bdje.b(paramCharSequence.toString(), 0, 24);
        paramInt1 = bdje.b(((CharSequence)localObject).toString());
        a((CharSequence)localObject, false);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s/%s", new Object[] { Integer.valueOf(paramInt1 / 2), Integer.valueOf(12) }));
      paramCharSequence = (CharSequence)localObject;
    }
    for (;;)
    {
      this.jdField_a_of_type_Xsa.a(new String[] { paramCharSequence.toString() });
      if (TextUtils.isEmpty(paramCharSequence)) {
        a(this.jdField_a_of_type_Xsa.a(), true);
      }
      if ((this.jdField_a_of_type_JavaLangString != null) && (!paramCharSequence.toString().equals(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Boolean = true;
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmus
 * JD-Core Version:    0.7.0.1
 */