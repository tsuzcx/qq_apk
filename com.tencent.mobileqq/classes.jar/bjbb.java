import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class bjbb
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  bjbb(bjba parambjba) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = BaseApplicationImpl.getApplication().getRuntime();
    if (paramSharedPreferences != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged key = " + paramString);
      }
      if ((!bjba.a(this.a)) && (bjba.a(this.a) != null))
      {
        if (bjba.a(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bjba.a(this.a, bjba.a(this.a).getInt(paramString, 0));
        }
        if (bjba.b(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bjba.c(this.a, bjba.a(this.a).getString(paramString, null));
        }
        if (bjba.d(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bjba.e(this.a, bjba.a(this.a).getString(paramString, null));
        }
        if (QLog.isColorLevel()) {
          QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged value = " + bjba.a(this.a) + " personlizedYellowVipUrl = " + bjba.a(this.a));
        }
      }
      bjba.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjbb
 * JD-Core Version:    0.7.0.1
 */