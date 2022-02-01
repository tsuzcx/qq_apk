import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.agent.SocialFriendChooser;

public class bjpg
  extends Handler
{
  public bjpg(SocialFriendChooser paramSocialFriendChooser) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 10001: 
      paramMessage = new Bundle(this.a.jdField_a_of_type_AndroidOsBundle);
      paramMessage.putString("agentversion", bjjo.a().e());
      paramMessage.putString("facetype", "mqqface");
      String str = bjzn.a().a("https://fusion.qq.com/cgi-bin/appstage/get_image_update");
      bjoi.a().a(str, paramMessage, new bjph(this));
      return;
    }
    if ((this.a.jdField_a_of_type_Bjus != null) && (!this.a.jdField_a_of_type_Bjus.isCancelled())) {
      this.a.jdField_a_of_type_Bjus.cancel(true);
    }
    this.a.l();
    paramMessage = new Intent();
    paramMessage.putExtra("key_error_code", -7);
    paramMessage.putExtra("key_error_msg", bjvb.e);
    this.a.setResult(-1, paramMessage);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjpg
 * JD-Core Version:    0.7.0.1
 */