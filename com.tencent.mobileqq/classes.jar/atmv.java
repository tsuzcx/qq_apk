import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class atmv
  implements View.OnLongClickListener
{
  public atmv(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseLocalFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bhuk localbhuk = new bhuk();
    localbhuk.a(2131367081, paramView.getContext().getString(2131692400));
    localbhuk.a(2131365346, paramView.getContext().getString(2131691323));
    this.a.a = bhkx.a(paramView, localbhuk, new atmw(this, paramView), new atmy(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atmv
 * JD-Core Version:    0.7.0.1
 */