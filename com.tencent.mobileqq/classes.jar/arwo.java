import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

class arwo
  implements DialogInterface.OnClickListener
{
  arwo(arwn paramarwn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditText localEditText = (EditText)((QQCustomDialog)paramDialogInterface).findViewById(2131371810);
    paramDialogInterface = (EditText)((QQCustomDialog)paramDialogInterface).findViewById(2131361954);
    if ((TextUtils.isEmpty(localEditText.getText().toString())) || (TextUtils.isEmpty(paramDialogInterface.getText().toString())))
    {
      QQToast.a(this.a.a.getActivity(), 1, anvx.a(2131702261), 0).a();
      return;
    }
    arxl localarxl = new arxl();
    localarxl.a = localEditText.getText().toString();
    localarxl.jdField_b_of_type_JavaLangString = paramDialogInterface.getText().toString();
    localarxl.jdField_b_of_type_Boolean = true;
    arxi.a().a(localarxl);
    this.a.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwo
 * JD-Core Version:    0.7.0.1
 */