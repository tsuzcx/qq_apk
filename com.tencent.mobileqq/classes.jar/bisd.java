import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class bisd
  extends bisa
{
  private View jdField_a_of_type_AndroidViewView;
  private String jdField_a_of_type_JavaLangString = "";
  private vqp jdField_a_of_type_Vqp;
  protected boolean a;
  
  protected View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public bisc a()
  {
    return new bisc(this.jdField_a_of_type_Vqp.a(), this.jdField_a_of_type_Vqp.a(), this.jdField_a_of_type_Vqp.a(), this.jdField_a_of_type_Boolean);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Vqp.a(new String[] { this.jdField_a_of_type_AndroidWidgetEditText.getText().toString() });
    this.jdField_a_of_type_Vqp.c(false);
  }
  
  public void a(Context paramContext, bisc parambisc, EditText paramEditText, TextView paramTextView, bisb parambisb)
  {
    super.a(paramContext, parambisc, paramEditText, paramTextView, parambisb);
    this.jdField_a_of_type_Vqp = new vqp(paramContext);
    this.jdField_a_of_type_Vqp.b(false);
    this.jdField_a_of_type_Vqp.a(0.0F);
    this.jdField_a_of_type_Vqp.c(true);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Vqp.a();
    if (parambisc == null) {
      a(this.jdField_a_of_type_Vqp.a(), true);
    }
    for (;;)
    {
      a(paramEditText.getText().toString(), 24);
      return;
      this.jdField_a_of_type_Vqp.a(parambisc.a);
      a(parambisc.a[0], false);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_Vqp != null)
    {
      paramCharSequence = this.jdField_a_of_type_Vqp.a();
      if ((paramCharSequence != null) && (paramCharSequence.length > 0)) {
        this.jdField_a_of_type_JavaLangString = paramCharSequence[0];
      }
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      this.jdField_a_of_type_Vqp.a(new String[] { this.jdField_a_of_type_AndroidWidgetEditText.getText().toString() });
      this.jdField_a_of_type_Vqp.c(false);
      this.jdField_a_of_type_Bisb.a();
      return true;
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = baip.b(paramCharSequence.toString());
    if (24 - paramInt2 <= 6)
    {
      paramInt1 = paramInt2;
      Object localObject = paramCharSequence;
      if (24 - paramInt2 < 0)
      {
        localObject = baip.b(paramCharSequence.toString(), 0, 24);
        paramInt1 = baip.b(((CharSequence)localObject).toString());
        a((CharSequence)localObject, false);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s/%s", new Object[] { Integer.valueOf(paramInt1 / 2), Integer.valueOf(12) }));
      paramCharSequence = (CharSequence)localObject;
    }
    for (;;)
    {
      this.jdField_a_of_type_Vqp.a(new String[] { paramCharSequence.toString() });
      if (TextUtils.isEmpty(paramCharSequence)) {
        a(this.jdField_a_of_type_Vqp.a(), true);
      }
      if ((this.jdField_a_of_type_JavaLangString != null) && (!paramCharSequence.toString().equals(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Boolean = true;
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bisd
 * JD-Core Version:    0.7.0.1
 */