import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;

public class anki
  implements View.OnClickListener
{
  public anki(DBFixConfigActivity paramDBFixConfigActivity) {}
  
  public void onClick(View paramView)
  {
    ThreadManager.post(this.a.a, 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anki
 * JD-Core Version:    0.7.0.1
 */