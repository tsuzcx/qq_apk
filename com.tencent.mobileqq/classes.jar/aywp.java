import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

public class aywp
  implements View.OnClickListener
{
  public aywp(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onClick(View paramView)
  {
    beex.b(paramView);
    try
    {
      this.a.h();
      return;
    }
    catch (JSONException paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PublishHomeWorkFragment", 2, "on publish homework error, parse json error", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aywp
 * JD-Core Version:    0.7.0.1
 */