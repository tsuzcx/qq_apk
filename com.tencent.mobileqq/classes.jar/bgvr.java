import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseBooleanArray;
import java.util.List;

public final class bgvr
{
  static final bgvu jdField_a_of_type_Bgvu = new bgvs();
  private final SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  @Nullable
  private final bgvv jdField_a_of_type_Bgvv;
  private final bgvw<bgvx, bgvv> jdField_a_of_type_Bgvw;
  private final List<bgvv> jdField_a_of_type_JavaUtilList;
  private final List<bgvx> b;
  
  bgvr(List<bgvv> paramList, List<bgvx> paramList1)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramList1;
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_Bgvw = new bgvw();
    this.jdField_a_of_type_Bgvv = b();
  }
  
  private float a(bgvv parambgvv, bgvx parambgvx)
  {
    float f3 = 0.0F;
    float[] arrayOfFloat = parambgvv.a();
    int i;
    if (this.jdField_a_of_type_Bgvv != null)
    {
      i = this.jdField_a_of_type_Bgvv.b();
      if (parambgvx.g() <= 0.0F) {
        break label135;
      }
      f1 = parambgvx.g();
    }
    label135:
    for (float f1 = (1.0F - Math.abs(arrayOfFloat[1] - parambgvx.b())) * f1;; f1 = 0.0F)
    {
      if (parambgvx.h() > 0.0F) {
        f2 = parambgvx.h();
      }
      for (float f2 = (1.0F - Math.abs(arrayOfFloat[2] - parambgvx.e())) * f2;; f2 = 0.0F)
      {
        if (parambgvx.i() > 0.0F) {
          f3 = parambgvx.i() * (parambgvv.b() / i);
        }
        return f1 + f2 + f3;
        i = 1;
        break;
      }
    }
  }
  
  @NonNull
  public static bgvt a(@NonNull Bitmap paramBitmap)
  {
    return new bgvt(paramBitmap);
  }
  
  @Nullable
  private bgvv a(bgvx parambgvx)
  {
    bgvv localbgvv = b(parambgvx);
    if ((localbgvv != null) && (parambgvx.a())) {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray.append(localbgvv.a(), true);
    }
    return localbgvv;
  }
  
  private boolean a(bgvv parambgvv, bgvx parambgvx)
  {
    float[] arrayOfFloat = parambgvv.a();
    return (arrayOfFloat[1] >= parambgvx.a()) && (arrayOfFloat[1] <= parambgvx.c()) && (arrayOfFloat[2] >= parambgvx.d()) && (arrayOfFloat[2] <= parambgvx.f()) && (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(parambgvv.a()));
  }
  
  @Nullable
  private bgvv b()
  {
    int i = -2147483648;
    Object localObject = null;
    int k = this.jdField_a_of_type_JavaUtilList.size();
    int j = 0;
    if (j < k)
    {
      bgvv localbgvv = (bgvv)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localbgvv.b() <= i) {
        break label67;
      }
      i = localbgvv.b();
      localObject = localbgvv;
    }
    label67:
    for (;;)
    {
      j += 1;
      break;
      return localObject;
    }
  }
  
  @Nullable
  private bgvv b(bgvx parambgvx)
  {
    float f1 = 0.0F;
    Object localObject = null;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j)
    {
      bgvv localbgvv = (bgvv)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!a(localbgvv, parambgvx)) {
        break label89;
      }
      float f2 = a(localbgvv, parambgvx);
      if ((localObject != null) && (f2 <= f1)) {
        break label89;
      }
      f1 = f2;
      localObject = localbgvv;
    }
    label89:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  @Nullable
  public bgvv a()
  {
    return this.jdField_a_of_type_Bgvv;
  }
  
  void a()
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      bgvx localbgvx = (bgvx)this.b.get(i);
      localbgvx.a();
      this.jdField_a_of_type_Bgvw.b(localbgvx, a(localbgvx));
      i += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvr
 * JD-Core Version:    0.7.0.1
 */