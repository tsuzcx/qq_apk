import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class asty
  implements View.OnLongClickListener
{
  public asty(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseCloudFileTabView.b(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bguh localbguh = new bguh();
    localbguh.a(2131365302, paramView.getContext().getString(2131691320));
    this.a.a = bgkw.a(paramView, localbguh, new astz(this, paramView), new asua(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asty
 * JD-Core Version:    0.7.0.1
 */