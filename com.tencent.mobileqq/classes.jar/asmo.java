import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

public class asmo
{
  public int a;
  public int b;
  public int c;
  public int d;
  
  public static asmo a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSosoLbsInfo != null)
    {
      localObject1 = localObject2;
      if (paramSosoLbsInfo.mLocation != null)
      {
        localObject1 = new asmo();
        ((asmo)localObject1).a = ((int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
        ((asmo)localObject1).b = ((int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
        ((asmo)localObject1).d = 1;
        ((asmo)localObject1).c = ((int)paramSosoLbsInfo.mLocation.altitude);
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
 * Qualified Name:     asmo
 * JD-Core Version:    0.7.0.1
 */