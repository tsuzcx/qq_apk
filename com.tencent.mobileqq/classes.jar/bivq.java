import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.ae.mode.AECaptureModeSelectPager;

public class bivq
  extends biwa
{
  private int jdField_a_of_type_Int = -1;
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private biim jdField_a_of_type_Biim;
  private bivy jdField_a_of_type_Bivy;
  private bivz jdField_a_of_type_Bivz;
  private AECaptureModeSelectPager jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  
  public bivq(Activity paramActivity, View paramView, biwb parambiwb)
  {
    super(paramActivity, paramView, parambiwb);
    this.jdField_a_of_type_Biim = ((biim)parambiwb.a(65537, new Object[0]));
  }
  
  private biqk a()
  {
    return (biqk)bjae.a().c(18);
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Int == paramInt) || (this.jdField_a_of_type_Bivy.e())) {
      return;
    }
    if (paramInt != 0) {
      this.jdField_a_of_type_Biwb.a(196616, new Object[0]);
    }
    this.jdField_a_of_type_Bivy.a().a(bivx.a(this.jdField_a_of_type_Biim)[paramInt]);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setCurrentItem(paramInt, true);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {}
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_Boolean = paramBoolean;
        if (!paramBoolean) {
          break;
        }
      } while (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    } while (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
  }
  
  private void d()
  {
    int i = 200;
    Object localObject = this.jdField_a_of_type_Biim.a().getIntent();
    if (localObject != null) {
      i = ((Intent)localObject).getIntExtra("AECAMERA_MODE", 200);
    }
    bizq.b("AEVideoStoryCaptureModePart", "checkMode---mode=" + i);
    switch (i)
    {
    default: 
      this.jdField_a_of_type_Bivy.a(true);
      bizg.a().c();
      this.jdField_a_of_type_Bivy.a(bivx.jdField_a_of_type_Bivx);
      boolean bool = this.jdField_a_of_type_Biim.a().getIntent().getBooleanExtra("key_has_countdown", false);
      if (bool)
      {
        localObject = bivx.a(bivx.jdField_a_of_type_Bivx);
        ((bivx)localObject).a(bool);
        this.jdField_a_of_type_Bivy.a().a(localObject);
      }
      break;
    }
    for (;;)
    {
      b(false);
      return;
      a(0);
      b(false);
      return;
      a(0);
      b(true);
      return;
      this.jdField_a_of_type_Bivy.a(true);
      localObject = this.jdField_a_of_type_Bivy.a(this.jdField_a_of_type_Biim);
      if (localObject == bivx.b) {
        bizg.a().f("3");
      }
      this.jdField_a_of_type_Bivy.a((bivx)localObject);
      a(((bivx)localObject).jdField_a_of_type_Int);
      b(true);
      return;
      this.jdField_a_of_type_Bivy.a(true);
      bizg.a().i();
      this.jdField_a_of_type_Bivy.a(bivx.c);
      a(bivx.c.jdField_a_of_type_Int);
      b(false);
      return;
      a(bivx.jdField_a_of_type_Bivx.jdField_a_of_type_Int);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bivy = ((bivy)biix.a(this.jdField_a_of_type_Biim).a(bivy.class));
    this.jdField_a_of_type_Bivy.a().a(this.jdField_a_of_type_Biim, new bivs(this));
    this.jdField_a_of_type_Bivz = ((bivz)biix.a(this.jdField_a_of_type_Biim).a(bivz.class));
    this.jdField_a_of_type_Bivz.a().a(this.jdField_a_of_type_Biim, new bivt(this));
  }
  
  protected void a()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131375357);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368520));
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager = ((AECaptureModeSelectPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131379338));
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i = j;
    if (blbz.a(j, k)) {
      i = k * 9 / 16;
    }
    i = (i - bbkx.a(53.0F)) / 2;
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setDisableScroll(true);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setOnPageChangeListener(new bivr(this));
    this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = new bivu(this, this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setAdapter(this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter);
    e();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (paramInt1 == 101) && (paramInt2 == 201)) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      d();
      return;
      if ((paramVarArgs == null) || (paramVarArgs.length != 1) || (!(paramVarArgs[0] instanceof biqn))) {
        break;
      }
    } while (this.jdField_a_of_type_Int != bivx.b.jdField_a_of_type_Int);
    a().a((biqn)paramVarArgs[0], true);
    if (this.jdField_a_of_type_Biim != null) {
      this.jdField_a_of_type_Biim.a().getIntent().putExtra("widgetinfo", "camera^" + ((biqn)paramVarArgs[0]).a);
    }
    a(bivx.jdField_a_of_type_Bivx.jdField_a_of_type_Int);
  }
  
  public void b()
  {
    super.b();
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Biim != null)) {
      this.jdField_a_of_type_Biim.b(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bivq
 * JD-Core Version:    0.7.0.1
 */