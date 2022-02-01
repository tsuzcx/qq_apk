import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;

final class bnzy
{
  private static String a = "PBSerialization-L";
  
  public static bnzx a(byte[] paramArrayOfByte)
  {
    Object localObject = new bnzw();
    if (paramArrayOfByte.length < bnzw.d)
    {
      QLog.w(a, 1, "buffer length is short than 16!");
      return null;
    }
    ((bnzw)localObject).a(paramArrayOfByte);
    if (paramArrayOfByte.length < ((bnzw)localObject).a())
    {
      QLog.w(a, 1, "buffer length is short!");
      return null;
    }
    int i = ((bnzw)localObject).a() - ((bnzw)localObject).b() - bnzw.d;
    int j = ((bnzw)localObject).b();
    localObject = new byte[i];
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, bnzw.d, localObject, 0, i);
    System.arraycopy(paramArrayOfByte, i + bnzw.d, arrayOfByte, 0, j);
    paramArrayOfByte = new WeiyunPB.MsgHead();
    try
    {
      paramArrayOfByte.mergeFrom((byte[])localObject);
      paramArrayOfByte = new bnzx(paramArrayOfByte, arrayOfByte);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e(a, 1, "throw InvalidProtocolBufferException.");
    }
    return null;
  }
  
  public static byte[] a(bnzx parambnzx)
  {
    byte[] arrayOfByte1 = parambnzx.a().toByteArray();
    parambnzx = parambnzx.a();
    int i = bnzw.d + arrayOfByte1.length + parambnzx.length;
    Object localObject = new bnzw();
    ((bnzw)localObject).b(parambnzx.length);
    ((bnzw)localObject).a(i);
    localObject = ((bnzw)localObject).a();
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, localObject.length, arrayOfByte1.length);
    i = localObject.length;
    System.arraycopy(parambnzx, 0, arrayOfByte2, arrayOfByte1.length + i, parambnzx.length);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnzy
 * JD-Core Version:    0.7.0.1
 */