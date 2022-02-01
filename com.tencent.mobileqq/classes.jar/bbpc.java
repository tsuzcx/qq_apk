import android.text.TextUtils;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bbpc
{
  public static List<bbph> a(String paramString)
  {
    localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("LiuHaiArray"))
        {
          paramString = paramString.getJSONArray("LiuHaiArray");
          int i = 0;
          while (i < paramString.length())
          {
            bbph localbbph = new bbph();
            JSONObject localJSONObject = paramString.getJSONObject(i);
            if (localJSONObject.has("manufacturer")) {
              localbbph.a = localJSONObject.optString("manufacturer", "");
            }
            if (localJSONObject.has("brand")) {
              localbbph.b = localJSONObject.optString("brand", "");
            }
            if (localJSONObject.has("model")) {
              localbbph.c = localJSONObject.optString("model", "");
            }
            localArrayList.add(localbbph);
            i += 1;
          }
        }
        return localArrayList;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        BrowserLogHelper.getInstance().getGalleryLog().d("ListConfigParseUtils", 4, "parseWhiteListConfig exception = " + paramString.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpc
 * JD-Core Version:    0.7.0.1
 */