import QC.UniBusiCommItemAidInfo;
import QC.UniBusiGetOneItemWithCheckRsp;
import QC.UniBusiSimpleItemDetail;
import com.tencent.mobileqq.widget.QQToast;

class aypu
  implements aypz
{
  aypu(ayps paramayps) {}
  
  public void a(boolean paramBoolean, UniBusiGetOneItemWithCheckRsp paramUniBusiGetOneItemWithCheckRsp)
  {
    if (ayps.a(this.a) == null) {}
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
      } while (paramUniBusiGetOneItemWithCheckRsp.stDetail.itemId != ayps.a(this.a).itemId);
      if (paramUniBusiGetOneItemWithCheckRsp.ret == 0)
      {
        ayps.a(this.a, false);
        this.a.b();
        return;
      }
    } while (!ayps.a(this.a));
    ayps.a(this.a, ayps.a(this.a), ayps.a(this.a).stAidInfo.androidAid, ayps.a(this.a).stAidInfo.payType, ayps.a(this.a).stAidInfo.errMsg, ayps.a(this.a).stAidInfo.month);
    return;
    ayps.a(this.a, false);
    QQToast.a(ayps.a(this.a), amtj.a(2131714143), 0).a();
    ayps.a(this.a, null);
    ayps.a(this.a, -1);
    return;
    label195:
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypu
 * JD-Core Version:    0.7.0.1
 */