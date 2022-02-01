import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

public class avep
{
  private static volatile avep jdField_a_of_type_Avep;
  private static final List<String> jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { "setFaceData", "changeSecureMobile", "deleteFace", "identify" });
  private static final List<String> b = Arrays.asList(new String[] { "loginVerify" });
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public static avep a()
  {
    if (jdField_a_of_type_Avep == null) {}
    try
    {
      if (jdField_a_of_type_Avep == null) {
        jdField_a_of_type_Avep = new avep();
      }
      return jdField_a_of_type_Avep;
    }
    finally {}
  }
  
  public avex a()
  {
    if ((this.jdField_a_of_type_Int == 11) || (this.jdField_a_of_type_Int == 0)) {
      return new avfo();
    }
    if (this.jdField_a_of_type_Int == 10)
    {
      this.jdField_a_of_type_JavaLangString = "根据当地法规，人脸识别功能无法启用";
      return new avfn(this.jdField_a_of_type_JavaLangString);
    }
    QLog.d("FaceContext", 1, new Object[] { "unknown usable state : ", Integer.valueOf(this.jdField_a_of_type_Int) });
    return null;
  }
  
  public void a(int paramInt, String paramString1, String paramString2, ayeu paramayeu)
  {
    QLog.d("FaceContext", 1, "start refreshIpStateOnSubProcess");
    Bundle localBundle = new Bundle();
    localBundle.putString("method", paramString2);
    localBundle.putInt("srcAppId", paramInt);
    localBundle.putString("uin", paramString1);
    QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_face_usable", localBundle, new aver(this, paramayeu));
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, ayeu paramayeu)
  {
    a(paramQQAppInterface, paramContext, paramInt, paramString, null, paramayeu);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, ayeu paramayeu)
  {
    paramContext = new aveq(this, paramayeu);
    QLog.d("FaceContext", 1, "start refreshIpState");
    if (jdField_a_of_type_JavaUtilList.contains(paramString1)) {
      bccl.a(paramQQAppInterface, paramInt, paramContext);
    }
    while (!b.contains(paramString1)) {
      return;
    }
    paramString1 = dp.a(false);
    paramQQAppInterface = new byte[0];
    if (bdvy.a(paramString1))
    {
      paramQQAppInterface = bdvy.a(paramString1);
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
      bccl.a(paramInt, paramQQAppInterface, l1, paramContext);
      return;
      if (bdvy.b(paramString1))
      {
        paramQQAppInterface = bdvy.b(paramString1);
        QLog.e("FaceContext", 1, "v6");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avep
 * JD-Core Version:    0.7.0.1
 */