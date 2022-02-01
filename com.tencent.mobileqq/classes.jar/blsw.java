import android.content.Context;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class blsw
{
  static blsw jdField_a_of_type_Blsw;
  private static String b = "GMEAVEngineWalper";
  int jdField_a_of_type_Int = 0;
  public Context a;
  public bkjp a;
  private blth jdField_a_of_type_Blth = new bltc(this);
  bltj jdField_a_of_type_Bltj;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new bltb(this);
  String jdField_a_of_type_JavaLangString = "";
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static blsw a()
  {
    if (jdField_a_of_type_Blsw == null) {
      jdField_a_of_type_Blsw = new blsw();
    }
    return jdField_a_of_type_Blsw;
  }
  
  private void a()
  {
    bltk.a().a(this.jdField_a_of_type_Bltj, new blsx(this));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bltj = new bltj(paramInt, paramString1, paramString2);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, blti.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    bltd.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Blth);
    bltd.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new bltf();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.d = paramString4;
    paramContext.c = paramString1;
    bltd.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    a();
  }
  
  public void a(bkjp parambkjp)
  {
    this.jdField_a_of_type_Bkjp = parambkjp;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    bltd.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bltd.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new blsy(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (bltd.a(this.jdField_a_of_type_AndroidContentContext).a() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Bkjp != null) {
        this.jdField_a_of_type_Bkjp.a(paramBoolean, 0);
      }
      return;
    }
    bltd.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new blsz(this));
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString, paramBoolean1, paramBoolean2);
  }
  
  public void b(boolean paramBoolean)
  {
    if (bltd.a(this.jdField_a_of_type_AndroidContentContext).b() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Bkjp != null) {
        this.jdField_a_of_type_Bkjp.b(paramBoolean, 0);
      }
      return;
    }
    bltd.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new blta(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blsw
 * JD-Core Version:    0.7.0.1
 */