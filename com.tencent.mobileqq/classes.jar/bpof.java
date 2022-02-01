import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bpof
  implements View.OnClickListener
{
  bpof(bpoc parambpoc) {}
  
  public void onClick(View paramView)
  {
    if (bpoc.a(this.a)) {
      this.a.a.y();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQToast.a(BaseApplicationImpl.getContext(), anzj.a(2131712574), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpof
 * JD-Core Version:    0.7.0.1
 */