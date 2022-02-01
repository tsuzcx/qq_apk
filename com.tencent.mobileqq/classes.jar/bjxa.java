import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bjxa
  implements View.OnClickListener
{
  bjxa(bjwz parambjwz, bjwy parambjwy) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Bjwy.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Bjwz.a.a(this.jdField_a_of_type_Bjwy.itemView, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxa
 * JD-Core Version:    0.7.0.1
 */