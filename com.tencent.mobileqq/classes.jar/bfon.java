import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager.17;

public class bfon
  implements DialogInterface.OnClickListener
{
  public bfon(DownloadManager.17 param17) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      label6:
      paramDialogInterface = this.a.jdField_a_of_type_AndroidOsBundle.getString(bfoh.b);
      String str1 = this.a.jdField_a_of_type_AndroidOsBundle.getString(bfoh.j);
      String str2 = this.a.jdField_a_of_type_AndroidOsBundle.getString(bfoh.f);
      String str3 = this.a.jdField_a_of_type_AndroidOsBundle.getString(bfoh.i);
      String str4 = this.a.jdField_a_of_type_AndroidOsBundle.getString(bfoh.l);
      boolean bool = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean(bfoh.y, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfon
 * JD-Core Version:    0.7.0.1
 */