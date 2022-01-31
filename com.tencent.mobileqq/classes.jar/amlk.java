import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.danmaku.core.DanmakuManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class amlk
  implements anfw
{
  private static final angy jdField_a_of_type_Angy = new amll();
  private static final String jdField_a_of_type_JavaLangString = amlk.class.getSimpleName();
  private amln jdField_a_of_type_Amln;
  private amlo jdField_a_of_type_Amlo;
  private angz jdField_a_of_type_Angz;
  private DanmakuManager jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager;
  
  public anga a(amlp paramamlp)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) && (paramamlp != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(-2147483647, paramamlp);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Angz != null)
    {
      this.jdField_a_of_type_Angz.b(paramInt);
      if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.h();
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.b(paramLong);
    }
  }
  
  public void a(amln paramamln)
  {
    this.jdField_a_of_type_Amln = paramamln;
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(this);
    }
  }
  
  public void a(amlo paramamlo)
  {
    this.jdField_a_of_type_Amlo = paramamlo;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_Angz = angj.a();
    this.jdField_a_of_type_Angz.a(3);
    this.jdField_a_of_type_Angz.c(7000);
    this.jdField_a_of_type_Angz.f(8.0F);
    this.jdField_a_of_type_Angz.c(12.0F);
    this.jdField_a_of_type_Angz.b(12.0F);
    this.jdField_a_of_type_Angz.b(false);
    this.jdField_a_of_type_Angz.d(true);
    angl localangl = angj.a();
    localangl.a(new amlm(this));
    localangl.a(-4);
    localangl.a(new amlq(paramContext));
    paramContext = localangl.a();
    angx.a(jdField_a_of_type_Angy);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager = new DanmakuManager(paramView, paramContext);
  }
  
  public void a(anga paramanga, anhx paramanhx, anhn paramanhn) {}
  
  public void a(DanmuItemBean paramDanmuItemBean)
  {
    if ((paramDanmuItemBean != null) && (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null))
    {
      paramDanmuItemBean = new amlp(paramDanmuItemBean);
      paramDanmuItemBean = this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(-2147483647, paramDanmuItemBean);
      paramDanmuItemBean.e(true);
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(paramDanmuItemBean);
    }
  }
  
  public void a(List<anga> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "addDanmakuList danmakuList is null");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(paramList);
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) && (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.d());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.g();
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.l();
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager = null;
    }
  }
  
  public void b(List<anga> paramList)
  {
    if ((this.jdField_a_of_type_Amln != null) && (!b())) {
      this.jdField_a_of_type_Amln.b();
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) && (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a());
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.d();
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.e();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.c();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.b();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Amln != null) {
      this.jdField_a_of_type_Amln.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amlk
 * JD-Core Version:    0.7.0.1
 */