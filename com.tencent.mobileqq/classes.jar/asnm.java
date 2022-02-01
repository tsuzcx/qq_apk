import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo.MiniApp;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import java.lang.ref.WeakReference;

class asnm
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  MiniAppRecommInfo.MiniApp jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo$MiniApp;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  
  public asnm(Activity paramActivity, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371441));
    if ((this.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
      ((ThemeImageView)this.jdField_a_of_type_AndroidWidgetImageView).setMaskShape(blfw.c);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371442));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(MiniAppRecommInfo.MiniApp paramMiniApp)
  {
    if (paramMiniApp == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo$MiniApp = paramMiniApp;
    Drawable localDrawable = MiniAppUtils.getIcon(this.jdField_a_of_type_AndroidWidgetImageView.getContext(), paramMiniApp.c, true, 2130841184, 48);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMiniApp.b);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo$MiniApp != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo$MiniApp.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo != null))
    {
      MiniAppConfig localMiniAppConfig = new MiniAppConfig(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo$MiniApp.jdField_a_of_type_ComTencentMobileqqMiniApkgMiniAppInfo);
      localMiniAppConfig.launchParam = new LaunchParam();
      localMiniAppConfig.launchParam.scene = 2065;
      MiniAppController.startApp((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localMiniAppConfig, null);
      asnl.a(102, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanMiniAppRecommInfo$MiniApp.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnm
 * JD-Core Version:    0.7.0.1
 */