import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import org.json.JSONObject;

public class bfhp
{
  public static int a()
  {
    return bema.a("MiniGame", "MiniGameBannerAdMinWidth", 300);
  }
  
  public static BaseLibInfo a()
  {
    Object localObject = bema.a("MiniGame", "MiniGameBaseLib", "{\"key1\":\"https://d3g.qq.com/sngapp/app/update/20190708174635_6988/lib-1.4.7.zip\",\"key2\":\"\",\"key3\":\"1.4.7\",\"key4\": {\"file_length\": 6336933},\"key5\":2}");
    betc.b("minigame", "MiniEng getWnsGameBaseLibInfo " + (String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = BaseLibInfo.fromJSON(new JSONObject((String)localObject));
        return localObject;
      }
      catch (Exception localException)
      {
        betc.d("minigame", "MiniEng getWnsGameBaseLibInfo failed", localException);
      }
    }
    return null;
  }
  
  public static String a()
  {
    return bema.a("MiniGame", "MiniGameDefaultShareImg", "https://qzonestyle.gtimg.cn/aoi/sola/20190510161934_LYAUVguqnV.png");
  }
  
  public static String a(String paramString)
  {
    return bema.a("MiniGame", "MiniGameEngineVersion", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfhp
 * JD-Core Version:    0.7.0.1
 */