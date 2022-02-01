import android.view.View;
import android.view.View.OnLongClickListener;
import com.dataline.activities.LiteActivity;

public class bd
  implements View.OnLongClickListener
{
  public bd(LiteActivity paramLiteActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.isUserOperatedInAIO = true;
    return this.a.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bd
 * JD-Core Version:    0.7.0.1
 */