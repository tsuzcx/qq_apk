import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;

final class blff
{
  private static String a = "PBSerialization-L";
  
  public static blfe a(byte[] paramArrayOfByte)
  {
    Object localObject = new blfd();
    if (paramArrayOfByte.length < blfd.d)
    {
      QLog.w(a, 1, "buffer length is short than 16!");
      return null;
    }
    ((blfd)localObject).a(paramArrayOfByte);
    if (paramArrayOfByte.length < ((blfd)localObject).a())
    {
      QLog.w(a, 1, "buffer length is short!");
      return null;
    }
    int i = ((blfd)localObject).a() - ((blfd)localObject).b() - blfd.d;
    int j = ((blfd)localObject).b();
    localObject = new byte[i];
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, blfd.d, localObject, 0, i);
    System.arraycopy(paramArrayOfByte, i + blfd.d, arrayOfByte, 0, j);
    paramArrayOfByte = new WeiyunPB.MsgHead();
    try
    {
      paramArrayOfByte.mergeFrom((byte[])localObject);
      paramArrayOfByte = new blfe(paramArrayOfByte, arrayOfByte);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e(a, 1, "throw InvalidProtocolBufferException.");
    }
    return null;
  }
  
  public static byte[] a(blfe paramblfe)
  {
    byte[] arrayOfByte1 = paramblfe.a().toByteArray();
    paramblfe = paramblfe.a();
    int i = blfd.d + arrayOfByte1.length + paramblfe.length;
    Object localObject = new blfd();
    ((blfd)localObject).b(paramblfe.length);
    ((blfd)localObject).a(i);
    localObject = ((blfd)localObject).a();
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, localObject.length, arrayOfByte1.length);
    i = localObject.length;
    System.arraycopy(paramblfe, 0, arrayOfByte2, arrayOfByte1.length + i, paramblfe.length);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blff
 * JD-Core Version:    0.7.0.1
 */