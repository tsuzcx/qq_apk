import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager.17;

public class bdks
  implements DialogInterface.OnClickListener
{
  public bdks(DownloadManager.17 param17) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      label6:
      paramDialogInterface = this.a.jdField_a_of_type_AndroidOsBundle.getString(bdkm.b);
      String str1 = this.a.jdField_a_of_type_AndroidOsBundle.getString(bdkm.j);
      String str2 = this.a.jdField_a_of_type_AndroidOsBundle.getString(bdkm.f);
      String str3 = this.a.jdField_a_of_type_AndroidOsBundle.getString(bdkm.i);
      String str4 = this.a.jdField_a_of_type_AndroidOsBundle.getString(bdkm.l);
      boolean bool = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean(bdkm.y, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdks
 * JD-Core Version:    0.7.0.1
 */