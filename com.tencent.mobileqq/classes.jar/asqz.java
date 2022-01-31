import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class asqz
{
  public int a;
  public String a;
  public ArrayList<basp> a;
  public boolean a;
  public String b;
  public String c;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      basp localbasp = (basp)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localStringBuilder.append("http://");
      localStringBuilder.append(localbasp.jdField_a_of_type_JavaLangString);
      if (localbasp.jdField_a_of_type_Int != 80)
      {
        localStringBuilder.append(":");
        localStringBuilder.append(localbasp.jdField_a_of_type_Int);
      }
      localStringBuilder.append("/");
    }
    for (;;)
    {
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      return localStringBuilder.toString();
      if (!this.jdField_c_of_type_JavaLangString.startsWith("http://")) {
        localStringBuilder.append("http://");
      }
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      if (!this.jdField_c_of_type_JavaLangString.endsWith("/")) {
        localStringBuilder.append("/");
      }
    }
  }
  
  public void a(baxr parambaxr)
  {
    int i = 0;
    StringBuilder localStringBuilder;
    if (HotVideoData.access$000())
    {
      this.jdField_a_of_type_JavaUtilArrayList = parambaxr.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {}
      if (parambaxr.jdField_c_of_type_Int != 0) {
        break label200;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onBusiProtoResp() cdn ---- mIpListSize:");
        if (this.jdField_a_of_type_JavaUtilArrayList != null) {
          break label189;
        }
      }
    }
    for (;;)
    {
      QLog.d("HotVideoData", 2, i + " mHostType:" + parambaxr.jdField_a_of_type_Int + " domain:" + parambaxr.jdField_b_of_type_JavaLangString + " url:" + parambaxr.jdField_c_of_type_JavaLangString);
      QLog.d("HotVideoData", 2, "onBusiProtoResp() cdn ---- downResp.previewMd5:" + HexUtil.bytes2HexStr(parambaxr.jdField_a_of_type_ArrayOfByte));
      this.jdField_b_of_type_JavaLangString = parambaxr.jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_JavaUtilArrayList = parambaxr.jdField_b_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        break;
      }
      break;
      label189:
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    label200:
    this.jdField_a_of_type_Boolean = false;
    if (-5100026 == parambaxr.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotVideoData", 2, "onBusiProtoResp()---- 安全打击");
      }
      this.jdField_a_of_type_JavaLangString = alpo.a(2131706002);
      return;
    }
    if ((-9527 == parambaxr.d) && ((parambaxr.g.equals("H_400_-5103017")) || (parambaxr.g.equals("H_400_-5103059"))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotVideoData", 2, "onBusiProtoResp()---- 视频文件过期errCode=" + parambaxr.d);
      }
      this.jdField_a_of_type_JavaLangString = alpo.a(2131706003);
      return;
    }
    this.jdField_a_of_type_JavaLangString = alpo.a(2131706004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqz
 * JD-Core Version:    0.7.0.1
 */