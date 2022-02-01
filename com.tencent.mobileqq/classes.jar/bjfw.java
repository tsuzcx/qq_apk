import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.agent.SocialFriendChooser;

public class bjfw
  extends Handler
{
  public bjfw(SocialFriendChooser paramSocialFriendChooser) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 10001: 
      paramMessage = new Bundle(this.a.jdField_a_of_type_AndroidOsBundle);
      paramMessage.putString("agentversion", bizw.a().e());
      paramMessage.putString("facetype", "mqqface");
      String str = bjpz.a().a("https://fusion.qq.com/cgi-bin/appstage/get_image_update");
      bjet.a().a(str, paramMessage, new bjfx(this));
      return;
    }
    if ((this.a.jdField_a_of_type_Bjlg != null) && (!this.a.jdField_a_of_type_Bjlg.isCancelled())) {
      this.a.jdField_a_of_type_Bjlg.cancel(true);
    }
    this.a.l();
    paramMessage = new Intent();
    paramMessage.putExtra("key_error_code", -7);
    paramMessage.putExtra("key_error_msg", bjlp.e);
    this.a.setResult(-1, paramMessage);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjfw
 * JD-Core Version:    0.7.0.1
 */