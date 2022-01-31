import android.view.View;
import android.view.ViewStub;
import dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder.1;
import dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder.2;
import dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder.3;
import dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder.4;
import dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder.5;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

public class bikb
  extends bijx
{
  private VideoFilterViewPager a;
  
  public bikb(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  public avsu a()
  {
    avsu localavsu = new avsu(null);
    a(new FilterPagerViewStubHolder.2(this, localavsu));
    return localavsu;
  }
  
  public void a(int paramInt)
  {
    a(new FilterPagerViewStubHolder.5(this, paramInt));
  }
  
  protected void a(View paramView)
  {
    this.a = ((VideoFilterViewPager)paramView.findViewById(2131366418));
  }
  
  public void a(bkqt parambkqt, boolean paramBoolean)
  {
    a();
    a(new FilterPagerViewStubHolder.1(this, parambkqt, paramBoolean));
  }
  
  public void a(bkqu parambkqu)
  {
    a(new FilterPagerViewStubHolder.4(this, parambkqu));
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (!a())) {
      return;
    }
    a();
    VideoFilterViewPager localVideoFilterViewPager = this.a;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localVideoFilterViewPager.setVisibility(i);
      this.a.setEnabled(paramBoolean);
      return;
    }
  }
  
  public void b()
  {
    if (!a()) {
      return;
    }
    this.a.d();
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool2 = true;
    a();
    VideoFilterViewPager localVideoFilterViewPager;
    if (this.a != null)
    {
      localVideoFilterViewPager = this.a;
      if (paramBoolean) {
        break label77;
      }
      bool1 = true;
      localVideoFilterViewPager.setDisableScroll(bool1);
      localVideoFilterViewPager = this.a;
      if (paramBoolean) {
        break label82;
      }
    }
    label77:
    label82:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localVideoFilterViewPager.a(bool1);
      if (this.a != null)
      {
        this.a.setIsNormalMode(paramBoolean);
        if (paramBoolean) {
          break label87;
        }
        this.a.a(0);
      }
      return;
      bool1 = false;
      break;
    }
    label87:
    this.a.a();
  }
  
  public void c() {}
  
  public void c(boolean paramBoolean)
  {
    a();
    this.a.post(new FilterPagerViewStubHolder.3(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bikb
 * JD-Core Version:    0.7.0.1
 */