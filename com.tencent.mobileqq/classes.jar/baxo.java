import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

public class baxo
{
  public static Intent a(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    if (paramIntent == null)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("ForwardUtils", 4, "getForwardData return null from main process");
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
    } while (!AIOFilePictureData.class.isInstance(paramIntent));
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
      BrowserLogHelper.getInstance().getGalleryLog().d("ForwardUtils", 4, "getForwardData return null from main process");
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
      if (AIOFilePictureData.class.isInstance(paramIntent))
      {
        localIntent.putExtra("isPic", true);
        localIntent.putExtra("direct_send_if_dataline_forward", true);
      }
      aufz.a(paramActivity, paramIntent, 103, paramInt, paramString);
      return;
    }
    aufz.a(paramActivity, paramIntent, 21, paramInt, paramString);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramIntent == null)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("ForwardUtils", 4, "getForwardData return null from main process");
      return;
    }
    paramIntent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
    paramIntent.putExtra("key_req", ForwardRecentActivity.f);
    paramIntent.putExtra("key_direct_show_uin_type", paramInt);
    paramIntent.putExtra("key_direct_show_uin", paramString);
    if (!paramBoolean)
    {
      paramIntent.putExtra("filepictest", true);
      aufz.a(paramActivity, paramIntent, ForwardRecentTranslucentActivity.class, 21);
      return;
    }
    aufz.a(paramActivity, paramIntent, ForwardRecentTranslucentActivity.class, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baxo
 * JD-Core Version:    0.7.0.1
 */