import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.OpenAuthorityFragment.12.1;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;

public class bjdr
  extends bjgg
{
  public bjdr(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onDeleteVirtual isSuccess=", Boolean.valueOf(paramBoolean), ", code=", Integer.valueOf(paramInt) });
    if (paramBoolean) {
      return;
    }
    this.a.k();
    if (paramInt == 151)
    {
      bjhh.a(this.a.getActivity(), anvx.a(2131707306), false);
      this.a.c(OpenAuthorityFragment.b(this.a));
      return;
    }
    bjhh.a(this.a.getActivity(), anvx.a(2131707308) + paramInt, false);
  }
  
  public void a(boolean paramBoolean, int paramInt, bjgh parambjgh)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onDoAuthorize isSuccess=", Boolean.valueOf(paramBoolean), ", code=", Integer.valueOf(paramInt) });
    auuv.a("KEY_AUTHORIZE_REQUEST", OpenAuthorityFragment.a(this.a), paramBoolean);
    Object localObject;
    if ((paramBoolean) && (parambjgh != null))
    {
      localObject = this.a.a.obtainMessage();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = parambjgh;
      this.a.a.sendMessage((Message)localObject);
      return;
    }
    if (paramInt == 110509)
    {
      if (OpenAuthorityFragment.e(this.a) >= 2)
      {
        bjhh.a(this.a.getActivity(), anvx.a(2131707307), false);
        parambjgh = OpenAuthorityFragment.a(this.a).a().a(OpenAuthorityFragment.a(this.a));
        localObject = this.a;
        if (parambjgh == null) {}
        for (parambjgh = null;; parambjgh = parambjgh.a)
        {
          ((OpenAuthorityFragment)localObject).c(parambjgh);
          bjhg.a(OpenAuthorityFragment.b(this.a), "0X800B65F");
          return;
        }
      }
      OpenAuthorityFragment.f(this.a);
      OpenAuthorityFragment.a(this.a, 1);
      return;
    }
    if (paramInt == 110537)
    {
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onDoAuthorize 110537");
      bjhh.a(this.a.getActivity(), anvx.a(2131707309), false);
      this.a.c(OpenAuthorityFragment.b(this.a));
      return;
    }
    if ((parambjgh != null) && (!TextUtils.isEmpty(parambjgh.a.get()))) {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "-->onDoAuthorize error msg: " + parambjgh.a.get());
    }
    bjhg.a(OpenAuthorityFragment.b(this.a), "0X800B65F");
    bjhh.a(this.a.getActivity(), anvx.a(2131694461), false);
  }
  
  public void a(boolean paramBoolean, GetVirtualListResult paramGetVirtualListResult)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onGetVirtualList isSuccess=", Boolean.valueOf(paramBoolean) });
    if (OpenAuthorityFragment.a(this.a))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, " activity is isInvalid");
      return;
    }
    auuv.a("KEY_GET_VIRTUAL_LIST_D24", OpenAuthorityFragment.a(this.a), paramBoolean);
    this.a.getActivity().runOnUiThread(new OpenAuthorityFragment.12.1(this, paramBoolean, paramGetVirtualListResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjdr
 * JD-Core Version:    0.7.0.1
 */