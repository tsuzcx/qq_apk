import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.tianshu.TianShuGetAdvCallback;

class bmnj
  implements TianShuGetAdvCallback
{
  bmnj(bmni parambmni) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    this.a.a(paramBoolean, paramGetAdsRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmnj
 * JD-Core Version:    0.7.0.1
 */