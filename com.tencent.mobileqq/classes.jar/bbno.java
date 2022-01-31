import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseBooleanArray;
import java.util.List;

public final class bbno
{
  static final bbnr jdField_a_of_type_Bbnr = new bbnp();
  private final SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  @Nullable
  private final bbns jdField_a_of_type_Bbns;
  private final bbnt<bbnu, bbns> jdField_a_of_type_Bbnt;
  private final List<bbns> jdField_a_of_type_JavaUtilList;
  private final List<bbnu> b;
  
  bbno(List<bbns> paramList, List<bbnu> paramList1)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramList1;
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_Bbnt = new bbnt();
    this.jdField_a_of_type_Bbns = b();
  }
  
  private float a(bbns parambbns, bbnu parambbnu)
  {
    float f3 = 0.0F;
    float[] arrayOfFloat = parambbns.a();
    int i;
    if (this.jdField_a_of_type_Bbns != null)
    {
      i = this.jdField_a_of_type_Bbns.b();
      if (parambbnu.g() <= 0.0F) {
        break label135;
      }
      f1 = parambbnu.g();
    }
    label135:
    for (float f1 = (1.0F - Math.abs(arrayOfFloat[1] - parambbnu.b())) * f1;; f1 = 0.0F)
    {
      if (parambbnu.h() > 0.0F) {
        f2 = parambbnu.h();
      }
      for (float f2 = (1.0F - Math.abs(arrayOfFloat[2] - parambbnu.e())) * f2;; f2 = 0.0F)
      {
        if (parambbnu.i() > 0.0F) {
          f3 = parambbnu.i() * (parambbns.b() / i);
        }
        return f1 + f2 + f3;
        i = 1;
        break;
      }
    }
  }
  
  @NonNull
  public static bbnq a(@NonNull Bitmap paramBitmap)
  {
    return new bbnq(paramBitmap);
  }
  
  @Nullable
  private bbns a(bbnu parambbnu)
  {
    bbns localbbns = b(parambbnu);
    if ((localbbns != null) && (parambbnu.a())) {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray.append(localbbns.a(), true);
    }
    return localbbns;
  }
  
  private boolean a(bbns parambbns, bbnu parambbnu)
  {
    float[] arrayOfFloat = parambbns.a();
    return (arrayOfFloat[1] >= parambbnu.a()) && (arrayOfFloat[1] <= parambbnu.c()) && (arrayOfFloat[2] >= parambbnu.d()) && (arrayOfFloat[2] <= parambbnu.f()) && (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(parambbns.a()));
  }
  
  @Nullable
  private bbns b()
  {
    int i = -2147483648;
    Object localObject = null;
    int k = this.jdField_a_of_type_JavaUtilList.size();
    int j = 0;
    if (j < k)
    {
      bbns localbbns = (bbns)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localbbns.b() <= i) {
        break label67;
      }
      i = localbbns.b();
      localObject = localbbns;
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
  private bbns b(bbnu parambbnu)
  {
    float f1 = 0.0F;
    Object localObject = null;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j)
    {
      bbns localbbns = (bbns)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!a(localbbns, parambbnu)) {
        break label89;
      }
      float f2 = a(localbbns, parambbnu);
      if ((localObject != null) && (f2 <= f1)) {
        break label89;
      }
      f1 = f2;
      localObject = localbbns;
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
  public bbns a()
  {
    return this.jdField_a_of_type_Bbns;
  }
  
  void a()
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      bbnu localbbnu = (bbnu)this.b.get(i);
      localbbnu.a();
      this.jdField_a_of_type_Bbnt.b(localbbnu, a(localbbnu));
      i += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbno
 * JD-Core Version:    0.7.0.1
 */