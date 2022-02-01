import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class autb
  extends BroadcastReceiver
{
  autb(ausz paramausz, String paramString) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((ausz.a(this.jdField_a_of_type_Ausz) == null) || (ausz.a(this.jdField_a_of_type_Ausz).isFinishing()))
    {
      QLog.e("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive null == mActivity || mActivity.isFinishing()");
      return;
    }
    ausz.a(this.jdField_a_of_type_Ausz);
    ausz.a(this.jdField_a_of_type_Ausz).removeMessages(93);
    ausz.a(this.jdField_a_of_type_Ausz).removeMessages(94);
    paramContext = ((auuc)ausz.a(this.jdField_a_of_type_Ausz).app.getManager(QQManagerFactory.SDK_SHARE)).a(this.jdField_a_of_type_JavaLangString);
    if (paramContext == null)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive b77Result == null");
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive parseB77Result");
    ausz.a(this.jdField_a_of_type_Ausz, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autb
 * JD-Core Version:    0.7.0.1
 */