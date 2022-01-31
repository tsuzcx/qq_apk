import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseBooleanArray;
import java.util.List;

public final class bdmi
{
  static final bdml jdField_a_of_type_Bdml = new bdmj();
  private final SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  @Nullable
  private final bdmm jdField_a_of_type_Bdmm;
  private final bdmn<bdmo, bdmm> jdField_a_of_type_Bdmn;
  private final List<bdmm> jdField_a_of_type_JavaUtilList;
  private final List<bdmo> b;
  
  bdmi(List<bdmm> paramList, List<bdmo> paramList1)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramList1;
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_Bdmn = new bdmn();
    this.jdField_a_of_type_Bdmm = b();
  }
  
  private float a(bdmm parambdmm, bdmo parambdmo)
  {
    float f3 = 0.0F;
    float[] arrayOfFloat = parambdmm.a();
    int i;
    if (this.jdField_a_of_type_Bdmm != null)
    {
      i = this.jdField_a_of_type_Bdmm.b();
      if (parambdmo.g() <= 0.0F) {
        break label135;
      }
      f1 = parambdmo.g();
    }
    label135:
    for (float f1 = (1.0F - Math.abs(arrayOfFloat[1] - parambdmo.b())) * f1;; f1 = 0.0F)
    {
      if (parambdmo.h() > 0.0F) {
        f2 = parambdmo.h();
      }
      for (float f2 = (1.0F - Math.abs(arrayOfFloat[2] - parambdmo.e())) * f2;; f2 = 0.0F)
      {
        if (parambdmo.i() > 0.0F) {
          f3 = parambdmo.i() * (parambdmm.b() / i);
        }
        return f1 + f2 + f3;
        i = 1;
        break;
      }
    }
  }
  
  @NonNull
  public static bdmk a(@NonNull Bitmap paramBitmap)
  {
    return new bdmk(paramBitmap);
  }
  
  @Nullable
  private bdmm a(bdmo parambdmo)
  {
    bdmm localbdmm = b(parambdmo);
    if ((localbdmm != null) && (parambdmo.a())) {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray.append(localbdmm.a(), true);
    }
    return localbdmm;
  }
  
  private boolean a(bdmm parambdmm, bdmo parambdmo)
  {
    float[] arrayOfFloat = parambdmm.a();
    return (arrayOfFloat[1] >= parambdmo.a()) && (arrayOfFloat[1] <= parambdmo.c()) && (arrayOfFloat[2] >= parambdmo.d()) && (arrayOfFloat[2] <= parambdmo.f()) && (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(parambdmm.a()));
  }
  
  @Nullable
  private bdmm b()
  {
    int i = -2147483648;
    Object localObject = null;
    int k = this.jdField_a_of_type_JavaUtilList.size();
    int j = 0;
    if (j < k)
    {
      bdmm localbdmm = (bdmm)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localbdmm.b() <= i) {
        break label67;
      }
      i = localbdmm.b();
      localObject = localbdmm;
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
  private bdmm b(bdmo parambdmo)
  {
    float f1 = 0.0F;
    Object localObject = null;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j)
    {
      bdmm localbdmm = (bdmm)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!a(localbdmm, parambdmo)) {
        break label89;
      }
      float f2 = a(localbdmm, parambdmo);
      if ((localObject != null) && (f2 <= f1)) {
        break label89;
      }
      f1 = f2;
      localObject = localbdmm;
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
  public bdmm a()
  {
    return this.jdField_a_of_type_Bdmm;
  }
  
  void a()
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      bdmo localbdmo = (bdmo)this.b.get(i);
      localbdmo.a();
      this.jdField_a_of_type_Bdmn.b(localbdmo, a(localbdmo));
      i += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdmi
 * JD-Core Version:    0.7.0.1
 */