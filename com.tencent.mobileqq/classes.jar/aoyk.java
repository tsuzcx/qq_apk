import android.graphics.Canvas;
import android.text.TextPaint;

public class aoyk
  extends aoyh
{
  private TextPaint a = new TextPaint();
  
  private String a(aoxh paramaoxh)
  {
    return String.valueOf(paramaoxh.a());
  }
  
  public aozf a(aoxh paramaoxh)
  {
    aoyg localaoyg = aoxq.a();
    float f1 = aozi.a(localaoyg.c(), a(paramaoxh)) + localaoyg.f() + localaoyg.f();
    float f2 = aozi.a(localaoyg.c());
    f2 = localaoyg.e() * 2.0F + f2;
    paramaoxh.a(f2);
    paramaoxh.b(f1);
    return new aozf(f1, f2);
  }
  
  public boolean a(aoxh paramaoxh)
  {
    return true;
  }
  
  public void b(Canvas paramCanvas, aoxh paramaoxh, aoxq paramaoxq, float paramFloat1, float paramFloat2)
  {
    paramaoxq = aoxq.a();
    this.a.setTextSize(paramaoxq.c());
    this.a.setColor(-1);
    paramCanvas.drawText(a(paramaoxh), paramaoxq.f() + paramFloat1, paramaoxq.e() + paramFloat2 - this.a.ascent(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoyk
 * JD-Core Version:    0.7.0.1
 */