import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aqgh
{
  public int a;
  public String a;
  public ArrayList<axuh> a;
  public boolean a;
  public String b;
  public String c;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      axuh localaxuh = (axuh)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localStringBuilder.append("http://");
      localStringBuilder.append(localaxuh.jdField_a_of_type_JavaLangString);
      if (localaxuh.jdField_a_of_type_Int != 80)
      {
        localStringBuilder.append(":");
        localStringBuilder.append(localaxuh.jdField_a_of_type_Int);
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
  
  public void a(axzj paramaxzj)
  {
    int i = 0;
    StringBuilder localStringBuilder;
    if (HotVideoData.access$000())
    {
      this.jdField_a_of_type_JavaUtilArrayList = paramaxzj.jdField_a_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {}
      if (paramaxzj.jdField_c_of_type_Int != 0) {
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
      QLog.d("HotVideoData", 2, i + " mHostType:" + paramaxzj.jdField_a_of_type_Int + " domain:" + paramaxzj.jdField_b_of_type_JavaLangString + " url:" + paramaxzj.jdField_c_of_type_JavaLangString);
      QLog.d("HotVideoData", 2, "onBusiProtoResp() cdn ---- downResp.previewMd5:" + HexUtil.bytes2HexStr(paramaxzj.jdField_a_of_type_ArrayOfByte));
      this.jdField_b_of_type_JavaLangString = paramaxzj.jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_JavaUtilArrayList = paramaxzj.jdField_b_of_type_JavaUtilArrayList;
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        break;
      }
      break;
      label189:
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    label200:
    this.jdField_a_of_type_Boolean = false;
    if (-5100026 == paramaxzj.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotVideoData", 2, "onBusiProtoResp()---- 安全打击");
      }
      this.jdField_a_of_type_JavaLangString = ajjy.a(2131639834);
      return;
    }
    if ((-9527 == paramaxzj.d) && ((paramaxzj.g.equals("H_400_-5103017")) || (paramaxzj.g.equals("H_400_-5103059"))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotVideoData", 2, "onBusiProtoResp()---- 视频文件过期errCode=" + paramaxzj.d);
      }
      this.jdField_a_of_type_JavaLangString = ajjy.a(2131639835);
      return;
    }
    this.jdField_a_of_type_JavaLangString = ajjy.a(2131639836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqgh
 * JD-Core Version:    0.7.0.1
 */