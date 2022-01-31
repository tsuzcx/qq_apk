import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnShowListener;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.widget.XEditText;
import com.tencent.widget.XEditTextEx;

public class bmyu
  extends Dialog
  implements TextWatcher, View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private DialogInterface.OnShowListener jdField_a_of_type_AndroidContentDialogInterface$OnShowListener;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bmnj jdField_a_of_type_Bmnj;
  XEditText jdField_a_of_type_ComTencentWidgetXEditText;
  String jdField_a_of_type_JavaLangString;
  private wjq jdField_a_of_type_Wjq;
  
  public bmyu(@NonNull Context paramContext, bmnj parambmnj)
  {
    super(paramContext, 2131755180);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bmnj = parambmnj;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditText.getText().toString();
  }
  
  public void a()
  {
    Window localWindow = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = xin.b(getContext());
    localLayoutParams.flags |= 0x20;
    localLayoutParams.gravity = 80;
    localWindow.setAttributes(localLayoutParams);
    localWindow.setSoftInputMode(34);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131561435, null));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditText = ((XEditTextEx)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365837));
    this.jdField_a_of_type_ComTencentWidgetXEditText.addTextChangedListener(this);
    setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_Wjq = new wjq(getContext(), this.jdField_a_of_type_AndroidViewViewGroup, new bmyv(this));
    this.jdField_a_of_type_Wjq.a(this.jdField_a_of_type_AndroidContentContext.getString(2131690626));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    super.setOnShowListener(new bmyw(this, paramBoolean));
    super.show();
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditText.setText(paramString);
      this.jdField_a_of_type_ComTencentWidgetXEditText.setSelection(paramString.length());
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXEditText.setText(this.jdField_a_of_type_JavaLangString);
    paramString = this.jdField_a_of_type_ComTencentWidgetXEditText;
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaLangString.length())
    {
      paramString.setSelection(i);
      return;
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void dismiss()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentWidgetXEditText.getText().toString();
    this.jdField_a_of_type_Wjq.c();
    this.jdField_a_of_type_Wjq.a();
    if (isShowing()) {
      super.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    dismiss();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setOnShowListener(DialogInterface.OnShowListener paramOnShowListener)
  {
    super.setOnShowListener(paramOnShowListener);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnShowListener = paramOnShowListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyu
 * JD-Core Version:    0.7.0.1
 */