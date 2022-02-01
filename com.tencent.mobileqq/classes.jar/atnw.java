import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;

public class atnw
  implements View.OnLongClickListener
{
  public atnw(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseRecentFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bhuk localbhuk = new bhuk();
    localbhuk.a(2131367081, paramView.getContext().getString(2131692400));
    localbhuk.a(2131365346, paramView.getContext().getString(2131691323));
    ApolloUtil.a(paramView, QfileBaseRecentFileTabView.n(this.a), localbhuk);
    this.a.a = bhkx.a(paramView, localbhuk, new atnx(this, paramView), new atnz(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atnw
 * JD-Core Version:    0.7.0.1
 */