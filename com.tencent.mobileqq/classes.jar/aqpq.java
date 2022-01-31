import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class aqpq
  implements View.OnLongClickListener
{
  public aqpq(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseLocalFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bdpi localbdpi = new bdpi();
    localbdpi.a(2131366762, paramView.getContext().getString(2131692837));
    localbdpi.a(2131365065, paramView.getContext().getString(2131691562));
    this.a.a = bdft.a(paramView, localbdpi, new aqpr(this, paramView), new aqpt(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpq
 * JD-Core Version:    0.7.0.1
 */