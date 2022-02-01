import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bcft
{
  public static bcfu a(bcfw parambcfw, bcfv parambcfv, boolean paramBoolean)
  {
    bcfu localbcfu = new bcfu();
    int i;
    if (parambcfw.e > 0)
    {
      i = parambcfw.e;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, videoFps = " + i);
      }
      if (!paramBoolean) {
        break label189;
      }
      localbcfu.jdField_a_of_type_Float = 1.0F;
      localbcfu.jdField_a_of_type_Int = parambcfw.jdField_a_of_type_Int;
      localbcfu.jdField_b_of_type_Int = parambcfw.jdField_b_of_type_Int;
      localbcfu.jdField_b_of_type_Long = i;
      if ((parambcfw.jdField_a_of_type_Long <= 0L) || (parambcfw.jdField_a_of_type_Long * 8L >= parambcfv.jdField_a_of_type_Long)) {
        break label169;
      }
      localbcfu.jdField_a_of_type_Long = parambcfw.jdField_b_of_type_Long;
      label124:
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, isRaw, compressInfo.desBitRate = " + localbcfu.jdField_a_of_type_Long);
      }
    }
    label169:
    label189:
    label352:
    label742:
    for (;;)
    {
      return localbcfu;
      i = 30;
      break;
      localbcfu.jdField_a_of_type_Long = ((int)(parambcfv.jdField_a_of_type_Long / parambcfw.d));
      break label124;
      double d2;
      double d1;
      if (parambcfw.jdField_a_of_type_Int <= parambcfw.jdField_b_of_type_Int)
      {
        i = parambcfw.jdField_b_of_type_Int;
        if (i <= parambcfv.jdField_a_of_type_Int) {
          break label692;
        }
        localbcfu.jdField_a_of_type_Float = (parambcfv.jdField_a_of_type_Int / i);
        localbcfu.jdField_a_of_type_Int = ((int)(parambcfw.jdField_a_of_type_Int * localbcfu.jdField_a_of_type_Float));
        localbcfu.jdField_b_of_type_Int = ((int)(parambcfw.jdField_b_of_type_Int * localbcfu.jdField_a_of_type_Float));
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,  config.scaleRate = " + localbcfu.jdField_a_of_type_Float + ", compressInfo.desWidth = " + localbcfu.jdField_a_of_type_Int + ", compressInfo.desHeight = " + localbcfu.jdField_b_of_type_Int);
        }
        if ((parambcfw.e <= 0) || (parambcfw.e >= parambcfv.jdField_b_of_type_Int)) {
          break label719;
        }
        localbcfu.jdField_b_of_type_Long = parambcfw.e;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, compressInfo.desFPS = " + localbcfu.jdField_b_of_type_Long);
        }
        d2 = localbcfu.jdField_a_of_type_Int * localbcfu.jdField_b_of_type_Int * localbcfu.jdField_b_of_type_Long * parambcfv.jdField_a_of_type_Double;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp = " + d2);
        }
        d1 = d2;
        if (d2 > parambcfw.jdField_b_of_type_Long) {
          d1 = parambcfw.jdField_b_of_type_Long;
        }
        d2 = d1;
        if (d1 > parambcfv.c) {
          d2 = parambcfv.c;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp real = " + d2);
        }
        if (parambcfw.d * d2 <= parambcfv.jdField_a_of_type_Long) {
          break label732;
        }
        d2 = parambcfv.jdField_a_of_type_Long / (localbcfu.jdField_a_of_type_Int * localbcfu.jdField_b_of_type_Int * localbcfu.jdField_b_of_type_Long * parambcfw.d);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,densityExp = " + d2);
        }
        d1 = d2;
        if (d2 < parambcfv.jdField_b_of_type_Double) {
          d1 = parambcfv.jdField_b_of_type_Double;
        }
      }
      for (localbcfu.jdField_a_of_type_Long = ((int)(d1 * (localbcfu.jdField_a_of_type_Int * localbcfu.jdField_b_of_type_Int * localbcfu.jdField_b_of_type_Long)));; localbcfu.jdField_a_of_type_Long = ((int)d2))
      {
        if (!QLog.isColorLevel()) {
          break label742;
        }
        QLog.d("VideoCompressConfig", 2, "getCompressInfo,  compressInfo.desBitRate " + localbcfu.jdField_a_of_type_Long);
        return localbcfu;
        i = parambcfw.jdField_a_of_type_Int;
        break;
        localbcfu.jdField_a_of_type_Float = 1.0F;
        localbcfu.jdField_a_of_type_Int = parambcfw.jdField_a_of_type_Int;
        localbcfu.jdField_b_of_type_Int = parambcfw.jdField_b_of_type_Int;
        break label263;
        localbcfu.jdField_b_of_type_Long = parambcfv.jdField_b_of_type_Int;
        break label352;
      }
    }
  }
  
  public static bcfv a(QQAppInterface paramQQAppInterface)
  {
    bcfv localbcfv = new bcfv();
    if (paramQQAppInterface == null) {
      QLog.e("VideoCompressConfig", 1, "getManageConfig, app is null.");
    }
    do
    {
      return localbcfv;
      paramQQAppInterface = bgsg.p(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
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
          localbcfv.jdField_a_of_type_Int = i;
        }
        i = Integer.valueOf(paramQQAppInterface[1]).intValue();
        if (i > 0) {
          localbcfv.jdField_b_of_type_Int = i;
        }
        double d = Double.valueOf(paramQQAppInterface[2]).doubleValue();
        if (d > 0.0D) {
          localbcfv.jdField_a_of_type_Double = d;
        }
        d = Double.valueOf(paramQQAppInterface[3]).doubleValue();
        if (d > 0.0D) {
          localbcfv.jdField_b_of_type_Double = d;
        }
        if ((paramQQAppInterface.length >= 6) && (paramQQAppInterface[5] != null) && (paramQQAppInterface[5].length() > 0))
        {
          i = Integer.valueOf(paramQQAppInterface[5]).intValue();
          if (i > 0) {
            localbcfv.jdField_a_of_type_Long = (i * 1024 * 1024 * 8);
          }
        }
        long l;
        if ((paramQQAppInterface.length >= 8) && (paramQQAppInterface[7] != null) && (paramQQAppInterface[7].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[7]).longValue();
          if (l > 0L) {
            localbcfv.c = l;
          }
        }
        if ((paramQQAppInterface.length >= 9) && (paramQQAppInterface[8] != null) && (paramQQAppInterface[8].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[8]).longValue();
          if (l > 0L) {
            localbcfv.jdField_b_of_type_Long = l;
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
    QLog.d("VideoCompressConfig", 2, "getManageConfig, maxLength = " + localbcfv.jdField_a_of_type_Int + ", maxFPS = " + localbcfv.jdField_b_of_type_Int + ", maxDensity = " + localbcfv.jdField_a_of_type_Double + ", minDensity = " + localbcfv.jdField_b_of_type_Double + ", maxSize = " + localbcfv.jdField_a_of_type_Long + ", maxBitRate = " + localbcfv.c + ", minBitRate = " + localbcfv.jdField_b_of_type_Long);
    return localbcfv;
  }
  
  public static bcfw a(String paramString)
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
    bcfw localbcfw = new bcfw();
    localbcfw.jdField_a_of_type_Long = ((File)localObject).length();
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
        localbcfw.jdField_a_of_type_Int = Integer.valueOf(paramString).intValue();
        localbcfw.jdField_b_of_type_Int = Integer.valueOf(str1).intValue();
        localbcfw.c = Integer.valueOf(str2).intValue();
        localbcfw.d = ((int)(Integer.valueOf(str3).intValue() / 1000.0D + 0.5D));
        localbcfw.e = ((int)(Integer.valueOf(str4).intValue() * 1.0D / localbcfw.d + 0.5D));
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
      if (localbcfw.d > 0) {
        localbcfw.jdField_b_of_type_Long = (localbcfw.jdField_a_of_type_Long * 8L / localbcfw.d);
      }
      paramString = localbcfw;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoCompressConfig", 2, "getVideoInfo, fileSize = " + localbcfw.jdField_a_of_type_Long + ", width = " + localbcfw.jdField_a_of_type_Int + ", height = " + localbcfw.jdField_b_of_type_Int + ", rotation = " + localbcfw.c + ", duration = " + localbcfw.d + ", fps = " + localbcfw.e + ", videoInfo.bitRate = " + localbcfw.jdField_b_of_type_Long);
      return localbcfw;
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
            localbcfw.jdField_a_of_type_Int = localObject[1];
            localbcfw.jdField_b_of_type_Int = localObject[2];
            localbcfw.c = Integer.valueOf(ShortVideoTrimmer.a(localObject[3])).intValue();
            localbcfw.d = ((int)(localObject[4] / 1000.0D + 0.5D));
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("VideoCompressConfig", 1, "getVideoInfo error.", paramString);
      }
    }
  }
  
  public static boolean a(bcfw parambcfw, bcfv parambcfv)
  {
    if ((parambcfw == null) || (parambcfv == null))
    {
      QLog.e("VideoCompressConfig", 1, "isNeedCompress, false, videoInfo or config is null");
      return false;
    }
    if (parambcfw.jdField_a_of_type_Long * 8L > parambcfv.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, fileSize > maxSize, fileSize = " + parambcfw.jdField_a_of_type_Long);
      }
      return true;
    }
    if (parambcfw.jdField_b_of_type_Long < parambcfv.jdField_b_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress,false, bitRate < minBitRate, bitRate = " + parambcfw.jdField_b_of_type_Long + ", minBitRate = " + parambcfv.jdField_b_of_type_Long);
      }
      return false;
    }
    if (parambcfw.jdField_b_of_type_Long > parambcfv.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, bitRate > maxBitRate, bitRate = " + parambcfw.jdField_b_of_type_Long + ", maxBitRate = " + parambcfv.c);
      }
      return true;
    }
    if (parambcfw.e > 0) {}
    for (int i = parambcfw.e;; i = 30)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, videoFps = " + i);
      }
      if (parambcfw.jdField_b_of_type_Long <= parambcfw.jdField_a_of_type_Int * parambcfw.jdField_b_of_type_Int * i * parambcfv.jdField_a_of_type_Double * 1.2D) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, density > 1.2 * maxDensty. bitRate = " + parambcfw.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (parambcfw.jdField_a_of_type_Int * parambcfw.jdField_b_of_type_Int) * parambcfv.jdField_a_of_type_Double * 1.2D);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressConfig", 2, "isNeedCompress, false, density <= 1.2 * maxDensty. bitRate = " + parambcfw.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (parambcfw.jdField_a_of_type_Int * parambcfw.jdField_b_of_type_Int) * parambcfv.jdField_a_of_type_Double * 1.2D);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcft
 * JD-Core Version:    0.7.0.1
 */