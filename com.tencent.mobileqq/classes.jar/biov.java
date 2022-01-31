import android.content.Context;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class biov
{
  static biov jdField_a_of_type_Biov;
  private static String b = "GMEAVEngineWalper";
  int jdField_a_of_type_Int = 0;
  public Context a;
  public bgkw a;
  private bipg jdField_a_of_type_Bipg = new bipb(this);
  bipi jdField_a_of_type_Bipi;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new bipa(this);
  String jdField_a_of_type_JavaLangString = "";
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static biov a()
  {
    if (jdField_a_of_type_Biov == null) {
      jdField_a_of_type_Biov = new biov();
    }
    return jdField_a_of_type_Biov;
  }
  
  private void a()
  {
    bipj.a().a(this.jdField_a_of_type_Bipi, new biow(this));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bipi = new bipi(paramInt, paramString1, paramString2);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, biph.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    bipc.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Bipg);
    bipc.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new bipe();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.d = paramString4;
    paramContext.c = paramString1;
    bipc.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    a();
  }
  
  public void a(bgkw parambgkw)
  {
    this.jdField_a_of_type_Bgkw = parambgkw;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    bipc.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bipc.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new biox(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (bipc.a(this.jdField_a_of_type_AndroidContentContext).a() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Bgkw != null) {
        this.jdField_a_of_type_Bgkw.a(paramBoolean, 0);
      }
      return;
    }
    bipc.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new bioy(this));
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString, paramBoolean1, paramBoolean2);
  }
  
  public void b(boolean paramBoolean)
  {
    if (bipc.a(this.jdField_a_of_type_AndroidContentContext).b() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Bgkw != null) {
        this.jdField_a_of_type_Bgkw.b(paramBoolean, 0);
      }
      return;
    }
    bipc.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new bioz(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biov
 * JD-Core Version:    0.7.0.1
 */