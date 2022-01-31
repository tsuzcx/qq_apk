import NS_NEW_MOBILE_REPORT.AccessReqHead;
import NS_NEW_MOBILE_REPORT.AccessRspHead;
import NS_NEW_MOBILE_REPORT.Terminal;
import android.content.pm.PackageInfo;
import com.qq.taf.jce.JceStruct;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bibu
  extends QzoneExternalRequest
{
  private static String jdField_a_of_type_JavaLangString = "";
  private static String b = "";
  private static String c = "";
  private AccessReqHead jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead;
  
  public bibu(long paramLong)
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
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.androidId = String.valueOf(bbdh.f());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.imsi = String.valueOf(b());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.mode = String.valueOf(bbdh.i());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.manufacture = String.valueOf(bbdh.h());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.qimei = String.valueOf(UserAction.getQIMEI());
    if (QLog.isColorLevel()) {
      QLog.d("YYBInstallPackageReportRequest", 1, "YYBInstallPackageReportRequest qimei=" + this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.terminal.qimei);
    }
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.uniqueId = String.valueOf(bdjp.c());
    this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.installPkgList = new ArrayList();
    Object localObject = bdjl.a(BaseApplicationImpl.getApplication());
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject).next();
        this.jdField_a_of_type_NS_NEW_MOBILE_REPORTAccessReqHead.installPkgList.add(localPackageInfo.packageName);
      }
    }
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
      jdField_a_of_type_JavaLangString = bfnn.a("b94d1a");
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
      b = bfnn.b("b94d1a");
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
      c = bfnn.c("b94d1a");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bibu
 * JD-Core Version:    0.7.0.1
 */