import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;

public class anoo
  implements axrt
{
  public anoo(ExtendFriendResourceDownloader.4 param4) {}
  
  public void onResp(axsq paramaxsq)
  {
    int i = 0;
    anoi localanoi = (anoi)paramaxsq.jdField_a_of_type_Axsp.a();
    if (localanoi != null)
    {
      if (paramaxsq.jdField_a_of_type_Int == 0) {
        break label147;
      }
      QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed. errorCode: " + paramaxsq.b + ", errorMsg: " + paramaxsq.jdField_a_of_type_JavaLangString + ", file: " + localanoi.b);
    }
    for (;;)
    {
      if ((i != 0) && (anok.a(this.a.this$0, localanoi)))
      {
        ((anod)anok.a(this.a.this$0).a(127)).notifyUI(8, true, Boolean.valueOf(true));
        QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  needNotifyUi  .");
      }
      anok.a(this.a.this$0, localanoi);
      return;
      label147:
      if (!localanoi.c.equalsIgnoreCase(SecUtil.getFileMd5(paramaxsq.jdField_a_of_type_Axsp.c)))
      {
        QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed: " + localanoi.b + "md5 is not match. ：" + SecUtil.getFileMd5(paramaxsq.jdField_a_of_type_Axsp.c) + " infomd5:" + localanoi.c);
        bace.d(paramaxsq.jdField_a_of_type_Axsp.c);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener resFile success. file: " + localanoi.jdField_a_of_type_JavaLangString + localanoi.b);
        }
        String str = ansv.c();
        boolean bool = anok.b(this.a.this$0, paramaxsq.jdField_a_of_type_Axsp.c, str);
        i = bool;
        if (!bool)
        {
          QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  unzip file failed.");
          i = bool;
        }
      }
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anoo
 * JD-Core Version:    0.7.0.1
 */