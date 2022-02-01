import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class atog
  extends BroadcastReceiver
{
  atog(atoe paramatoe, String paramString) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((atoe.a(this.jdField_a_of_type_Atoe) == null) || (atoe.a(this.jdField_a_of_type_Atoe).isFinishing()))
    {
      QLog.e("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive null == mActivity || mActivity.isFinishing()");
      return;
    }
    atoe.a(this.jdField_a_of_type_Atoe);
    atoe.a(this.jdField_a_of_type_Atoe).removeMessages(93);
    atoe.a(this.jdField_a_of_type_Atoe).removeMessages(94);
    paramContext = ((atph)atoe.a(this.jdField_a_of_type_Atoe).app.getManager(350)).a(this.jdField_a_of_type_JavaLangString);
    if (paramContext == null)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive b77Result == null");
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive parseB77Result");
    atoe.a(this.jdField_a_of_type_Atoe, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atog
 * JD-Core Version:    0.7.0.1
 */