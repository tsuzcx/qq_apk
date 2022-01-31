import android.graphics.Canvas;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import java.util.ArrayList;
import java.util.List;

public abstract class aoyr
  extends aoyh<aoxp>
{
  private SparseArray<List<aoys>> a = new SparseArray();
  
  public int a(Object paramObject)
  {
    return 0;
  }
  
  public abstract aoys a(int paramInt);
  
  public aozf a(aoxp paramaoxp)
  {
    int i = a(paramaoxp.a());
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
    localObject = (aoys)((List)localObject).remove(0);
    a(i, (aoys)localObject, paramaoxp);
    ((aoys)localObject).a(View.MeasureSpec.makeMeasureSpec(paramaoxp.f(), -2147483648), View.MeasureSpec.makeMeasureSpec(paramaoxp.g(), -2147483648));
    ((aoys)localObject).a(0, 0, ((aoys)localObject).a(), ((aoys)localObject).b());
    paramaoxp.a((aoys)localObject);
    paramaoxp.b(((aoys)localObject).a());
    paramaoxp.a(((aoys)localObject).b());
    return new aozf(((aoys)localObject).a(), ((aoys)localObject).b());
  }
  
  public abstract void a(int paramInt, aoys paramaoys, aoxp paramaoxp);
  
  public void a(Canvas paramCanvas, aoxp paramaoxp, aoxq paramaoxq, float paramFloat1, float paramFloat2)
  {
    paramaoxq = paramaoxp.a();
    if (paramaoxq == null) {
      return;
    }
    if (!paramaoxp.i())
    {
      paramaoxq.a(View.MeasureSpec.makeMeasureSpec(paramaoxq.a(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramaoxq.b(), 1073741824));
      paramaoxq.a(0, 0, paramaoxq.a(), paramaoxq.b());
      paramaoxp.f(true);
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramaoxq.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(aoxp paramaoxp)
  {
    aoys localaoys = paramaoxp.a();
    if (localaoys != null)
    {
      int i = a(paramaoxp.a());
      List localList = (List)this.a.get(i);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.a.put(i, localObject);
      }
      ((List)localObject).add(localaoys);
      paramaoxp.a(null);
    }
  }
  
  public boolean a(aoxh paramaoxh)
  {
    return paramaoxh instanceof aoxp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoyr
 * JD-Core Version:    0.7.0.1
 */