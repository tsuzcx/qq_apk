import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class bmze
  extends bmzb
{
  private View jdField_a_of_type_AndroidViewView;
  private String jdField_a_of_type_JavaLangString = "";
  private xwj jdField_a_of_type_Xwj;
  protected boolean a;
  
  protected View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public bmzd a()
  {
    return new bmzd(this.jdField_a_of_type_Xwj.a(), this.jdField_a_of_type_Xwj.a(), this.jdField_a_of_type_Xwj.a(), this.jdField_a_of_type_Boolean);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xwj.a(new String[] { this.jdField_a_of_type_AndroidWidgetEditText.getText().toString() });
    this.jdField_a_of_type_Xwj.c(false);
  }
  
  public void a(Context paramContext, bmzd parambmzd, EditText paramEditText, TextView paramTextView, bmzc parambmzc)
  {
    super.a(paramContext, parambmzd, paramEditText, paramTextView, parambmzc);
    this.jdField_a_of_type_Xwj = new xwj(paramContext);
    this.jdField_a_of_type_Xwj.b(false);
    this.jdField_a_of_type_Xwj.a(0.0F);
    this.jdField_a_of_type_Xwj.c(true);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Xwj.a();
    if (parambmzd == null) {
      a(this.jdField_a_of_type_Xwj.a(), true);
    }
    for (;;)
    {
      a(paramEditText.getText().toString(), 24);
      return;
      this.jdField_a_of_type_Xwj.a(parambmzd.a);
      a(parambmzd.a[0], false);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_Xwj != null)
    {
      paramCharSequence = this.jdField_a_of_type_Xwj.a();
      if ((paramCharSequence != null) && (paramCharSequence.length > 0)) {
        this.jdField_a_of_type_JavaLangString = paramCharSequence[0];
      }
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      this.jdField_a_of_type_Xwj.a(new String[] { this.jdField_a_of_type_AndroidWidgetEditText.getText().toString() });
      this.jdField_a_of_type_Xwj.c(false);
      this.jdField_a_of_type_Bmzc.a();
      return true;
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = bdnn.b(paramCharSequence.toString());
    if (24 - paramInt2 <= 6)
    {
      paramInt1 = paramInt2;
      Object localObject = paramCharSequence;
      if (24 - paramInt2 < 0)
      {
        localObject = bdnn.b(paramCharSequence.toString(), 0, 24);
        paramInt1 = bdnn.b(((CharSequence)localObject).toString());
        a((CharSequence)localObject, false);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s/%s", new Object[] { Integer.valueOf(paramInt1 / 2), Integer.valueOf(12) }));
      paramCharSequence = (CharSequence)localObject;
    }
    for (;;)
    {
      this.jdField_a_of_type_Xwj.a(new String[] { paramCharSequence.toString() });
      if (TextUtils.isEmpty(paramCharSequence)) {
        a(this.jdField_a_of_type_Xwj.a(), true);
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
 * Qualified Name:     bmze
 * JD-Core Version:    0.7.0.1
 */