import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class atme
  implements atmn, IHttpCommunicatorListener
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private atmm jdField_a_of_type_Atmm;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private final int jdField_b_of_type_Int;
  private final long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private final byte[] jdField_b_of_type_ArrayOfByte;
  
  private atme(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong2, boolean paramBoolean, String paramString3)
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
  
  public static atme a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong2, boolean paramBoolean, String paramString3)
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
    return new atme(paramQQAppInterface, paramLong1, paramInt1, paramInt2, paramString1, paramString2, paramLong2, paramBoolean, paramString3);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    DataInputStream localDataInputStream = new DataInputStream(paramArrayOfByte);
    try
    {
      localDataInputStream.skip(4L);
      if (localDataInputStream.readInt() != 0) {
        this.jdField_a_of_type_Atmm.a(9001, "httpServer retCode!=0");
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
        this.jdField_a_of_type_Atmm.a(9001, "httpServer flag!=0 flag!=1");
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
        this.jdField_a_of_type_Atmm.a(9001, "httpServer flag!=0 flag!=1");
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
      this.jdField_a_of_type_Atmm.a(l1 << 32 | l2, null);
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
      this.jdField_a_of_type_Atmm.b();
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
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
    {
      a().cancelMsg(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
    }
  }
  
  public void a(atmm paramatmm)
  {
    this.jdField_a_of_type_Atmm = paramatmm;
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
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = new HttpMsg(paramString, paramArrayOfByte, this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setInstanceFollowRedirects(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestProperty("cache-control", "no-cache");
    paramArrayOfByte = "gprs";
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
      paramArrayOfByte = "wifi";
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestProperty("Net-type", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestMethod("POST");
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setPriority(1);
    if (this.jdField_a_of_type_Atmm != null) {
      this.jdField_a_of_type_Atmm.a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.fileType = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.busiType = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.msgId = String.valueOf(this.jdField_a_of_type_Long);
    paramArrayOfByte = "";
    if (paramString != null) {
      paramArrayOfByte = paramString.toLowerCase();
    }
    if ((this.jdField_b_of_type_Boolean) && (paramArrayOfByte.startsWith("https")))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.mIsHttps = true;
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.mIsHostIP = atmh.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.mReqHost = this.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.timeoutParam = auea.a();
    a().sendMsg(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    return true;
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(this.jdField_a_of_type_Long) + "]已经结束,返回");
      }
    }
    do
    {
      return;
      if (paramHttpMsg1 == this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) {
        break;
      }
      if ((paramHttpMsg1 != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null))
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(paramHttpMsg1.getSerial()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()) + "]");
        return;
      }
      if (paramHttpMsg1 != null)
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(paramHttpMsg1.getSerial()) + "]");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null);
    QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()) + "]");
    return;
    if (paramHttpMsg2.getResponseCode() == 200) {
      if (paramHttpMsg2.getResponseProperty("User-ReturnCode") == null) {
        break label390;
      }
    }
    label390:
    for (long l = Long.parseLong(paramHttpMsg2.getResponseProperty("User-ReturnCode"));; l = 0L)
    {
      if (0L != l)
      {
        this.jdField_a_of_type_Atmm.a(paramHttpMsg2.errCode, paramHttpMsg2.getErrorString(), paramHttpMsg2.rawRespHeader);
        return;
      }
      a(paramHttpMsg2.getRecvData());
      return;
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],decode but response Code [" + paramHttpMsg2.getResponseCode() + "] is not 200");
      return;
    }
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramHttpMsg2 != null)
    {
      this.jdField_a_of_type_Atmm.a(paramHttpMsg2.errCode, paramHttpMsg2.getErrorString(), paramHttpMsg2.rawRespHeader);
      return;
    }
    this.jdField_a_of_type_Atmm.a(0, "null", "null");
  }
  
  public void handleRedirect(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Atmm.a(paramString);
  }
  
  public void onFlowEvent(HttpMsg paramHttpMsg)
  {
    int i;
    int j;
    int k;
    if (paramHttpMsg != null)
    {
      i = paramHttpMsg.fileType;
      j = paramHttpMsg.busiType;
      k = paramHttpMsg.netType;
      if (!"POST".equals(paramHttpMsg.getRequestMethod())) {
        break label66;
      }
    }
    label66:
    for (boolean bool = true; (this.jdField_a_of_type_Atmm != null) && (this.jdField_a_of_type_Atmm.a(i, j, k, bool, paramHttpMsg.flow)); bool = false) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendAppDataIncerment(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), bool, k, i, j, paramHttpMsg.flow);
  }
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atme
 * JD-Core Version:    0.7.0.1
 */