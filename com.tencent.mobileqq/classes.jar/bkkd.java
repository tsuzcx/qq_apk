import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;

final class bkkd
{
  private static String a = "PBSerialization-L";
  
  public static bkkc a(byte[] paramArrayOfByte)
  {
    Object localObject = new bkkb();
    if (paramArrayOfByte.length < bkkb.d)
    {
      QLog.w(a, 1, "buffer length is short than 16!");
      return null;
    }
    ((bkkb)localObject).a(paramArrayOfByte);
    if (paramArrayOfByte.length < ((bkkb)localObject).a())
    {
      QLog.w(a, 1, "buffer length is short!");
      return null;
    }
    int i = ((bkkb)localObject).a() - ((bkkb)localObject).b() - bkkb.d;
    int j = ((bkkb)localObject).b();
    localObject = new byte[i];
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, bkkb.d, localObject, 0, i);
    System.arraycopy(paramArrayOfByte, i + bkkb.d, arrayOfByte, 0, j);
    paramArrayOfByte = new WeiyunPB.MsgHead();
    try
    {
      paramArrayOfByte.mergeFrom((byte[])localObject);
      paramArrayOfByte = new bkkc(paramArrayOfByte, arrayOfByte);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e(a, 1, "throw InvalidProtocolBufferException.");
    }
    return null;
  }
  
  public static byte[] a(bkkc parambkkc)
  {
    byte[] arrayOfByte1 = parambkkc.a().toByteArray();
    parambkkc = parambkkc.a();
    int i = bkkb.d + arrayOfByte1.length + parambkkc.length;
    Object localObject = new bkkb();
    ((bkkb)localObject).b(parambkkc.length);
    ((bkkb)localObject).a(i);
    localObject = ((bkkb)localObject).a();
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, localObject.length, arrayOfByte1.length);
    i = localObject.length;
    System.arraycopy(parambkkc, 0, arrayOfByte2, arrayOfByte1.length + i, parambkkc.length);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkkd
 * JD-Core Version:    0.7.0.1
 */