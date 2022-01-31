import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginPreInstaller;

public class ammp
  extends SosoInterface.OnLocationListener
{
  public ammp(PluginPreInstaller paramPluginPreInstaller, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      paramSosoLbsInfo = paramSosoLbsInfo.a.e;
      if (!TextUtils.isEmpty(paramSosoLbsInfo))
      {
        localObject = PreferenceManager.getDefaultSharedPreferences(PluginPreInstaller.a(this.a)).edit();
        ((SharedPreferences.Editor)localObject).putString("wlx_last_location_city", paramSosoLbsInfo);
        ((SharedPreferences.Editor)localObject).commit();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("wlx isJtcodePluginPreInstall; start location locationCity=");
          if (TextUtils.isEmpty(paramSosoLbsInfo)) {
            break label100;
          }
        }
      }
    }
    for (;;)
    {
      QLog.d("PluginPreInstaller", 2, paramSosoLbsInfo);
      return;
      label100:
      paramSosoLbsInfo = "null";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammp
 * JD-Core Version:    0.7.0.1
 */