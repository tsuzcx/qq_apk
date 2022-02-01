import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class bmhl
  implements View.OnClickListener
{
  float jdField_a_of_type_Float;
  
  public bmhl(bmhk parambmhk, float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void onClick(View paramView)
  {
    Iterator localIterator = this.jdField_a_of_type_Bmhk.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((TextView)localEntry.getValue()).setSelected(false);
      ((TextView)localEntry.getValue()).setTextColor(bmhk.a(this.jdField_a_of_type_Bmhk));
    }
    paramView.setSelected(true);
    ((TextView)paramView).setTextColor(bmhk.b(this.jdField_a_of_type_Bmhk));
    if (this.jdField_a_of_type_Bmhk.jdField_a_of_type_Bmhm != null) {
      this.jdField_a_of_type_Bmhk.jdField_a_of_type_Bmhm.a(this.jdField_a_of_type_Float);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhl
 * JD-Core Version:    0.7.0.1
 */