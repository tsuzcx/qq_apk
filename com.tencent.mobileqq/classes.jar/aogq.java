import com.qq.android.dexposed.XC_MethodHook;
import com.qq.android.dexposed.XC_MethodHook.MethodHookParam;
import com.tencent.mobileqq.config.QConfigureException;
import com.tencent.qphone.base.util.QLog;

final class aogq
  extends XC_MethodHook
{
  public void beforeHookedMethod(XC_MethodHook.MethodHookParam paramMethodHookParam)
  {
    try
    {
      paramMethodHookParam = aogm.a();
      if ((paramMethodHookParam.contains("QConfigManager.save")) && (paramMethodHookParam.contains("onParsed"))) {
        aogm.a(new QConfigureException(paramMethodHookParam), "Can not switch thread when parsing config.", "QConfigWatchDog_threadswitch");
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
 * Qualified Name:     aogq
 * JD-Core Version:    0.7.0.1
 */