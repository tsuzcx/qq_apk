import android.content.Context;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class biko
{
  static biko jdField_a_of_type_Biko;
  private static String b = "GMEAVEngineWalper";
  int jdField_a_of_type_Int = 0;
  public Context a;
  public bggp a;
  private bikz jdField_a_of_type_Bikz = new biku(this);
  bilb jdField_a_of_type_Bilb;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new bikt(this);
  String jdField_a_of_type_JavaLangString = "";
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static biko a()
  {
    if (jdField_a_of_type_Biko == null) {
      jdField_a_of_type_Biko = new biko();
    }
    return jdField_a_of_type_Biko;
  }
  
  private void a()
  {
    bilc.a().a(this.jdField_a_of_type_Bilb, new bikp(this));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bilb = new bilb(paramInt, paramString1, paramString2);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, bila.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    bikv.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Bikz);
    bikv.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new bikx();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.d = paramString4;
    paramContext.c = paramString1;
    bikv.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    a();
  }
  
  public void a(bggp parambggp)
  {
    this.jdField_a_of_type_Bggp = parambggp;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    bikv.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bikv.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new bikq(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (bikv.a(this.jdField_a_of_type_AndroidContentContext).a() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Bggp != null) {
        this.jdField_a_of_type_Bggp.a(paramBoolean, 0);
      }
      return;
    }
    bikv.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new bikr(this));
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString, paramBoolean1, paramBoolean2);
  }
  
  public void b(boolean paramBoolean)
  {
    if (bikv.a(this.jdField_a_of_type_AndroidContentContext).b() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Bggp != null) {
        this.jdField_a_of_type_Bggp.b(paramBoolean, 0);
      }
      return;
    }
    bikv.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new biks(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biko
 * JD-Core Version:    0.7.0.1
 */