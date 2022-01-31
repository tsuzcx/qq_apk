import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class aqne
{
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = SafeBitmapFactory.safeDecode(paramString, paramOptions);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (paramInt1 >= paramInt2) {}
      paramOptions.inSampleSize *= 2;
    }
    return localObject;
    return a(paramString, paramOptions, paramInt1 + 1, paramInt2);
  }
  
  public static String a(Bitmap paramBitmap, String paramString, int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[3];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = 60;
    int[] tmp12_7 = tmp7_5;
    tmp12_7[1] = 40;
    int[] tmp17_12 = tmp12_7;
    tmp17_12[2] = 20;
    tmp17_12;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    boolean bool = false;
    int i = 0;
    for (;;)
    {
      if (i < arrayOfInt.length)
      {
        bool = a(paramBitmap, localByteArrayOutputStream, arrayOfInt[i]);
        if ((!bool) || (localByteArrayOutputStream.size() >= 6750000)) {}
      }
      else
      {
        if (i >= arrayOfInt.length) {
          bool = a(paramBitmap, localByteArrayOutputStream, 10);
        }
        if (bool) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e(aqne.class.getName(), 2, "compressBmpToFixedSize fail!");
        }
        return null;
      }
      i += 1;
    }
    paramArrayOfInt[0] = paramBitmap.getWidth();
    paramArrayOfInt[1] = paramBitmap.getHeight();
    paramBitmap = aubr.a(new File(paramString).getName(), false);
    try
    {
      paramString = new FileOutputStream(new File(paramBitmap));
      paramString.write(localByteArrayOutputStream.toByteArray());
      paramString.flush();
      paramString.close();
      return paramBitmap;
    }
    catch (Exception paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(aqne.class.getName(), 2, "compressBmpToFixedSize save fail!");
        }
        paramBitmap = null;
      }
    }
  }
  
  public static String a(String paramString)
  {
    System.currentTimeMillis();
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      paramString = str1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        paramString = new File(paramString);
        if (!paramString.exists()) {
          break label56;
        }
        try
        {
          String str2 = bfko.a(paramString);
          paramString = str2;
          if (str2 != null) {
            continue;
          }
          return "";
        }
        catch (IOException paramString)
        {
          return "";
        }
      }
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    return paramString;
    label56:
    return "";
  }
  
  private static boolean a(Bitmap paramBitmap, ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
  {
    try
    {
      paramByteArrayOutputStream.reset();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, paramByteArrayOutputStream);
      return true;
    }
    catch (Exception paramBitmap)
    {
      if (QLog.isColorLevel()) {
        QLog.e(aqne.class.getName(), 2, "doCompress Exception:", paramBitmap);
      }
      paramByteArrayOutputStream.reset();
      return false;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      if (QLog.isColorLevel()) {
        QLog.e(aqne.class.getName(), 2, "doCompress OutOfMemoryError:", paramBitmap);
      }
      paramByteArrayOutputStream.reset();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqne
 * JD-Core Version:    0.7.0.1
 */