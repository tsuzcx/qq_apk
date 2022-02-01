import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.danmaku.core.DanmakuManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aqsr
  implements arrh
{
  private static final arsj jdField_a_of_type_Arsj = new aqss();
  private static final String jdField_a_of_type_JavaLangString = aqsr.class.getSimpleName();
  private aqsu jdField_a_of_type_Aqsu;
  private aqsv jdField_a_of_type_Aqsv;
  private arsk jdField_a_of_type_Arsk;
  private DanmakuManager jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager;
  
  public arrl a(aqsw paramaqsw)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) && (paramaqsw != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(-2147483647, paramaqsw);
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
    if (this.jdField_a_of_type_Arsk != null)
    {
      this.jdField_a_of_type_Arsk.b(paramInt);
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
    this.jdField_a_of_type_Arsk = arru.a();
    this.jdField_a_of_type_Arsk.a(3);
    this.jdField_a_of_type_Arsk.c(7000);
    this.jdField_a_of_type_Arsk.f(8.0F);
    this.jdField_a_of_type_Arsk.c(12.0F);
    this.jdField_a_of_type_Arsk.b(12.0F);
    this.jdField_a_of_type_Arsk.b(false);
    this.jdField_a_of_type_Arsk.d(true);
    arrw localarrw = arru.a();
    localarrw.a(new aqst(this));
    localarrw.a(-4);
    localarrw.a(new aqsx(paramContext));
    paramContext = localarrw.a();
    arsi.a(jdField_a_of_type_Arsj);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager = new DanmakuManager(paramView, paramContext);
  }
  
  public void a(aqsu paramaqsu)
  {
    this.jdField_a_of_type_Aqsu = paramaqsu;
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(this);
    }
  }
  
  public void a(aqsv paramaqsv)
  {
    this.jdField_a_of_type_Aqsv = paramaqsv;
  }
  
  public void a(arrl paramarrl, arti paramarti, arsy paramarsy) {}
  
  public void a(DanmuItemBean paramDanmuItemBean)
  {
    if ((paramDanmuItemBean != null) && (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null))
    {
      paramDanmuItemBean = new aqsw(paramDanmuItemBean);
      paramDanmuItemBean = this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(-2147483647, paramDanmuItemBean);
      paramDanmuItemBean.e(true);
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(paramDanmuItemBean);
    }
  }
  
  public void a(List<arrl> paramList)
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
  
  public void b(List<arrl> paramList)
  {
    if ((this.jdField_a_of_type_Aqsu != null) && (!b())) {
      this.jdField_a_of_type_Aqsu.b();
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
    if (this.jdField_a_of_type_Aqsu != null) {
      this.jdField_a_of_type_Aqsu.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqsr
 * JD-Core Version:    0.7.0.1
 */