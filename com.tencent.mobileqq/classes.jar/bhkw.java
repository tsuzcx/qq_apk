import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseBooleanArray;
import java.util.List;

public final class bhkw
{
  static final bhkz jdField_a_of_type_Bhkz = new bhkx();
  private final SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  @Nullable
  private final bhla jdField_a_of_type_Bhla;
  private final bhlb<bhlc, bhla> jdField_a_of_type_Bhlb;
  private final List<bhla> jdField_a_of_type_JavaUtilList;
  private final List<bhlc> b;
  
  bhkw(List<bhla> paramList, List<bhlc> paramList1)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramList1;
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_Bhlb = new bhlb();
    this.jdField_a_of_type_Bhla = b();
  }
  
  private float a(bhla parambhla, bhlc parambhlc)
  {
    float f3 = 0.0F;
    float[] arrayOfFloat = parambhla.a();
    int i;
    if (this.jdField_a_of_type_Bhla != null)
    {
      i = this.jdField_a_of_type_Bhla.b();
      if (parambhlc.g() <= 0.0F) {
        break label135;
      }
      f1 = parambhlc.g();
    }
    label135:
    for (float f1 = (1.0F - Math.abs(arrayOfFloat[1] - parambhlc.b())) * f1;; f1 = 0.0F)
    {
      if (parambhlc.h() > 0.0F) {
        f2 = parambhlc.h();
      }
      for (float f2 = (1.0F - Math.abs(arrayOfFloat[2] - parambhlc.e())) * f2;; f2 = 0.0F)
      {
        if (parambhlc.i() > 0.0F) {
          f3 = parambhlc.i() * (parambhla.b() / i);
        }
        return f1 + f2 + f3;
        i = 1;
        break;
      }
    }
  }
  
  @NonNull
  public static bhky a(@NonNull Bitmap paramBitmap)
  {
    return new bhky(paramBitmap);
  }
  
  @Nullable
  private bhla a(bhlc parambhlc)
  {
    bhla localbhla = b(parambhlc);
    if ((localbhla != null) && (parambhlc.a())) {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray.append(localbhla.a(), true);
    }
    return localbhla;
  }
  
  private boolean a(bhla parambhla, bhlc parambhlc)
  {
    float[] arrayOfFloat = parambhla.a();
    return (arrayOfFloat[1] >= parambhlc.a()) && (arrayOfFloat[1] <= parambhlc.c()) && (arrayOfFloat[2] >= parambhlc.d()) && (arrayOfFloat[2] <= parambhlc.f()) && (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(parambhla.a()));
  }
  
  @Nullable
  private bhla b()
  {
    int i = -2147483648;
    Object localObject = null;
    int k = this.jdField_a_of_type_JavaUtilList.size();
    int j = 0;
    if (j < k)
    {
      bhla localbhla = (bhla)this.jdField_a_of_type_JavaUtilList.get(j);
      if (localbhla.b() <= i) {
        break label67;
      }
      i = localbhla.b();
      localObject = localbhla;
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
  private bhla b(bhlc parambhlc)
  {
    float f1 = 0.0F;
    Object localObject = null;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j)
    {
      bhla localbhla = (bhla)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!a(localbhla, parambhlc)) {
        break label89;
      }
      float f2 = a(localbhla, parambhlc);
      if ((localObject != null) && (f2 <= f1)) {
        break label89;
      }
      f1 = f2;
      localObject = localbhla;
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
  public bhla a()
  {
    return this.jdField_a_of_type_Bhla;
  }
  
  void a()
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      bhlc localbhlc = (bhlc)this.b.get(i);
      localbhlc.a();
      this.jdField_a_of_type_Bhlb.b(localbhlc, a(localbhlc));
      i += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhkw
 * JD-Core Version:    0.7.0.1
 */