import android.text.TextUtils;
import com.tencent.ark.open.ArkAppMgr;

public class apwb
{
  public static void a(String paramString1, String paramString2, String paramString3, apst paramapst)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (apuh.a() != null)) {
      ArkAppMgr.getInstance().getAppPathByNameTimeout(3000L, paramString1, paramString2, "0.0.0.1", null, new apwc(paramString1, paramString3, paramapst));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apwb
 * JD-Core Version:    0.7.0.1
 */