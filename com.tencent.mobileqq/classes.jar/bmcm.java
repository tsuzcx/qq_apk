import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.cropvideo.CropVideoActivity.CropUtils.1;
import java.io.File;

public class bmcm
{
  public static void a(@NonNull String paramString1, @NonNull String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2, @NonNull upk paramupk)
  {
    xqq.a(paramString1);
    xqq.a(paramString2);
    xqq.a(paramupk);
    ThreadManager.newFreeThread(new CropVideoActivity.CropUtils.1(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong1, paramLong2, paramupk), "VideoCrop", 5).start();
  }
  
  private static int b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2)
  {
    wxe.b("CropVideoActivity", "startCropVideo cropX: " + paramInt1 + ", cropY: " + paramInt2 + ", cropWidth: " + paramInt3 + ", cropHeight: " + paramInt4 + ", targetWidth: " + paramInt5 + ", targetHeight: " + paramInt6 + ", startTime: " + paramLong1 + ", endTime: " + paramLong2);
    int i = paramInt5;
    if (paramInt5 == -1) {
      i = paramInt3;
    }
    paramInt5 = paramInt6;
    if (paramInt6 == -1) {
      paramInt5 = paramInt4;
    }
    if (paramLong1 < 0L)
    {
      wxe.e("CropVideoActivity", "startCropVideo illegal start time!");
      return -1;
    }
    if ((paramLong1 >= paramLong2) && (paramLong2 >= 0L))
    {
      wxe.e("CropVideoActivity", "startCropVideo illegal time!");
      return -2;
    }
    paramInt6 = paramInt1;
    if (paramInt1 % 2 != 0) {
      paramInt6 = (paramInt1 + 1) / 2 * 2;
    }
    paramInt1 = paramInt2;
    if (paramInt2 % 2 != 0) {
      paramInt1 = (paramInt2 + 1) / 2 * 2;
    }
    paramInt2 = paramInt3;
    if (paramInt3 % 16 != 0) {
      paramInt2 = paramInt3 / 16 * 16;
    }
    paramInt3 = paramInt4;
    if (paramInt4 % 16 != 0) {
      paramInt3 = paramInt4 / 16 * 16;
    }
    if (i % 16 != 0) {
      paramInt4 = i / 16;
    }
    if (paramInt5 % 16 != 0) {
      paramInt4 = paramInt5 / 16;
    }
    paramString1 = new File(paramString1);
    paramString2 = new bmcn(paramString2, 2048000, paramLong1, paramLong2, false, true);
    paramString2.a(paramInt6, paramInt1, paramInt2, paramInt3);
    if ((new bnte().a(paramString1, paramString2, true)) && (paramString2.a == null)) {
      return 0;
    }
    return -3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmcm
 * JD-Core Version:    0.7.0.1
 */