import com.tencent.mobileqq.app.ThreadManager;
import cooperation.vip.ad.TianshuSplashManager.TianShuGetSplashCallback.1;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import mqq.os.MqqHandler;

public class bkzg
  implements blbv
{
  public String a;
  
  public bkzg(bkzf parambkzf, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if ((paramBoolean) && (paramGetAdsRsp != null)) {
      ThreadManager.getUIHandler().postDelayed(new TianshuSplashManager.TianShuGetSplashCallback.1(this, paramGetAdsRsp), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzg
 * JD-Core Version:    0.7.0.1
 */