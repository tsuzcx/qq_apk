import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bchn
  implements View.OnClickListener
{
  bchn(bchk parambchk, bceh parambceh) {}
  
  public void onClick(View paramView)
  {
    if ("ActiveEntitySearchResultPresenter_add_troop".equals(paramView.getTag()))
    {
      bchk.a(this.jdField_a_of_type_Bchk, paramView);
      bchk.a(this.jdField_a_of_type_Bchk, this.jdField_a_of_type_Bceh);
      if (bchk.a(this.jdField_a_of_type_Bchk) == null) {
        break label122;
      }
      bchk.a(this.jdField_a_of_type_Bchk).addObserver(bchk.a(this.jdField_a_of_type_Bchk));
    }
    for (;;)
    {
      try
      {
        ((aoep)bchk.a(this.jdField_a_of_type_Bchk).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b(Long.parseLong(this.jdField_a_of_type_Bceh.b), Long.valueOf(bchk.a(this.jdField_a_of_type_Bchk).getCurrentUin()).longValue(), null);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      label122:
      bchk.a(this.jdField_a_of_type_Bchk, paramView.getContext(), this.jdField_a_of_type_Bceh);
      bchk.a(this.jdField_a_of_type_Bchk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchn
 * JD-Core Version:    0.7.0.1
 */