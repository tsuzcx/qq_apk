import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class bafq
  implements bafu
{
  public bafq(InterestSwitchEditActivity paramInterestSwitchEditActivity) {}
  
  public void a(@NotNull View paramView, bagn parambagn)
  {
    if (bnrf.a(paramView)) {
      return;
    }
    InterestSwitchEditActivity.a(this.a, parambagn);
    InterestSwitchEditActivity.b(this.a, parambagn);
  }
  
  public void b(@NotNull View paramView, @Nullable bagn parambagn)
  {
    int j = 0;
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694253, 0).b(this.a.getTitleBarHeight());
    }
    while (parambagn == null) {
      return;
    }
    if (parambagn.b()) {}
    for (int i = 1;; i = 0)
    {
      if (bagq.a.a(parambagn.b())) {
        if (i != 0) {}
      }
      for (j = 1;; j = i)
      {
        if ((parambagn.b() == 42340) && (j == 1) && (QQPlayerService.a())) {
          QQPlayerService.c(BaseApplicationImpl.getContext());
        }
        InterestSwitchEditActivity.a(this.a, parambagn, j);
        InterestSwitchEditActivity.c(this.a, parambagn);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafq
 * JD-Core Version:    0.7.0.1
 */