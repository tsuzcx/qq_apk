import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;

public class asvy
  implements beuq
{
  public asvy(ExtendFriendResourceDownloader.4 param4) {}
  
  public void onResp(bevm parambevm)
  {
    int i = 0;
    asvs localasvs = (asvs)parambevm.jdField_a_of_type_Bevl.a();
    if (localasvs != null)
    {
      if (parambevm.jdField_a_of_type_Int == 0) {
        break label147;
      }
      QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed. errorCode: " + parambevm.b + ", errorMsg: " + parambevm.jdField_a_of_type_JavaLangString + ", file: " + localasvs.b);
    }
    for (;;)
    {
      if ((i != 0) && (asvu.a(this.a.this$0, localasvs)))
      {
        ((asvg)asvu.a(this.a.this$0).a(127)).notifyUI(8, true, Boolean.valueOf(true));
        QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  needNotifyUi  .");
      }
      asvu.a(this.a.this$0, localasvs);
      return;
      label147:
      if (!localasvs.c.equalsIgnoreCase(SecUtil.getFileMd5(parambevm.jdField_a_of_type_Bevl.c)))
      {
        QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener file failed: " + localasvs.b + "md5 is not match. ：" + SecUtil.getFileMd5(parambevm.jdField_a_of_type_Bevl.c) + " infomd5:" + localasvs.c);
        bhmi.d(parambevm.jdField_a_of_type_Bevl.c);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener resFile success. file: " + localasvs.jdField_a_of_type_JavaLangString + localasvs.b);
        }
        String str = atax.c();
        boolean bool = asvu.b(this.a.this$0, parambevm.jdField_a_of_type_Bevl.c, str);
        i = bool;
        if (!bool)
        {
          QLog.e("ExtendFriendResourceDownloader", 2, "LimitChatDownloaderListener  unzip file failed.");
          i = bool;
        }
      }
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvy
 * JD-Core Version:    0.7.0.1
 */