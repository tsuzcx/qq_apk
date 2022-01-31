import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.danmaku.core.DanmakuManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aoci
  implements aoxd
{
  private static final aoyf jdField_a_of_type_Aoyf = new aocj();
  private static final String jdField_a_of_type_JavaLangString = aoci.class.getSimpleName();
  private aocl jdField_a_of_type_Aocl;
  private aocm jdField_a_of_type_Aocm;
  private aoyg jdField_a_of_type_Aoyg;
  private DanmakuManager jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager;
  
  public aoxh a(aocn paramaocn)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) && (paramaocn != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(-2147483647, paramaocn);
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
    if (this.jdField_a_of_type_Aoyg != null)
    {
      this.jdField_a_of_type_Aoyg.b(paramInt);
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
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_Aoyg = aoxq.a();
    this.jdField_a_of_type_Aoyg.a(3);
    this.jdField_a_of_type_Aoyg.c(7000);
    this.jdField_a_of_type_Aoyg.f(8.0F);
    this.jdField_a_of_type_Aoyg.c(12.0F);
    this.jdField_a_of_type_Aoyg.b(12.0F);
    this.jdField_a_of_type_Aoyg.b(false);
    this.jdField_a_of_type_Aoyg.d(true);
    aoxs localaoxs = aoxq.a();
    localaoxs.a(new aock(this));
    localaoxs.a(-4);
    localaoxs.a(new aoco(paramContext));
    paramContext = localaoxs.a();
    aoye.a(jdField_a_of_type_Aoyf);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager = new DanmakuManager(paramView, paramContext);
  }
  
  public void a(aocl paramaocl)
  {
    this.jdField_a_of_type_Aocl = paramaocl;
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(this);
    }
  }
  
  public void a(aocm paramaocm)
  {
    this.jdField_a_of_type_Aocm = paramaocm;
  }
  
  public void a(aoxh paramaoxh, aoze paramaoze, aoyu paramaoyu) {}
  
  public void a(DanmuItemBean paramDanmuItemBean)
  {
    if ((paramDanmuItemBean != null) && (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null))
    {
      paramDanmuItemBean = new aocn(paramDanmuItemBean);
      paramDanmuItemBean = this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(-2147483647, paramDanmuItemBean);
      paramDanmuItemBean.e(true);
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(paramDanmuItemBean);
    }
  }
  
  public void a(List<aoxh> paramList)
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
  
  public void b(List<aoxh> paramList)
  {
    if ((this.jdField_a_of_type_Aocl != null) && (!b())) {
      this.jdField_a_of_type_Aocl.b();
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
    if (this.jdField_a_of_type_Aocl != null) {
      this.jdField_a_of_type_Aocl.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoci
 * JD-Core Version:    0.7.0.1
 */