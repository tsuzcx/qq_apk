import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bprq
  implements View.OnClickListener
{
  bprq(bprp parambprp, bprs parambprs) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Bprs.a()) {
      this.jdField_a_of_type_Bprs.b();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bprp.a != null) {
        this.jdField_a_of_type_Bprp.a.a(this.jdField_a_of_type_Bprp);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Bprs.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bprq
 * JD-Core Version:    0.7.0.1
 */