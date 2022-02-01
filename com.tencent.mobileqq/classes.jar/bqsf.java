import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class bqsf
  extends bqsc
{
  private View jdField_a_of_type_AndroidViewView;
  private String jdField_a_of_type_JavaLangString = "";
  private ztp jdField_a_of_type_Ztp;
  protected boolean a;
  
  protected View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public bqse a()
  {
    return new bqse(this.jdField_a_of_type_Ztp.a(), this.jdField_a_of_type_Ztp.a(), this.jdField_a_of_type_Ztp.a(), this.jdField_a_of_type_Boolean);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ztp.a(new String[] { this.jdField_a_of_type_AndroidWidgetEditText.getText().toString() });
    this.jdField_a_of_type_Ztp.c(false);
  }
  
  public void a(Context paramContext, bqse parambqse, EditText paramEditText, TextView paramTextView, bqsd parambqsd)
  {
    super.a(paramContext, parambqse, paramEditText, paramTextView, parambqsd);
    this.jdField_a_of_type_Ztp = new ztp(paramContext);
    this.jdField_a_of_type_Ztp.b(false);
    this.jdField_a_of_type_Ztp.a(0.0F);
    this.jdField_a_of_type_Ztp.c(true);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Ztp.a();
    if (parambqse == null) {
      a(this.jdField_a_of_type_Ztp.a(), true);
    }
    for (;;)
    {
      a(paramEditText.getText().toString(), 24);
      return;
      this.jdField_a_of_type_Ztp.a(parambqse.a);
      a(parambqse.a[0], false);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_Ztp != null)
    {
      paramCharSequence = this.jdField_a_of_type_Ztp.a();
      if ((paramCharSequence != null) && (paramCharSequence.length > 0)) {
        this.jdField_a_of_type_JavaLangString = paramCharSequence[0];
      }
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      this.jdField_a_of_type_Ztp.a(new String[] { this.jdField_a_of_type_AndroidWidgetEditText.getText().toString() });
      this.jdField_a_of_type_Ztp.c(false);
      this.jdField_a_of_type_Bqsd.a();
      return true;
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = bhsr.b(paramCharSequence.toString());
    if (24 - paramInt2 <= 6)
    {
      paramInt1 = paramInt2;
      Object localObject = paramCharSequence;
      if (24 - paramInt2 < 0)
      {
        localObject = bhsr.b(paramCharSequence.toString(), 0, 24);
        paramInt1 = bhsr.b(((CharSequence)localObject).toString());
        a((CharSequence)localObject, false);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s/%s", new Object[] { Integer.valueOf(paramInt1 / 2), Integer.valueOf(12) }));
      paramCharSequence = (CharSequence)localObject;
    }
    for (;;)
    {
      this.jdField_a_of_type_Ztp.a(new String[] { paramCharSequence.toString() });
      if (TextUtils.isEmpty(paramCharSequence)) {
        a(this.jdField_a_of_type_Ztp.a(), true);
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
 * Qualified Name:     bqsf
 * JD-Core Version:    0.7.0.1
 */