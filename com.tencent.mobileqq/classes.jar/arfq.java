import android.graphics.Canvas;
import android.text.TextPaint;

public class arfq
  extends arfn
{
  private TextPaint a = new TextPaint();
  
  private String a(aren paramaren)
  {
    return String.valueOf(paramaren.a());
  }
  
  public argl a(aren paramaren)
  {
    arfm localarfm = arew.a();
    float f1 = argo.a(localarfm.c(), a(paramaren)) + localarfm.f() + localarfm.f();
    float f2 = argo.a(localarfm.c());
    f2 = localarfm.e() * 2.0F + f2;
    paramaren.a(f2);
    paramaren.b(f1);
    return new argl(f1, f2);
  }
  
  public boolean a(aren paramaren)
  {
    return true;
  }
  
  public void b(Canvas paramCanvas, aren paramaren, arew paramarew, float paramFloat1, float paramFloat2)
  {
    paramarew = arew.a();
    this.a.setTextSize(paramarew.c());
    this.a.setColor(-1);
    paramCanvas.drawText(a(paramaren), paramarew.f() + paramFloat1, paramarew.e() + paramFloat2 - this.a.ascent(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfq
 * JD-Core Version:    0.7.0.1
 */