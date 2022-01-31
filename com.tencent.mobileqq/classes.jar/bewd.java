import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;

public class bewd
  extends VerticalCenterImageSpan
{
  private int a;
  
  public bewd(Drawable paramDrawable)
  {
    super(paramDrawable, 0);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return super.getSize(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt) + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewd
 * JD-Core Version:    0.7.0.1
 */