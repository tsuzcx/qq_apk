import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;

final class biea
{
  private static String a = "PBSerialization-L";
  
  public static bidz a(byte[] paramArrayOfByte)
  {
    Object localObject = new bidy();
    if (paramArrayOfByte.length < bidy.d)
    {
      QLog.w(a, 1, "buffer length is short than 16!");
      return null;
    }
    ((bidy)localObject).a(paramArrayOfByte);
    if (paramArrayOfByte.length < ((bidy)localObject).a())
    {
      QLog.w(a, 1, "buffer length is short!");
      return null;
    }
    int i = ((bidy)localObject).a() - ((bidy)localObject).b() - bidy.d;
    int j = ((bidy)localObject).b();
    localObject = new byte[i];
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, bidy.d, localObject, 0, i);
    System.arraycopy(paramArrayOfByte, i + bidy.d, arrayOfByte, 0, j);
    paramArrayOfByte = new WeiyunPB.MsgHead();
    try
    {
      paramArrayOfByte.mergeFrom((byte[])localObject);
      paramArrayOfByte = new bidz(paramArrayOfByte, arrayOfByte);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e(a, 1, "throw InvalidProtocolBufferException.");
    }
    return null;
  }
  
  public static byte[] a(bidz parambidz)
  {
    byte[] arrayOfByte1 = parambidz.a().toByteArray();
    parambidz = parambidz.a();
    int i = bidy.d + arrayOfByte1.length + parambidz.length;
    Object localObject = new bidy();
    ((bidy)localObject).b(parambidz.length);
    ((bidy)localObject).a(i);
    localObject = ((bidy)localObject).a();
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, localObject.length, arrayOfByte1.length);
    i = localObject.length;
    System.arraycopy(parambidz, 0, arrayOfByte2, arrayOfByte1.length + i, parambidz.length);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biea
 * JD-Core Version:    0.7.0.1
 */