import com.tencent.mobileqq.flutter.channel.zanranking.ZanRankingIpcServer.GetCoverTask;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;

public class aunu
  extends VasQuickUpdateManager.CallBacker
{
  public aunu(ZanRankingIpcServer.GetCoverTask paramGetCoverTask) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 15L) && (paramString1.startsWith("card.")) && (paramInt1 == 0) && (this.a.a != null)) {
      ZanRankingIpcServer.GetCoverTask.a(this.a, this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aunu
 * JD-Core Version:    0.7.0.1
 */