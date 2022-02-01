import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.appstore.dl.DownloadManagerV2.19;
import com.tencent.open.downloadnew.DownloadInfo;

public class bjjt
  implements DialogInterface.OnClickListener
{
  public bjjt(DownloadManagerV2.19 param19) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      label6:
      paramDialogInterface = this.a.jdField_a_of_type_AndroidOsBundle.getString(bjmy.b);
      String str1 = this.a.jdField_a_of_type_AndroidOsBundle.getString(bjmy.j);
      String str2 = this.a.jdField_a_of_type_AndroidOsBundle.getString(bjmy.f);
      String str3 = this.a.jdField_a_of_type_AndroidOsBundle.getString(bjmy.i);
      String str4 = this.a.jdField_a_of_type_AndroidOsBundle.getString(bjmy.l);
      boolean bool = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean(bjmy.y, true);
      paramDialogInterface = new DownloadInfo(paramDialogInterface, str1.trim(), str2, str4, str3, null, this.a.jdField_a_of_type_JavaLangString, bool);
      this.a.this$0.a(10, paramDialogInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjjt
 * JD-Core Version:    0.7.0.1
 */