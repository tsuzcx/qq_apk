import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.danmaku.core.DanmakuManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aqwe
  implements arty
{
  private static final arva jdField_a_of_type_Arva = new aqwf();
  private static final String jdField_a_of_type_JavaLangString = aqwe.class.getSimpleName();
  private aqwh jdField_a_of_type_Aqwh;
  private aqwi jdField_a_of_type_Aqwi;
  private arvb jdField_a_of_type_Arvb;
  private DanmakuManager jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager;
  
  public aruc a(aqwj paramaqwj)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) && (paramaqwj != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(-2147483647, paramaqwj);
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
    if (this.jdField_a_of_type_Arvb != null)
    {
      this.jdField_a_of_type_Arvb.b(paramInt);
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
    this.jdField_a_of_type_Arvb = arul.a();
    this.jdField_a_of_type_Arvb.a(3);
    this.jdField_a_of_type_Arvb.c(7000);
    this.jdField_a_of_type_Arvb.f(8.0F);
    this.jdField_a_of_type_Arvb.c(12.0F);
    this.jdField_a_of_type_Arvb.b(12.0F);
    this.jdField_a_of_type_Arvb.b(false);
    this.jdField_a_of_type_Arvb.d(true);
    arun localarun = arul.a();
    localarun.a(new aqwg(this));
    localarun.a(-4);
    localarun.a(new aqwk(paramContext));
    paramContext = localarun.a();
    aruz.a(jdField_a_of_type_Arva);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager = new DanmakuManager(paramView, paramContext);
  }
  
  public void a(aqwh paramaqwh)
  {
    this.jdField_a_of_type_Aqwh = paramaqwh;
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(this);
    }
  }
  
  public void a(aqwi paramaqwi)
  {
    this.jdField_a_of_type_Aqwi = paramaqwi;
  }
  
  public void a(aruc paramaruc, arvz paramarvz, arvp paramarvp) {}
  
  public void a(DanmuItemBean paramDanmuItemBean)
  {
    if ((paramDanmuItemBean != null) && (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null))
    {
      paramDanmuItemBean = new aqwj(paramDanmuItemBean);
      paramDanmuItemBean = this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(-2147483647, paramDanmuItemBean);
      paramDanmuItemBean.e(true);
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(paramDanmuItemBean);
    }
  }
  
  public void a(List<aruc> paramList)
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
  
  public void b(List<aruc> paramList)
  {
    if ((this.jdField_a_of_type_Aqwh != null) && (!b())) {
      this.jdField_a_of_type_Aqwh.b();
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
    if (this.jdField_a_of_type_Aqwh != null) {
      this.jdField_a_of_type_Aqwh.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqwe
 * JD-Core Version:    0.7.0.1
 */