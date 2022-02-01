import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcku
  implements View.OnClickListener
{
  bcku(bckt parambckt) {}
  
  public void onClick(View paramView)
  {
    ofx localofx = (ofx)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(88);
    if (localofx != null) {
      localofx.a(this.a, (Activity)paramView.getContext());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcku
 * JD-Core Version:    0.7.0.1
 */