import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenStatusReceiver;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingWatchTogetherWrapper.2;
import com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingWatchTogetherWrapper.3;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bjgc
  extends bjfv
  implements awuy, bjfj, IVideoOuterStatusListener
{
  private IVideoInnerStatusListener a;
  private ImageView b;
  
  bjgc(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.setOnDragListener(this);
  }
  
  private void f()
  {
    View localView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374498);
    localView.setContentDescription("一起看悬浮窗");
    if (blqj.a())
    {
      localView.setBackgroundColor(Color.parseColor("#4D000000"));
      return;
    }
    localView.setBackgroundColor(Color.parseColor("#00000000"));
  }
  
  public int a(FloatingScreenParams paramFloatingScreenParams, View paramView)
  {
    FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
    if (paramFloatingScreenParams == null)
    {
      if (this.jdField_a_of_type_AndroidContentContext != null) {
        localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(1).build();
      }
    }
    else
    {
      paramFloatingScreenParams = new FloatingWatchTogetherWrapper.2(this, paramView, localFloatingScreenParams);
      ThreadManager.getUIHandlerV2().postDelayed(paramFloatingScreenParams, 500L);
      return 0;
    }
    return 2;
  }
  
  public IVideoOuterStatusListener a(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener = paramIVideoInnerStatusListener;
    return this;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingWatchTogetherWrapper", 2, new Object[] { "onThemeChanged: invoked. ", " TAG: ", "FloatingWatchTogetherWrapper" });
    }
    f();
  }
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("关闭一起看悬浮窗");
    this.b = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374495));
    this.b.setContentDescription(anzj.a(2131703530));
    a(new View[] { this.b });
    a(false, new View[] { this.b });
    f();
  }
  
  public void a(FloatingScreenParams paramFloatingScreenParams)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("qqfs_floating_sp", 4);
    int i = localSharedPreferences.getInt("KEY_QQFS_WATCH_TOGETHER_CENTER_X", -2147483648);
    int j = localSharedPreferences.getInt("KEY_QQFS_WATCH_TOGETHER_CENTER_Y", -2147483648);
    if ((i != -2147483648) && (j != -2147483648))
    {
      paramFloatingScreenParams.setFloatingCenterX(i);
      paramFloatingScreenParams.setFloatingCenterY(j);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FloatingWatchTogetherWrapper", 2, new Object[] { "restoreLastCenterPosition: invoked. ", " centerX: ", Integer.valueOf(i), " centerY: ", Integer.valueOf(j) });
    }
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    FloatingWatchTogetherWrapper.3 local3 = new FloatingWatchTogetherWrapper.3(this, paramInt);
    ThreadManager.getUIHandlerV2().post(local3);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver = new FloatingScreenStatusReceiver(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver.a(2, new bjgd(this));
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.b();
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("qqfs_floating_sp", 4).edit();
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.a();
      int j = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.b();
      localEditor.putInt("KEY_QQFS_WATCH_TOGETHER_CENTER_X", i);
      localEditor.putInt("KEY_QQFS_WATCH_TOGETHER_CENTER_Y", j);
      localEditor.apply();
      if (QLog.isColorLevel()) {
        QLog.d("FloatingWatchTogetherWrapper", 2, new Object[] { "saveFloatingCenter: invoked. ", " centerX: ", Integer.valueOf(i), " centerY: ", Integer.valueOf(j), " isSmallFloating: ", Boolean.valueOf(bool) });
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131374495) {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoInnerStatusListener.notifyVideoStart();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
    }
  }
  
  public void onOrientationChange(boolean paramBoolean) {}
  
  public void onSetVideoCover(Bitmap paramBitmap) {}
  
  public void onSetVideoCover(Drawable paramDrawable) {}
  
  public void onVideoBuffering() {}
  
  public void onVideoComplete(boolean paramBoolean) {}
  
  public void onVideoError(int paramInt) {}
  
  public void onVideoProgressUpdate(int paramInt) {}
  
  public void onVideoSize(int paramInt1, int paramInt2) {}
  
  public void onVideoStart(int paramInt)
  {
    a(false, new View[] { this.b });
  }
  
  public void onVideoStop()
  {
    a(true, new View[] { this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgc
 * JD-Core Version:    0.7.0.1
 */