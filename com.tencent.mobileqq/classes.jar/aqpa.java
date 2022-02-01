import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class aqpa<D extends aqoa>
{
  private ArrayList<aqpf> a;
  
  private void c(Canvas paramCanvas, D paramD, aqoj paramaqoj, float paramFloat1, float paramFloat2)
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((aqpf)localIterator.next()).a(paramCanvas, paramD, paramaqoj, paramFloat1, paramFloat2);
      }
    }
  }
  
  public abstract aqpy a(D paramD);
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, D paramD, aqoj paramaqoj, float paramFloat1, float paramFloat2)
  {
    b(paramCanvas, paramD, paramaqoj, paramFloat1, paramFloat2);
    c(paramCanvas, paramD, paramaqoj, paramFloat1, paramFloat2);
  }
  
  public void a(D paramD) {}
  
  public abstract boolean a(aqoa paramaqoa);
  
  public abstract void b(Canvas paramCanvas, D paramD, aqoj paramaqoj, float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpa
 * JD-Core Version:    0.7.0.1
 */