import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;

public final class amri
{
  private static String a = "PBSerialization-L";
  
  public static amrh a(byte[] paramArrayOfByte)
  {
    Object localObject = new amrg();
    if (paramArrayOfByte.length < amrg.d)
    {
      QLog.w(a, 1, "buffer length is short than 16!");
      return null;
    }
    ((amrg)localObject).a(paramArrayOfByte);
    if (paramArrayOfByte.length < ((amrg)localObject).a())
    {
      QLog.w(a, 1, "buffer length is short!");
      return null;
    }
    int i = ((amrg)localObject).a() - ((amrg)localObject).b() - amrg.d;
    int j = ((amrg)localObject).b();
    localObject = new byte[i];
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, amrg.d, localObject, 0, i);
    System.arraycopy(paramArrayOfByte, i + amrg.d, arrayOfByte, 0, j);
    paramArrayOfByte = new WeiyunPB.MsgHead();
    try
    {
      paramArrayOfByte.mergeFrom((byte[])localObject);
      paramArrayOfByte = new amrh(paramArrayOfByte, arrayOfByte);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e(a, 1, "throw InvalidProtocolBufferException.");
    }
    return null;
  }
  
  public static byte[] a(amrh paramamrh)
  {
    byte[] arrayOfByte1 = paramamrh.a().toByteArray();
    paramamrh = paramamrh.a();
    int i = amrg.d + arrayOfByte1.length + paramamrh.length;
    Object localObject = new amrg();
    ((amrg)localObject).b(paramamrh.length);
    ((amrg)localObject).a(i);
    localObject = ((amrg)localObject).a();
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, localObject.length, arrayOfByte1.length);
    i = localObject.length;
    System.arraycopy(paramamrh, 0, arrayOfByte2, arrayOfByte1.length + i, paramamrh.length);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amri
 * JD-Core Version:    0.7.0.1
 */