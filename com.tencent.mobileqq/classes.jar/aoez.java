import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;

public class aoez
  implements aysa
{
  public aoez(ExtendFriendResourceDownloader.4 param4) {}
  
  public void onResp(aysx paramaysx)
  {
    int i = 0;
    aoet localaoet = (aoet)paramaysx.jdField_a_of_type_Aysw.a();
    if (localaoet != null)
    {
      if (paramaysx.jdField_a_of_type_Int == 0) {
        break label147;
      }
      QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed. errorCode: " + paramaysx.b + ", errorMsg: " + paramaysx.jdField_a_of_type_JavaLangString + ", file: " + localaoet.b);
    }
    for (;;)
    {
      if ((i != 0) && (aoev.a(this.a.this$0, localaoet)))
      {
        ((aoeo)aoev.a(this.a.this$0).a(127)).notifyUI(8, true, Boolean.valueOf(true));
        QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  needNotifyUi  .");
      }
      aoev.a(this.a.this$0, localaoet);
      return;
      label147:
      if (!localaoet.c.equalsIgnoreCase(SecUtil.getFileMd5(paramaysx.jdField_a_of_type_Aysw.c)))
      {
        QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed: " + localaoet.b + "md5 is not match. ：" + SecUtil.getFileMd5(paramaysx.jdField_a_of_type_Aysw.c) + " infomd5:" + localaoet.c);
        bbdj.d(paramaysx.jdField_a_of_type_Aysw.c);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener resFile success. file: " + localaoet.jdField_a_of_type_JavaLangString + localaoet.b);
        }
        String str = aojh.c();
        boolean bool = aoev.b(this.a.this$0, paramaysx.jdField_a_of_type_Aysw.c, str);
        i = bool;
        if (!bool)
        {
          QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  unzip file failed.");
          i = bool;
        }
      }
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoez
 * JD-Core Version:    0.7.0.1
 */