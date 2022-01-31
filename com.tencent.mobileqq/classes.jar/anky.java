import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;

class anky
  implements DialogInterface.OnClickListener
{
  anky(ankx paramankx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditText localEditText = (EditText)((bbgg)paramDialogInterface).findViewById(2131370655);
    paramDialogInterface = (EditText)((bbgg)paramDialogInterface).findViewById(2131361899);
    if ((TextUtils.isEmpty(localEditText.getText().toString())) || (TextUtils.isEmpty(paramDialogInterface.getText().toString())))
    {
      bcpw.a(this.a.a.getActivity(), 1, ajyc.a(2131702766), 0).a();
      return;
    }
    anlv localanlv = new anlv();
    localanlv.a = localEditText.getText().toString();
    localanlv.jdField_b_of_type_JavaLangString = paramDialogInterface.getText().toString();
    localanlv.jdField_b_of_type_Boolean = true;
    anls.a().a(localanlv);
    this.a.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anky
 * JD-Core Version:    0.7.0.1
 */