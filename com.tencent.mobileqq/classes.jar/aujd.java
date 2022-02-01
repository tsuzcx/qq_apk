import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class aujd
  extends BroadcastReceiver
{
  aujd(aujb paramaujb, String paramString) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((aujb.a(this.jdField_a_of_type_Aujb) == null) || (aujb.a(this.jdField_a_of_type_Aujb).isFinishing()))
    {
      QLog.e("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive null == mActivity || mActivity.isFinishing()");
      return;
    }
    aujb.a(this.jdField_a_of_type_Aujb);
    aujb.a(this.jdField_a_of_type_Aujb).removeMessages(93);
    aujb.a(this.jdField_a_of_type_Aujb).removeMessages(94);
    paramContext = ((auke)aujb.a(this.jdField_a_of_type_Aujb).a.getManager(350)).a(this.jdField_a_of_type_JavaLangString);
    if (paramContext == null)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive b77Result == null");
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive parseB77Result");
    aujb.a(this.jdField_a_of_type_Aujb, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujd
 * JD-Core Version:    0.7.0.1
 */