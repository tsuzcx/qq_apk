import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;

public class apxh
  implements bapx
{
  public apxh(ExtendFriendResourceDownloader.4 param4) {}
  
  public void onResp(baqw parambaqw)
  {
    int i = 0;
    apxb localapxb = (apxb)parambaqw.jdField_a_of_type_Baqv.a();
    if (localapxb != null)
    {
      if (parambaqw.jdField_a_of_type_Int == 0) {
        break label147;
      }
      QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed. errorCode: " + parambaqw.b + ", errorMsg: " + parambaqw.jdField_a_of_type_JavaLangString + ", file: " + localapxb.b);
    }
    for (;;)
    {
      if ((i != 0) && (apxd.a(this.a.this$0, localapxb)))
      {
        ((apwv)apxd.a(this.a.this$0).a(127)).notifyUI(8, true, Boolean.valueOf(true));
        QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  needNotifyUi  .");
      }
      apxd.a(this.a.this$0, localapxb);
      return;
      label147:
      if (!localapxb.c.equalsIgnoreCase(SecUtil.getFileMd5(parambaqw.jdField_a_of_type_Baqv.c)))
      {
        QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed: " + localapxb.b + "md5 is not match. ：" + SecUtil.getFileMd5(parambaqw.jdField_a_of_type_Baqv.c) + " infomd5:" + localapxb.c);
        bdcs.d(parambaqw.jdField_a_of_type_Baqv.c);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener resFile success. file: " + localapxb.jdField_a_of_type_JavaLangString + localapxb.b);
        }
        String str = aqbo.c();
        boolean bool = apxd.b(this.a.this$0, parambaqw.jdField_a_of_type_Baqv.c, str);
        i = bool;
        if (!bool)
        {
          QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  unzip file failed.");
          i = bool;
        }
      }
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxh
 * JD-Core Version:    0.7.0.1
 */