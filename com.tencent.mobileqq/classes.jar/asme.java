import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;

public class asme
  implements INetEngine.INetEngineListener
{
  public asme(ExtendFriendResourceDownloader.4 param4) {}
  
  public void onResp(NetResp paramNetResp)
  {
    int i = 0;
    asly localasly = (asly)paramNetResp.mReq.getUserData();
    if (localasly != null)
    {
      if (paramNetResp.mResult == 0) {
        break label148;
      }
      QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed. errorCode: " + paramNetResp.mErrCode + ", errorMsg: " + paramNetResp.mErrDesc + ", file: " + localasly.b);
    }
    for (;;)
    {
      if ((i != 0) && (asma.a(this.a.this$0, localasly)))
      {
        ((aslm)asma.a(this.a.this$0).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).notifyUI(8, true, Boolean.valueOf(true));
        QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  needNotifyUi  .");
      }
      asma.a(this.a.this$0, localasly);
      return;
      label148:
      if (!localasly.c.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
      {
        QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed: " + localasly.b + "md5 is not match. ：" + SecUtil.getFileMd5(paramNetResp.mReq.mOutPath) + " infomd5:" + localasly.c);
        FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener resFile success. file: " + localasly.a + localasly.b);
        }
        String str = asrl.c();
        boolean bool = asma.b(this.a.this$0, paramNetResp.mReq.mOutPath, str);
        i = bool;
        if (!bool)
        {
          QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  unzip file failed.");
          i = bool;
        }
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asme
 * JD-Core Version:    0.7.0.1
 */