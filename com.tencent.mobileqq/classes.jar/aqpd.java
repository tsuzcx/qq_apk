import android.graphics.Canvas;
import android.text.TextPaint;
import com.tencent.mobileqq.danmaku.util.DrawUtils;

public class aqpd
  extends aqpa
{
  private TextPaint a = new TextPaint();
  
  private String a(aqoa paramaqoa)
  {
    return String.valueOf(paramaqoa.a());
  }
  
  public aqpy a(aqoa paramaqoa)
  {
    aqoz localaqoz = aqoj.a();
    float f1 = DrawUtils.getTextWidth(localaqoz.c(), a(paramaqoa)) + localaqoz.f() + localaqoz.f();
    float f2 = DrawUtils.getTextHeight(localaqoz.c());
    f2 = localaqoz.e() * 2.0F + f2;
    paramaqoa.a(f2);
    paramaqoa.b(f1);
    return new aqpy(f1, f2);
  }
  
  public boolean a(aqoa paramaqoa)
  {
    return true;
  }
  
  public void b(Canvas paramCanvas, aqoa paramaqoa, aqoj paramaqoj, float paramFloat1, float paramFloat2)
  {
    paramaqoj = aqoj.a();
    this.a.setTextSize(paramaqoj.c());
    this.a.setColor(-1);
    paramCanvas.drawText(a(paramaqoa), paramaqoj.f() + paramFloat1, paramaqoj.e() + paramFloat2 - this.a.ascent(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpd
 * JD-Core Version:    0.7.0.1
 */