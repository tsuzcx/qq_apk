import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import org.json.JSONObject;

public class bdzi
{
  public static int a()
  {
    return bdhg.a("MiniGame", "MiniGameBannerAdMinWidth", 300);
  }
  
  public static BaseLibInfo a()
  {
    Object localObject = bdhg.a("MiniGame", "MiniGameBaseLib", "{\"key1\":\"https://d3g.qq.com/sngapp/app/update/20190708174635_6988/lib-1.4.7.zip\",\"key2\":\"\",\"key3\":\"1.4.7\",\"key4\": {\"file_length\": 6336933},\"key5\":2}");
    bdnw.b("minigame", "MiniEng getWnsGameBaseLibInfo " + (String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = BaseLibInfo.fromJSON(new JSONObject((String)localObject));
        return localObject;
      }
      catch (Exception localException)
      {
        bdnw.d("minigame", "MiniEng getWnsGameBaseLibInfo failed", localException);
      }
    }
    return null;
  }
  
  public static String a()
  {
    return bdhg.a("MiniGame", "MiniGameDefaultShareImg", "https://qzonestyle.gtimg.cn/aoi/sola/20190510161934_LYAUVguqnV.png");
  }
  
  public static String a(String paramString)
  {
    return bdhg.a("MiniGame", "MiniGameEngineVersion", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdzi
 * JD-Core Version:    0.7.0.1
 */