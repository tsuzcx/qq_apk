import android.content.Context;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class bgjq
{
  static bgjq jdField_a_of_type_Bgjq;
  private static String b = "GMEAVEngineWalper";
  int jdField_a_of_type_Int = 0;
  public Context a;
  public begr a;
  private bgkb jdField_a_of_type_Bgkb = new bgjw(this);
  bgkd jdField_a_of_type_Bgkd;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new bgjv(this);
  String jdField_a_of_type_JavaLangString = "";
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public static bgjq a()
  {
    if (jdField_a_of_type_Bgjq == null) {
      jdField_a_of_type_Bgjq = new bgjq();
    }
    return jdField_a_of_type_Bgjq;
  }
  
  private void a()
  {
    bgke.a().a(this.jdField_a_of_type_Bgkd, new bgjr(this));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bgkd = new bgkd(paramInt, paramString1, paramString2);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, bgkc.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    bgjx.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Bgkb);
    bgjx.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new bgjz();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.d = paramString4;
    paramContext.c = paramString1;
    bgjx.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    a();
  }
  
  public void a(begr parambegr)
  {
    this.jdField_a_of_type_Begr = parambegr;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    bgjx.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bgjx.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new bgjs(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (bgjx.a(this.jdField_a_of_type_AndroidContentContext).a() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Begr != null) {
        this.jdField_a_of_type_Begr.a(paramBoolean, 0);
      }
      return;
    }
    bgjx.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new bgjt(this));
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString, paramBoolean1, paramBoolean2);
  }
  
  public void b(boolean paramBoolean)
  {
    if (bgjx.a(this.jdField_a_of_type_AndroidContentContext).b() == paramBoolean)
    {
      QLog.d("AVEngineWalper", 1, "StartOpenSpeaker.OnComplete. bOpen = " + paramBoolean + ", result = " + 0);
      if (this.jdField_a_of_type_Begr != null) {
        this.jdField_a_of_type_Begr.b(paramBoolean, 0);
      }
      return;
    }
    bgjx.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new bgju(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgjq
 * JD-Core Version:    0.7.0.1
 */