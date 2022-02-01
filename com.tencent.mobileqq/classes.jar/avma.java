import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class avma
{
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      HashMap localHashMap = new HashMap();
      acik.a(localHashMap, paramString1);
      localHashMap.put(Integer.valueOf(1), paramString2);
      localHashMap.put(Integer.valueOf(2), paramString1);
      if (paramBoolean) {
        localHashMap.put(Integer.valueOf(24), Integer.valueOf(1));
      }
      acik.a(anbd.a(), "769", paramString3, paramString2, "76906", "1", "160", localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avma
 * JD-Core Version:    0.7.0.1
 */