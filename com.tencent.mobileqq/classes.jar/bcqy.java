import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.mobileqq.troop.widget.FollowImageTextView;

public class bcqy
  extends TextView
{
  public bcqy(FollowImageTextView paramFollowImageTextView, Context paramContext)
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
    ((bcrb)localObject).a(FollowImageTextView.a(this.a) - 1);
    ((bcrb)localObject).a(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcqy
 * JD-Core Version:    0.7.0.1
 */