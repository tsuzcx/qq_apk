import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class befv
  implements View.OnClickListener
{
  private befw jdField_a_of_type_Befw;
  private befx jdField_a_of_type_Befx;
  
  public befv(befx parambefx)
  {
    this.jdField_a_of_type_Befx = parambefx;
  }
  
  public void a(befw parambefw)
  {
    this.jdField_a_of_type_Befw = parambefw;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    befx.a(this.jdField_a_of_type_Befx, i);
    if (this.jdField_a_of_type_Befw != null) {
      this.jdField_a_of_type_Befw.a((befy)befx.a(this.jdField_a_of_type_Befx).get(i));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befv
 * JD-Core Version:    0.7.0.1
 */