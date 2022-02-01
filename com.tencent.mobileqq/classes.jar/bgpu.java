import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgpu
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bgpu(bgpp parambgpp, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bgpp.a != null)
    {
      this.jdField_a_of_type_Bgpp.a.onClick(this.jdField_a_of_type_Bgpp, this.jdField_a_of_type_Bgpp.a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Bgpp.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgpu
 * JD-Core Version:    0.7.0.1
 */