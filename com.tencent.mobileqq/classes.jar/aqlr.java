import com.taobao.android.dexposed.XC_MethodHook;
import com.tencent.mobileqq.config.QConfigureException;
import com.tencent.qphone.base.util.QLog;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;

final class aqlr
  extends XC_MethodHook
{
  public void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    try
    {
      paramMethodHookParam = aqln.a();
      if ((paramMethodHookParam.contains("QConfigManager.save")) && (paramMethodHookParam.contains("onParsed"))) {
        aqln.a(new QConfigureException(paramMethodHookParam), "Can not switch thread when parsing config.", "QConfigWatchDog_threadswitch");
      }
      return;
    }
    catch (Exception paramMethodHookParam)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QConfigWatchDog", 2, "hook thread exception.", paramMethodHookParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqlr
 * JD-Core Version:    0.7.0.1
 */