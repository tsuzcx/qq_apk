import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class avws
{
  private static volatile avws jdField_a_of_type_Avws;
  private static final List<String> jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { "setFaceData", "changeSecureMobile", "deleteFace", "identify" });
  private static final List<String> b = Arrays.asList(new String[] { "loginVerify" });
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public static avws a()
  {
    if (jdField_a_of_type_Avws == null) {}
    try
    {
      if (jdField_a_of_type_Avws == null) {
        jdField_a_of_type_Avws = new avws();
      }
      return jdField_a_of_type_Avws;
    }
    finally {}
  }
  
  public avxa a()
  {
    if ((this.jdField_a_of_type_Int == 11) || (this.jdField_a_of_type_Int == 0)) {
      return new avxr();
    }
    if (this.jdField_a_of_type_Int == 10)
    {
      this.jdField_a_of_type_JavaLangString = "根据当地法规，人脸识别功能无法启用";
      return new avxq(this.jdField_a_of_type_JavaLangString);
    }
    QLog.d("FaceContext", 1, new Object[] { "unknown usable state : ", Integer.valueOf(this.jdField_a_of_type_Int) });
    return null;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, ayxn paramayxn)
  {
    QLog.d("FaceContext", 1, "start refreshIpStateOnSubProcess");
    Bundle localBundle = new Bundle();
    localBundle.putString("method", paramString2);
    localBundle.putInt("srcAppId", paramInt);
    localBundle.putString("uin", paramString1);
    QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_face_usable", localBundle, new avwu(this, paramayxn));
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, ayxn paramayxn)
  {
    a(paramQQAppInterface, paramContext, paramInt, paramString, null, paramayxn);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, ayxn paramayxn)
  {
    paramContext = new avwt(this, paramayxn);
    QLog.d("FaceContext", 1, "start refreshIpState");
    if (jdField_a_of_type_JavaUtilList.contains(paramString1)) {
      bcvd.a(paramQQAppInterface, paramInt, paramContext);
    }
    while (!b.contains(paramString1)) {
      return;
    }
    paramString1 = dp.a(false);
    paramQQAppInterface = new byte[0];
    if (beus.a(paramString1))
    {
      paramQQAppInterface = beus.a(paramString1);
      QLog.d("FaceContext", 1, "v4");
    }
    for (;;)
    {
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(paramString2);
        l1 = l2;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QLog.d("FaceContext", 1, new Object[] { "parse uin error, ", paramString1.getMessage() });
        }
      }
      bcvd.a(paramInt, paramQQAppInterface, l1, paramContext);
      return;
      if (beus.b(paramString1))
      {
        paramQQAppInterface = beus.b(paramString1);
        QLog.e("FaceContext", 1, "v6");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avws
 * JD-Core Version:    0.7.0.1
 */