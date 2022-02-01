import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class beul
  implements View.OnClickListener
{
  private beum jdField_a_of_type_Beum;
  private beun jdField_a_of_type_Beun;
  
  public beul(beun parambeun)
  {
    this.jdField_a_of_type_Beun = parambeun;
  }
  
  public void a(beum parambeum)
  {
    this.jdField_a_of_type_Beum = parambeum;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    beun.a(this.jdField_a_of_type_Beun, i);
    if (this.jdField_a_of_type_Beum != null) {
      this.jdField_a_of_type_Beum.a((beuo)beun.a(this.jdField_a_of_type_Beun).get(i));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beul
 * JD-Core Version:    0.7.0.1
 */