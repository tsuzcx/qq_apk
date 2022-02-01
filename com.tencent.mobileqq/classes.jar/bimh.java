import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.OpenAuthorityFragment.12.1;
import com.tencent.open.model.AccountManage.RefreshReason;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;

public class bimh
  extends bior
{
  public bimh(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onDeleteVirtual isSuccess=", Boolean.valueOf(paramBoolean), ", code=", Integer.valueOf(paramInt) });
    if (paramBoolean) {
      return;
    }
    this.a.k();
    OpenAuthorityFragment.a(this.a, anni.a(2131706622) + paramInt, false);
  }
  
  public void a(boolean paramBoolean, int paramInt, bios parambios)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onDoAuthorize isSuccess=", Boolean.valueOf(paramBoolean), ", code=", Integer.valueOf(paramInt) });
    aukw.a("KEY_AUTHORIZE_REQUEST", OpenAuthorityFragment.a(this.a), paramBoolean);
    Object localObject;
    if ((paramBoolean) && (parambios != null))
    {
      localObject = this.a.a.obtainMessage();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = parambios;
      this.a.a.sendMessage((Message)localObject);
      return;
    }
    if (paramInt == 110509)
    {
      if (OpenAuthorityFragment.e(this.a) >= 2)
      {
        parambios = OpenAuthorityFragment.a(this.a).a().a(OpenAuthorityFragment.a(this.a));
        localObject = this.a;
        if (parambios == null) {}
        for (parambios = null;; parambios = parambios.a)
        {
          ((OpenAuthorityFragment)localObject).c(parambios);
          return;
        }
      }
      OpenAuthorityFragment.f(this.a);
      OpenAuthorityFragment.a(this.a, AccountManage.RefreshReason.forceRefreshBy110509);
      return;
    }
    if ((parambios != null) && (!TextUtils.isEmpty(parambios.a.get())))
    {
      OpenAuthorityFragment.a(this.a, parambios.a.get() + anni.a(2131706619) + paramInt, false);
      return;
    }
    OpenAuthorityFragment.a(this.a, anni.a(2131706621) + paramInt, false);
  }
  
  public void a(boolean paramBoolean, GetVirtualListResult paramGetVirtualListResult)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onGetVirtualList isSuccess=", Boolean.valueOf(paramBoolean) });
    if (OpenAuthorityFragment.a(this.a))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, " activity is isInvalid");
      return;
    }
    aukw.a("KEY_GET_VIRTUAL_LIST_D24", OpenAuthorityFragment.a(this.a), paramBoolean);
    this.a.getActivity().runOnUiThread(new OpenAuthorityFragment.12.1(this, paramBoolean, paramGetVirtualListResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bimh
 * JD-Core Version:    0.7.0.1
 */