import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ascl
  extends BroadcastReceiver
{
  ascl(ascj paramascj, String paramString) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((ascj.a(this.jdField_a_of_type_Ascj) == null) || (ascj.a(this.jdField_a_of_type_Ascj).isFinishing()))
    {
      QLog.e("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive null == mActivity || mActivity.isFinishing()");
      return;
    }
    ascj.a(this.jdField_a_of_type_Ascj);
    ascj.a(this.jdField_a_of_type_Ascj).removeMessages(93);
    ascj.a(this.jdField_a_of_type_Ascj).removeMessages(94);
    paramContext = ((asdm)ascj.a(this.jdField_a_of_type_Ascj).a.getManager(350)).a(this.jdField_a_of_type_JavaLangString);
    if (paramContext == null)
    {
      QLog.e("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive b77Result == null");
      return;
    }
    QLog.e("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive parseB77Result");
    ascj.a(this.jdField_a_of_type_Ascj, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascl
 * JD-Core Version:    0.7.0.1
 */