import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class bnix
  implements InvocationHandler
{
  bnix(bniv parambniv) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = paramMethod.getName();
    boolean bool;
    if ("onLoad".equals(paramObject)) {
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 2))
      {
        int i = ((Integer)paramArrayOfObject[0]).intValue();
        bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
        bniv.a(this.a, i, bool);
      }
    }
    for (;;)
    {
      return null;
      if (("onLoadFinish".equals(paramObject)) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1))
      {
        bool = ((Boolean)paramArrayOfObject[0]).booleanValue();
        bniv.a(this.a, bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnix
 * JD-Core Version:    0.7.0.1
 */