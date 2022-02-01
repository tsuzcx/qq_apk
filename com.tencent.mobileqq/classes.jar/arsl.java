import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class arsl<D extends arrl>
{
  private ArrayList<arsq> a;
  
  private void c(Canvas paramCanvas, D paramD, arru paramarru, float paramFloat1, float paramFloat2)
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((arsq)localIterator.next()).a(paramCanvas, paramD, paramarru, paramFloat1, paramFloat2);
      }
    }
  }
  
  public abstract artj a(D paramD);
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, D paramD, arru paramarru, float paramFloat1, float paramFloat2)
  {
    b(paramCanvas, paramD, paramarru, paramFloat1, paramFloat2);
    c(paramCanvas, paramD, paramarru, paramFloat1, paramFloat2);
  }
  
  public void a(D paramD) {}
  
  public abstract boolean a(arrl paramarrl);
  
  public abstract void b(Canvas paramCanvas, D paramD, arru paramarru, float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arsl
 * JD-Core Version:    0.7.0.1
 */