import android.content.res.Resources;
import android.os.Message;
import android.widget.Button;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;

public class bfbb
  implements bfnk
{
  public bfbb(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void a()
  {
    if (!OpenAuthorityFragment.b(this.a))
    {
      QLog.e("OpenAuthorityFragment", 1, "updatePreAuthFromServer onSuccess for activity is finished");
      return;
    }
    Object localObject1 = this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(OpenAuthorityFragment.a(this.a));
    QLog.d("OpenAuthorityFragment", 1, new Object[] { "updatePreAuthFromServer use cached appid=", OpenAuthorityFragment.a(this.a), ", appInfo=", ((arua)localObject1).toString() });
    Object localObject2 = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    ((Message)localObject2).what = 3;
    ((Message)localObject2).obj = localObject1;
    this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject2);
    localObject1 = this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(OpenAuthorityFragment.a(this.a));
    boolean bool;
    if (localObject1 != null)
    {
      QLog.d("OpenAuthorityFragment", 1, "updatePreAuthFromServer onSuccess null != virtualResult");
      localObject2 = this.a.jdField_a_of_type_Bfnj;
      if (((GetVirtualListResult)localObject1).a == 0)
      {
        bool = true;
        ((bfnj)localObject2).a(bool, (GetVirtualListResult)localObject1);
      }
    }
    for (;;)
    {
      if (!this.a.b) {
        this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      }
      localObject1 = this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(OpenAuthorityFragment.a(this.a));
      localObject2 = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
      ((Message)localObject2).what = 0;
      ((Message)localObject2).obj = localObject1;
      this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject2);
      return;
      bool = false;
      break;
      QLog.d("OpenAuthorityFragment", 1, "updatePreAuthFromServer onSuccess null == virtualResult");
      this.a.jdField_a_of_type_Bfnj.a(false, null);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("OpenAuthorityFragment", 1, new Object[] { "updatePreAuthFromServer | onFail: | uin : *" + bfdz.a(this.a.jdField_a_of_type_Bfmm.a), ", errorCode=", Integer.valueOf(paramInt), ", errorMsg=", paramString });
    if (!OpenAuthorityFragment.b(this.a))
    {
      QLog.e("OpenAuthorityFragment", 1, "updatePreAuthFromServer onFail for activity is finished");
      return;
    }
    this.a.jdField_a_of_type_Bfnj.a(false, null);
    this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
    paramString = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
    paramString.what = 6;
    paramString.arg1 = 3001;
    paramString.obj = this.a.getResources().getString(2131695054);
    this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfbb
 * JD-Core Version:    0.7.0.1
 */