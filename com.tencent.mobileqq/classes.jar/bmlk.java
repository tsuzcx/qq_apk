import com.tencent.mobileqq.app.ThreadManager;
import cooperation.vip.ad.TianshuSplashManager.TianShuGetSplashCallback.1;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.tianshu.TianShuGetAdvCallback;
import mqq.os.MqqHandler;

public class bmlk
  implements TianShuGetAdvCallback
{
  public String a;
  
  public bmlk(bmlj parambmlj, String paramString)
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
 * Qualified Name:     bmlk
 * JD-Core Version:    0.7.0.1
 */