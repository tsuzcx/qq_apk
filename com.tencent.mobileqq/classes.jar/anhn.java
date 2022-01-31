import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;

public final class anhn
{
  private static String a = "PBSerialization-L";
  
  public static anhm a(byte[] paramArrayOfByte)
  {
    Object localObject = new anhl();
    if (paramArrayOfByte.length < anhl.d)
    {
      QLog.w(a, 1, "buffer length is short than 16!");
      return null;
    }
    ((anhl)localObject).a(paramArrayOfByte);
    if (paramArrayOfByte.length < ((anhl)localObject).a())
    {
      QLog.w(a, 1, "buffer length is short!");
      return null;
    }
    int i = ((anhl)localObject).a() - ((anhl)localObject).b() - anhl.d;
    int j = ((anhl)localObject).b();
    localObject = new byte[i];
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, anhl.d, localObject, 0, i);
    System.arraycopy(paramArrayOfByte, i + anhl.d, arrayOfByte, 0, j);
    paramArrayOfByte = new WeiyunPB.MsgHead();
    try
    {
      paramArrayOfByte.mergeFrom((byte[])localObject);
      paramArrayOfByte = new anhm(paramArrayOfByte, arrayOfByte);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e(a, 1, "throw InvalidProtocolBufferException.");
    }
    return null;
  }
  
  public static byte[] a(anhm paramanhm)
  {
    byte[] arrayOfByte1 = paramanhm.a().toByteArray();
    paramanhm = paramanhm.a();
    int i = anhl.d + arrayOfByte1.length + paramanhm.length;
    Object localObject = new anhl();
    ((anhl)localObject).b(paramanhm.length);
    ((anhl)localObject).a(i);
    localObject = ((anhl)localObject).a();
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, localObject.length, arrayOfByte1.length);
    i = localObject.length;
    System.arraycopy(paramanhm, 0, arrayOfByte2, arrayOfByte1.length + i, paramanhm.length);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhn
 * JD-Core Version:    0.7.0.1
 */