import android.os.Message;
import com.tencent.mobileqq.flashchat.FlashChatTextEffectView;
import mqq.os.MqqHandler;

class auvs
  implements ahag
{
  auvs(auvq paramauvq, auvt paramauvt, int paramInt) {}
  
  public void a()
  {
    FlashChatTextEffectView.a(this.jdField_a_of_type_Auvt);
    Message localMessage = Message.obtain();
    localMessage.obj = this.jdField_a_of_type_Auvt;
    localMessage.what = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Int < FlashChatTextEffectView.a().length)
    {
      auvq.a(this.jdField_a_of_type_Auvq).sendMessageDelayed(localMessage, FlashChatTextEffectView.a()[this.jdField_a_of_type_Int]);
      return;
    }
    auvq.a(this.jdField_a_of_type_Auvq).sendMessageDelayed(localMessage, 7000L);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auvs
 * JD-Core Version:    0.7.0.1
 */