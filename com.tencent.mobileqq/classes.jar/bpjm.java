import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bpjm
  implements View.OnClickListener
{
  bpjm(bpjl parambpjl, int paramInt, bpjn parambpjn) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == bpjl.a(this.jdField_a_of_type_Bpjl))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    bpjl.a(this.jdField_a_of_type_Bpjl, this.jdField_a_of_type_Int);
    bpjl.a(this.jdField_a_of_type_Bpjl).a(bpjl.a(this.jdField_a_of_type_Bpjl), ((Integer)bpjl.a(this.jdField_a_of_type_Bpjl).get(this.jdField_a_of_type_Int)).intValue(), this.jdField_a_of_type_Int, bpjl.b(this.jdField_a_of_type_Bpjl));
    bpjl.a(this.jdField_a_of_type_Bpjl, this.jdField_a_of_type_Bpjn, this.jdField_a_of_type_Int);
    if ("adapter_extract".equals(bpjl.a(this.jdField_a_of_type_Bpjl)))
    {
      bozv.a().a().f = "ai_color";
      bozv.a().a().jdField_g_of_type_Int = -1;
    }
    for (;;)
    {
      bozv.a().a().jdField_g_of_type_JavaLangString = bpjl.b(this.jdField_a_of_type_Bpjl);
      bozr.a().t();
      break;
      if ("adapter_fix".equals(bpjl.a(this.jdField_a_of_type_Bpjl)))
      {
        bozv.a().a().f = "common_color";
        bozv.a().a().jdField_g_of_type_Int = (this.jdField_a_of_type_Int + 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjm
 * JD-Core Version:    0.7.0.1
 */