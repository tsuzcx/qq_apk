package com.tencent.mobileqq.armap.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MapLog
{
  public static final int CLR = 2;
  public static final int DEBUG = 1;
  public static final String TAG = "Q.armap";
  
  public static final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    Object localObject = "Q.armap";
    if (!bool)
    {
      localObject = new StringBuilder("Q.armap");
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(paramString1);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString1 = paramString2;
    if (paramVarArgs != null)
    {
      paramString1 = paramString2;
      if (paramVarArgs.length > 0) {
        try
        {
          paramString1 = String.format(paramString2, paramVarArgs);
        }
        catch (Exception paramVarArgs)
        {
          paramString1 = paramString2;
          if (QLog.isDevelopLevel())
          {
            paramVarArgs.printStackTrace();
            paramString1 = paramString2;
          }
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i((String)localObject, 4, paramString1);
    }
  }
  
  public static final void debug(int paramInt, String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QLOG_");
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",Loglevel:");
    localStringBuilder.append(paramInt);
    QLog.d(paramString1, paramInt, localStringBuilder.toString());
  }
  
  public static final void i(int paramInt, String paramString, Object... paramVarArgs)
  {
    i(null, paramInt, paramString, paramVarArgs);
  }
  
  public static final void i(String paramString1, int paramInt, String paramString2, Object... paramVarArgs)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    Object localObject = "Q.armap";
    if (!bool)
    {
      localObject = new StringBuilder("Q.armap");
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(paramString1);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString1 = paramString2;
    if (paramVarArgs != null)
    {
      paramString1 = paramString2;
      if (paramVarArgs.length > 0) {
        try
        {
          paramString1 = String.format(paramString2, paramVarArgs);
        }
        catch (Exception paramVarArgs)
        {
          paramString1 = paramString2;
          if (QLog.isDevelopLevel())
          {
            paramVarArgs.printStackTrace();
            paramString1 = paramString2;
          }
        }
      }
    }
    if (paramInt == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i((String)localObject, 2, paramString1);
      }
    }
    else if (paramInt == 4)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i((String)localObject, 4, paramString1);
      }
    }
    else if (paramInt == 1) {
      QLog.i((String)localObject, 1, paramString1);
    }
  }
  
  public static boolean isLoggable(int paramInt)
  {
    if (paramInt == 1) {
      return QLog.isDevelopLevel();
    }
    if (paramInt == 2) {
      return QLog.isColorLevel();
    }
    return false;
  }
  
  public static boolean needWiden(long paramLong)
  {
    return (paramLong & 0x0) == -9223372036854775808L;
  }
  
  public static BigInteger toUnsignedLongValue(long paramLong)
  {
    if (!needWiden(paramLong)) {
      return BigInteger.valueOf(paramLong);
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    localByteBuffer.putLong(paramLong);
    return new BigInteger(1, localByteBuffer.array());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.utils.MapLog
 * JD-Core Version:    0.7.0.1
 */