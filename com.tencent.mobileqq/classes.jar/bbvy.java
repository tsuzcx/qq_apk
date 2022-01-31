import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

public class bbvy
  implements View.OnClickListener
{
  public bbvy(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onClick(View paramView)
  {
    bhoc.b(paramView);
    try
    {
      this.a.i();
      return;
    }
    catch (JSONException paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PublishHomeWorkFragment", 2, "on publish homework error, parse json error", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvy
 * JD-Core Version:    0.7.0.1
 */