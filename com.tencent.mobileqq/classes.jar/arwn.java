import android.os.Message;
import com.tencent.mobileqq.flashchat.FlashChatTextEffectView;
import mqq.os.MqqHandler;

class arwn
  implements afjs
{
  arwn(arwl paramarwl, arwo paramarwo, int paramInt) {}
  
  public void a()
  {
    FlashChatTextEffectView.a(this.jdField_a_of_type_Arwo);
    Message localMessage = Message.obtain();
    localMessage.obj = this.jdField_a_of_type_Arwo;
    localMessage.what = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Int < FlashChatTextEffectView.a().length)
    {
      arwl.a(this.jdField_a_of_type_Arwl).sendMessageDelayed(localMessage, FlashChatTextEffectView.a()[this.jdField_a_of_type_Int]);
      return;
    }
    arwl.a(this.jdField_a_of_type_Arwl).sendMessageDelayed(localMessage, 7000L);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwn
 * JD-Core Version:    0.7.0.1
 */