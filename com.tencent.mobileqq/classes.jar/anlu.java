import android.content.Context;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class anlu
{
  static anlu jdField_a_of_type_Anlu;
  int jdField_a_of_type_Int = 0;
  public Context a;
  private anmg jdField_a_of_type_Anmg = new anmb(this);
  anmk jdField_a_of_type_Anmk;
  public bkti a;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new anma(this);
  public String a;
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  private anlu()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static anlu a()
  {
    if (jdField_a_of_type_Anlu == null) {
      jdField_a_of_type_Anlu = new anlu();
    }
    return jdField_a_of_type_Anlu;
  }
  
  private void d()
  {
    anml.a().a(this.jdField_a_of_type_Anmk, new anlv(this));
  }
  
  public void a()
  {
    QLog.i("AVEngineWalper", 1, "DestroyEngine()");
    anmc.a(this.jdField_a_of_type_AndroidContentContext).a();
    anmc.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Anmk = new anmk(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    anmc.a(this.jdField_a_of_type_AndroidContentContext).a(paramLong);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, anmj.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    anmc.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Anmg);
    anmc.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new anme();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.c = paramString1;
    anmc.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    d();
  }
  
  public void a(bkti parambkti)
  {
    this.jdField_a_of_type_Bkti = parambkti;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    anmc.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    anmc.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new anlw(this));
  }
  
  public void a(boolean paramBoolean)
  {
    anmc.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new anly(this));
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
    anmc.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void b(long paramLong)
  {
    anmc.a(this.jdField_a_of_type_AndroidContentContext).b(paramLong);
  }
  
  public void b(String paramString)
  {
    anmc.a(this.jdField_a_of_type_AndroidContentContext).a(paramString);
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bktj.a().a(Integer.valueOf(this.jdField_a_of_type_JavaLangString).intValue(), new anlx(this, paramString, paramBoolean1, paramBoolean2));
  }
  
  public void b(boolean paramBoolean)
  {
    anmc.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new anlz(this));
  }
  
  public void c()
  {
    anmc.a(this.jdField_a_of_type_AndroidContentContext).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlu
 * JD-Core Version:    0.7.0.1
 */