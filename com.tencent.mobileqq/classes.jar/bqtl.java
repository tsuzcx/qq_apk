import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bqtl
  implements View.OnClickListener
{
  bqtl(bqtk parambqtk, bqtn parambqtn) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Bqtn.a()) {
      this.jdField_a_of_type_Bqtn.b();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bqtk.a != null) {
        this.jdField_a_of_type_Bqtk.a.a(this.jdField_a_of_type_Bqtk);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Bqtn.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqtl
 * JD-Core Version:    0.7.0.1
 */