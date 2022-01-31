import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import mqq.app.MobileQQ;

public class birx
  implements birw
{
  public boolean a(int paramInt, Bundle paramBundle)
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    long l;
    String str;
    switch (paramInt)
    {
    case 3: 
    default: 
      return true;
    case 1: 
      localObject1 = paramBundle.getString("installAppName");
      paramBundle = paramBundle.getString("installAppUrl");
      l = 0L;
      for (;;)
      {
        try
        {
          localObject2 = new URL(paramBundle);
        }
        catch (MalformedURLException localMalformedURLException)
        {
          Object localObject2;
          localMalformedURLException.printStackTrace();
          continue;
        }
        try
        {
          paramInt = ((URL)localObject2).openConnection().getContentLength();
          l = paramInt;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putLong("_filesize_from_dlg", l);
      ((Bundle)localObject2).putString("_filename_from_dlg", (String)localObject1);
      ((Bundle)localObject2).putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_qfav");
      aqwa.a().b(paramBundle, (Bundle)localObject2);
      return true;
    case 2: 
      l = paramBundle.getLong("previewSize", -1L);
      str = paramBundle.getString("previewName");
      Intent localIntent = new Intent(((QQAppInterface)localObject1).getApplication().getBaseContext(), FilePreviewActivity.class);
      localIntent.addFlags(268435456);
      localIntent.putExtra("offline_file_type", 0);
      localIntent.putExtra("offline_file_name", str);
      localIntent.putExtra("offline_file_size", l);
      ((QQAppInterface)localObject1).a().a(new aqvs(paramBundle));
      QLog.i("FavoritesRemoteCommandHandler", 1, "open zip favorite,open new activity");
      ((QQAppInterface)localObject1).getApplication().getBaseContext().startActivity(localIntent);
      return true;
    case 4: 
      str = paramBundle.getString("configKey");
      paramBundle.putString("configInfo", aqxg.a(((QQAppInterface)localObject1).getApp().getBaseContext(), str));
      return true;
    }
    paramBundle.putBoolean("isVideoChatting", ((QQAppInterface)localObject1).c());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     birx
 * JD-Core Version:    0.7.0.1
 */