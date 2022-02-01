import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.RelativeLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class bbpz
  extends BrowserBasePresenter
{
  public bbqa a;
  public bbqx a;
  private ImmersionHelper a;
  public ConcurrentHashMap<Long, Set<DanmuItemBean>> a;
  
  public bbpz()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if ((this.jdField_a_of_type_Bbqa != null) && (this.jdField_a_of_type_Bbqa.jdField_a_of_type_Bbps != null)) {
      return this.jdField_a_of_type_Bbqa.jdField_a_of_type_Bbps.a(paramLong, paramInt1, paramInt2, paramString);
    }
    return -1;
  }
  
  public long a()
  {
    return 0L;
  }
  
  public aqsr a()
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      return this.jdField_a_of_type_Bbqa.a();
    }
    return null;
  }
  
  public bbka a()
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      return this.jdField_a_of_type_Bbqa.a();
    }
    return null;
  }
  
  public bbkd a()
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      return this.jdField_a_of_type_Bbqa.a();
    }
    return null;
  }
  
  public ImmersionHelper a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper = new ImmersionHelper(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper;
  }
  
  public RichMediaBrowserInfo a()
  {
    if ((this.jdField_a_of_type_Bbqa != null) && (this.jdField_a_of_type_Bbqa.jdField_a_of_type_Bbps != null)) {
      return this.jdField_a_of_type_Bbqa.jdField_a_of_type_Bbps.a();
    }
    return null;
  }
  
  public RichMediaBrowserInfo a(long paramLong)
  {
    if ((this.jdField_a_of_type_Bbqa != null) && (this.jdField_a_of_type_Bbqa.jdField_a_of_type_Bbps != null)) {
      return this.jdField_a_of_type_Bbqa.jdField_a_of_type_Bbps.a(paramLong);
    }
    return null;
  }
  
  public RichMediaBrowserInfo a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Bbqa != null) && (this.jdField_a_of_type_Bbqa.jdField_a_of_type_Bbps != null)) {
      return this.jdField_a_of_type_Bbqa.jdField_a_of_type_Bbps.a(paramLong1, paramLong2);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      this.jdField_a_of_type_Bbqa.d();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      this.jdField_a_of_type_Bbqa.a(paramInt);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Bbqa != null) && (this.jdField_a_of_type_Bbqa.jdField_a_of_type_Bbps != null)) {
      this.jdField_a_of_type_Bbqa.jdField_a_of_type_Bbps.a(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle) {}
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      this.jdField_a_of_type_Bbqa.a(paramLong1, paramLong2, paramString);
    }
  }
  
  public void a(bbqa parambbqa)
  {
    this.jdField_a_of_type_Bbqa = parambbqa;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      this.jdField_a_of_type_Bbqa.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bbqa != null) && (this.jdField_a_of_type_Bbqa.jdField_a_of_type_Bbps != null) && (this.jdField_a_of_type_Bbqa.jdField_a_of_type_Bbps.a());
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      return this.jdField_a_of_type_Bbqa.b(paramInt);
    }
    return false;
  }
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return bbpf.a(paramRichMediaBrowserInfo);
  }
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Bbqa != null) && (this.jdField_a_of_type_Bbqa.jdField_a_of_type_Bbqz != null)) {
      this.jdField_a_of_type_Bbqa.jdField_a_of_type_Bbqz.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void back()
  {
    super.back();
    if (this.jdField_a_of_type_Bbqa != null) {
      this.jdField_a_of_type_Bbqa.j();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOBrowserBasePresenter", 0, "onDanmakuDrawFinish");
    }
    if ((b()) && (!a().a))
    {
      a().b();
      a().a();
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  @RequiresApi(api=11)
  public void d()
  {
    if (getContentView() != null) {
      getContentView().setAlpha(0.3F);
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_Bbqa != null) && (this.jdField_a_of_type_Bbqa.jdField_a_of_type_Bbqz != null)) {
      return this.jdField_a_of_type_Bbqa.jdField_a_of_type_Bbqz.a();
    }
    return false;
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Bbqx != null) && (this.jdField_a_of_type_Bbqx.a != null)) {
      this.jdField_a_of_type_Bbqx.a.setAlpha(0.3F);
    }
  }
  
  @RequiresApi(api=11)
  public void f()
  {
    if (getContentView() != null) {
      getContentView().setAlpha(1.0F);
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Bbqx != null) && (this.jdField_a_of_type_Bbqx.a != null)) {
      this.jdField_a_of_type_Bbqx.a.setAlpha(1.0F);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      this.jdField_a_of_type_Bbqa.f();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      this.jdField_a_of_type_Bbqa.k();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      this.jdField_a_of_type_Bbqa.l();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      this.jdField_a_of_type_Bbqa.m();
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Bbqa != null) {
      this.jdField_a_of_type_Bbqa.n();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void setGalleryView(BrowserBaseView paramBrowserBaseView)
  {
    super.setGalleryView(paramBrowserBaseView);
    if ((paramBrowserBaseView instanceof bbqx)) {
      this.jdField_a_of_type_Bbqx = ((bbqx)paramBrowserBaseView);
    }
  }
  
  public void setRelyPresenter(BasePresenter paramBasePresenter)
  {
    super.setRelyPresenter(paramBasePresenter);
    if ((paramBasePresenter instanceof bbqa)) {
      a((bbqa)paramBasePresenter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpz
 * JD-Core Version:    0.7.0.1
 */