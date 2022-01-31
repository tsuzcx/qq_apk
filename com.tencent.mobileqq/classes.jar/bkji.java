import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class bkji
  extends bkjf
{
  private View jdField_a_of_type_AndroidViewView;
  private String jdField_a_of_type_JavaLangString = "";
  private wdi jdField_a_of_type_Wdi;
  protected boolean a;
  
  protected View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public bkjh a()
  {
    return new bkjh(this.jdField_a_of_type_Wdi.a(), this.jdField_a_of_type_Wdi.a(), this.jdField_a_of_type_Wdi.a(), this.jdField_a_of_type_Boolean);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wdi.a(new String[] { this.jdField_a_of_type_AndroidWidgetEditText.getText().toString() });
    this.jdField_a_of_type_Wdi.c(false);
  }
  
  public void a(Context paramContext, bkjh parambkjh, EditText paramEditText, TextView paramTextView, bkjg parambkjg)
  {
    super.a(paramContext, parambkjh, paramEditText, paramTextView, parambkjg);
    this.jdField_a_of_type_Wdi = new wdi(paramContext);
    this.jdField_a_of_type_Wdi.b(false);
    this.jdField_a_of_type_Wdi.a(0.0F);
    this.jdField_a_of_type_Wdi.c(true);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Wdi.a();
    if (parambkjh == null) {
      a(this.jdField_a_of_type_Wdi.a(), true);
    }
    for (;;)
    {
      a(paramEditText.getText().toString(), 24);
      return;
      this.jdField_a_of_type_Wdi.a(parambkjh.a);
      a(parambkjh.a[0], false);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_Wdi != null)
    {
      paramCharSequence = this.jdField_a_of_type_Wdi.a();
      if ((paramCharSequence != null) && (paramCharSequence.length > 0)) {
        this.jdField_a_of_type_JavaLangString = paramCharSequence[0];
      }
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      this.jdField_a_of_type_Wdi.a(new String[] { this.jdField_a_of_type_AndroidWidgetEditText.getText().toString() });
      this.jdField_a_of_type_Wdi.c(false);
      this.jdField_a_of_type_Bkjg.a();
      return true;
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = bbkk.b(paramCharSequence.toString());
    if (24 - paramInt2 <= 6)
    {
      paramInt1 = paramInt2;
      Object localObject = paramCharSequence;
      if (24 - paramInt2 < 0)
      {
        localObject = bbkk.b(paramCharSequence.toString(), 0, 24);
        paramInt1 = bbkk.b(((CharSequence)localObject).toString());
        a((CharSequence)localObject, false);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s/%s", new Object[] { Integer.valueOf(paramInt1 / 2), Integer.valueOf(12) }));
      paramCharSequence = (CharSequence)localObject;
    }
    for (;;)
    {
      this.jdField_a_of_type_Wdi.a(new String[] { paramCharSequence.toString() });
      if (TextUtils.isEmpty(paramCharSequence)) {
        a(this.jdField_a_of_type_Wdi.a(), true);
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
 * Qualified Name:     bkji
 * JD-Core Version:    0.7.0.1
 */