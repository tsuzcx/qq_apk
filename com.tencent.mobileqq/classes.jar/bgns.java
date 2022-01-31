import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqmini.sdk.core.widget.TabBar;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo.ButtonInfo;

public class bgns
  implements View.OnClickListener
{
  public bgns(TabBar paramTabBar, int paramInt, TabBarInfo.ButtonInfo paramButtonInfo) {}
  
  public void onClick(View paramView)
  {
    if (TabBar.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar) != null) {
      TabBar.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetTabBar).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo$ButtonInfo.pagePath, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelTabBarInfo$ButtonInfo.text);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgns
 * JD-Core Version:    0.7.0.1
 */