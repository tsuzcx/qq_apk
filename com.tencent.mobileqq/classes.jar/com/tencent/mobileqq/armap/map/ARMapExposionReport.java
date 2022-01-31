package com.tencent.mobileqq.armap.map;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class ARMapExposionReport
  implements Runnable
{
  final long jdField_a_of_type_Long;
  final String jdField_a_of_type_JavaLangString;
  final String b;
  
  public ARMapExposionReport(String paramString1, String paramString2, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  /* Error */
  public static long a(String paramString)
  {
    // Byte code:
    //   0: new 27	java/math/BigInteger
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 30	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 34	java/math/BigInteger:toByteArray	()[B
    //   11: astore 7
    //   13: aload 7
    //   15: arraylength
    //   16: istore_1
    //   17: aload 7
    //   19: arraylength
    //   20: bipush 8
    //   22: invokestatic 40	java/lang/Math:min	(II)I
    //   25: istore_2
    //   26: iload_1
    //   27: iload_2
    //   28: isub
    //   29: istore_1
    //   30: lconst_0
    //   31: lstore_3
    //   32: aload 7
    //   34: arraylength
    //   35: istore_2
    //   36: lload_3
    //   37: lstore 5
    //   39: iload_1
    //   40: iload_2
    //   41: if_icmpge +41 -> 82
    //   44: aload 7
    //   46: iload_1
    //   47: baload
    //   48: sipush 255
    //   51: iand
    //   52: i2l
    //   53: lstore 5
    //   55: iload_1
    //   56: iconst_1
    //   57: iadd
    //   58: istore_1
    //   59: lload_3
    //   60: bipush 8
    //   62: lshl
    //   63: lload 5
    //   65: lor
    //   66: lstore_3
    //   67: goto -35 -> 32
    //   70: astore 7
    //   72: lconst_0
    //   73: lstore_3
    //   74: aload 7
    //   76: invokevirtual 43	java/lang/Exception:printStackTrace	()V
    //   79: lload_3
    //   80: lstore 5
    //   82: invokestatic 49	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   85: ifeq +33 -> 118
    //   88: ldc 51
    //   90: iconst_4
    //   91: invokestatic 57	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   94: ldc 59
    //   96: iconst_2
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_0
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: lload 5
    //   108: invokestatic 65	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   111: aastore
    //   112: invokestatic 71	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   115: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: lload 5
    //   120: lreturn
    //   121: astore 7
    //   123: goto -49 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramString	String
    //   16	43	1	i	int
    //   25	17	2	j	int
    //   31	49	3	l1	long
    //   37	82	5	l2	long
    //   11	34	7	arrayOfByte	byte[]
    //   70	5	7	localException1	Exception
    //   121	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	26	70	java/lang/Exception
    //   32	36	121	java/lang/Exception
  }
  
  private void c(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = paramString.split("\\|");
        int j = paramString.length;
        i = 0;
        if (i < j)
        {
          String[] arrayOfString = paramString[i];
          if ((arrayOfString != null) && (arrayOfString.length() != 0))
          {
            arrayOfString = arrayOfString.split("-");
            if (arrayOfString != null)
            {
              int k = arrayOfString.length;
              if (k == 4) {
                try
                {
                  long l = a(arrayOfString[0]);
                  k = Integer.parseInt(arrayOfString[2]);
                  int m = Integer.parseInt(arrayOfString[3]);
                  ReportController.b(null, "dc01440", "", "", "0X8007A4D", "0X8007A4D", 0, k + m, 0, String.valueOf(k), String.valueOf(l), "", String.valueOf(m));
                }
                catch (Exception localException)
                {
                  localException.printStackTrace();
                }
              }
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      i += 1;
    }
  }
  
  private void d(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = paramString.split("\\|");
        int j = paramString.length;
        i = 0;
        if (i < j)
        {
          String[] arrayOfString = paramString[i];
          if ((arrayOfString != null) && (arrayOfString.length() != 0))
          {
            arrayOfString = arrayOfString.split("-");
            if (arrayOfString != null)
            {
              int k = arrayOfString.length;
              if (k == 4) {
                try
                {
                  long l = a(arrayOfString[0]);
                  k = Integer.parseInt(arrayOfString[2]);
                  int m = Integer.parseInt(arrayOfString[3]);
                  ReportController.b(null, "dc01440", "", "", "0X8007A4C", "0X8007A4C", 0, k + m, 0, String.valueOf(k), String.valueOf(l), "", String.valueOf(m));
                }
                catch (Exception localException)
                {
                  localException.printStackTrace();
                }
              }
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      i += 1;
    }
  }
  
  public void a(String paramString)
  {
    int i = 0;
    int j;
    try
    {
      paramString = paramString.split("\\|");
      int k = paramString.length;
      j = 0;
      if (j < k)
      {
        String[] arrayOfString = paramString[j];
        if (arrayOfString == null) {
          break label178;
        }
        if (arrayOfString.length() != 0)
        {
          arrayOfString = arrayOfString.split("-");
          if (arrayOfString == null) {
            break label178;
          }
          int m = arrayOfString.length;
          if (m != 2) {
            break label178;
          }
          try
          {
            long l = a(arrayOfString[0]);
            ReportController.b(null, "dc01440", "", "", "0X800783A", "0X800783A", 0, 0, String.valueOf(a(arrayOfString[1])), String.valueOf(l), String.valueOf(this.jdField_a_of_type_Long), "");
            i += 1;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            break label178;
          }
        }
      }
      else
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("ARMapExposionReport", 4, "reportPOIReachable 0X800783A total: " + i);
        }
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    label178:
    for (;;)
    {
      j += 1;
      break;
    }
  }
  
  public void b(String paramString)
  {
    int i = 0;
    int j;
    try
    {
      paramString = paramString.split("\\|");
      int k = paramString.length;
      j = 0;
      if (j < k)
      {
        String[] arrayOfString = paramString[j];
        if (arrayOfString == null) {
          break label177;
        }
        if (arrayOfString.length() != 0)
        {
          arrayOfString = arrayOfString.split("-");
          if (arrayOfString == null) {
            break label177;
          }
          int m = arrayOfString.length;
          if (m != 2) {
            break label177;
          }
          try
          {
            long l = a(arrayOfString[0]);
            ReportController.b(null, "dc01440", "", "", "0X8007843", "0X8007843", 0, Integer.parseInt(arrayOfString[1]), 0, String.valueOf(l), "", String.valueOf(this.jdField_a_of_type_Long), "");
            i += 1;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            break label177;
          }
        }
      }
      else
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("ARMapExposionReport", 4, "reportPOIExposion 0X8007843 total: " + i);
        }
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    label177:
    for (;;)
    {
      j += 1;
      break;
    }
  }
  
  public void run()
  {
    if ("0X800783A".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {
      a(this.b);
    }
    do
    {
      return;
      if ("0X8007843".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
      {
        b(this.b);
        return;
      }
      if ("0X8007A4D".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
      {
        c(this.b);
        return;
      }
      if ("0X8007A4C".equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
      {
        d(this.b);
        return;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("ARMapExposionReport", 4, "error key : " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.ARMapExposionReport
 * JD-Core Version:    0.7.0.1
 */