import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;

class bngg
  implements View.OnClickListener
{
  bngg(bngd parambngd, bnfk parambnfk, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ((bnff)this.jdField_a_of_type_Bngd.a.get()).a(this.jdField_a_of_type_Bnfk.itemView, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngg
 * JD-Core Version:    0.7.0.1
 */