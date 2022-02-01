import android.text.TextUtils;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.common.login.LoginData;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import mqq.manager.TicketManager;

class awcr
  implements awcw
{
  awcr(awcc paramawcc, LoginData paramLoginData, TicketManager paramTicketManager, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((!awcc.a(this.jdField_a_of_type_Awcc, paramInt)) || (TextUtils.isEmpty(paramString)))
    {
      QLog.w("XProxy|NowProxy", 1, "asyn get skey error. retCode: " + paramInt);
      return;
    }
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData.setSkey(paramString.getBytes());
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData.setST(this.jdField_a_of_type_MqqManagerTicketManager.getSt(this.jdField_a_of_type_JavaLangString, 16));
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData.setSTKey(this.jdField_a_of_type_MqqManagerTicketManager.getStkey(this.jdField_a_of_type_JavaLangString, 16));
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData.setUserId(this.jdField_a_of_type_JavaLangString);
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Awcc.b)) || (TextUtils.isEmpty(this.jdField_a_of_type_Awcc.jdField_a_of_type_JavaLangString)))
    {
      NowLive.login(this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData);
      return;
    }
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData.setKey(this.jdField_a_of_type_Awcc.b.getBytes());
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData.setAuthAppId("101490787");
    this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData.setOriginalId(this.jdField_a_of_type_Awcc.jdField_a_of_type_JavaLangString);
    NowLive.login(this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginData);
    awcc.a(this.jdField_a_of_type_Awcc).set(System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awcr
 * JD-Core Version:    0.7.0.1
 */