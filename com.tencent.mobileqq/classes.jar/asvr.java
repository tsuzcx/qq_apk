import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class asvr
  implements View.OnClickListener
{
  asvr(asvn paramasvn, String paramString) {}
  
  public void onClick(View paramView)
  {
    bfyi.a(this.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getApplication().getRuntime().getAccount(), this.jdField_a_of_type_Asvn.a);
    aqgi.c().c.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvr
 * JD-Core Version:    0.7.0.1
 */