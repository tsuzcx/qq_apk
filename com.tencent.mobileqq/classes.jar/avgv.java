import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class avgv
  implements DialogInterface.OnClickListener
{
  avgv(avgk paramavgk, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramDialogInterface = new Intent();
      paramDialogInterface.setAction("android.intent.action.VIEW");
      paramDialogInterface.setData(Uri.parse(avgk.a(this.jdField_a_of_type_Avgk).guideAppNowJumpUri));
      this.jdField_a_of_type_Avgk.a.startActivity(paramDialogInterface);
      return;
    }
    if ("com.tencent.now".equals(avgk.a(this.jdField_a_of_type_Avgk).guideAppNowPackage))
    {
      paramDialogInterface = BaseApplicationImpl.getContext().getSharedPreferences("now_down_apk", 4);
      if (paramDialogInterface.getInt("state", 0) == 1) {
        try
        {
          arpg.a(paramDialogInterface.getString("filePath", ""));
          paramDialogInterface.edit().putInt("state", 0).apply();
          return;
        }
        catch (Exception paramDialogInterface)
        {
          QLog.e("NearbyProfileDisplayPanel", 1, paramDialogInterface, new Object[0]);
          this.jdField_a_of_type_Avgk.a(avgk.a(this.jdField_a_of_type_Avgk).guideAppNowDownloadUrl, "now.apk", "now_down_apk");
          return;
        }
      }
      this.jdField_a_of_type_Avgk.a(avgk.a(this.jdField_a_of_type_Avgk).guideAppNowDownloadUrl, "now.apk", "now_down_apk");
      return;
    }
    paramDialogInterface = avgk.a(this.jdField_a_of_type_Avgk).guideAppNowPackage.replaceAll("\\.", "_") + "_apk";
    String str = avgk.a(this.jdField_a_of_type_Avgk).guideAppNowPackage.replaceAll("\\.", "_") + ".apk";
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences(paramDialogInterface, 4);
    if (localSharedPreferences.getInt("state", 0) == 1) {
      try
      {
        arpg.a(localSharedPreferences.getString("filePath", ""));
        localSharedPreferences.edit().putInt("state", 0).apply();
        return;
      }
      catch (Exception localException)
      {
        QLog.e("NearbyProfileDisplayPanel", 1, localException, new Object[0]);
        this.jdField_a_of_type_Avgk.a(avgk.a(this.jdField_a_of_type_Avgk).guideAppNowDownloadUrl, str, paramDialogInterface);
        return;
      }
    }
    this.jdField_a_of_type_Avgk.a(avgk.a(this.jdField_a_of_type_Avgk).guideAppNowDownloadUrl, str, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avgv
 * JD-Core Version:    0.7.0.1
 */