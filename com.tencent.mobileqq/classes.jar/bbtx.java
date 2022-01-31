import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;

public class bbtx
  implements View.OnClickListener
{
  public bbtx(HealthBusinessPlugin paramHealthBusinessPlugin, bbuf parambbuf, IVideoViewBase paramIVideoViewBase, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d)
    {
      this.jdField_a_of_type_Bbuf.c.setImageResource(2130841326);
      ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).setOnTouchListener(new bbty(this));
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().findViewById(2131375329).setVisibility(8);
      if (((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().findViewById(16908290).getParent().getParent()).getChildAt(1) != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().findViewById(16908290).getParent().getParent()).getChildAt(1).setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getWindow().setFlags(1024, 1024);
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().setRequestedOrientation(0);
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getWindow().setFlags(1024, 1024);
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.k = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getScrollX();
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.l = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getScrollY();
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().scrollTo(0, 0);
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_AndroidWidgetFrameLayout.scrollTo(0, 0);
      paramView = ((ViewGroup)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getLayoutParams();
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.g = paramView.height;
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.f = paramView.width;
      paramView.width = -1;
      paramView.height = -1;
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_Int = ((FrameLayout.LayoutParams)paramView).topMargin;
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.b = ((FrameLayout.LayoutParams)paramView).leftMargin;
      ((FrameLayout.LayoutParams)paramView).topMargin = 0;
      ((FrameLayout.LayoutParams)paramView).leftMargin = 0;
      i = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getResources().getDisplayMetrics().widthPixels;
      j = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getResources().getDisplayMetrics().heightPixels;
      QLog.d("HealthBusinessPlugin", 2, "FullScreenWidth ScreenWidth:" + i);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = j;
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.h = ((FrameLayout.LayoutParams)localObject).width;
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.i = ((FrameLayout.LayoutParams)localObject).height;
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.j = ((FrameLayout.LayoutParams)localObject).topMargin;
      ((FrameLayout.LayoutParams)localObject).topMargin = 0;
      ((FrameLayout.LayoutParams)localObject).width = j;
      ((FrameLayout.LayoutParams)localObject).height = i;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      ((ViewGroup)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).setLayoutParams(paramView);
      this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d = true;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().findViewById(2131375329).setVisibility(0);
    if (((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().findViewById(16908290).getParent().getParent()).getChildAt(1) != null) {
      ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().findViewById(16908290).getParent().getParent()).getChildAt(1).setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getWindow().setFlags(1024, 8);
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().setVisibility(0);
    this.jdField_a_of_type_Bbuf.c.setImageResource(2130841325);
    ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).setOnTouchListener(null);
    paramView = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getWindow().getAttributes();
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().setRequestedOrientation(1);
    paramView.flags &= 0xFFFFFBFF;
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getWindow().setAttributes(paramView);
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getWindow().clearFlags(512);
    paramView = ((ViewGroup)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getLayoutParams();
    ((FrameLayout.LayoutParams)paramView).topMargin = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_Int;
    ((FrameLayout.LayoutParams)paramView).leftMargin = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.b;
    paramView.height = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.g;
    paramView.width = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.f;
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().scrollTo(this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.k, this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.l);
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_AndroidWidgetFrameLayout.scrollTo(this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.k, this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.l + this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_ComTencentBizUiTouchWebView.mTotalYoffset);
    int i = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getResources().getDisplayMetrics().widthPixels;
    int j = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.mRuntime.a().getResources().getDisplayMetrics().heightPixels;
    QLog.d("HealthBusinessPlugin", 2, "onBACKFullScreenWidth ScreenWidth:" + i);
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = i;
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).width = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.h;
    ((FrameLayout.LayoutParams)localObject).height = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.i;
    ((FrameLayout.LayoutParams)localObject).topMargin = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.j;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    ((ViewGroup)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).setLayoutParams(paramView);
    this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbtx
 * JD-Core Version:    0.7.0.1
 */