import android.os.Bundle;
import android.util.SparseArray;

public abstract class azuz
{
  protected static SparseArray<Class<?>> a = new SparseArray();
  protected static SparseArray<Class<?>> b = new SparseArray();
  
  static
  {
    a.put(1, azvb.class);
  }
  
  public abstract int a();
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putInt("redpoint.fromReceiverIPCCode", a());
  }
  
  public void b(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azuz
 * JD-Core Version:    0.7.0.1
 */