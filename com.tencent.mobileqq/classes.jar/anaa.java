import android.content.Context;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class anaa
{
  static anaa jdField_a_of_type_Anaa;
  int jdField_a_of_type_Int = 0;
  private anam jdField_a_of_type_Anam = new anah(this);
  anaq jdField_a_of_type_Anaq;
  public Context a;
  public bjsi a;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new anag(this);
  public String a;
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  private anaa()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static anaa a()
  {
    if (jdField_a_of_type_Anaa == null) {
      jdField_a_of_type_Anaa = new anaa();
    }
    return jdField_a_of_type_Anaa;
  }
  
  private void d()
  {
    anar.a().a(this.jdField_a_of_type_Anaq, new anab(this));
  }
  
  public void a()
  {
    QLog.i("AVEngineWalper", 1, "DestroyEngine()");
    anai.a(this.jdField_a_of_type_AndroidContentContext).a();
    anai.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Anaq = new anaq(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    anai.a(this.jdField_a_of_type_AndroidContentContext).a(paramLong);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, anap.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    anai.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Anam);
    anai.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new anak();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.c = paramString1;
    anai.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    d();
  }
  
  public void a(bjsi parambjsi)
  {
    this.jdField_a_of_type_Bjsi = parambjsi;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    anai.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    anai.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new anac(this));
  }
  
  public void a(boolean paramBoolean)
  {
    anai.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new anae(this));
  }
  
  boolean a()
  {
    try
    {
      GraphicRendererMgr localGraphicRendererMgr = GraphicRendererMgr.getInstance();
      int i = localGraphicRendererMgr.getRecvDecoderFrameFunctionptr();
      QLog.e("AVEngineWalper", 1, "mgr=" + String.valueOf(localGraphicRendererMgr) + ", nFunID=" + String.valueOf(i));
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AVEngineWalper", 1, "CheckGraphicMgrStart stack=" + QLog.getStackTraceString(localThrowable));
    }
    return false;
  }
  
  public void b()
  {
    anai.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void b(long paramLong)
  {
    anai.a(this.jdField_a_of_type_AndroidContentContext).b(paramLong);
  }
  
  public void b(String paramString)
  {
    anai.a(this.jdField_a_of_type_AndroidContentContext).a(paramString);
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bjsj.a().a(Integer.valueOf(this.jdField_a_of_type_JavaLangString).intValue(), new anad(this, paramString, paramBoolean1, paramBoolean2));
  }
  
  public void b(boolean paramBoolean)
  {
    anai.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new anaf(this));
  }
  
  public void c()
  {
    anai.a(this.jdField_a_of_type_AndroidContentContext).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anaa
 * JD-Core Version:    0.7.0.1
 */