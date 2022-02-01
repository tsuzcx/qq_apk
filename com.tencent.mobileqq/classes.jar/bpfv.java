import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class bpfv
  implements View.OnClickListener
{
  float jdField_a_of_type_Float;
  
  public bpfv(bpfu parambpfu, float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void onClick(View paramView)
  {
    Iterator localIterator = this.jdField_a_of_type_Bpfu.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((TextView)localEntry.getValue()).setSelected(false);
      ((TextView)localEntry.getValue()).setTextColor(bpfu.a(this.jdField_a_of_type_Bpfu));
    }
    paramView.setSelected(true);
    ((TextView)paramView).setTextColor(bpfu.b(this.jdField_a_of_type_Bpfu));
    if (this.jdField_a_of_type_Bpfu.jdField_a_of_type_Bpfw != null) {
      this.jdField_a_of_type_Bpfu.jdField_a_of_type_Bpfw.a(this.jdField_a_of_type_Float);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpfv
 * JD-Core Version:    0.7.0.1
 */