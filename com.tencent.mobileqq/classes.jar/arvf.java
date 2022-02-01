import android.graphics.Canvas;
import android.text.TextPaint;

public class arvf
  extends arvc
{
  private TextPaint a = new TextPaint();
  
  private String a(aruc paramaruc)
  {
    return String.valueOf(paramaruc.a());
  }
  
  public arwa a(aruc paramaruc)
  {
    arvb localarvb = arul.a();
    float f1 = arwd.a(localarvb.c(), a(paramaruc)) + localarvb.f() + localarvb.f();
    float f2 = arwd.a(localarvb.c());
    f2 = localarvb.e() * 2.0F + f2;
    paramaruc.a(f2);
    paramaruc.b(f1);
    return new arwa(f1, f2);
  }
  
  public boolean a(aruc paramaruc)
  {
    return true;
  }
  
  public void b(Canvas paramCanvas, aruc paramaruc, arul paramarul, float paramFloat1, float paramFloat2)
  {
    paramarul = arul.a();
    this.a.setTextSize(paramarul.c());
    this.a.setColor(-1);
    paramCanvas.drawText(a(paramaruc), paramarul.f() + paramFloat1, paramarul.e() + paramFloat2 - this.a.ascent(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvf
 * JD-Core Version:    0.7.0.1
 */