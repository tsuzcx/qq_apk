import android.os.Message;
import com.tencent.mobileqq.flashchat.FlashChatTextEffectView;
import mqq.os.MqqHandler;

class aumh
  implements agph
{
  aumh(aumf paramaumf, aumi paramaumi, int paramInt) {}
  
  public void a()
  {
    FlashChatTextEffectView.a(this.jdField_a_of_type_Aumi);
    Message localMessage = Message.obtain();
    localMessage.obj = this.jdField_a_of_type_Aumi;
    localMessage.what = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Int < FlashChatTextEffectView.a().length)
    {
      aumf.a(this.jdField_a_of_type_Aumf).sendMessageDelayed(localMessage, FlashChatTextEffectView.a()[this.jdField_a_of_type_Int]);
      return;
    }
    aumf.a(this.jdField_a_of_type_Aumf).sendMessageDelayed(localMessage, 7000L);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumh
 * JD-Core Version:    0.7.0.1
 */