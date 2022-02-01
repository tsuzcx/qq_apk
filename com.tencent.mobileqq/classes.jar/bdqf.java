import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.SystemClock;
import android.util.StateSet;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class bdqf
{
  public static int a(String paramString)
  {
    int i = 0;
    if (paramString != null) {
      paramString.trim();
    }
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static long a(String paramString)
  {
    long l = 0L;
    if (paramString != null) {
      paramString.trim();
    }
    try
    {
      l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public static StateListDrawable a(Resources paramResources, int paramInt, float[] paramArrayOfFloat)
  {
    GradientDrawable[] arrayOfGradientDrawable = new GradientDrawable[2];
    int k = Color.red(paramInt);
    int i = Color.green(paramInt);
    int j = Color.blue(paramInt);
    paramInt = k;
    k = 0;
    if (k < arrayOfGradientDrawable.length)
    {
      arrayOfGradientDrawable[k] = new GradientDrawable();
      arrayOfGradientDrawable[k].setShape(0);
      int m = paramInt - (k << 5);
      paramInt = m;
      if (m < 0) {
        paramInt = 0;
      }
      m = i - (k << 5);
      i = m;
      if (m < 0) {
        i = 0;
      }
      m = j - (k << 5);
      j = m;
      if (m < 0) {
        j = 0;
      }
      arrayOfGradientDrawable[k].setColor(Color.rgb(paramInt, i, j));
      if (paramArrayOfFloat != null) {
        arrayOfGradientDrawable[k].setCornerRadii(paramArrayOfFloat);
      }
      for (;;)
      {
        k += 1;
        break;
        arrayOfGradientDrawable[k].setCornerRadius(agej.a(4.0F, paramResources));
      }
    }
    paramResources = new StateListDrawable();
    paramArrayOfFloat = arrayOfGradientDrawable[1];
    paramResources.addState(new int[] { 16842919, 16842910 }, paramArrayOfFloat);
    paramResources.addState(StateSet.WILD_CARD, arrayOfGradientDrawable[0]);
    return paramResources;
  }
  
  private static boolean a(Inflater paramInflater)
  {
    return (paramInflater.finished()) || (paramInflater.getRemaining() <= 0);
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    Inflater localInflater = new Inflater();
    localInflater.reset();
    localInflater.setInput(paramArrayOfByte);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
    for (;;)
    {
      try
      {
        byte[] arrayOfByte1 = new byte[1024];
        long l = SystemClock.uptimeMillis();
        if (!a(localInflater))
        {
          localByteArrayOutputStream.write(arrayOfByte1, 0, localInflater.inflate(arrayOfByte1));
          if (SystemClock.uptimeMillis() - l <= 15000L) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.w("StructMsg", 2, "decompress struct msg time out");
          }
          bdll.b(null, "dc00898", "", "", "0X8009845", "0X8009845", 0, 1, "", "", "", "");
          try
          {
            localByteArrayOutputStream.close();
            return paramArrayOfByte;
          }
          catch (IOException localIOException1)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("StructMsg", 2, localIOException1.getMessage());
            return paramArrayOfByte;
          }
        }
        arrayOfByte2 = localByteArrayOutputStream.toByteArray();
        paramArrayOfByte = arrayOfByte2;
      }
      catch (Exception localException)
      {
        byte[] arrayOfByte2;
        localException = localException;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StructMsg", 2, localException.getMessage());
        try
        {
          localIOException3.close();
          arrayOfByte3 = paramArrayOfByte;
        }
        catch (IOException localIOException4)
        {
          arrayOfByte3 = paramArrayOfByte;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StructMsg", 2, localIOException4.getMessage());
        byte[] arrayOfByte3 = paramArrayOfByte;
        continue;
      }
      finally {}
      try
      {
        localByteArrayOutputStream.close();
        arrayOfByte2 = paramArrayOfByte;
      }
      catch (IOException localIOException3)
      {
        arrayOfByte2 = paramArrayOfByte;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StructMsg", 2, localIOException3.getMessage());
        arrayOfByte2 = paramArrayOfByte;
      }
    }
    localInflater.end();
    return arrayOfByte2;
    try
    {
      localIOException4.close();
      throw paramArrayOfByte;
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, localIOException2.getMessage());
        }
      }
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte.length;
    Object localObject;
    if (paramInt == -1)
    {
      paramInt = paramArrayOfByte[0];
      localObject = new byte[i - 1];
      if (paramInt == 1)
      {
        System.arraycopy(paramArrayOfByte, 1, localObject, 0, i - 1);
        paramArrayOfByte = a((byte[])localObject);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = new String(paramArrayOfByte, 0, paramArrayOfByte.length);
        QLog.d("StructMsg", 2, "getStructMsgFromXmlBuff xmlStr:" + (String)localObject);
      }
      return paramArrayOfByte;
      System.arraycopy(paramArrayOfByte, 1, localObject, 0, i - 1);
      paramArrayOfByte = (byte[])localObject;
      continue;
      localObject = new byte[i];
      if (paramInt == 1)
      {
        System.arraycopy(paramArrayOfByte, 0, localObject, 0, i);
        paramArrayOfByte = a((byte[])localObject);
      }
      else
      {
        System.arraycopy(paramArrayOfByte, 0, localObject, 0, i);
        paramArrayOfByte = (byte[])localObject;
      }
    }
  }
  
  public static final byte[] b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte1 = new byte[0];
    Deflater localDeflater = new Deflater();
    localDeflater.reset();
    localDeflater.setInput(paramArrayOfByte);
    localDeflater.finish();
    localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
    try
    {
      byte[] arrayOfByte3 = new byte[1024];
      while (!localDeflater.finished()) {
        localByteArrayOutputStream.write(arrayOfByte3, 0, localDeflater.deflate(arrayOfByte3));
      }
      try
      {
        byte[] arrayOfByte2;
        localByteArrayOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, localIOException1.getMessage());
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, localException.getMessage());
      }
      for (;;)
      {
        try
        {
          localByteArrayOutputStream.close();
          arrayOfByte2 = paramArrayOfByte;
        }
        catch (IOException localIOException3)
        {
          arrayOfByte2 = paramArrayOfByte;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("StructMsg", 2, localIOException3.getMessage());
          arrayOfByte2 = paramArrayOfByte;
          continue;
        }
        localDeflater.end();
        return arrayOfByte2;
        arrayOfByte3 = localByteArrayOutputStream.toByteArray();
        paramArrayOfByte = arrayOfByte3;
        try
        {
          localByteArrayOutputStream.close();
          arrayOfByte2 = paramArrayOfByte;
        }
        catch (IOException localIOException2)
        {
          arrayOfByte2 = paramArrayOfByte;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("StructMsg", 2, localIOException2.getMessage());
          arrayOfByte2 = paramArrayOfByte;
        }
      }
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = paramArrayOfByte;
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, paramArrayOfByte.getMessage());
        }
        try
        {
          localByteArrayOutputStream.close();
        }
        catch (IOException paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, paramArrayOfByte.getMessage());
          }
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqf
 * JD-Core Version:    0.7.0.1
 */