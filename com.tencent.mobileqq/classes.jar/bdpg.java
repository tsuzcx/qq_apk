import cooperation.wadl.ipc.WadlResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class bdpg
  extends bdoz
{
  private WeakReference<bdph> a;
  
  public bdpg()
  {
    super(false, null);
  }
  
  public void a(bdph parambdph)
  {
    this.a = new WeakReference(parambdph);
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    super.onQueryCallback(paramArrayList);
    if ((this.a != null) && (this.a.get() != null)) {
      ((bdph)this.a.get()).a(paramArrayList);
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
      i = bdpe.a(paramWadlResult.b);
    } while ((this.a == null) || (this.a.get() == null));
    ((bdph)this.a.get()).a(i, paramWadlResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdpg
 * JD-Core Version:    0.7.0.1
 */