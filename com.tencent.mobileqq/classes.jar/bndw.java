import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;

public class bndw
  extends bnda
  implements bndr
{
  private View jdField_a_of_type_AndroidViewView;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public bndw(Activity paramActivity, View paramView, bnqc parambnqc)
  {
    super(paramActivity, paramView, parambnqc);
  }
  
  private boolean a(bncz parambncz, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambncz != null)
    {
      bool1 = bool2;
      if (parambncz.jdField_a_of_type_Bnke != null)
      {
        bool1 = bool2;
        if (paramInt == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean)) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = ((AEBottomListScrollView)this.mRootView.findViewById(2131377010));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFling(true);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransitionTimeMillis(100);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFlingThreshold(1000);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOffscreenItems(10);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOnItemChangedListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setScrollStateChangeListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAEEditMaterialSelectedListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransformer(new bnea().a(1.0F).b(1.3839F).a());
    this.jdField_a_of_type_Bncv = new bncv(this.jdField_a_of_type_Bmxa, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, this.jdField_a_of_type_Bnbg);
    this.jdField_a_of_type_Bncv.a(new bndx(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAdapter(this.jdField_a_of_type_Bncv);
    this.jdField_a_of_type_AndroidViewView = this.mRootView.findViewById(2131369217);
    this.jdField_a_of_type_Bnkb = ((bnkb)bogd.a().c(18));
    this.jdField_a_of_type_Bnkb.a(this, 113);
    this.jdField_a_of_type_Bnkb.a(this, 112);
    a();
    c();
  }
  
  public void a(@NonNull bncz parambncz, int paramInt)
  {
    super.a(parambncz, paramInt);
    a(false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.mPartManager != null)
    {
      if (paramBoolean) {
        this.mPartManager.a(327696, new Object[0]);
      }
    }
    else {
      return;
    }
    this.mPartManager.a(327689, new Object[0]);
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)bmxz.a(this.jdField_a_of_type_Bmxa).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_Bmxa, new bndy(this));
  }
  
  public void b(@NonNull bncz parambncz, int paramInt)
  {
    super.b(parambncz, paramInt);
    if (a(parambncz, paramInt))
    {
      this.jdField_a_of_type_Boolean = false;
      b(false);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    b(true);
  }
  
  protected void c(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      b(true);
      super.c(paramInt);
      this.jdField_b_of_type_Int = paramInt;
      return;
    }
  }
  
  public void c(@Nullable bncz parambncz, int paramInt)
  {
    if (parambncz != null)
    {
      parambncz.a(3);
      parambncz = parambncz.jdField_a_of_type_Bnke;
      if ((parambncz != null) && (!"call_material_id".equals(parambncz.jdField_a_of_type_JavaLangString))) {
        this.jdField_b_of_type_Int = paramInt;
      }
      if ((parambncz != null) && (!"0".equals(parambncz.jdField_a_of_type_JavaLangString)) && (parambncz.jdField_a_of_type_Boolean)) {
        a(true);
      }
      bnhs.a().a(parambncz);
      if (this.jdField_a_of_type_Bncv != null)
      {
        if (!a(parambncz)) {
          break label95;
        }
        zfn.a(this.mActivity, parambncz);
      }
    }
    return;
    label95:
    this.jdField_a_of_type_Bncv.b(parambncz);
  }
  
  protected void d()
  {
    h();
  }
  
  protected void e()
  {
    b(327683);
  }
  
  protected void f()
  {
    b(327697);
  }
  
  protected void g()
  {
    b(327684);
  }
  
  public void initView()
  {
    if (this.mRootView != null) {
      j();
    }
    b();
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    super.send(paramInt, paramVarArgs);
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
          b(false);
          return;
        }
        if (paramInt == 786435)
        {
          b(true);
          return;
        }
        if (paramInt != 131075) {
          break;
        }
        paramVarArgs = bnkb.a();
      } while ((paramVarArgs != null) && (!paramVarArgs.equals(bnke.jdField_a_of_type_Bnke)));
      b(false);
      return;
    } while (paramInt != 786436);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.smoothScrollToPosition(this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndw
 * JD-Core Version:    0.7.0.1
 */