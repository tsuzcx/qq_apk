import android.graphics.Canvas;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import java.util.ArrayList;
import java.util.List;

public abstract class anhk
  extends anha<angi>
{
  private SparseArray<List<anhl>> a = new SparseArray();
  
  public int a(Object paramObject)
  {
    return 0;
  }
  
  public abstract anhl a(int paramInt);
  
  public anhy a(angi paramangi)
  {
    int i = a(paramangi.a());
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
    localObject = (anhl)((List)localObject).remove(0);
    a(i, (anhl)localObject, paramangi);
    ((anhl)localObject).a(View.MeasureSpec.makeMeasureSpec(paramangi.f(), -2147483648), View.MeasureSpec.makeMeasureSpec(paramangi.g(), -2147483648));
    ((anhl)localObject).a(0, 0, ((anhl)localObject).a(), ((anhl)localObject).b());
    paramangi.a((anhl)localObject);
    paramangi.b(((anhl)localObject).a());
    paramangi.a(((anhl)localObject).b());
    return new anhy(((anhl)localObject).a(), ((anhl)localObject).b());
  }
  
  public abstract void a(int paramInt, anhl paramanhl, angi paramangi);
  
  public void a(Canvas paramCanvas, angi paramangi, angj paramangj, float paramFloat1, float paramFloat2)
  {
    paramangj = paramangi.a();
    if (paramangj == null) {
      return;
    }
    if (!paramangi.i())
    {
      paramangj.a(View.MeasureSpec.makeMeasureSpec(paramangj.a(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramangj.b(), 1073741824));
      paramangj.a(0, 0, paramangj.a(), paramangj.b());
      paramangi.f(true);
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramangj.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(angi paramangi)
  {
    anhl localanhl = paramangi.a();
    if (localanhl != null)
    {
      int i = a(paramangi.a());
      List localList = (List)this.a.get(i);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.a.put(i, localObject);
      }
      ((List)localObject).add(localanhl);
      paramangi.a(null);
    }
  }
  
  public boolean a(anga paramanga)
  {
    return paramanga instanceof angi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anhk
 * JD-Core Version:    0.7.0.1
 */