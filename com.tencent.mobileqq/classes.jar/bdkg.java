import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public final class bdkg
  implements DialogInterface.OnClickListener
{
  public bdkg(boolean paramBoolean, Context paramContext, String paramString1, String paramString2, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      paramDialogInterface = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", String.format(aguq.jdField_a_of_type_JavaLangString, new Object[] { this.jdField_a_of_type_JavaLangString, "group_aio_popup" }));
      paramDialogInterface.putExtra("hide_operation_bar", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramDialogInterface);
    }
    for (;;)
    {
      azmj.b(null, "dc00898", "", "", "qq_vip", this.b, this.jdField_a_of_type_Int, 0, "", "", "", "");
      return;
      alzw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, "group_aio_popup");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkg
 * JD-Core Version:    0.7.0.1
 */