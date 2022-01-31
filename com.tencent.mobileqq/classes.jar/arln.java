import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;

class arln
  implements HookMethodCallback
{
  private int a;
  
  public arln(int paramInt)
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
      arlm.b();
      try
      {
        paramMethodHookParam.result = JavaHookBridge.invokeOriginMethod(paramMethodHookParam.method, paramMethodHookParam.thisObject, paramMethodHookParam.args);
        paramMethodHookParam.throwable = null;
        arlm.a(true, this.a);
        return;
      }
      catch (Exception paramMethodHookParam)
      {
        arlm.a(false, this.a);
        return;
        localThrowable = paramMethodHookParam.throwable;
      }
      catch (Error paramMethodHookParam)
      {
        arlm.a(false, this.a);
      }
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arln
 * JD-Core Version:    0.7.0.1
 */