import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;

public class asaf
  implements View.OnLongClickListener
{
  public asaf(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseRecentFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bgaz localbgaz = new bgaz();
    localbgaz.a(2131367097, paramView.getContext().getString(2131692448));
    localbgaz.a(2131365376, paramView.getContext().getString(2131691363));
    ApolloUtil.a(paramView, QfileBaseRecentFileTabView.n(this.a), localbgaz);
    this.a.a = bfue.a(paramView, localbgaz, new asag(this, paramView), new asai(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asaf
 * JD-Core Version:    0.7.0.1
 */