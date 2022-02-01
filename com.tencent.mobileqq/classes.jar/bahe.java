import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;

public class bahe
{
  private static String a = "MediaUtil";
  
  @TargetApi(10)
  public static long a(String paramString)
  {
    long l1 = 0L;
    localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(9);
    }
    catch (RuntimeException localRuntimeException)
    {
      long l2;
      xvv.c(a, "getVideoDuration path=" + paramString + " exists=" + ypi.e(paramString), localRuntimeException);
      localMediaMetadataRetriever.release();
      return 0L;
    }
    catch (Error localError)
    {
      label32:
      xvv.c(a, "getVideoDuration path=" + paramString + " exists=" + ypi.e(paramString), localError);
      localMediaMetadataRetriever.release();
      return 0L;
    }
    try
    {
      l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      break label32;
    }
    localMediaMetadataRetriever.release();
    return l1;
  }
  
  @TargetApi(10)
  public static Bitmap a(String paramString, int paramInt)
  {
    Object localObject = null;
    if (!ypi.e(paramString))
    {
      xvv.e(a, "File note exist when getFrameAtTime(). videoPath = " + paramString + " millisecond = " + paramInt);
      return null;
    }
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    long l = paramInt * 1000;
    try
    {
      paramString = localMediaMetadataRetriever.getFrameAtTime(l, 0);
      localMediaMetadataRetriever.release();
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        xvv.c(a, "getFrameAtTime", paramString);
        paramString = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahe
 * JD-Core Version:    0.7.0.1
 */