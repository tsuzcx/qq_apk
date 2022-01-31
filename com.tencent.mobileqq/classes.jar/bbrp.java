import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class bbrp
{
  public static void a(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("authResult", String.valueOf(paramInt));
    axrn.a(BaseApplication.getContext()).a("", paramString, false, 0L, -1L, localHashMap, "", true);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", paramString2);
    axrn.a(BaseApplication.getContext()).a("", paramString1, false, 0L, -1L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbrp
 * JD-Core Version:    0.7.0.1
 */