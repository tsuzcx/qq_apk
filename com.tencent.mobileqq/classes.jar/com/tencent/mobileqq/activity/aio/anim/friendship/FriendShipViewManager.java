package com.tencent.mobileqq.activity.aio.anim.friendship;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.HotReactiveHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.surfaceviewaction.gl.ImageButton.OnClickListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import utj;
import utk;
import utl;

public class FriendShipViewManager
{
  Activity jdField_a_of_type_AndroidAppActivity;
  Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  public ImageView a;
  private FriendShipLayout.OnBackClickListener jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipLayout$OnBackClickListener = new utk(this);
  public FriendShipLayout a;
  public FriendShipWaveView a;
  private ImageButton.OnClickListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener = new utl(this);
  String jdField_a_of_type_JavaLangString = "aio_ship_ship.png";
  boolean jdField_a_of_type_Boolean = false;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  String jdField_b_of_type_JavaLangString = "aio_ship_banner.png";
  Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  String jdField_c_of_type_JavaLangString = "aio_ship_blink.png";
  Bitmap jdField_d_of_type_AndroidGraphicsBitmap;
  String jdField_d_of_type_JavaLangString = "aio_ship_close.png";
  Bitmap jdField_e_of_type_AndroidGraphicsBitmap;
  String jdField_e_of_type_JavaLangString = "aio_ship_star1.png";
  Bitmap jdField_f_of_type_AndroidGraphicsBitmap;
  String jdField_f_of_type_JavaLangString = "aio_ship_star2.png";
  Bitmap jdField_g_of_type_AndroidGraphicsBitmap;
  String jdField_g_of_type_JavaLangString = "aio_ship_star3.png";
  Bitmap jdField_h_of_type_AndroidGraphicsBitmap;
  String jdField_h_of_type_JavaLangString = "aio_ship_star4.png";
  Bitmap jdField_i_of_type_AndroidGraphicsBitmap;
  String jdField_i_of_type_JavaLangString = "aio_ship_wave1.png";
  Bitmap jdField_j_of_type_AndroidGraphicsBitmap;
  String jdField_j_of_type_JavaLangString = "aio_ship_wave2.png";
  Bitmap jdField_k_of_type_AndroidGraphicsBitmap;
  String jdField_k_of_type_JavaLangString = "aio_ship_wave3.png";
  Bitmap jdField_l_of_type_AndroidGraphicsBitmap;
  String jdField_l_of_type_JavaLangString = "aio_ship_wording.png";
  
  public FriendShipViewManager(Activity paramActivity, Context paramContext)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window"));
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipWaveView.a(paramInt1, paramInt2, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlImageButton$OnClickListener, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_c_of_type_AndroidGraphicsBitmap, this.jdField_d_of_type_AndroidGraphicsBitmap, this.jdField_e_of_type_AndroidGraphicsBitmap, this.jdField_f_of_type_AndroidGraphicsBitmap, this.jdField_g_of_type_AndroidGraphicsBitmap, this.jdField_h_of_type_AndroidGraphicsBitmap, this.jdField_i_of_type_AndroidGraphicsBitmap, this.jdField_j_of_type_AndroidGraphicsBitmap, this.jdField_k_of_type_AndroidGraphicsBitmap, this.jdField_l_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipWaveView.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipLayout = new FriendShipLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipLayout.setBackListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipLayout$OnBackClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipWaveView = new FriendShipWaveView(this.jdField_a_of_type_AndroidContentContext, null);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipWaveView);
    int m;
    if (Build.VERSION.SDK_INT >= 21)
    {
      m = 2005;
      if (Build.VERSION.SDK_INT < 19) {
        break label155;
      }
    }
    label155:
    for (int n = 67109888;; n = 1024)
    {
      WindowManager.LayoutParams localLayoutParams1 = new WindowManager.LayoutParams(-1, -1, m, n, -2);
      localLayoutParams.gravity = 51;
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipLayout, localLayoutParams1);
      return;
      m = 2;
      break;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
    this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new utj(this), 1000L);
  }
  
  @TargetApi(9)
  public boolean a()
  {
    String str = HotReactiveHelper.b();
    if (FileUtils.a(str)) {}
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inScaled = true;
        localOptions.inDensity = 320;
        localOptions.inTargetDensity = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().densityDpi;
        this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(str + this.jdField_a_of_type_JavaLangString, localOptions);
        this.jdField_b_of_type_AndroidGraphicsBitmap = ImageUtil.a(str + this.jdField_b_of_type_JavaLangString, localOptions);
        this.jdField_c_of_type_AndroidGraphicsBitmap = ImageUtil.a(str + this.jdField_c_of_type_JavaLangString, localOptions);
        this.jdField_d_of_type_AndroidGraphicsBitmap = ImageUtil.a(str + this.jdField_d_of_type_JavaLangString, localOptions);
        this.jdField_e_of_type_AndroidGraphicsBitmap = ImageUtil.a(str + this.jdField_e_of_type_JavaLangString, localOptions);
        this.jdField_f_of_type_AndroidGraphicsBitmap = ImageUtil.a(str + this.jdField_f_of_type_JavaLangString, localOptions);
        this.jdField_g_of_type_AndroidGraphicsBitmap = ImageUtil.a(str + this.jdField_g_of_type_JavaLangString, localOptions);
        this.jdField_h_of_type_AndroidGraphicsBitmap = ImageUtil.a(str + this.jdField_h_of_type_JavaLangString, localOptions);
        this.jdField_i_of_type_AndroidGraphicsBitmap = ImageUtil.a(str + this.jdField_i_of_type_JavaLangString, localOptions);
        this.jdField_j_of_type_AndroidGraphicsBitmap = ImageUtil.a(str + this.jdField_j_of_type_JavaLangString, localOptions);
        this.jdField_k_of_type_AndroidGraphicsBitmap = ImageUtil.a(str + this.jdField_k_of_type_JavaLangString, localOptions);
        this.jdField_l_of_type_AndroidGraphicsBitmap = ImageUtil.a(str + this.jdField_l_of_type_JavaLangString, localOptions);
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (this.jdField_d_of_type_AndroidGraphicsBitmap != null) && (this.jdField_i_of_type_AndroidGraphicsBitmap != null) && (this.jdField_j_of_type_AndroidGraphicsBitmap != null) && (this.jdField_k_of_type_AndroidGraphicsBitmap != null))
        {
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d("FriendShipViewManager", 2, "checkImageRes isResOk=" + this.jdField_a_of_type_Boolean);
          }
          return this.jdField_a_of_type_Boolean;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendShipViewManager", 2, "checkImageRes bitmap is null");
        continue;
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_Boolean = false;
        QLog.e("FriendShipViewManager", 4, localException, new Object[0]);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.d("FriendShipViewManager", 2, "checkImageRes bitmap failed");
        continue;
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void b()
  {
    a(this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getWidth(), this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getHeight());
    ReportController.b(null, "dc00898", "", "", "0X8007777", "0X8007777", 0, 0, "", "", "", "");
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipLayout.setVisibility(4);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipLayout.setVisibility(0);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipWaveView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipWaveView.j();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipWaveView.n();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipLayout.removeAllViews();
    }
    if ((this.jdField_a_of_type_AndroidViewWindowManager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipLayout != null)) {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipLayout);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipWaveView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipWaveView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipFriendShipWaveView.i();
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAlphaAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.FriendShipViewManager
 * JD-Core Version:    0.7.0.1
 */