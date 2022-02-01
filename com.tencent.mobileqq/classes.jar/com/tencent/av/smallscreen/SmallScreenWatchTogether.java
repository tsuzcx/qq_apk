package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.av.VideoController;
import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerProxy;
import com.tencent.av.wtogether.callback.WatchTogetherUIProxy;
import com.tencent.av.wtogether.gles.WatchTogetherVideoRenderHelper;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.view.SmallScreenGLContentView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class SmallScreenWatchTogether
  extends SmallScreenItemBase
  implements WatchTogetherUIProxy
{
  private static int jdField_a_of_type_Int = 3;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private WatchTogetherVideoRenderHelper jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper;
  private SmallScreenGLContentView jdField_a_of_type_ComTencentAvWtogetherViewSmallScreenGLContentView;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean = false;
  
  public SmallScreenWatchTogether(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = "SmallScreenWatchTogether";
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 4, "SmallScreenWatchTogether construtc");
    }
    this.i = 2013396995;
    this.j = paramContext.getResources().getDimensionPixelSize(2131297976);
    this.k = paramContext.getResources().getDimensionPixelSize(2131297975);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private ActionSheet a(boolean paramBoolean)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidWidgetImageView.getContext(), null);
    if (paramBoolean) {
      localActionSheet.addButton(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getResources().getString(2131695994), 1);
    }
    localActionSheet.addButton(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getResources().getString(2131695993), 3);
    localActionSheet.addCancelButton(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getResources().getString(2131695992));
    localActionSheet.setOnButtonClickListener(new SmallScreenWatchTogether.2(this, paramBoolean));
    Window localWindow = localActionSheet.getWindow();
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      if (localLayoutParams != null) {
        if (Build.VERSION.SDK_INT >= 26) {
          localLayoutParams.type = 2038;
        } else {
          localLayoutParams.type = 2002;
        }
      }
      localWindow.setAttributes(localLayoutParams);
    }
    return localActionSheet;
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper != null) && (this.jdField_a_of_type_ComTencentAvWtogetherViewSmallScreenGLContentView != null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper = new WatchTogetherVideoRenderHelper(true);
    this.jdField_a_of_type_ComTencentAvWtogetherViewSmallScreenGLContentView = ((SmallScreenGLContentView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2013331456));
    this.jdField_a_of_type_ComTencentAvWtogetherViewSmallScreenGLContentView.setVideoRender(this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 4, "bindToVideoSink");
    }
    f();
    this.jdField_a_of_type_ComTencentAvWtogetherViewSmallScreenGLContentView.onResume();
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.a().a();
    if ((localWatchTogetherMediaPlayCtrl != null) && (localWatchTogetherMediaPlayCtrl.c())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if (localWatchTogetherMediaPlayCtrl != null)
    {
      localWatchTogetherMediaPlayCtrl.a(this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper);
      localWatchTogetherMediaPlayCtrl.a(this);
      localWatchTogetherMediaPlayCtrl.e();
    }
  }
  
  private void h()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 4, "unBindToVideoSink");
    }
    this.jdField_a_of_type_ComTencentAvWtogetherViewSmallScreenGLContentView.onPause();
    b();
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.a().a();
    if (localWatchTogetherMediaPlayCtrl != null)
    {
      localWatchTogetherMediaPlayCtrl.a("unBindToVideoSink", this.jdField_a_of_type_ComTencentAvWtogetherGlesWatchTogetherVideoRenderHelper);
      localWatchTogetherMediaPlayCtrl.b(this);
    }
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 4, "onDestroy");
    }
    this.jdField_b_of_type_Boolean = true;
    jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
    b();
    super.a();
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(Context paramContext, LayoutInflater paramLayoutInflater, SmallScreenRelativeLayout.FloatListener paramFloatListener)
  {
    super.a(paramContext, paramLayoutInflater, paramFloatListener);
    paramContext = (SmallScreenRelativeLayout)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2013331474);
    int i = AIOUtils.b(22.0F, paramContext.getResources());
    paramContext.setIntercetRect(this.j - i, 0, this.j, i, new SmallScreenWatchTogether.1(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2013331482));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2013331483));
  }
  
  public void a(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 4, "showActionSheet");
    }
    paramView = VideoController.a().a();
    if (paramView == null) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet = a(paramView.i());
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "showActionSheet fail");
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new SmallScreenWatchTogether.3(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new SmallScreenWatchTogether.4(this));
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      g();
    } else {
      h();
    }
    super.a(paramBoolean, jdField_a_of_type_Int);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean) {
        return false;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new SmallScreenWatchTogether.5(this));
    }
    return false;
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void b()
  {
    ActionSheet localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (localActionSheet != null)
    {
      localActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void setImmersiveStatus(boolean paramBoolean) {}
  
  public void setOrientationParams(int paramInt) {}
  
  public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener) {}
  
  public void setWatchTogetherMediaPlayerProxy(WatchTogetherMediaPlayerProxy paramWatchTogetherMediaPlayerProxy) {}
  
  public void setWatchTogetherParams(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenWatchTogether
 * JD-Core Version:    0.7.0.1
 */