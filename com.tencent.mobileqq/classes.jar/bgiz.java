import android.content.Context;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class bgiz
{
  static bgiz jdField_a_of_type_Bgiz;
  private static String b = "GMEAVEngineWalper";
  int jdField_a_of_type_Int = 0;
  public Context a;
  public bega a;
  private bgjk jdField_a_of_type_Bgjk = new bgjf(this);
  bgjm jdField_a_of_type_Bgjm;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new bgje(this);
  String jdField_a_of_type_JavaLangString = "";
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static bgiz a()
  {
    if (jdField_a_of_type_Bgiz == null) {
      jdField_a_of_type_Bgiz = new bgiz();
    }
    return jdField_a_of_type_Bgiz;
  }
  
  private void a()
  {
    bgjn.a().a(this.jdField_a_of_type_Bgjm, new bgja(this));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bgjm = new bgjm(paramInt, paramString1, paramString2);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, bgjl.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    bgjg.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Bgjk);
    bgjg.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new bgji();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.d = paramString4;
    paramContext.c = paramString1;
    bgjg.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    a();
  }
  
  public void a(bega parambega)
  {
    this.jdField_a_of_type_Bega = parambega;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    bgjg.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bgjg.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new bgjb(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (bgjg.a(this.jdField_a_of_type_AndroidContentContext).a() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Bega != null) {
        this.jdField_a_of_type_Bega.a(paramBoolean, 0);
      }
      return;
    }
    bgjg.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new bgjc(this));
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString, paramBoolean1, paramBoolean2);
  }
  
  public void b(boolean paramBoolean)
  {
    if (bgjg.a(this.jdField_a_of_type_AndroidContentContext).b() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Bega != null) {
        this.jdField_a_of_type_Bega.b(paramBoolean, 0);
      }
      return;
    }
    bgjg.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new bgjd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgiz
 * JD-Core Version:    0.7.0.1
 */