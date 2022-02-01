import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;

public class blqn
  extends blpr
  implements blqi
{
  private View jdField_a_of_type_AndroidViewView;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public blqn(Activity paramActivity, View paramView, bmas parambmas)
  {
    super(paramActivity, paramView, parambmas);
  }
  
  private boolean a(blpq paramblpq, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramblpq != null)
    {
      bool1 = bool2;
      if (paramblpq.jdField_a_of_type_Blvb != null)
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
  
  private void i()
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = ((AEBottomListScrollView)this.mRootView.findViewById(2131376742));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFling(true);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransitionTimeMillis(100);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFlingThreshold(1000);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOffscreenItems(10);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOnItemChangedListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setScrollStateChangeListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAEEditMaterialSelectedListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransformer(new blqr().a(1.0F).b(1.3839F).a());
    this.jdField_a_of_type_Blpm = new blpm(this.jdField_a_of_type_Bljy, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, this.jdField_a_of_type_Blnv);
    this.jdField_a_of_type_Blpm.a(new blqo(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAdapter(this.jdField_a_of_type_Blpm);
    this.jdField_a_of_type_AndroidViewView = this.mRootView.findViewById(2131369054);
    this.jdField_a_of_type_Bluy = ((bluy)bmql.a().c(18));
    this.jdField_a_of_type_Bluy.a(this, 113);
    this.jdField_a_of_type_Bluy.a(this, 114);
    this.jdField_a_of_type_Bluy.a(this, 115);
    this.jdField_a_of_type_Bluy.a(this, 112);
    a();
    c();
  }
  
  public void a(@NonNull blpq paramblpq, int paramInt)
  {
    super.a(paramblpq, paramInt);
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
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)blks.a(this.jdField_a_of_type_Bljy).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_Bljy, new blqp(this));
  }
  
  protected void b(int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      b(true);
      super.b(paramInt);
      this.b = paramInt;
      return;
    }
  }
  
  public void b(@NonNull blpq paramblpq, int paramInt)
  {
    super.b(paramblpq, paramInt);
    if (a(paramblpq, paramInt))
    {
      this.jdField_a_of_type_Boolean = false;
      b(false);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    b(true);
  }
  
  public void c(@Nullable blpq paramblpq, int paramInt)
  {
    if (paramblpq != null)
    {
      paramblpq.a(3);
      paramblpq = paramblpq.jdField_a_of_type_Blvb;
      if ((paramblpq != null) && (!"call_material_id".equals(paramblpq.jdField_a_of_type_JavaLangString))) {
        this.b = paramInt;
      }
      if ((paramblpq != null) && (paramblpq.jdField_a_of_type_Boolean)) {
        a(true);
      }
      bltp.a().a(paramblpq);
      if (this.jdField_a_of_type_Blpm != null)
      {
        if (!a(paramblpq)) {
          break label83;
        }
        yqu.a(this.mActivity, paramblpq);
      }
    }
    return;
    label83:
    this.jdField_a_of_type_Blpm.b(paramblpq);
  }
  
  protected void d()
  {
    g();
  }
  
  protected void e()
  {
    a(327683);
  }
  
  protected void f()
  {
    a(327684);
  }
  
  public void initView()
  {
    if (this.mRootView != null) {
      i();
    }
    b();
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
        paramVarArgs = bluy.a();
      } while ((paramVarArgs != null) && (!paramVarArgs.equals(blvb.jdField_a_of_type_Blvb)));
      b(false);
      return;
    } while (paramInt != 786436);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.smoothScrollToPosition(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqn
 * JD-Core Version:    0.7.0.1
 */