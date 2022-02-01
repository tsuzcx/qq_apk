import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bbru
{
  public static bbrv a(bbrx parambbrx, bbrw parambbrw, boolean paramBoolean)
  {
    bbrv localbbrv = new bbrv();
    int i;
    if (parambbrx.e > 0)
    {
      i = parambbrx.e;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, videoFps = " + i);
      }
      if (!paramBoolean) {
        break label189;
      }
      localbbrv.jdField_a_of_type_Float = 1.0F;
      localbbrv.jdField_a_of_type_Int = parambbrx.jdField_a_of_type_Int;
      localbbrv.jdField_b_of_type_Int = parambbrx.jdField_b_of_type_Int;
      localbbrv.jdField_b_of_type_Long = i;
      if ((parambbrx.jdField_a_of_type_Long <= 0L) || (parambbrx.jdField_a_of_type_Long * 8L >= parambbrw.jdField_a_of_type_Long)) {
        break label169;
      }
      localbbrv.jdField_a_of_type_Long = parambbrx.jdField_b_of_type_Long;
      label124:
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, isRaw, compressInfo.desBitRate = " + localbbrv.jdField_a_of_type_Long);
      }
    }
    label169:
    label189:
    label352:
    label742:
    for (;;)
    {
      return localbbrv;
      i = 30;
      break;
      localbbrv.jdField_a_of_type_Long = ((int)(parambbrw.jdField_a_of_type_Long / parambbrx.d));
      break label124;
      double d2;
      double d1;
      if (parambbrx.jdField_a_of_type_Int <= parambbrx.jdField_b_of_type_Int)
      {
        i = parambbrx.jdField_b_of_type_Int;
        if (i <= parambbrw.jdField_a_of_type_Int) {
          break label692;
        }
        localbbrv.jdField_a_of_type_Float = (parambbrw.jdField_a_of_type_Int / i);
        localbbrv.jdField_a_of_type_Int = ((int)(parambbrx.jdField_a_of_type_Int * localbbrv.jdField_a_of_type_Float));
        localbbrv.jdField_b_of_type_Int = ((int)(parambbrx.jdField_b_of_type_Int * localbbrv.jdField_a_of_type_Float));
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,  config.scaleRate = " + localbbrv.jdField_a_of_type_Float + ", compressInfo.desWidth = " + localbbrv.jdField_a_of_type_Int + ", compressInfo.desHeight = " + localbbrv.jdField_b_of_type_Int);
        }
        if ((parambbrx.e <= 0) || (parambbrx.e >= parambbrw.jdField_b_of_type_Int)) {
          break label719;
        }
        localbbrv.jdField_b_of_type_Long = parambbrx.e;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, compressInfo.desFPS = " + localbbrv.jdField_b_of_type_Long);
        }
        d2 = localbbrv.jdField_a_of_type_Int * localbbrv.jdField_b_of_type_Int * localbbrv.jdField_b_of_type_Long * parambbrw.jdField_a_of_type_Double;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp = " + d2);
        }
        d1 = d2;
        if (d2 > parambbrx.jdField_b_of_type_Long) {
          d1 = parambbrx.jdField_b_of_type_Long;
        }
        d2 = d1;
        if (d1 > parambbrw.c) {
          d2 = parambbrw.c;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp real = " + d2);
        }
        if (parambbrx.d * d2 <= parambbrw.jdField_a_of_type_Long) {
          break label732;
        }
        d2 = parambbrw.jdField_a_of_type_Long / (localbbrv.jdField_a_of_type_Int * localbbrv.jdField_b_of_type_Int * localbbrv.jdField_b_of_type_Long * parambbrx.d);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,densityExp = " + d2);
        }
        d1 = d2;
        if (d2 < parambbrw.jdField_b_of_type_Double) {
          d1 = parambbrw.jdField_b_of_type_Double;
        }
      }
      for (localbbrv.jdField_a_of_type_Long = ((int)(d1 * (localbbrv.jdField_a_of_type_Int * localbbrv.jdField_b_of_type_Int * localbbrv.jdField_b_of_type_Long)));; localbbrv.jdField_a_of_type_Long = ((int)d2))
      {
        if (!QLog.isColorLevel()) {
          break label742;
        }
        QLog.d("VideoCompressConfig", 2, "getCompressInfo,  compressInfo.desBitRate " + localbbrv.jdField_a_of_type_Long);
        return localbbrv;
        i = parambbrx.jdField_a_of_type_Int;
        break;
        localbbrv.jdField_a_of_type_Float = 1.0F;
        localbbrv.jdField_a_of_type_Int = parambbrx.jdField_a_of_type_Int;
        localbbrv.jdField_b_of_type_Int = parambbrx.jdField_b_of_type_Int;
        break label263;
        localbbrv.jdField_b_of_type_Long = parambbrw.jdField_b_of_type_Int;
        break label352;
      }
    }
  }
  
  public static bbrw a(QQAppInterface paramQQAppInterface)
  {
    bbrw localbbrw = new bbrw();
    if (paramQQAppInterface == null) {
      QLog.e("VideoCompressConfig", 1, "getManageConfig, app is null.");
    }
    do
    {
      return localbbrw;
      paramQQAppInterface = bfyz.p(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
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
          localbbrw.jdField_a_of_type_Int = i;
        }
        i = Integer.valueOf(paramQQAppInterface[1]).intValue();
        if (i > 0) {
          localbbrw.jdField_b_of_type_Int = i;
        }
        double d = Double.valueOf(paramQQAppInterface[2]).doubleValue();
        if (d > 0.0D) {
          localbbrw.jdField_a_of_type_Double = d;
        }
        d = Double.valueOf(paramQQAppInterface[3]).doubleValue();
        if (d > 0.0D) {
          localbbrw.jdField_b_of_type_Double = d;
        }
        if ((paramQQAppInterface.length >= 6) && (paramQQAppInterface[5] != null) && (paramQQAppInterface[5].length() > 0))
        {
          i = Integer.valueOf(paramQQAppInterface[5]).intValue();
          if (i > 0) {
            localbbrw.jdField_a_of_type_Long = (i * 1024 * 1024 * 8);
          }
        }
        long l;
        if ((paramQQAppInterface.length >= 8) && (paramQQAppInterface[7] != null) && (paramQQAppInterface[7].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[7]).longValue();
          if (l > 0L) {
            localbbrw.c = l;
          }
        }
        if ((paramQQAppInterface.length >= 9) && (paramQQAppInterface[8] != null) && (paramQQAppInterface[8].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[8]).longValue();
          if (l > 0L) {
            localbbrw.jdField_b_of_type_Long = l;
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
    QLog.d("VideoCompressConfig", 2, "getManageConfig, maxLength = " + localbbrw.jdField_a_of_type_Int + ", maxFPS = " + localbbrw.jdField_b_of_type_Int + ", maxDensity = " + localbbrw.jdField_a_of_type_Double + ", minDensity = " + localbbrw.jdField_b_of_type_Double + ", maxSize = " + localbbrw.jdField_a_of_type_Long + ", maxBitRate = " + localbbrw.c + ", minBitRate = " + localbbrw.jdField_b_of_type_Long);
    return localbbrw;
  }
  
  public static bbrx a(String paramString)
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
    bbrx localbbrx = new bbrx();
    localbbrx.jdField_a_of_type_Long = ((File)localObject).length();
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
        localbbrx.jdField_a_of_type_Int = Integer.valueOf(paramString).intValue();
        localbbrx.jdField_b_of_type_Int = Integer.valueOf(str1).intValue();
        localbbrx.c = Integer.valueOf(str2).intValue();
        localbbrx.d = ((int)(Integer.valueOf(str3).intValue() / 1000.0D + 0.5D));
        localbbrx.e = ((int)(Integer.valueOf(str4).intValue() * 1.0D / localbbrx.d + 0.5D));
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
      if (localbbrx.d > 0) {
        localbbrx.jdField_b_of_type_Long = (localbbrx.jdField_a_of_type_Long * 8L / localbbrx.d);
      }
      paramString = localbbrx;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoCompressConfig", 2, "getVideoInfo, fileSize = " + localbbrx.jdField_a_of_type_Long + ", width = " + localbbrx.jdField_a_of_type_Int + ", height = " + localbbrx.jdField_b_of_type_Int + ", rotation = " + localbbrx.c + ", duration = " + localbbrx.d + ", fps = " + localbbrx.e + ", videoInfo.bitRate = " + localbbrx.jdField_b_of_type_Long);
      return localbbrx;
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
            localbbrx.jdField_a_of_type_Int = localObject[1];
            localbbrx.jdField_b_of_type_Int = localObject[2];
            localbbrx.c = Integer.valueOf(ShortVideoTrimmer.getVideoRotate(localObject[3])).intValue();
            localbbrx.d = ((int)(localObject[4] / 1000.0D + 0.5D));
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("VideoCompressConfig", 1, "getVideoInfo error.", paramString);
      }
    }
  }
  
  public static boolean a(bbrx parambbrx, bbrw parambbrw)
  {
    if ((parambbrx == null) || (parambbrw == null))
    {
      QLog.e("VideoCompressConfig", 1, "isNeedCompress, false, videoInfo or config is null");
      return false;
    }
    if (parambbrx.jdField_a_of_type_Long * 8L > parambbrw.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, fileSize > maxSize, fileSize = " + parambbrx.jdField_a_of_type_Long);
      }
      return true;
    }
    if (parambbrx.jdField_b_of_type_Long < parambbrw.jdField_b_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress,false, bitRate < minBitRate, bitRate = " + parambbrx.jdField_b_of_type_Long + ", minBitRate = " + parambbrw.jdField_b_of_type_Long);
      }
      return false;
    }
    if (parambbrx.jdField_b_of_type_Long > parambbrw.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, bitRate > maxBitRate, bitRate = " + parambbrx.jdField_b_of_type_Long + ", maxBitRate = " + parambbrw.c);
      }
      return true;
    }
    if (parambbrx.e > 0) {}
    for (int i = parambbrx.e;; i = 30)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, videoFps = " + i);
      }
      if (parambbrx.jdField_b_of_type_Long <= parambbrx.jdField_a_of_type_Int * parambbrx.jdField_b_of_type_Int * i * parambbrw.jdField_a_of_type_Double * 1.2D) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, density > 1.2 * maxDensty. bitRate = " + parambbrx.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (parambbrx.jdField_a_of_type_Int * parambbrx.jdField_b_of_type_Int) * parambbrw.jdField_a_of_type_Double * 1.2D);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressConfig", 2, "isNeedCompress, false, density <= 1.2 * maxDensty. bitRate = " + parambbrx.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (parambbrx.jdField_a_of_type_Int * parambbrx.jdField_b_of_type_Int) * parambbrw.jdField_a_of_type_Double * 1.2D);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbru
 * JD-Core Version:    0.7.0.1
 */