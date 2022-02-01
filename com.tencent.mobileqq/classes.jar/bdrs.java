import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bdrs
  implements View.OnClickListener
{
  bdrs(bdrr parambdrr) {}
  
  public void onClick(View paramView)
  {
    onq localonq = (onq)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (localonq != null) {
      localonq.a(this.a, (Activity)paramView.getContext());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdrs
 * JD-Core Version:    0.7.0.1
 */