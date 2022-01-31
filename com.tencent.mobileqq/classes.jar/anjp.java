import java.util.HashMap;

public class anjp
{
  private static HashMap<String, anjq> a = new HashMap();
  
  public static Object a(int paramInt, String paramString, Object paramObject1, Object paramObject2)
  {
    paramString = (anjq)a.get(paramString);
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
  
  public static void a(String paramString, anjq paramanjq)
  {
    if (paramString != null) {
      a.put(paramString, paramanjq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjp
 * JD-Core Version:    0.7.0.1
 */