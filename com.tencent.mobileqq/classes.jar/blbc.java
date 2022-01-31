import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeSelectPager;

public class blbc
  extends blbl
{
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bkle jdField_a_of_type_Bkle;
  private blbj jdField_a_of_type_Blbj;
  private blbk jdField_a_of_type_Blbk;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private AECaptureModeSelectPager jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager;
  private boolean jdField_a_of_type_Boolean;
  private AECaptureMode[] jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  
  public blbc(Activity paramActivity, View paramView, blbm paramblbm)
  {
    super(paramActivity, paramView, paramblbm);
    this.jdField_a_of_type_Bkle = ((bkle)paramblbm.a(65537, new Object[0]));
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_Bkle != null) && (this.jdField_a_of_type_Bkle.a().getIntent() != null)) {
      return this.jdField_a_of_type_Bkle.a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bkwm.a.a());
    }
    return bkwm.a.a();
  }
  
  private bkvr a()
  {
    return (bkvr)blmf.a().c(18);
  }
  
  private void a(AECaptureMode paramAECaptureMode)
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == paramAECaptureMode) {}
    while (this.jdField_a_of_type_Blbj.d()) {
      return;
    }
    this.jdField_a_of_type_Blbj.a.a(new blbb(paramAECaptureMode, 0));
  }
  
  private void a(boolean paramBoolean)
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
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Blbj = ((blbj)bklq.a(this.jdField_a_of_type_Bkle).a(blbj.class));
    this.jdField_a_of_type_Blbj.a.a(this.jdField_a_of_type_Bkle, new blbe(this));
    this.jdField_a_of_type_Blbk = ((blbk)bklq.a(this.jdField_a_of_type_Bkle).a(blbk.class));
    this.jdField_a_of_type_Blbk.a().a(this.jdField_a_of_type_Bkle, new blbf(this));
    if ((bkwm.h(a())) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_Bkle.a().getResources().getColor(2131165239));
    }
  }
  
  protected void a()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377093);
    if (localViewStub != null)
    {
      localViewStub.inflate();
      blfg.b("AEVideoStoryCaptureModePart", "AEPartAction--inflate captureMode");
    }
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131375844);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368713));
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager = ((AECaptureModeSelectPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131380044));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366600));
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i = j;
    if (bnoa.a(j, k)) {
      i = k * 9 / 16;
    }
    i = (i - bdkf.a(53.0F)) / 2;
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setDisableScroll(true);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setOnPageChangeListener(new blbd(this));
    this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = ((AECaptureMode[])((blbj)bklq.a(this.jdField_a_of_type_Bkle).a(blbj.class)).b.a());
    if (this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode != null) {
      if (this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode.length <= 1) {
        break label269;
      }
    }
    label269:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = new blbg(this, this.jdField_a_of_type_AndroidViewView.getContext());
      this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setAdapter(this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter);
      d();
      return;
    }
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
      if ((paramVarArgs == null) || (paramVarArgs.length != 1) || (!(paramVarArgs[0] instanceof bkvu))) {
        break;
      }
    } while (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.PLAY);
    a().a((bkvu)paramVarArgs[0], true);
    if (this.jdField_a_of_type_Bkle != null) {
      this.jdField_a_of_type_Bkle.a().getIntent().putExtra("widgetinfo", "camera^" + ((bkvu)paramVarArgs[0]).a);
    }
    a(AECaptureMode.NORMAL);
  }
  
  public void b()
  {
    super.b();
    if ((AECaptureMode.NORMAL == this.jdField_a_of_type_DovComQqImAeModeAECaptureMode) && (this.jdField_a_of_type_Bkle != null)) {
      this.jdField_a_of_type_Bkle.c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbc
 * JD-Core Version:    0.7.0.1
 */