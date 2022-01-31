import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class aqlh
  implements View.OnLongClickListener
{
  public aqlh(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseLocalFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bdkz localbdkz = new bdkz();
    localbdkz.a(2131366752, paramView.getContext().getString(2131692835));
    localbdkz.a(2131365063, paramView.getContext().getString(2131691561));
    this.a.a = bdbk.a(paramView, localbdkz, new aqli(this, paramView), new aqlk(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqlh
 * JD-Core Version:    0.7.0.1
 */