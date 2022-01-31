import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseBooleanArray;
import java.util.List;

public final class bbna
{
  static final bbnd jdField_a_of_type_Bbnd = new bbnb();
  private final SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  @Nullable
  private final bbne jdField_a_of_type_Bbne;
  private final bbnf<bbng, bbne> jdField_a_of_type_Bbnf;
  private final List<bbne> jdField_a_of_type_JavaUtilList;
  private final List<bbng> b;
  
  bbna(List<bbne> paramList, List<bbng> paramList1)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramList1;
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_Bbnf = new bbnf();
    this.jdField_a_of_type_Bbne = b();
  }
  
  private float a(bbne parambbne, bbng parambbng)
  {
    float f3 = 0.0F;
    float[] arrayOfFloat = parambbne.a();
    int i;
    if (this.jdField_a_of_type_Bbne != null)
    {
      i = this.jdField_a_of_type_Bbne.b();
      if (parambbng.g() <= 0.0F) {
        break label135;
      }
      f1 = parambbng.g();
    }
    label135:
    for (float f1 = (1.0F - Math.abs(arrayOfFloat[1] - parambbng.b())) * f1;; f1 = 0.0F)
    {
      if (parambbng.h() > 0.0F) {
        f2 = parambbng.h();
      }
      for (float f2 = (1.0F - Math.abs(arrayOfFloat[2] - parambbng.e())) * f2;; f2 = 0.0F)
      {
        if (parambbng.i() > 0.0F) {
          f3 = parambbng.i() * (parambbne.b() / i);
        }
        return f1 + f2 + f3;
        i = 1;
        break;
      }
    }
  }
  
  @NonNull
  public static bbnc a(@NonNull Bitmap paramBitmap)
  {
    return new bbnc(paramBitmap);
  }
  
  @Nullable
  private bbne a(bbng parambbng)
  {
    bbne localbbne = b(parambbng);
    if ((localbbne != null) && (parambbng.a())) {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray.append(localbbne.a(), true);
    }
    return localbbne;
  }
  
  private boolean a(bbne parambbne, bbng parambbng)
  {
    float[] arrayOfFloat = parambbne.a();
    return (arrayOfFloat[1] >= parambbng.a()) && (arrayOfFloat[1] <= parambbng.c()) && (arrayOfFloat[2] >= parambbng.d()) && (arrayOfFloat[2] <= parambbng.f()) && (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(parambbne.a()));
  }
  
  @Nullable
  private bbne b()
  {
    int i = -2147483648;
    Object localObject = null;
    int k = this.jdField_a_of_type_JavaUtilList.size();
    int j = 0;
    if (j < k)
    {
      bbne localbbne = (bbne)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localbbne.b() <= i) {
        break label67;
      }
      i = localbbne.b();
      localObject = localbbne;
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
  private bbne b(bbng parambbng)
  {
    float f1 = 0.0F;
    Object localObject = null;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j)
    {
      bbne localbbne = (bbne)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!a(localbbne, parambbng)) {
        break label89;
      }
      float f2 = a(localbbne, parambbng);
      if ((localObject != null) && (f2 <= f1)) {
        break label89;
      }
      f1 = f2;
      localObject = localbbne;
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
  public bbne a()
  {
    return this.jdField_a_of_type_Bbne;
  }
  
  void a()
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      bbng localbbng = (bbng)this.b.get(i);
      localbbng.a();
      this.jdField_a_of_type_Bbnf.b(localbbng, a(localbbng));
      i += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbna
 * JD-Core Version:    0.7.0.1
 */