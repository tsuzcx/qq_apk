import NS_NEW_MOBILE_REPORT.AccessReqHead;
import NS_NEW_MOBILE_REPORT.AccessRspHead;
import NS_NEW_MOBILE_REPORT.Terminal;
import com.qq.taf.jce.JceStruct;
import com.tencent.beacon.event.UserAction;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

public class bmwr
  extends QzoneExternalRequest
{
  private static String jdField_a_of_type_JavaLangString = "";
  private static String b = "";
  private static String c = "";
  private AccessReqHead jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead;
  
  public bmwr(long paramLong, ArrayList<String> paramArrayList)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.needCompress = false;
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead = new AccessReqHead();
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.loginType = 1;
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.uin = paramLong;
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal = new Terminal();
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.imei = String.valueOf(a());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.macAddress = String.valueOf(c());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.androidId = String.valueOf(bgln.f());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.imsi = String.valueOf(b());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.mode = String.valueOf(bgln.i());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.manufacture = String.valueOf(bgln.h());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.qimei = String.valueOf(UserAction.getQIMEI());
    if (QLog.isColorLevel()) {
      QLog.d("YYBInstallPackageReportRequest", 1, "YYBInstallPackageReportRequest qimei=" + this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.qimei);
    }
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.uniqueId = String.valueOf(biuf.c());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.uninstallPkgList = new ArrayList();
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.uninstallPkgList.addAll(paramArrayList);
  }
  
  public static AccessRspHead a(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    do
    {
      return paramArrayOfByte;
      paramArrayOfInt = (AccessRspHead)decode(paramArrayOfByte, "NewMobileReport", paramArrayOfInt);
      paramArrayOfByte = paramArrayOfInt;
    } while (paramArrayOfInt != null);
    return null;
  }
  
  public static String a()
  {
    if ((jdField_a_of_type_JavaLangString != null) && (jdField_a_of_type_JavaLangString.length() > 0)) {
      return jdField_a_of_type_JavaLangString;
    }
    try
    {
      jdField_a_of_type_JavaLangString = bkfy.a("b94d1a");
      label27:
      return jdField_a_of_type_JavaLangString;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public static String b()
  {
    if ((b != null) && (b.length() > 0)) {
      return b;
    }
    try
    {
      b = bkfy.b("b94d1a");
      label27:
      return b;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public static String c()
  {
    if ((c != null) && (c.length() > 0)) {
      return c;
    }
    try
    {
      c = bkfy.c("b94d1a");
      label27:
      return c;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public String getCmdString()
  {
    return "MobileReport.NewMobileReport";
  }
  
  public JceStruct getReq()
  {
    return this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead;
  }
  
  public String uniKey()
  {
    return "NewMobileReport";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwr
 * JD-Core Version:    0.7.0.1
 */