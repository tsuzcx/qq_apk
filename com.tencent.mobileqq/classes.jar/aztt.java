import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

class aztt
  implements View.OnClickListener
{
  aztt(azts paramazts, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (azts.a(this.jdField_a_of_type_Azts) == this.jdField_a_of_type_Int) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Iterator localIterator = azts.a(this.jdField_a_of_type_Azts).iterator();
      while (localIterator.hasNext()) {
        ((aztw)localIterator.next()).a = false;
      }
      ((aztw)azts.a(this.jdField_a_of_type_Azts).get(this.jdField_a_of_type_Int)).a = true;
      azts.a(this.jdField_a_of_type_Azts, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Azts.notifyDataSetChanged();
      if (azts.a(this.jdField_a_of_type_Azts) != null) {
        azts.a(this.jdField_a_of_type_Azts).a((aztw)azts.a(this.jdField_a_of_type_Azts).get(this.jdField_a_of_type_Int));
      }
      bdla.b(null, "dc00898", "", "", "0X800AB2B", "0X800AB2B", 0, 0, "0", "0", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aztt
 * JD-Core Version:    0.7.0.1
 */