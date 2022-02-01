import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class avbc
  extends BroadcastReceiver
{
  avbc(avba paramavba, String paramString) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((avba.a(this.jdField_a_of_type_Avba) == null) || (avba.a(this.jdField_a_of_type_Avba).isFinishing()))
    {
      QLog.e("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive null == mActivity || mActivity.isFinishing()");
      return;
    }
    avba.a(this.jdField_a_of_type_Avba);
    avba.a(this.jdField_a_of_type_Avba).removeMessages(93);
    avba.a(this.jdField_a_of_type_Avba).removeMessages(94);
    paramContext = ((avcd)avba.a(this.jdField_a_of_type_Avba).a.getManager(350)).a(this.jdField_a_of_type_JavaLangString);
    if (paramContext == null)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive b77Result == null");
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive parseB77Result");
    avba.a(this.jdField_a_of_type_Avba, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbc
 * JD-Core Version:    0.7.0.1
 */