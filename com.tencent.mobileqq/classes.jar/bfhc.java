import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.agent.SocialFriendChooser;

public class bfhc
  extends Handler
{
  public bfhc(SocialFriendChooser paramSocialFriendChooser) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 10001: 
      paramMessage = new Bundle(this.a.jdField_a_of_type_AndroidOsBundle);
      paramMessage.putString("agentversion", bfbm.a().e());
      paramMessage.putString("facetype", "mqqface");
      String str = bfri.a().a("http://fusion.qq.com/cgi-bin/appstage/get_image_update");
      bfgf.a().a(str, paramMessage, new bfhd(this));
      return;
    }
    if ((this.a.jdField_a_of_type_Bfmk != null) && (!this.a.jdField_a_of_type_Bfmk.isCancelled())) {
      this.a.jdField_a_of_type_Bfmk.cancel(true);
    }
    this.a.l();
    paramMessage = new Intent();
    paramMessage.putExtra("key_error_code", -7);
    paramMessage.putExtra("key_error_msg", bfmt.e);
    this.a.setResult(-1, paramMessage);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfhc
 * JD-Core Version:    0.7.0.1
 */