import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;

public class bdhu
{
  public static FileManagerEntity a(ForwardFileInfo paramForwardFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.fileName = paramForwardFileInfo.d();
    localFileManagerEntity.nFileType = atvo.a(localFileManagerEntity.fileName);
    localFileManagerEntity.nSessionId = paramForwardFileInfo.b();
    localFileManagerEntity.cloudType = paramForwardFileInfo.d();
    return localFileManagerEntity;
  }
  
  public static ForwardFileInfo a(String paramString)
  {
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.d(9);
    localForwardFileInfo.b(10001);
    localForwardFileInfo.d(paramString);
    localForwardFileInfo.b(atvo.a().longValue());
    return localForwardFileInfo;
  }
  
  public static String a(int paramInt)
  {
    String str = anni.a(2131713487);
    if (paramInt == 3) {
      str = "word";
    }
    do
    {
      return str;
      if (paramInt == 6) {
        return "excel";
      }
      if (paramInt == 7) {
        return "ppt";
      }
    } while (paramInt != 9);
    return "pdf";
  }
  
  public static void a(Activity paramActivity, ForwardFileInfo paramForwardFileInfo, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity, FileBrowserActivity.class);
    if (paramForwardFileInfo != null) {
      localIntent.putExtra("fileinfo", paramForwardFileInfo);
    }
    if (paramBundle != null) {
      localIntent.putExtra("file_browser_extra_params", paramBundle);
    }
    paramActivity.startActivityForResult(localIntent, 102);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    a(paramActivity, paramString, false);
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    paramString = a(paramString);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isMiniProgram", paramBoolean);
    a(paramActivity, paramString, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhu
 * JD-Core Version:    0.7.0.1
 */