import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class bgzy
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  bgzy(bgzx parambgzx) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = BaseApplicationImpl.getApplication().getRuntime();
    if (paramSharedPreferences != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged key = " + paramString);
      }
      if ((!bgzx.a(this.a)) && (bgzx.a(this.a) != null))
      {
        if (bgzx.a(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bgzx.a(this.a, bgzx.a(this.a).getInt(paramString, 0));
        }
        if (bgzx.b(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bgzx.c(this.a, bgzx.a(this.a).getString(paramString, null));
        }
        if (bgzx.d(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bgzx.e(this.a, bgzx.a(this.a).getString(paramString, null));
        }
        if (QLog.isColorLevel()) {
          QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged value = " + bgzx.a(this.a) + " personlizedYellowVipUrl = " + bgzx.a(this.a));
        }
      }
      bgzx.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgzy
 * JD-Core Version:    0.7.0.1
 */