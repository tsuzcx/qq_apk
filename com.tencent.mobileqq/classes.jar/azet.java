import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class azet
{
  public static azeu a(azew paramazew, azev paramazev, boolean paramBoolean)
  {
    azeu localazeu = new azeu();
    int i;
    if (paramazew.e > 0)
    {
      i = paramazew.e;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, videoFps = " + i);
      }
      if (!paramBoolean) {
        break label189;
      }
      localazeu.jdField_a_of_type_Float = 1.0F;
      localazeu.jdField_a_of_type_Int = paramazew.jdField_a_of_type_Int;
      localazeu.jdField_b_of_type_Int = paramazew.jdField_b_of_type_Int;
      localazeu.jdField_b_of_type_Long = i;
      if ((paramazew.jdField_a_of_type_Long <= 0L) || (paramazew.jdField_a_of_type_Long * 8L >= paramazev.jdField_a_of_type_Long)) {
        break label169;
      }
      localazeu.jdField_a_of_type_Long = paramazew.jdField_b_of_type_Long;
      label124:
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, isRaw, compressInfo.desBitRate = " + localazeu.jdField_a_of_type_Long);
      }
    }
    label169:
    label189:
    label352:
    label742:
    for (;;)
    {
      return localazeu;
      i = 30;
      break;
      localazeu.jdField_a_of_type_Long = ((int)(paramazev.jdField_a_of_type_Long / paramazew.d));
      break label124;
      double d2;
      double d1;
      if (paramazew.jdField_a_of_type_Int <= paramazew.jdField_b_of_type_Int)
      {
        i = paramazew.jdField_b_of_type_Int;
        if (i <= paramazev.jdField_a_of_type_Int) {
          break label692;
        }
        localazeu.jdField_a_of_type_Float = (paramazev.jdField_a_of_type_Int / i);
        localazeu.jdField_a_of_type_Int = ((int)(paramazew.jdField_a_of_type_Int * localazeu.jdField_a_of_type_Float));
        localazeu.jdField_b_of_type_Int = ((int)(paramazew.jdField_b_of_type_Int * localazeu.jdField_a_of_type_Float));
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,  config.scaleRate = " + localazeu.jdField_a_of_type_Float + ", compressInfo.desWidth = " + localazeu.jdField_a_of_type_Int + ", compressInfo.desHeight = " + localazeu.jdField_b_of_type_Int);
        }
        if ((paramazew.e <= 0) || (paramazew.e >= paramazev.jdField_b_of_type_Int)) {
          break label719;
        }
        localazeu.jdField_b_of_type_Long = paramazew.e;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, compressInfo.desFPS = " + localazeu.jdField_b_of_type_Long);
        }
        d2 = localazeu.jdField_a_of_type_Int * localazeu.jdField_b_of_type_Int * localazeu.jdField_b_of_type_Long * paramazev.jdField_a_of_type_Double;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp = " + d2);
        }
        d1 = d2;
        if (d2 > paramazew.jdField_b_of_type_Long) {
          d1 = paramazew.jdField_b_of_type_Long;
        }
        d2 = d1;
        if (d1 > paramazev.c) {
          d2 = paramazev.c;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp real = " + d2);
        }
        if (paramazew.d * d2 <= paramazev.jdField_a_of_type_Long) {
          break label732;
        }
        d2 = paramazev.jdField_a_of_type_Long / (localazeu.jdField_a_of_type_Int * localazeu.jdField_b_of_type_Int * localazeu.jdField_b_of_type_Long * paramazew.d);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,densityExp = " + d2);
        }
        d1 = d2;
        if (d2 < paramazev.jdField_b_of_type_Double) {
          d1 = paramazev.jdField_b_of_type_Double;
        }
      }
      for (localazeu.jdField_a_of_type_Long = ((int)(d1 * (localazeu.jdField_a_of_type_Int * localazeu.jdField_b_of_type_Int * localazeu.jdField_b_of_type_Long)));; localazeu.jdField_a_of_type_Long = ((int)d2))
      {
        if (!QLog.isColorLevel()) {
          break label742;
        }
        QLog.d("VideoCompressConfig", 2, "getCompressInfo,  compressInfo.desBitRate " + localazeu.jdField_a_of_type_Long);
        return localazeu;
        i = paramazew.jdField_a_of_type_Int;
        break;
        localazeu.jdField_a_of_type_Float = 1.0F;
        localazeu.jdField_a_of_type_Int = paramazew.jdField_a_of_type_Int;
        localazeu.jdField_b_of_type_Int = paramazew.jdField_b_of_type_Int;
        break label263;
        localazeu.jdField_b_of_type_Long = paramazev.jdField_b_of_type_Int;
        break label352;
      }
    }
  }
  
  public static azev a(QQAppInterface paramQQAppInterface)
  {
    azev localazev = new azev();
    if (paramQQAppInterface == null) {
      QLog.e("VideoCompressConfig", 1, "getManageConfig, app is null.");
    }
    do
    {
      return localazev;
      paramQQAppInterface = bdne.p(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
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
          localazev.jdField_a_of_type_Int = i;
        }
        i = Integer.valueOf(paramQQAppInterface[1]).intValue();
        if (i > 0) {
          localazev.jdField_b_of_type_Int = i;
        }
        double d = Double.valueOf(paramQQAppInterface[2]).doubleValue();
        if (d > 0.0D) {
          localazev.jdField_a_of_type_Double = d;
        }
        d = Double.valueOf(paramQQAppInterface[3]).doubleValue();
        if (d > 0.0D) {
          localazev.jdField_b_of_type_Double = d;
        }
        if ((paramQQAppInterface.length >= 6) && (paramQQAppInterface[5] != null) && (paramQQAppInterface[5].length() > 0))
        {
          i = Integer.valueOf(paramQQAppInterface[5]).intValue();
          if (i > 0) {
            localazev.jdField_a_of_type_Long = (i * 1024 * 1024 * 8);
          }
        }
        long l;
        if ((paramQQAppInterface.length >= 8) && (paramQQAppInterface[7] != null) && (paramQQAppInterface[7].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[7]).longValue();
          if (l > 0L) {
            localazev.c = l;
          }
        }
        if ((paramQQAppInterface.length >= 9) && (paramQQAppInterface[8] != null) && (paramQQAppInterface[8].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[8]).longValue();
          if (l > 0L) {
            localazev.jdField_b_of_type_Long = l;
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
    QLog.d("VideoCompressConfig", 2, "getManageConfig, maxLength = " + localazev.jdField_a_of_type_Int + ", maxFPS = " + localazev.jdField_b_of_type_Int + ", maxDensity = " + localazev.jdField_a_of_type_Double + ", minDensity = " + localazev.jdField_b_of_type_Double + ", maxSize = " + localazev.jdField_a_of_type_Long + ", maxBitRate = " + localazev.c + ", minBitRate = " + localazev.jdField_b_of_type_Long);
    return localazev;
  }
  
  public static azew a(String paramString)
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
    azew localazew = new azew();
    localazew.jdField_a_of_type_Long = ((File)localObject).length();
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
        localazew.jdField_a_of_type_Int = Integer.valueOf(paramString).intValue();
        localazew.jdField_b_of_type_Int = Integer.valueOf(str1).intValue();
        localazew.c = Integer.valueOf(str2).intValue();
        localazew.d = ((int)(Integer.valueOf(str3).intValue() / 1000.0D + 0.5D));
        localazew.e = ((int)(Integer.valueOf(str4).intValue() * 1.0D / localazew.d + 0.5D));
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
      if (localazew.d > 0) {
        localazew.jdField_b_of_type_Long = (localazew.jdField_a_of_type_Long * 8L / localazew.d);
      }
      paramString = localazew;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoCompressConfig", 2, "getVideoInfo, fileSize = " + localazew.jdField_a_of_type_Long + ", width = " + localazew.jdField_a_of_type_Int + ", height = " + localazew.jdField_b_of_type_Int + ", rotation = " + localazew.c + ", duration = " + localazew.d + ", fps = " + localazew.e + ", videoInfo.bitRate = " + localazew.jdField_b_of_type_Long);
      return localazew;
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
            localazew.jdField_a_of_type_Int = localObject[1];
            localazew.jdField_b_of_type_Int = localObject[2];
            localazew.c = Integer.valueOf(ShortVideoTrimmer.a(localObject[3])).intValue();
            localazew.d = ((int)(localObject[4] / 1000.0D + 0.5D));
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("VideoCompressConfig", 1, "getVideoInfo error.", paramString);
      }
    }
  }
  
  public static boolean a(azew paramazew, azev paramazev)
  {
    if ((paramazew == null) || (paramazev == null))
    {
      QLog.e("VideoCompressConfig", 1, "isNeedCompress, false, videoInfo or config is null");
      return false;
    }
    if (paramazew.jdField_a_of_type_Long * 8L > paramazev.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, fileSize > maxSize, fileSize = " + paramazew.jdField_a_of_type_Long);
      }
      return true;
    }
    if (paramazew.jdField_b_of_type_Long < paramazev.jdField_b_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress,false, bitRate < minBitRate, bitRate = " + paramazew.jdField_b_of_type_Long + ", minBitRate = " + paramazev.jdField_b_of_type_Long);
      }
      return false;
    }
    if (paramazew.jdField_b_of_type_Long > paramazev.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, bitRate > maxBitRate, bitRate = " + paramazew.jdField_b_of_type_Long + ", maxBitRate = " + paramazev.c);
      }
      return true;
    }
    if (paramazew.e > 0) {}
    for (int i = paramazew.e;; i = 30)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, videoFps = " + i);
      }
      if (paramazew.jdField_b_of_type_Long <= paramazew.jdField_a_of_type_Int * paramazew.jdField_b_of_type_Int * i * paramazev.jdField_a_of_type_Double * 1.2D) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, density > 1.2 * maxDensty. bitRate = " + paramazew.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (paramazew.jdField_a_of_type_Int * paramazew.jdField_b_of_type_Int) * paramazev.jdField_a_of_type_Double * 1.2D);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressConfig", 2, "isNeedCompress, false, density <= 1.2 * maxDensty. bitRate = " + paramazew.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (paramazew.jdField_a_of_type_Int * paramazew.jdField_b_of_type_Int) * paramazev.jdField_a_of_type_Double * 1.2D);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azet
 * JD-Core Version:    0.7.0.1
 */