import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class bjfi
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  bjfi(bjfh parambjfh) {}
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramSharedPreferences = BaseApplicationImpl.getApplication().getRuntime();
    if (paramSharedPreferences != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged key = " + paramString);
      }
      if ((!bjfh.a(this.a)) && (bjfh.a(this.a) != null))
      {
        if (bjfh.a(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bjfh.a(this.a, bjfh.a(this.a).getInt(paramString, 0));
        }
        if (bjfh.b(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bjfh.c(this.a, bjfh.a(this.a).getString(paramString, null));
        }
        if (bjfh.d(this.a, paramSharedPreferences.getAccount()).equals(paramString)) {
          bjfh.e(this.a, bjfh.a(this.a).getString(paramString, null));
        }
        if (QLog.isColorLevel()) {
          QLog.d("QZoneVipInfoManager", 2, "onSharedPreferenceChanged value = " + bjfh.a(this.a) + " personlizedYellowVipUrl = " + bjfh.a(this.a));
        }
      }
      bjfh.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjfi
 * JD-Core Version:    0.7.0.1
 */