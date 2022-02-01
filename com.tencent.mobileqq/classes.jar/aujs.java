import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class aujs
{
  private static volatile aujs jdField_a_of_type_Aujs;
  public static final List<String> a;
  public static final List<String> b = Arrays.asList(new String[] { "setFaceData", "changeSecureMobile", "deleteFace", "identify" });
  public static final List<String> c = Arrays.asList(new String[] { "loginVerify", "identifyNoLogin" });
  public static final List<String> d = Arrays.asList(new String[] { "loginVerify", "changeSecureMobile" });
  public static final List<String> e = Arrays.asList(new String[] { "identify", "identifyNoLogin" });
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { "loginVerify", "identify", "changeSecureMobile", "identifyNoLogin" });
  }
  
  public static aujs a()
  {
    if (jdField_a_of_type_Aujs == null) {}
    try
    {
      if (jdField_a_of_type_Aujs == null) {
        jdField_a_of_type_Aujs = new aujs();
      }
      return jdField_a_of_type_Aujs;
    }
    finally {}
  }
  
  public auka a()
  {
    if ((this.jdField_a_of_type_Int == 11) || (this.jdField_a_of_type_Int == 0)) {
      return new aukr();
    }
    if (this.jdField_a_of_type_Int == 10)
    {
      this.jdField_a_of_type_JavaLangString = "根据当地法规，人脸识别功能无法启用";
      return new aukq(this.jdField_a_of_type_JavaLangString);
    }
    QLog.d("FaceContext", 1, new Object[] { "unknown usable state : ", Integer.valueOf(this.jdField_a_of_type_Int) });
    return null;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, axkv paramaxkv)
  {
    QLog.d("FaceContext", 1, "start refreshIpStateOnSubProcess");
    Bundle localBundle = new Bundle();
    localBundle.putString("method", paramString2);
    localBundle.putInt("srcAppId", paramInt);
    localBundle.putString("uin", paramString1);
    QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_face_usable", localBundle, new auju(this, paramaxkv));
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, axkv paramaxkv)
  {
    a(paramQQAppInterface, paramContext, paramInt, paramString, null, paramaxkv);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, axkv paramaxkv)
  {
    paramContext = new aujt(this, paramaxkv);
    QLog.d("FaceContext", 1, "start refreshIpState");
    if (b.contains(paramString1)) {
      bbon.a(paramQQAppInterface, paramInt, paramContext);
    }
    while (!c.contains(paramString1)) {
      return;
    }
    paramString1 = dp.a(false);
    paramQQAppInterface = new byte[0];
    long l1;
    if (IPAddressUtil.isIPv4LiteralAddress(paramString1))
    {
      paramQQAppInterface = IPAddressUtil.textToNumericFormatV4(paramString1);
      QLog.d("FaceContext", 1, "v4");
      l1 = 0L;
      if (paramString2 != null) {
        break label129;
      }
      l1 = 0L;
    }
    for (;;)
    {
      bbon.a(paramInt, paramQQAppInterface, l1, paramContext);
      return;
      if (!IPAddressUtil.isIPv6LiteralAddress(paramString1)) {
        break;
      }
      paramQQAppInterface = IPAddressUtil.textToNumericFormatV6(paramString1);
      QLog.e("FaceContext", 1, "v6");
      break;
      try
      {
        label129:
        long l2 = Long.parseLong(paramString2);
        l1 = l2;
      }
      catch (Exception paramString1)
      {
        QLog.d("FaceContext", 1, new Object[] { "parse uin error, ", paramString1.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujs
 * JD-Core Version:    0.7.0.1
 */