import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.transfile.ScribblePicDownloadProcessor.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class basl
  extends bamr
{
  MessageForScribble a;
  private int jdField_c_of_type_Int;
  private ArrayList<String> jdField_c_of_type_JavaUtilArrayList;
  String e = "";
  private int p;
  
  public basl(batw parambatw, baub parambaub)
  {
    super(parambatw, parambaub);
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
    String str = aycl.a(this.jdField_a_of_type_Baub.h);
    if (str.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileMd5))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.mExistInfo.mCombineFileExist = true;
      }
      int i = aycc.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
      if (i == aycc.d)
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
  
  public void aS_()
  {
    super.aS_();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.fileDownloadStatus = 3;
    }
    String str;
    if ((this.e != null) && (!this.e.startsWith("https")))
    {
      str = bavf.a(this.e);
      this.jdField_c_of_type_JavaUtilArrayList = bavf.a().a(str, 1018);
    }
    if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (!this.jdField_c_of_type_JavaUtilArrayList.isEmpty()))
    {
      str = "ipListFromInnerDns : ";
      int i = 0;
      while (i < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        str = str + " " + (String)this.jdField_c_of_type_JavaUtilArrayList.get(i);
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ScribblePicDownloadProcessor", 2, str);
      }
    }
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945A", "0X800945A", 0, 0, "", "", "", "");
    f();
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScribblePicDownloadProcessor", 2, "resume()");
    }
    if (this.k)
    {
      this.k = false;
      this.o = false;
      this.jdField_j_of_type_Int = 0;
      this.jdField_j_of_type_JavaLangString = "";
      this.jdField_a_of_type_Bamu.a.post(new ScribblePicDownloadProcessor.1(this));
    }
    return 0;
  }
  
  public int c()
  {
    super.c();
    b("uiParam", this.jdField_a_of_type_Baub.toString());
    if ((this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForScribble)))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble = ((MessageForScribble)this.jdField_a_of_type_Baub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      this.e = this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileUrl;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileUrl.equals("")) || (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileUrl.startsWith("http")))
    {
      b(9302, a(new Exception("combineFileUrl illegal " + this.e)));
      d();
      return -1;
    }
    this.jdField_a_of_type_Baub.h = aycc.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    if (TextUtils.isEmpty(this.jdField_a_of_type_Baub.h))
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
    ayca localayca = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localayca != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble == null) {
        break label92;
      }
      localayca.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    }
    for (;;)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945B", "0X800945B", 0, 0, "", "", "", "");
      return;
      label92:
      localayca.a(null);
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
    ayca localayca = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localayca != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble == null) {
        break label92;
      }
      localayca.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    }
    for (;;)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945C", "0X800945C", 0, 0, "", "", "", "");
      return;
      label92:
      localayca.a(null);
    }
  }
  
  public void f()
  {
    QLog.i("ScribblePicDownloadProcessor", 2, "scribble download start ");
    this.jdField_b_of_type_Bamy.a();
    String str1 = this.e;
    d(2001);
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_Bapx = this;
    localbaps.jdField_a_of_type_JavaLangString = str1;
    localbaps.jdField_a_of_type_Int = 0;
    localbaps.c = this.jdField_a_of_type_Baub.h;
    localbaps.e = String.valueOf(this.jdField_a_of_type_Baub.jdField_a_of_type_Long);
    localbaps.g = this.jdField_a_of_type_Baub.jdField_a_of_type_Int;
    localbaps.f = this.jdField_a_of_type_Baub.jdField_b_of_type_Int;
    localbaps.jdField_a_of_type_Long = 0L;
    localbaps.k = true;
    localbaps.l = true;
    String str2;
    if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (!this.jdField_c_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_c_of_type_Int < this.jdField_c_of_type_JavaUtilArrayList.size()))
    {
      str2 = (String)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int);
      str2 = bavf.a(localbaps.jdField_a_of_type_JavaLangString, str2);
      if ((str2 != null) && (!str2.equals(localbaps.jdField_a_of_type_JavaLangString))) {
        localbaps.jdField_a_of_type_JavaLangString = str2;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945D", "0X800945D", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        str2 = basj.a(str1);
        if (QLog.isColorLevel()) {
          QLog.i("ScribblePicDownloadProcessor", 2, "httpDownRespDomain: " + str2 + "reqUrl : " + str1 + " " + localbaps.jdField_a_of_type_JavaLangString + " uuid:" + this.jdField_a_of_type_Baub.e + " downOffset:" + localbaps.jdField_a_of_type_Long);
        }
        QLog.i("ScribblePicDownloadProcessor", 2, "index:" + this.jdField_c_of_type_Int + str1);
        if (f()) {
          break;
        }
        return;
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945E", "0X800945E", 0, 0, "", "", "", "");
      }
      this.jdField_a_of_type_Baqv = localbaps;
      n();
      this.jdField_a_of_type_Bapv.a(localbaps);
      return;
    }
  }
  
  public void onResp(baqw parambaqw)
  {
    super.onResp(parambaqw);
    this.jdField_a_of_type_Baqv = null;
    Object localObject = new StringBuilder().append(" result:");
    if (parambaqw.jdField_a_of_type_Int == 0)
    {
      bool = true;
      b("onHttpResp", bool);
      localObject = this.jdField_b_of_type_Bamy;
      if (parambaqw.jdField_a_of_type_Int != 0) {
        break label179;
      }
    }
    label179:
    for (boolean bool = true;; bool = false)
    {
      a((bamy)localObject, parambaqw, bool);
      this.jdField_a_of_type_Long = parambaqw.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (parambaqw.jdField_b_of_type_Long + parambaqw.jdField_a_of_type_Baqv.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += parambaqw.c;
      QLog.i("ScribblePicDownloadProcessor", 2, "scribble download onResp resp.mResult = " + parambaqw.jdField_a_of_type_Int);
      if (parambaqw.jdField_a_of_type_Int != 0) {
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
    if (this.p < 5)
    {
      this.p += 1;
      if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (!this.jdField_c_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_c_of_type_Int < this.jdField_c_of_type_JavaUtilArrayList.size()))
      {
        QLog.e("ScribblePicDownloadProcessor", 2, "scribble download  retry by changeIp");
        m();
        parambaqw = bavf.a(this.e);
        bavf.a().a(parambaqw, (String)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int), 1018);
        this.jdField_c_of_type_Int += 1;
        f();
        return;
      }
      if ((parambaqw.jdField_b_of_type_Int == 9364) && (this.l < 3))
      {
        b("[netChg]", "failed.but net change detect.so retry");
        QLog.e("ScribblePicDownloadProcessor", 2, "scribble download  retry");
        this.l += 1;
        m();
        f();
        return;
      }
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     basl
 * JD-Core Version:    0.7.0.1
 */