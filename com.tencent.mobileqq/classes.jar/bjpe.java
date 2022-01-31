import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class bjpe
  implements InvocationHandler
{
  bjpe(bjpc parambjpc) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = paramMethod.getName();
    boolean bool;
    if ("onLoad".equals(paramObject)) {
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 2))
      {
        int i = ((Integer)paramArrayOfObject[0]).intValue();
        bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
        bjpc.a(this.a, i, bool);
      }
    }
    for (;;)
    {
      return null;
      if (("onLoadFinish".equals(paramObject)) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1))
      {
        bool = ((Boolean)paramArrayOfObject[0]).booleanValue();
        bjpc.a(this.a, bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjpe
 * JD-Core Version:    0.7.0.1
 */