import android.content.Context;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class bfbi
{
  static bfbi jdField_a_of_type_Bfbi;
  private static String b = "GMEAVEngineWalper";
  int jdField_a_of_type_Int = 0;
  public Context a;
  public bdby a;
  private bfbt jdField_a_of_type_Bfbt = new bfbo(this);
  bfbv jdField_a_of_type_Bfbv;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new bfbn(this);
  String jdField_a_of_type_JavaLangString = "";
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static bfbi a()
  {
    if (jdField_a_of_type_Bfbi == null) {
      jdField_a_of_type_Bfbi = new bfbi();
    }
    return jdField_a_of_type_Bfbi;
  }
  
  private void a()
  {
    bfbw.a().a(this.jdField_a_of_type_Bfbv, new bfbj(this));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bfbv = new bfbv(paramInt, paramString1, paramString2);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, bfbu.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    bfbp.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Bfbt);
    bfbp.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new bfbr();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.d = paramString4;
    paramContext.c = paramString1;
    bfbp.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    a();
  }
  
  public void a(bdby parambdby)
  {
    this.jdField_a_of_type_Bdby = parambdby;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    bfbp.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bfbp.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new bfbk(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (bfbp.a(this.jdField_a_of_type_AndroidContentContext).a() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Bdby != null) {
        this.jdField_a_of_type_Bdby.a(paramBoolean, 0);
      }
      return;
    }
    bfbp.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new bfbl(this));
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString, paramBoolean1, paramBoolean2);
  }
  
  public void b(boolean paramBoolean)
  {
    if (bfbp.a(this.jdField_a_of_type_AndroidContentContext).b() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Bdby != null) {
        this.jdField_a_of_type_Bdby.b(paramBoolean, 0);
      }
      return;
    }
    bfbp.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new bfbm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfbi
 * JD-Core Version:    0.7.0.1
 */