import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.OpenAuthorityFragment.13.1;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;

public class bdbw
  extends bdom
{
  public bdbw(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    QLog.d("OpenAuthorityFragment", 1, new Object[] { "-->onDeleteVirtual isSuccess=", Boolean.valueOf(paramBoolean), ", code=", Integer.valueOf(paramInt) });
    if (paramBoolean) {
      return;
    }
    this.a.m();
    OpenAuthorityFragment.a(this.a, ajya.a(2131707861) + paramInt, false);
  }
  
  protected void a(boolean paramBoolean, int paramInt, SdkAuthorize.AuthorizeResponse paramAuthorizeResponse)
  {
    QLog.d("OpenAuthorityFragment", 1, new Object[] { "-->onDoAuthorize isSuccess=", Boolean.valueOf(paramBoolean), ", code=", Integer.valueOf(paramInt) });
    aqgj.a("KEY_AUTHORIZE_REQUEST", this.a.jdField_a_of_type_Bdnp, paramBoolean);
    if ((paramBoolean) && (paramAuthorizeResponse != null))
    {
      Message localMessage = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = paramAuthorizeResponse;
      this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
      return;
    }
    if ((paramAuthorizeResponse != null) && (!TextUtils.isEmpty(paramAuthorizeResponse.msg.get())))
    {
      OpenAuthorityFragment.a(this.a, paramAuthorizeResponse.msg.get() + ajya.a(2131707858) + paramInt, false);
      return;
    }
    OpenAuthorityFragment.a(this.a, ajya.a(2131707860) + paramInt, false);
  }
  
  public void a(boolean paramBoolean, GetVirtualListResult paramGetVirtualListResult)
  {
    QLog.d("OpenAuthorityFragment", 1, new Object[] { "-->onGetVirtualList isSuccess=", Boolean.valueOf(paramBoolean) });
    if (OpenAuthorityFragment.a(this.a))
    {
      QLog.e("OpenAuthorityFragment", 1, " activity is isInvalid");
      return;
    }
    aqgj.a("KEY_GET_VIRTUAL_LIST_D24", this.a.jdField_a_of_type_Bdnp, paramBoolean);
    this.a.getActivity().runOnUiThread(new OpenAuthorityFragment.13.1(this, paramBoolean, paramGetVirtualListResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdbw
 * JD-Core Version:    0.7.0.1
 */