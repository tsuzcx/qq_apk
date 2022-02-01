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
  protected Activity a;
  protected Dialog a;
  protected View a;
  protected ImageView a;
  protected RelativeLayout a;
  protected TextView a;
  protected AbstractAnimationManager a;
  public AbstractImageAdapter a;
  protected AbstractImageListModel a;
  AnimationLister jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister = new AbstractImageListScene.6(this);
  protected QQCustomDialog a;
  protected GestureSelectGridView a;
  protected boolean a;
  private int b;
  protected ImageView b;
  protected TextView b;
  protected boolean b;
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560942, null));
    if (paramViewGroup == null) {
      this.jdField_a_of_type_AndroidAppActivity.addContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
    } else {
      paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0);
    }
    b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131378784));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131363523));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131377140));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131367183));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131376884));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131381103));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131362539);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131364493));
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131362432));
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(4);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(this.jdField_c_of_type_Int);
    paramViewGroup = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView;
    paramViewGroup.setPadding(this.jdField_d_of_type_Int, paramViewGroup.getPaddingTop(), this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(a());
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(a());
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719242);
    q();
    r();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
  }
  
  private void p()
  {
    ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window")).getDefaultDisplay();
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297488);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297489);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297490);
    this.jdField_a_of_type_Int = ((ViewUtils.a() - this.jdField_d_of_type_Int * 2 - this.jdField_b_of_type_Int * 3) / 4);
  }
  
  private void q()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      if ((this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager != null) && (this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.jdField_b_of_type_Boolean))
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText("");
        ((ViewGroup.MarginLayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams()).setMargins(AIOUtils.b(16.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, 0, 0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new AbstractImageListScene.1(this));
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131689834);
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new AbstractImageListScene.2(this));
      }
    }
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      localTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131689937);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(a());
    }
  }
  
  private void r()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    } else {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AbstractImageListScene.3(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new AbstractImageListScene.4(this));
    ImageView localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setOnClickListener(new AbstractImageListScene.5(this));
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
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772083, 2130772075);
    } else {
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130771991, 2130771992);
    }
    return true;
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
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
        if (localObject != null)
        {
          localObject = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
          i = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
          if (localObject != null) {
            ((RelativeLayout.LayoutParams)localObject).setMargins(0, i, 0, 0);
          }
          if ((this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager != null) && (this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.jdField_a_of_type_AndroidViewViewGroup != null) && (Build.VERSION.SDK_INT >= 16)) {
            this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.jdField_a_of_type_AndroidViewViewGroup.setSystemUiVisibility(0);
          }
        }
      }
      if (((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).a != null)
      {
        i = this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167114);
        ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).a.setStatusColor(i);
        ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).a.setStatusBarColor(i);
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719242);
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractImageListScene
 * JD-Core Version:    0.7.0.1
 */