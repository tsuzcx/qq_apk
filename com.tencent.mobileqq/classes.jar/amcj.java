import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneVipInfoManager;
import mqq.app.AppRuntime;

public class amcj
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  public amcj(QZoneVipInfoManager paramQZoneVipInfoManager) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = BaseApplicationImpl.getApplication().getRuntime();
    if (paramSharedPreferences != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged key = " + paramString);
      }
      if ((!QZoneVipInfoManager.a(this.a)) && (QZoneVipInfoManager.a(this.a) != null))
      {
        if (QZoneVipInfoManager.a(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          QZoneVipInfoManager.a(this.a, QZoneVipInfoManager.a(this.a).getInt(paramString, 0));
        }
        if (QZoneVipInfoManager.b(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          QZoneVipInfoManager.c(this.a, QZoneVipInfoManager.a(this.a).getString(paramString, null));
        }
        if (QLog.isColorLevel()) {
          QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged value = " + QZoneVipInfoManager.a(this.a) + " personlizedYellowVipUrl = " + QZoneVipInfoManager.a(this.a));
        }
      }
      QZoneVipInfoManager.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amcj
 * JD-Core Version:    0.7.0.1
 */