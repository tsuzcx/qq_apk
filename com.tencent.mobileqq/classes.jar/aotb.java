import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;

public class aotb
  implements View.OnLongClickListener
{
  public aotb(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseRecentFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bblr localbblr = new bblr();
    localbblr.a(2131366634, paramView.getContext().getString(2131692752));
    localbblr.a(2131364979, paramView.getContext().getString(2131691507));
    ApolloUtil.a(paramView, QfileBaseRecentFileTabView.n(this.a), localbblr);
    this.a.a = bbcc.a(paramView, localbblr, new aotc(this, paramView), new aote(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aotb
 * JD-Core Version:    0.7.0.1
 */