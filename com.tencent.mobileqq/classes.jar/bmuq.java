import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class bmuq
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  bmuq(bmup parambmup) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = BaseApplicationImpl.getApplication().getRuntime();
    if (paramSharedPreferences != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged key = " + paramString);
      }
      if ((!bmup.a(this.a)) && (bmup.a(this.a) != null))
      {
        if (bmup.a(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bmup.a(this.a, bmup.a(this.a).getInt(paramString, 0));
        }
        if (bmup.b(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bmup.c(this.a, bmup.a(this.a).getString(paramString, null));
        }
        if (bmup.d(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bmup.e(this.a, bmup.a(this.a).getString(paramString, null));
        }
        if (QLog.isColorLevel()) {
          QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged value = " + bmup.a(this.a) + " personlizedYellowVipUrl = " + bmup.a(this.a));
        }
      }
      bmup.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmuq
 * JD-Core Version:    0.7.0.1
 */