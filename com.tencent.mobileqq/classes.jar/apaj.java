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

public class apaj
  implements apap, bbmi
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private apao jdField_a_of_type_Apao;
  private bbmg jdField_a_of_type_Bbmg;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private final int jdField_b_of_type_Int;
  private final long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private final byte[] jdField_b_of_type_ArrayOfByte;
  
  private apaj(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong2, boolean paramBoolean, String paramString3)
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
  
  public static apaj a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong2, boolean paramBoolean, String paramString3)
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
    return new apaj(paramQQAppInterface, paramLong1, paramInt1, paramInt2, paramString1, paramString2, paramLong2, paramBoolean, paramString3);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    DataInputStream localDataInputStream = new DataInputStream(paramArrayOfByte);
    try
    {
      localDataInputStream.skip(4L);
      if (localDataInputStream.readInt() != 0) {
        this.jdField_a_of_type_Apao.a(9001, "httpServer retCode!=0");
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
        this.jdField_a_of_type_Apao.a(9001, "httpServer flag!=0 flag!=1");
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
        this.jdField_a_of_type_Apao.a(9001, "httpServer flag!=0 flag!=1");
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
      this.jdField_a_of_type_Apao.a(l1 << 32 | l2, null);
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
      this.jdField_a_of_type_Apao.b();
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
    if (this.jdField_a_of_type_Bbmg != null)
    {
      a().a(this.jdField_a_of_type_Bbmg);
      this.jdField_a_of_type_Bbmg = null;
    }
  }
  
  public void a(apao paramapao)
  {
    this.jdField_a_of_type_Apao = paramapao;
  }
  
  public void a(bbmg parambbmg1, bbmg parambbmg2)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(this.jdField_a_of_type_Long) + "]已经结束,返回");
      }
    }
    do
    {
      return;
      if (parambbmg1 == this.jdField_a_of_type_Bbmg) {
        break;
      }
      if ((parambbmg1 != null) && (this.jdField_a_of_type_Bbmg != null))
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambbmg1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bbmg.a()) + "]");
        return;
      }
      if (parambbmg1 != null)
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(parambbmg1.a()) + "]");
        return;
      }
    } while (this.jdField_a_of_type_Bbmg == null);
    QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_Bbmg.a()) + "]");
    return;
    if (parambbmg2.c() == 200) {
      if (parambbmg2.a("User-ReturnCode") == null) {
        break label373;
      }
    }
    label373:
    for (long l = Long.parseLong(parambbmg2.a("User-ReturnCode"));; l = 0L)
    {
      if (0L != l)
      {
        this.jdField_a_of_type_Apao.a(parambbmg2.f, parambbmg2.d(), parambbmg2.d);
        return;
      }
      a(parambbmg2.a());
      return;
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],decode but response Code [" + parambbmg2.c() + "] is not 200");
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Apao.a(paramString);
  }
  
  public boolean a(bbmg parambbmg1, bbmg parambbmg2, int paramInt)
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
    this.jdField_a_of_type_Bbmg = new bbmg(paramString, paramArrayOfByte, this);
    this.jdField_a_of_type_Bbmg.b(false);
    this.jdField_a_of_type_Bbmg.a("cache-control", "no-cache");
    paramArrayOfByte = "gprs";
    if (bbev.b(BaseApplication.getContext()) == 1) {
      paramArrayOfByte = "wifi";
    }
    this.jdField_a_of_type_Bbmg.a("Net-type", paramArrayOfByte);
    this.jdField_a_of_type_Bbmg.b("POST");
    this.jdField_a_of_type_Bbmg.b(1);
    if (this.jdField_a_of_type_Apao != null) {
      this.jdField_a_of_type_Apao.a(this.jdField_a_of_type_Bbmg);
    }
    this.jdField_a_of_type_Bbmg.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bbmg.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Bbmg.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    paramArrayOfByte = "";
    if (paramString != null) {
      paramArrayOfByte = paramString.toLowerCase();
    }
    if ((this.jdField_b_of_type_Boolean) && (paramArrayOfByte.startsWith("https")))
    {
      this.jdField_a_of_type_Bbmg.j = true;
      this.jdField_a_of_type_Bbmg.k = apam.a(paramString);
      this.jdField_a_of_type_Bbmg.e = this.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Bbmg.jdField_a_of_type_Ayug = apue.a();
    a().a(this.jdField_a_of_type_Bbmg);
    return true;
  }
  
  public void b(bbmg parambbmg1, bbmg parambbmg2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (parambbmg2 != null)
    {
      this.jdField_a_of_type_Apao.a(parambbmg2.f, parambbmg2.d(), parambbmg2.d);
      return;
    }
    this.jdField_a_of_type_Apao.a(0, "null", "null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apaj
 * JD-Core Version:    0.7.0.1
 */