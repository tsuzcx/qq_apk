import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class blto
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  blto(bltn parambltn) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = BaseApplicationImpl.getApplication().getRuntime();
    if (paramSharedPreferences != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged key = " + paramString);
      }
      if ((!bltn.a(this.a)) && (bltn.a(this.a) != null))
      {
        if (bltn.a(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bltn.a(this.a, bltn.a(this.a).getInt(paramString, 0));
        }
        if (bltn.b(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bltn.c(this.a, bltn.a(this.a).getString(paramString, null));
        }
        if (bltn.d(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bltn.e(this.a, bltn.a(this.a).getString(paramString, null));
        }
        if (QLog.isColorLevel()) {
          QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged value = " + bltn.a(this.a) + " personlizedYellowVipUrl = " + bltn.a(this.a));
        }
      }
      bltn.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blto
 * JD-Core Version:    0.7.0.1
 */