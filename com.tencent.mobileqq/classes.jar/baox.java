import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class baox
  implements bdts
{
  baox(baow parambaow) {}
  
  public void onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    QLog.e("TintManager", 1, "tint config download onCompleted");
    this.a.loadConfig(BaseApplicationImpl.getApplication().getResources(), baow.a(this.a));
    paramQQAppInterface = new Intent("com.tencent.qplus.THEME_UPDATE");
    BaseApplicationImpl.getApplication().sendBroadcast(paramQQAppInterface, "com.tencent.msg.permission.pushnotify");
  }
  
  public void onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baox
 * JD-Core Version:    0.7.0.1
 */