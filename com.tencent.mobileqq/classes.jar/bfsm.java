import cooperation.wadl.ipc.WadlResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class bfsm
  extends bfsf
{
  private WeakReference<bfsn> a;
  
  public bfsm()
  {
    super(false, null);
  }
  
  public void a(bfsn parambfsn)
  {
    this.a = new WeakReference(parambfsn);
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    super.onQueryCallback(paramArrayList);
    if ((this.a != null) && (this.a.get() != null)) {
      ((bfsn)this.a.get()).a(paramArrayList);
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
      i = bfsk.a(paramWadlResult.b);
    } while ((this.a == null) || (this.a.get() == null));
    ((bfsn)this.a.get()).a(i, paramWadlResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfsm
 * JD-Core Version:    0.7.0.1
 */