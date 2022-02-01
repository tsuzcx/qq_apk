import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class azrm
  implements azrq
{
  public azrm(InterestSwitchEditActivity paramInterestSwitchEditActivity) {}
  
  public void a(@NotNull View paramView, azsj paramazsj)
  {
    if (bnyz.a(paramView)) {
      return;
    }
    InterestSwitchEditActivity.a(this.a, paramazsj);
    InterestSwitchEditActivity.b(this.a, paramazsj);
  }
  
  public void b(@NotNull View paramView, @Nullable azsj paramazsj)
  {
    int j = 0;
    if (!bgnt.d(BaseApplication.getContext())) {
      QQToast.a(BaseApplicationImpl.sApplication, 2131693946, 0).b(this.a.getTitleBarHeight());
    }
    while (paramazsj == null) {
      return;
    }
    if (paramazsj.b()) {}
    for (int i = 1;; i = 0)
    {
      if (azsm.a.a(paramazsj.b())) {
        if (i != 0) {}
      }
      for (j = 1;; j = i)
      {
        if ((paramazsj.b() == 42340) && (j == 1) && (QQPlayerService.a())) {
          QQPlayerService.c(BaseApplicationImpl.getContext());
        }
        InterestSwitchEditActivity.a(this.a, paramazsj, j);
        InterestSwitchEditActivity.c(this.a, paramazsj);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azrm
 * JD-Core Version:    0.7.0.1
 */