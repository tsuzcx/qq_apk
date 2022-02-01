import android.text.TextUtils;
import com.tencent.ark.open.ArkAppMgr;

public class aosx
{
  public static void a(String paramString1, String paramString2, String paramString3, aops paramaops)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (aorg.a() != null)) {
      ArkAppMgr.getInstance().getAppPathByNameTimeout(3000L, paramString1, paramString2, "0.0.0.1", null, new aosy(paramString1, paramString3, paramaops));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosx
 * JD-Core Version:    0.7.0.1
 */