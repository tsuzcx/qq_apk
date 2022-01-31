import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;

class atgm
  implements HookMethodCallback
{
  private int a;
  
  public atgm(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (paramMethodHookParam.throwable == null) {
      return;
    }
    Throwable localThrowable;
    if (paramMethodHookParam.throwable.getCause() != null) {
      localThrowable = paramMethodHookParam.throwable.getCause();
    }
    while ((localThrowable instanceof OutOfMemoryError))
    {
      atgl.b();
      try
      {
        paramMethodHookParam.result = JavaHookBridge.invokeOriginMethod(paramMethodHookParam.method, paramMethodHookParam.thisObject, paramMethodHookParam.args);
        paramMethodHookParam.throwable = null;
        atgl.a(true, this.a);
        return;
      }
      catch (Exception paramMethodHookParam)
      {
        atgl.a(false, this.a);
        return;
        localThrowable = paramMethodHookParam.throwable;
      }
      catch (Error paramMethodHookParam)
      {
        atgl.a(false, this.a);
      }
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atgm
 * JD-Core Version:    0.7.0.1
 */