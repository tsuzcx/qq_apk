import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhto
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  
  bhto(bhtn parambhtn) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Long == 0L) || (l - this.jdField_a_of_type_Long > 2000L))
    {
      bhtn.a(this.jdField_a_of_type_Bhtn).b();
      this.jdField_a_of_type_Long = l;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhto
 * JD-Core Version:    0.7.0.1
 */