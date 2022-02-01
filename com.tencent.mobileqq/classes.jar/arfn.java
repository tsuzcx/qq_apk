import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class arfn<D extends aren>
{
  private ArrayList<arfs> a;
  
  private void c(Canvas paramCanvas, D paramD, arew paramarew, float paramFloat1, float paramFloat2)
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((arfs)localIterator.next()).a(paramCanvas, paramD, paramarew, paramFloat1, paramFloat2);
      }
    }
  }
  
  public abstract argl a(D paramD);
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, D paramD, arew paramarew, float paramFloat1, float paramFloat2)
  {
    b(paramCanvas, paramD, paramarew, paramFloat1, paramFloat2);
    c(paramCanvas, paramD, paramarew, paramFloat1, paramFloat2);
  }
  
  public void a(D paramD) {}
  
  public abstract boolean a(aren paramaren);
  
  public abstract void b(Canvas paramCanvas, D paramD, arew paramarew, float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfn
 * JD-Core Version:    0.7.0.1
 */