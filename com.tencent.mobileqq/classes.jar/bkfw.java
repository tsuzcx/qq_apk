import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;

final class bkfw
{
  private static String a = "PBSerialization-L";
  
  public static bkfv a(byte[] paramArrayOfByte)
  {
    Object localObject = new bkfu();
    if (paramArrayOfByte.length < bkfu.d)
    {
      QLog.w(a, 1, "buffer length is short than 16!");
      return null;
    }
    ((bkfu)localObject).a(paramArrayOfByte);
    if (paramArrayOfByte.length < ((bkfu)localObject).a())
    {
      QLog.w(a, 1, "buffer length is short!");
      return null;
    }
    int i = ((bkfu)localObject).a() - ((bkfu)localObject).b() - bkfu.d;
    int j = ((bkfu)localObject).b();
    localObject = new byte[i];
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, bkfu.d, localObject, 0, i);
    System.arraycopy(paramArrayOfByte, i + bkfu.d, arrayOfByte, 0, j);
    paramArrayOfByte = new WeiyunPB.MsgHead();
    try
    {
      paramArrayOfByte.mergeFrom((byte[])localObject);
      paramArrayOfByte = new bkfv(paramArrayOfByte, arrayOfByte);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e(a, 1, "throw InvalidProtocolBufferException.");
    }
    return null;
  }
  
  public static byte[] a(bkfv parambkfv)
  {
    byte[] arrayOfByte1 = parambkfv.a().toByteArray();
    parambkfv = parambkfv.a();
    int i = bkfu.d + arrayOfByte1.length + parambkfv.length;
    Object localObject = new bkfu();
    ((bkfu)localObject).b(parambkfv.length);
    ((bkfu)localObject).a(i);
    localObject = ((bkfu)localObject).a();
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, localObject.length, arrayOfByte1.length);
    i = localObject.length;
    System.arraycopy(parambkfv, 0, arrayOfByte2, arrayOfByte1.length + i, parambkfv.length);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkfw
 * JD-Core Version:    0.7.0.1
 */