import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.share.QZoneShareActivity;

public class bhld
  implements View.OnClickListener
{
  public bhld(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.d)
    {
      this.a.f();
      return;
    }
    this.a.h();
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhld
 * JD-Core Version:    0.7.0.1
 */