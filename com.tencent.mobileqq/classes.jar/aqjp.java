import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class aqjp
  implements View.OnLongClickListener
{
  public aqjp(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseCloudFileTabView.b(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bdkz localbdkz = new bdkz();
    localbdkz.a(2131365063, paramView.getContext().getString(2131691561));
    this.a.a = bdbk.a(paramView, localbdkz, new aqjq(this, paramView), new aqjr(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqjp
 * JD-Core Version:    0.7.0.1
 */