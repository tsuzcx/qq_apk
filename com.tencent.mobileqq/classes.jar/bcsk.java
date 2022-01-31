import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;

public class bcsk
  implements View.OnTouchListener
{
  public bcsk(TroopPicEffectGuidePicActivity paramTroopPicEffectGuidePicActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsk
 * JD-Core Version:    0.7.0.1
 */