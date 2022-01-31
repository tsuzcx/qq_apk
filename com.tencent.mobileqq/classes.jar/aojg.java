import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aojg
  extends Handler
{
  public static int a;
  public static int b = 2;
  private WeakReference<ExtendFriendLimitChatMatchFragment> a;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public aojg(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramExtendFriendLimitChatMatchFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == jdField_a_of_type_Int)
    {
      paramMessage = (ExtendFriendLimitChatMatchFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramMessage != null)
      {
        QLog.e("ExtendFriendLimitChatMatchFragment", 1, "limitchat matching time out from ui");
        ExtendFriendLimitChatMatchFragment.a(paramMessage, true);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramMessage.what != b);
        paramMessage = (ExtendFriendLimitChatMatchFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (paramMessage == null);
      ExtendFriendLimitChatMatchFragment.b(paramMessage);
      paramMessage = paramMessage.getActivity();
    } while (paramMessage == null);
    paramMessage.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aojg
 * JD-Core Version:    0.7.0.1
 */