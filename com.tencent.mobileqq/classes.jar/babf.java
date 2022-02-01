import QC.UniBusiCommItemAidInfo;
import QC.UniBusiGetOneItemWithCheckRsp;
import QC.UniBusiSimpleItemDetail;
import com.tencent.mobileqq.widget.QQToast;

class babf
  implements babk
{
  babf(babd parambabd) {}
  
  public void a(boolean paramBoolean, UniBusiGetOneItemWithCheckRsp paramUniBusiGetOneItemWithCheckRsp)
  {
    if (babd.a(this.a) == null) {}
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
      } while (paramUniBusiGetOneItemWithCheckRsp.stDetail.itemId != babd.a(this.a).itemId);
      if (paramUniBusiGetOneItemWithCheckRsp.ret == 0)
      {
        babd.a(this.a, false);
        this.a.b();
        return;
      }
    } while (!babd.a(this.a));
    babd.a(this.a, babd.a(this.a), babd.a(this.a).stAidInfo.androidAid, babd.a(this.a).stAidInfo.payType, babd.a(this.a).stAidInfo.errMsg, babd.a(this.a).stAidInfo.month);
    return;
    babd.a(this.a, false);
    QQToast.a(babd.a(this.a), anzj.a(2131713911), 0).a();
    babd.a(this.a, null);
    babd.a(this.a, -1);
    return;
    label195:
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babf
 * JD-Core Version:    0.7.0.1
 */