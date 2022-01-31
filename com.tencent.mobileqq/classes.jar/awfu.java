import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class awfu
{
  public static awfv a(awfx paramawfx, awfw paramawfw, boolean paramBoolean)
  {
    awfv localawfv = new awfv();
    int i;
    if (paramawfx.e > 0)
    {
      i = paramawfx.e;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, videoFps = " + i);
      }
      if (!paramBoolean) {
        break label189;
      }
      localawfv.jdField_a_of_type_Float = 1.0F;
      localawfv.jdField_a_of_type_Int = paramawfx.jdField_a_of_type_Int;
      localawfv.jdField_b_of_type_Int = paramawfx.jdField_b_of_type_Int;
      localawfv.jdField_b_of_type_Long = i;
      if ((paramawfx.jdField_a_of_type_Long <= 0L) || (paramawfx.jdField_a_of_type_Long * 8L >= paramawfw.jdField_a_of_type_Long)) {
        break label169;
      }
      localawfv.jdField_a_of_type_Long = paramawfx.jdField_b_of_type_Long;
      label124:
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, isRaw, compressInfo.desBitRate = " + localawfv.jdField_a_of_type_Long);
      }
    }
    label169:
    label189:
    label352:
    label742:
    for (;;)
    {
      return localawfv;
      i = 30;
      break;
      localawfv.jdField_a_of_type_Long = ((int)(paramawfw.jdField_a_of_type_Long / paramawfx.d));
      break label124;
      double d2;
      double d1;
      if (paramawfx.jdField_a_of_type_Int <= paramawfx.jdField_b_of_type_Int)
      {
        i = paramawfx.jdField_b_of_type_Int;
        if (i <= paramawfw.jdField_a_of_type_Int) {
          break label692;
        }
        localawfv.jdField_a_of_type_Float = (paramawfw.jdField_a_of_type_Int / i);
        localawfv.jdField_a_of_type_Int = ((int)(paramawfx.jdField_a_of_type_Int * localawfv.jdField_a_of_type_Float));
        localawfv.jdField_b_of_type_Int = ((int)(paramawfx.jdField_b_of_type_Int * localawfv.jdField_a_of_type_Float));
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,  config.scaleRate = " + localawfv.jdField_a_of_type_Float + ", compressInfo.desWidth = " + localawfv.jdField_a_of_type_Int + ", compressInfo.desHeight = " + localawfv.jdField_b_of_type_Int);
        }
        if ((paramawfx.e <= 0) || (paramawfx.e >= paramawfw.jdField_b_of_type_Int)) {
          break label719;
        }
        localawfv.jdField_b_of_type_Long = paramawfx.e;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, compressInfo.desFPS = " + localawfv.jdField_b_of_type_Long);
        }
        d2 = localawfv.jdField_a_of_type_Int * localawfv.jdField_b_of_type_Int * localawfv.jdField_b_of_type_Long * paramawfw.jdField_a_of_type_Double;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp = " + d2);
        }
        d1 = d2;
        if (d2 > paramawfx.jdField_b_of_type_Long) {
          d1 = paramawfx.jdField_b_of_type_Long;
        }
        d2 = d1;
        if (d1 > paramawfw.c) {
          d2 = paramawfw.c;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp real = " + d2);
        }
        if (paramawfx.d * d2 <= paramawfw.jdField_a_of_type_Long) {
          break label732;
        }
        d2 = paramawfw.jdField_a_of_type_Long / (localawfv.jdField_a_of_type_Int * localawfv.jdField_b_of_type_Int * localawfv.jdField_b_of_type_Long * paramawfx.d);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,densityExp = " + d2);
        }
        d1 = d2;
        if (d2 < paramawfw.jdField_b_of_type_Double) {
          d1 = paramawfw.jdField_b_of_type_Double;
        }
      }
      for (localawfv.jdField_a_of_type_Long = ((int)(d1 * (localawfv.jdField_a_of_type_Int * localawfv.jdField_b_of_type_Int * localawfv.jdField_b_of_type_Long)));; localawfv.jdField_a_of_type_Long = ((int)d2))
      {
        if (!QLog.isColorLevel()) {
          break label742;
        }
        QLog.d("VideoCompressConfig", 2, "getCompressInfo,  compressInfo.desBitRate " + localawfv.jdField_a_of_type_Long);
        return localawfv;
        i = paramawfx.jdField_a_of_type_Int;
        break;
        localawfv.jdField_a_of_type_Float = 1.0F;
        localawfv.jdField_a_of_type_Int = paramawfx.jdField_a_of_type_Int;
        localawfv.jdField_b_of_type_Int = paramawfx.jdField_b_of_type_Int;
        break label263;
        localawfv.jdField_b_of_type_Long = paramawfw.jdField_b_of_type_Int;
        break label352;
      }
    }
  }
  
  public static awfw a(QQAppInterface paramQQAppInterface)
  {
    awfw localawfw = new awfw();
    if (paramQQAppInterface == null) {
      QLog.e("VideoCompressConfig", 1, "getManageConfig, app is null.");
    }
    do
    {
      return localawfw;
      paramQQAppInterface = baig.o(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getManageConfig, compressConfig = " + paramQQAppInterface);
        }
        paramQQAppInterface = paramQQAppInterface.split("\\|");
        if ((paramQQAppInterface == null) || (paramQQAppInterface.length < 5)) {}
      }
      try
      {
        int i = Integer.valueOf(paramQQAppInterface[0]).intValue();
        if (i > 0) {
          localawfw.jdField_a_of_type_Int = i;
        }
        i = Integer.valueOf(paramQQAppInterface[1]).intValue();
        if (i > 0) {
          localawfw.jdField_b_of_type_Int = i;
        }
        double d = Double.valueOf(paramQQAppInterface[2]).doubleValue();
        if (d > 0.0D) {
          localawfw.jdField_a_of_type_Double = d;
        }
        d = Double.valueOf(paramQQAppInterface[3]).doubleValue();
        if (d > 0.0D) {
          localawfw.jdField_b_of_type_Double = d;
        }
        if ((paramQQAppInterface.length >= 6) && (paramQQAppInterface[5] != null) && (paramQQAppInterface[5].length() > 0))
        {
          i = Integer.valueOf(paramQQAppInterface[5]).intValue();
          if (i > 0) {
            localawfw.jdField_a_of_type_Long = (i * 1024 * 1024 * 8);
          }
        }
        long l;
        if ((paramQQAppInterface.length >= 8) && (paramQQAppInterface[7] != null) && (paramQQAppInterface[7].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[7]).longValue();
          if (l > 0L) {
            localawfw.c = l;
          }
        }
        if ((paramQQAppInterface.length >= 9) && (paramQQAppInterface[8] != null) && (paramQQAppInterface[8].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[8]).longValue();
          if (l > 0L) {
            localawfw.jdField_b_of_type_Long = l;
          }
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoCompressConfig", 2, "getCompressConfigNew -> get VideoCompressConfig Erro", paramQQAppInterface);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoCompressConfig", 2, "getManageConfig, maxLength = " + localawfw.jdField_a_of_type_Int + ", maxFPS = " + localawfw.jdField_b_of_type_Int + ", maxDensity = " + localawfw.jdField_a_of_type_Double + ", minDensity = " + localawfw.jdField_b_of_type_Double + ", maxSize = " + localawfw.jdField_a_of_type_Long + ", maxBitRate = " + localawfw.c + ", minBitRate = " + localawfw.jdField_b_of_type_Long);
    return localawfw;
  }
  
  public static awfx a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("VideoCompressConfig", 1, "getVideoInfo, videoPath is empty.");
      paramString = null;
      return paramString;
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      QLog.e("VideoCompressConfig", 1, "getVideoInfo, file not exists.");
      return null;
    }
    awfx localawfx = new awfx();
    localawfx.jdField_a_of_type_Long = ((File)localObject).length();
    if (Build.VERSION.SDK_INT >= 17) {
      localObject = new MediaMetadataRetriever();
    }
    for (;;)
    {
      try
      {
        ((MediaMetadataRetriever)localObject).setDataSource(paramString);
        paramString = ((MediaMetadataRetriever)localObject).extractMetadata(18);
        String str1 = ((MediaMetadataRetriever)localObject).extractMetadata(19);
        String str2 = ((MediaMetadataRetriever)localObject).extractMetadata(24);
        String str3 = ((MediaMetadataRetriever)localObject).extractMetadata(9);
        String str4 = ((MediaMetadataRetriever)localObject).extractMetadata(32);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getVideoInfo by MediaMetadataRetriever, width = " + paramString + ", height = " + str1 + ", rotation = " + str2 + ", duration = " + str3 + ", frameCount = " + str4);
        }
        localawfx.jdField_a_of_type_Int = Integer.valueOf(paramString).intValue();
        localawfx.jdField_b_of_type_Int = Integer.valueOf(str1).intValue();
        localawfx.c = Integer.valueOf(str2).intValue();
        localawfx.d = ((int)(Integer.valueOf(str3).intValue() / 1000.0D + 0.5D));
        localawfx.e = ((int)(Integer.valueOf(str4).intValue() * 1.0D / localawfx.d + 0.5D));
      }
      catch (Exception paramString)
      {
        QLog.e("VideoCompressConfig", 1, "getVideoProperty:", paramString);
        ((MediaMetadataRetriever)localObject).release();
        continue;
      }
      finally
      {
        ((MediaMetadataRetriever)localObject).release();
      }
      if (localawfx.d > 0) {
        localawfx.jdField_b_of_type_Long = (localawfx.jdField_a_of_type_Long * 8L / localawfx.d);
      }
      paramString = localawfx;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoCompressConfig", 2, "getVideoInfo, fileSize = " + localawfx.jdField_a_of_type_Long + ", width = " + localawfx.jdField_a_of_type_Int + ", height = " + localawfx.jdField_b_of_type_Int + ", rotation = " + localawfx.c + ", duration = " + localawfx.d + ", fps = " + localawfx.e + ", videoInfo.bitRate = " + localawfx.jdField_b_of_type_Long);
      return localawfx;
      try
      {
        paramString = ShortVideoTrimmer.getRealProperties(paramString);
        if (paramString != null)
        {
          paramString = paramString.split(",");
          if ((paramString != null) && (paramString.length > 0))
          {
            localObject = new int[paramString.length];
            int i = 0;
            while (i < paramString.length)
            {
              localObject[i] = Integer.valueOf(paramString[i]).intValue();
              i += 1;
            }
            localawfx.jdField_a_of_type_Int = localObject[1];
            localawfx.jdField_b_of_type_Int = localObject[2];
            localawfx.c = Integer.valueOf(ShortVideoTrimmer.a(localObject[3])).intValue();
            localawfx.d = ((int)(localObject[4] / 1000.0D + 0.5D));
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("VideoCompressConfig", 1, "getVideoInfo error.", paramString);
      }
    }
  }
  
  public static boolean a(awfx paramawfx, awfw paramawfw)
  {
    if ((paramawfx == null) || (paramawfw == null))
    {
      QLog.e("VideoCompressConfig", 1, "isNeedCompress, false, videoInfo or config is null");
      return false;
    }
    if (paramawfx.jdField_a_of_type_Long * 8L > paramawfw.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, fileSize > maxSize, fileSize = " + paramawfx.jdField_a_of_type_Long);
      }
      return true;
    }
    if (paramawfx.jdField_b_of_type_Long < paramawfw.jdField_b_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress,false, bitRate < minBitRate, bitRate = " + paramawfx.jdField_b_of_type_Long + ", minBitRate = " + paramawfw.jdField_b_of_type_Long);
      }
      return false;
    }
    if (paramawfx.jdField_b_of_type_Long > paramawfw.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, bitRate > maxBitRate, bitRate = " + paramawfx.jdField_b_of_type_Long + ", maxBitRate = " + paramawfw.c);
      }
      return true;
    }
    if (paramawfx.e > 0) {}
    for (int i = paramawfx.e;; i = 30)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, videoFps = " + i);
      }
      if (paramawfx.jdField_b_of_type_Long <= paramawfx.jdField_a_of_type_Int * paramawfx.jdField_b_of_type_Int * i * paramawfw.jdField_a_of_type_Double * 1.2D) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, density > 1.2 * maxDensty. bitRate = " + paramawfx.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (paramawfx.jdField_a_of_type_Int * paramawfx.jdField_b_of_type_Int) * paramawfw.jdField_a_of_type_Double * 1.2D);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressConfig", 2, "isNeedCompress, false, density <= 1.2 * maxDensty. bitRate = " + paramawfx.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (paramawfx.jdField_a_of_type_Int * paramawfx.jdField_b_of_type_Int) * paramawfw.jdField_a_of_type_Double * 1.2D);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awfu
 * JD-Core Version:    0.7.0.1
 */