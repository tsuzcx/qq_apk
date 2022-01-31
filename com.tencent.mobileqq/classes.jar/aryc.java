import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class aryc
  extends BroadcastReceiver
{
  aryc(arya paramarya, String paramString) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((arya.a(this.jdField_a_of_type_Arya) == null) || (arya.a(this.jdField_a_of_type_Arya).isFinishing()))
    {
      QLog.e("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive null == mActivity || mActivity.isFinishing()");
      return;
    }
    arya.a(this.jdField_a_of_type_Arya);
    arya.a(this.jdField_a_of_type_Arya).removeMessages(93);
    arya.a(this.jdField_a_of_type_Arya).removeMessages(94);
    paramContext = ((arzd)arya.a(this.jdField_a_of_type_Arya).a.getManager(350)).a(this.jdField_a_of_type_JavaLangString);
    if (paramContext == null)
    {
      QLog.e("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive b77Result == null");
      return;
    }
    QLog.e("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive parseB77Result");
    arya.a(this.jdField_a_of_type_Arya, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryc
 * JD-Core Version:    0.7.0.1
 */