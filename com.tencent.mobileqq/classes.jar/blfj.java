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

public class blfj
  extends blfs
{
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bkpl jdField_a_of_type_Bkpl;
  private blfq jdField_a_of_type_Blfq;
  private blfr jdField_a_of_type_Blfr;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private AECaptureModeSelectPager jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager;
  private boolean jdField_a_of_type_Boolean;
  private AECaptureMode[] jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  
  public blfj(Activity paramActivity, View paramView, blft paramblft)
  {
    super(paramActivity, paramView, paramblft);
    this.jdField_a_of_type_Bkpl = ((bkpl)paramblft.a(65537, new Object[0]));
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_Bkpl != null) && (this.jdField_a_of_type_Bkpl.a().getIntent() != null)) {
      return this.jdField_a_of_type_Bkpl.a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", blat.a.a());
    }
    return blat.a.a();
  }
  
  private bkzy a()
  {
    return (bkzy)blqr.a().c(18);
  }
  
  private void a(AECaptureMode paramAECaptureMode)
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == paramAECaptureMode) {}
    while (this.jdField_a_of_type_Blfq.d()) {
      return;
    }
    this.jdField_a_of_type_Blfq.a.a(new blfi(paramAECaptureMode, 0));
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
    this.jdField_a_of_type_Blfq = ((blfq)bkpx.a(this.jdField_a_of_type_Bkpl).a(blfq.class));
    this.jdField_a_of_type_Blfq.a.a(this.jdField_a_of_type_Bkpl, new blfl(this));
    this.jdField_a_of_type_Blfr = ((blfr)bkpx.a(this.jdField_a_of_type_Bkpl).a(blfr.class));
    this.jdField_a_of_type_Blfr.a().a(this.jdField_a_of_type_Bkpl, new blfm(this));
    if ((blat.h(a())) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_a_of_type_Bkpl.a().getResources().getColor(2131165239));
    }
  }
  
  protected void a()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377147);
    if (localViewStub != null)
    {
      localViewStub.inflate();
      bljn.b("AEVideoStoryCaptureModePart", "AEPartAction--inflate captureMode");
    }
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131375897);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368727));
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager = ((AECaptureModeSelectPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131380102));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366606));
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i = j;
    if (bnsm.a(j, k)) {
      i = k * 9 / 16;
    }
    i = (i - bdoo.a(53.0F)) / 2;
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setDisableScroll(true);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setOnPageChangeListener(new blfk(this));
    this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = ((AECaptureMode[])((blfq)bkpx.a(this.jdField_a_of_type_Bkpl).a(blfq.class)).b.a());
    if (this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode != null) {
      if (this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode.length <= 1) {
        break label269;
      }
    }
    label269:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = new blfn(this, this.jdField_a_of_type_AndroidViewView.getContext());
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
      if ((paramVarArgs == null) || (paramVarArgs.length != 1) || (!(paramVarArgs[0] instanceof blab))) {
        break;
      }
    } while (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.PLAY);
    a().a((blab)paramVarArgs[0], true);
    if (this.jdField_a_of_type_Bkpl != null) {
      this.jdField_a_of_type_Bkpl.a().getIntent().putExtra("widgetinfo", "camera^" + ((blab)paramVarArgs[0]).a);
    }
    a(AECaptureMode.NORMAL);
  }
  
  public void b()
  {
    super.b();
    if ((AECaptureMode.NORMAL == this.jdField_a_of_type_DovComQqImAeModeAECaptureMode) && (this.jdField_a_of_type_Bkpl != null)) {
      this.jdField_a_of_type_Bkpl.c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfj
 * JD-Core Version:    0.7.0.1
 */