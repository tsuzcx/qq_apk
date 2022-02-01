import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;

public abstract class atqb
{
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  boolean c = true;
  
  public abstract Intent a();
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public ChatMessage a()
  {
    return null;
  }
  
  public void a(SessionInfo paramSessionInfo) {}
  
  public void a(ChatMessage paramChatMessage) {}
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(Bundle paramBundle) {}
  
  public void b(boolean paramBoolean) {}
  
  public boolean b()
  {
    return true;
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  boolean c()
  {
    return false;
  }
  
  boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    return this.b;
  }
  
  public boolean f()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqb
 * JD-Core Version:    0.7.0.1
 */