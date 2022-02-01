import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bcyo
{
  public static bcyp a(bcyr parambcyr, bcyq parambcyq, boolean paramBoolean)
  {
    bcyp localbcyp = new bcyp();
    int i;
    if (parambcyr.e > 0)
    {
      i = parambcyr.e;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, videoFps = " + i);
      }
      if (!paramBoolean) {
        break label189;
      }
      localbcyp.jdField_a_of_type_Float = 1.0F;
      localbcyp.jdField_a_of_type_Int = parambcyr.jdField_a_of_type_Int;
      localbcyp.jdField_b_of_type_Int = parambcyr.jdField_b_of_type_Int;
      localbcyp.jdField_b_of_type_Long = i;
      if ((parambcyr.jdField_a_of_type_Long <= 0L) || (parambcyr.jdField_a_of_type_Long * 8L >= parambcyq.jdField_a_of_type_Long)) {
        break label169;
      }
      localbcyp.jdField_a_of_type_Long = parambcyr.jdField_b_of_type_Long;
      label124:
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, isRaw, compressInfo.desBitRate = " + localbcyp.jdField_a_of_type_Long);
      }
    }
    label169:
    label189:
    label352:
    label742:
    for (;;)
    {
      return localbcyp;
      i = 30;
      break;
      localbcyp.jdField_a_of_type_Long = ((int)(parambcyq.jdField_a_of_type_Long / parambcyr.d));
      break label124;
      double d2;
      double d1;
      if (parambcyr.jdField_a_of_type_Int <= parambcyr.jdField_b_of_type_Int)
      {
        i = parambcyr.jdField_b_of_type_Int;
        if (i <= parambcyq.jdField_a_of_type_Int) {
          break label692;
        }
        localbcyp.jdField_a_of_type_Float = (parambcyq.jdField_a_of_type_Int / i);
        localbcyp.jdField_a_of_type_Int = ((int)(parambcyr.jdField_a_of_type_Int * localbcyp.jdField_a_of_type_Float));
        localbcyp.jdField_b_of_type_Int = ((int)(parambcyr.jdField_b_of_type_Int * localbcyp.jdField_a_of_type_Float));
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,  config.scaleRate = " + localbcyp.jdField_a_of_type_Float + ", compressInfo.desWidth = " + localbcyp.jdField_a_of_type_Int + ", compressInfo.desHeight = " + localbcyp.jdField_b_of_type_Int);
        }
        if ((parambcyr.e <= 0) || (parambcyr.e >= parambcyq.jdField_b_of_type_Int)) {
          break label719;
        }
        localbcyp.jdField_b_of_type_Long = parambcyr.e;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, compressInfo.desFPS = " + localbcyp.jdField_b_of_type_Long);
        }
        d2 = localbcyp.jdField_a_of_type_Int * localbcyp.jdField_b_of_type_Int * localbcyp.jdField_b_of_type_Long * parambcyq.jdField_a_of_type_Double;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp = " + d2);
        }
        d1 = d2;
        if (d2 > parambcyr.jdField_b_of_type_Long) {
          d1 = parambcyr.jdField_b_of_type_Long;
        }
        d2 = d1;
        if (d1 > parambcyq.c) {
          d2 = parambcyq.c;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp real = " + d2);
        }
        if (parambcyr.d * d2 <= parambcyq.jdField_a_of_type_Long) {
          break label732;
        }
        d2 = parambcyq.jdField_a_of_type_Long / (localbcyp.jdField_a_of_type_Int * localbcyp.jdField_b_of_type_Int * localbcyp.jdField_b_of_type_Long * parambcyr.d);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,densityExp = " + d2);
        }
        d1 = d2;
        if (d2 < parambcyq.jdField_b_of_type_Double) {
          d1 = parambcyq.jdField_b_of_type_Double;
        }
      }
      for (localbcyp.jdField_a_of_type_Long = ((int)(d1 * (localbcyp.jdField_a_of_type_Int * localbcyp.jdField_b_of_type_Int * localbcyp.jdField_b_of_type_Long)));; localbcyp.jdField_a_of_type_Long = ((int)d2))
      {
        if (!QLog.isColorLevel()) {
          break label742;
        }
        QLog.d("VideoCompressConfig", 2, "getCompressInfo,  compressInfo.desBitRate " + localbcyp.jdField_a_of_type_Long);
        return localbcyp;
        i = parambcyr.jdField_a_of_type_Int;
        break;
        localbcyp.jdField_a_of_type_Float = 1.0F;
        localbcyp.jdField_a_of_type_Int = parambcyr.jdField_a_of_type_Int;
        localbcyp.jdField_b_of_type_Int = parambcyr.jdField_b_of_type_Int;
        break label263;
        localbcyp.jdField_b_of_type_Long = parambcyq.jdField_b_of_type_Int;
        break label352;
      }
    }
  }
  
  public static bcyq a(QQAppInterface paramQQAppInterface)
  {
    bcyq localbcyq = new bcyq();
    if (paramQQAppInterface == null) {
      QLog.e("VideoCompressConfig", 1, "getManageConfig, app is null.");
    }
    do
    {
      return localbcyq;
      paramQQAppInterface = bhhr.p(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
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
          localbcyq.jdField_a_of_type_Int = i;
        }
        i = Integer.valueOf(paramQQAppInterface[1]).intValue();
        if (i > 0) {
          localbcyq.jdField_b_of_type_Int = i;
        }
        double d = Double.valueOf(paramQQAppInterface[2]).doubleValue();
        if (d > 0.0D) {
          localbcyq.jdField_a_of_type_Double = d;
        }
        d = Double.valueOf(paramQQAppInterface[3]).doubleValue();
        if (d > 0.0D) {
          localbcyq.jdField_b_of_type_Double = d;
        }
        if ((paramQQAppInterface.length >= 6) && (paramQQAppInterface[5] != null) && (paramQQAppInterface[5].length() > 0))
        {
          i = Integer.valueOf(paramQQAppInterface[5]).intValue();
          if (i > 0) {
            localbcyq.jdField_a_of_type_Long = (i * 1024 * 1024 * 8);
          }
        }
        long l;
        if ((paramQQAppInterface.length >= 8) && (paramQQAppInterface[7] != null) && (paramQQAppInterface[7].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[7]).longValue();
          if (l > 0L) {
            localbcyq.c = l;
          }
        }
        if ((paramQQAppInterface.length >= 9) && (paramQQAppInterface[8] != null) && (paramQQAppInterface[8].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[8]).longValue();
          if (l > 0L) {
            localbcyq.jdField_b_of_type_Long = l;
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
    QLog.d("VideoCompressConfig", 2, "getManageConfig, maxLength = " + localbcyq.jdField_a_of_type_Int + ", maxFPS = " + localbcyq.jdField_b_of_type_Int + ", maxDensity = " + localbcyq.jdField_a_of_type_Double + ", minDensity = " + localbcyq.jdField_b_of_type_Double + ", maxSize = " + localbcyq.jdField_a_of_type_Long + ", maxBitRate = " + localbcyq.c + ", minBitRate = " + localbcyq.jdField_b_of_type_Long);
    return localbcyq;
  }
  
  public static bcyr a(String paramString)
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
    bcyr localbcyr = new bcyr();
    localbcyr.jdField_a_of_type_Long = ((File)localObject).length();
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
        localbcyr.jdField_a_of_type_Int = Integer.valueOf(paramString).intValue();
        localbcyr.jdField_b_of_type_Int = Integer.valueOf(str1).intValue();
        localbcyr.c = Integer.valueOf(str2).intValue();
        localbcyr.d = ((int)(Integer.valueOf(str3).intValue() / 1000.0D + 0.5D));
        localbcyr.e = ((int)(Integer.valueOf(str4).intValue() * 1.0D / localbcyr.d + 0.5D));
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
      if (localbcyr.d > 0) {
        localbcyr.jdField_b_of_type_Long = (localbcyr.jdField_a_of_type_Long * 8L / localbcyr.d);
      }
      paramString = localbcyr;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoCompressConfig", 2, "getVideoInfo, fileSize = " + localbcyr.jdField_a_of_type_Long + ", width = " + localbcyr.jdField_a_of_type_Int + ", height = " + localbcyr.jdField_b_of_type_Int + ", rotation = " + localbcyr.c + ", duration = " + localbcyr.d + ", fps = " + localbcyr.e + ", videoInfo.bitRate = " + localbcyr.jdField_b_of_type_Long);
      return localbcyr;
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
            localbcyr.jdField_a_of_type_Int = localObject[1];
            localbcyr.jdField_b_of_type_Int = localObject[2];
            localbcyr.c = Integer.valueOf(ShortVideoTrimmer.getVideoRotate(localObject[3])).intValue();
            localbcyr.d = ((int)(localObject[4] / 1000.0D + 0.5D));
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("VideoCompressConfig", 1, "getVideoInfo error.", paramString);
      }
    }
  }
  
  public static boolean a(bcyr parambcyr, bcyq parambcyq)
  {
    if ((parambcyr == null) || (parambcyq == null))
    {
      QLog.e("VideoCompressConfig", 1, "isNeedCompress, false, videoInfo or config is null");
      return false;
    }
    if (parambcyr.jdField_a_of_type_Long * 8L > parambcyq.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, fileSize > maxSize, fileSize = " + parambcyr.jdField_a_of_type_Long);
      }
      return true;
    }
    if (parambcyr.jdField_b_of_type_Long < parambcyq.jdField_b_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress,false, bitRate < minBitRate, bitRate = " + parambcyr.jdField_b_of_type_Long + ", minBitRate = " + parambcyq.jdField_b_of_type_Long);
      }
      return false;
    }
    if (parambcyr.jdField_b_of_type_Long > parambcyq.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, bitRate > maxBitRate, bitRate = " + parambcyr.jdField_b_of_type_Long + ", maxBitRate = " + parambcyq.c);
      }
      return true;
    }
    if (parambcyr.e > 0) {}
    for (int i = parambcyr.e;; i = 30)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, videoFps = " + i);
      }
      if (parambcyr.jdField_b_of_type_Long <= parambcyr.jdField_a_of_type_Int * parambcyr.jdField_b_of_type_Int * i * parambcyq.jdField_a_of_type_Double * 1.2D) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, density > 1.2 * maxDensty. bitRate = " + parambcyr.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (parambcyr.jdField_a_of_type_Int * parambcyr.jdField_b_of_type_Int) * parambcyq.jdField_a_of_type_Double * 1.2D);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressConfig", 2, "isNeedCompress, false, density <= 1.2 * maxDensty. bitRate = " + parambcyr.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (parambcyr.jdField_a_of_type_Int * parambcyr.jdField_b_of_type_Int) * parambcyq.jdField_a_of_type_Double * 1.2D);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcyo
 * JD-Core Version:    0.7.0.1
 */