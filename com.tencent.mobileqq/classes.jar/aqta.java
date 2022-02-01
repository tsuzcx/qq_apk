import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

class aqta
  implements DialogInterface.OnClickListener
{
  aqta(aqsz paramaqsz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditText localEditText = (EditText)((QQCustomDialog)paramDialogInterface).findViewById(2131371622);
    paramDialogInterface = (EditText)((QQCustomDialog)paramDialogInterface).findViewById(2131361952);
    if ((TextUtils.isEmpty(localEditText.getText().toString())) || (TextUtils.isEmpty(paramDialogInterface.getText().toString())))
    {
      QQToast.a(this.a.a.getActivity(), 1, amtj.a(2131701910), 0).a();
      return;
    }
    aqtx localaqtx = new aqtx();
    localaqtx.a = localEditText.getText().toString();
    localaqtx.jdField_b_of_type_JavaLangString = paramDialogInterface.getText().toString();
    localaqtx.jdField_b_of_type_Boolean = true;
    aqtu.a().a(localaqtx);
    this.a.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqta
 * JD-Core Version:    0.7.0.1
 */