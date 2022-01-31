import QC.UniBusiCommItemAidInfo;
import QC.UniBusiGetOneItemWithCheckRsp;
import QC.UniBusiSimpleItemDetail;
import com.tencent.mobileqq.widget.QQToast;

class awty
  implements awud
{
  awty(awtw paramawtw) {}
  
  public void a(boolean paramBoolean, UniBusiGetOneItemWithCheckRsp paramUniBusiGetOneItemWithCheckRsp)
  {
    if (awtw.a(this.a) == null) {}
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
      } while (paramUniBusiGetOneItemWithCheckRsp.stDetail.itemId != awtw.a(this.a).itemId);
      if (paramUniBusiGetOneItemWithCheckRsp.ret == 0)
      {
        awtw.a(this.a, false);
        this.a.b();
        return;
      }
    } while (!awtw.a(this.a));
    awtw.a(this.a, awtw.a(this.a), awtw.a(this.a).stAidInfo.androidAid, awtw.a(this.a).stAidInfo.payType, awtw.a(this.a).stAidInfo.errMsg, awtw.a(this.a).stAidInfo.month);
    return;
    awtw.a(this.a, false);
    QQToast.a(awtw.a(this.a), alud.a(2131715521), 0).a();
    awtw.a(this.a, null);
    awtw.a(this.a, -1);
    return;
    label195:
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awty
 * JD-Core Version:    0.7.0.1
 */