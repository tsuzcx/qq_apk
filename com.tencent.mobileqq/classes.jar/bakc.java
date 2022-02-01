import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class bakc
  implements bakg
{
  public bakc(InterestSwitchEditActivity paramInterestSwitchEditActivity) {}
  
  public void a(@NotNull View paramView, bakz parambakz)
  {
    if (bpak.a(paramView)) {
      return;
    }
    InterestSwitchEditActivity.a(this.a, parambakz);
    InterestSwitchEditActivity.b(this.a, parambakz);
  }
  
  public void b(@NotNull View paramView, @Nullable bakz parambakz)
  {
    int j = 0;
    if (!bhnv.d(BaseApplication.getContext())) {
      QQToast.a(BaseApplicationImpl.sApplication, 2131693963, 0).b(this.a.getTitleBarHeight());
    }
    while (parambakz == null) {
      return;
    }
    if (parambakz.b()) {}
    for (int i = 1;; i = 0)
    {
      if (balc.a.a(parambakz.b())) {
        if (i != 0) {}
      }
      for (j = 1;; j = i)
      {
        if ((parambakz.b() == 42340) && (j == 1) && (QQPlayerService.a())) {
          QQPlayerService.c(BaseApplicationImpl.getContext());
        }
        InterestSwitchEditActivity.a(this.a, parambakz, j);
        InterestSwitchEditActivity.c(this.a, parambakz);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakc
 * JD-Core Version:    0.7.0.1
 */