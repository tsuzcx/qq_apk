import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhts
  implements View.OnClickListener
{
  private final bhtr jdField_a_of_type_Bhtr;
  private final boolean jdField_a_of_type_Boolean;
  
  public bhts(bhtn parambhtn, bhtr parambhtr, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bhtr = parambhtr;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    bhtn.a(this.jdField_a_of_type_Bhtn, this.jdField_a_of_type_Bhtr.b);
    bhtn.a(this.jdField_a_of_type_Bhtn, this.jdField_a_of_type_Bhtr);
    bhtn.a(this.jdField_a_of_type_Bhtn, bhtn.a(this.jdField_a_of_type_Bhtn));
    if (this.jdField_a_of_type_Boolean) {
      bhtn.a(this.jdField_a_of_type_Bhtn).a();
    }
    int j = this.jdField_a_of_type_Bhtr.b;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 4;; i = this.jdField_a_of_type_Bhtr.d)
    {
      bhtm.a(2, j, i, 102);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhts
 * JD-Core Version:    0.7.0.1
 */