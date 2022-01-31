import android.graphics.Canvas;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import java.util.ArrayList;
import java.util.List;

public abstract class amqy
  extends amqo<ampw>
{
  private SparseArray<List<amqz>> a = new SparseArray();
  
  public int a(Object paramObject)
  {
    return 0;
  }
  
  public abstract amqz a(int paramInt);
  
  public amrm a(ampw paramampw)
  {
    int i = a(paramampw.a());
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
    localObject = (amqz)((List)localObject).remove(0);
    a(i, (amqz)localObject, paramampw);
    ((amqz)localObject).a(View.MeasureSpec.makeMeasureSpec(paramampw.f(), -2147483648), View.MeasureSpec.makeMeasureSpec(paramampw.g(), -2147483648));
    ((amqz)localObject).a(0, 0, ((amqz)localObject).a(), ((amqz)localObject).b());
    paramampw.a((amqz)localObject);
    paramampw.b(((amqz)localObject).a());
    paramampw.a(((amqz)localObject).b());
    return new amrm(((amqz)localObject).a(), ((amqz)localObject).b());
  }
  
  public abstract void a(int paramInt, amqz paramamqz, ampw paramampw);
  
  public void a(ampw paramampw)
  {
    amqz localamqz = paramampw.a();
    if (localamqz != null)
    {
      int i = a(paramampw.a());
      List localList = (List)this.a.get(i);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.a.put(i, localObject);
      }
      ((List)localObject).add(localamqz);
      paramampw.a(null);
    }
  }
  
  public void a(Canvas paramCanvas, ampw paramampw, ampx paramampx, float paramFloat1, float paramFloat2)
  {
    paramampx = paramampw.a();
    if (paramampx == null) {
      return;
    }
    if (!paramampw.i())
    {
      paramampx.a(View.MeasureSpec.makeMeasureSpec(paramampx.a(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramampx.b(), 1073741824));
      paramampx.a(0, 0, paramampx.a(), paramampx.b());
      paramampw.f(true);
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramampx.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean a(ampo paramampo)
  {
    return paramampo instanceof ampw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amqy
 * JD-Core Version:    0.7.0.1
 */