import android.view.View;
import java.util.List;

class ayhq
  implements bfph
{
  ayhq(ayhn paramayhn, List paramList, ayit paramayit, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramView = (ayiu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (ayhn.a(this.jdField_a_of_type_Ayhn) != null) {
        ayhn.a(this.jdField_a_of_type_Ayhn).a(paramView.b(), this.jdField_a_of_type_Ayit);
      }
      this.jdField_a_of_type_Bfpc.dismiss();
      return;
    }
    this.jdField_a_of_type_Bfpc.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayhq
 * JD-Core Version:    0.7.0.1
 */