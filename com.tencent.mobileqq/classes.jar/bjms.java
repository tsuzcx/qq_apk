import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class bjms
  implements bjmw
{
  private final bjmv[] a;
  
  bjms(bjmv[] paramArrayOfbjmv)
  {
    this.a = paramArrayOfbjmv;
  }
  
  public void a(bjnb parambjnb, bjmy parambjmy)
  {
    int j = 0;
    bjnd localbjnd = new bjnd();
    bjmv[] arrayOfbjmv = this.a;
    int k = arrayOfbjmv.length;
    int i = 0;
    while (i < k)
    {
      arrayOfbjmv[i].a(parambjnb, parambjmy, false, localbjnd);
      i += 1;
    }
    arrayOfbjmv = this.a;
    k = arrayOfbjmv.length;
    i = j;
    while (i < k)
    {
      arrayOfbjmv[i].a(parambjnb, parambjmy, true, localbjnd);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjms
 * JD-Core Version:    0.7.0.1
 */