import QC.UniBusiCommItemAidInfo;
import QC.UniBusiGetOneItemWithCheckRsp;
import QC.UniBusiSimpleItemDetail;
import com.tencent.mobileqq.widget.QQToast;

class azup
  implements azuu
{
  azup(azun paramazun) {}
  
  public void a(boolean paramBoolean, UniBusiGetOneItemWithCheckRsp paramUniBusiGetOneItemWithCheckRsp)
  {
    if (azun.a(this.a) == null) {}
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
      } while (paramUniBusiGetOneItemWithCheckRsp.stDetail.itemId != azun.a(this.a).itemId);
      if (paramUniBusiGetOneItemWithCheckRsp.ret == 0)
      {
        azun.a(this.a, false);
        this.a.b();
        return;
      }
    } while (!azun.a(this.a));
    azun.a(this.a, azun.a(this.a), azun.a(this.a).stAidInfo.androidAid, azun.a(this.a).stAidInfo.payType, azun.a(this.a).stAidInfo.errMsg, azun.a(this.a).stAidInfo.month);
    return;
    azun.a(this.a, false);
    QQToast.a(azun.a(this.a), anvx.a(2131714490), 0).a();
    azun.a(this.a, null);
    azun.a(this.a, -1);
    return;
    label195:
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azup
 * JD-Core Version:    0.7.0.1
 */