import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.widget.QQToast;

class arzd
  implements DialogInterface.OnClickListener
{
  arzd(arzc paramarzc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditText localEditText = (EditText)((bhpc)paramDialogInterface).findViewById(2131371654);
    paramDialogInterface = (EditText)((bhpc)paramDialogInterface).findViewById(2131361952);
    if ((TextUtils.isEmpty(localEditText.getText().toString())) || (TextUtils.isEmpty(paramDialogInterface.getText().toString())))
    {
      QQToast.a(this.a.a.getActivity(), 1, anzj.a(2131701675), 0).a();
      return;
    }
    asaa localasaa = new asaa();
    localasaa.a = localEditText.getText().toString();
    localasaa.jdField_b_of_type_JavaLangString = paramDialogInterface.getText().toString();
    localasaa.jdField_b_of_type_Boolean = true;
    arzx.a().a(localasaa);
    this.a.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzd
 * JD-Core Version:    0.7.0.1
 */