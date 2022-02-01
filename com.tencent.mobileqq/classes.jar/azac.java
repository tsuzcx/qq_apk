import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class azac
  implements azag
{
  public azac(InterestSwitchEditActivity paramInterestSwitchEditActivity) {}
  
  public void a(@NotNull View paramView, azaz paramazaz)
  {
    if (bmbv.a(paramView)) {
      return;
    }
    InterestSwitchEditActivity.a(this.a, paramazaz);
    InterestSwitchEditActivity.b(this.a, paramazaz);
  }
  
  public void b(@NotNull View paramView, @Nullable azaz paramazaz)
  {
    int j = 0;
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694062, 0).b(this.a.getTitleBarHeight());
    }
    while (paramazaz == null) {
      return;
    }
    if (paramazaz.b()) {}
    for (int i = 1;; i = 0)
    {
      if (azbc.a.a(paramazaz.b())) {
        if (i != 0) {}
      }
      for (j = 1;; j = i)
      {
        if ((paramazaz.b() == 42340) && (j == 1) && (QQPlayerService.a())) {
          QQPlayerService.c(BaseApplicationImpl.getContext());
        }
        InterestSwitchEditActivity.a(this.a, paramazaz, j);
        InterestSwitchEditActivity.c(this.a, paramazaz);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azac
 * JD-Core Version:    0.7.0.1
 */