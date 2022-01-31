import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.widget.QQToast;

class apgt
  implements DialogInterface.OnClickListener
{
  apgt(apgs paramapgs) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditText localEditText = (EditText)((bdjz)paramDialogInterface).findViewById(2131370985);
    paramDialogInterface = (EditText)((bdjz)paramDialogInterface).findViewById(2131361898);
    if ((TextUtils.isEmpty(localEditText.getText().toString())) || (TextUtils.isEmpty(paramDialogInterface.getText().toString())))
    {
      QQToast.a(this.a.a.getActivity(), 1, alud.a(2131703161), 0).a();
      return;
    }
    aphq localaphq = new aphq();
    localaphq.a = localEditText.getText().toString();
    localaphq.jdField_b_of_type_JavaLangString = paramDialogInterface.getText().toString();
    localaphq.jdField_b_of_type_Boolean = true;
    aphn.a().a(localaphq);
    this.a.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apgt
 * JD-Core Version:    0.7.0.1
 */