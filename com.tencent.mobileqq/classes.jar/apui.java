import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.gallery.animation.AnimationView;
import com.tencent.mobileqq.gallery.view.GalleryBaseAdapter;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;

public class apui
  implements apsc, behi, behj, behk, bejr, bejs
{
  protected int a;
  protected ViewGroup a;
  private apsb jdField_a_of_type_Apsb;
  public aptf a;
  protected apun a;
  protected apvk a;
  protected GalleryBaseAdapter a;
  public Gallery a;
  private boolean jdField_a_of_type_Boolean;
  public Activity b;
  protected View b;
  public RelativeLayout b;
  
  public apui(Activity paramActivity)
  {
    this.jdField_b_of_type_AndroidAppActivity = paramActivity;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public apsb a()
  {
    return this.jdField_a_of_type_Apsb;
  }
  
  public apsb a(Activity paramActivity, apsw paramapsw)
  {
    return new apsd(paramActivity, paramapsw);
  }
  
  protected apun a()
  {
    return new apuo();
  }
  
  protected apvk a()
  {
    return new apvl();
  }
  
  public AnimationView a()
  {
    AnimationView localAnimationView = new AnimationView(this.jdField_b_of_type_AndroidAppActivity, null);
    localAnimationView.setId(2131297010);
    localAnimationView.setVisibility(4);
    return localAnimationView;
  }
  
  protected GalleryBaseAdapter a(Context paramContext)
  {
    return new GalleryBaseAdapter();
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Apvk != null) && (this.jdField_a_of_type_Apvk.a())) {
      this.jdField_a_of_type_Apvk.b();
    }
    if ((this.jdField_a_of_type_Apvk != null) && (this.jdField_a_of_type_Apvk.b())) {
      this.jdField_a_of_type_Apvk.c();
    }
    apsm.a().a().b("GalleryBaseScene", 2, "onScrollStart:" + paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Apsb = a(this.jdField_b_of_type_AndroidAppActivity, this.jdField_a_of_type_Aptf.a);
  }
  
  public void a(Configuration paramConfiguration) {}
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(ViewGroup paramViewGroup)
  {
    b(paramViewGroup);
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(a());
    }
  }
  
  public void a(aptf paramaptf)
  {
    this.jdField_a_of_type_Aptf = paramaptf;
  }
  
  public void a(AdapterView<?> paramAdapterView) {}
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    if ((this.jdField_a_of_type_Apun != null) && (d())) {
      this.jdField_a_of_type_Apun.a(paramAdapterView, paramInt);
    }
    if ((!g()) && (this.jdField_a_of_type_Apvk != null) && (!this.jdField_a_of_type_Apvk.a())) {
      this.jdField_a_of_type_Apvk.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqGalleryViewGalleryBaseAdapter.a(paramView, paramInt);
    apsm.a().a().b("GalleryBaseScene", 2, "GalleryBaseView.onItemSelected(): position=" + paramInt);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  protected RelativeLayout b()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_b_of_type_AndroidAppActivity).inflate(2131495379, null);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Aptf != null) && (a().b) && (this.jdField_a_of_type_ComTencentWidgetGallery != null)) {
      this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(4);
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Apvk != null) && (!this.jdField_a_of_type_Apvk.a())) {
      this.jdField_a_of_type_Apvk.a();
    }
    apsm.a().a().b("GalleryBaseScene", 2, "onScrollEnd:" + paramInt);
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = b();
    if (paramViewGroup == null) {
      this.jdField_b_of_type_AndroidAppActivity.addContentView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131309736));
      this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)this.jdField_b_of_type_AndroidAppActivity.findViewById(2131301286));
      this.jdField_b_of_type_AndroidViewView = this.jdField_b_of_type_AndroidAppActivity.findViewById(2131297459);
      this.jdField_a_of_type_Apun = a();
      if (this.jdField_a_of_type_Apun != null) {
        this.jdField_a_of_type_Apun.a(this.jdField_b_of_type_AndroidAppActivity, this, this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_Apvk = a();
      if (this.jdField_a_of_type_Apvk != null) {
        this.jdField_a_of_type_Apvk.a(this.jdField_b_of_type_AndroidAppActivity, this);
      }
      this.jdField_a_of_type_ComTencentMobileqqGalleryViewGalleryBaseAdapter = a(this.jdField_b_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqGalleryViewGalleryBaseAdapter.a(this.jdField_a_of_type_Aptf);
      if (this.jdField_a_of_type_Apvk != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqGalleryViewGalleryBaseAdapter.a(this.jdField_a_of_type_Apvk);
        this.jdField_a_of_type_Apvk.a();
      }
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqGalleryViewGalleryBaseAdapter);
      this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(this.jdField_b_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131165934));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(this);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemRotateListener(this);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnScollListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      return;
      paramViewGroup.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetGallery != null) && (this.jdField_a_of_type_ComTencentWidgetGallery.getVisibility() != 0)) {
      this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
  }
  
  public boolean c()
  {
    if (f())
    {
      a().a(this);
      e(a().c());
    }
    for (;;)
    {
      return false;
      e();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Aptf != null) && (a().b) && (this.jdField_a_of_type_ComTencentWidgetGallery != null)) {
      this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(4);
    }
    if (this.jdField_a_of_type_Apun != null) {
      this.jdField_a_of_type_Apun.a(4);
    }
    if ((this.jdField_a_of_type_Apvk != null) && (this.jdField_a_of_type_Apvk.a())) {
      this.jdField_a_of_type_Apvk.b();
    }
    if (this.jdField_a_of_type_ComTencentWidgetGallery != null) {
      this.jdField_a_of_type_ComTencentWidgetGallery.e();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView.getAnimation() != null) {
      this.jdField_b_of_type_AndroidViewView.clearAnimation();
    }
    if (this.jdField_a_of_type_ComTencentWidgetGallery.getAnimation() != null) {
      this.jdField_a_of_type_ComTencentWidgetGallery.clearAnimation();
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setDuration(a().a());
    localAlphaAnimation.setFillAfter(true);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
      return;
    }
    localAlphaAnimation.setAnimationListener(new apuj(this));
    a().startAnimation(localAlphaAnimation);
  }
  
  public boolean d()
  {
    return true;
  }
  
  public void e()
  {
    if (this.jdField_b_of_type_AndroidAppActivity != null) {
      this.jdField_b_of_type_AndroidAppActivity.finish();
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView.getAnimation() != null) {
      this.jdField_b_of_type_AndroidViewView.clearAnimation();
    }
    if (a().getAnimation() != null) {
      a().clearAnimation();
    }
    if (paramBoolean)
    {
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setFillAfter(true);
      this.jdField_b_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
      localAlphaAnimation.setDuration(a().a());
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new befp());
    localAlphaAnimation.setDuration(a().a());
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, this.jdField_a_of_type_AndroidViewViewGroup.getWidth() / 2, this.jdField_a_of_type_AndroidViewViewGroup.getHeight() / 2);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation.setDuration(a().a());
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setAnimationListener(new apuk(this));
    this.jdField_b_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
  }
  
  public boolean e()
  {
    return true;
  }
  
  public boolean f()
  {
    return true;
  }
  
  public boolean g()
  {
    return a().a();
  }
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  protected void l()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setSystemUiVisibility(4);
  }
  
  public void n()
  {
    p();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  public void o() {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void p()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (e())
    {
      a().a(this);
      d(a().b());
      return;
    }
    q();
    c();
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentWidgetGallery != null) {
      this.jdField_a_of_type_ComTencentWidgetGallery.setBackgroundColor(-16777216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apui
 * JD-Core Version:    0.7.0.1
 */