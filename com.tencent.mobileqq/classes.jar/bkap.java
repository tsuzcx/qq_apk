import cooperation.wadl.ipc.WadlResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class bkap
  extends bkaj
{
  private WeakReference<bkaq> a;
  
  public bkap()
  {
    super(false, null);
  }
  
  public void a(bkaq parambkaq)
  {
    this.a = new WeakReference(parambkaq);
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    super.onQueryCallback(paramArrayList);
    if ((this.a != null) && (this.a.get() != null)) {
      ((bkaq)this.a.get()).a(paramArrayList);
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
      i = bkan.a(paramWadlResult.b);
    } while ((this.a == null) || (this.a.get() == null));
    ((bkaq)this.a.get()).a(i, paramWadlResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkap
 * JD-Core Version:    0.7.0.1
 */