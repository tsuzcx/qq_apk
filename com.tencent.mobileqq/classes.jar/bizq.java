import cooperation.wadl.ipc.WadlResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class bizq
  extends bizk
{
  private WeakReference<bizr> a;
  
  public bizq()
  {
    super(false, null);
  }
  
  public void a(bizr parambizr)
  {
    this.a = new WeakReference(parambizr);
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    super.onQueryCallback(paramArrayList);
    if ((this.a != null) && (this.a.get() != null)) {
      ((bizr)this.a.get()).a(paramArrayList);
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
      i = bizo.a(paramWadlResult.b);
    } while ((this.a == null) || (this.a.get() == null));
    ((bizr)this.a.get()).a(i, paramWadlResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bizq
 * JD-Core Version:    0.7.0.1
 */