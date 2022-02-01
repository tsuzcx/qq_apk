import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;

public class atel
  implements View.OnLongClickListener
{
  public atel(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseRecentFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bhjq localbhjq = new bhjq();
    localbhjq.a(2131367216, paramView.getContext().getString(2131692550));
    localbhjq.a(2131365469, paramView.getContext().getString(2131691448));
    ApolloUtil.a(paramView, QfileBaseRecentFileTabView.n(this.a), localbhjq);
    this.a.a = bhcw.a(paramView, localbhjq, new atem(this, paramView), new ateo(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atel
 * JD-Core Version:    0.7.0.1
 */