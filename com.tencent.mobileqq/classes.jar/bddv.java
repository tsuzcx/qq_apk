import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.agent.SocialFriendChooser;

public class bddv
  extends Handler
{
  public bddv(SocialFriendChooser paramSocialFriendChooser) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 10001: 
      paramMessage = new Bundle(this.a.jdField_a_of_type_AndroidOsBundle);
      paramMessage.putString("agentversion", bcyb.a().e());
      paramMessage.putString("facetype", "mqqface");
      String str = bdoc.a().a("http://fusion.qq.com/cgi-bin/appstage/get_image_update");
      bdcy.a().a(str, paramMessage, new bddw(this));
      return;
    }
    if ((this.a.jdField_a_of_type_Bdjd != null) && (!this.a.jdField_a_of_type_Bdjd.isCancelled())) {
      this.a.jdField_a_of_type_Bdjd.cancel(true);
    }
    this.a.l();
    paramMessage = new Intent();
    paramMessage.putExtra("key_error_code", -7);
    paramMessage.putExtra("key_error_msg", bdjm.e);
    this.a.setResult(-1, paramMessage);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bddv
 * JD-Core Version:    0.7.0.1
 */