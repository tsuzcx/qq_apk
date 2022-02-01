import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgqz
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bgqz(bgqu parambgqu, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bgqu.a != null)
    {
      this.jdField_a_of_type_Bgqu.a.onClick(this.jdField_a_of_type_Bgqu, this.jdField_a_of_type_Bgqu.a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Bgqu.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgqz
 * JD-Core Version:    0.7.0.1
 */