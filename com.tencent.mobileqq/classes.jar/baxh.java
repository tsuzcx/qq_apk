import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class baxh
{
  public static void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith(anhk.bg)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("src_file_path", paramString1);
      localHashMap.put("des_file_path", paramString2);
      bctj.a(BaseApplication.getContext()).a(null, "qq_images_file_delete", true, 0L, 0L, localHashMap, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baxh
 * JD-Core Version:    0.7.0.1
 */