import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class anha<D extends anga>
{
  private ArrayList<anhf> a;
  
  private void c(Canvas paramCanvas, D paramD, angj paramangj, float paramFloat1, float paramFloat2)
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((anhf)localIterator.next()).a(paramCanvas, paramD, paramangj, paramFloat1, paramFloat2);
      }
    }
  }
  
  public abstract anhy a(D paramD);
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, D paramD, angj paramangj, float paramFloat1, float paramFloat2)
  {
    b(paramCanvas, paramD, paramangj, paramFloat1, paramFloat2);
    c(paramCanvas, paramD, paramangj, paramFloat1, paramFloat2);
  }
  
  public void a(D paramD) {}
  
  public abstract boolean a(anga paramanga);
  
  public abstract void b(Canvas paramCanvas, D paramD, angj paramangj, float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anha
 * JD-Core Version:    0.7.0.1
 */