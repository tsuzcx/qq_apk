import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class blri
  implements azla
{
  blri(blrh paramblrh) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(azlb paramazlb)
  {
    if ((paramazlb == null) || (this.a.a == null)) {
      return;
    }
    if (paramazlb.jdField_a_of_type_Int == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicEmoticonUploader", 2, "Upload finish, id=" + paramazlb.c);
      }
      localBundle = new Bundle();
      localBundle.putInt("result", 0);
      localBundle.putString("id", paramazlb.c);
      this.a.a.onInvokeFinish(localBundle);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipComicEmoticonUploader", 2, "Upload error");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", 1);
    localBundle.putInt("errCode", paramazlb.b);
    localBundle.putString("errMsg", paramazlb.jdField_a_of_type_JavaLangString);
    this.a.a.onInvokeFinish(localBundle);
  }
  
  public void updateMsg(azlb paramazlb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blri
 * JD-Core Version:    0.7.0.1
 */