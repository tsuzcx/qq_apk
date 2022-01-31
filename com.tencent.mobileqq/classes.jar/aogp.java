import com.qq.android.dexposed.XC_MethodHook;
import com.qq.android.dexposed.XC_MethodHook.MethodHookParam;
import com.tencent.mobileqq.config.QConfigureException;
import com.tencent.qphone.base.util.QLog;

final class aogp
  extends XC_MethodHook
{
  public void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    try
    {
      paramMethodHookParam = aogm.a();
      if ((!paramMethodHookParam.contains("QConfigManager.readSync")) && (!paramMethodHookParam.contains("QConfigManager.loadConObj")) && (!paramMethodHookParam.contains("QConfigManager.save"))) {
        aogm.a(new QConfigureException(paramMethodHookParam), "Can not parse json beyond QConfigManager when app starting.", "QConfigWatchDog_Json");
      }
      return;
    }
    catch (Exception paramMethodHookParam)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QConfigWatchDog", 2, "hook json exception.", paramMethodHookParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aogp
 * JD-Core Version:    0.7.0.1
 */