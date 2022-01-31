import com.tencent.qapmsdk.common.logger.ILogProxy;
import com.tencent.qapmsdk.common.logger.LogState;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class azpg
  implements ILogProxy
{
  int a;
  
  public azpg(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void doLog(@NotNull LogState paramLogState, @NotNull String... paramVarArgs)
  {
    int i = 1;
    if (paramLogState.getValue() > this.a) {}
    while ((paramVarArgs == null) || (paramVarArgs.length <= 1)) {
      return;
    }
    Object localObject = paramVarArgs[0];
    localObject = new StringBuilder(256);
    while (i < paramVarArgs.length)
    {
      ((StringBuilder)localObject).append(paramVarArgs[i]);
      i += 1;
    }
    switch (azph.a[paramLogState.ordinal()])
    {
    default: 
      return;
    case 1: 
      QLog.d(paramVarArgs[0], 4, ((StringBuilder)localObject).toString());
    case 2: 
      QLog.d(paramVarArgs[0], 2, ((StringBuilder)localObject).toString());
      return;
    case 3: 
      QLog.i(paramVarArgs[0], 2, ((StringBuilder)localObject).toString());
      return;
    case 4: 
      QLog.w(paramVarArgs[0], 2, ((StringBuilder)localObject).toString());
      return;
    }
    QLog.e(paramVarArgs[0], 2, ((StringBuilder)localObject).toString());
  }
  
  public void flush(@NotNull String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpg
 * JD-Core Version:    0.7.0.1
 */