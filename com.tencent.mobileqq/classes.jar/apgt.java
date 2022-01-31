import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintStream;

public class apgt
{
  public static int a(bgbd parambgbd, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 == 0L)
    {
      if (paramLong1 < parambgbd.a(BaseApplication.getContext(), paramLong1, paramLong3, 1024)) {}
      for (;;)
      {
        i = (int)paramLong1;
        int k = bgbg.a(BaseApplication.getContext());
        int j;
        if (k != 1)
        {
          j = i;
          if (k != 2) {}
        }
        else
        {
          j = i;
          if (i > 16384) {
            j = 16384;
          }
        }
        i = Math.min(j, 1048576);
        if (QLog.isColorLevel()) {
          QLog.d("FileHttpUtils<FileAssistant>", 2, "sendFilePakage transferedSize[" + paramLong2 + "], size[" + i + "]");
        }
        return i;
        paramLong1 = 1024L;
      }
    }
    int i = parambgbd.a(BaseApplication.getContext(), paramLong1, paramLong2, 131072);
    if (paramLong1 < i + paramLong2) {}
    for (paramLong1 -= paramLong2;; paramLong1 = i)
    {
      i = (int)paramLong1;
      break;
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramArrayOfByte == null) {
      return "";
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      String str1 = str2;
      if (str2.length() == 1) {
        str1 = '0' + str2;
      }
      System.out.print(str1.toUpperCase() + " ");
      localStringBuffer.append(str1.toUpperCase() + "");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 9052) || (paramInt == 9050) || (paramInt == 9055) || (paramInt == 9053) || (paramInt == 9054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apgt
 * JD-Core Version:    0.7.0.1
 */