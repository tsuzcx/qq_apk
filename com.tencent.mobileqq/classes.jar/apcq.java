import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class apcq<D extends apbq>
{
  private ArrayList<apcv> a;
  
  private void c(Canvas paramCanvas, D paramD, apbz paramapbz, float paramFloat1, float paramFloat2)
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((apcv)localIterator.next()).a(paramCanvas, paramD, paramapbz, paramFloat1, paramFloat2);
      }
    }
  }
  
  public abstract apdo a(D paramD);
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, D paramD, apbz paramapbz, float paramFloat1, float paramFloat2)
  {
    b(paramCanvas, paramD, paramapbz, paramFloat1, paramFloat2);
    c(paramCanvas, paramD, paramapbz, paramFloat1, paramFloat2);
  }
  
  public void a(D paramD) {}
  
  public abstract boolean a(apbq paramapbq);
  
  public abstract void b(Canvas paramCanvas, D paramD, apbz paramapbz, float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcq
 * JD-Core Version:    0.7.0.1
 */