import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnfm
  implements View.OnClickListener
{
  bnfm(bnfl parambnfl, bnfo parambnfo) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bnfo.getLayoutPosition();
    bnfl.a(this.jdField_a_of_type_Bnfl).a(this.jdField_a_of_type_Bnfo.itemView, i);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfm
 * JD-Core Version:    0.7.0.1
 */