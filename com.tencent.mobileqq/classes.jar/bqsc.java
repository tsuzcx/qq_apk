import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public abstract class bqsc
  implements TextWatcher, TextView.OnEditorActionListener
{
  protected EditText a;
  protected TextView a;
  protected bqsd a;
  
  @NonNull
  public static bqsc a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("unSupport interactType:" + paramInt);
    }
    return new bqsf();
  }
  
  protected abstract View a();
  
  public abstract bqse a();
  
  public void a() {}
  
  public void a(Context paramContext, bqse parambqse, EditText paramEditText, TextView paramTextView, bqsd parambqsd)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_Bqsd = parambqsd;
  }
  
  protected void a(CharSequence paramCharSequence, int paramInt)
  {
    int i = bhsr.b(paramCharSequence.toString());
    if (paramInt - i <= 6)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s/%s", new Object[] { Integer.valueOf(i / 2), Integer.valueOf(paramInt / 2) }));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  protected void a(CharSequence paramCharSequence, boolean paramBoolean)
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
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqsc
 * JD-Core Version:    0.7.0.1
 */