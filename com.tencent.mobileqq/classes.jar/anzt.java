import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class anzt
  implements View.OnLongClickListener
{
  public anzt(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseCloudFileTabView.b(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bakh localbakh = new bakh();
    localbakh.a(2131299411, paramView.getContext().getString(2131625931));
    this.a.a = baay.a(paramView, localbakh, new anzu(this, paramView), new anzv(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anzt
 * JD-Core Version:    0.7.0.1
 */