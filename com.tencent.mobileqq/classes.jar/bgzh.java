import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class bgzh
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  bgzh(bgzg parambgzg) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = BaseApplicationImpl.getApplication().getRuntime();
    if (paramSharedPreferences != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged key = " + paramString);
      }
      if ((!bgzg.a(this.a)) && (bgzg.a(this.a) != null))
      {
        if (bgzg.a(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bgzg.a(this.a, bgzg.a(this.a).getInt(paramString, 0));
        }
        if (bgzg.b(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bgzg.c(this.a, bgzg.a(this.a).getString(paramString, null));
        }
        if (bgzg.d(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bgzg.e(this.a, bgzg.a(this.a).getString(paramString, null));
        }
        if (QLog.isColorLevel()) {
          QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged value = " + bgzg.a(this.a) + " personlizedYellowVipUrl = " + bgzg.a(this.a));
        }
      }
      bgzg.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgzh
 * JD-Core Version:    0.7.0.1
 */