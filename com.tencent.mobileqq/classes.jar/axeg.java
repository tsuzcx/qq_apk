import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;

public class axeg
{
  public static FileManagerEntity a(ForwardFileInfo paramForwardFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.fileName = paramForwardFileInfo.d();
    localFileManagerEntity.nFileType = apck.a(localFileManagerEntity.fileName);
    localFileManagerEntity.nSessionId = paramForwardFileInfo.b();
    localFileManagerEntity.cloudType = paramForwardFileInfo.d();
    return localFileManagerEntity;
  }
  
  public static String a(int paramInt)
  {
    String str = ajjy.a(2131649003);
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
  
  public static void a(Activity paramActivity, String paramString)
  {
    a(paramActivity, paramString, false);
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    Object localObject = new FileManagerEntity();
    ((FileManagerEntity)localObject).nSessionId = apck.a().longValue();
    ((FileManagerEntity)localObject).fileName = paramString;
    paramString = new ForwardFileInfo();
    paramString.d(9);
    paramString.b(10001);
    paramString.d(((FileManagerEntity)localObject).fileName);
    paramString.b(((FileManagerEntity)localObject).nSessionId);
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("isMiniProgram", paramBoolean);
    Intent localIntent = new Intent(paramActivity, FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramString);
    localIntent.putExtra("file_browser_extra_params", (Bundle)localObject);
    paramActivity.startActivityForResult(localIntent, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axeg
 * JD-Core Version:    0.7.0.1
 */