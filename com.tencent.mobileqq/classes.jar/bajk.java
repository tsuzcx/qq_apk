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

public class bajk
  extends BrowserBasePresenter
{
  public bajl a;
  public baki a;
  private ImmersionHelper a;
  public ConcurrentHashMap<Long, Set<DanmuItemBean>> a;
  
  public bajk()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if ((this.jdField_a_of_type_Bajl != null) && (this.jdField_a_of_type_Bajl.jdField_a_of_type_Bajd != null)) {
      return this.jdField_a_of_type_Bajl.jdField_a_of_type_Bajd.a(paramLong, paramInt1, paramInt2, paramString);
    }
    return -1;
  }
  
  public long a()
  {
    return 0L;
  }
  
  public appn a()
  {
    if (this.jdField_a_of_type_Bajl != null) {
      return this.jdField_a_of_type_Bajl.a();
    }
    return null;
  }
  
  public badl a()
  {
    if (this.jdField_a_of_type_Bajl != null) {
      return this.jdField_a_of_type_Bajl.a();
    }
    return null;
  }
  
  public bado a()
  {
    if (this.jdField_a_of_type_Bajl != null) {
      return this.jdField_a_of_type_Bajl.a();
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
    if ((this.jdField_a_of_type_Bajl != null) && (this.jdField_a_of_type_Bajl.jdField_a_of_type_Bajd != null)) {
      return this.jdField_a_of_type_Bajl.jdField_a_of_type_Bajd.a();
    }
    return null;
  }
  
  public RichMediaBrowserInfo a(long paramLong)
  {
    if ((this.jdField_a_of_type_Bajl != null) && (this.jdField_a_of_type_Bajl.jdField_a_of_type_Bajd != null)) {
      return this.jdField_a_of_type_Bajl.jdField_a_of_type_Bajd.a(paramLong);
    }
    return null;
  }
  
  public RichMediaBrowserInfo a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Bajl != null) && (this.jdField_a_of_type_Bajl.jdField_a_of_type_Bajd != null)) {
      return this.jdField_a_of_type_Bajl.jdField_a_of_type_Bajd.a(paramLong1, paramLong2);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bajl != null) {
      this.jdField_a_of_type_Bajl.d();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bajl != null) {
      this.jdField_a_of_type_Bajl.a(paramInt);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Bajl != null) && (this.jdField_a_of_type_Bajl.jdField_a_of_type_Bajd != null)) {
      this.jdField_a_of_type_Bajl.jdField_a_of_type_Bajd.a(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle) {}
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_a_of_type_Bajl != null) {
      this.jdField_a_of_type_Bajl.a(paramLong1, paramLong2, paramString);
    }
  }
  
  public void a(bajl parambajl)
  {
    this.jdField_a_of_type_Bajl = parambajl;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bajl != null) {
      this.jdField_a_of_type_Bajl.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bajl != null) && (this.jdField_a_of_type_Bajl.jdField_a_of_type_Bajd != null) && (this.jdField_a_of_type_Bajl.jdField_a_of_type_Bajd.a());
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_Bajl != null) {
      return this.jdField_a_of_type_Bajl.b(paramInt);
    }
    return false;
  }
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return baiq.a(paramRichMediaBrowserInfo);
  }
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Bajl != null) && (this.jdField_a_of_type_Bajl.jdField_a_of_type_Bakk != null)) {
      this.jdField_a_of_type_Bajl.jdField_a_of_type_Bakk.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void back()
  {
    super.back();
    if (this.jdField_a_of_type_Bajl != null) {
      this.jdField_a_of_type_Bajl.j();
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
    if ((this.jdField_a_of_type_Bajl != null) && (this.jdField_a_of_type_Bajl.jdField_a_of_type_Bakk != null)) {
      return this.jdField_a_of_type_Bajl.jdField_a_of_type_Bakk.a();
    }
    return false;
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Baki != null) && (this.jdField_a_of_type_Baki.a != null)) {
      this.jdField_a_of_type_Baki.a.setAlpha(0.3F);
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
    if ((this.jdField_a_of_type_Baki != null) && (this.jdField_a_of_type_Baki.a != null)) {
      this.jdField_a_of_type_Baki.a.setAlpha(1.0F);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Bajl != null) {
      this.jdField_a_of_type_Bajl.f();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Bajl != null) {
      this.jdField_a_of_type_Bajl.k();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Bajl != null) {
      this.jdField_a_of_type_Bajl.l();
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Bajl != null) {
      this.jdField_a_of_type_Bajl.m();
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Bajl != null) {
      this.jdField_a_of_type_Bajl.n();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void setGalleryView(BrowserBaseView paramBrowserBaseView)
  {
    super.setGalleryView(paramBrowserBaseView);
    if ((paramBrowserBaseView instanceof baki)) {
      this.jdField_a_of_type_Baki = ((baki)paramBrowserBaseView);
    }
  }
  
  public void setRelyPresenter(BasePresenter paramBasePresenter)
  {
    super.setRelyPresenter(paramBasePresenter);
    if ((paramBasePresenter instanceof bajl)) {
      a((bajl)paramBasePresenter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajk
 * JD-Core Version:    0.7.0.1
 */