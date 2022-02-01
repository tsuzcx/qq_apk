import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auie
  implements View.OnClickListener
{
  auie(auid paramauid, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_Auid.a, QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Auid.a.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auie
 * JD-Core Version:    0.7.0.1
 */