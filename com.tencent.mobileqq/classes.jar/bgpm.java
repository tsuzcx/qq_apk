import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgpm
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bgpm(bgpa parambgpa, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bgpa.onArrayItemClick != null) {
      this.jdField_a_of_type_Bgpa.onArrayItemClick.onClick(this.jdField_a_of_type_Bgpa, this.jdField_a_of_type_Bgpa.customWhichToCallBack(this.jdField_a_of_type_Int));
    }
    try
    {
      if (this.jdField_a_of_type_Bgpa.isShowing()) {
        this.jdField_a_of_type_Bgpa.dismiss();
      }
      label54:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label54;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgpm
 * JD-Core Version:    0.7.0.1
 */