import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.ae.mode.AECaptureModeSelectPager;

public class biwh
  extends biwr
{
  private int jdField_a_of_type_Int = -1;
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bijd jdField_a_of_type_Bijd;
  private biwp jdField_a_of_type_Biwp;
  private biwq jdField_a_of_type_Biwq;
  private AECaptureModeSelectPager jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  
  public biwh(Activity paramActivity, View paramView, biws parambiws)
  {
    super(paramActivity, paramView, parambiws);
    this.jdField_a_of_type_Bijd = ((bijd)parambiws.a(65537, new Object[0]));
  }
  
  private birb a()
  {
    return (birb)bjav.a().c(18);
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Int == paramInt) || (this.jdField_a_of_type_Biwp.e())) {
      return;
    }
    if (paramInt != 0) {
      this.jdField_a_of_type_Biws.a(196616, new Object[0]);
    }
    this.jdField_a_of_type_Biwp.a().a(biwo.a(this.jdField_a_of_type_Bijd)[paramInt]);
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
    Object localObject = this.jdField_a_of_type_Bijd.a().getIntent();
    if (localObject != null) {
      i = ((Intent)localObject).getIntExtra("AECAMERA_MODE", 200);
    }
    bjah.b("AEVideoStoryCaptureModePart", "checkMode---mode=" + i);
    switch (i)
    {
    default: 
      this.jdField_a_of_type_Biwp.a(true);
      bizx.a().c();
      this.jdField_a_of_type_Biwp.a(biwo.jdField_a_of_type_Biwo);
      boolean bool = this.jdField_a_of_type_Bijd.a().getIntent().getBooleanExtra("key_has_countdown", false);
      if (bool)
      {
        localObject = biwo.a(biwo.jdField_a_of_type_Biwo);
        ((biwo)localObject).a(bool);
        this.jdField_a_of_type_Biwp.a().a(localObject);
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
      this.jdField_a_of_type_Biwp.a(true);
      localObject = this.jdField_a_of_type_Biwp.a(this.jdField_a_of_type_Bijd);
      if (localObject == biwo.b) {
        bizx.a().f("3");
      }
      this.jdField_a_of_type_Biwp.a((biwo)localObject);
      a(((biwo)localObject).jdField_a_of_type_Int);
      b(true);
      return;
      this.jdField_a_of_type_Biwp.a(true);
      bizx.a().i();
      this.jdField_a_of_type_Biwp.a(biwo.c);
      a(biwo.c.jdField_a_of_type_Int);
      b(false);
      return;
      a(biwo.jdField_a_of_type_Biwo.jdField_a_of_type_Int);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Biwp = ((biwp)bijo.a(this.jdField_a_of_type_Bijd).a(biwp.class));
    this.jdField_a_of_type_Biwp.a().a(this.jdField_a_of_type_Bijd, new biwj(this));
    this.jdField_a_of_type_Biwq = ((biwq)bijo.a(this.jdField_a_of_type_Bijd).a(biwq.class));
    this.jdField_a_of_type_Biwq.a().a(this.jdField_a_of_type_Bijd, new biwk(this));
  }
  
  protected void a()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131375359);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368519));
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager = ((AECaptureModeSelectPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131379343));
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i = j;
    if (blcq.a(j, k)) {
      i = k * 9 / 16;
    }
    i = (i - bbll.a(53.0F)) / 2;
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setDisableScroll(true);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setOnPageChangeListener(new biwi(this));
    this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = new biwl(this, this.jdField_a_of_type_AndroidViewView.getContext());
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
      if ((paramVarArgs == null) || (paramVarArgs.length != 1) || (!(paramVarArgs[0] instanceof bire))) {
        break;
      }
    } while (this.jdField_a_of_type_Int != biwo.b.jdField_a_of_type_Int);
    a().a((bire)paramVarArgs[0], true);
    if (this.jdField_a_of_type_Bijd != null) {
      this.jdField_a_of_type_Bijd.a().getIntent().putExtra("widgetinfo", "camera^" + ((bire)paramVarArgs[0]).a);
    }
    a(biwo.jdField_a_of_type_Biwo.jdField_a_of_type_Int);
  }
  
  public void b()
  {
    super.b();
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Bijd != null)) {
      this.jdField_a_of_type_Bijd.b(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwh
 * JD-Core Version:    0.7.0.1
 */