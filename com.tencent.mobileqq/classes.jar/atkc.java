import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;

public class atkc
  implements View.OnLongClickListener
{
  public atkc(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseCloudFileTabView.b(this.a))) {
      return false;
    }
    paramView.setSelected(true);
    bhuk localbhuk = new bhuk();
    localbhuk.a(2131365346, paramView.getContext().getString(2131691323));
    this.a.a = bhkx.a(paramView, localbhuk, new atkd(this, paramView), new atke(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atkc
 * JD-Core Version:    0.7.0.1
 */