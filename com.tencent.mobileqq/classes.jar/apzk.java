import android.text.TextUtils;
import com.tencent.ark.open.ArkAppMgr;

public class apzk
{
  public static void a(String paramString1, String paramString2, String paramString3, apwf paramapwf)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (apxt.a() != null)) {
      ArkAppMgr.getInstance().getAppPathByNameTimeout(3000L, paramString1, paramString2, "0.0.0.1", null, new apzl(paramString1, paramString3, paramapwf));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzk
 * JD-Core Version:    0.7.0.1
 */