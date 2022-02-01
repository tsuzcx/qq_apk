import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class azjr
{
  public static void a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramQQAppInterface == null))
    {
      a("picPreSendProcess bundle=null!");
      return;
    }
    paramBundle.setClassLoader(PhotoSendParams.class.getClassLoader());
    PhotoSendParams localPhotoSendParams = (PhotoSendParams)paramBundle.getParcelable("PhotoConst.photo_send_qzone_pic_file_params");
    String str1 = paramBundle.getString("uin");
    String str2 = paramQQAppInterface.getCurrentUin();
    paramBundle.getString("troop_uin");
    int i = paramBundle.getInt("uintype", 1003);
    if ((localPhotoSendParams == null) || (TextUtils.isEmpty(localPhotoSendParams.rawMd5)) || (TextUtils.isEmpty(localPhotoSendParams.thumbPath)) || (!FileUtils.fileExistsAndNotEmpty(localPhotoSendParams.thumbPath)) || (TextUtils.isEmpty(localPhotoSendParams.rawDownloadUrl)) || (TextUtils.isEmpty(str1)))
    {
      a("picPreSendProcess sendParams error, friendUin:" + str1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PicAioQzonePreSendMgr", 2, "picPreSendProcess params friendUin:" + str1 + ", uinType:" + i + ", sendParams:" + localPhotoSendParams.toString());
    }
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PicUpReq localPicUpReq;
    switch (i)
    {
    default: 
      localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
      localPicUpReq.selfUin = str2;
      localPicUpReq.peerUin = str1;
      localPicUpReq.secondUin = str2;
      localPicUpReq.fileSize = localPhotoSendParams.fileSize;
      localPicUpReq.md5 = HexUtil.hexStr2Bytes(localPhotoSendParams.rawMd5);
      localPicUpReq.fileName = (localPhotoSendParams.rawMd5 + ".jpg");
      localPicUpReq.width = localPhotoSendParams.rawWidth;
      localPicUpReq.height = localPhotoSendParams.rawHeight;
      localPicUpReq.picType = 1000;
      localPicUpReq.typeHotPic = 3;
      localPicUpReq.transferUrl = localPhotoSendParams.rawDownloadUrl;
    }
    for (paramBundle = "c2c_pic_up"; TextUtils.isEmpty(paramBundle); paramBundle = "grp_pic_up")
    {
      a("picPreSendProcess protoKey=null!");
      return;
      localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
      localPicUpReq.selfUin = str2;
      localPicUpReq.peerUin = str1;
      localPicUpReq.secondUin = str2;
      localPicUpReq.fileSize = localPhotoSendParams.fileSize;
      localPicUpReq.md5 = HexUtil.hexStr2Bytes(localPhotoSendParams.rawMd5);
      localPicUpReq.fileName = (localPhotoSendParams.rawMd5 + ".jpg");
      localPicUpReq.width = localPhotoSendParams.rawWidth;
      localPicUpReq.height = localPhotoSendParams.rawHeight;
      localPicUpReq.picType = 1000;
      localPicUpReq.busiType = 1045;
      localPicUpReq.uinType = 1;
      localPicUpReq.typeHotPic = 3;
      localPicUpReq.transferUrl = localPhotoSendParams.rawDownloadUrl;
    }
    localRichProtoReq.reqs.add(localPicUpReq);
    localRichProtoReq.protoKey = paramBundle;
    localRichProtoReq.protoReqMgr = paramQQAppInterface.getProtoReqManager();
    localRichProtoReq.callback = new azjs(str2, str1, localPhotoSendParams);
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PicAioQzonePreSendMgr", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjr
 * JD-Core Version:    0.7.0.1
 */