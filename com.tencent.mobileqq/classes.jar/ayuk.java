import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.transfile.ScribblePicDownloadProcessor.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ayuk
  extends ayou
{
  MessageForScribble a;
  private int jdField_c_of_type_Int;
  private ArrayList<String> jdField_c_of_type_JavaUtilArrayList;
  String e = "";
  private int p;
  
  public ayuk(ayvv paramayvv, aywa paramaywa)
  {
    super(paramayvv, paramaywa);
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
    String str = awhf.a(this.jdField_a_of_type_Aywa.h);
    if (str.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileMd5))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.mExistInfo.mCombineFileExist = true;
      }
      int i = awgw.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
      if (i == awgw.d)
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
  
  public void aR_()
  {
    super.aR_();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.fileDownloadStatus = 3;
    }
    String str;
    if ((this.e != null) && (!this.e.startsWith("https")))
    {
      str = ayxe.a(this.e);
      this.jdField_c_of_type_JavaUtilArrayList = ayxe.a().a(str, 1018);
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
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945A", "0X800945A", 0, 0, "", "", "", "");
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
      this.jdField_a_of_type_Ayox.a.post(new ScribblePicDownloadProcessor.1(this));
    }
    return 0;
  }
  
  public int c()
  {
    super.c();
    b("uiParam", this.jdField_a_of_type_Aywa.toString());
    if ((this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForScribble)))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble = ((MessageForScribble)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      this.e = this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileUrl;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileUrl.equals("")) || (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble.combineFileUrl.startsWith("http")))
    {
      b(9302, a(new Exception("combineFileUrl illegal " + this.e)));
      d();
      return -1;
    }
    this.jdField_a_of_type_Aywa.h = awgw.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    if (TextUtils.isEmpty(this.jdField_a_of_type_Aywa.h))
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
    awgu localawgu = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localawgu != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble == null) {
        break label92;
      }
      localawgu.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    }
    for (;;)
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945B", "0X800945B", 0, 0, "", "", "", "");
      return;
      label92:
      localawgu.a(null);
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
    awgu localawgu = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localawgu != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble == null) {
        break label92;
      }
      localawgu.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForScribble);
    }
    for (;;)
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945C", "0X800945C", 0, 0, "", "", "", "");
      return;
      label92:
      localawgu.a(null);
    }
  }
  
  public void f()
  {
    QLog.i("ScribblePicDownloadProcessor", 2, "scribble download start ");
    this.jdField_b_of_type_Aypb.a();
    String str1 = this.e;
    d(2001);
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_Aysa = this;
    localayrv.jdField_a_of_type_JavaLangString = str1;
    localayrv.jdField_a_of_type_Int = 0;
    localayrv.c = this.jdField_a_of_type_Aywa.h;
    localayrv.e = String.valueOf(this.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
    localayrv.g = this.jdField_a_of_type_Aywa.jdField_a_of_type_Int;
    localayrv.f = this.jdField_a_of_type_Aywa.jdField_b_of_type_Int;
    localayrv.jdField_a_of_type_Long = 0L;
    localayrv.k = true;
    localayrv.l = true;
    String str2;
    if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (!this.jdField_c_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_c_of_type_Int < this.jdField_c_of_type_JavaUtilArrayList.size()))
    {
      str2 = (String)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int);
      str2 = ayxe.a(localayrv.jdField_a_of_type_JavaLangString, str2);
      if ((str2 != null) && (!str2.equals(localayrv.jdField_a_of_type_JavaLangString))) {
        localayrv.jdField_a_of_type_JavaLangString = str2;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945D", "0X800945D", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        str2 = ayui.a(str1);
        if (QLog.isColorLevel()) {
          QLog.i("ScribblePicDownloadProcessor", 2, "httpDownRespDomain: " + str2 + "reqUrl : " + str1 + " " + localayrv.jdField_a_of_type_JavaLangString + " uuid:" + this.jdField_a_of_type_Aywa.e + " downOffset:" + localayrv.jdField_a_of_type_Long);
        }
        QLog.i("ScribblePicDownloadProcessor", 2, "index:" + this.jdField_c_of_type_Int + str1);
        if (f()) {
          break;
        }
        return;
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800945E", "0X800945E", 0, 0, "", "", "", "");
      }
      this.jdField_a_of_type_Aysw = localayrv;
      n();
      this.jdField_a_of_type_Ayry.a(localayrv);
      return;
    }
  }
  
  public void onResp(aysx paramaysx)
  {
    super.onResp(paramaysx);
    this.jdField_a_of_type_Aysw = null;
    Object localObject = new StringBuilder().append(" result:");
    if (paramaysx.jdField_a_of_type_Int == 0)
    {
      bool = true;
      b("onHttpResp", bool);
      localObject = this.jdField_b_of_type_Aypb;
      if (paramaysx.jdField_a_of_type_Int != 0) {
        break label179;
      }
    }
    label179:
    for (boolean bool = true;; bool = false)
    {
      a((aypb)localObject, paramaysx, bool);
      this.jdField_a_of_type_Long = paramaysx.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long <= 0L) {
        this.jdField_a_of_type_Long = (paramaysx.jdField_b_of_type_Long + paramaysx.jdField_a_of_type_Aysw.jdField_a_of_type_Long);
      }
      this.jdField_b_of_type_Long += paramaysx.c;
      QLog.i("ScribblePicDownloadProcessor", 2, "scribble download onResp resp.mResult = " + paramaysx.jdField_a_of_type_Int);
      if (paramaysx.jdField_a_of_type_Int != 0) {
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
        paramaysx = ayxe.a(this.e);
        ayxe.a().a(paramaysx, (String)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_Int), 1018);
        this.jdField_c_of_type_Int += 1;
        f();
        return;
      }
      if ((paramaysx.jdField_b_of_type_Int == 9364) && (this.l < 3))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayuk
 * JD-Core Version:    0.7.0.1
 */