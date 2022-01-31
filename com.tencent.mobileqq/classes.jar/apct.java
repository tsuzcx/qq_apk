import android.graphics.Canvas;
import android.text.TextPaint;

public class apct
  extends apcq
{
  private TextPaint a = new TextPaint();
  
  private String a(apbq paramapbq)
  {
    return String.valueOf(paramapbq.a());
  }
  
  public apdo a(apbq paramapbq)
  {
    apcp localapcp = apbz.a();
    float f1 = apdr.a(localapcp.c(), a(paramapbq)) + localapcp.f() + localapcp.f();
    float f2 = apdr.a(localapcp.c());
    f2 = localapcp.e() * 2.0F + f2;
    paramapbq.a(f2);
    paramapbq.b(f1);
    return new apdo(f1, f2);
  }
  
  public boolean a(apbq paramapbq)
  {
    return true;
  }
  
  public void b(Canvas paramCanvas, apbq paramapbq, apbz paramapbz, float paramFloat1, float paramFloat2)
  {
    paramapbz = apbz.a();
    this.a.setTextSize(paramapbz.c());
    this.a.setColor(-1);
    paramCanvas.drawText(a(paramapbq), paramapbz.f() + paramFloat1, paramapbz.e() + paramFloat2 - this.a.ascent(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apct
 * JD-Core Version:    0.7.0.1
 */