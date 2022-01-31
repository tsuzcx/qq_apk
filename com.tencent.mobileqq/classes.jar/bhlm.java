import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import java.util.ArrayList;

public abstract class bhlm
{
  protected Paint a = new Paint();
  
  public bhlm()
  {
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
  }
  
  public abstract void a(Canvas paramCanvas, RectF paramRectF, int paramInt1, int paramInt2);
  
  public abstract void a(Canvas paramCanvas, ArrayList<bhne> paramArrayList, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhlm
 * JD-Core Version:    0.7.0.1
 */