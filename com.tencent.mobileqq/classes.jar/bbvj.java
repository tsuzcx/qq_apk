import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.video.VipVideoPlayActivity;

public class bbvj
  implements View.OnClickListener
{
  public bbvj(VipVideoPlayActivity paramVipVideoPlayActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.getRequestedOrientation() == 0)
    {
      this.a.setRequestedOrientation(1);
      return;
    }
    this.a.setResult(0);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbvj
 * JD-Core Version:    0.7.0.1
 */