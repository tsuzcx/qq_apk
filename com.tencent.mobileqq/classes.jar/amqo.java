import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class amqo<D extends ampo>
{
  private ArrayList<amqt> a;
  
  private void c(Canvas paramCanvas, D paramD, ampx paramampx, float paramFloat1, float paramFloat2)
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((amqt)localIterator.next()).a(paramCanvas, paramD, paramampx, paramFloat1, paramFloat2);
      }
    }
  }
  
  public abstract amrm a(D paramD);
  
  public void a() {}
  
  public void a(D paramD) {}
  
  public final void a(Canvas paramCanvas, D paramD, ampx paramampx, float paramFloat1, float paramFloat2)
  {
    b(paramCanvas, paramD, paramampx, paramFloat1, paramFloat2);
    c(paramCanvas, paramD, paramampx, paramFloat1, paramFloat2);
  }
  
  public abstract boolean a(ampo paramampo);
  
  public abstract void b(Canvas paramCanvas, D paramD, ampx paramampx, float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amqo
 * JD-Core Version:    0.7.0.1
 */