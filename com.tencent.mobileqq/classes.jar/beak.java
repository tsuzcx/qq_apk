import java.lang.reflect.Field;

public class beak
{
  public static Object a(Object paramObject, String paramString)
  {
    try
    {
      paramObject = paramObject.getClass().getField(paramString).get(paramObject);
      return paramObject;
    }
    catch (NoSuchFieldException paramObject)
    {
      return null;
    }
    catch (IllegalArgumentException paramObject)
    {
      return null;
    }
    catch (IllegalAccessException paramObject) {}
    return null;
  }
  
  public static Object b(Object paramObject, String paramString)
  {
    try
    {
      String[] arrayOfString = paramString.split("\\.");
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        paramString = paramObject;
        if (i >= j) {
          break;
        }
        paramString = arrayOfString[i];
        paramObject = paramObject.getClass().getField(paramString).get(paramObject);
        i += 1;
      }
      return null;
    }
    catch (IllegalAccessException paramObject)
    {
      paramString = null;
      return paramString;
    }
    catch (IllegalArgumentException paramObject)
    {
      return null;
    }
    catch (NoSuchFieldException paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     beak
 * JD-Core Version:    0.7.0.1
 */