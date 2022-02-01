import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhpo
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bhpo(bhpc parambhpc, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bhpc.onArrayItemClick != null) {
      this.jdField_a_of_type_Bhpc.onArrayItemClick.onClick(this.jdField_a_of_type_Bhpc, this.jdField_a_of_type_Bhpc.customWhichToCallBack(this.jdField_a_of_type_Int));
    }
    try
    {
      if (this.jdField_a_of_type_Bhpc.isShowing()) {
        this.jdField_a_of_type_Bhpc.dismiss();
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
 * Qualified Name:     bhpo
 * JD-Core Version:    0.7.0.1
 */