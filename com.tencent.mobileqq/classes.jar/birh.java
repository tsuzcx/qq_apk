import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.appcommon.now.download.js.DownloadJSApi.2;
import com.tencent.open.downloadnew.DownloadInfo;

public class birh
  implements DialogInterface.OnClickListener
{
  public birh(DownloadJSApi.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      label6:
      paramDialogInterface = this.a.jdField_a_of_type_AndroidOsBundle.getString(bivp.b);
      String str1 = this.a.jdField_a_of_type_AndroidOsBundle.getString(bivp.j);
      String str2 = this.a.jdField_a_of_type_AndroidOsBundle.getString(bivp.f);
      String str3 = this.a.jdField_a_of_type_AndroidOsBundle.getString(bivp.i);
      String str4 = this.a.jdField_a_of_type_AndroidOsBundle.getString(bivp.l);
      boolean bool = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean(bivp.y, true);
      paramDialogInterface = new DownloadInfo(paramDialogInterface, str1.trim(), str2, str4, str3, null, this.a.jdField_a_of_type_JavaLangString, bool);
      bivr.a().a(10, paramDialogInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     birh
 * JD-Core Version:    0.7.0.1
 */