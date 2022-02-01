import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhhq
  implements View.OnClickListener
{
  bhhq(bhhp parambhhp) {}
  
  public void onClick(View paramView)
  {
    if (this.a.mDialog.isShowing())
    {
      this.a.mDialog.cancel();
      this.a.mDialog.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhhq
 * JD-Core Version:    0.7.0.1
 */