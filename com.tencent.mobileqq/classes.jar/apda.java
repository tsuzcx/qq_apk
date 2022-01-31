import android.graphics.Canvas;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import java.util.ArrayList;
import java.util.List;

public abstract class apda
  extends apcq<apby>
{
  private SparseArray<List<apdb>> a = new SparseArray();
  
  public int a(Object paramObject)
  {
    return 0;
  }
  
  public abstract apdb a(int paramInt);
  
  public apdo a(apby paramapby)
  {
    int i = a(paramapby.a());
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
    localObject = (apdb)((List)localObject).remove(0);
    a(i, (apdb)localObject, paramapby);
    ((apdb)localObject).a(View.MeasureSpec.makeMeasureSpec(paramapby.f(), -2147483648), View.MeasureSpec.makeMeasureSpec(paramapby.g(), -2147483648));
    ((apdb)localObject).a(0, 0, ((apdb)localObject).a(), ((apdb)localObject).b());
    paramapby.a((apdb)localObject);
    paramapby.b(((apdb)localObject).a());
    paramapby.a(((apdb)localObject).b());
    return new apdo(((apdb)localObject).a(), ((apdb)localObject).b());
  }
  
  public abstract void a(int paramInt, apdb paramapdb, apby paramapby);
  
  public void a(Canvas paramCanvas, apby paramapby, apbz paramapbz, float paramFloat1, float paramFloat2)
  {
    paramapbz = paramapby.a();
    if (paramapbz == null) {
      return;
    }
    if (!paramapby.i())
    {
      paramapbz.a(View.MeasureSpec.makeMeasureSpec(paramapbz.a(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramapbz.b(), 1073741824));
      paramapbz.a(0, 0, paramapbz.a(), paramapbz.b());
      paramapby.f(true);
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramapbz.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(apby paramapby)
  {
    apdb localapdb = paramapby.a();
    if (localapdb != null)
    {
      int i = a(paramapby.a());
      List localList = (List)this.a.get(i);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.a.put(i, localObject);
      }
      ((List)localObject).add(localapdb);
      paramapby.a(null);
    }
  }
  
  public boolean a(apbq paramapbq)
  {
    return paramapbq instanceof apby;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apda
 * JD-Core Version:    0.7.0.1
 */