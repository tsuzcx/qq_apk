import android.os.Message;
import com.tencent.mobileqq.flashchat.FlashChatTextEffectView;
import mqq.os.MqqHandler;

class apgx
  implements adbt
{
  apgx(apgv paramapgv, apgy paramapgy, int paramInt) {}
  
  public void a()
  {
    FlashChatTextEffectView.a(this.jdField_a_of_type_Apgy);
    Message localMessage = Message.obtain();
    localMessage.obj = this.jdField_a_of_type_Apgy;
    localMessage.what = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Int < FlashChatTextEffectView.a().length)
    {
      apgv.a(this.jdField_a_of_type_Apgv).sendMessageDelayed(localMessage, FlashChatTextEffectView.a()[this.jdField_a_of_type_Int]);
      return;
    }
    apgv.a(this.jdField_a_of_type_Apgv).sendMessageDelayed(localMessage, 7000L);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apgx
 * JD-Core Version:    0.7.0.1
 */