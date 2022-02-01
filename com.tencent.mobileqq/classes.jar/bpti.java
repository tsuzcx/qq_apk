import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public class bpti
{
  public static int a(String paramString, bptj parambptj)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    label227:
    for (;;)
    {
      String str1;
      String str2;
      String str3;
      try
      {
        localMediaMetadataRetriever.setDataSource(paramString);
        str1 = localMediaMetadataRetriever.extractMetadata(18);
        str2 = localMediaMetadataRetriever.extractMetadata(19);
        paramString = localMediaMetadataRetriever.extractMetadata(24);
        str3 = localMediaMetadataRetriever.extractMetadata(9);
        localMediaMetadataRetriever.release();
        if ((paramString != null) && (!"".equals(paramString)) && (!"null".equals(paramString))) {
          break label227;
        }
        paramString = "0";
        if ((str1 == null) || (str2 == null))
        {
          QLog.e("MediaMetadataUtils", 1, "extractMetadata:width=" + str1 + " height=" + str2);
          return -102;
        }
      }
      catch (RuntimeException paramString)
      {
        QLog.e("MediaMetadataUtils", 1, "setDataSource", paramString);
        return -101;
      }
      for (;;)
      {
        try
        {
          parambptj.a[0] = Integer.parseInt(str1);
          parambptj.a[1] = Integer.parseInt(str2);
          parambptj.a[3] = Integer.parseInt(str3);
          i = 0;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e("MediaMetadataUtils", 1, "parseInt", localNumberFormatException);
          int i = -103;
          continue;
        }
        try
        {
          parambptj.a[2] = Integer.parseInt(paramString);
          parambptj.a[4] = 0;
          return i;
        }
        catch (NumberFormatException paramString)
        {
          QLog.e("MediaMetadataUtils", 1, "parseInt", paramString);
          parambptj.a[2] = 0;
          return i;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpti
 * JD-Core Version:    0.7.0.1
 */