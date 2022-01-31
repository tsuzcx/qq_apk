import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.gallery.model.pic.AIOFilePicData;

public class aqnw
{
  public static Intent a(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    if (paramIntent == null)
    {
      aqmd.a().a().a("ForwardUtils", 4, "getForwardData return null from main process");
      paramActivity = null;
    }
    Intent localIntent;
    do
    {
      do
      {
        return paramActivity;
        paramIntent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
        paramActivity = paramIntent;
      } while (paramBoolean);
      paramIntent.putExtra("filepictest", true);
      paramActivity = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
      String str1 = paramIntent.getStringExtra("forward_filepath");
      paramBoolean = paramIntent.getBooleanExtra("k_favorites", false);
      String str2 = paramIntent.getStringExtra("forward_text");
      boolean bool = paramIntent.getBooleanExtra("isFromShare", false);
      int i = paramIntent.getIntExtra("forward_type", 0);
      localIntent = new Intent();
      localIntent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", i);
      localBundle.putParcelable("fileinfo", paramActivity);
      localBundle.putBoolean("not_forward", true);
      localIntent.putExtras(localBundle);
      localIntent.putExtra("forward_filepath", str1);
      localIntent.putExtra("forward_text", str2);
      localIntent.putExtra("k_favorites", paramBoolean);
      localIntent.putExtra("isFromShare", bool);
      paramActivity = paramIntent;
    } while (!AIOFilePicData.class.isInstance(paramIntent));
    localIntent.putExtra("isPic", true);
    localIntent.putExtra("direct_send_if_dataline_forward", true);
    return paramIntent;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    a(paramActivity, paramIntent, paramBoolean, -1, "");
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramIntent == null)
    {
      aqmd.a().a().a("ForwardUtils", 4, "getForwardData return null from main process");
      return;
    }
    paramIntent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
    if (!paramBoolean)
    {
      paramIntent.putExtra("filepictest", true);
      ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
      String str1 = paramIntent.getStringExtra("forward_filepath");
      paramBoolean = paramIntent.getBooleanExtra("k_favorites", false);
      String str2 = paramIntent.getStringExtra("forward_text");
      boolean bool = paramIntent.getBooleanExtra("isFromShare", false);
      int i = paramIntent.getIntExtra("forward_type", 0);
      Intent localIntent = new Intent();
      localIntent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", i);
      localBundle.putParcelable("fileinfo", localForwardFileInfo);
      localBundle.putBoolean("not_forward", true);
      localIntent.putExtras(localBundle);
      localIntent.putExtra("forward_filepath", str1);
      localIntent.putExtra("forward_text", str2);
      localIntent.putExtra("k_favorites", paramBoolean);
      localIntent.putExtra("isFromShare", bool);
      if (AIOFilePicData.class.isInstance(paramIntent))
      {
        localIntent.putExtra("isPic", true);
        localIntent.putExtra("direct_send_if_dataline_forward", true);
      }
      aqbe.a(paramActivity, paramIntent, 103, paramInt, paramString);
      return;
    }
    aqbe.a(paramActivity, paramIntent, 21, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqnw
 * JD-Core Version:    0.7.0.1
 */