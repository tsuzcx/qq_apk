import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhpw
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bhpw(bhpr parambhpr, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bhpr.a != null)
    {
      this.jdField_a_of_type_Bhpr.a.onClick(this.jdField_a_of_type_Bhpr, this.jdField_a_of_type_Bhpr.a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Bhpr.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhpw
 * JD-Core Version:    0.7.0.1
 */