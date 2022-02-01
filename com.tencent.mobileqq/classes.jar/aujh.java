import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class aujh
  implements View.OnClickListener
{
  aujh(aujd paramaujd, String paramString) {}
  
  public void onClick(View paramView)
  {
    bhrn.a(this.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getApplication().getRuntime().getAccount(), this.jdField_a_of_type_Aujd.a);
    arml.c().c.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujh
 * JD-Core Version:    0.7.0.1
 */