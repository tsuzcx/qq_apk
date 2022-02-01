import android.content.Context;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class blck
{
  static blck jdField_a_of_type_Blck;
  private static String b = "GMEAVEngineWalper";
  int jdField_a_of_type_Int = 0;
  public Context a;
  public bjsi a;
  private blcv jdField_a_of_type_Blcv = new blcq(this);
  blcx jdField_a_of_type_Blcx;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new blcp(this);
  String jdField_a_of_type_JavaLangString = "";
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static blck a()
  {
    if (jdField_a_of_type_Blck == null) {
      jdField_a_of_type_Blck = new blck();
    }
    return jdField_a_of_type_Blck;
  }
  
  private void a()
  {
    blcy.a().a(this.jdField_a_of_type_Blcx, new blcl(this));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Blcx = new blcx(paramInt, paramString1, paramString2);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, blcw.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    blcr.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Blcv);
    blcr.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new blct();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.d = paramString4;
    paramContext.c = paramString1;
    blcr.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    a();
  }
  
  public void a(bjsi parambjsi)
  {
    this.jdField_a_of_type_Bjsi = parambjsi;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    blcr.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    blcr.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new blcm(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (blcr.a(this.jdField_a_of_type_AndroidContentContext).a() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Bjsi != null) {
        this.jdField_a_of_type_Bjsi.a(paramBoolean, 0);
      }
      return;
    }
    blcr.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new blcn(this));
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString, paramBoolean1, paramBoolean2);
  }
  
  public void b(boolean paramBoolean)
  {
    if (blcr.a(this.jdField_a_of_type_AndroidContentContext).b() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Bjsi != null) {
        this.jdField_a_of_type_Bjsi.b(paramBoolean, 0);
      }
      return;
    }
    blcr.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new blco(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blck
 * JD-Core Version:    0.7.0.1
 */