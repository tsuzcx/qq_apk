import QC.UniBusiCommItemAidInfo;
import QC.UniBusiGetOneItemWithCheckRsp;
import QC.UniBusiSimpleItemDetail;

class auyd
  implements auyi
{
  auyd(auyb paramauyb) {}
  
  public void a(boolean paramBoolean, UniBusiGetOneItemWithCheckRsp paramUniBusiGetOneItemWithCheckRsp)
  {
    if (auyb.a(this.a) == null) {}
    do
    {
      do
      {
        return;
        if (paramBoolean) {
          break label195;
        }
        if ((paramUniBusiGetOneItemWithCheckRsp == null) || (paramUniBusiGetOneItemWithCheckRsp.stDetail == null)) {
          break;
        }
      } while (paramUniBusiGetOneItemWithCheckRsp.stDetail.itemId != auyb.a(this.a).itemId);
      if (paramUniBusiGetOneItemWithCheckRsp.ret == 0)
      {
        auyb.a(this.a, false);
        this.a.b();
        return;
      }
    } while (!auyb.a(this.a));
    auyb.a(this.a, auyb.a(this.a), auyb.a(this.a).stAidInfo.androidAid, auyb.a(this.a).stAidInfo.payType, auyb.a(this.a).stAidInfo.errMsg, auyb.a(this.a).stAidInfo.month);
    return;
    auyb.a(this.a, false);
    bcql.a(auyb.a(this.a), ajya.a(2131715137), 0).a();
    auyb.a(this.a, null);
    auyb.a(this.a, -1);
    return;
    label195:
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyd
 * JD-Core Version:    0.7.0.1
 */