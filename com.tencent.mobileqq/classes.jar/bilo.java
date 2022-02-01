import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bilo
  implements View.OnClickListener
{
  bilo(biln parambiln, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WholePeoplePlugin", 2, "onClick " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Biln.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bilo
 * JD-Core Version:    0.7.0.1
 */