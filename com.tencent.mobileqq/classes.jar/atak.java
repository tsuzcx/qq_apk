import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

final class atak
  implements MediaScannerConnection.OnScanCompletedListener
{
  public void onScanCompleted(String paramString, Uri paramUri)
  {
    if (QLog.isDebugVersion()) {
      QLog.i("FilePathUtil<FileAssistant>", 1, "MediaScannerConnection Scanned:\n" + paramString + ":\nuri=" + paramUri);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atak
 * JD-Core Version:    0.7.0.1
 */