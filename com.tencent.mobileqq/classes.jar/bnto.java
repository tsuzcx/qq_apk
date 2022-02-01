import com.tencent.mobileqq.app.ThreadManager;
import cooperation.vip.ad.TianshuAdManager.1.1;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import mqq.os.MqqHandler;

public class bnto
  implements bnwp
{
  bnto(bntn parambntn) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if ((paramBoolean) && (paramGetAdsRsp != null)) {
      ThreadManager.getUIHandler().postDelayed(new TianshuAdManager.1.1(this, paramGetAdsRsp), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnto
 * JD-Core Version:    0.7.0.1
 */