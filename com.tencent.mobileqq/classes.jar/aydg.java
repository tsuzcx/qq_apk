import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class aydg
  implements RichProtoProc.RichProtoCallback
{
  aydg(String paramString1, String paramString2, PhotoSendParams paramPhotoSendParams) {}
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    int j = 0;
    if (j < paramRichProtoResp.resps.size())
    {
      paramRichProtoReq = (RichProto.RichProtoResp.RespCommon)paramRichProtoResp.resps.get(j);
      int i = -1;
      if ((paramRichProtoReq instanceof RichProto.RichProtoResp.GroupPicUpResp)) {
        i = ((RichProto.RichProtoResp.GroupPicUpResp)paramRichProtoReq).result;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PicAioQzonePreSendMgr", 2, "picPreSendProcess request Result, resultCode:" + i + ", selfUin:" + this.jdField_a_of_type_JavaLangString + ", friendUin:" + this.b + ", md5:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5 + ", commonInfo:" + paramRichProtoReq.toString());
        }
        j += 1;
        break;
        if ((paramRichProtoReq instanceof RichProto.RichProtoResp.C2CPicUpResp)) {
          i = ((RichProto.RichProtoResp.C2CPicUpResp)paramRichProtoReq).result;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydg
 * JD-Core Version:    0.7.0.1
 */