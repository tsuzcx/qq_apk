import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfxw
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bfxw(bfxr parambfxr, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bfxr.a != null)
    {
      this.jdField_a_of_type_Bfxr.a.onClick(this.jdField_a_of_type_Bfxr, this.jdField_a_of_type_Bfxr.a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Bfxr.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxw
 * JD-Core Version:    0.7.0.1
 */