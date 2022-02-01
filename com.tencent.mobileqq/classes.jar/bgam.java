import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;

public class bgam
  implements View.OnClickListener
{
  public bgam(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onClick(View paramView)
  {
    blgx.b(paramView);
    try
    {
      this.a.i();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublishHomeWorkFragment", 2, "on publish homework error, parse json error", localJSONException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgam
 * JD-Core Version:    0.7.0.1
 */