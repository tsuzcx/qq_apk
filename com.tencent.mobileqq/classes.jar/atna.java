import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

public class atna
  implements atmn, IHttpCommunicatorListener
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private atmm jdField_a_of_type_Atmm;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  
  private atna(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public static atna a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    return new atna(paramQQAppInterface, paramLong, paramInt1, paramInt2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().cancelMsg(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
    }
  }
  
  public void a(atmm paramatmm)
  {
    this.jdField_a_of_type_Atmm = paramatmm;
  }
  
  public boolean a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = new HttpMsg(paramString + "&bmd5=" + MD5.toMD5(paramArrayOfByte) + "&range=" + String.valueOf(paramLong), paramArrayOfByte, this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setInstanceFollowRedirects(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestProperty("cache-control", "no-cache");
    paramString = "gprs";
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
      paramString = "wifi";
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestProperty("Net-type", paramString);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestProperty("Range", "bytes=" + paramLong + "-");
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestMethod("POST");
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setPriority(1);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.fileType = this.b;
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.busiType = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.msgId = String.valueOf(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().sendMsg(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
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
        break label409;
      }
    }
    label409:
    for (long l = Long.parseLong(paramHttpMsg2.getResponseProperty("User-ReturnCode"));; l = 0L)
    {
      if (0L != l)
      {
        this.jdField_a_of_type_Atmm.a(paramHttpMsg2.errCode, paramHttpMsg2.getErrorString(), paramHttpMsg2.rawRespHeader);
        return;
      }
      paramHttpMsg1 = paramHttpMsg2.getResponseProperty("Range");
      if (paramHttpMsg1 == null)
      {
        this.jdField_a_of_type_Atmm.a(9001, "httpServer not has range");
        return;
      }
      l = Long.parseLong(paramHttpMsg1);
      this.jdField_a_of_type_Atmm.a(l, paramHttpMsg2.rawRespHeader);
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
    this.jdField_a_of_type_Atmm.a(paramHttpMsg2.errCode, paramHttpMsg2.getErrorString(), paramHttpMsg2.rawRespHeader);
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
        break label61;
      }
    }
    label61:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendAppDataIncerment(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), bool, k, i, j, paramHttpMsg.flow);
      return;
    }
  }
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atna
 * JD-Core Version:    0.7.0.1
 */