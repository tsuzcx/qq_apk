import cooperation.weiyun.channel.pb.WeiyunPB.MsgBody;
import cooperation.weiyun.channel.pb.WeiyunPB.RspMsgBody;

class bkki<T>
  implements bkkg
{
  private static final String jdField_a_of_type_JavaLangString = alud.a(2131701334);
  private final int jdField_a_of_type_Int;
  private final bkkj<T> jdField_a_of_type_Bkkj;
  
  bkki(int paramInt, bkkj<T> parambkkj)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bkkj = parambkkj;
  }
  
  public void a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Bkkj == null) {
      return;
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      this.jdField_a_of_type_Bkkj.a(paramInt, paramString, null);
      return;
    }
    try
    {
      paramString = (WeiyunPB.MsgBody)new WeiyunPB.MsgBody().mergeFrom(paramArrayOfByte);
      paramString = (WeiyunPB.RspMsgBody)paramString.RspMsg_body.get();
      if (paramString == null)
      {
        bkmj.a().w("BaseCallback", "rspMsgBody is null.");
        paramString = jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Bkkj.a(1828003, paramString, null);
        return;
      }
    }
    catch (Throwable paramString)
    {
      bkmj.a().w("BaseCallback", "decode Rsp Body failed.", paramString);
      paramString = jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bkkj.a(1828003, paramString, null);
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      paramString = jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bkkj.a(1828001, paramString, null);
      return;
    case 26113: 
      this.jdField_a_of_type_Bkkj.a(paramString.LibInfoListGetMsgRsp_body);
      return;
    case 2402: 
      this.jdField_a_of_type_Bkkj.a(paramString.DiskFileBatchDownloadMsgRsp_body);
      return;
    case 2414: 
      this.jdField_a_of_type_Bkkj.a(paramString.DiskFileDocDownloadAbsMsgRsp_body);
      return;
    case 2509: 
      this.jdField_a_of_type_Bkkj.a(paramString.DiskDirFileBatchDeleteExMsgRsp_body);
      return;
    case 2803: 
      this.jdField_a_of_type_Bkkj.a(paramString.DiskPicBackupRsp_body);
      return;
    case 2804: 
      this.jdField_a_of_type_Bkkj.a(paramString.DiskAlbumStatusReportRsp_body);
      return;
    case 11001: 
      this.jdField_a_of_type_Bkkj.a(paramString.PwdQueryMsgRsp_body);
      return;
    case 11005: 
      this.jdField_a_of_type_Bkkj.a(paramString.PwdVerifyMsgRsp_body);
      return;
    case 245700: 
      this.jdField_a_of_type_Bkkj.a(paramString.CrossBidProxyCopyFileToOtherBidMsgRsp_body);
      return;
    case 245706: 
      this.jdField_a_of_type_Bkkj.a(paramString.CrossBidProxyOfflineFileGetListMsgRsp_body);
      return;
    case 246000: 
      this.jdField_a_of_type_Bkkj.a(paramString.QqSdkFileUploadMsgRsp_body);
      return;
    case 246001: 
      this.jdField_a_of_type_Bkkj.a(paramString.AioPicAndVideoCopyToWeiyunMsgRsp_body);
      return;
    }
    this.jdField_a_of_type_Bkkj.a(paramString.WeiyunShareAddFromMobileQQMsgRsp_body);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkki
 * JD-Core Version:    0.7.0.1
 */