import android.graphics.Canvas;
import android.text.TextPaint;

public class anhd
  extends anha
{
  private TextPaint a = new TextPaint();
  
  private String a(anga paramanga)
  {
    return String.valueOf(paramanga.a());
  }
  
  public anhy a(anga paramanga)
  {
    angz localangz = angj.a();
    float f1 = anib.a(localangz.c(), a(paramanga)) + localangz.f() + localangz.f();
    float f2 = anib.a(localangz.c());
    f2 = localangz.e() * 2.0F + f2;
    paramanga.a(f2);
    paramanga.b(f1);
    return new anhy(f1, f2);
  }
  
  public boolean a(anga paramanga)
  {
    return true;
  }
  
  public void b(Canvas paramCanvas, anga paramanga, angj paramangj, float paramFloat1, float paramFloat2)
  {
    paramangj = angj.a();
    this.a.setTextSize(paramangj.c());
    this.a.setColor(-1);
    paramCanvas.drawText(a(paramanga), paramangj.f() + paramFloat1, paramangj.e() + paramFloat2 - this.a.ascent(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anhd
 * JD-Core Version:    0.7.0.1
 */