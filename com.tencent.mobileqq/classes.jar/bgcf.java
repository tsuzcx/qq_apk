import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseBooleanArray;
import java.util.List;

public final class bgcf
{
  static final bgci jdField_a_of_type_Bgci = new bgcg();
  private final SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  @Nullable
  private final bgcj jdField_a_of_type_Bgcj;
  private final bgck<bgcl, bgcj> jdField_a_of_type_Bgck;
  private final List<bgcj> jdField_a_of_type_JavaUtilList;
  private final List<bgcl> b;
  
  bgcf(List<bgcj> paramList, List<bgcl> paramList1)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramList1;
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_Bgck = new bgck();
    this.jdField_a_of_type_Bgcj = b();
  }
  
  private float a(bgcj parambgcj, bgcl parambgcl)
  {
    float f3 = 0.0F;
    float[] arrayOfFloat = parambgcj.a();
    int i;
    if (this.jdField_a_of_type_Bgcj != null)
    {
      i = this.jdField_a_of_type_Bgcj.b();
      if (parambgcl.g() <= 0.0F) {
        break label135;
      }
      f1 = parambgcl.g();
    }
    label135:
    for (float f1 = (1.0F - Math.abs(arrayOfFloat[1] - parambgcl.b())) * f1;; f1 = 0.0F)
    {
      if (parambgcl.h() > 0.0F) {
        f2 = parambgcl.h();
      }
      for (float f2 = (1.0F - Math.abs(arrayOfFloat[2] - parambgcl.e())) * f2;; f2 = 0.0F)
      {
        if (parambgcl.i() > 0.0F) {
          f3 = parambgcl.i() * (parambgcj.b() / i);
        }
        return f1 + f2 + f3;
        i = 1;
        break;
      }
    }
  }
  
  @NonNull
  public static bgch a(@NonNull Bitmap paramBitmap)
  {
    return new bgch(paramBitmap);
  }
  
  @Nullable
  private bgcj a(bgcl parambgcl)
  {
    bgcj localbgcj = b(parambgcl);
    if ((localbgcj != null) && (parambgcl.a())) {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray.append(localbgcj.a(), true);
    }
    return localbgcj;
  }
  
  private boolean a(bgcj parambgcj, bgcl parambgcl)
  {
    float[] arrayOfFloat = parambgcj.a();
    return (arrayOfFloat[1] >= parambgcl.a()) && (arrayOfFloat[1] <= parambgcl.c()) && (arrayOfFloat[2] >= parambgcl.d()) && (arrayOfFloat[2] <= parambgcl.f()) && (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(parambgcj.a()));
  }
  
  @Nullable
  private bgcj b()
  {
    int i = -2147483648;
    Object localObject = null;
    int k = this.jdField_a_of_type_JavaUtilList.size();
    int j = 0;
    if (j < k)
    {
      bgcj localbgcj = (bgcj)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localbgcj.b() <= i) {
        break label67;
      }
      i = localbgcj.b();
      localObject = localbgcj;
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
  private bgcj b(bgcl parambgcl)
  {
    float f1 = 0.0F;
    Object localObject = null;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j)
    {
      bgcj localbgcj = (bgcj)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!a(localbgcj, parambgcl)) {
        break label89;
      }
      float f2 = a(localbgcj, parambgcl);
      if ((localObject != null) && (f2 <= f1)) {
        break label89;
      }
      f1 = f2;
      localObject = localbgcj;
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
  public bgcj a()
  {
    return this.jdField_a_of_type_Bgcj;
  }
  
  void a()
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      bgcl localbgcl = (bgcl)this.b.get(i);
      localbgcl.a();
      this.jdField_a_of_type_Bgck.b(localbgcl, a(localbgcl));
      i += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgcf
 * JD-Core Version:    0.7.0.1
 */