import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class arwl
  implements View.OnLongClickListener
{
  public arwl(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseCloudFileTabView.b(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bgaz localbgaz = new bgaz();
    localbgaz.a(2131365376, paramView.getContext().getString(2131691363));
    this.a.a = bfue.a(paramView, localbgaz, new arwm(this, paramView), new arwn(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwl
 * JD-Core Version:    0.7.0.1
 */