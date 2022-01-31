import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class angv<D extends anfv>
{
  private ArrayList<anha> a;
  
  private void c(Canvas paramCanvas, D paramD, ange paramange, float paramFloat1, float paramFloat2)
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((anha)localIterator.next()).a(paramCanvas, paramD, paramange, paramFloat1, paramFloat2);
      }
    }
  }
  
  public abstract anht a(D paramD);
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, D paramD, ange paramange, float paramFloat1, float paramFloat2)
  {
    b(paramCanvas, paramD, paramange, paramFloat1, paramFloat2);
    c(paramCanvas, paramD, paramange, paramFloat1, paramFloat2);
  }
  
  public void a(D paramD) {}
  
  public abstract boolean a(anfv paramanfv);
  
  public abstract void b(Canvas paramCanvas, D paramD, ange paramange, float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     angv
 * JD-Core Version:    0.7.0.1
 */