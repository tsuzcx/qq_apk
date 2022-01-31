import cooperation.weiyun.channel.pb.WeiyunPB.MsgBody;
import cooperation.weiyun.channel.pb.WeiyunPB.RspMsgBody;

class bief<T>
  implements bied
{
  private static final String jdField_a_of_type_JavaLangString = ajya.a(2131700953);
  private final int jdField_a_of_type_Int;
  private final bieg<T> jdField_a_of_type_Bieg;
  
  bief(int paramInt, bieg<T> parambieg)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bieg = parambieg;
  }
  
  public void a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Bieg == null) {
      return;
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      this.jdField_a_of_type_Bieg.a(paramInt, paramString, null);
      return;
    }
    try
    {
      paramString = (WeiyunPB.MsgBody)new WeiyunPB.MsgBody().mergeFrom(paramArrayOfByte);
      paramString = (WeiyunPB.RspMsgBody)paramString.RspMsg_body.get();
      if (paramString == null)
      {
        bigg.a().w("BaseCallback", "rspMsgBody is null.");
        paramString = jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Bieg.a(1828003, paramString, null);
        return;
      }
    }
    catch (Throwable paramString)
    {
      bigg.a().w("BaseCallback", "decode Rsp Body failed.", paramString);
      paramString = jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bieg.a(1828003, paramString, null);
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      paramString = jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bieg.a(1828001, paramString, null);
      return;
    case 26113: 
      this.jdField_a_of_type_Bieg.a(paramString.LibInfoListGetMsgRsp_body);
      return;
    case 2402: 
      this.jdField_a_of_type_Bieg.a(paramString.DiskFileBatchDownloadMsgRsp_body);
      return;
    case 2414: 
      this.jdField_a_of_type_Bieg.a(paramString.DiskFileDocDownloadAbsMsgRsp_body);
      return;
    case 2509: 
      this.jdField_a_of_type_Bieg.a(paramString.DiskDirFileBatchDeleteExMsgRsp_body);
      return;
    case 2803: 
      this.jdField_a_of_type_Bieg.a(paramString.DiskPicBackupRsp_body);
      return;
    case 2804: 
      this.jdField_a_of_type_Bieg.a(paramString.DiskAlbumStatusReportRsp_body);
      return;
    case 11001: 
      this.jdField_a_of_type_Bieg.a(paramString.PwdQueryMsgRsp_body);
      return;
    case 11005: 
      this.jdField_a_of_type_Bieg.a(paramString.PwdVerifyMsgRsp_body);
      return;
    case 245700: 
      this.jdField_a_of_type_Bieg.a(paramString.CrossBidProxyCopyFileToOtherBidMsgRsp_body);
      return;
    case 245706: 
      this.jdField_a_of_type_Bieg.a(paramString.CrossBidProxyOfflineFileGetListMsgRsp_body);
      return;
    case 246000: 
      this.jdField_a_of_type_Bieg.a(paramString.QqSdkFileUploadMsgRsp_body);
      return;
    case 246001: 
      this.jdField_a_of_type_Bieg.a(paramString.AioPicAndVideoCopyToWeiyunMsgRsp_body);
      return;
    }
    this.jdField_a_of_type_Bieg.a(paramString.WeiyunShareAddFromMobileQQMsgRsp_body);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bief
 * JD-Core Version:    0.7.0.1
 */