import android.graphics.Canvas;
import android.text.TextPaint;

public class angy
  extends angv
{
  private TextPaint a = new TextPaint();
  
  private String a(anfv paramanfv)
  {
    return String.valueOf(paramanfv.a());
  }
  
  public anht a(anfv paramanfv)
  {
    angu localangu = ange.a();
    float f1 = anhw.a(localangu.c(), a(paramanfv)) + localangu.f() + localangu.f();
    float f2 = anhw.a(localangu.c());
    f2 = localangu.e() * 2.0F + f2;
    paramanfv.a(f2);
    paramanfv.b(f1);
    return new anht(f1, f2);
  }
  
  public boolean a(anfv paramanfv)
  {
    return true;
  }
  
  public void b(Canvas paramCanvas, anfv paramanfv, ange paramange, float paramFloat1, float paramFloat2)
  {
    paramange = ange.a();
    this.a.setTextSize(paramange.c());
    this.a.setColor(-1);
    paramCanvas.drawText(a(paramanfv), paramange.f() + paramFloat1, paramange.e() + paramFloat2 - this.a.ascent(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     angy
 * JD-Core Version:    0.7.0.1
 */