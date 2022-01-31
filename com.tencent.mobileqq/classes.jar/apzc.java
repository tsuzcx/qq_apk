import android.os.Message;
import com.tencent.mobileqq.flashchat.FlashChatTextEffectView;
import mqq.os.MqqHandler;

class apzc
  implements admt
{
  apzc(apza paramapza, apzd paramapzd, int paramInt) {}
  
  public void a()
  {
    FlashChatTextEffectView.a(this.jdField_a_of_type_Apzd);
    Message localMessage = Message.obtain();
    localMessage.obj = this.jdField_a_of_type_Apzd;
    localMessage.what = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Int < FlashChatTextEffectView.a().length)
    {
      apza.a(this.jdField_a_of_type_Apza).sendMessageDelayed(localMessage, FlashChatTextEffectView.a()[this.jdField_a_of_type_Int]);
      return;
    }
    apza.a(this.jdField_a_of_type_Apza).sendMessageDelayed(localMessage, 7000L);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apzc
 * JD-Core Version:    0.7.0.1
 */