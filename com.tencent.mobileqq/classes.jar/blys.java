import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class blys
  implements blyw
{
  private final blyv[] a;
  
  blys(blyv[] paramArrayOfblyv)
  {
    this.a = paramArrayOfblyv;
  }
  
  public void a(blzb paramblzb, blyy paramblyy)
  {
    int j = 0;
    blzd localblzd = new blzd();
    blyv[] arrayOfblyv = this.a;
    int k = arrayOfblyv.length;
    int i = 0;
    while (i < k)
    {
      arrayOfblyv[i].a(paramblzb, paramblyy, false, localblzd);
      i += 1;
    }
    arrayOfblyv = this.a;
    k = arrayOfblyv.length;
    i = j;
    while (i < k)
    {
      arrayOfblyv[i].a(paramblzb, paramblyy, true, localblzd);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blys
 * JD-Core Version:    0.7.0.1
 */