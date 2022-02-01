import android.content.Context;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class bkhk
{
  static bkhk jdField_a_of_type_Bkhk;
  private static String b = "GMEAVEngineWalper";
  int jdField_a_of_type_Int = 0;
  public Context a;
  public biyn a;
  private bkhv jdField_a_of_type_Bkhv = new bkhq(this);
  bkhx jdField_a_of_type_Bkhx;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new bkhp(this);
  String jdField_a_of_type_JavaLangString = "";
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static bkhk a()
  {
    if (jdField_a_of_type_Bkhk == null) {
      jdField_a_of_type_Bkhk = new bkhk();
    }
    return jdField_a_of_type_Bkhk;
  }
  
  private void a()
  {
    bkhy.a().a(this.jdField_a_of_type_Bkhx, new bkhl(this));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bkhx = new bkhx(paramInt, paramString1, paramString2);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, bkhw.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    bkhr.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Bkhv);
    bkhr.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new bkht();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.d = paramString4;
    paramContext.c = paramString1;
    bkhr.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    a();
  }
  
  public void a(biyn parambiyn)
  {
    this.jdField_a_of_type_Biyn = parambiyn;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    bkhr.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bkhr.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new bkhm(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (bkhr.a(this.jdField_a_of_type_AndroidContentContext).a() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Biyn != null) {
        this.jdField_a_of_type_Biyn.a(paramBoolean, 0);
      }
      return;
    }
    bkhr.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new bkhn(this));
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString, paramBoolean1, paramBoolean2);
  }
  
  public void b(boolean paramBoolean)
  {
    if (bkhr.a(this.jdField_a_of_type_AndroidContentContext).b() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Biyn != null) {
        this.jdField_a_of_type_Biyn.b(paramBoolean, 0);
      }
      return;
    }
    bkhr.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new bkho(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkhk
 * JD-Core Version:    0.7.0.1
 */