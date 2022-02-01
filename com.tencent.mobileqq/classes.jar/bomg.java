import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.view.View;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;

public class bomg
  extends boll
{
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  public bomg(Activity paramActivity, View paramView, bown parambown)
  {
    super(paramActivity, paramView, parambown);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    View localView = this.b;
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean)) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private boolean a(bolk parambolk, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambolk != null)
    {
      bool1 = bool2;
      if (parambolk.a != null)
      {
        bool1 = bool2;
        if (paramInt == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void p()
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = ((AEBottomListScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376988));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFling(true);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransitionTimeMillis(100);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFlingThreshold(1000);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOffscreenItems(10);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOnItemChangedListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setScrollStateChangeListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransformer(new bomk().a(1.0F).b(1.3839F).a());
    this.jdField_a_of_type_Bolg = new bolg(this.jdField_a_of_type_Bofh, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, this.jdField_a_of_type_Bojq);
    this.jdField_a_of_type_Bolg.a(new bomh(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAdapter(this.jdField_a_of_type_Bolg);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131369028);
    this.jdField_a_of_type_Boqr = ((boqr)bplq.a().c(18));
    this.jdField_a_of_type_Boqr.a(this, 113);
    this.jdField_a_of_type_Boqr.a(this, 114);
    this.jdField_a_of_type_Boqr.a(this, 115);
    this.jdField_a_of_type_Boqr.a(this, 112);
    b();
    f();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      p();
    }
    e();
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    super.a(paramInt, paramVarArgs);
    if (paramInt == 786433) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.smoothScrollToPosition(0);
    }
    do
    {
      do
      {
        return;
        if (paramInt == 786434)
        {
          a(false);
          return;
        }
        if (paramInt == 786435)
        {
          a(true);
          return;
        }
      } while (paramInt != 131075);
      paramVarArgs = boqr.a();
    } while ((paramVarArgs != null) && (!paramVarArgs.equals(boqu.a)));
    a(false);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(@NonNull bolk parambolk, int paramInt)
  {
    super.b(parambolk, paramInt);
    if (a(parambolk, paramInt))
    {
      this.jdField_a_of_type_Boolean = false;
      a(false);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    a(true);
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)bofz.a(this.jdField_a_of_type_Bofh).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_Bofh, new bomi(this));
  }
  
  protected void h()
  {
    k();
  }
  
  protected void i()
  {
    a(327683);
  }
  
  protected void j()
  {
    a(327684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bomg
 * JD-Core Version:    0.7.0.1
 */