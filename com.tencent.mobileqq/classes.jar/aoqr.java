import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class aoqr
  implements View.OnLongClickListener
{
  public aoqr(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseCloudFileTabView.b(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bbmf localbbmf = new bbmf();
    localbbmf.a(2131364978, paramView.getContext().getString(2131691507));
    this.a.a = bbcq.a(paramView, localbbmf, new aoqs(this, paramView), new aoqt(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoqr
 * JD-Core Version:    0.7.0.1
 */