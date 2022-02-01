import android.view.View;
import java.util.List;

class beek
  implements bkzq
{
  beek(beeh parambeeh, List paramList, befn parambefn, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramView = (befo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (beeh.a(this.jdField_a_of_type_Beeh) != null) {
        beeh.a(this.jdField_a_of_type_Beeh).a(paramView.b(), this.jdField_a_of_type_Befn);
      }
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
    }
    this.jdField_a_of_type_Bkzi.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beek
 * JD-Core Version:    0.7.0.1
 */