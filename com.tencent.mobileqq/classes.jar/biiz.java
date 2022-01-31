import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import mqq.manager.Manager;
import org.json.JSONObject;
import tencent.im.cs.cmd0x388.cmd0x388.ExtensionCommPicTryUp;

public class biiz
  implements Manager
{
  private awfy jdField_a_of_type_Awfy = new bija(this);
  private batw jdField_a_of_type_Batw;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public RemoteCommand.OnInvokeFinishLinstener a;
  private String jdField_a_of_type_JavaLangString;
  
  public biiz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Batw = paramQQAppInterface.a();
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.c();
  }
  
  public void a(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener = paramOnInvokeFinishLinstener;
      paramOnInvokeFinishLinstener = new baub();
      paramOnInvokeFinishLinstener.jdField_b_of_type_Int = 24;
      paramOnInvokeFinishLinstener.jdField_c_of_type_Int = 20;
      paramOnInvokeFinishLinstener.jdField_a_of_type_JavaLangString = "actQqComicPicUpload";
      paramOnInvokeFinishLinstener.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramOnInvokeFinishLinstener.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramOnInvokeFinishLinstener.jdField_a_of_type_Boolean = true;
      paramOnInvokeFinishLinstener.i = paramBundle.getString("localPath");
      paramOnInvokeFinishLinstener.jdField_a_of_type_Awfy = this.jdField_a_of_type_Awfy;
      Object localObject = paramBundle.getString("comicId");
      String str1 = paramBundle.getString("picMd5");
      String str2 = paramBundle.getString("actionData");
      paramBundle = new JSONObject();
      try
      {
        paramBundle.put("comicId", localObject);
        paramBundle.put("picMd5", str1);
        paramBundle.put("actionData", str2);
        localObject = new cmd0x388.ExtensionCommPicTryUp();
        ((cmd0x388.ExtensionCommPicTryUp)localObject).rpt_bytes_extinfo.add(ByteStringMicro.copyFrom(paramBundle.toString().getBytes()));
        paramOnInvokeFinishLinstener.jdField_a_of_type_ArrayOfByte = ((cmd0x388.ExtensionCommPicTryUp)localObject).toByteArray();
        if (this.jdField_a_of_type_Batw == null) {
          continue;
        }
        this.jdField_a_of_type_Batw.a(paramOnInvokeFinishLinstener);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Batw = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biiz
 * JD-Core Version:    0.7.0.1
 */