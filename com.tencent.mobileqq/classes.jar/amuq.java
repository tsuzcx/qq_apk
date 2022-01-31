import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;

class amuq
  implements DialogInterface.OnClickListener
{
  amuq(amup paramamup) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditText localEditText = (EditText)((bafb)paramDialogInterface).findViewById(2131304989);
    paramDialogInterface = (EditText)((bafb)paramDialogInterface).findViewById(2131296363);
    if ((TextUtils.isEmpty(localEditText.getText().toString())) || (TextUtils.isEmpty(paramDialogInterface.getText().toString())))
    {
      bbmy.a(this.a.a.getActivity(), 1, ajjy.a(2131636982), 0).a();
      return;
    }
    amvn localamvn = new amvn();
    localamvn.a = localEditText.getText().toString();
    localamvn.jdField_b_of_type_JavaLangString = paramDialogInterface.getText().toString();
    localamvn.jdField_b_of_type_Boolean = true;
    amvk.a().a(localamvn);
    this.a.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amuq
 * JD-Core Version:    0.7.0.1
 */