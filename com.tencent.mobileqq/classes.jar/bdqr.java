import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseBooleanArray;
import java.util.List;

public final class bdqr
{
  static final bdqu jdField_a_of_type_Bdqu = new bdqs();
  private final SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  @Nullable
  private final bdqv jdField_a_of_type_Bdqv;
  private final bdqw<bdqx, bdqv> jdField_a_of_type_Bdqw;
  private final List<bdqv> jdField_a_of_type_JavaUtilList;
  private final List<bdqx> b;
  
  bdqr(List<bdqv> paramList, List<bdqx> paramList1)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramList1;
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_Bdqw = new bdqw();
    this.jdField_a_of_type_Bdqv = b();
  }
  
  private float a(bdqv parambdqv, bdqx parambdqx)
  {
    float f3 = 0.0F;
    float[] arrayOfFloat = parambdqv.a();
    int i;
    if (this.jdField_a_of_type_Bdqv != null)
    {
      i = this.jdField_a_of_type_Bdqv.b();
      if (parambdqx.g() <= 0.0F) {
        break label135;
      }
      f1 = parambdqx.g();
    }
    label135:
    for (float f1 = (1.0F - Math.abs(arrayOfFloat[1] - parambdqx.b())) * f1;; f1 = 0.0F)
    {
      if (parambdqx.h() > 0.0F) {
        f2 = parambdqx.h();
      }
      for (float f2 = (1.0F - Math.abs(arrayOfFloat[2] - parambdqx.e())) * f2;; f2 = 0.0F)
      {
        if (parambdqx.i() > 0.0F) {
          f3 = parambdqx.i() * (parambdqv.b() / i);
        }
        return f1 + f2 + f3;
        i = 1;
        break;
      }
    }
  }
  
  @NonNull
  public static bdqt a(@NonNull Bitmap paramBitmap)
  {
    return new bdqt(paramBitmap);
  }
  
  @Nullable
  private bdqv a(bdqx parambdqx)
  {
    bdqv localbdqv = b(parambdqx);
    if ((localbdqv != null) && (parambdqx.a())) {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray.append(localbdqv.a(), true);
    }
    return localbdqv;
  }
  
  private boolean a(bdqv parambdqv, bdqx parambdqx)
  {
    float[] arrayOfFloat = parambdqv.a();
    return (arrayOfFloat[1] >= parambdqx.a()) && (arrayOfFloat[1] <= parambdqx.c()) && (arrayOfFloat[2] >= parambdqx.d()) && (arrayOfFloat[2] <= parambdqx.f()) && (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(parambdqv.a()));
  }
  
  @Nullable
  private bdqv b()
  {
    int i = -2147483648;
    Object localObject = null;
    int k = this.jdField_a_of_type_JavaUtilList.size();
    int j = 0;
    if (j < k)
    {
      bdqv localbdqv = (bdqv)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localbdqv.b() <= i) {
        break label67;
      }
      i = localbdqv.b();
      localObject = localbdqv;
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
  private bdqv b(bdqx parambdqx)
  {
    float f1 = 0.0F;
    Object localObject = null;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j)
    {
      bdqv localbdqv = (bdqv)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!a(localbdqv, parambdqx)) {
        break label89;
      }
      float f2 = a(localbdqv, parambdqx);
      if ((localObject != null) && (f2 <= f1)) {
        break label89;
      }
      f1 = f2;
      localObject = localbdqv;
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
  public bdqv a()
  {
    return this.jdField_a_of_type_Bdqv;
  }
  
  void a()
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      bdqx localbdqx = (bdqx)this.b.get(i);
      localbdqx.a();
      this.jdField_a_of_type_Bdqw.b(localbdqx, a(localbdqx));
      i += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqr
 * JD-Core Version:    0.7.0.1
 */