import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.transfile.ScribblePicDownloadProcessor.1;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bewu
  extends berj
{
  MessageForScribble a;
  private ArrayList<String> c;
  private int d;
  String e;
  private int q;
  
  public bewu(beyb parambeyb, beyg parambeyg)
  {
    super(parambeyb, parambeyg);
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  private void a(MessageForScribble paramMessageForScribble)
  {
    if (paramMessageForScribble != null)
    {
      paramMessageForScribble.prewrite();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForScribble.frienduin, paramMessageForScribble.istroop, paramMessageForScribble.uniseq, paramMessageForScribble.msgData);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble == null) {
      return;
    }
    String str = bbxv.a(this.jdField_a_of_type_Beyg.h);
    if (str.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileMd5))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.mExistInfo.mCombineFileExist = true;
      }
      int i = bbxm.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
      if (i == bbxm.d)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.mExistInfo.mDataFileExist = true;
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.mExistInfo.mInit = true;
        }
        e();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.mExistInfo.mDataFileExist = false;
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.mExistInfo.mInit = true;
      }
      b(9303, a(new Exception("SpliteCombineFile illegal result: " + i)));
      d();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.mExistInfo.mDataFileExist = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.mExistInfo.mCombineFileExist = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.mExistInfo.mInit = true;
    }
    b(9041, a(new Exception("SpliteCombineFile illegal md5String: " + str + "  msg.combineFileMd5:  " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileMd5)));
    d();
  }
  
  public void aN_()
  {
    super.aN_();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.fileDownloadStatus = 3;
    }
    String str;
    if ((this.jdField_e_of_type_JavaLangString != null) && (!this.jdField_e_of_type_JavaLangString.startsWith("https")))
    {
      str = InnerDns.getHostFromUrl(this.jdField_e_of_type_JavaLangString);
      this.c = InnerDns.getInstance().reqDnsForIpList(str, 1018);
    }
    if ((this.c != null) && (!this.c.isEmpty()))
    {
      str = "ipListFromInnerDns : ";
      int i = 0;
      while (i < this.c.size())
      {
        str = str + " " + (String)this.c.get(i);
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ScribblePicDownloadProcessor", 2, str);
      }
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945A", "0X800945A", 0, 0, "", "", "", "");
    f();
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScribblePicDownloadProcessor", 2, "resume()");
    }
    if (this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = false;
      this.jdField_q_of_type_Boolean = false;
      this.k = 0;
      this.j = "";
      this.jdField_a_of_type_Bern.a.post(new ScribblePicDownloadProcessor.1(this));
    }
    return 0;
  }
  
  public int c()
  {
    super.c();
    b("uiParam", this.jdField_a_of_type_Beyg.toString());
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForScribble)))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble = ((MessageForScribble)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileUrl;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileUrl.equals("")) || (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileUrl.startsWith("http")))
    {
      b(9302, a(new Exception("combineFileUrl illegal " + this.jdField_e_of_type_JavaLangString)));
      d();
      return -1;
    }
    this.jdField_a_of_type_Beyg.h = bbxm.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    if (TextUtils.isEmpty(this.jdField_a_of_type_Beyg.h))
    {
      b(9302, a(new Exception("combineFileMd5 illegal " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileMd5)));
      d();
      return -1;
    }
    return 0;
  }
  
  void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.fileDownloadStatus = 2;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    d(2005);
    bbxk localbbxk = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localbbxk != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble == null) {
        break label92;
      }
      localbbxk.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945B", "0X800945B", 0, 0, "", "", "", "");
      return;
      label92:
      localbbxk.a(null);
    }
  }
  
  void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.fileDownloadStatus = 1;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    d(2003);
    bbxk localbbxk = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localbbxk != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble == null) {
        break label92;
      }
      localbbxk.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945C", "0X800945C", 0, 0, "", "", "", "");
      return;
      label92:
      localbbxk.a(null);
    }
  }
  
  public void f()
  {
    QLog.i("ScribblePicDownloadProcessor", 2, "scribble download start ");
    this.jdField_b_of_type_Berr.a();
    String str1 = this.jdField_e_of_type_JavaLangString;
    d(2001);
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = this;
    localbeum.jdField_a_of_type_JavaLangString = str1;
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.c = this.jdField_a_of_type_Beyg.h;
    localbeum.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    localbeum.f = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    localbeum.jdField_e_of_type_Int = this.jdField_a_of_type_Beyg.jdField_b_of_type_Int;
    localbeum.jdField_a_of_type_Long = 0L;
    localbeum.l = true;
    localbeum.jdField_m_of_type_Boolean = true;
    String str2;
    if ((this.c != null) && (!this.c.isEmpty()) && (this.d < this.c.size()))
    {
      str2 = (String)this.c.get(this.d);
      str2 = InnerDns.replaceDomainWithIp(localbeum.jdField_a_of_type_JavaLangString, str2);
      if ((str2 != null) && (!str2.equals(localbeum.jdField_a_of_type_JavaLangString))) {
        localbeum.jdField_a_of_type_JavaLangString = str2;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945D", "0X800945D", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        str2 = bews.a(str1);
        if (QLog.isColorLevel()) {
          QLog.i("ScribblePicDownloadProcessor", 2, "httpDownRespDomain: " + str2 + "reqUrl : " + str1 + " " + localbeum.jdField_a_of_type_JavaLangString + " uuid:" + this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString + " downOffset:" + localbeum.jdField_a_of_type_Long);
        }
        QLog.i("ScribblePicDownloadProcessor", 2, "index:" + this.d + str1);
        if (f()) {
          break;
        }
        return;
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945E", "0X800945E", 0, 0, "", "", "", "");
      }
      this.jdField_a_of_type_Bevl = localbeum;
      o();
      this.jdField_a_of_type_Beuo.a(localbeum);
      return;
    }
  }
  
  public void onResp(bevm parambevm)
  {
    super.onResp(parambevm);
    this.jdField_a_of_type_Bevl = null;
    Object localObject = new StringBuilder().append(" result:");
    if (parambevm.jdField_a_of_type_Int == 0)
    {
      bool = true;
      b("onHttpResp", bool);
      localObject = this.jdField_b_of_type_Berr;
      if (parambevm.jdField_a_of_type_Int != 0) {
        break label179;
      }
    }
    label179:
    for (boolean bool = true;; bool = false)
    {
      a((berr)localObject, parambevm, bool);
      this.jdField_a_of_type_Long = parambevm.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (parambevm.jdField_b_of_type_Long + parambevm.jdField_a_of_type_Bevl.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += parambevm.c;
      QLog.i("ScribblePicDownloadProcessor", 2, "scribble download onResp resp.mResult = " + parambevm.jdField_a_of_type_Int);
      if (parambevm.jdField_a_of_type_Int != 0) {
        break label184;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.mExistInfo.mCombineFileExist = true;
      }
      g();
      return;
      bool = false;
      break;
    }
    label184:
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.mExistInfo.mCombineFileExist = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.mExistInfo.mDataFileExist = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.mExistInfo.mInit = true;
    }
    if (this.jdField_q_of_type_Int < 5)
    {
      this.jdField_q_of_type_Int += 1;
      if ((this.c != null) && (!this.c.isEmpty()) && (this.d < this.c.size()))
      {
        QLog.e("ScribblePicDownloadProcessor", 2, "scribble download  retry by changeIp");
        n();
        parambevm = InnerDns.getHostFromUrl(this.jdField_e_of_type_JavaLangString);
        InnerDns.getInstance().reportBadIp(parambevm, (String)this.c.get(this.d), 1018);
        this.d += 1;
        f();
        return;
      }
      if ((parambevm.jdField_b_of_type_Int == 9364) && (this.jdField_m_of_type_Int < 3))
      {
        b("[netChg]", "failed.but net change detect.so retry");
        QLog.e("ScribblePicDownloadProcessor", 2, "scribble download  retry");
        this.jdField_m_of_type_Int += 1;
        n();
        f();
        return;
      }
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewu
 * JD-Core Version:    0.7.0.1
 */