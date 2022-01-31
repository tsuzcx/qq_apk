import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class bjtl
  implements InvocationHandler
{
  bjtl(bjtj parambjtj) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = paramMethod.getName();
    boolean bool;
    if ("onLoad".equals(paramObject)) {
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 2))
      {
        int i = ((Integer)paramArrayOfObject[0]).intValue();
        bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
        bjtj.a(this.a, i, bool);
      }
    }
    for (;;)
    {
      return null;
      if (("onLoadFinish".equals(paramObject)) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1))
      {
        bool = ((Boolean)paramArrayOfObject[0]).booleanValue();
        bjtj.a(this.a, bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjtl
 * JD-Core Version:    0.7.0.1
 */