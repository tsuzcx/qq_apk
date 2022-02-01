import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class botn
  implements View.OnClickListener
{
  botn(botm parambotm, boto paramboto, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (botm.a(this.jdField_a_of_type_Botm) != this.jdField_a_of_type_Boto.getLayoutPosition()) {
      bozr.a().j(this.jdField_a_of_type_JavaLangString);
    }
    if ((botm.a(this.jdField_a_of_type_Botm) == -1) && (TextUtils.isEmpty(botm.a(this.jdField_a_of_type_Botm).a())))
    {
      botm.a(this.jdField_a_of_type_Botm).a(this.jdField_a_of_type_JavaLangString, ((bosz)bosy.a.get(0)).jdField_a_of_type_JavaLangString, ((bosz)bosy.a.get(0)).b);
      botm.a(this.jdField_a_of_type_Botm).a(true, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Botm.a();
      botm.a(this.jdField_a_of_type_Botm, this.jdField_a_of_type_Boto.getLayoutPosition());
      ((bosx)botm.a(this.jdField_a_of_type_Botm).get(botm.a(this.jdField_a_of_type_Botm) - 1)).a(true);
      this.jdField_a_of_type_Boto.a(true);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      botm.a(this.jdField_a_of_type_Botm).a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     botn
 * JD-Core Version:    0.7.0.1
 */