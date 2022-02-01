import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class atdk
  implements View.OnLongClickListener
{
  public atdk(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseLocalFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bhjq localbhjq = new bhjq();
    localbhjq.a(2131367216, paramView.getContext().getString(2131692550));
    localbhjq.a(2131365469, paramView.getContext().getString(2131691448));
    this.a.a = bhcw.a(paramView, localbhjq, new atdl(this, paramView), new atdn(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdk
 * JD-Core Version:    0.7.0.1
 */