import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

class baaj
  implements View.OnClickListener
{
  baaj(baai parambaai, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (baai.a(this.jdField_a_of_type_Baai) == this.jdField_a_of_type_Int) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Iterator localIterator = baai.a(this.jdField_a_of_type_Baai).iterator();
      while (localIterator.hasNext()) {
        ((baam)localIterator.next()).a = false;
      }
      ((baam)baai.a(this.jdField_a_of_type_Baai).get(this.jdField_a_of_type_Int)).a = true;
      baai.a(this.jdField_a_of_type_Baai, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Baai.notifyDataSetChanged();
      if (baai.a(this.jdField_a_of_type_Baai) != null) {
        baai.a(this.jdField_a_of_type_Baai).a((baam)baai.a(this.jdField_a_of_type_Baai).get(this.jdField_a_of_type_Int));
      }
      bdll.b(null, "dc00898", "", "", "0X800AB2B", "0X800AB2B", 0, 0, "0", "0", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baaj
 * JD-Core Version:    0.7.0.1
 */