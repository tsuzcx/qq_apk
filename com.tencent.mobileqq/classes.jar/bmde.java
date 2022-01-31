import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bmde
  implements bmdi
{
  private final bmdh[] a;
  
  bmde(bmdh[] paramArrayOfbmdh)
  {
    this.a = paramArrayOfbmdh;
  }
  
  public void a(bmdn parambmdn, bmdk parambmdk)
  {
    int j = 0;
    bmdp localbmdp = new bmdp();
    bmdh[] arrayOfbmdh = this.a;
    int k = arrayOfbmdh.length;
    int i = 0;
    while (i < k)
    {
      arrayOfbmdh[i].a(parambmdn, parambmdk, false, localbmdp);
      i += 1;
    }
    arrayOfbmdh = this.a;
    k = arrayOfbmdh.length;
    i = j;
    while (i < k)
    {
      arrayOfbmdh[i].a(parambmdn, parambmdk, true, localbmdp);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmde
 * JD-Core Version:    0.7.0.1
 */