import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcrq
  implements View.OnClickListener
{
  bcrq(bcro parambcro, bcra parambcra, bcqw parambcqw, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (bcro.a(this.jdField_a_of_type_Bcro) != null) {
      bcro.a(this.jdField_a_of_type_Bcro).a(this.jdField_a_of_type_Bcra, (bcrb)this.jdField_a_of_type_Bcqw, this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcrq
 * JD-Core Version:    0.7.0.1
 */