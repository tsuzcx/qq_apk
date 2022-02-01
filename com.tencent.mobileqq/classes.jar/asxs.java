import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;

public class asxs
  implements View.OnLongClickListener
{
  public asxs(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseRecentFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bguh localbguh = new bguh();
    localbguh.a(2131367030, paramView.getContext().getString(2131692395));
    localbguh.a(2131365302, paramView.getContext().getString(2131691320));
    ApolloUtil.a(paramView, QfileBaseRecentFileTabView.n(this.a), localbguh);
    this.a.a = bgkw.a(paramView, localbguh, new asxt(this, paramView), new asxv(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxs
 * JD-Core Version:    0.7.0.1
 */