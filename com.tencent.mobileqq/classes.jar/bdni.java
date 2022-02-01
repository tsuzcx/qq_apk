import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bdni
  implements View.OnClickListener
{
  private bdnj jdField_a_of_type_Bdnj;
  private bdnk jdField_a_of_type_Bdnk;
  
  public bdni(bdnk parambdnk)
  {
    this.jdField_a_of_type_Bdnk = parambdnk;
  }
  
  public void a(bdnj parambdnj)
  {
    this.jdField_a_of_type_Bdnj = parambdnj;
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    bdnk.a(this.jdField_a_of_type_Bdnk, i);
    if (this.jdField_a_of_type_Bdnj != null) {
      this.jdField_a_of_type_Bdnj.a((bdnl)bdnk.a(this.jdField_a_of_type_Bdnk).get(i));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdni
 * JD-Core Version:    0.7.0.1
 */