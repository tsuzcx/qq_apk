import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class atar
  implements View.OnLongClickListener
{
  public atar(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseCloudFileTabView.b(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bhjq localbhjq = new bhjq();
    localbhjq.a(2131365469, paramView.getContext().getString(2131691448));
    this.a.a = bhcw.a(paramView, localbhjq, new atas(this, paramView), new atat(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atar
 * JD-Core Version:    0.7.0.1
 */