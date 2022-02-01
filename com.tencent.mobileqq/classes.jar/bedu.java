import android.view.View;
import java.util.List;

class bedu
  implements bliz
{
  bedu(bedr parambedr, List paramList, beex parambeex, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramView = (beey)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (bedr.a(this.jdField_a_of_type_Bedr) != null) {
        bedr.a(this.jdField_a_of_type_Bedr).a(paramView.b(), this.jdField_a_of_type_Beex);
      }
      this.jdField_a_of_type_Blir.dismiss();
      return;
    }
    this.jdField_a_of_type_Blir.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedu
 * JD-Core Version:    0.7.0.1
 */