import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class boea
  implements View.OnClickListener
{
  float jdField_a_of_type_Float;
  
  public boea(bodz parambodz, float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void onClick(View paramView)
  {
    Iterator localIterator = this.jdField_a_of_type_Bodz.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((TextView)localEntry.getValue()).setSelected(false);
      ((TextView)localEntry.getValue()).setTextColor(bodz.a(this.jdField_a_of_type_Bodz));
    }
    paramView.setSelected(true);
    ((TextView)paramView).setTextColor(bodz.b(this.jdField_a_of_type_Bodz));
    if (this.jdField_a_of_type_Bodz.jdField_a_of_type_Boeb != null) {
      this.jdField_a_of_type_Bodz.jdField_a_of_type_Boeb.a(this.jdField_a_of_type_Float);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boea
 * JD-Core Version:    0.7.0.1
 */