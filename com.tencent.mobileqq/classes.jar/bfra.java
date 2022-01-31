import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class bfra
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  bfra(bfqz parambfqz) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = BaseApplicationImpl.getApplication().getRuntime();
    if (paramSharedPreferences != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged key = " + paramString);
      }
      if ((!bfqz.a(this.a)) && (bfqz.a(this.a) != null))
      {
        if (bfqz.a(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bfqz.a(this.a, bfqz.a(this.a).getInt(paramString, 0));
        }
        if (bfqz.b(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bfqz.c(this.a, bfqz.a(this.a).getString(paramString, null));
        }
        if (bfqz.d(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bfqz.e(this.a, bfqz.a(this.a).getString(paramString, null));
        }
        if (QLog.isColorLevel()) {
          QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged value = " + bfqz.a(this.a) + " personlizedYellowVipUrl = " + bfqz.a(this.a));
        }
      }
      bfqz.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfra
 * JD-Core Version:    0.7.0.1
 */