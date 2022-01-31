import QC.UniBusiCommItemAidInfo;
import QC.UniBusiGetOneItemWithCheckRsp;
import QC.UniBusiSimpleItemDetail;

class auyb
  implements auyg
{
  auyb(auxz paramauxz) {}
  
  public void a(boolean paramBoolean, UniBusiGetOneItemWithCheckRsp paramUniBusiGetOneItemWithCheckRsp)
  {
    if (auxz.a(this.a) == null) {}
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
      } while (paramUniBusiGetOneItemWithCheckRsp.stDetail.itemId != auxz.a(this.a).itemId);
      if (paramUniBusiGetOneItemWithCheckRsp.ret == 0)
      {
        auxz.a(this.a, false);
        this.a.b();
        return;
      }
    } while (!auxz.a(this.a));
    auxz.a(this.a, auxz.a(this.a), auxz.a(this.a).stAidInfo.androidAid, auxz.a(this.a).stAidInfo.payType, auxz.a(this.a).stAidInfo.errMsg, auxz.a(this.a).stAidInfo.month);
    return;
    auxz.a(this.a, false);
    bcpw.a(auxz.a(this.a), ajyc.a(2131715126), 0).a();
    auxz.a(this.a, null);
    auxz.a(this.a, -1);
    return;
    label195:
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyb
 * JD-Core Version:    0.7.0.1
 */