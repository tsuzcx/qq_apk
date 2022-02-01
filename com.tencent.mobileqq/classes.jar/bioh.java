import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.agent.SocialFriendChooser;

public class bioh
  extends Handler
{
  public bioh(SocialFriendChooser paramSocialFriendChooser) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 10001: 
      paramMessage = new Bundle(this.a.jdField_a_of_type_AndroidOsBundle);
      paramMessage.putString("agentversion", biip.a().e());
      paramMessage.putString("facetype", "mqqface");
      String str = biyo.a().a("https://fusion.qq.com/cgi-bin/appstage/get_image_update");
      binj.a().a(str, paramMessage, new bioi(this));
      return;
    }
    if ((this.a.jdField_a_of_type_Bitt != null) && (!this.a.jdField_a_of_type_Bitt.isCancelled())) {
      this.a.jdField_a_of_type_Bitt.cancel(true);
    }
    this.a.l();
    paramMessage = new Intent();
    paramMessage.putExtra("key_error_code", -7);
    paramMessage.putExtra("key_error_msg", biuc.e);
    this.a.setResult(-1, paramMessage);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bioh
 * JD-Core Version:    0.7.0.1
 */