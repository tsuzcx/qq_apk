import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class aosf
  implements View.OnLongClickListener
{
  public aosf(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseLocalFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bblr localbblr = new bblr();
    localbblr.a(2131366634, paramView.getContext().getString(2131692752));
    localbblr.a(2131364979, paramView.getContext().getString(2131691507));
    this.a.a = bbcc.a(paramView, localbblr, new aosg(this, paramView), new aosi(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosf
 * JD-Core Version:    0.7.0.1
 */