import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class bgic
  implements auoq
{
  bgic(bgib parambgib) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auor paramauor) {}
  
  public void b(auor paramauor)
  {
    if ((paramauor == null) || (this.a.a == null)) {
      return;
    }
    if (paramauor.jdField_a_of_type_Int == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicEmoticonUploader", 2, "Upload finish, id=" + paramauor.c);
      }
      localBundle = new Bundle();
      localBundle.putInt("result", 0);
      localBundle.putString("id", paramauor.c);
      this.a.a.onInvokeFinish(localBundle);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipComicEmoticonUploader", 2, "Upload error");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", 1);
    localBundle.putInt("errCode", paramauor.b);
    localBundle.putString("errMsg", paramauor.jdField_a_of_type_JavaLangString);
    this.a.a.onInvokeFinish(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgic
 * JD-Core Version:    0.7.0.1
 */