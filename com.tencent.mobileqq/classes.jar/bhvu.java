import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseBooleanArray;
import java.util.List;

public final class bhvu
{
  static final bhvx jdField_a_of_type_Bhvx = new bhvv();
  private final SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  @Nullable
  private final bhvy jdField_a_of_type_Bhvy;
  private final bhvz<bhwa, bhvy> jdField_a_of_type_Bhvz;
  private final List<bhvy> jdField_a_of_type_JavaUtilList;
  private final List<bhwa> b;
  
  bhvu(List<bhvy> paramList, List<bhwa> paramList1)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramList1;
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_Bhvz = new bhvz();
    this.jdField_a_of_type_Bhvy = b();
  }
  
  private float a(bhvy parambhvy, bhwa parambhwa)
  {
    float f3 = 0.0F;
    float[] arrayOfFloat = parambhvy.a();
    int i;
    if (this.jdField_a_of_type_Bhvy != null)
    {
      i = this.jdField_a_of_type_Bhvy.b();
      if (parambhwa.g() <= 0.0F) {
        break label135;
      }
      f1 = parambhwa.g();
    }
    label135:
    for (float f1 = (1.0F - Math.abs(arrayOfFloat[1] - parambhwa.b())) * f1;; f1 = 0.0F)
    {
      if (parambhwa.h() > 0.0F) {
        f2 = parambhwa.h();
      }
      for (float f2 = (1.0F - Math.abs(arrayOfFloat[2] - parambhwa.e())) * f2;; f2 = 0.0F)
      {
        if (parambhwa.i() > 0.0F) {
          f3 = parambhwa.i() * (parambhvy.b() / i);
        }
        return f1 + f2 + f3;
        i = 1;
        break;
      }
    }
  }
  
  @NonNull
  public static bhvw a(@NonNull Bitmap paramBitmap)
  {
    return new bhvw(paramBitmap);
  }
  
  @Nullable
  private bhvy a(bhwa parambhwa)
  {
    bhvy localbhvy = b(parambhwa);
    if ((localbhvy != null) && (parambhwa.a())) {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray.append(localbhvy.a(), true);
    }
    return localbhvy;
  }
  
  private boolean a(bhvy parambhvy, bhwa parambhwa)
  {
    float[] arrayOfFloat = parambhvy.a();
    return (arrayOfFloat[1] >= parambhwa.a()) && (arrayOfFloat[1] <= parambhwa.c()) && (arrayOfFloat[2] >= parambhwa.d()) && (arrayOfFloat[2] <= parambhwa.f()) && (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(parambhvy.a()));
  }
  
  @Nullable
  private bhvy b()
  {
    int i = -2147483648;
    Object localObject = null;
    int k = this.jdField_a_of_type_JavaUtilList.size();
    int j = 0;
    if (j < k)
    {
      bhvy localbhvy = (bhvy)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localbhvy.b() <= i) {
        break label67;
      }
      i = localbhvy.b();
      localObject = localbhvy;
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
  private bhvy b(bhwa parambhwa)
  {
    float f1 = 0.0F;
    Object localObject = null;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j)
    {
      bhvy localbhvy = (bhvy)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!a(localbhvy, parambhwa)) {
        break label89;
      }
      float f2 = a(localbhvy, parambhwa);
      if ((localObject != null) && (f2 <= f1)) {
        break label89;
      }
      f1 = f2;
      localObject = localbhvy;
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
  public bhvy a()
  {
    return this.jdField_a_of_type_Bhvy;
  }
  
  void a()
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      bhwa localbhwa = (bhwa)this.b.get(i);
      localbhwa.a();
      this.jdField_a_of_type_Bhvz.b(localbhwa, a(localbhwa));
      i += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhvu
 * JD-Core Version:    0.7.0.1
 */