import android.app.Activity;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.qvip.view.ImgHeaderView;
import com.tencent.mobileqq.vas.qvip.view.MoreMsgHeaderView;
import com.tencent.mobileqq.vas.qvip.view.QQVipArkHeaderView;
import com.tencent.mobileqq.vas.qvip.view.TextHeaderView;
import com.tencent.qphone.base.util.QLog;

public class bhct
{
  public static bhcp a(QQVipMsgInfo paramQQVipMsgInfo, Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      if (paramQQVipMsgInfo == null) {
        return new MoreMsgHeaderView(paramActivity);
      }
      try
      {
        if (paramQQVipMsgInfo.msgType == 1)
        {
          paramQQVipMsgInfo = new QQVipArkHeaderView(paramActivity, null);
          return paramQQVipMsgInfo;
        }
      }
      catch (Throwable paramQQVipMsgInfo)
      {
        QLog.d("QQVipPubHeaderFactory", 4, "decode header(web) faile:" + paramQQVipMsgInfo.getMessage());
        return null;
      }
      if (paramQQVipMsgInfo.msgType == 2) {
        return new ImgHeaderView(paramActivity);
      }
      if (paramQQVipMsgInfo.msgType == 3) {
        return new TextHeaderView(paramActivity);
      }
      paramQQVipMsgInfo = new MoreMsgHeaderView(paramActivity);
      return paramQQVipMsgInfo;
    }
    QLog.d("QQVipPubHeaderFactory", 4, "createHeader fail activity is null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhct
 * JD-Core Version:    0.7.0.1
 */