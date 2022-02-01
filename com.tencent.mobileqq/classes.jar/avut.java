import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class avut
{
  public int a;
  public String a;
  public ArrayList<bewy> a;
  public boolean a;
  public String b;
  public String c;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      bewy localbewy = (bewy)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localStringBuilder.append("http://");
      localStringBuilder.append(localbewy.jdField_a_of_type_JavaLangString);
      if (localbewy.jdField_a_of_type_Int != 80)
      {
        localStringBuilder.append(":");
        localStringBuilder.append(localbewy.jdField_a_of_type_Int);
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
  
  public void a(bfbx parambfbx)
  {
    int i = 0;
    StringBuilder localStringBuilder;
    if (HotVideoData.access$000())
    {
      this.jdField_a_of_type_JavaUtilArrayList = parambfbx.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {}
      if (parambfbx.jdField_c_of_type_Int != 0) {
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
      QLog.d("HotVideoData", 2, i + " mHostType:" + parambfbx.jdField_a_of_type_Int + " domain:" + parambfbx.jdField_b_of_type_JavaLangString + " url:" + parambfbx.jdField_c_of_type_JavaLangString);
      QLog.d("HotVideoData", 2, "onBusiProtoResp() cdn ---- downResp.previewMd5:" + HexUtil.bytes2HexStr(parambfbx.jdField_a_of_type_ArrayOfByte));
      this.jdField_b_of_type_JavaLangString = parambfbx.jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_JavaUtilArrayList = parambfbx.jdField_b_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        break;
      }
      break;
      label189:
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    label200:
    this.jdField_a_of_type_Boolean = false;
    if (-5100026 == parambfbx.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotVideoData", 2, "onBusiProtoResp()---- 安全打击");
      }
      this.jdField_a_of_type_JavaLangString = anzj.a(2131704522);
      return;
    }
    if ((-9527 == parambfbx.d) && ((parambfbx.g.equals("H_400_-5103017")) || (parambfbx.g.equals("H_400_-5103059"))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotVideoData", 2, "onBusiProtoResp()---- 视频文件过期errCode=" + parambfbx.d);
      }
      this.jdField_a_of_type_JavaLangString = anzj.a(2131704523);
      return;
    }
    this.jdField_a_of_type_JavaLangString = anzj.a(2131704524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avut
 * JD-Core Version:    0.7.0.1
 */