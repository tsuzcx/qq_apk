import android.os.Bundle;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ande
{
  private final int jdField_a_of_type_Int;
  private andf jdField_a_of_type_Andf;
  private andi jdField_a_of_type_Andi;
  private andj jdField_a_of_type_Andj;
  private andn jdField_a_of_type_Andn;
  private ando jdField_a_of_type_Ando;
  private andp jdField_a_of_type_Andp;
  private boolean jdField_a_of_type_Boolean;
  
  public ande(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteScriptManager", 2, "SpriteDrawerInfoManager constructor.");
    }
    this.jdField_a_of_type_Andi = new andi();
    this.jdField_a_of_type_Andi.a(paramString);
    this.jdField_a_of_type_Andn = new andn(this.jdField_a_of_type_Andi);
    this.jdField_a_of_type_Andp = new andp(this.jdField_a_of_type_Andi, this.jdField_a_of_type_Andn, this);
    this.jdField_a_of_type_Ando = new ando(this.jdField_a_of_type_Andi);
    this.jdField_a_of_type_Andj = new andj(this.jdField_a_of_type_Andi, this.jdField_a_of_type_Andn, this.jdField_a_of_type_Ando, this.jdField_a_of_type_Andp);
    this.jdField_a_of_type_Andi.a(this.jdField_a_of_type_Ando);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public andf a()
  {
    return this.jdField_a_of_type_Andf;
  }
  
  public andi a()
  {
    return this.jdField_a_of_type_Andi;
  }
  
  public ando a()
  {
    return this.jdField_a_of_type_Ando;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Andf != null) {
      this.jdField_a_of_type_Andf.a(1);
    }
    this.jdField_a_of_type_Andi.a(-1);
  }
  
  public void a(int paramInt)
  {
    QLog.i("CmShow_SpriteScriptManager", 1, "[onSurfaceReady], spriteFrom:" + paramInt);
    if ((this.jdField_a_of_type_Andi == null) || (this.jdField_a_of_type_Andj == null) || (this.jdField_a_of_type_Andp == null)) {
      return;
    }
    this.jdField_a_of_type_Andi.a(0, 0);
    this.jdField_a_of_type_Andi.b(true);
    paramInt = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Andi.b(paramInt);
    this.jdField_a_of_type_Andp.a();
    this.jdField_a_of_type_Andi.a(true);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Andf = ((andf)this.jdField_a_of_type_Andp.a(100));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Andj.a(paramInt1, paramInt2);
  }
  
  public void a(ampv paramampv)
  {
    if (paramampv == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Andi.a(paramampv);
      localApolloCmdChannel = ApolloUtil.a();
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramampv);
  }
  
  public void a(anda paramanda)
  {
    this.jdField_a_of_type_Andn.a(paramanda);
  }
  
  public void a(CmShowRenderView.PlayActionConfig paramPlayActionConfig)
  {
    this.jdField_a_of_type_Andj.a(this.jdField_a_of_type_Andi, paramPlayActionConfig);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Andj.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Andj.a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Andj.a(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Andj != null) {
      this.jdField_a_of_type_Andj.a(this.jdField_a_of_type_Andi, paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, float paramFloat, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Andi.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Andi.b = paramString1;
    this.jdField_a_of_type_Andi.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_Andn != null) {
      this.jdField_a_of_type_Andj.a(this.jdField_a_of_type_Andi, paramInt, this.jdField_a_of_type_Andn.a, paramBundle);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Andj.a(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Andj.a(paramString, paramBoolean);
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Andj.a(paramList, paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Andf != null) {
      this.jdField_a_of_type_Andf.a(2);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ando != null) {
      this.jdField_a_of_type_Ando.a();
    }
    Object localObject = this.jdField_a_of_type_Andi.a();
    if (localObject != null)
    {
      localObject = ((ampv)localObject).getRenderImpl();
      if (localObject != null) {
        ((amnw)localObject).c();
      }
    }
    this.jdField_a_of_type_Andn.a();
    this.jdField_a_of_type_Andp.b();
    this.jdField_a_of_type_Andi.c();
    this.jdField_a_of_type_Andj.a();
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ande
 * JD-Core Version:    0.7.0.1
 */