import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bmmi
  implements View.OnClickListener
{
  bmmi(bmmh parambmmh, int paramInt, bmmj parambmmj) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == bmmh.a(this.jdField_a_of_type_Bmmh))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    bmmh.a(this.jdField_a_of_type_Bmmh, this.jdField_a_of_type_Int);
    bmmh.a(this.jdField_a_of_type_Bmmh).a(bmmh.a(this.jdField_a_of_type_Bmmh), ((Integer)bmmh.a(this.jdField_a_of_type_Bmmh).get(this.jdField_a_of_type_Int)).intValue(), this.jdField_a_of_type_Int, bmmh.b(this.jdField_a_of_type_Bmmh));
    bmmh.a(this.jdField_a_of_type_Bmmh, this.jdField_a_of_type_Bmmj, this.jdField_a_of_type_Int);
    if ("adapter_extract".equals(bmmh.a(this.jdField_a_of_type_Bmmh)))
    {
      bmbg.a().a().f = "ai_color";
      bmbg.a().a().h = -1;
    }
    for (;;)
    {
      bmbg.a().a().g = bmmh.b(this.jdField_a_of_type_Bmmh);
      bmbc.a().s();
      break;
      if ("adapter_fix".equals(bmmh.a(this.jdField_a_of_type_Bmmh)))
      {
        bmbg.a().a().f = "common_color";
        bmbg.a().a().h = (this.jdField_a_of_type_Int + 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmi
 * JD-Core Version:    0.7.0.1
 */