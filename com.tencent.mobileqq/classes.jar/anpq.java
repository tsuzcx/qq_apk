import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;

public final class anpq
{
  private static String a = "PBSerialization-L";
  
  public static anpp a(byte[] paramArrayOfByte)
  {
    Object localObject = new anpo();
    if (paramArrayOfByte.length < anpo.d)
    {
      QLog.w(a, 1, "buffer length is short than 16!");
      return null;
    }
    ((anpo)localObject).a(paramArrayOfByte);
    if (paramArrayOfByte.length < ((anpo)localObject).a())
    {
      QLog.w(a, 1, "buffer length is short!");
      return null;
    }
    int i = ((anpo)localObject).a() - ((anpo)localObject).b() - anpo.d;
    int j = ((anpo)localObject).b();
    localObject = new byte[i];
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, anpo.d, localObject, 0, i);
    System.arraycopy(paramArrayOfByte, i + anpo.d, arrayOfByte, 0, j);
    paramArrayOfByte = new WeiyunPB.MsgHead();
    try
    {
      paramArrayOfByte.mergeFrom((byte[])localObject);
      paramArrayOfByte = new anpp(paramArrayOfByte, arrayOfByte);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e(a, 1, "throw InvalidProtocolBufferException.");
    }
    return null;
  }
  
  public static byte[] a(anpp paramanpp)
  {
    byte[] arrayOfByte1 = paramanpp.a().toByteArray();
    paramanpp = paramanpp.a();
    int i = anpo.d + arrayOfByte1.length + paramanpp.length;
    Object localObject = new anpo();
    ((anpo)localObject).b(paramanpp.length);
    ((anpo)localObject).a(i);
    localObject = ((anpo)localObject).a();
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, localObject.length, arrayOfByte1.length);
    i = localObject.length;
    System.arraycopy(paramanpp, 0, arrayOfByte2, arrayOfByte1.length + i, paramanpp.length);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpq
 * JD-Core Version:    0.7.0.1
 */