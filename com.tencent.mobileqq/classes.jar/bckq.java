import cooperation.wadl.ipc.WadlResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class bckq
  extends bckj
{
  private WeakReference<bckr> a;
  
  public bckq()
  {
    super(false, null);
  }
  
  public void a(bckr parambckr)
  {
    this.a = new WeakReference(parambckr);
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    super.onQueryCallback(paramArrayList);
    if ((this.a != null) && (this.a.get() != null)) {
      ((bckr)this.a.get()).a(paramArrayList);
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
      i = bcko.a(paramWadlResult.b);
    } while ((this.a == null) || (this.a.get() == null));
    ((bckr)this.a.get()).a(i, paramWadlResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bckq
 * JD-Core Version:    0.7.0.1
 */