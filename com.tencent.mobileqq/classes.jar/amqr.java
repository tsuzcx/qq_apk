import android.graphics.Canvas;
import android.text.TextPaint;

public class amqr
  extends amqo
{
  private TextPaint a = new TextPaint();
  
  private String a(ampo paramampo)
  {
    return String.valueOf(paramampo.a());
  }
  
  public amrm a(ampo paramampo)
  {
    amqn localamqn = ampx.a();
    float f1 = amrp.a(localamqn.c(), a(paramampo)) + localamqn.f() + localamqn.f();
    float f2 = amrp.a(localamqn.c());
    f2 = localamqn.e() * 2.0F + f2;
    paramampo.a(f2);
    paramampo.b(f1);
    return new amrm(f1, f2);
  }
  
  public boolean a(ampo paramampo)
  {
    return true;
  }
  
  public void b(Canvas paramCanvas, ampo paramampo, ampx paramampx, float paramFloat1, float paramFloat2)
  {
    paramampx = ampx.a();
    this.a.setTextSize(paramampx.c());
    this.a.setColor(-1);
    paramCanvas.drawText(a(paramampo), paramampx.f() + paramFloat1, paramampx.e() + paramFloat2 - this.a.ascent(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amqr
 * JD-Core Version:    0.7.0.1
 */