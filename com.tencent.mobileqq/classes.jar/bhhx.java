import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.ui.MainPageFragment;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;

public class bhhx
  implements View.OnLongClickListener
{
  public bhhx(MainPageFragment paramMainPageFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView.getId() == 2131370612) && (GameWnsUtils.enablePersistentDebugVersion()) && (MainPageFragment.a(this.a) != null))
    {
      paramView = MiniAppEnv.g().getContext().getApplicationContext().getSharedPreferences("persistent_debug_version_" + this.a.a(), 4);
      if (paramView.getBoolean("persistent", false))
      {
        paramView.edit().remove("persistent").apply();
        QMLog.e("MainPageFragment", "close persistent debug version");
        Toast.makeText(this.a.getActivity(), this.a.getResources().getString(2131694333), 1).show();
      }
    }
    else
    {
      return false;
    }
    paramView.edit().putBoolean("persistent", true).apply();
    QMLog.e("MainPageFragment", "open persistent debug version");
    Toast.makeText(this.a.getActivity(), this.a.getResources().getString(2131694337), 1).show();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhx
 * JD-Core Version:    0.7.0.1
 */