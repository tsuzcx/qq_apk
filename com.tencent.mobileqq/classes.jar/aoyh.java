import android.graphics.Canvas;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class aoyh<D extends aoxh>
{
  private ArrayList<aoym> a;
  
  private void c(Canvas paramCanvas, D paramD, aoxq paramaoxq, float paramFloat1, float paramFloat2)
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((aoym)localIterator.next()).a(paramCanvas, paramD, paramaoxq, paramFloat1, paramFloat2);
      }
    }
  }
  
  public abstract aozf a(D paramD);
  
  public void a() {}
  
  public final void a(Canvas paramCanvas, D paramD, aoxq paramaoxq, float paramFloat1, float paramFloat2)
  {
    b(paramCanvas, paramD, paramaoxq, paramFloat1, paramFloat2);
    c(paramCanvas, paramD, paramaoxq, paramFloat1, paramFloat2);
  }
  
  public void a(D paramD) {}
  
  public abstract boolean a(aoxh paramaoxh);
  
  public abstract void b(Canvas paramCanvas, D paramD, aoxq paramaoxq, float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoyh
 * JD-Core Version:    0.7.0.1
 */