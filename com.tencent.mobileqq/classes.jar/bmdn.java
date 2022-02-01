import android.content.Context;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class bmdn
{
  static bmdn jdField_a_of_type_Bmdn;
  private static String b = "GMEAVEngineWalper";
  int jdField_a_of_type_Int = 0;
  public Context a;
  public bkti a;
  private bmdy jdField_a_of_type_Bmdy = new bmdt(this);
  bmea jdField_a_of_type_Bmea;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new bmds(this);
  String jdField_a_of_type_JavaLangString = "";
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static bmdn a()
  {
    if (jdField_a_of_type_Bmdn == null) {
      jdField_a_of_type_Bmdn = new bmdn();
    }
    return jdField_a_of_type_Bmdn;
  }
  
  private void a()
  {
    bmeb.a().a(this.jdField_a_of_type_Bmea, new bmdo(this));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bmea = new bmea(paramInt, paramString1, paramString2);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, bmdz.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    bmdu.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Bmdy);
    bmdu.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new bmdw();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.d = paramString4;
    paramContext.c = paramString1;
    bmdu.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    a();
  }
  
  public void a(bkti parambkti)
  {
    this.jdField_a_of_type_Bkti = parambkti;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    bmdu.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bmdu.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new bmdp(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (bmdu.a(this.jdField_a_of_type_AndroidContentContext).a() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Bkti != null) {
        this.jdField_a_of_type_Bkti.a(paramBoolean, 0);
      }
      return;
    }
    bmdu.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new bmdq(this));
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString, paramBoolean1, paramBoolean2);
  }
  
  public void b(boolean paramBoolean)
  {
    if (bmdu.a(this.jdField_a_of_type_AndroidContentContext).b() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Bkti != null) {
        this.jdField_a_of_type_Bkti.b(paramBoolean, 0);
      }
      return;
    }
    bmdu.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new bmdr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdn
 * JD-Core Version:    0.7.0.1
 */