import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class aswr
  implements View.OnLongClickListener
{
  public aswr(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseLocalFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bguh localbguh = new bguh();
    localbguh.a(2131367030, paramView.getContext().getString(2131692395));
    localbguh.a(2131365302, paramView.getContext().getString(2131691320));
    this.a.a = bgkw.a(paramView, localbguh, new asws(this, paramView), new aswu(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswr
 * JD-Core Version:    0.7.0.1
 */