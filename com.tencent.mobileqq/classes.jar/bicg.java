import android.content.Intent;
import java.util.HashSet;
import org.json.JSONObject;

public abstract interface bicg
{
  public abstract HashSet<String> getFilterCmds();
  
  public abstract void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bicg
 * JD-Core Version:    0.7.0.1
 */