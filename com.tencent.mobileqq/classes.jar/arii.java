import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

public class arii
{
  public int a;
  public int b;
  public int c;
  public int d;
  
  public static arii a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSosoLbsInfo != null)
    {
      localObject1 = localObject2;
      if (paramSosoLbsInfo.mLocation != null)
      {
        localObject1 = new arii();
        ((arii)localObject1).a = ((int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
        ((arii)localObject1).b = ((int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
        ((arii)localObject1).d = 1;
        ((arii)localObject1).c = ((int)paramSosoLbsInfo.mLocation.altitude);
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
 * Qualified Name:     arii
 * JD-Core Version:    0.7.0.1
 */