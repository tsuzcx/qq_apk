import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;

final class bidj
{
  private static String a = "PBSerialization-L";
  
  public static bidi a(byte[] paramArrayOfByte)
  {
    Object localObject = new bidh();
    if (paramArrayOfByte.length < bidh.d)
    {
      QLog.w(a, 1, "buffer length is short than 16!");
      return null;
    }
    ((bidh)localObject).a(paramArrayOfByte);
    if (paramArrayOfByte.length < ((bidh)localObject).a())
    {
      QLog.w(a, 1, "buffer length is short!");
      return null;
    }
    int i = ((bidh)localObject).a() - ((bidh)localObject).b() - bidh.d;
    int j = ((bidh)localObject).b();
    localObject = new byte[i];
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, bidh.d, localObject, 0, i);
    System.arraycopy(paramArrayOfByte, i + bidh.d, arrayOfByte, 0, j);
    paramArrayOfByte = new WeiyunPB.MsgHead();
    try
    {
      paramArrayOfByte.mergeFrom((byte[])localObject);
      paramArrayOfByte = new bidi(paramArrayOfByte, arrayOfByte);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e(a, 1, "throw InvalidProtocolBufferException.");
    }
    return null;
  }
  
  public static byte[] a(bidi parambidi)
  {
    byte[] arrayOfByte1 = parambidi.a().toByteArray();
    parambidi = parambidi.a();
    int i = bidh.d + arrayOfByte1.length + parambidi.length;
    Object localObject = new bidh();
    ((bidh)localObject).b(parambidi.length);
    ((bidh)localObject).a(i);
    localObject = ((bidh)localObject).a();
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, localObject.length, arrayOfByte1.length);
    i = localObject.length;
    System.arraycopy(parambidi, 0, arrayOfByte2, arrayOfByte1.length + i, parambidi.length);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidj
 * JD-Core Version:    0.7.0.1
 */