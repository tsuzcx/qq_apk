import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class bghe
  extends JSONObject
{
  public bghe(QzoneVerticalVideoTopicInfo paramQzoneVerticalVideoTopicInfo) {}
  
  public bghe a(String paramString1, String paramString2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bghe
 * JD-Core Version:    0.7.0.1
 */