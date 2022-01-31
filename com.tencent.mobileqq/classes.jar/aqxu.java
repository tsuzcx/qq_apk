import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class aqxu
  implements aqya, bdpz
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private aqxz jdField_a_of_type_Aqxz;
  private bdpx jdField_a_of_type_Bdpx;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private final int jdField_b_of_type_Int;
  private final long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private final byte[] jdField_b_of_type_ArrayOfByte;
  
  private aqxu(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong2, boolean paramBoolean, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(paramString1);
    this.jdField_b_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(paramString2);
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString3;
  }
  
  public static aqxu a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong2, boolean paramBoolean, String paramString3)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFtnHttpUploader strCheckSum is null");
      }
      return null;
    }
    if (paramString1.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFtnHttpUploader strCheckSum is empty");
      }
      return null;
    }
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFtnHttpUploader strSHA is null");
      }
      return null;
    }
    if (paramString2.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFtnHttpUploader strSHA is empty");
      }
      return null;
    }
    return new aqxu(paramQQAppInterface, paramLong1, paramInt1, paramInt2, paramString1, paramString2, paramLong2, paramBoolean, paramString3);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    DataInputStream localDataInputStream = new DataInputStream(paramArrayOfByte);
    try
    {
      localDataInputStream.skip(4L);
      if (localDataInputStream.readInt() != 0) {
        this.jdField_a_of_type_Aqxz.a(9001, "httpServer retCode!=0");
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        int i;
        long l1;
        long l2;
        localIOException.printStackTrace();
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "unPackageData exception:" + localIOException.toString());
        this.jdField_a_of_type_Aqxz.a(9001, "httpServer flag!=0 flag!=1");
        try
        {
          paramArrayOfByte.close();
          localDataInputStream.close();
          return;
        }
        catch (Exception paramArrayOfByte)
        {
          return;
        }
        this.jdField_a_of_type_Aqxz.a(9001, "httpServer flag!=0 flag!=1");
      }
    }
    finally
    {
      try
      {
        paramArrayOfByte.close();
        localDataInputStream.close();
        throw localObject;
      }
      catch (Exception paramArrayOfByte)
      {
        break label232;
      }
    }
    try
    {
      paramArrayOfByte.close();
      localDataInputStream.close();
      return;
    }
    catch (Exception paramArrayOfByte) {}
    localDataInputStream.skip(8L);
    i = localDataInputStream.readByte();
    if (i == 0)
    {
      i = localDataInputStream.readInt();
      l1 = localDataInputStream.readInt();
      l2 = i;
      this.jdField_a_of_type_Aqxz.a(l1 << 32 | l2, null);
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte.close();
        localDataInputStream.close();
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        return;
      }
      if (i != 1) {
        break;
      }
      this.jdField_a_of_type_Aqxz.b();
    }
    label232:
  }
  
  private byte[] a(long paramLong, byte[] paramArrayOfByte)
  {
    int i = this.jdField_a_of_type_ArrayOfByte.length + 2 + 2 + this.jdField_b_of_type_ArrayOfByte.length + 20 + paramArrayOfByte.length;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(i + 16);
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    try
    {
      localDataOutputStream.writeInt(-1412589450);
      localDataOutputStream.writeInt(1007);
      localDataOutputStream.writeInt(0);
      localDataOutputStream.writeInt(i);
      localDataOutputStream.writeShort(this.jdField_a_of_type_ArrayOfByte.length);
      localDataOutputStream.write(this.jdField_a_of_type_ArrayOfByte);
      localDataOutputStream.writeShort(this.jdField_b_of_type_ArrayOfByte.length);
      localDataOutputStream.write(this.jdField_b_of_type_ArrayOfByte);
      localDataOutputStream.writeInt((int)(this.jdField_b_of_type_Long & 0xFFFFFFFF));
      localDataOutputStream.writeInt((int)(paramLong & 0xFFFFFFFF));
      localDataOutputStream.writeInt(paramArrayOfByte.length);
      localDataOutputStream.writeInt((int)(this.jdField_b_of_type_Long >> 32));
      localDataOutputStream.writeInt((int)(paramLong >> 32));
      localDataOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      label255:
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      paramArrayOfByte.printStackTrace();
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "packageData exception:" + paramArrayOfByte.toString());
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
    finally
    {
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception localException1)
      {
        break label255;
      }
    }
  }
  
  protected HttpCommunicator a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bdpx != null)
    {
      a().a(this.jdField_a_of_type_Bdpx);
      this.jdField_a_of_type_Bdpx = null;
    }
  }
  
  public void a(aqxz paramaqxz)
  {
    this.jdField_a_of_type_Aqxz = paramaqxz;
  }
  
  public void a(bdpx parambdpx1, bdpx parambdpx2)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(this.jdField_a_of_type_Long) + "]已经结束,返回");
      }
    }
    do
    {
      return;
      if (parambdpx1 == this.jdField_a_of_type_Bdpx) {
        break;
      }
      if ((parambdpx1 != null) && (this.jdField_a_of_type_Bdpx != null))
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambdpx1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bdpx.a()) + "]");
        return;
      }
      if (parambdpx1 != null)
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambdpx1.a()) + "]");
        return;
      }
    } while (this.jdField_a_of_type_Bdpx == null);
    QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bdpx.a()) + "]");
    return;
    if (parambdpx2.c() == 200) {
      if (parambdpx2.a("User-ReturnCode") == null) {
        break label373;
      }
    }
    label373:
    for (long l = Long.parseLong(parambdpx2.a("User-ReturnCode"));; l = 0L)
    {
      if (0L != l)
      {
        this.jdField_a_of_type_Aqxz.a(parambdpx2.f, parambdpx2.d(), parambdpx2.d);
        return;
      }
      a(parambdpx2.a());
      return;
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],decode but response Code [" + parambdpx2.c() + "] is not 200");
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Aqxz.a(paramString);
  }
  
  public boolean a(bdpx parambdpx1, bdpx parambdpx2, int paramInt)
  {
    return true;
  }
  
  public boolean a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = a(paramLong, paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "sendData packageData return null");
      }
      return false;
    }
    this.jdField_a_of_type_Bdpx = new bdpx(paramString, paramArrayOfByte, this);
    this.jdField_a_of_type_Bdpx.b(false);
    this.jdField_a_of_type_Bdpx.a("cache-control", "no-cache");
    paramArrayOfByte = "gprs";
    if (bdin.b(BaseApplication.getContext()) == 1) {
      paramArrayOfByte = "wifi";
    }
    this.jdField_a_of_type_Bdpx.a("Net-type", paramArrayOfByte);
    this.jdField_a_of_type_Bdpx.b("POST");
    this.jdField_a_of_type_Bdpx.b(1);
    if (this.jdField_a_of_type_Aqxz != null) {
      this.jdField_a_of_type_Aqxz.a(this.jdField_a_of_type_Bdpx);
    }
    this.jdField_a_of_type_Bdpx.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bdpx.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Bdpx.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    paramArrayOfByte = "";
    if (paramString != null) {
      paramArrayOfByte = paramString.toLowerCase();
    }
    if ((this.jdField_b_of_type_Boolean) && (paramArrayOfByte.startsWith("https")))
    {
      this.jdField_a_of_type_Bdpx.j = true;
      this.jdField_a_of_type_Bdpx.k = aqxx.a(paramString);
      this.jdField_a_of_type_Bdpx.e = this.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Bdpx.jdField_a_of_type_Bawq = arrr.a();
    a().a(this.jdField_a_of_type_Bdpx);
    return true;
  }
  
  public void b(bdpx parambdpx1, bdpx parambdpx2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (parambdpx2 != null)
    {
      this.jdField_a_of_type_Aqxz.a(parambdpx2.f, parambdpx2.d(), parambdpx2.d);
      return;
    }
    this.jdField_a_of_type_Aqxz.a(0, "null", "null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqxu
 * JD-Core Version:    0.7.0.1
 */