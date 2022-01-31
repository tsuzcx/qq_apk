import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class aosj
  implements View.OnLongClickListener
{
  public aosj(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseLocalFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bbmf localbbmf = new bbmf();
    localbbmf.a(2131366634, paramView.getContext().getString(2131692753));
    localbbmf.a(2131364978, paramView.getContext().getString(2131691507));
    this.a.a = bbcq.a(paramView, localbbmf, new aosk(this, paramView), new aosm(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosj
 * JD-Core Version:    0.7.0.1
 */