import com.tencent.mobileqq.transfile.ProtoReqManager.IProtoRespBack;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;

class aopa
  implements ProtoReqManager.IProtoRespBack
{
  aopa(aooy paramaooy) {}
  
  public void onProtoResp(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    if (paramProtoResp.resp.getResultCode() != 1000)
    {
      this.a.a(4006, false, null);
      return;
    }
    aooy.a(this.a, paramProtoResp, paramProtoReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aopa
 * JD-Core Version:    0.7.0.1
 */