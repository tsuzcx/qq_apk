import android.os.Bundle;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class anhc
{
  private final int jdField_a_of_type_Int;
  private anhd jdField_a_of_type_Anhd;
  private anhg jdField_a_of_type_Anhg;
  private anhh jdField_a_of_type_Anhh;
  private anhl jdField_a_of_type_Anhl;
  private anhm jdField_a_of_type_Anhm;
  private anhn jdField_a_of_type_Anhn;
  private boolean jdField_a_of_type_Boolean;
  
  public anhc(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteScriptManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Anhg = new anhg();
    this.jdField_a_of_type_Anhg.a(paramString);
    this.jdField_a_of_type_Anhl = new anhl(this.jdField_a_of_type_Anhg);
    this.jdField_a_of_type_Anhn = new anhn(this.jdField_a_of_type_Anhg, this.jdField_a_of_type_Anhl, this);
    this.jdField_a_of_type_Anhm = new anhm(this.jdField_a_of_type_Anhg);
    this.jdField_a_of_type_Anhh = new anhh(this.jdField_a_of_type_Anhg, this.jdField_a_of_type_Anhl, this.jdField_a_of_type_Anhm, this.jdField_a_of_type_Anhn);
    this.jdField_a_of_type_Anhg.a(this.jdField_a_of_type_Anhm);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public anhd a()
  {
    return this.jdField_a_of_type_Anhd;
  }
  
  public anhg a()
  {
    return this.jdField_a_of_type_Anhg;
  }
  
  public anhm a()
  {
    return this.jdField_a_of_type_Anhm;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Anhd != null) {
      this.jdField_a_of_type_Anhd.a(1);
    }
    this.jdField_a_of_type_Anhg.a(-1);
  }
  
  public void a(int paramInt)
  {
    QLog.i("CmShow_SpriteScriptManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Anhg == null) || (this.jdField_a_of_type_Anhh == null) || (this.jdField_a_of_type_Anhn == null)) {
      return;
    }
    this.jdField_a_of_type_Anhg.a(0, 0);
    this.jdField_a_of_type_Anhg.b(true);
    paramInt = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Anhg.b(paramInt);
    this.jdField_a_of_type_Anhn.a();
    this.jdField_a_of_type_Anhg.a(true);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Anhd = ((anhd)this.jdField_a_of_type_Anhn.a(100));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Anhh.a(paramInt1, paramInt2);
  }
  
  public void a(amwa paramamwa)
  {
    if (paramamwa == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Anhg.a(paramamwa);
      localApolloCmdChannel = ApolloUtil.a();
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramamwa);
  }
  
  public void a(angy paramangy)
  {
    this.jdField_a_of_type_Anhl.a(paramangy);
  }
  
  public void a(CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    this.jdField_a_of_type_Anhh.a(this.jdField_a_of_type_Anhg, paramPlayActionConfig);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Anhh.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Anhh.a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Anhh.a(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Anhh != null) {
      this.jdField_a_of_type_Anhh.a(this.jdField_a_of_type_Anhg, paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, float paramFloat, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Anhg.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Anhg.b = paramString1;
    this.jdField_a_of_type_Anhg.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_Anhl != null) {
      this.jdField_a_of_type_Anhh.a(this.jdField_a_of_type_Anhg, paramInt, this.jdField_a_of_type_Anhl.a, paramBundle);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Anhh.a(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Anhh.a(paramString, paramBoolean);
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Anhh.a(paramList, paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Anhd != null) {
      this.jdField_a_of_type_Anhd.a(2);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Anhm != null) {
      this.jdField_a_of_type_Anhm.a();
    }
    Object localObject = this.jdField_a_of_type_Anhg.a();
    if (localObject != null)
    {
      localObject = ((amwa)localObject).getRenderImpl();
      if (localObject != null) {
        ((amul)localObject).c();
      }
    }
    this.jdField_a_of_type_Anhl.a();
    this.jdField_a_of_type_Anhn.b();
    this.jdField_a_of_type_Anhg.c();
    this.jdField_a_of_type_Anhh.a();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhc
 * JD-Core Version:    0.7.0.1
 */