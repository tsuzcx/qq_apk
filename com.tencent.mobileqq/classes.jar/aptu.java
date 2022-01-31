import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.gallery.model.pic.AIOFilePicData;

public class aptu
{
  public static void a(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    if (paramIntent == null)
    {
      apsm.a().a().a("ForwardUtils", 4, "getForwardData return null from main process");
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
      aphp.a(paramActivity, paramIntent, 103);
      return;
    }
    aphp.a(paramActivity, paramIntent, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aptu
 * JD-Core Version:    0.7.0.1
 */