import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeSelectPager;

public class bnps
  extends bnqb
{
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bmxa jdField_a_of_type_Bmxa;
  private bnpz jdField_a_of_type_Bnpz;
  private bnqa jdField_a_of_type_Bnqa;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private AECaptureModeSelectPager jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager;
  private boolean jdField_a_of_type_Boolean;
  private AECaptureMode[] jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode;
  private boolean b;
  
  public bnps(Activity paramActivity, View paramView, bnqc parambnqc)
  {
    super(paramActivity, paramView, parambnqc);
    this.jdField_a_of_type_Bmxa = ((bmxa)parambnqc.a(65537, new Object[0]));
  }
  
  private bnkb a()
  {
    return (bnkb)bogd.a().c(18);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Bnpz = ((bnpz)bmxz.a(this.jdField_a_of_type_Bmxa).get(bnpz.class));
    this.jdField_a_of_type_Bnpz.a.observe(this.jdField_a_of_type_Bmxa, new bnpu(this));
    this.jdField_a_of_type_Bnqa = ((bnqa)bmxz.a(this.jdField_a_of_type_Bmxa).get(bnqa.class));
    this.jdField_a_of_type_Bnqa.a().observe(this.jdField_a_of_type_Bmxa, new bnpv(this));
  }
  
  private void a(AECaptureMode paramAECaptureMode)
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == paramAECaptureMode) {}
    while (this.jdField_a_of_type_Bnpz.d()) {
      return;
    }
    this.jdField_a_of_type_Bnpz.a.postValue(new bnpr(this.jdField_a_of_type_DovComQqImAeModeAECaptureMode, paramAECaptureMode, 0));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      do
      {
        return;
        this.b = paramBoolean;
        if (!paramBoolean) {
          break;
        }
      } while (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    } while (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void initView()
  {
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2131378166);
    if (localViewStub != null)
    {
      localViewStub.inflate();
      bnrh.b("AEVideoStoryCaptureModePart", "AEPartAction--inflate captureMode");
    }
    this.jdField_a_of_type_AndroidViewView = this.mRootView.findViewById(2131376798);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369341));
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager = ((AECaptureModeSelectPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131381318));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mRootView.findViewById(2131367064));
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i = j;
    if (bptp.a(j, k)) {
      i = k * 9 / 16;
    }
    i = (i - ViewUtils.dip2px(53.0F)) / 2;
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setDisableScroll(true);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setOnPageChangeListener(new bnpt(this));
    this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = ((AECaptureMode[])((bnpz)bmxz.a(this.jdField_a_of_type_Bmxa).get(bnpz.class)).b.getValue());
    if (this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode != null) {
      if (this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode.length <= 1) {
        break label269;
      }
    }
    label269:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = new bnpw(this, this.mRootView.getContext());
      this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setAdapter(this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter);
      a();
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.mActivity != null) && (paramInt1 == 101) && (paramInt2 == 201)) {
      this.mActivity.finish();
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if ((AECaptureMode.NORMAL == this.jdField_a_of_type_DovComQqImAeModeAECaptureMode) && (this.jdField_a_of_type_Bmxa != null)) {
      this.jdField_a_of_type_Bmxa.f(true);
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      if ((paramVarArgs == null) || (paramVarArgs.length != 1) || (!(paramVarArgs[0] instanceof bnke))) {
        break;
      }
    } while (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.PLAY);
    a().a((bnke)paramVarArgs[0], true);
    if (this.jdField_a_of_type_Bmxa != null) {
      this.jdField_a_of_type_Bmxa.a().getIntent().putExtra("widgetinfo", "camera^" + ((bnke)paramVarArgs[0]).a);
    }
    a(AECaptureMode.NORMAL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnps
 * JD-Core Version:    0.7.0.1
 */