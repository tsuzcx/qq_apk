import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class azak
{
  public static azal a(azan paramazan, azam paramazam, boolean paramBoolean)
  {
    azal localazal = new azal();
    int i;
    if (paramazan.e > 0)
    {
      i = paramazan.e;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, videoFps = " + i);
      }
      if (!paramBoolean) {
        break label189;
      }
      localazal.jdField_a_of_type_Float = 1.0F;
      localazal.jdField_a_of_type_Int = paramazan.jdField_a_of_type_Int;
      localazal.jdField_b_of_type_Int = paramazan.jdField_b_of_type_Int;
      localazal.jdField_b_of_type_Long = i;
      if ((paramazan.jdField_a_of_type_Long <= 0L) || (paramazan.jdField_a_of_type_Long * 8L >= paramazam.jdField_a_of_type_Long)) {
        break label169;
      }
      localazal.jdField_a_of_type_Long = paramazan.jdField_b_of_type_Long;
      label124:
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, isRaw, compressInfo.desBitRate = " + localazal.jdField_a_of_type_Long);
      }
    }
    label169:
    label189:
    label352:
    label742:
    for (;;)
    {
      return localazal;
      i = 30;
      break;
      localazal.jdField_a_of_type_Long = ((int)(paramazam.jdField_a_of_type_Long / paramazan.d));
      break label124;
      double d2;
      double d1;
      if (paramazan.jdField_a_of_type_Int <= paramazan.jdField_b_of_type_Int)
      {
        i = paramazan.jdField_b_of_type_Int;
        if (i <= paramazam.jdField_a_of_type_Int) {
          break label692;
        }
        localazal.jdField_a_of_type_Float = (paramazam.jdField_a_of_type_Int / i);
        localazal.jdField_a_of_type_Int = ((int)(paramazan.jdField_a_of_type_Int * localazal.jdField_a_of_type_Float));
        localazal.jdField_b_of_type_Int = ((int)(paramazan.jdField_b_of_type_Int * localazal.jdField_a_of_type_Float));
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,  config.scaleRate = " + localazal.jdField_a_of_type_Float + ", compressInfo.desWidth = " + localazal.jdField_a_of_type_Int + ", compressInfo.desHeight = " + localazal.jdField_b_of_type_Int);
        }
        if ((paramazan.e <= 0) || (paramazan.e >= paramazam.jdField_b_of_type_Int)) {
          break label719;
        }
        localazal.jdField_b_of_type_Long = paramazan.e;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, compressInfo.desFPS = " + localazal.jdField_b_of_type_Long);
        }
        d2 = localazal.jdField_a_of_type_Int * localazal.jdField_b_of_type_Int * localazal.jdField_b_of_type_Long * paramazam.jdField_a_of_type_Double;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp = " + d2);
        }
        d1 = d2;
        if (d2 > paramazan.jdField_b_of_type_Long) {
          d1 = paramazan.jdField_b_of_type_Long;
        }
        d2 = d1;
        if (d1 > paramazam.c) {
          d2 = paramazam.c;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp real = " + d2);
        }
        if (paramazan.d * d2 <= paramazam.jdField_a_of_type_Long) {
          break label732;
        }
        d2 = paramazam.jdField_a_of_type_Long / (localazal.jdField_a_of_type_Int * localazal.jdField_b_of_type_Int * localazal.jdField_b_of_type_Long * paramazan.d);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,densityExp = " + d2);
        }
        d1 = d2;
        if (d2 < paramazam.jdField_b_of_type_Double) {
          d1 = paramazam.jdField_b_of_type_Double;
        }
      }
      for (localazal.jdField_a_of_type_Long = ((int)(d1 * (localazal.jdField_a_of_type_Int * localazal.jdField_b_of_type_Int * localazal.jdField_b_of_type_Long)));; localazal.jdField_a_of_type_Long = ((int)d2))
      {
        if (!QLog.isColorLevel()) {
          break label742;
        }
        QLog.d("VideoCompressConfig", 2, "getCompressInfo,  compressInfo.desBitRate " + localazal.jdField_a_of_type_Long);
        return localazal;
        i = paramazan.jdField_a_of_type_Int;
        break;
        localazal.jdField_a_of_type_Float = 1.0F;
        localazal.jdField_a_of_type_Int = paramazan.jdField_a_of_type_Int;
        localazal.jdField_b_of_type_Int = paramazan.jdField_b_of_type_Int;
        break label263;
        localazal.jdField_b_of_type_Long = paramazam.jdField_b_of_type_Int;
        break label352;
      }
    }
  }
  
  public static azam a(QQAppInterface paramQQAppInterface)
  {
    azam localazam = new azam();
    if (paramQQAppInterface == null) {
      QLog.e("VideoCompressConfig", 1, "getManageConfig, app is null.");
    }
    do
    {
      return localazam;
      paramQQAppInterface = bdiv.p(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
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
          localazam.jdField_a_of_type_Int = i;
        }
        i = Integer.valueOf(paramQQAppInterface[1]).intValue();
        if (i > 0) {
          localazam.jdField_b_of_type_Int = i;
        }
        double d = Double.valueOf(paramQQAppInterface[2]).doubleValue();
        if (d > 0.0D) {
          localazam.jdField_a_of_type_Double = d;
        }
        d = Double.valueOf(paramQQAppInterface[3]).doubleValue();
        if (d > 0.0D) {
          localazam.jdField_b_of_type_Double = d;
        }
        if ((paramQQAppInterface.length >= 6) && (paramQQAppInterface[5] != null) && (paramQQAppInterface[5].length() > 0))
        {
          i = Integer.valueOf(paramQQAppInterface[5]).intValue();
          if (i > 0) {
            localazam.jdField_a_of_type_Long = (i * 1024 * 1024 * 8);
          }
        }
        long l;
        if ((paramQQAppInterface.length >= 8) && (paramQQAppInterface[7] != null) && (paramQQAppInterface[7].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[7]).longValue();
          if (l > 0L) {
            localazam.c = l;
          }
        }
        if ((paramQQAppInterface.length >= 9) && (paramQQAppInterface[8] != null) && (paramQQAppInterface[8].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[8]).longValue();
          if (l > 0L) {
            localazam.jdField_b_of_type_Long = l;
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
    QLog.d("VideoCompressConfig", 2, "getManageConfig, maxLength = " + localazam.jdField_a_of_type_Int + ", maxFPS = " + localazam.jdField_b_of_type_Int + ", maxDensity = " + localazam.jdField_a_of_type_Double + ", minDensity = " + localazam.jdField_b_of_type_Double + ", maxSize = " + localazam.jdField_a_of_type_Long + ", maxBitRate = " + localazam.c + ", minBitRate = " + localazam.jdField_b_of_type_Long);
    return localazam;
  }
  
  public static azan a(String paramString)
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
    azan localazan = new azan();
    localazan.jdField_a_of_type_Long = ((File)localObject).length();
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
        localazan.jdField_a_of_type_Int = Integer.valueOf(paramString).intValue();
        localazan.jdField_b_of_type_Int = Integer.valueOf(str1).intValue();
        localazan.c = Integer.valueOf(str2).intValue();
        localazan.d = ((int)(Integer.valueOf(str3).intValue() / 1000.0D + 0.5D));
        localazan.e = ((int)(Integer.valueOf(str4).intValue() * 1.0D / localazan.d + 0.5D));
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
      if (localazan.d > 0) {
        localazan.jdField_b_of_type_Long = (localazan.jdField_a_of_type_Long * 8L / localazan.d);
      }
      paramString = localazan;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoCompressConfig", 2, "getVideoInfo, fileSize = " + localazan.jdField_a_of_type_Long + ", width = " + localazan.jdField_a_of_type_Int + ", height = " + localazan.jdField_b_of_type_Int + ", rotation = " + localazan.c + ", duration = " + localazan.d + ", fps = " + localazan.e + ", videoInfo.bitRate = " + localazan.jdField_b_of_type_Long);
      return localazan;
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
            localazan.jdField_a_of_type_Int = localObject[1];
            localazan.jdField_b_of_type_Int = localObject[2];
            localazan.c = Integer.valueOf(ShortVideoTrimmer.a(localObject[3])).intValue();
            localazan.d = ((int)(localObject[4] / 1000.0D + 0.5D));
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("VideoCompressConfig", 1, "getVideoInfo error.", paramString);
      }
    }
  }
  
  public static boolean a(azan paramazan, azam paramazam)
  {
    if ((paramazan == null) || (paramazam == null))
    {
      QLog.e("VideoCompressConfig", 1, "isNeedCompress, false, videoInfo or config is null");
      return false;
    }
    if (paramazan.jdField_a_of_type_Long * 8L > paramazam.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, fileSize > maxSize, fileSize = " + paramazan.jdField_a_of_type_Long);
      }
      return true;
    }
    if (paramazan.jdField_b_of_type_Long < paramazam.jdField_b_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress,false, bitRate < minBitRate, bitRate = " + paramazan.jdField_b_of_type_Long + ", minBitRate = " + paramazam.jdField_b_of_type_Long);
      }
      return false;
    }
    if (paramazan.jdField_b_of_type_Long > paramazam.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, bitRate > maxBitRate, bitRate = " + paramazan.jdField_b_of_type_Long + ", maxBitRate = " + paramazam.c);
      }
      return true;
    }
    if (paramazan.e > 0) {}
    for (int i = paramazan.e;; i = 30)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, videoFps = " + i);
      }
      if (paramazan.jdField_b_of_type_Long <= paramazan.jdField_a_of_type_Int * paramazan.jdField_b_of_type_Int * i * paramazam.jdField_a_of_type_Double * 1.2D) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, density > 1.2 * maxDensty. bitRate = " + paramazan.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (paramazan.jdField_a_of_type_Int * paramazan.jdField_b_of_type_Int) * paramazam.jdField_a_of_type_Double * 1.2D);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressConfig", 2, "isNeedCompress, false, density <= 1.2 * maxDensty. bitRate = " + paramazan.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (paramazan.jdField_a_of_type_Int * paramazan.jdField_b_of_type_Int) * paramazam.jdField_a_of_type_Double * 1.2D);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azak
 * JD-Core Version:    0.7.0.1
 */