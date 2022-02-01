import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;

final class bmrw
{
  private static String a = "PBSerialization-L";
  
  public static bmrv a(byte[] paramArrayOfByte)
  {
    Object localObject = new bmru();
    if (paramArrayOfByte.length < bmru.d)
    {
      QLog.w(a, 1, "buffer length is short than 16!");
      return null;
    }
    ((bmru)localObject).a(paramArrayOfByte);
    if (paramArrayOfByte.length < ((bmru)localObject).a())
    {
      QLog.w(a, 1, "buffer length is short!");
      return null;
    }
    int i = ((bmru)localObject).a() - ((bmru)localObject).b() - bmru.d;
    int j = ((bmru)localObject).b();
    localObject = new byte[i];
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, bmru.d, localObject, 0, i);
    System.arraycopy(paramArrayOfByte, i + bmru.d, arrayOfByte, 0, j);
    paramArrayOfByte = new WeiyunPB.MsgHead();
    try
    {
      paramArrayOfByte.mergeFrom((byte[])localObject);
      paramArrayOfByte = new bmrv(paramArrayOfByte, arrayOfByte);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e(a, 1, "throw InvalidProtocolBufferException.");
    }
    return null;
  }
  
  public static byte[] a(bmrv parambmrv)
  {
    byte[] arrayOfByte1 = parambmrv.a().toByteArray();
    parambmrv = parambmrv.a();
    int i = bmru.d + arrayOfByte1.length + parambmrv.length;
    Object localObject = new bmru();
    ((bmru)localObject).b(parambmrv.length);
    ((bmru)localObject).a(i);
    localObject = ((bmru)localObject).a();
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, localObject.length, arrayOfByte1.length);
    i = localObject.length;
    System.arraycopy(parambmrv, 0, arrayOfByte2, arrayOfByte1.length + i, parambmrv.length);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmrw
 * JD-Core Version:    0.7.0.1
 */