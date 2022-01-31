import cooperation.wadl.ipc.WadlResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class bfod
  extends bfnw
{
  private WeakReference<bfoe> a;
  
  public bfod()
  {
    super(false, null);
  }
  
  public void a(bfoe parambfoe)
  {
    this.a = new WeakReference(parambfoe);
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    super.onQueryCallback(paramArrayList);
    if ((this.a != null) && (this.a.get() != null)) {
      ((bfoe)this.a.get()).a(paramArrayList);
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
      i = bfob.a(paramWadlResult.b);
    } while ((this.a == null) || (this.a.get() == null));
    ((bfoe)this.a.get()).a(i, paramWadlResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfod
 * JD-Core Version:    0.7.0.1
 */