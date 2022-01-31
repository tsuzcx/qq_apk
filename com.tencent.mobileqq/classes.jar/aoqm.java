import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class aoqm
  implements View.OnLongClickListener
{
  public aoqm(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseCloudFileTabView.b(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bblr localbblr = new bblr();
    localbblr.a(2131364979, paramView.getContext().getString(2131691507));
    this.a.a = bbcc.a(paramView, localbblr, new aoqn(this, paramView), new aoqo(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoqm
 * JD-Core Version:    0.7.0.1
 */