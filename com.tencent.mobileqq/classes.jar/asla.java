import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class asla
  extends Handler
{
  public static int a;
  public static int b = 2;
  public static int c = 3;
  public static int d = 5200;
  private WeakReference<ExtendFriendLimitChatMatchFragment> a;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public asla(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment)
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
          do
          {
            return;
            if (paramMessage.what != b) {
              break;
            }
            paramMessage = (ExtendFriendLimitChatMatchFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          } while (paramMessage == null);
          ExtendFriendLimitChatMatchFragment.b(paramMessage);
          paramMessage = paramMessage.getActivity();
        } while (paramMessage == null);
        paramMessage.finish();
        return;
      } while (paramMessage.what != c);
      paramMessage = (ExtendFriendLimitChatMatchFragment)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramMessage == null);
    ExtendFriendLimitChatMatchFragment.c(paramMessage);
    ExtendFriendLimitChatMatchFragment.d(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asla
 * JD-Core Version:    0.7.0.1
 */