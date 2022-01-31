import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;

public class aqmd
  implements View.OnLongClickListener
{
  public aqmd(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseRecentFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bdkz localbdkz = new bdkz();
    localbdkz.a(2131366752, paramView.getContext().getString(2131692835));
    localbdkz.a(2131365063, paramView.getContext().getString(2131691561));
    ApolloUtil.a(paramView, QfileBaseRecentFileTabView.n(this.a), localbdkz);
    this.a.a = bdbk.a(paramView, localbdkz, new aqme(this, paramView), new aqmg(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqmd
 * JD-Core Version:    0.7.0.1
 */