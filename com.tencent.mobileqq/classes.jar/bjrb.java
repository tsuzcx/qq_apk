import cooperation.wadl.ipc.WadlResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class bjrb
  extends bjqv
{
  private WeakReference<bjrc> a;
  
  public bjrb()
  {
    super(false, null);
  }
  
  public void a(bjrc parambjrc)
  {
    this.a = new WeakReference(parambjrc);
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    super.onQueryCallback(paramArrayList);
    if ((this.a != null) && (this.a.get() != null)) {
      ((bjrc)this.a.get()).a(paramArrayList);
    }
  }
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    super.onWadlTaskStatusChanged(paramWadlResult);
    if ((paramWadlResult == null) || (paramWadlResult.a == null)) {}
    int i;
    do
    {
      return;
      i = bjqz.a(paramWadlResult.b);
    } while ((this.a == null) || (this.a.get() == null));
    ((bjrc)this.a.get()).a(i, paramWadlResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjrb
 * JD-Core Version:    0.7.0.1
 */