import android.os.Bundle;
import android.util.SparseArray;

public abstract class axlo
{
  protected static SparseArray<Class<?>> a = new SparseArray();
  protected static SparseArray<Class<?>> b = new SparseArray();
  
  static
  {
    a.put(1, axlq.class);
  }
  
  public abstract int a();
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putInt("redpoint.fromReceiverIPCCode", a());
  }
  
  public void b(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axlo
 * JD-Core Version:    0.7.0.1
 */