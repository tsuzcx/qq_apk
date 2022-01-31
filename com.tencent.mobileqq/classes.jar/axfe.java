import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class axfe
{
  public static axff a(axfh paramaxfh, axfg paramaxfg, boolean paramBoolean)
  {
    axff localaxff = new axff();
    int i;
    if (paramaxfh.e > 0)
    {
      i = paramaxfh.e;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, videoFps = " + i);
      }
      if (!paramBoolean) {
        break label189;
      }
      localaxff.jdField_a_of_type_Float = 1.0F;
      localaxff.jdField_a_of_type_Int = paramaxfh.jdField_a_of_type_Int;
      localaxff.jdField_b_of_type_Int = paramaxfh.jdField_b_of_type_Int;
      localaxff.jdField_b_of_type_Long = i;
      if ((paramaxfh.jdField_a_of_type_Long <= 0L) || (paramaxfh.jdField_a_of_type_Long * 8L >= paramaxfg.jdField_a_of_type_Long)) {
        break label169;
      }
      localaxff.jdField_a_of_type_Long = paramaxfh.jdField_b_of_type_Long;
      label124:
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, isRaw, compressInfo.desBitRate = " + localaxff.jdField_a_of_type_Long);
      }
    }
    label169:
    label189:
    label352:
    label742:
    for (;;)
    {
      return localaxff;
      i = 30;
      break;
      localaxff.jdField_a_of_type_Long = ((int)(paramaxfg.jdField_a_of_type_Long / paramaxfh.d));
      break label124;
      double d2;
      double d1;
      if (paramaxfh.jdField_a_of_type_Int <= paramaxfh.jdField_b_of_type_Int)
      {
        i = paramaxfh.jdField_b_of_type_Int;
        if (i <= paramaxfg.jdField_a_of_type_Int) {
          break label692;
        }
        localaxff.jdField_a_of_type_Float = (paramaxfg.jdField_a_of_type_Int / i);
        localaxff.jdField_a_of_type_Int = ((int)(paramaxfh.jdField_a_of_type_Int * localaxff.jdField_a_of_type_Float));
        localaxff.jdField_b_of_type_Int = ((int)(paramaxfh.jdField_b_of_type_Int * localaxff.jdField_a_of_type_Float));
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,  config.scaleRate = " + localaxff.jdField_a_of_type_Float + ", compressInfo.desWidth = " + localaxff.jdField_a_of_type_Int + ", compressInfo.desHeight = " + localaxff.jdField_b_of_type_Int);
        }
        if ((paramaxfh.e <= 0) || (paramaxfh.e >= paramaxfg.jdField_b_of_type_Int)) {
          break label719;
        }
        localaxff.jdField_b_of_type_Long = paramaxfh.e;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, compressInfo.desFPS = " + localaxff.jdField_b_of_type_Long);
        }
        d2 = localaxff.jdField_a_of_type_Int * localaxff.jdField_b_of_type_Int * localaxff.jdField_b_of_type_Long * paramaxfg.jdField_a_of_type_Double;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp = " + d2);
        }
        d1 = d2;
        if (d2 > paramaxfh.jdField_b_of_type_Long) {
          d1 = paramaxfh.jdField_b_of_type_Long;
        }
        d2 = d1;
        if (d1 > paramaxfg.c) {
          d2 = paramaxfg.c;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp real = " + d2);
        }
        if (paramaxfh.d * d2 <= paramaxfg.jdField_a_of_type_Long) {
          break label732;
        }
        d2 = paramaxfg.jdField_a_of_type_Long / (localaxff.jdField_a_of_type_Int * localaxff.jdField_b_of_type_Int * localaxff.jdField_b_of_type_Long * paramaxfh.d);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,densityExp = " + d2);
        }
        d1 = d2;
        if (d2 < paramaxfg.jdField_b_of_type_Double) {
          d1 = paramaxfg.jdField_b_of_type_Double;
        }
      }
      for (localaxff.jdField_a_of_type_Long = ((int)(d1 * (localaxff.jdField_a_of_type_Int * localaxff.jdField_b_of_type_Int * localaxff.jdField_b_of_type_Long)));; localaxff.jdField_a_of_type_Long = ((int)d2))
      {
        if (!QLog.isColorLevel()) {
          break label742;
        }
        QLog.d("VideoCompressConfig", 2, "getCompressInfo,  compressInfo.desBitRate " + localaxff.jdField_a_of_type_Long);
        return localaxff;
        i = paramaxfh.jdField_a_of_type_Int;
        break;
        localaxff.jdField_a_of_type_Float = 1.0F;
        localaxff.jdField_a_of_type_Int = paramaxfh.jdField_a_of_type_Int;
        localaxff.jdField_b_of_type_Int = paramaxfh.jdField_b_of_type_Int;
        break label263;
        localaxff.jdField_b_of_type_Long = paramaxfg.jdField_b_of_type_Int;
        break label352;
      }
    }
  }
  
  public static axfg a(QQAppInterface paramQQAppInterface)
  {
    axfg localaxfg = new axfg();
    if (paramQQAppInterface == null) {
      QLog.e("VideoCompressConfig", 1, "getManageConfig, app is null.");
    }
    do
    {
      return localaxfg;
      paramQQAppInterface = bbkb.o(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
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
          localaxfg.jdField_a_of_type_Int = i;
        }
        i = Integer.valueOf(paramQQAppInterface[1]).intValue();
        if (i > 0) {
          localaxfg.jdField_b_of_type_Int = i;
        }
        double d = Double.valueOf(paramQQAppInterface[2]).doubleValue();
        if (d > 0.0D) {
          localaxfg.jdField_a_of_type_Double = d;
        }
        d = Double.valueOf(paramQQAppInterface[3]).doubleValue();
        if (d > 0.0D) {
          localaxfg.jdField_b_of_type_Double = d;
        }
        if ((paramQQAppInterface.length >= 6) && (paramQQAppInterface[5] != null) && (paramQQAppInterface[5].length() > 0))
        {
          i = Integer.valueOf(paramQQAppInterface[5]).intValue();
          if (i > 0) {
            localaxfg.jdField_a_of_type_Long = (i * 1024 * 1024 * 8);
          }
        }
        long l;
        if ((paramQQAppInterface.length >= 8) && (paramQQAppInterface[7] != null) && (paramQQAppInterface[7].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[7]).longValue();
          if (l > 0L) {
            localaxfg.c = l;
          }
        }
        if ((paramQQAppInterface.length >= 9) && (paramQQAppInterface[8] != null) && (paramQQAppInterface[8].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[8]).longValue();
          if (l > 0L) {
            localaxfg.jdField_b_of_type_Long = l;
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
    QLog.d("VideoCompressConfig", 2, "getManageConfig, maxLength = " + localaxfg.jdField_a_of_type_Int + ", maxFPS = " + localaxfg.jdField_b_of_type_Int + ", maxDensity = " + localaxfg.jdField_a_of_type_Double + ", minDensity = " + localaxfg.jdField_b_of_type_Double + ", maxSize = " + localaxfg.jdField_a_of_type_Long + ", maxBitRate = " + localaxfg.c + ", minBitRate = " + localaxfg.jdField_b_of_type_Long);
    return localaxfg;
  }
  
  public static axfh a(String paramString)
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
    axfh localaxfh = new axfh();
    localaxfh.jdField_a_of_type_Long = ((File)localObject).length();
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
        localaxfh.jdField_a_of_type_Int = Integer.valueOf(paramString).intValue();
        localaxfh.jdField_b_of_type_Int = Integer.valueOf(str1).intValue();
        localaxfh.c = Integer.valueOf(str2).intValue();
        localaxfh.d = ((int)(Integer.valueOf(str3).intValue() / 1000.0D + 0.5D));
        localaxfh.e = ((int)(Integer.valueOf(str4).intValue() * 1.0D / localaxfh.d + 0.5D));
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
      if (localaxfh.d > 0) {
        localaxfh.jdField_b_of_type_Long = (localaxfh.jdField_a_of_type_Long * 8L / localaxfh.d);
      }
      paramString = localaxfh;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoCompressConfig", 2, "getVideoInfo, fileSize = " + localaxfh.jdField_a_of_type_Long + ", width = " + localaxfh.jdField_a_of_type_Int + ", height = " + localaxfh.jdField_b_of_type_Int + ", rotation = " + localaxfh.c + ", duration = " + localaxfh.d + ", fps = " + localaxfh.e + ", videoInfo.bitRate = " + localaxfh.jdField_b_of_type_Long);
      return localaxfh;
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
            localaxfh.jdField_a_of_type_Int = localObject[1];
            localaxfh.jdField_b_of_type_Int = localObject[2];
            localaxfh.c = Integer.valueOf(ShortVideoTrimmer.a(localObject[3])).intValue();
            localaxfh.d = ((int)(localObject[4] / 1000.0D + 0.5D));
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("VideoCompressConfig", 1, "getVideoInfo error.", paramString);
      }
    }
  }
  
  public static boolean a(axfh paramaxfh, axfg paramaxfg)
  {
    if ((paramaxfh == null) || (paramaxfg == null))
    {
      QLog.e("VideoCompressConfig", 1, "isNeedCompress, false, videoInfo or config is null");
      return false;
    }
    if (paramaxfh.jdField_a_of_type_Long * 8L > paramaxfg.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, fileSize > maxSize, fileSize = " + paramaxfh.jdField_a_of_type_Long);
      }
      return true;
    }
    if (paramaxfh.jdField_b_of_type_Long < paramaxfg.jdField_b_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress,false, bitRate < minBitRate, bitRate = " + paramaxfh.jdField_b_of_type_Long + ", minBitRate = " + paramaxfg.jdField_b_of_type_Long);
      }
      return false;
    }
    if (paramaxfh.jdField_b_of_type_Long > paramaxfg.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, bitRate > maxBitRate, bitRate = " + paramaxfh.jdField_b_of_type_Long + ", maxBitRate = " + paramaxfg.c);
      }
      return true;
    }
    if (paramaxfh.e > 0) {}
    for (int i = paramaxfh.e;; i = 30)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, videoFps = " + i);
      }
      if (paramaxfh.jdField_b_of_type_Long <= paramaxfh.jdField_a_of_type_Int * paramaxfh.jdField_b_of_type_Int * i * paramaxfg.jdField_a_of_type_Double * 1.2D) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, density > 1.2 * maxDensty. bitRate = " + paramaxfh.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (paramaxfh.jdField_a_of_type_Int * paramaxfh.jdField_b_of_type_Int) * paramaxfg.jdField_a_of_type_Double * 1.2D);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressConfig", 2, "isNeedCompress, false, density <= 1.2 * maxDensty. bitRate = " + paramaxfh.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (paramaxfh.jdField_a_of_type_Int * paramaxfh.jdField_b_of_type_Int) * paramaxfg.jdField_a_of_type_Double * 1.2D);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axfe
 * JD-Core Version:    0.7.0.1
 */