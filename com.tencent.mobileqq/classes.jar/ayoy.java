import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

class ayoy
  implements View.OnClickListener
{
  ayoy(ayox paramayox, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (ayox.a(this.jdField_a_of_type_Ayox) == this.jdField_a_of_type_Int) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Iterator localIterator = ayox.a(this.jdField_a_of_type_Ayox).iterator();
      while (localIterator.hasNext()) {
        ((aypb)localIterator.next()).a = false;
      }
      ((aypb)ayox.a(this.jdField_a_of_type_Ayox).get(this.jdField_a_of_type_Int)).a = true;
      ayox.a(this.jdField_a_of_type_Ayox, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Ayox.notifyDataSetChanged();
      if (ayox.a(this.jdField_a_of_type_Ayox) != null) {
        ayox.a(this.jdField_a_of_type_Ayox).a((aypb)ayox.a(this.jdField_a_of_type_Ayox).get(this.jdField_a_of_type_Int));
      }
      bcef.b(null, "dc00898", "", "", "0X800AB2B", "0X800AB2B", 0, 0, "0", "0", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayoy
 * JD-Core Version:    0.7.0.1
 */