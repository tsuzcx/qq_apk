import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;

public class aqqm
  implements View.OnLongClickListener
{
  public aqqm(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseRecentFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bdpi localbdpi = new bdpi();
    localbdpi.a(2131366762, paramView.getContext().getString(2131692837));
    localbdpi.a(2131365065, paramView.getContext().getString(2131691562));
    ApolloUtil.a(paramView, QfileBaseRecentFileTabView.n(this.a), localbdpi);
    this.a.a = bdft.a(paramView, localbdpi, new aqqn(this, paramView), new aqqp(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqm
 * JD-Core Version:    0.7.0.1
 */