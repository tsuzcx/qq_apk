import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class bnlu
  extends JSONObject
{
  public bnlu(QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo) {}
  
  public bnlu a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return this;
    }
    try
    {
      put(paramString1, paramString2);
      return this;
    }
    catch (JSONException paramString1)
    {
      QZLog.d(QzoneVerticalVideoTopicInfo.a(this.a), 2, "put JSON error", paramString1);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlu
 * JD-Core Version:    0.7.0.1
 */