import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import org.json.JSONException;
import org.json.JSONObject;

class arjh
  implements arif
{
  arjh(arjd paramarjd) {}
  
  public void a(Context paramContext)
  {
    try
    {
      Intent localIntent;
      if (new JSONObject(arjd.a(this.a)).getInt("showlocalfile") == 1)
      {
        localIntent = new Intent(paramContext, LocalFileBrowserActivity.class);
        if (localIntent != null) {}
      }
      else
      {
        return;
      }
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("category", 23);
        localIntent.putExtra("bundle", localBundle);
        localIntent.putExtra("localSdCardfile", 0);
        paramContext.startActivity(localIntent);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arjh
 * JD-Core Version:    0.7.0.1
 */