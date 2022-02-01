import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhgo
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bhgo(bhgj parambhgj, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bhgj.a != null)
    {
      this.jdField_a_of_type_Bhgj.a.onClick(this.jdField_a_of_type_Bhgj, this.jdField_a_of_type_Bhgj.a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Bhgj.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhgo
 * JD-Core Version:    0.7.0.1
 */