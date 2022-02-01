import android.graphics.Canvas;
import android.text.TextPaint;
import com.tencent.mobileqq.danmaku.util.DrawUtils;

public class arso
  extends arsl
{
  private TextPaint a = new TextPaint();
  
  private String a(arrl paramarrl)
  {
    return String.valueOf(paramarrl.a());
  }
  
  public artj a(arrl paramarrl)
  {
    arsk localarsk = arru.a();
    float f1 = DrawUtils.getTextWidth(localarsk.c(), a(paramarrl)) + localarsk.f() + localarsk.f();
    float f2 = DrawUtils.getTextHeight(localarsk.c());
    f2 = localarsk.e() * 2.0F + f2;
    paramarrl.a(f2);
    paramarrl.b(f1);
    return new artj(f1, f2);
  }
  
  public boolean a(arrl paramarrl)
  {
    return true;
  }
  
  public void b(Canvas paramCanvas, arrl paramarrl, arru paramarru, float paramFloat1, float paramFloat2)
  {
    paramarru = arru.a();
    this.a.setTextSize(paramarru.c());
    this.a.setColor(-1);
    paramCanvas.drawText(a(paramarrl), paramarru.f() + paramFloat1, paramarru.e() + paramFloat2 - this.a.ascent(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arso
 * JD-Core Version:    0.7.0.1
 */