import QC.UniBusiCommItemAidInfo;
import QC.UniBusiGetOneItemWithCheckRsp;
import QC.UniBusiSimpleItemDetail;
import com.tencent.mobileqq.widget.QQToast;

class azit
  implements aziy
{
  azit(azir paramazir) {}
  
  public void a(boolean paramBoolean, UniBusiGetOneItemWithCheckRsp paramUniBusiGetOneItemWithCheckRsp)
  {
    if (azir.a(this.a) == null) {}
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
      } while (paramUniBusiGetOneItemWithCheckRsp.stDetail.itemId != azir.a(this.a).itemId);
      if (paramUniBusiGetOneItemWithCheckRsp.ret == 0)
      {
        azir.a(this.a, false);
        this.a.b();
        return;
      }
    } while (!azir.a(this.a));
    azir.a(this.a, azir.a(this.a), azir.a(this.a).stAidInfo.androidAid, azir.a(this.a).stAidInfo.payType, azir.a(this.a).stAidInfo.errMsg, azir.a(this.a).stAidInfo.month);
    return;
    azir.a(this.a, false);
    QQToast.a(azir.a(this.a), anni.a(2131713802), 0).a();
    azir.a(this.a, null);
    azir.a(this.a, -1);
    return;
    label195:
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azit
 * JD-Core Version:    0.7.0.1
 */