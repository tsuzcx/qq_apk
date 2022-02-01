import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;

final class bmyq
{
  private static String a = "PBSerialization-L";
  
  public static bmyp a(byte[] paramArrayOfByte)
  {
    Object localObject = new bmyo();
    if (paramArrayOfByte.length < bmyo.d)
    {
      QLog.w(a, 1, "buffer length is short than 16!");
      return null;
    }
    ((bmyo)localObject).a(paramArrayOfByte);
    if (paramArrayOfByte.length < ((bmyo)localObject).a())
    {
      QLog.w(a, 1, "buffer length is short!");
      return null;
    }
    int i = ((bmyo)localObject).a() - ((bmyo)localObject).b() - bmyo.d;
    int j = ((bmyo)localObject).b();
    localObject = new byte[i];
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, bmyo.d, localObject, 0, i);
    System.arraycopy(paramArrayOfByte, i + bmyo.d, arrayOfByte, 0, j);
    paramArrayOfByte = new WeiyunPB.MsgHead();
    try
    {
      paramArrayOfByte.mergeFrom((byte[])localObject);
      paramArrayOfByte = new bmyp(paramArrayOfByte, arrayOfByte);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e(a, 1, "throw InvalidProtocolBufferException.");
    }
    return null;
  }
  
  public static byte[] a(bmyp parambmyp)
  {
    byte[] arrayOfByte1 = parambmyp.a().toByteArray();
    parambmyp = parambmyp.a();
    int i = bmyo.d + arrayOfByte1.length + parambmyp.length;
    Object localObject = new bmyo();
    ((bmyo)localObject).b(parambmyp.length);
    ((bmyo)localObject).a(i);
    localObject = ((bmyo)localObject).a();
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, localObject.length, arrayOfByte1.length);
    i = localObject.length;
    System.arraycopy(parambmyp, 0, arrayOfByte2, arrayOfByte1.length + i, parambmyp.length);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyq
 * JD-Core Version:    0.7.0.1
 */