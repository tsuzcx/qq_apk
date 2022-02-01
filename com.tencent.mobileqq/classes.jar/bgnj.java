import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.mobileqq.troop.widget.FollowImageTextView;

public class bgnj
  extends TextView
{
  public bgnj(FollowImageTextView paramFollowImageTextView, Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (FollowImageTextView.a(this.a))
    {
      super.onDraw(paramCanvas);
      return;
    }
    Object localObject = getPaint();
    ((TextPaint)localObject).setColor(getCurrentTextColor());
    ((TextPaint)localObject).drawableState = getDrawableState();
    localObject = FollowImageTextView.a(this.a);
    ((bgnm)localObject).a(FollowImageTextView.a(this.a) - 1);
    ((bgnm)localObject).a(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgnj
 * JD-Core Version:    0.7.0.1
 */