import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class aspx
{
  public static void a()
  {
    if (Build.VERSION.SDK_INT > 25)
    {
      Runtime.getRuntime().gc();
      Runtime.getRuntime().gc();
      Runtime.getRuntime().runFinalization();
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < 2)
      {
        ArrayList localArrayList = new ArrayList();
        do
        {
          localArrayList.add(new WeakReference(new byte[100]));
        } while (((WeakReference)localArrayList.get((int)(Math.random() * localArrayList.size()))).get() != null);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aspx
 * JD-Core Version:    0.7.0.1
 */