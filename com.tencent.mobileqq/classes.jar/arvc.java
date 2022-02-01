import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class arvc<D extends aruc>
{
  private ArrayList<arvh> a;
  
  private void c(Canvas paramCanvas, D paramD, arul paramarul, float paramFloat1, float paramFloat2)
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((arvh)localIterator.next()).a(paramCanvas, paramD, paramarul, paramFloat1, paramFloat2);
      }
    }
  }
  
  public abstract arwa a(D paramD);
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, D paramD, arul paramarul, float paramFloat1, float paramFloat2)
  {
    b(paramCanvas, paramD, paramarul, paramFloat1, paramFloat2);
    c(paramCanvas, paramD, paramarul, paramFloat1, paramFloat2);
  }
  
  public void a(D paramD) {}
  
  public abstract boolean a(aruc paramaruc);
  
  public abstract void b(Canvas paramCanvas, D paramD, arul paramarul, float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvc
 * JD-Core Version:    0.7.0.1
 */