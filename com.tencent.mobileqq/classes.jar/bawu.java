import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.transfile.ScribblePicDownloadProcessor.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bawu
  extends bara
{
  MessageForScribble a;
  private int jdField_c_of_type_Int;
  private ArrayList<String> jdField_c_of_type_JavaUtilArrayList;
  String e = "";
  private int p;
  
  public bawu(bayf parambayf, bayk parambayk)
  {
    super(parambayf, parambayk);
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
    String str = aygu.a(this.jdField_a_of_type_Bayk.h);
    if (str.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileMd5))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.mExistInfo.mCombineFileExist = true;
      }
      int i = aygl.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
      if (i == aygl.d)
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
  
  public void aP_()
  {
    super.aP_();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.fileDownloadStatus = 3;
    }
    String str;
    if ((this.e != null) && (!this.e.startsWith("https")))
    {
      str = bazo.a(this.e);
      this.jdField_c_of_type_JavaUtilArrayList = bazo.a().a(str, 1018);
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
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945A", "0X800945A", 0, 0, "", "", "", "");
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
      this.jdField_a_of_type_Bard.a.post(new ScribblePicDownloadProcessor.1(this));
    }
    return 0;
  }
  
  public int c()
  {
    super.c();
    b("uiParam", this.jdField_a_of_type_Bayk.toString());
    if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForScribble)))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble = ((MessageForScribble)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      this.e = this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileUrl;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileUrl.equals("")) || (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileUrl.startsWith("http")))
    {
      b(9302, a(new Exception("combineFileUrl illegal " + this.e)));
      d();
      return -1;
    }
    this.jdField_a_of_type_Bayk.h = aygl.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    if (TextUtils.isEmpty(this.jdField_a_of_type_Bayk.h))
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
    aygj localaygj = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localaygj != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble == null) {
        break label92;
      }
      localaygj.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945B", "0X800945B", 0, 0, "", "", "", "");
      return;
      label92:
      localaygj.a(null);
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
    aygj localaygj = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localaygj != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble == null) {
        break label92;
      }
      localaygj.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945C", "0X800945C", 0, 0, "", "", "", "");
      return;
      label92:
      localaygj.a(null);
    }
  }
  
  public void f()
  {
    QLog.i("ScribblePicDownloadProcessor", 2, "scribble download start ");
    this.jdField_b_of_type_Barh.a();
    String str1 = this.e;
    d(2001);
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = this;
    localbaub.jdField_a_of_type_JavaLangString = str1;
    localbaub.jdField_a_of_type_Int = 0;
    localbaub.c = this.jdField_a_of_type_Bayk.h;
    localbaub.e = String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
    localbaub.g = this.jdField_a_of_type_Bayk.jdField_a_of_type_Int;
    localbaub.f = this.jdField_a_of_type_Bayk.jdField_b_of_type_Int;
    localbaub.jdField_a_of_type_Long = 0L;
    localbaub.k = true;
    localbaub.l = true;
    String str2;
    if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (!this.jdField_c_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_c_of_type_Int < this.jdField_c_of_type_JavaUtilArrayList.size()))
    {
      str2 = (String)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int);
      str2 = bazo.a(localbaub.jdField_a_of_type_JavaLangString, str2);
      if ((str2 != null) && (!str2.equals(localbaub.jdField_a_of_type_JavaLangString))) {
        localbaub.jdField_a_of_type_JavaLangString = str2;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945D", "0X800945D", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        str2 = baws.a(str1);
        if (QLog.isColorLevel()) {
          QLog.i("ScribblePicDownloadProcessor", 2, "httpDownRespDomain: " + str2 + "reqUrl : " + str1 + " " + localbaub.jdField_a_of_type_JavaLangString + " uuid:" + this.jdField_a_of_type_Bayk.e + " downOffset:" + localbaub.jdField_a_of_type_Long);
        }
        QLog.i("ScribblePicDownloadProcessor", 2, "index:" + this.jdField_c_of_type_Int + str1);
        if (f()) {
          break;
        }
        return;
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945E", "0X800945E", 0, 0, "", "", "", "");
      }
      this.jdField_a_of_type_Bave = localbaub;
      n();
      this.jdField_a_of_type_Baue.a(localbaub);
      return;
    }
  }
  
  public void onResp(bavf parambavf)
  {
    super.onResp(parambavf);
    this.jdField_a_of_type_Bave = null;
    Object localObject = new StringBuilder().append(" result:");
    if (parambavf.jdField_a_of_type_Int == 0)
    {
      bool = true;
      b("onHttpResp", bool);
      localObject = this.jdField_b_of_type_Barh;
      if (parambavf.jdField_a_of_type_Int != 0) {
        break label179;
      }
    }
    label179:
    for (boolean bool = true;; bool = false)
    {
      a((barh)localObject, parambavf, bool);
      this.jdField_a_of_type_Long = parambavf.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (parambavf.jdField_b_of_type_Long + parambavf.jdField_a_of_type_Bave.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += parambavf.c;
      QLog.i("ScribblePicDownloadProcessor", 2, "scribble download onResp resp.mResult = " + parambavf.jdField_a_of_type_Int);
      if (parambavf.jdField_a_of_type_Int != 0) {
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
        parambavf = bazo.a(this.e);
        bazo.a().a(parambavf, (String)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int), 1018);
        this.jdField_c_of_type_Int += 1;
        f();
        return;
      }
      if ((parambavf.jdField_b_of_type_Int == 9364) && (this.l < 3))
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
 * Qualified Name:     bawu
 * JD-Core Version:    0.7.0.1
 */