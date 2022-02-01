import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azdl
  implements View.OnClickListener
{
  azdl(azdh paramazdh, azdw paramazdw) {}
  
  public void onClick(View paramView)
  {
    azdh.a(this.jdField_a_of_type_Azdh).removeMessages(101);
    azdh.a(this.jdField_a_of_type_Azdh).obtainMessage(101).sendToTarget();
    this.jdField_a_of_type_Azdw.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdl
 * JD-Core Version:    0.7.0.1
 */