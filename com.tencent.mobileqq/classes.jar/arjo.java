import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.widget.QQToast;

class arjo
  implements DialogInterface.OnClickListener
{
  arjo(arjn paramarjn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditText localEditText = (EditText)((bgpa)paramDialogInterface).findViewById(2131371546);
    paramDialogInterface = (EditText)((bgpa)paramDialogInterface).findViewById(2131361952);
    if ((TextUtils.isEmpty(localEditText.getText().toString())) || (TextUtils.isEmpty(paramDialogInterface.getText().toString())))
    {
      QQToast.a(this.a.a.getActivity(), 1, anni.a(2131701568), 0).a();
      return;
    }
    arkl localarkl = new arkl();
    localarkl.a = localEditText.getText().toString();
    localarkl.jdField_b_of_type_JavaLangString = paramDialogInterface.getText().toString();
    localarkl.jdField_b_of_type_Boolean = true;
    arki.a().a(localarkl);
    this.a.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjo
 * JD-Core Version:    0.7.0.1
 */