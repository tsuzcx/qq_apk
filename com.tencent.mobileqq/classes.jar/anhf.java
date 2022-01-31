import android.graphics.Canvas;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import java.util.ArrayList;
import java.util.List;

public abstract class anhf
  extends angv<angd>
{
  private SparseArray<List<anhg>> a = new SparseArray();
  
  public int a(Object paramObject)
  {
    return 0;
  }
  
  public abstract anhg a(int paramInt);
  
  public anht a(angd paramangd)
  {
    int i = a(paramangd.a());
    List localList = (List)this.a.get(i);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.a.put(i, localObject);
    }
    if (((List)localObject).isEmpty()) {
      ((List)localObject).add(a(i));
    }
    localObject = (anhg)((List)localObject).remove(0);
    a(i, (anhg)localObject, paramangd);
    ((anhg)localObject).a(View.MeasureSpec.makeMeasureSpec(paramangd.f(), -2147483648), View.MeasureSpec.makeMeasureSpec(paramangd.g(), -2147483648));
    ((anhg)localObject).a(0, 0, ((anhg)localObject).a(), ((anhg)localObject).b());
    paramangd.a((anhg)localObject);
    paramangd.b(((anhg)localObject).a());
    paramangd.a(((anhg)localObject).b());
    return new anht(((anhg)localObject).a(), ((anhg)localObject).b());
  }
  
  public abstract void a(int paramInt, anhg paramanhg, angd paramangd);
  
  public void a(Canvas paramCanvas, angd paramangd, ange paramange, float paramFloat1, float paramFloat2)
  {
    paramange = paramangd.a();
    if (paramange == null) {
      return;
    }
    if (!paramangd.i())
    {
      paramange.a(View.MeasureSpec.makeMeasureSpec(paramange.a(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramange.b(), 1073741824));
      paramange.a(0, 0, paramange.a(), paramange.b());
      paramangd.f(true);
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramange.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(angd paramangd)
  {
    anhg localanhg = paramangd.a();
    if (localanhg != null)
    {
      int i = a(paramangd.a());
      List localList = (List)this.a.get(i);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.a.put(i, localObject);
      }
      ((List)localObject).add(localanhg);
      paramangd.a(null);
    }
  }
  
  public boolean a(anfv paramanfv)
  {
    return paramanfv instanceof angd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anhf
 * JD-Core Version:    0.7.0.1
 */