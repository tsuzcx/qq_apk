import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhrb
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bhrb(bhqw parambhqw, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bhqw.a != null)
    {
      this.jdField_a_of_type_Bhqw.a.onClick(this.jdField_a_of_type_Bhqw, this.jdField_a_of_type_Bhqw.a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Bhqw.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhrb
 * JD-Core Version:    0.7.0.1
 */