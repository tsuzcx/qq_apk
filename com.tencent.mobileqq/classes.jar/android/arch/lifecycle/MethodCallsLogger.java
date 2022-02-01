package android.arch.lifecycle;

import android.support.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class MethodCallsLogger
{
  private Map<String, Integer> mCalledMethods = new HashMap();
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public boolean approveCall(String paramString, int paramInt)
  {
    Integer localInteger = (Integer)this.mCalledMethods.get(paramString);
    int i;
    if (localInteger != null)
    {
      i = localInteger.intValue();
      if ((i & paramInt) == 0) {
        break label62;
      }
    }
    label62:
    for (int j = 1;; j = 0)
    {
      this.mCalledMethods.put(paramString, Integer.valueOf(i | paramInt));
      return j ^ 0x1;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.arch.lifecycle.MethodCallsLogger
 * JD-Core Version:    0.7.0.1
 */