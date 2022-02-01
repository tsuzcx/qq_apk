import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;

public class asgk
  implements bdvw
{
  public asgk(ExtendFriendResourceDownloader.4 param4) {}
  
  public void onResp(bdwt parambdwt)
  {
    int i = 0;
    asge localasge = (asge)parambdwt.jdField_a_of_type_Bdws.a();
    if (localasge != null)
    {
      if (parambdwt.jdField_a_of_type_Int == 0) {
        break label147;
      }
      QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed. errorCode: " + parambdwt.b + ", errorMsg: " + parambdwt.jdField_a_of_type_JavaLangString + ", file: " + localasge.b);
    }
    for (;;)
    {
      if ((i != 0) && (asgg.a(this.a.this$0, localasge)))
      {
        ((asfs)asgg.a(this.a.this$0).a(127)).notifyUI(8, true, Boolean.valueOf(true));
        QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  needNotifyUi  .");
      }
      asgg.a(this.a.this$0, localasge);
      return;
      label147:
      if (!localasge.c.equalsIgnoreCase(SecUtil.getFileMd5(parambdwt.jdField_a_of_type_Bdws.c)))
      {
        QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed: " + localasge.b + "md5 is not match. ：" + SecUtil.getFileMd5(parambdwt.jdField_a_of_type_Bdws.c) + " infomd5:" + localasge.c);
        bgmg.d(parambdwt.jdField_a_of_type_Bdws.c);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener resFile success. file: " + localasge.jdField_a_of_type_JavaLangString + localasge.b);
        }
        String str = aslb.c();
        boolean bool = asgg.b(this.a.this$0, parambdwt.jdField_a_of_type_Bdws.c, str);
        i = bool;
        if (!bool)
        {
          QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  unzip file failed.");
          i = bool;
        }
      }
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgk
 * JD-Core Version:    0.7.0.1
 */