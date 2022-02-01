import android.graphics.Canvas;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import java.util.ArrayList;
import java.util.List;

public abstract class aqpk
  extends aqpa<aqoi>
{
  private SparseArray<List<aqpl>> a = new SparseArray();
  
  public int a(Object paramObject)
  {
    return 0;
  }
  
  public abstract aqpl a(int paramInt);
  
  public aqpy a(aqoi paramaqoi)
  {
    int i = a(paramaqoi.a());
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
    localObject = (aqpl)((List)localObject).remove(0);
    a(i, (aqpl)localObject, paramaqoi);
    ((aqpl)localObject).a(View.MeasureSpec.makeMeasureSpec(paramaqoi.f(), -2147483648), View.MeasureSpec.makeMeasureSpec(paramaqoi.g(), -2147483648));
    ((aqpl)localObject).a(0, 0, ((aqpl)localObject).a(), ((aqpl)localObject).b());
    paramaqoi.a((aqpl)localObject);
    paramaqoi.b(((aqpl)localObject).a());
    paramaqoi.a(((aqpl)localObject).b());
    return new aqpy(((aqpl)localObject).a(), ((aqpl)localObject).b());
  }
  
  public abstract void a(int paramInt, aqpl paramaqpl, aqoi paramaqoi);
  
  public void a(Canvas paramCanvas, aqoi paramaqoi, aqoj paramaqoj, float paramFloat1, float paramFloat2)
  {
    paramaqoj = paramaqoi.a();
    if (paramaqoj == null) {
      return;
    }
    if (!paramaqoi.i())
    {
      paramaqoj.a(View.MeasureSpec.makeMeasureSpec(paramaqoj.a(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramaqoj.b(), 1073741824));
      paramaqoj.a(0, 0, paramaqoj.a(), paramaqoj.b());
      paramaqoi.f(true);
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramaqoj.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(aqoi paramaqoi)
  {
    aqpl localaqpl = paramaqoi.a();
    if (localaqpl != null)
    {
      int i = a(paramaqoi.a());
      List localList = (List)this.a.get(i);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.a.put(i, localObject);
      }
      ((List)localObject).add(localaqpl);
      paramaqoi.a(null);
    }
  }
  
  public boolean a(aqoa paramaqoa)
  {
    return paramaqoa instanceof aqoi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpk
 * JD-Core Version:    0.7.0.1
 */