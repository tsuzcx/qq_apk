import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar;

public class bdfq
  extends bdft
{
  public bdfq(TCProgressBar paramTCProgressBar)
  {
    super(paramTCProgressBar);
  }
  
  public void a(Canvas paramCanvas)
  {
    this.a.b.left = this.f;
    this.a.b.right = (this.f + this.g);
    this.a.a.setColor(this.a.m);
    paramCanvas.drawRect(this.a.b, this.a.a);
    super.a(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfq
 * JD-Core Version:    0.7.0.1
 */