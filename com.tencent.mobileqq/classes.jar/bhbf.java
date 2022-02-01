import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;

public class bhbf
  implements View.OnTouchListener
{
  public bhbf(TroopPicEffectGuidePicActivity paramTroopPicEffectGuidePicActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      paramView.setAlpha(0.5F);
    }
    for (;;)
    {
      return false;
      if ((i == 1) || (i == 3)) {
        paramView.setAlpha(1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhbf
 * JD-Core Version:    0.7.0.1
 */