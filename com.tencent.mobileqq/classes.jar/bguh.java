import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;

final class bguh
{
  private static String a = "PBSerialization-L";
  
  public static bgug a(byte[] paramArrayOfByte)
  {
    Object localObject = new bguf();
    if (paramArrayOfByte.length < bguf.d)
    {
      QLog.w(a, 1, "buffer length is short than 16!");
      return null;
    }
    ((bguf)localObject).a(paramArrayOfByte);
    if (paramArrayOfByte.length < ((bguf)localObject).a())
    {
      QLog.w(a, 1, "buffer length is short!");
      return null;
    }
    int i = ((bguf)localObject).a() - ((bguf)localObject).b() - bguf.d;
    int j = ((bguf)localObject).b();
    localObject = new byte[i];
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, bguf.d, localObject, 0, i);
    System.arraycopy(paramArrayOfByte, i + bguf.d, arrayOfByte, 0, j);
    paramArrayOfByte = new WeiyunPB.MsgHead();
    try
    {
      paramArrayOfByte.mergeFrom((byte[])localObject);
      paramArrayOfByte = new bgug(paramArrayOfByte, arrayOfByte);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e(a, 1, "throw InvalidProtocolBufferException.");
    }
    return null;
  }
  
  public static byte[] a(bgug parambgug)
  {
    byte[] arrayOfByte1 = parambgug.a().toByteArray();
    parambgug = parambgug.a();
    int i = bguf.d + arrayOfByte1.length + parambgug.length;
    Object localObject = new bguf();
    ((bguf)localObject).b(parambgug.length);
    ((bguf)localObject).a(i);
    localObject = ((bguf)localObject).a();
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, localObject.length, arrayOfByte1.length);
    i = localObject.length;
    System.arraycopy(parambgug, 0, arrayOfByte2, arrayOfByte1.length + i, parambgug.length);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bguh
 * JD-Core Version:    0.7.0.1
 */