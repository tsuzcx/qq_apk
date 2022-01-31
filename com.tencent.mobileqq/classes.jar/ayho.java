import android.view.View;
import java.util.List;

class ayho
  implements bfoq
{
  ayho(ayhl paramayhl, List paramList, ayir paramayir, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramView = (ayis)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (ayhl.a(this.jdField_a_of_type_Ayhl) != null) {
        ayhl.a(this.jdField_a_of_type_Ayhl).a(paramView.b(), this.jdField_a_of_type_Ayir);
      }
      this.jdField_a_of_type_Bfol.dismiss();
      return;
    }
    this.jdField_a_of_type_Bfol.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayho
 * JD-Core Version:    0.7.0.1
 */