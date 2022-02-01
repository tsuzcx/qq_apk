import android.content.Context;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class amgo
{
  static amgo jdField_a_of_type_Amgo;
  int jdField_a_of_type_Int = 0;
  private amha jdField_a_of_type_Amha = new amgv(this);
  amhe jdField_a_of_type_Amhe;
  public Context a;
  public biyn a;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new amgu(this);
  public String a;
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  private amgo()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static amgo a()
  {
    if (jdField_a_of_type_Amgo == null) {
      jdField_a_of_type_Amgo = new amgo();
    }
    return jdField_a_of_type_Amgo;
  }
  
  private void d()
  {
    amhf.a().a(this.jdField_a_of_type_Amhe, new amgp(this));
  }
  
  public void a()
  {
    QLog.i("AVEngineWalper", 1, "DestroyEngine()");
    amgw.a(this.jdField_a_of_type_AndroidContentContext).a();
    amgw.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Amhe = new amhe(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    amgw.a(this.jdField_a_of_type_AndroidContentContext).a(paramLong);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, amhd.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    amgw.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Amha);
    amgw.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new amgy();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.c = paramString1;
    amgw.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    d();
  }
  
  public void a(biyn parambiyn)
  {
    this.jdField_a_of_type_Biyn = parambiyn;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    amgw.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    amgw.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new amgq(this));
  }
  
  public void a(boolean paramBoolean)
  {
    amgw.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new amgs(this));
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
    amgw.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void b(long paramLong)
  {
    amgw.a(this.jdField_a_of_type_AndroidContentContext).b(paramLong);
  }
  
  public void b(String paramString)
  {
    amgw.a(this.jdField_a_of_type_AndroidContentContext).a(paramString);
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    biyo.a().a(Integer.valueOf(this.jdField_a_of_type_JavaLangString).intValue(), new amgr(this, paramString, paramBoolean1, paramBoolean2));
  }
  
  public void b(boolean paramBoolean)
  {
    amgw.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new amgt(this));
  }
  
  public void c()
  {
    amgw.a(this.jdField_a_of_type_AndroidContentContext).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amgo
 * JD-Core Version:    0.7.0.1
 */