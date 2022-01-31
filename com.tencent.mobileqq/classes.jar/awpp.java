import QC.UniBusiCommItemAidInfo;
import QC.UniBusiGetOneItemWithCheckRsp;
import QC.UniBusiSimpleItemDetail;
import com.tencent.mobileqq.widget.QQToast;

class awpp
  implements awpu
{
  awpp(awpn paramawpn) {}
  
  public void a(boolean paramBoolean, UniBusiGetOneItemWithCheckRsp paramUniBusiGetOneItemWithCheckRsp)
  {
    if (awpn.a(this.a) == null) {}
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
      } while (paramUniBusiGetOneItemWithCheckRsp.stDetail.itemId != awpn.a(this.a).itemId);
      if (paramUniBusiGetOneItemWithCheckRsp.ret == 0)
      {
        awpn.a(this.a, false);
        this.a.b();
        return;
      }
    } while (!awpn.a(this.a));
    awpn.a(this.a, awpn.a(this.a), awpn.a(this.a).stAidInfo.androidAid, awpn.a(this.a).stAidInfo.payType, awpn.a(this.a).stAidInfo.errMsg, awpn.a(this.a).stAidInfo.month);
    return;
    awpn.a(this.a, false);
    QQToast.a(awpn.a(this.a), alpo.a(2131715509), 0).a();
    awpn.a(this.a, null);
    awpn.a(this.a, -1);
    return;
    label195:
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awpp
 * JD-Core Version:    0.7.0.1
 */