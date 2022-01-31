import android.graphics.Bitmap;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.image.Utils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class bbqj
  implements Sizeable
{
  public int a;
  public HashMap<Integer, Bitmap> a = new HashMap();
  public int b;
  
  public int getByteSize()
  {
    Iterator localIterator = this.a.values().iterator();
    for (int i = 0; localIterator.hasNext(); i = Utils.getBitmapSize((Bitmap)localIterator.next()) + i) {}
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbqj
 * JD-Core Version:    0.7.0.1
 */