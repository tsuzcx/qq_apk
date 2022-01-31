import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bjnj
  implements bjnn
{
  private final bjnm[] a;
  
  bjnj(bjnm[] paramArrayOfbjnm)
  {
    this.a = paramArrayOfbjnm;
  }
  
  public void a(bjns parambjns, bjnp parambjnp)
  {
    int j = 0;
    bjnu localbjnu = new bjnu();
    bjnm[] arrayOfbjnm = this.a;
    int k = arrayOfbjnm.length;
    int i = 0;
    while (i < k)
    {
      arrayOfbjnm[i].a(parambjns, parambjnp, false, localbjnu);
      i += 1;
    }
    arrayOfbjnm = this.a;
    k = arrayOfbjnm.length;
    i = j;
    while (i < k)
    {
      arrayOfbjnm[i].a(parambjns, parambjnp, true, localbjnu);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjnj
 * JD-Core Version:    0.7.0.1
 */