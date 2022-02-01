import android.graphics.Canvas;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import java.util.ArrayList;
import java.util.List;

public abstract class arsv
  extends arsl<arrt>
{
  private SparseArray<List<arsw>> a = new SparseArray();
  
  public int a(Object paramObject)
  {
    return 0;
  }
  
  public abstract arsw a(int paramInt);
  
  public artj a(arrt paramarrt)
  {
    int i = a(paramarrt.a());
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
    localObject = (arsw)((List)localObject).remove(0);
    a(i, (arsw)localObject, paramarrt);
    ((arsw)localObject).a(View.MeasureSpec.makeMeasureSpec(paramarrt.f(), -2147483648), View.MeasureSpec.makeMeasureSpec(paramarrt.g(), -2147483648));
    ((arsw)localObject).a(0, 0, ((arsw)localObject).a(), ((arsw)localObject).b());
    paramarrt.a((arsw)localObject);
    paramarrt.b(((arsw)localObject).a());
    paramarrt.a(((arsw)localObject).b());
    return new artj(((arsw)localObject).a(), ((arsw)localObject).b());
  }
  
  public abstract void a(int paramInt, arsw paramarsw, arrt paramarrt);
  
  public void a(Canvas paramCanvas, arrt paramarrt, arru paramarru, float paramFloat1, float paramFloat2)
  {
    paramarru = paramarrt.a();
    if (paramarru == null) {
      return;
    }
    if (!paramarrt.i())
    {
      paramarru.a(View.MeasureSpec.makeMeasureSpec(paramarru.a(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramarru.b(), 1073741824));
      paramarru.a(0, 0, paramarru.a(), paramarru.b());
      paramarrt.f(true);
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramarru.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(arrt paramarrt)
  {
    arsw localarsw = paramarrt.a();
    if (localarsw != null)
    {
      int i = a(paramarrt.a());
      List localList = (List)this.a.get(i);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.a.put(i, localObject);
      }
      ((List)localObject).add(localarsw);
      paramarrt.a(null);
    }
  }
  
  public boolean a(arrl paramarrl)
  {
    return paramarrl instanceof arrt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arsv
 * JD-Core Version:    0.7.0.1
 */