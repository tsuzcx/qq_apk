import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.io.File;

public class bgku
{
  public static Uri a(Context paramContext, File paramFile)
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    paramFile = Uri.fromFile(paramFile);
    localIntent.setData(paramFile);
    paramContext.sendBroadcast(localIntent);
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgku
 * JD-Core Version:    0.7.0.1
 */