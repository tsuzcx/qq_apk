import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bchx
  implements View.OnClickListener
{
  bchx(bchu parambchu, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    bchu.a(this.jdField_a_of_type_Bchu).onAction(paramView);
    if ((bchu.a(this.jdField_a_of_type_Bchu) instanceof bcal)) {
      ((bcal)bchu.a(this.jdField_a_of_type_Bchu)).a(this.jdField_a_of_type_JavaLangString, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchx
 * JD-Core Version:    0.7.0.1
 */