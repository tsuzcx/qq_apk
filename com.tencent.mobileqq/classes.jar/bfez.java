import android.content.Context;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.ui.MainPageFragment;
import java.io.File;

public class bfez
  implements View.OnLongClickListener
{
  public bfez(MainPageFragment paramMainPageFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    String str = MainPageFragment.b() + MainPageFragment.a(this.a).appId + "_debug";
    if (new File(str).exists()) {
      bekq.a(str, false);
    }
    str = MainPageFragment.c() + bfgc.c(MainPageFragment.a(this.a).appId);
    if (new File(str).exists()) {
      bekq.a(str, false);
    }
    str = paramView.getContext().getCacheDir() + File.separator + "mini" + File.separator + this.a.a() + File.separator + MainPageFragment.a(this.a).appId;
    if (new File(str).exists()) {
      bekq.a(str, false);
    }
    this.a.getActivity().finish();
    Process.killProcess(Process.myPid());
    besl.d("debug", "clear miniapp");
    Toast.makeText(paramView.getContext(), "清除游戏缓存数据成功!", 1).show();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfez
 * JD-Core Version:    0.7.0.1
 */