import android.os.Message;
import com.tencent.mobileqq.flashchat.FlashChatTextEffectView;
import mqq.os.MqqHandler;

class apza
  implements admv
{
  apza(apyy paramapyy, apzb paramapzb, int paramInt) {}
  
  public void a()
  {
    FlashChatTextEffectView.a(this.jdField_a_of_type_Apzb);
    Message localMessage = Message.obtain();
    localMessage.obj = this.jdField_a_of_type_Apzb;
    localMessage.what = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Int < FlashChatTextEffectView.a().length)
    {
      apyy.a(this.jdField_a_of_type_Apyy).sendMessageDelayed(localMessage, FlashChatTextEffectView.a()[this.jdField_a_of_type_Int]);
      return;
    }
    apyy.a(this.jdField_a_of_type_Apyy).sendMessageDelayed(localMessage, 7000L);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apza
 * JD-Core Version:    0.7.0.1
 */