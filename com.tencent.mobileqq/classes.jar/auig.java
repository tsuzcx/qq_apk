import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.DiskFileDocDownloadAbsMsgRsp;

class auig
  implements bmsc<WeiyunPB.DiskFileDocDownloadAbsMsgRsp>
{
  auig(auie paramauie) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.DiskFileDocDownloadAbsMsgRsp paramDiskFileDocDownloadAbsMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "get weiyun file PreviewAddress onFailed,errCode[" + paramInt + "],errMsg[" + paramString + "]");
    }
    auie.a(this.a).getFileManagerNotifyCenter().a(false, 278, new Object[] { Integer.valueOf(paramInt), paramString, "", "", "", "", Integer.valueOf(0) });
  }
  
  public void a(WeiyunPB.DiskFileDocDownloadAbsMsgRsp paramDiskFileDocDownloadAbsMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "get weiyun file PreviewAddress onSucceed");
    }
    String str = bmua.a(paramDiskFileDocDownloadAbsMsgRsp.downloadkey.get());
    auie.a(this.a).getFileManagerNotifyCenter().a(true, 278, new Object[] { Integer.valueOf(0), "", str, paramDiskFileDocDownloadAbsMsgRsp.cookie.get(), paramDiskFileDocDownloadAbsMsgRsp.downloadip.get(), paramDiskFileDocDownloadAbsMsgRsp.downloaddns.get(), Integer.valueOf(paramDiskFileDocDownloadAbsMsgRsp.downloadport.get()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auig
 * JD-Core Version:    0.7.0.1
 */