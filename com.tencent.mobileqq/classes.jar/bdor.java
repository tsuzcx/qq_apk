import cooperation.wadl.ipc.WadlResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class bdor
  extends bdok
{
  private WeakReference<bdos> a;
  
  public bdor()
  {
    super(false, null);
  }
  
  public void a(bdos parambdos)
  {
    this.a = new WeakReference(parambdos);
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    super.onQueryCallback(paramArrayList);
    if ((this.a != null) && (this.a.get() != null)) {
      ((bdos)this.a.get()).a(paramArrayList);
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
      i = bdop.a(paramWadlResult.b);
    } while ((this.a == null) || (this.a.get() == null));
    ((bdos)this.a.get()).a(i, paramWadlResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdor
 * JD-Core Version:    0.7.0.1
 */