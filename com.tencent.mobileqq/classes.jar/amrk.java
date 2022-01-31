import cooperation.weiyun.channel.WySender.ICallback;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgBody;
import cooperation.weiyun.channel.pb.WeiyunPB.RspMsgBody;
import cooperation.weiyun.sdk.api.IWeiyunCallback;
import cooperation.weiyun.utils.WyLog;

public class amrk
  implements WySender.ICallback
{
  private final int jdField_a_of_type_Int;
  private final IWeiyunCallback jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback;
  
  public amrk(int paramInt, IWeiyunCallback paramIWeiyunCallback)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback = paramIWeiyunCallback;
  }
  
  public void a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback == null) {
      return;
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramInt, paramString, null);
      return;
    }
    try
    {
      paramString = (WeiyunPB.MsgBody)new WeiyunPB.MsgBody().mergeFrom(paramArrayOfByte);
      paramString = (WeiyunPB.RspMsgBody)paramString.RspMsg_body.get();
      if (paramString == null)
      {
        WyLog.a().w("BaseCallback", "rspMsgBody is null.");
        this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(1828003, "无效的协议!", null);
        return;
      }
    }
    catch (Throwable paramString)
    {
      WyLog.a().w("BaseCallback", "decode Rsp Body failed.", paramString);
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(1828003, "无效的协议!", null);
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(1828001, "无效的协议!", null);
      return;
    case 26113: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.LibInfoListGetMsgRsp_body);
      return;
    case 2402: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.DiskFileBatchDownloadMsgRsp_body);
      return;
    case 2414: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.DiskFileDocDownloadAbsMsgRsp_body);
      return;
    case 2509: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.DiskDirFileBatchDeleteExMsgRsp_body);
      return;
    case 2803: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.DiskPicBackupRsp_body);
      return;
    case 2804: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.DiskAlbumStatusReportRsp_body);
      return;
    case 11001: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.PwdQueryMsgRsp_body);
      return;
    case 11005: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.PwdVerifyMsgRsp_body);
      return;
    case 245700: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.CrossBidProxyCopyFileToOtherBidMsgRsp_body);
      return;
    case 245706: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.CrossBidProxyOfflineFileGetListMsgRsp_body);
      return;
    case 246000: 
      this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.QqSdkFileUploadMsgRsp_body);
      return;
    }
    this.jdField_a_of_type_CooperationWeiyunSdkApiIWeiyunCallback.a(paramString.AioPicAndVideoCopyToWeiyunMsgRsp_body);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrk
 * JD-Core Version:    0.7.0.1
 */