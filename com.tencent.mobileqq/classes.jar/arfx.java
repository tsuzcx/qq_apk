import android.graphics.Canvas;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import java.util.ArrayList;
import java.util.List;

public abstract class arfx
  extends arfn<arev>
{
  private SparseArray<List<arfy>> a = new SparseArray();
  
  public int a(Object paramObject)
  {
    return 0;
  }
  
  public abstract arfy a(int paramInt);
  
  public argl a(arev paramarev)
  {
    int i = a(paramarev.a());
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
    localObject = (arfy)((List)localObject).remove(0);
    a(i, (arfy)localObject, paramarev);
    ((arfy)localObject).a(View.MeasureSpec.makeMeasureSpec(paramarev.f(), -2147483648), View.MeasureSpec.makeMeasureSpec(paramarev.g(), -2147483648));
    ((arfy)localObject).a(0, 0, ((arfy)localObject).a(), ((arfy)localObject).b());
    paramarev.a((arfy)localObject);
    paramarev.b(((arfy)localObject).a());
    paramarev.a(((arfy)localObject).b());
    return new argl(((arfy)localObject).a(), ((arfy)localObject).b());
  }
  
  public abstract void a(int paramInt, arfy paramarfy, arev paramarev);
  
  public void a(Canvas paramCanvas, arev paramarev, arew paramarew, float paramFloat1, float paramFloat2)
  {
    paramarew = paramarev.a();
    if (paramarew == null) {
      return;
    }
    if (!paramarev.i())
    {
      paramarew.a(View.MeasureSpec.makeMeasureSpec(paramarew.a(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramarew.b(), 1073741824));
      paramarew.a(0, 0, paramarew.a(), paramarew.b());
      paramarev.f(true);
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramarew.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(arev paramarev)
  {
    arfy localarfy = paramarev.a();
    if (localarfy != null)
    {
      int i = a(paramarev.a());
      List localList = (List)this.a.get(i);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.a.put(i, localObject);
      }
      ((List)localObject).add(localarfy);
      paramarev.a(null);
    }
  }
  
  public boolean a(aren paramaren)
  {
    return paramaren instanceof arev;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfx
 * JD-Core Version:    0.7.0.1
 */