import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;

public class aqbq
  implements baug
{
  public aqbq(ExtendFriendResourceDownloader.4 param4) {}
  
  public void onResp(bavf parambavf)
  {
    int i = 0;
    aqbk localaqbk = (aqbk)parambavf.jdField_a_of_type_Bave.a();
    if (localaqbk != null)
    {
      if (parambavf.jdField_a_of_type_Int == 0) {
        break label147;
      }
      QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed. errorCode: " + parambavf.b + ", errorMsg: " + parambavf.jdField_a_of_type_JavaLangString + ", file: " + localaqbk.b);
    }
    for (;;)
    {
      if ((i != 0) && (aqbm.a(this.a.this$0, localaqbk)))
      {
        ((aqbe)aqbm.a(this.a.this$0).a(127)).notifyUI(8, true, Boolean.valueOf(true));
        QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  needNotifyUi  .");
      }
      aqbm.a(this.a.this$0, localaqbk);
      return;
      label147:
      if (!localaqbk.c.equalsIgnoreCase(SecUtil.getFileMd5(parambavf.jdField_a_of_type_Bave.c)))
      {
        QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed: " + localaqbk.b + "md5 is not match. ：" + SecUtil.getFileMd5(parambavf.jdField_a_of_type_Bave.c) + " infomd5:" + localaqbk.c);
        bdhb.d(parambavf.jdField_a_of_type_Bave.c);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener resFile success. file: " + localaqbk.jdField_a_of_type_JavaLangString + localaqbk.b);
        }
        String str = aqfx.c();
        boolean bool = aqbm.b(this.a.this$0, parambavf.jdField_a_of_type_Bave.c, str);
        i = bool;
        if (!bool)
        {
          QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  unzip file failed.");
          i = bool;
        }
      }
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbq
 * JD-Core Version:    0.7.0.1
 */