import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import java.util.ArrayList;

public abstract class bokp
{
  protected Paint a = new Paint();
  
  public bokp()
  {
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
  }
  
  public abstract void a(Canvas paramCanvas, RectF paramRectF, int paramInt1, int paramInt2);
  
  public abstract void a(Canvas paramCanvas, ArrayList<bomh> paramArrayList, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bokp
 * JD-Core Version:    0.7.0.1
 */