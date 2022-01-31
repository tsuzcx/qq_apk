import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bhux
  implements bhvb
{
  private final bhva[] a;
  
  bhux(bhva[] paramArrayOfbhva)
  {
    this.a = paramArrayOfbhva;
  }
  
  public void a(bhvg parambhvg, bhvd parambhvd)
  {
    int j = 0;
    bhvi localbhvi = new bhvi();
    bhva[] arrayOfbhva = this.a;
    int k = arrayOfbhva.length;
    int i = 0;
    while (i < k)
    {
      arrayOfbhva[i].a(parambhvg, parambhvd, false, localbhvi);
      i += 1;
    }
    arrayOfbhva = this.a;
    k = arrayOfbhva.length;
    i = j;
    while (i < k)
    {
      arrayOfbhva[i].a(parambhvg, parambhvd, true, localbhvi);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhux
 * JD-Core Version:    0.7.0.1
 */