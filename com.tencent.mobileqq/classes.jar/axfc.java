import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class axfc
{
  public static axfd a(axff paramaxff, axfe paramaxfe, boolean paramBoolean)
  {
    axfd localaxfd = new axfd();
    int i;
    if (paramaxff.e > 0)
    {
      i = paramaxff.e;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, videoFps = " + i);
      }
      if (!paramBoolean) {
        break label189;
      }
      localaxfd.jdField_a_of_type_Float = 1.0F;
      localaxfd.jdField_a_of_type_Int = paramaxff.jdField_a_of_type_Int;
      localaxfd.jdField_b_of_type_Int = paramaxff.jdField_b_of_type_Int;
      localaxfd.jdField_b_of_type_Long = i;
      if ((paramaxff.jdField_a_of_type_Long <= 0L) || (paramaxff.jdField_a_of_type_Long * 8L >= paramaxfe.jdField_a_of_type_Long)) {
        break label169;
      }
      localaxfd.jdField_a_of_type_Long = paramaxff.jdField_b_of_type_Long;
      label124:
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, isRaw, compressInfo.desBitRate = " + localaxfd.jdField_a_of_type_Long);
      }
    }
    label169:
    label189:
    label352:
    label742:
    for (;;)
    {
      return localaxfd;
      i = 30;
      break;
      localaxfd.jdField_a_of_type_Long = ((int)(paramaxfe.jdField_a_of_type_Long / paramaxff.d));
      break label124;
      double d2;
      double d1;
      if (paramaxff.jdField_a_of_type_Int <= paramaxff.jdField_b_of_type_Int)
      {
        i = paramaxff.jdField_b_of_type_Int;
        if (i <= paramaxfe.jdField_a_of_type_Int) {
          break label692;
        }
        localaxfd.jdField_a_of_type_Float = (paramaxfe.jdField_a_of_type_Int / i);
        localaxfd.jdField_a_of_type_Int = ((int)(paramaxff.jdField_a_of_type_Int * localaxfd.jdField_a_of_type_Float));
        localaxfd.jdField_b_of_type_Int = ((int)(paramaxff.jdField_b_of_type_Int * localaxfd.jdField_a_of_type_Float));
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,  config.scaleRate = " + localaxfd.jdField_a_of_type_Float + ", compressInfo.desWidth = " + localaxfd.jdField_a_of_type_Int + ", compressInfo.desHeight = " + localaxfd.jdField_b_of_type_Int);
        }
        if ((paramaxff.e <= 0) || (paramaxff.e >= paramaxfe.jdField_b_of_type_Int)) {
          break label719;
        }
        localaxfd.jdField_b_of_type_Long = paramaxff.e;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, compressInfo.desFPS = " + localaxfd.jdField_b_of_type_Long);
        }
        d2 = localaxfd.jdField_a_of_type_Int * localaxfd.jdField_b_of_type_Int * localaxfd.jdField_b_of_type_Long * paramaxfe.jdField_a_of_type_Double;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp = " + d2);
        }
        d1 = d2;
        if (d2 > paramaxff.jdField_b_of_type_Long) {
          d1 = paramaxff.jdField_b_of_type_Long;
        }
        d2 = d1;
        if (d1 > paramaxfe.c) {
          d2 = paramaxfe.c;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp real = " + d2);
        }
        if (paramaxff.d * d2 <= paramaxfe.jdField_a_of_type_Long) {
          break label732;
        }
        d2 = paramaxfe.jdField_a_of_type_Long / (localaxfd.jdField_a_of_type_Int * localaxfd.jdField_b_of_type_Int * localaxfd.jdField_b_of_type_Long * paramaxff.d);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,densityExp = " + d2);
        }
        d1 = d2;
        if (d2 < paramaxfe.jdField_b_of_type_Double) {
          d1 = paramaxfe.jdField_b_of_type_Double;
        }
      }
      for (localaxfd.jdField_a_of_type_Long = ((int)(d1 * (localaxfd.jdField_a_of_type_Int * localaxfd.jdField_b_of_type_Int * localaxfd.jdField_b_of_type_Long)));; localaxfd.jdField_a_of_type_Long = ((int)d2))
      {
        if (!QLog.isColorLevel()) {
          break label742;
        }
        QLog.d("VideoCompressConfig", 2, "getCompressInfo,  compressInfo.desBitRate " + localaxfd.jdField_a_of_type_Long);
        return localaxfd;
        i = paramaxff.jdField_a_of_type_Int;
        break;
        localaxfd.jdField_a_of_type_Float = 1.0F;
        localaxfd.jdField_a_of_type_Int = paramaxff.jdField_a_of_type_Int;
        localaxfd.jdField_b_of_type_Int = paramaxff.jdField_b_of_type_Int;
        break label263;
        localaxfd.jdField_b_of_type_Long = paramaxfe.jdField_b_of_type_Int;
        break label352;
      }
    }
  }
  
  public static axfe a(QQAppInterface paramQQAppInterface)
  {
    axfe localaxfe = new axfe();
    if (paramQQAppInterface == null) {
      QLog.e("VideoCompressConfig", 1, "getManageConfig, app is null.");
    }
    do
    {
      return localaxfe;
      paramQQAppInterface = bbjn.o(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
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
          localaxfe.jdField_a_of_type_Int = i;
        }
        i = Integer.valueOf(paramQQAppInterface[1]).intValue();
        if (i > 0) {
          localaxfe.jdField_b_of_type_Int = i;
        }
        double d = Double.valueOf(paramQQAppInterface[2]).doubleValue();
        if (d > 0.0D) {
          localaxfe.jdField_a_of_type_Double = d;
        }
        d = Double.valueOf(paramQQAppInterface[3]).doubleValue();
        if (d > 0.0D) {
          localaxfe.jdField_b_of_type_Double = d;
        }
        if ((paramQQAppInterface.length >= 6) && (paramQQAppInterface[5] != null) && (paramQQAppInterface[5].length() > 0))
        {
          i = Integer.valueOf(paramQQAppInterface[5]).intValue();
          if (i > 0) {
            localaxfe.jdField_a_of_type_Long = (i * 1024 * 1024 * 8);
          }
        }
        long l;
        if ((paramQQAppInterface.length >= 8) && (paramQQAppInterface[7] != null) && (paramQQAppInterface[7].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[7]).longValue();
          if (l > 0L) {
            localaxfe.c = l;
          }
        }
        if ((paramQQAppInterface.length >= 9) && (paramQQAppInterface[8] != null) && (paramQQAppInterface[8].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[8]).longValue();
          if (l > 0L) {
            localaxfe.jdField_b_of_type_Long = l;
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
    QLog.d("VideoCompressConfig", 2, "getManageConfig, maxLength = " + localaxfe.jdField_a_of_type_Int + ", maxFPS = " + localaxfe.jdField_b_of_type_Int + ", maxDensity = " + localaxfe.jdField_a_of_type_Double + ", minDensity = " + localaxfe.jdField_b_of_type_Double + ", maxSize = " + localaxfe.jdField_a_of_type_Long + ", maxBitRate = " + localaxfe.c + ", minBitRate = " + localaxfe.jdField_b_of_type_Long);
    return localaxfe;
  }
  
  public static axff a(String paramString)
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
    axff localaxff = new axff();
    localaxff.jdField_a_of_type_Long = ((File)localObject).length();
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
        localaxff.jdField_a_of_type_Int = Integer.valueOf(paramString).intValue();
        localaxff.jdField_b_of_type_Int = Integer.valueOf(str1).intValue();
        localaxff.c = Integer.valueOf(str2).intValue();
        localaxff.d = ((int)(Integer.valueOf(str3).intValue() / 1000.0D + 0.5D));
        localaxff.e = ((int)(Integer.valueOf(str4).intValue() * 1.0D / localaxff.d + 0.5D));
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
      if (localaxff.d > 0) {
        localaxff.jdField_b_of_type_Long = (localaxff.jdField_a_of_type_Long * 8L / localaxff.d);
      }
      paramString = localaxff;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoCompressConfig", 2, "getVideoInfo, fileSize = " + localaxff.jdField_a_of_type_Long + ", width = " + localaxff.jdField_a_of_type_Int + ", height = " + localaxff.jdField_b_of_type_Int + ", rotation = " + localaxff.c + ", duration = " + localaxff.d + ", fps = " + localaxff.e + ", videoInfo.bitRate = " + localaxff.jdField_b_of_type_Long);
      return localaxff;
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
            localaxff.jdField_a_of_type_Int = localObject[1];
            localaxff.jdField_b_of_type_Int = localObject[2];
            localaxff.c = Integer.valueOf(ShortVideoTrimmer.a(localObject[3])).intValue();
            localaxff.d = ((int)(localObject[4] / 1000.0D + 0.5D));
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("VideoCompressConfig", 1, "getVideoInfo error.", paramString);
      }
    }
  }
  
  public static boolean a(axff paramaxff, axfe paramaxfe)
  {
    if ((paramaxff == null) || (paramaxfe == null))
    {
      QLog.e("VideoCompressConfig", 1, "isNeedCompress, false, videoInfo or config is null");
      return false;
    }
    if (paramaxff.jdField_a_of_type_Long * 8L > paramaxfe.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, fileSize > maxSize, fileSize = " + paramaxff.jdField_a_of_type_Long);
      }
      return true;
    }
    if (paramaxff.jdField_b_of_type_Long < paramaxfe.jdField_b_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress,false, bitRate < minBitRate, bitRate = " + paramaxff.jdField_b_of_type_Long + ", minBitRate = " + paramaxfe.jdField_b_of_type_Long);
      }
      return false;
    }
    if (paramaxff.jdField_b_of_type_Long > paramaxfe.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, bitRate > maxBitRate, bitRate = " + paramaxff.jdField_b_of_type_Long + ", maxBitRate = " + paramaxfe.c);
      }
      return true;
    }
    if (paramaxff.e > 0) {}
    for (int i = paramaxff.e;; i = 30)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, videoFps = " + i);
      }
      if (paramaxff.jdField_b_of_type_Long <= paramaxff.jdField_a_of_type_Int * paramaxff.jdField_b_of_type_Int * i * paramaxfe.jdField_a_of_type_Double * 1.2D) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, density > 1.2 * maxDensty. bitRate = " + paramaxff.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (paramaxff.jdField_a_of_type_Int * paramaxff.jdField_b_of_type_Int) * paramaxfe.jdField_a_of_type_Double * 1.2D);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressConfig", 2, "isNeedCompress, false, density <= 1.2 * maxDensty. bitRate = " + paramaxff.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (paramaxff.jdField_a_of_type_Int * paramaxff.jdField_b_of_type_Int) * paramaxfe.jdField_a_of_type_Double * 1.2D);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axfc
 * JD-Core Version:    0.7.0.1
 */