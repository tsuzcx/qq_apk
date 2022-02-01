import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp;

class auim
  implements bmsc<WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp>
{
  auim(auie paramauie, auir paramauir) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp paramCrossBidProxyCopyFileToOtherBidMsgRsp)
  {
    QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "sendWeiYun2Dataline onFailed: errcode[" + paramInt + "], errmsg[" + paramString + "]");
    if (this.jdField_a_of_type_Auir != null) {
      this.jdField_a_of_type_Auir.a(paramInt, paramString);
    }
  }
  
  public void a(WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp paramCrossBidProxyCopyFileToOtherBidMsgRsp)
  {
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = new String(paramCrossBidProxyCopyFileToOtherBidMsgRsp.dst_path.get().toByteArray());
    if (paramCrossBidProxyCopyFileToOtherBidMsgRsp.length() < 1)
    {
      QLog.e("WeiYunLogicCenter<FileAssistant>", 1, "=_= ^! [CS Replay]sendWeiYun2Dataline onSucceed,But uuid is null!!!");
      if (this.jdField_a_of_type_Auir != null) {
        this.jdField_a_of_type_Auir.a(-3, "copyFileToOtherBid_fail");
      }
    }
    do
    {
      return;
      QLog.i("WeiYunLogicCenter<FileAssistant>", 1, "=_= ^ [CS Replay] sendWeiYun2Dataline onSucceed, Uuid[" + paramCrossBidProxyCopyFileToOtherBidMsgRsp + "]");
    } while (this.jdField_a_of_type_Auir == null);
    this.jdField_a_of_type_Auir.a(paramCrossBidProxyCopyFileToOtherBidMsgRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auim
 * JD-Core Version:    0.7.0.1
 */