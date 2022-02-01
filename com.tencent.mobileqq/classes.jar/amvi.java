import android.os.Bundle;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class amvi
{
  private final int jdField_a_of_type_Int;
  private amvj jdField_a_of_type_Amvj;
  private amvm jdField_a_of_type_Amvm;
  private amvn jdField_a_of_type_Amvn;
  private amvr jdField_a_of_type_Amvr;
  private amvs jdField_a_of_type_Amvs;
  private amvt jdField_a_of_type_Amvt;
  private boolean jdField_a_of_type_Boolean;
  
  public amvi(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteScriptManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Amvm = new amvm();
    this.jdField_a_of_type_Amvm.a(paramString);
    this.jdField_a_of_type_Amvr = new amvr(this.jdField_a_of_type_Amvm);
    this.jdField_a_of_type_Amvt = new amvt(this.jdField_a_of_type_Amvm, this.jdField_a_of_type_Amvr, this);
    this.jdField_a_of_type_Amvs = new amvs(this.jdField_a_of_type_Amvm);
    this.jdField_a_of_type_Amvn = new amvn(this.jdField_a_of_type_Amvm, this.jdField_a_of_type_Amvr, this.jdField_a_of_type_Amvs, this.jdField_a_of_type_Amvt);
    this.jdField_a_of_type_Amvm.a(this.jdField_a_of_type_Amvs);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public amvj a()
  {
    return this.jdField_a_of_type_Amvj;
  }
  
  public amvm a()
  {
    return this.jdField_a_of_type_Amvm;
  }
  
  public amvs a()
  {
    return this.jdField_a_of_type_Amvs;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Amvj != null) {
      this.jdField_a_of_type_Amvj.a(1);
    }
    this.jdField_a_of_type_Amvm.a(-1);
  }
  
  public void a(int paramInt)
  {
    QLog.i("CmShow_SpriteScriptManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Amvm == null) || (this.jdField_a_of_type_Amvn == null) || (this.jdField_a_of_type_Amvt == null)) {
      return;
    }
    this.jdField_a_of_type_Amvm.a(0, 0);
    this.jdField_a_of_type_Amvm.b(true);
    paramInt = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Amvm.b(paramInt);
    this.jdField_a_of_type_Amvt.a();
    this.jdField_a_of_type_Amvm.a(true);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Amvj = ((amvj)this.jdField_a_of_type_Amvt.a(100));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Amvn.a(paramInt1, paramInt2);
  }
  
  public void a(amkg paramamkg)
  {
    if (paramamkg == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Amvm.a(paramamkg);
      localApolloCmdChannel = ApolloUtil.a();
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramamkg);
  }
  
  public void a(amve paramamve)
  {
    this.jdField_a_of_type_Amvr.a(paramamve);
  }
  
  public void a(CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    this.jdField_a_of_type_Amvn.a(this.jdField_a_of_type_Amvm, paramPlayActionConfig);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Amvn.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Amvn.a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Amvn.a(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Amvn != null) {
      this.jdField_a_of_type_Amvn.a(this.jdField_a_of_type_Amvm, paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, float paramFloat, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Amvm.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Amvm.b = paramString1;
    this.jdField_a_of_type_Amvm.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_Amvr != null) {
      this.jdField_a_of_type_Amvn.a(this.jdField_a_of_type_Amvm, paramInt, this.jdField_a_of_type_Amvr.a, paramBundle);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Amvn.a(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Amvn.a(paramString, paramBoolean);
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Amvn.a(paramList, paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Amvj != null) {
      this.jdField_a_of_type_Amvj.a(2);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Amvs != null) {
      this.jdField_a_of_type_Amvs.a();
    }
    Object localObject = this.jdField_a_of_type_Amvm.a();
    if (localObject != null)
    {
      localObject = ((amkg)localObject).getRenderImpl();
      if (localObject != null) {
        ((amir)localObject).c();
      }
    }
    this.jdField_a_of_type_Amvr.a();
    this.jdField_a_of_type_Amvt.b();
    this.jdField_a_of_type_Amvm.c();
    this.jdField_a_of_type_Amvn.a();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvi
 * JD-Core Version:    0.7.0.1
 */