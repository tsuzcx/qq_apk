import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bkhv
  implements View.OnClickListener
{
  bkhv(bkho parambkho) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (bkho.a(this.a) != null) {
      bkho.a(this.a).onDismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkhv
 * JD-Core Version:    0.7.0.1
 */