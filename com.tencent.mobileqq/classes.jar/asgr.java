import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

public class asgr
{
  public int a;
  public int b;
  public int c;
  public int d;
  
  public static asgr a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSosoLbsInfo != null)
    {
      localObject1 = localObject2;
      if (paramSosoLbsInfo.a != null)
      {
        localObject1 = new asgr();
        ((asgr)localObject1).a = ((int)(paramSosoLbsInfo.a.a * 1000000.0D));
        ((asgr)localObject1).b = ((int)(paramSosoLbsInfo.a.b * 1000000.0D));
        ((asgr)localObject1).d = 1;
        ((asgr)localObject1).c = ((int)paramSosoLbsInfo.a.e);
      }
    }
    return localObject1;
  }
  
  @NonNull
  public String toString()
  {
    return "lat:" + this.a + " lon:" + this.b + " alt:" + this.c + " type:" + this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgr
 * JD-Core Version:    0.7.0.1
 */