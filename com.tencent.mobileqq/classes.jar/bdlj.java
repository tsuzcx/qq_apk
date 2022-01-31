import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput.3;
import com.tencent.mobileqq.widget.ClearableEditText;
import java.lang.ref.SoftReference;
import java.util.Timer;

public class bdlj
  extends bdjz
{
  private long jdField_a_of_type_Long;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private SoftReference<Context> jdField_a_of_type_JavaLangRefSoftReference;
  
  public bdlj(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramContext);
  }
  
  public EditText a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  }
  
  public void a(TextWatcher paramTextWatcher)
  {
    if (paramTextWatcher != null)
    {
      this.jdField_a_of_type_AndroidTextTextWatcher = paramTextWatcher;
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(paramTextWatcher);
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(paramString);
    }
  }
  
  public String getInputValue()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131368343));
  }
  
  public bdjz setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new bdlk(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public void show()
  {
    super.show();
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText();
    if ((localEditable instanceof Spannable)) {
      Selection.setSelection((Spannable)localEditable, localEditable.length());
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.isFocusable()) || (this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.isFocusableInTouchMode())) {
      new Timer().schedule(new QQCustomDialogWtihInput.3(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdlj
 * JD-Core Version:    0.7.0.1
 */