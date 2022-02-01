import android.content.Context;
import android.view.OrientationEventListener;

class aygo
  extends OrientationEventListener
{
  aygo(aygn paramaygn, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1) {
      this.a.b = 0;
    }
    do
    {
      return;
      this.a.b = ((paramInt + 45) / 90 * 90);
    } while (this.a.b >= 0);
    this.a.b = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygo
 * JD-Core Version:    0.7.0.1
 */