import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.10;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;

public class anjb
  implements DialogInterface.OnClickListener
{
  public anjb(ArkAppDownloadModule.10 param10) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = false;
    bkis.a().a(this.a.jdField_a_of_type_CooperationWadlIpcWadlParams);
    aniz.a(this.a.this$0, true);
    azqs.a(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "7", "", this.a.jdField_a_of_type_CooperationWadlIpcWadlParams.a, "");
    if ((paramDialogInterface instanceof bdjz))
    {
      if (!((bdjz)paramDialogInterface).getCheckBoxState()) {
        bool = true;
      }
      if (this.a.jdField_a_of_type_AndroidContentSharedPreferences == null) {}
    }
    try
    {
      this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.a.b, bool).apply();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("ark.download.module", 1, "start download sp error : ", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjb
 * JD-Core Version:    0.7.0.1
 */