import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class arze
  implements View.OnLongClickListener
{
  public arze(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseLocalFileTabView.a(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bgaz localbgaz = new bgaz();
    localbgaz.a(2131367097, paramView.getContext().getString(2131692448));
    localbgaz.a(2131365376, paramView.getContext().getString(2131691363));
    this.a.a = bfue.a(paramView, localbgaz, new arzf(this, paramView), new arzh(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arze
 * JD-Core Version:    0.7.0.1
 */