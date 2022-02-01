import android.graphics.Canvas;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import java.util.ArrayList;
import java.util.List;

public abstract class arvm
  extends arvc<aruk>
{
  private SparseArray<List<arvn>> a = new SparseArray();
  
  public int a(Object paramObject)
  {
    return 0;
  }
  
  public abstract arvn a(int paramInt);
  
  public arwa a(aruk paramaruk)
  {
    int i = a(paramaruk.a());
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
    localObject = (arvn)((List)localObject).remove(0);
    a(i, (arvn)localObject, paramaruk);
    ((arvn)localObject).a(View.MeasureSpec.makeMeasureSpec(paramaruk.f(), -2147483648), View.MeasureSpec.makeMeasureSpec(paramaruk.g(), -2147483648));
    ((arvn)localObject).a(0, 0, ((arvn)localObject).a(), ((arvn)localObject).b());
    paramaruk.a((arvn)localObject);
    paramaruk.b(((arvn)localObject).a());
    paramaruk.a(((arvn)localObject).b());
    return new arwa(((arvn)localObject).a(), ((arvn)localObject).b());
  }
  
  public abstract void a(int paramInt, arvn paramarvn, aruk paramaruk);
  
  public void a(Canvas paramCanvas, aruk paramaruk, arul paramarul, float paramFloat1, float paramFloat2)
  {
    paramarul = paramaruk.a();
    if (paramarul == null) {
      return;
    }
    if (!paramaruk.i())
    {
      paramarul.a(View.MeasureSpec.makeMeasureSpec(paramarul.a(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramarul.b(), 1073741824));
      paramarul.a(0, 0, paramarul.a(), paramarul.b());
      paramaruk.f(true);
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramarul.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(aruk paramaruk)
  {
    arvn localarvn = paramaruk.a();
    if (localarvn != null)
    {
      int i = a(paramaruk.a());
      List localList = (List)this.a.get(i);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.a.put(i, localObject);
      }
      ((List)localObject).add(localarvn);
      paramaruk.a(null);
    }
  }
  
  public boolean a(aruc paramaruc)
  {
    return paramaruc instanceof aruk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvm
 * JD-Core Version:    0.7.0.1
 */