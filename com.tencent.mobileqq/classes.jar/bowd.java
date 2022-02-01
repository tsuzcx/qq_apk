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
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeSelectPager;

public class bowd
  extends bowm
{
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bofh jdField_a_of_type_Bofh;
  private bowk jdField_a_of_type_Bowk;
  private bowl jdField_a_of_type_Bowl;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private AECaptureModeSelectPager jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager;
  private boolean jdField_a_of_type_Boolean;
  private AECaptureMode[] jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  
  public bowd(Activity paramActivity, View paramView, bown parambown)
  {
    super(paramActivity, paramView, parambown);
    this.jdField_a_of_type_Bofh = ((bofh)parambown.a(65537, new Object[0]));
  }
  
  private boqr a()
  {
    return (boqr)bplq.a().c(18);
  }
  
  private void a(AECaptureMode paramAECaptureMode)
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == paramAECaptureMode) {}
    while (this.jdField_a_of_type_Bowk.d()) {
      return;
    }
    this.jdField_a_of_type_Bowk.a.postValue(new bowc(this.jdField_a_of_type_DovComQqImAeModeAECaptureMode, paramAECaptureMode, 0));
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
  
  private void b()
  {
    this.jdField_a_of_type_Bowk = ((bowk)bofz.a(this.jdField_a_of_type_Bofh).get(bowk.class));
    this.jdField_a_of_type_Bowk.a.observe(this.jdField_a_of_type_Bofh, new bowf(this));
    this.jdField_a_of_type_Bowl = ((bowl)bofz.a(this.jdField_a_of_type_Bofh).get(bowl.class));
    this.jdField_a_of_type_Bowl.a().observe(this.jdField_a_of_type_Bofh, new bowg(this));
  }
  
  protected void a()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378109);
    if (localViewStub != null)
    {
      localViewStub.inflate();
      bpam.b("AEVideoStoryCaptureModePart", "AEPartAction--inflate captureMode");
    }
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376769);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369154));
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager = ((AECaptureModeSelectPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131381245));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366923));
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i = j;
    if (brkm.a(j, k)) {
      i = k * 9 / 16;
    }
    i = (i - bhtq.a(53.0F)) / 2;
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setDisableScroll(true);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setOnPageChangeListener(new bowe(this));
    this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = ((AECaptureMode[])((bowk)bofz.a(this.jdField_a_of_type_Bofh).get(bowk.class)).b.getValue());
    if (this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode != null) {
      if (this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode.length <= 1) {
        break label269;
      }
    }
    label269:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = new bowh(this, this.jdField_a_of_type_AndroidViewView.getContext());
      this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setAdapter(this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter);
      b();
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
      if ((paramVarArgs == null) || (paramVarArgs.length != 1) || (!(paramVarArgs[0] instanceof boqu))) {
        break;
      }
    } while (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.PLAY);
    a().a((boqu)paramVarArgs[0], true);
    if (this.jdField_a_of_type_Bofh != null) {
      this.jdField_a_of_type_Bofh.a().getIntent().putExtra("widgetinfo", "camera^" + ((boqu)paramVarArgs[0]).a);
    }
    a(AECaptureMode.NORMAL);
  }
  
  public void c()
  {
    super.c();
    if ((AECaptureMode.NORMAL == this.jdField_a_of_type_DovComQqImAeModeAECaptureMode) && (this.jdField_a_of_type_Bofh != null)) {
      this.jdField_a_of_type_Bofh.b(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bowd
 * JD-Core Version:    0.7.0.1
 */