import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Array;

public class bqap
{
  public static boolean a(File paramFile1, File paramFile2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMAudioUtil", 2, "begin convert mp3 to pcm");
    }
    mnw localmnw = new mnw(44100, 16, 1);
    localmnw.a(new bqaq());
    long l = System.currentTimeMillis();
    try
    {
      localmnw.a(paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath());
      return true;
    }
    catch (Throwable paramFile1)
    {
      QLog.e("QIMAudioUtil", 1, "convertMp3ToPcm decode exception:" + paramFile1, paramFile1);
      if (QLog.isColorLevel()) {
        QLog.d("QIMAudioUtil", 2, "mp3 to pcm time:" + (System.currentTimeMillis() - l));
      }
    }
    return false;
  }
  
  public static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt, double paramDouble)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte3 == null) || (paramInt == 0))
    {
      QLog.e("QIMAudioUtil", 1, "mix, dst == null || inputA == null || inputB == null || size == 0");
      return false;
    }
    System.currentTimeMillis();
    int i = paramInt / 2;
    short[][] arrayOfShort = (short[][])Array.newInstance(Short.TYPE, new int[] { 2, i });
    i = 0;
    while (i < paramInt / 2)
    {
      if (i * 2 + 1 < paramArrayOfByte2.length) {
        arrayOfShort[0][i] = ((short)(paramArrayOfByte2[(i * 2)] & 0xFF | (paramArrayOfByte2[(i * 2 + 1)] & 0xFF) << 8));
      }
      i += 1;
    }
    i = 0;
    while (i < paramInt / 2)
    {
      if (i * 2 + 1 < paramArrayOfByte3.length) {
        arrayOfShort[1][i] = ((short)(paramArrayOfByte3[(i * 2)] & 0xFF | (paramArrayOfByte3[(i * 2 + 1)] & 0xFF) << 8));
      }
      i += 1;
    }
    int n = (int)(705600.0D * (paramDouble / 1000.0D)) / 2;
    paramArrayOfByte2 = new short[paramInt / 2];
    int j = 0;
    int k;
    label246:
    int m;
    if (j < paramInt / 2)
    {
      i = 0;
      if ((n < j) && (j < arrayOfShort[1].length + n))
      {
        k = 0;
        if (k < 2)
        {
          if (arrayOfShort[k].length <= j) {
            break label429;
          }
          paramArrayOfByte3 = arrayOfShort[k];
          if (k == 0)
          {
            m = j;
            label278:
            i = paramArrayOfByte3[m] + i;
          }
        }
      }
    }
    label429:
    for (;;)
    {
      k += 1;
      break label246;
      m = j - n;
      break label278;
      label306:
      if (i > 32767) {
        k = 32767;
      }
      for (;;)
      {
        paramArrayOfByte2[j] = ((short)k);
        j += 1;
        break;
        i = arrayOfShort[0][j] + 0;
        break label306;
        k = i;
        if (i < -32767) {
          k = -32767;
        }
      }
      i = 0;
      while (i < paramInt / 2)
      {
        paramArrayOfByte1[(i * 2)] = ((byte)(paramArrayOfByte2[i] & 0xFF));
        paramArrayOfByte1[(i * 2 + 1)] = ((byte)((paramArrayOfByte2[i] & 0xFF00) >> 8));
        i += 1;
      }
      System.currentTimeMillis();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqap
 * JD-Core Version:    0.7.0.1
 */