import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;

public class auft
{
  public static long a(String paramString)
  {
    try
    {
      long l = new BigInteger(paramString).longValue();
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w(auft.class.getSimpleName(), 2, "failed to long:" + paramString);
      }
    }
    return 0L;
  }
  
  public static String a(int paramInt)
  {
    return String.valueOf(paramInt & 0xFFFFFFFF);
  }
  
  public static String a(long paramLong)
  {
    BigInteger localBigInteger2 = BigInteger.valueOf(paramLong);
    BigInteger localBigInteger1 = localBigInteger2;
    if (localBigInteger2.signum() < 0) {
      localBigInteger1 = localBigInteger2.add(BigInteger.ONE.shiftLeft(64));
    }
    return localBigInteger1.toString();
  }
  
  public static String a(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    int m = paramString.length() - 4;
    int k = m - 4;
    int i = m;
    if (m < 0) {
      i = 0;
    }
    if (k < 0) {}
    for (;;)
    {
      if ((j < i) && (i > 0)) {
        localStringBuffer.replace(j, i, "*");
      }
      return localStringBuffer.toString();
      j = k;
    }
  }
  
  public static long b(String paramString)
  {
    try
    {
      long l = new BigInteger(paramString).longValue();
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(auft.class.getSimpleName(), 2, "failed getLong, uin = " + paramString);
      }
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auft
 * JD-Core Version:    0.7.0.1
 */