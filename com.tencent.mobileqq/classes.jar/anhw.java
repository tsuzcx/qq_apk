import android.content.Context;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class anhw
{
  static anhw jdField_a_of_type_Anhw;
  int jdField_a_of_type_Int = 0;
  public Context a;
  private anii jdField_a_of_type_Anii = new anid(this);
  anim jdField_a_of_type_Anim;
  public bkjp a;
  private AVCallback jdField_a_of_type_ComTencentTMGSdkAVCallback = new anic(this);
  public String a;
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  
  private anhw()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static anhw a()
  {
    if (jdField_a_of_type_Anhw == null) {
      jdField_a_of_type_Anhw = new anhw();
    }
    return jdField_a_of_type_Anhw;
  }
  
  private void d()
  {
    anin.a().a(this.jdField_a_of_type_Anim, new anhx(this));
  }
  
  public void a()
  {
    QLog.i("AVEngineWalper", 1, "DestroyEngine()");
    anie.a(this.jdField_a_of_type_AndroidContentContext).a();
    anie.a(this.jdField_a_of_type_AndroidContentContext).a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Anim = new anim(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    anie.a(this.jdField_a_of_type_AndroidContentContext).a(paramLong);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    QLog.e("Begin:TMGProformanceHelper", 1, anil.a());
    QLog.e("AVEngineWalper", 1, "InitSDKEngine() strAppid=" + paramString2 + ", strUin=" + paramString1 + ", strAccountType=" + paramString3);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString2;
    anie.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Anii);
    anie.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_AndroidContentContext);
    paramContext = new anig();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = paramString3;
    paramContext.c = paramString1;
    anie.a(this.jdField_a_of_type_AndroidContentContext).a(paramContext);
    d();
  }
  
  public void a(bkjp parambkjp)
  {
    this.jdField_a_of_type_Bkjp = parambkjp;
  }
  
  public void a(String paramString)
  {
    QLog.e("AVEngineWalper", 1, "ExitRoom!!!, strRoomID" + paramString);
    anie.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    anie.a(this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean1, paramBoolean2, this.jdField_a_of_type_Int, new anhy(this));
  }
  
  public void a(boolean paramBoolean)
  {
    anie.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new ania(this));
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
    anie.a(this.jdField_a_of_type_AndroidContentContext).b();
  }
  
  public void b(long paramLong)
  {
    anie.a(this.jdField_a_of_type_AndroidContentContext).b(paramLong);
  }
  
  public void b(String paramString)
  {
    anie.a(this.jdField_a_of_type_AndroidContentContext).a(paramString);
  }
  
  public void b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    bkjq.a().a(Integer.valueOf(this.jdField_a_of_type_JavaLangString).intValue(), new anhz(this, paramString, paramBoolean1, paramBoolean2));
  }
  
  public void b(boolean paramBoolean)
  {
    anie.a(this.jdField_a_of_type_AndroidContentContext).a(paramBoolean, new anib(this));
  }
  
  public void c()
  {
    anie.a(this.jdField_a_of_type_AndroidContentContext).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhw
 * JD-Core Version:    0.7.0.1
 */