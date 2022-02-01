import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class bglz
  implements View.OnClickListener
{
  bglz(DialogInterface.OnClickListener paramOnClickListener, bgpa parambgpa) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bgpa, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bglz
 * JD-Core Version:    0.7.0.1
 */