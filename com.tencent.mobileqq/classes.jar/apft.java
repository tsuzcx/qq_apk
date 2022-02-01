import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.ar.view.ARScanEntryView.40.1;
import com.tencent.mobileqq.ar.view.ARScanEntryView.40.2;
import com.tencent.mobileqq.ar.view.ARScanEntryView.40.3;
import com.tencent.qphone.base.util.QLog;

public class apft
  extends apsh
{
  public apft(ARScanEntryView paramARScanEntryView) {}
  
  public void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    SharedPreferences localSharedPreferences = apsi.a(this.a.a);
    long l = localSharedPreferences.getLong("key_ar_act_id", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARScanEntryView", 2, "onGetARRedDotInfo redSwitch = " + paramInt + ",actID = " + paramLong + ",isSuccess = " + paramBoolean + ",savedActID = " + l);
    }
    localSharedPreferences.edit().putLong("key_ar_act_id", paramLong).commit();
    if (!this.a.m)
    {
      QLog.d("AREngine_ARScanEntryView", 1, "onGetARRedDotInfo,not deal redhot message when pause");
      return;
    }
    paramBoolean = localSharedPreferences.getBoolean("key_show_reddot", false);
    if (paramInt == 1) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label274;
      }
      if ((paramLong > l) || ((paramBoolean) && (paramLong == l)))
      {
        ARScanEntryView.a(this.a).post(new ARScanEntryView.40.1(this));
        localSharedPreferences.edit().putBoolean("key_show_reddot", true).commit();
        ARScanEntryView.g(this.a, true);
      }
      if (paramLong >= l) {
        break;
      }
      ARScanEntryView.g(this.a, false);
      ARScanEntryView.a(this.a).post(new ARScanEntryView.40.2(this));
      localSharedPreferences.edit().putBoolean("key_show_reddot", false).commit();
      return;
    }
    label274:
    ARScanEntryView.g(this.a, false);
    ARScanEntryView.a(this.a).post(new ARScanEntryView.40.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apft
 * JD-Core Version:    0.7.0.1
 */