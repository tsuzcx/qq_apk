import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;

public class aotf
  implements View.OnLongClickListener
{
  public aotf(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseRecentFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bbmf localbbmf = new bbmf();
    localbbmf.a(2131366634, paramView.getContext().getString(2131692753));
    localbbmf.a(2131364978, paramView.getContext().getString(2131691507));
    ApolloUtil.a(paramView, QfileBaseRecentFileTabView.n(this.a), localbbmf);
    this.a.a = bbcq.a(paramView, localbbmf, new aotg(this, paramView), new aoti(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aotf
 * JD-Core Version:    0.7.0.1
 */