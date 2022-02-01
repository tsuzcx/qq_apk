import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public final class bgvt
{
  private int jdField_a_of_type_Int = 16;
  @Nullable
  private final Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  @Nullable
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  @Nullable
  private final List<bgvv> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int = 12544;
  private final List<bgvx> jdField_b_of_type_JavaUtilList = new ArrayList();
  private int jdField_c_of_type_Int = -1;
  private final List<bgvu> jdField_c_of_type_JavaUtilList = new ArrayList();
  
  public bgvt(@NonNull Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      throw new IllegalArgumentException("Bitmap is not valid");
    }
    this.jdField_c_of_type_JavaUtilList.add(bgvr.a);
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaUtilList.add(bgvx.a);
    this.jdField_b_of_type_JavaUtilList.add(bgvx.b);
    this.jdField_b_of_type_JavaUtilList.add(bgvx.c);
    this.jdField_b_of_type_JavaUtilList.add(bgvx.d);
    this.jdField_b_of_type_JavaUtilList.add(bgvx.e);
    this.jdField_b_of_type_JavaUtilList.add(bgvx.f);
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    double d2 = -1.0D;
    int i;
    double d1;
    if (this.jdField_b_of_type_Int > 0)
    {
      i = paramBitmap.getWidth() * paramBitmap.getHeight();
      d1 = d2;
      if (i > this.jdField_b_of_type_Int) {
        d1 = Math.sqrt(this.jdField_b_of_type_Int / i);
      }
    }
    while (d1 <= 0.0D)
    {
      return paramBitmap;
      d1 = d2;
      if (this.jdField_c_of_type_Int > 0)
      {
        i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
        d1 = d2;
        if (i > this.jdField_c_of_type_Int) {
          d1 = this.jdField_c_of_type_Int / i;
        }
      }
    }
    return Bitmap.createScaledBitmap(paramBitmap, (int)Math.ceil(paramBitmap.getWidth() * d1), (int)Math.ceil(d1 * paramBitmap.getHeight()), false);
  }
  
  private int[] a(Bitmap paramBitmap)
  {
    int i = 0;
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int[] arrayOfInt = new int[j * k];
    paramBitmap.getPixels(arrayOfInt, 0, j, 0, 0, j, k);
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      return arrayOfInt;
    }
    k = this.jdField_a_of_type_AndroidGraphicsRect.width();
    int m = this.jdField_a_of_type_AndroidGraphicsRect.height();
    paramBitmap = new int[k * m];
    while (i < m)
    {
      System.arraycopy(arrayOfInt, (this.jdField_a_of_type_AndroidGraphicsRect.top + i) * j + this.jdField_a_of_type_AndroidGraphicsRect.left, paramBitmap, i * k, k);
      i += 1;
    }
    return paramBitmap;
  }
  
  @NonNull
  public bgvr a()
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      Bitmap localBitmap = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      if (0 != 0) {
        throw new NullPointerException();
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      if ((localBitmap != this.jdField_a_of_type_AndroidGraphicsBitmap) && (localObject != null))
      {
        double d = localBitmap.getWidth() / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        ((Rect)localObject).left = ((int)Math.floor(((Rect)localObject).left * d));
        ((Rect)localObject).top = ((int)Math.floor(((Rect)localObject).top * d));
        ((Rect)localObject).right = Math.min((int)Math.ceil(((Rect)localObject).right * d), localBitmap.getWidth());
        ((Rect)localObject).bottom = Math.min((int)Math.ceil(d * ((Rect)localObject).bottom), localBitmap.getHeight());
      }
      int[] arrayOfInt = a(localBitmap);
      int i = this.jdField_a_of_type_Int;
      if (this.jdField_c_of_type_JavaUtilList.isEmpty())
      {
        localObject = null;
        localObject = new bgvm(arrayOfInt, i, (bgvu[])localObject);
        if (localBitmap != this.jdField_a_of_type_AndroidGraphicsBitmap) {
          localBitmap.recycle();
        }
        localObject = ((bgvm)localObject).a();
        if (0 != 0) {
          throw new NullPointerException();
        }
      }
    }
    for (;;)
    {
      localObject = new bgvr((List)localObject, this.jdField_b_of_type_JavaUtilList);
      ((bgvr)localObject).a();
      if (0 != 0) {
        throw new NullPointerException();
      }
      return localObject;
      localObject = (bgvu[])this.jdField_c_of_type_JavaUtilList.toArray(new bgvu[this.jdField_c_of_type_JavaUtilList.size()]);
      break;
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label304;
      }
      localObject = this.jdField_a_of_type_JavaUtilList;
    }
    label304:
    throw new AssertionError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvt
 * JD-Core Version:    0.7.0.1
 */