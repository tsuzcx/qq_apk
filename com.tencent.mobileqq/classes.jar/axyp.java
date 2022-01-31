import android.support.annotation.RequiresApi;
import android.widget.RelativeLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.BaseView;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class axyp
  extends BrowserBasePresenter
{
  public axyq a;
  public axzm a;
  private ImmersionHelper a;
  public ConcurrentHashMap<Long, Set<DanmuItemBean>> a;
  
  public axyp()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper = new ImmersionHelper(this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if ((this.jdField_a_of_type_Axyq != null) && (this.jdField_a_of_type_Axyq.jdField_a_of_type_Axyi != null)) {
      return this.jdField_a_of_type_Axyq.jdField_a_of_type_Axyi.a(paramLong, paramInt1, paramInt2, paramString);
    }
    return -1;
  }
  
  public long a()
  {
    return 0L;
  }
  
  public aogr a()
  {
    if (this.jdField_a_of_type_Axyq != null) {
      return this.jdField_a_of_type_Axyq.a();
    }
    return null;
  }
  
  public axsw a()
  {
    if (this.jdField_a_of_type_Axyq != null) {
      return this.jdField_a_of_type_Axyq.a();
    }
    return null;
  }
  
  public axsz a()
  {
    if (this.jdField_a_of_type_Axyq != null) {
      return this.jdField_a_of_type_Axyq.a();
    }
    return null;
  }
  
  public ImmersionHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper;
  }
  
  public RichMediaBrowserInfo a()
  {
    if ((this.jdField_a_of_type_Axyq != null) && (this.jdField_a_of_type_Axyq.jdField_a_of_type_Axyi != null)) {
      return this.jdField_a_of_type_Axyq.jdField_a_of_type_Axyi.a();
    }
    return null;
  }
  
  public RichMediaBrowserInfo a(long paramLong)
  {
    if ((this.jdField_a_of_type_Axyq != null) && (this.jdField_a_of_type_Axyq.jdField_a_of_type_Axyi != null)) {
      return this.jdField_a_of_type_Axyq.jdField_a_of_type_Axyi.a(paramLong);
    }
    return null;
  }
  
  public RichMediaBrowserInfo a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Axyq != null) && (this.jdField_a_of_type_Axyq.jdField_a_of_type_Axyi != null)) {
      return this.jdField_a_of_type_Axyq.jdField_a_of_type_Axyi.a(paramLong1, paramLong2);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Axyq != null) {
      this.jdField_a_of_type_Axyq.d();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Axyq != null) {
      this.jdField_a_of_type_Axyq.a(paramInt);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Axyq != null) && (this.jdField_a_of_type_Axyq.jdField_a_of_type_Axyi != null)) {
      this.jdField_a_of_type_Axyq.jdField_a_of_type_Axyi.a(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3) {}
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_a_of_type_Axyq != null) {
      this.jdField_a_of_type_Axyq.a(paramLong1, paramLong2, paramString);
    }
  }
  
  public void a(axyq paramaxyq)
  {
    this.jdField_a_of_type_Axyq = paramaxyq;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Axyq != null) {
      this.jdField_a_of_type_Axyq.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Axyq != null) && (this.jdField_a_of_type_Axyq.jdField_a_of_type_Axyi != null) && (this.jdField_a_of_type_Axyq.jdField_a_of_type_Axyi.a());
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_Axyq != null) {
      return this.jdField_a_of_type_Axyq.b(paramInt);
    }
    return false;
  }
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return axyb.a(paramRichMediaBrowserInfo);
  }
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Axyq != null) && (this.jdField_a_of_type_Axyq.jdField_a_of_type_Axzo != null)) {
      this.jdField_a_of_type_Axyq.jdField_a_of_type_Axzo.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void back()
  {
    super.back();
    if (this.jdField_a_of_type_Axyq != null) {
      this.jdField_a_of_type_Axyq.j();
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
    if ((this.jdField_a_of_type_Axyq != null) && (this.jdField_a_of_type_Axyq.jdField_a_of_type_Axzo != null)) {
      return this.jdField_a_of_type_Axyq.jdField_a_of_type_Axzo.a();
    }
    return false;
  }
  
  @RequiresApi(api=11)
  public void e()
  {
    if (getContentView() != null) {
      getContentView().setAlpha(1.0F);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Axyq != null) {
      this.jdField_a_of_type_Axyq.f();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Axyq != null) {
      this.jdField_a_of_type_Axyq.k();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Axyq != null) {
      this.jdField_a_of_type_Axyq.l();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Axyq != null) {
      this.jdField_a_of_type_Axyq.m();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Axyq != null) {
      this.jdField_a_of_type_Axyq.n();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void setGalleryView(BaseView paramBaseView)
  {
    super.setGalleryView(paramBaseView);
    if ((paramBaseView instanceof axzm)) {
      this.jdField_a_of_type_Axzm = ((axzm)paramBaseView);
    }
  }
  
  public void setRelyPresenter(BasePresenter paramBasePresenter)
  {
    super.setRelyPresenter(paramBasePresenter);
    if ((paramBasePresenter instanceof axyq)) {
      a((axyq)paramBasePresenter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyp
 * JD-Core Version:    0.7.0.1
 */