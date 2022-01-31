import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;

public class aoch
  implements View.OnLongClickListener
{
  public aoch(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseRecentFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bakh localbakh = new bakh();
    localbakh.a(2131301023, paramView.getContext().getString(2131627114));
    localbakh.a(2131299411, paramView.getContext().getString(2131625931));
    ApolloUtil.a(paramView, QfileBaseRecentFileTabView.n(this.a), localbakh);
    this.a.a = baay.a(paramView, localbakh, new aoci(this, paramView), new aock(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoch
 * JD-Core Version:    0.7.0.1
 */