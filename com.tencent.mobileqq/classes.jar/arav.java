import com.qq.android.dexposed.XC_MethodHook;
import com.qq.android.dexposed.XC_MethodHook.MethodHookParam;
import com.tencent.mobileqq.config.QConfigureException;
import com.tencent.qphone.base.util.QLog;

final class arav
  extends XC_MethodHook
{
  public void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    try
    {
      paramMethodHookParam = araq.a();
      if ((!paramMethodHookParam.contains("QConfigManager.readSync")) && (!paramMethodHookParam.contains("QConfigManager.loadConObj")) && (!paramMethodHookParam.contains("QConfigManager.save")) && (!paramMethodHookParam.contains("android.app.SharedPreferencesImpl"))) {
        araq.a(new QConfigureException(paramMethodHookParam), "Can not parse xml beyond QConfigManager when app starting.", "QConfigWatchDog_Xml");
      }
      return;
    }
    catch (Exception paramMethodHookParam)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QConfigWatchDog", 2, "hook xml exception.", paramMethodHookParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arav
 * JD-Core Version:    0.7.0.1
 */