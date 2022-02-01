import com.tencent.mobileqq.app.ThreadManager;
import cooperation.vip.ad.TianshuRenewalsBarManager.TianshuGetRenewalsBarCallback.1;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.tianshu.TianShuGetAdvCallback;
import mqq.os.MqqHandler;

public class bmli
  implements TianShuGetAdvCallback
{
  public String a;
  
  public bmli(bmlf parambmlf, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if ((paramBoolean) && (paramGetAdsRsp != null)) {
      ThreadManager.getUIHandler().postDelayed(new TianshuRenewalsBarManager.TianshuGetRenewalsBarCallback.1(this, paramGetAdsRsp), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmli
 * JD-Core Version:    0.7.0.1
 */