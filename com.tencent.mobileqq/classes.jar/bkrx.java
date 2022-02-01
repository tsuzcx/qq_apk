import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bkrx
  implements View.OnClickListener
{
  bkrx(bkrw parambkrw, bkrv parambkrv) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bkrv.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Bkrw.a.a(this.jdField_a_of_type_Bkrv.itemView, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkrx
 * JD-Core Version:    0.7.0.1
 */