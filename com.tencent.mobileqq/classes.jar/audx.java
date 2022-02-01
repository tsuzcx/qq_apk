import android.os.Message;
import com.tencent.mobileqq.flashchat.FlashChatTextEffectView;
import mqq.os.MqqHandler;

class audx
  implements agra
{
  audx(audv paramaudv, audy paramaudy, int paramInt) {}
  
  public void a()
  {
    FlashChatTextEffectView.a(this.jdField_a_of_type_Audy);
    Message localMessage = Message.obtain();
    localMessage.obj = this.jdField_a_of_type_Audy;
    localMessage.what = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Int < FlashChatTextEffectView.a().length)
    {
      audv.a(this.jdField_a_of_type_Audv).sendMessageDelayed(localMessage, FlashChatTextEffectView.a()[this.jdField_a_of_type_Int]);
      return;
    }
    audv.a(this.jdField_a_of_type_Audv).sendMessageDelayed(localMessage, 7000L);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audx
 * JD-Core Version:    0.7.0.1
 */