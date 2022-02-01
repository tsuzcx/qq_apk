import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

class azhx
  implements View.OnClickListener
{
  azhx(azhw paramazhw, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (azhw.a(this.jdField_a_of_type_Azhw) == this.jdField_a_of_type_Int) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Iterator localIterator = azhw.a(this.jdField_a_of_type_Azhw).iterator();
      while (localIterator.hasNext()) {
        ((azia)localIterator.next()).a = false;
      }
      ((azia)azhw.a(this.jdField_a_of_type_Azhw).get(this.jdField_a_of_type_Int)).a = true;
      azhw.a(this.jdField_a_of_type_Azhw, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Azhw.notifyDataSetChanged();
      if (azhw.a(this.jdField_a_of_type_Azhw) != null) {
        azhw.a(this.jdField_a_of_type_Azhw).a((azia)azhw.a(this.jdField_a_of_type_Azhw).get(this.jdField_a_of_type_Int));
      }
      bcst.b(null, "dc00898", "", "", "0X800AB2B", "0X800AB2B", 0, 0, "0", "0", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhx
 * JD-Core Version:    0.7.0.1
 */