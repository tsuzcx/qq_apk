import java.util.HashMap;

public class apyl
{
  private static HashMap<String, apym> a = new HashMap();
  
  public static Object a(int paramInt, String paramString, Object paramObject1, Object paramObject2)
  {
    paramString = (apym)a.get(paramString);
    if (paramString != null) {
      paramObject2 = paramString.a(paramInt, paramObject1);
    }
    return paramObject2;
  }
  
  public static void a(String paramString)
  {
    if (paramString != null) {
      a.remove(paramString);
    }
  }
  
  public static void a(String paramString, apym paramapym)
  {
    if (paramString != null) {
      a.put(paramString, paramapym);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apyl
 * JD-Core Version:    0.7.0.1
 */