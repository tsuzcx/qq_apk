import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.agent.SocialFriendChooser;

public class bhuv
  extends Handler
{
  public bhuv(SocialFriendChooser paramSocialFriendChooser) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 10001: 
      paramMessage = new Bundle(this.a.jdField_a_of_type_AndroidOsBundle);
      paramMessage.putString("agentversion", bhpc.a().e());
      paramMessage.putString("facetype", "mqqface");
      String str = biex.a().a("https://fusion.qq.com/cgi-bin/appstage/get_image_update");
      bhtw.a().a(str, paramMessage, new bhuw(this));
      return;
    }
    if ((this.a.jdField_a_of_type_Biae != null) && (!this.a.jdField_a_of_type_Biae.isCancelled())) {
      this.a.jdField_a_of_type_Biae.cancel(true);
    }
    this.a.l();
    paramMessage = new Intent();
    paramMessage.putExtra("key_error_code", -7);
    paramMessage.putExtra("key_error_msg", bian.e);
    this.a.setResult(-1, paramMessage);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhuv
 * JD-Core Version:    0.7.0.1
 */