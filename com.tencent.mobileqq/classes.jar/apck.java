import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.widget.QQToast;

class apck
  implements DialogInterface.OnClickListener
{
  apck(apcj paramapcj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditText localEditText = (EditText)((bdfq)paramDialogInterface).findViewById(2131370966);
    paramDialogInterface = (EditText)((bdfq)paramDialogInterface).findViewById(2131361898);
    if ((TextUtils.isEmpty(localEditText.getText().toString())) || (TextUtils.isEmpty(paramDialogInterface.getText().toString())))
    {
      QQToast.a(this.a.a.getActivity(), 1, alpo.a(2131703149), 0).a();
      return;
    }
    apdh localapdh = new apdh();
    localapdh.a = localEditText.getText().toString();
    localapdh.jdField_b_of_type_JavaLangString = paramDialogInterface.getText().toString();
    localapdh.jdField_b_of_type_Boolean = true;
    apde.a().a(localapdh);
    this.a.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apck
 * JD-Core Version:    0.7.0.1
 */