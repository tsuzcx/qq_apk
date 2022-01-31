import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class aqny
  implements View.OnLongClickListener
{
  public aqny(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseCloudFileTabView.b(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bdpi localbdpi = new bdpi();
    localbdpi.a(2131365065, paramView.getContext().getString(2131691562));
    this.a.a = bdft.a(paramView, localbdpi, new aqnz(this, paramView), new aqoa(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqny
 * JD-Core Version:    0.7.0.1
 */