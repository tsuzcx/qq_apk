import android.support.v4.app.FragmentActivity;
import com.tencent.open.agent.OpenSelectPermissionFragment;
import com.tencent.open.agent.OpenSelectPermissionFragment.4.1;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;

public class bddd
  extends bdom
{
  public bddd(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt, SdkAuthorize.AuthorizeResponse paramAuthorizeResponse)
  {
    if (this.a.getActivity() == null)
    {
      QLog.e("OpenSelectPermissionFragment", 1, "onDoAuthorize activity is null");
      return;
    }
    this.a.getActivity().runOnUiThread(new OpenSelectPermissionFragment.4.1(this, paramBoolean, paramAuthorizeResponse, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bddd
 * JD-Core Version:    0.7.0.1
 */