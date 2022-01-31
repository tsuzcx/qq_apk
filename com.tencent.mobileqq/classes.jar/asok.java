import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

class asok
  implements bcww
{
  asok(asoj paramasoj) {}
  
  public void a(BaseResp paramBaseResp)
  {
    QLog.d("AIOShareActionSheet", 1, "WXShareResult trans:" + paramBaseResp.transaction + " ,errCode:" + paramBaseResp.errCode + " ,errStr:" + paramBaseResp.errStr);
    WXShareHelper.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asok
 * JD-Core Version:    0.7.0.1
 */