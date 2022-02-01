import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;

public class arhy
  implements INetEngine.INetEngineListener
{
  public arhy(ExtendFriendResourceDownloader.4 param4) {}
  
  public void onResp(NetResp paramNetResp)
  {
    int i = 0;
    arhs localarhs = (arhs)paramNetResp.mReq.getUserData();
    if (localarhs != null)
    {
      if (paramNetResp.mResult == 0) {
        break label147;
      }
      QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed. errorCode: " + paramNetResp.mErrCode + ", errorMsg: " + paramNetResp.mErrDesc + ", file: " + localarhs.b);
    }
    for (;;)
    {
      if ((i != 0) && (arhu.a(this.a.this$0, localarhs)))
      {
        ((arhg)arhu.a(this.a.this$0).getBusinessHandler(127)).notifyUI(8, true, Boolean.valueOf(true));
        QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  needNotifyUi  .");
      }
      arhu.a(this.a.this$0, localarhs);
      return;
      label147:
      if (!localarhs.c.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
      {
        QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed: " + localarhs.b + "md5 is not match. ：" + SecUtil.getFileMd5(paramNetResp.mReq.mOutPath) + " infomd5:" + localarhs.c);
        FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener resFile success. file: " + localarhs.a + localarhs.b);
        }
        String str = arnf.c();
        boolean bool = arhu.b(this.a.this$0, paramNetResp.mReq.mOutPath, str);
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
 * Qualified Name:     arhy
 * JD-Core Version:    0.7.0.1
 */