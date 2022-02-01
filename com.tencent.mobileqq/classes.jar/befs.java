import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;

public class befs
  implements IHttpCommunicatorListener
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private beft jdField_a_of_type_Beft;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  public befs(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
    {
      befc.c("FtnDownloader", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] cancel ftn download");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().cancelMsg(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, HttpMsg paramHttpMsg)
  {
    befc.a("FtnDownloader", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download err. errCode:" + paramInt + " errMsg:" + paramString1 + " rspHeader:" + paramString2);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Beft != null) {
      this.jdField_a_of_type_Beft.a(paramInt, paramString1, paramString2, paramHttpMsg);
    }
  }
  
  public void a(beft parambeft)
  {
    this.jdField_a_of_type_Beft = parambeft;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    befc.c("FtnDownloader", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download url:" + paramString + " pos:" + paramLong);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    String str2 = "bytes=" + paramLong + "-";
    HttpMsg localHttpMsg = new HttpMsg(paramString, null, this, true);
    localHttpMsg.setInstanceFollowRedirects(false);
    String str1 = "gprs";
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
      str1 = "wifi";
    }
    localHttpMsg.setRequestProperty("Net-type", str1);
    localHttpMsg.setRequestProperty("cache-control", "no-cache");
    if (paramLong != 0L) {
      localHttpMsg.setRequestProperty("Range", str2);
    }
    localHttpMsg.setPriority(5);
    localHttpMsg.setDataSlice(true);
    localHttpMsg.fileType = this.jdField_b_of_type_Int;
    localHttpMsg.busiType = this.jdField_a_of_type_Int;
    localHttpMsg.msgId = String.valueOf(this.jdField_a_of_type_Long);
    localHttpMsg.setRequestProperty("Accept-Encoding", "identity");
    if (this.jdField_a_of_type_Beft != null) {
      this.jdField_a_of_type_Beft.b(localHttpMsg);
    }
    str1 = "";
    if (paramString != null) {
      str1 = paramString.toLowerCase();
    }
    if ((this.jdField_b_of_type_Boolean) && (str1.startsWith("https")))
    {
      localHttpMsg.mIsHttps = true;
      localHttpMsg.mIsHostIP = asib.a(paramString);
      localHttpMsg.mReqHost = this.jdField_a_of_type_JavaLangString;
    }
    localHttpMsg.timeoutParam = aszt.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().sendMsg(localHttpMsg);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
    return true;
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    long l;
    do
    {
      do
      {
        return;
        if (paramHttpMsg1 == this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) {
          break;
        }
        if ((paramHttpMsg1 != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null))
        {
          befc.a("FtnDownloader", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(paramHttpMsg1.getSerial()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()) + "]");
          return;
        }
        if (paramHttpMsg1 != null)
        {
          befc.a("FtnDownloader", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(paramHttpMsg1.getSerial()) + "]");
          return;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null);
      befc.a("FtnDownloader", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()) + "]");
      return;
      if ((paramHttpMsg2.getResponseCode() != 206) && (paramHttpMsg2.getResponseCode() != 200)) {
        break;
      }
      paramHttpMsg1 = paramHttpMsg2.getRecvData();
      l = paramHttpMsg2.getTotalLen();
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = l;
      }
    } while (this.jdField_a_of_type_Beft == null);
    this.jdField_a_of_type_Beft.a(paramHttpMsg1, l, paramHttpMsg2.rawReqHeader);
    return;
    befc.a("FtnDownloader", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download decode resp code no 200|206");
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramHttpMsg2 != null)
    {
      a(paramHttpMsg2.errCode, paramHttpMsg2.getErrorString(), paramHttpMsg2.rawRespHeader, paramHttpMsg2);
      return;
    }
    a(9001, "err no response", "", null);
  }
  
  public void handleRedirect(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      befc.a("FtnDownloader", befc.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download Redirect. " + paramString);
    } while (this.jdField_a_of_type_Beft == null);
    this.jdField_a_of_type_Beft.a(paramString);
  }
  
  public void onFlowEvent(HttpMsg paramHttpMsg)
  {
    if (paramHttpMsg != null) {
      if (!"POST".equals(paramHttpMsg.getRequestMethod())) {
        break label54;
      }
    }
    label54:
    for (boolean bool = true;; bool = false)
    {
      if (this.jdField_a_of_type_Beft != null) {
        this.jdField_a_of_type_Beft.a(paramHttpMsg.fileType, paramHttpMsg.busiType, paramHttpMsg.netType, bool, paramHttpMsg.flow);
      }
      return;
    }
  }
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (5 == paramInt) {
      if (!this.jdField_a_of_type_Boolean) {}
    }
    while ((3 != paramInt) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Beft == null))
    {
      do
      {
        return true;
        this.jdField_a_of_type_Boolean = true;
      } while (this.jdField_a_of_type_Beft == null);
      this.jdField_a_of_type_Beft.a();
      return true;
    }
    this.jdField_a_of_type_Beft.a(paramHttpMsg2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befs
 * JD-Core Version:    0.7.0.1
 */