import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bcyl
{
  public static bcym a(bcyo parambcyo, bcyn parambcyn, boolean paramBoolean)
  {
    bcym localbcym = new bcym();
    int i;
    if (parambcyo.e > 0)
    {
      i = parambcyo.e;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, videoFps = " + i);
      }
      if (!paramBoolean) {
        break label189;
      }
      localbcym.jdField_a_of_type_Float = 1.0F;
      localbcym.jdField_a_of_type_Int = parambcyo.jdField_a_of_type_Int;
      localbcym.jdField_b_of_type_Int = parambcyo.jdField_b_of_type_Int;
      localbcym.jdField_b_of_type_Long = i;
      if ((parambcyo.jdField_a_of_type_Long <= 0L) || (parambcyo.jdField_a_of_type_Long * 8L >= parambcyn.jdField_a_of_type_Long)) {
        break label169;
      }
      localbcym.jdField_a_of_type_Long = parambcyo.jdField_b_of_type_Long;
      label124:
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, isRaw, compressInfo.desBitRate = " + localbcym.jdField_a_of_type_Long);
      }
    }
    label169:
    label189:
    label352:
    label742:
    for (;;)
    {
      return localbcym;
      i = 30;
      break;
      localbcym.jdField_a_of_type_Long = ((int)(parambcyn.jdField_a_of_type_Long / parambcyo.d));
      break label124;
      double d2;
      double d1;
      if (parambcyo.jdField_a_of_type_Int <= parambcyo.jdField_b_of_type_Int)
      {
        i = parambcyo.jdField_b_of_type_Int;
        if (i <= parambcyn.jdField_a_of_type_Int) {
          break label692;
        }
        localbcym.jdField_a_of_type_Float = (parambcyn.jdField_a_of_type_Int / i);
        localbcym.jdField_a_of_type_Int = ((int)(parambcyo.jdField_a_of_type_Int * localbcym.jdField_a_of_type_Float));
        localbcym.jdField_b_of_type_Int = ((int)(parambcyo.jdField_b_of_type_Int * localbcym.jdField_a_of_type_Float));
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,  config.scaleRate = " + localbcym.jdField_a_of_type_Float + ", compressInfo.desWidth = " + localbcym.jdField_a_of_type_Int + ", compressInfo.desHeight = " + localbcym.jdField_b_of_type_Int);
        }
        if ((parambcyo.e <= 0) || (parambcyo.e >= parambcyn.jdField_b_of_type_Int)) {
          break label719;
        }
        localbcym.jdField_b_of_type_Long = parambcyo.e;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, compressInfo.desFPS = " + localbcym.jdField_b_of_type_Long);
        }
        d2 = localbcym.jdField_a_of_type_Int * localbcym.jdField_b_of_type_Int * localbcym.jdField_b_of_type_Long * parambcyn.jdField_a_of_type_Double;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp = " + d2);
        }
        d1 = d2;
        if (d2 > parambcyo.jdField_b_of_type_Long) {
          d1 = parambcyo.jdField_b_of_type_Long;
        }
        d2 = d1;
        if (d1 > parambcyn.c) {
          d2 = parambcyn.c;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp real = " + d2);
        }
        if (parambcyo.d * d2 <= parambcyn.jdField_a_of_type_Long) {
          break label732;
        }
        d2 = parambcyn.jdField_a_of_type_Long / (localbcym.jdField_a_of_type_Int * localbcym.jdField_b_of_type_Int * localbcym.jdField_b_of_type_Long * parambcyo.d);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,densityExp = " + d2);
        }
        d1 = d2;
        if (d2 < parambcyn.jdField_b_of_type_Double) {
          d1 = parambcyn.jdField_b_of_type_Double;
        }
      }
      for (localbcym.jdField_a_of_type_Long = ((int)(d1 * (localbcym.jdField_a_of_type_Int * localbcym.jdField_b_of_type_Int * localbcym.jdField_b_of_type_Long)));; localbcym.jdField_a_of_type_Long = ((int)d2))
      {
        if (!QLog.isColorLevel()) {
          break label742;
        }
        QLog.d("VideoCompressConfig", 2, "getCompressInfo,  compressInfo.desBitRate " + localbcym.jdField_a_of_type_Long);
        return localbcym;
        i = parambcyo.jdField_a_of_type_Int;
        break;
        localbcym.jdField_a_of_type_Float = 1.0F;
        localbcym.jdField_a_of_type_Int = parambcyo.jdField_a_of_type_Int;
        localbcym.jdField_b_of_type_Int = parambcyo.jdField_b_of_type_Int;
        break label263;
        localbcym.jdField_b_of_type_Long = parambcyn.jdField_b_of_type_Int;
        break label352;
      }
    }
  }
  
  public static bcyn a(QQAppInterface paramQQAppInterface)
  {
    bcyn localbcyn = new bcyn();
    if (paramQQAppInterface == null) {
      QLog.e("VideoCompressConfig", 1, "getManageConfig, app is null.");
    }
    do
    {
      return localbcyn;
      paramQQAppInterface = bhsi.p(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
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
          localbcyn.jdField_a_of_type_Int = i;
        }
        i = Integer.valueOf(paramQQAppInterface[1]).intValue();
        if (i > 0) {
          localbcyn.jdField_b_of_type_Int = i;
        }
        double d = Double.valueOf(paramQQAppInterface[2]).doubleValue();
        if (d > 0.0D) {
          localbcyn.jdField_a_of_type_Double = d;
        }
        d = Double.valueOf(paramQQAppInterface[3]).doubleValue();
        if (d > 0.0D) {
          localbcyn.jdField_b_of_type_Double = d;
        }
        if ((paramQQAppInterface.length >= 6) && (paramQQAppInterface[5] != null) && (paramQQAppInterface[5].length() > 0))
        {
          i = Integer.valueOf(paramQQAppInterface[5]).intValue();
          if (i > 0) {
            localbcyn.jdField_a_of_type_Long = (i * 1024 * 1024 * 8);
          }
        }
        long l;
        if ((paramQQAppInterface.length >= 8) && (paramQQAppInterface[7] != null) && (paramQQAppInterface[7].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[7]).longValue();
          if (l > 0L) {
            localbcyn.c = l;
          }
        }
        if ((paramQQAppInterface.length >= 9) && (paramQQAppInterface[8] != null) && (paramQQAppInterface[8].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[8]).longValue();
          if (l > 0L) {
            localbcyn.jdField_b_of_type_Long = l;
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
    QLog.d("VideoCompressConfig", 2, "getManageConfig, maxLength = " + localbcyn.jdField_a_of_type_Int + ", maxFPS = " + localbcyn.jdField_b_of_type_Int + ", maxDensity = " + localbcyn.jdField_a_of_type_Double + ", minDensity = " + localbcyn.jdField_b_of_type_Double + ", maxSize = " + localbcyn.jdField_a_of_type_Long + ", maxBitRate = " + localbcyn.c + ", minBitRate = " + localbcyn.jdField_b_of_type_Long);
    return localbcyn;
  }
  
  public static bcyo a(String paramString)
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
    bcyo localbcyo = new bcyo();
    localbcyo.jdField_a_of_type_Long = ((File)localObject).length();
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
        localbcyo.jdField_a_of_type_Int = Integer.valueOf(paramString).intValue();
        localbcyo.jdField_b_of_type_Int = Integer.valueOf(str1).intValue();
        localbcyo.c = Integer.valueOf(str2).intValue();
        localbcyo.d = ((int)(Integer.valueOf(str3).intValue() / 1000.0D + 0.5D));
        localbcyo.e = ((int)(Integer.valueOf(str4).intValue() * 1.0D / localbcyo.d + 0.5D));
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
      if (localbcyo.d > 0) {
        localbcyo.jdField_b_of_type_Long = (localbcyo.jdField_a_of_type_Long * 8L / localbcyo.d);
      }
      paramString = localbcyo;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoCompressConfig", 2, "getVideoInfo, fileSize = " + localbcyo.jdField_a_of_type_Long + ", width = " + localbcyo.jdField_a_of_type_Int + ", height = " + localbcyo.jdField_b_of_type_Int + ", rotation = " + localbcyo.c + ", duration = " + localbcyo.d + ", fps = " + localbcyo.e + ", videoInfo.bitRate = " + localbcyo.jdField_b_of_type_Long);
      return localbcyo;
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
            localbcyo.jdField_a_of_type_Int = localObject[1];
            localbcyo.jdField_b_of_type_Int = localObject[2];
            localbcyo.c = Integer.valueOf(ShortVideoTrimmer.a(localObject[3])).intValue();
            localbcyo.d = ((int)(localObject[4] / 1000.0D + 0.5D));
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("VideoCompressConfig", 1, "getVideoInfo error.", paramString);
      }
    }
  }
  
  public static boolean a(bcyo parambcyo, bcyn parambcyn)
  {
    if ((parambcyo == null) || (parambcyn == null))
    {
      QLog.e("VideoCompressConfig", 1, "isNeedCompress, false, videoInfo or config is null");
      return false;
    }
    if (parambcyo.jdField_a_of_type_Long * 8L > parambcyn.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, fileSize > maxSize, fileSize = " + parambcyo.jdField_a_of_type_Long);
      }
      return true;
    }
    if (parambcyo.jdField_b_of_type_Long < parambcyn.jdField_b_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress,false, bitRate < minBitRate, bitRate = " + parambcyo.jdField_b_of_type_Long + ", minBitRate = " + parambcyn.jdField_b_of_type_Long);
      }
      return false;
    }
    if (parambcyo.jdField_b_of_type_Long > parambcyn.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, bitRate > maxBitRate, bitRate = " + parambcyo.jdField_b_of_type_Long + ", maxBitRate = " + parambcyn.c);
      }
      return true;
    }
    if (parambcyo.e > 0) {}
    for (int i = parambcyo.e;; i = 30)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, videoFps = " + i);
      }
      if (parambcyo.jdField_b_of_type_Long <= parambcyo.jdField_a_of_type_Int * parambcyo.jdField_b_of_type_Int * i * parambcyn.jdField_a_of_type_Double * 1.2D) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, density > 1.2 * maxDensty. bitRate = " + parambcyo.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (parambcyo.jdField_a_of_type_Int * parambcyo.jdField_b_of_type_Int) * parambcyn.jdField_a_of_type_Double * 1.2D);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressConfig", 2, "isNeedCompress, false, density <= 1.2 * maxDensty. bitRate = " + parambcyo.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (parambcyo.jdField_a_of_type_Int * parambcyo.jdField_b_of_type_Int) * parambcyn.jdField_a_of_type_Double * 1.2D);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcyl
 * JD-Core Version:    0.7.0.1
 */