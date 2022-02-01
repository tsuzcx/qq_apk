package com.tencent.common.galleryactivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public abstract class AbstractImageListScene
  extends ImageScene
  implements AnimationLister
{
  int jdField_a_of_type_Int;
  public Activity a;
  protected Dialog a;
  protected View a;
  protected ImageView a;
  protected RelativeLayout a;
  protected TextView a;
  protected AbstractAnimationManager a;
  public AbstractImageAdapter a;
  protected AbstractImageListModel a;
  AnimationLister jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister = new AbstractImageListScene.6(this);
  public QQCustomDialog a;
  public GestureSelectGridView a;
  protected boolean a;
  private int b;
  protected ImageView b;
  protected TextView b;
  public boolean b;
  private int c;
  protected ImageView c;
  protected TextView c;
  private int d;
  protected TextView d;
  
  public AbstractImageListScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel = paramAbstractImageListModel;
  }
  
  private void c(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561078, null));
    if (paramViewGroup == null) {
      this.jdField_a_of_type_AndroidAppActivity.addContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131379432));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131364824));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131377712));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131367401));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131377437));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131381891));
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131362583);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131364606));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131362476));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(4);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(a());
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(a());
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719524);
      q();
      r();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      return;
      paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0);
    }
  }
  
  private void p()
  {
    ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window")).getDefaultDisplay();
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297499);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297500);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297501);
    this.jdField_a_of_type_Int = ((ViewUtils.a() - this.jdField_d_of_type_Int * 2 - this.jdField_b_of_type_Int * 3) / 4);
  }
  
  private void q()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      if ((this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager == null) || (!this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.jdField_b_of_type_Boolean)) {
        break label129;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText("");
      ((ViewGroup.MarginLayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams()).setMargins(AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new AbstractImageListScene.1(this));
    }
    for (;;)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690022);
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(a());
      }
      return;
      label129:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131689920);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new AbstractImageListScene.2(this));
    }
  }
  
  private void r()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AbstractImageListScene.3(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new AbstractImageListScene.4(this));
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new AbstractImageListScene.5(this));
      }
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public Rect a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.b();
    View localView = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(j - i);
    if (localView != null) {
      return AnimationUtils.a(localView);
    }
    return null;
  }
  
  protected abstract View.OnClickListener a();
  
  protected abstract AbstractImageAdapter a(Activity paramActivity, int paramInt);
  
  protected abstract AdapterView.OnItemClickListener a();
  
  protected abstract GestureSelectGridView.OnSelectListener a();
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a(this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractAnimationManager = this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
    p();
    c(paramViewGroup);
  }
  
  public void d() {}
  
  public boolean e()
  {
    d();
    this.jdField_a_of_type_AndroidAppActivity.finish();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772061, 2130772053);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130771979, 2130771980);
    }
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void j()
  {
    super.j();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = null;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel = null;
  }
  
  protected abstract void k();
  
  protected abstract void l();
  
  public void m()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AIOGalleryActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImmerseTest", 2, "imagelist setColor blue");
      }
      int i;
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        i = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
        if (localLayoutParams != null) {
          localLayoutParams.setMargins(0, i, 0, 0);
        }
        if ((this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager != null) && (this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.jdField_a_of_type_AndroidViewViewGroup != null) && (Build.VERSION.SDK_INT >= 16)) {
          this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.jdField_a_of_type_AndroidViewViewGroup.setSystemUiVisibility(0);
        }
      }
      if (((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp != null)
      {
        i = this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167091);
        ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusColor(i);
        ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusBarColor(i);
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719524);
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "imagelist onstart");
    }
  }
  
  public void n()
  {
    super.n();
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "imagelist onStop");
    }
  }
  
  protected abstract void o();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractImageListScene
 * JD-Core Version:    0.7.0.1
 */