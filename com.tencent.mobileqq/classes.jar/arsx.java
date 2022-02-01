import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;
import java.util.Iterator;
import java.util.LinkedList;

public class arsx
{
  private final int jdField_a_of_type_Int;
  private final LinkedList<Bitmap> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private int b;
  private int c;
  private int d;
  
  public arsx()
  {
    DisplayMetrics localDisplayMetrics = arqu.a().a().a().getDisplayMetrics();
    int i = localDisplayMetrics.widthPixels;
    this.jdField_a_of_type_Int = (localDisplayMetrics.heightPixels * i * 8);
  }
  
  private void b(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.remove(paramBitmap);
    if (paramBitmap != null)
    {
      this.b -= paramBitmap.getRowBytes() * paramBitmap.getHeight();
      if ((!paramBitmap.isRecycled()) && (!arqu.a().a().c())) {
        paramBitmap.recycle();
      }
    }
  }
  
  public int a()
  {
    return this.b;
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    this.c += 1;
    Object localObject1 = null;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    Object localObject2;
    if (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if ((localBitmap.getWidth() >= paramInt1) && (localBitmap.getHeight() >= paramInt2)) {
        if (localObject1 == null) {
          localObject2 = localBitmap;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        break;
        localObject2 = localBitmap;
        if (localObject1.getHeight() * localObject1.getWidth() < localBitmap.getHeight() * localBitmap.getWidth()) {
          localObject2 = localObject1;
        }
      }
    }
    if (localObject1 != null)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(localObject1);
      this.b -= localObject1.getRowBytes() * localObject1.getHeight();
      return localObject1;
    }
    try
    {
      this.d += 1;
      localObject2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
      return localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      artm.a("BitmapCacheManager", "create bitmap out of memory", localOutOfMemoryError);
    }
    return localObject1;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if ((localBitmap != null) && (!localBitmap.isRecycled()) && (!arqu.a().a().c())) {
        localBitmap.recycle();
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.b = 0;
    this.c = 0;
    this.d = 0;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {}
    for (;;)
    {
      return;
      this.b += paramBitmap.getRowBytes() * paramBitmap.getHeight();
      this.jdField_a_of_type_JavaUtilLinkedList.addLast(paramBitmap);
      while (this.b > this.jdField_a_of_type_Int)
      {
        paramBitmap = null;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        if (localIterator.hasNext())
        {
          Bitmap localBitmap2 = (Bitmap)localIterator.next();
          Bitmap localBitmap1;
          if (paramBitmap == null) {
            localBitmap1 = localBitmap2;
          }
          for (;;)
          {
            paramBitmap = localBitmap1;
            break;
            localBitmap1 = localBitmap2;
            if (paramBitmap.getHeight() * paramBitmap.getWidth() < localBitmap2.getHeight() * localBitmap2.getWidth()) {
              localBitmap1 = paramBitmap;
            }
          }
        }
        if (paramBitmap != null) {
          b(paramBitmap);
        }
      }
    }
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arsx
 * JD-Core Version:    0.7.0.1
 */