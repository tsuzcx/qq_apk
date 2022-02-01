import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;

public class azrn
  extends LinearLayoutManager
{
  public azrn(InterestSwitchEditActivity paramInterestSwitchEditActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean canScrollHorizontally()
  {
    return false;
  }
  
  public boolean canScrollVertically()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azrn
 * JD-Core Version:    0.7.0.1
 */