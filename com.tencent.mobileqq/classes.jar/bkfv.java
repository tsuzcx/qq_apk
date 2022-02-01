import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import mqq.manager.Manager;
import org.json.JSONObject;
import tencent.im.cs.cmd0x388.cmd0x388.ExtensionCommPicTryUp;

public class bkfv
  implements Manager
{
  private ayeo jdField_a_of_type_Ayeo = new bkfw(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public RemoteCommand.OnInvokeFinishLinstener a;
  private TransFileController jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  private String jdField_a_of_type_JavaLangString;
  
  public bkfv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramQQAppInterface.getTransFileController();
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentUin();
  }
  
  public void a(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener = paramOnInvokeFinishLinstener;
      paramOnInvokeFinishLinstener = new TransferRequest();
      paramOnInvokeFinishLinstener.mFileType = 24;
      paramOnInvokeFinishLinstener.mCommandId = 20;
      paramOnInvokeFinishLinstener.mRichTag = "actQqComicPicUpload";
      paramOnInvokeFinishLinstener.mSelfUin = this.jdField_a_of_type_JavaLangString;
      paramOnInvokeFinishLinstener.mPeerUin = this.jdField_a_of_type_JavaLangString;
      paramOnInvokeFinishLinstener.mIsUp = true;
      paramOnInvokeFinishLinstener.mLocalPath = paramBundle.getString("localPath");
      paramOnInvokeFinishLinstener.mUpCallBack = this.jdField_a_of_type_Ayeo;
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
        paramOnInvokeFinishLinstener.mExtentionInfo = ((cmd0x388.ExtensionCommPicTryUp)localObject).toByteArray();
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.transferAsync(paramOnInvokeFinishLinstener);
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
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkIpcRemoteCommand$OnInvokeFinishLinstener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkfv
 * JD-Core Version:    0.7.0.1
 */