import android.os.Bundle;
import org.json.JSONObject;

public abstract interface aymv
{
  public abstract void callJs(String paramString, String... paramVarArgs);
  
  public abstract void diyThemeSetup(JSONObject paramJSONObject, String paramString);
  
  public abstract void downloadBgPic(String paramString, Bundle paramBundle);
  
  public abstract void startDownload(JSONObject paramJSONObject, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aymv
 * JD-Core Version:    0.7.0.1
 */