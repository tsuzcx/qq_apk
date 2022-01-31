import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class bdus
{
  public static void a(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("authResult", String.valueOf(paramInt));
    azri.a(BaseApplication.getContext()).a("", paramString, false, 0L, -1L, localHashMap, "", true);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", paramString2);
    azri.a(BaseApplication.getContext()).a("", paramString1, false, 0L, -1L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdus
 * JD-Core Version:    0.7.0.1
 */