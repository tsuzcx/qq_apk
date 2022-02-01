import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class amlj
  implements View.OnClickListener
{
  amlj(amli paramamli, amlh paramamlh, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Amlh.a.isChecked()) {}
    for (((aoui)this.jdField_a_of_type_Amli.a.get(this.jdField_a_of_type_Int)).a = false;; ((aoui)this.jdField_a_of_type_Amli.a.get(this.jdField_a_of_type_Int)).a = true)
    {
      this.jdField_a_of_type_Amli.notifyItemChanged(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Amli.a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlj
 * JD-Core Version:    0.7.0.1
 */