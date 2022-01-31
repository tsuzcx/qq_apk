import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;

public class aofe
  implements aysc
{
  public aofe(ExtendFriendResourceDownloader.4 param4) {}
  
  public void onResp(aysz paramaysz)
  {
    int i = 0;
    aoey localaoey = (aoey)paramaysz.jdField_a_of_type_Aysy.a();
    if (localaoey != null)
    {
      if (paramaysz.jdField_a_of_type_Int == 0) {
        break label147;
      }
      QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed. errorCode: " + paramaysz.b + ", errorMsg: " + paramaysz.jdField_a_of_type_JavaLangString + ", file: " + localaoey.b);
    }
    for (;;)
    {
      if ((i != 0) && (aofa.a(this.a.this$0, localaoey)))
      {
        ((aoet)aofa.a(this.a.this$0).a(127)).notifyUI(8, true, Boolean.valueOf(true));
        QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  needNotifyUi  .");
      }
      aofa.a(this.a.this$0, localaoey);
      return;
      label147:
      if (!localaoey.c.equalsIgnoreCase(SecUtil.getFileMd5(paramaysz.jdField_a_of_type_Aysy.c)))
      {
        QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed: " + localaoey.b + "md5 is not match. ：" + SecUtil.getFileMd5(paramaysz.jdField_a_of_type_Aysy.c) + " infomd5:" + localaoey.c);
        bbdx.d(paramaysz.jdField_a_of_type_Aysy.c);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener resFile success. file: " + localaoey.jdField_a_of_type_JavaLangString + localaoey.b);
        }
        String str = aojm.c();
        boolean bool = aofa.b(this.a.this$0, paramaysz.jdField_a_of_type_Aysy.c, str);
        i = bool;
        if (!bool)
        {
          QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  unzip file failed.");
          i = bool;
        }
      }
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aofe
 * JD-Core Version:    0.7.0.1
 */