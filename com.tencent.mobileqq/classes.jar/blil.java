import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blil
  implements View.OnClickListener
{
  blil(blik paramblik, blij paramblij) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Blij.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_Blik.a.a(this.jdField_a_of_type_Blij.itemView, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blil
 * JD-Core Version:    0.7.0.1
 */