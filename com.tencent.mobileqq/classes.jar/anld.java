import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;

class anld
  implements DialogInterface.OnClickListener
{
  anld(anlc paramanlc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditText localEditText = (EditText)((bbgu)paramDialogInterface).findViewById(2131370655);
    paramDialogInterface = (EditText)((bbgu)paramDialogInterface).findViewById(2131361898);
    if ((TextUtils.isEmpty(localEditText.getText().toString())) || (TextUtils.isEmpty(paramDialogInterface.getText().toString())))
    {
      bcql.a(this.a.a.getActivity(), 1, ajya.a(2131702777), 0).a();
      return;
    }
    anma localanma = new anma();
    localanma.a = localEditText.getText().toString();
    localanma.jdField_b_of_type_JavaLangString = paramDialogInterface.getText().toString();
    localanma.jdField_b_of_type_Boolean = true;
    anlx.a().a(localanma);
    this.a.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anld
 * JD-Core Version:    0.7.0.1
 */