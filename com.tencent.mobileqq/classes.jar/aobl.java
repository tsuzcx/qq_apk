import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class aobl
  implements View.OnLongClickListener
{
  public aobl(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseLocalFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bakh localbakh = new bakh();
    localbakh.a(2131301023, paramView.getContext().getString(2131627114));
    localbakh.a(2131299411, paramView.getContext().getString(2131625931));
    this.a.a = baay.a(paramView, localbakh, new aobm(this, paramView), new aobo(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aobl
 * JD-Core Version:    0.7.0.1
 */