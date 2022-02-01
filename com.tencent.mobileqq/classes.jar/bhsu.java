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

public class bhsu
  extends bhvf
{
  public bhsu(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onDeleteVirtual isSuccess=", Boolean.valueOf(paramBoolean), ", code=", Integer.valueOf(paramInt) });
    if (paramBoolean) {
      return;
    }
    this.a.k();
    if (paramInt == 151)
    {
      bhwf.a(this.a.getActivity(), amtj.a(2131706960), false);
      this.a.c(OpenAuthorityFragment.b(this.a));
      return;
    }
    bhwf.a(this.a.getActivity(), amtj.a(2131706962) + paramInt, false);
  }
  
  public void a(boolean paramBoolean, int paramInt, bhvg parambhvg)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onDoAuthorize isSuccess=", Boolean.valueOf(paramBoolean), ", code=", Integer.valueOf(paramInt) });
    atqa.a("KEY_AUTHORIZE_REQUEST", OpenAuthorityFragment.a(this.a), paramBoolean);
    Object localObject;
    if ((paramBoolean) && (parambhvg != null))
    {
      localObject = this.a.a.obtainMessage();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = parambhvg;
      this.a.a.sendMessage((Message)localObject);
      return;
    }
    if (paramInt == 110509)
    {
      if (OpenAuthorityFragment.e(this.a) >= 2)
      {
        bhwf.a(this.a.getActivity(), amtj.a(2131706961), false);
        parambhvg = OpenAuthorityFragment.a(this.a).a().a(OpenAuthorityFragment.a(this.a));
        localObject = this.a;
        if (parambhvg == null) {}
        for (parambhvg = null;; parambhvg = parambhvg.a)
        {
          ((OpenAuthorityFragment)localObject).c(parambhvg);
          return;
        }
      }
      OpenAuthorityFragment.f(this.a);
      OpenAuthorityFragment.a(this.a, 1);
      return;
    }
    if ((parambhvg != null) && (!TextUtils.isEmpty(parambhvg.a.get()))) {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "-->onDoAuthorize error msg: " + parambhvg.a.get());
    }
    bhwf.a(this.a.getActivity(), amtj.a(2131694263), false);
  }
  
  public void a(boolean paramBoolean, GetVirtualListResult paramGetVirtualListResult)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onGetVirtualList isSuccess=", Boolean.valueOf(paramBoolean) });
    if (OpenAuthorityFragment.a(this.a))
    {
      QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, " activity is isInvalid");
      return;
    }
    atqa.a("KEY_GET_VIRTUAL_LIST_D24", OpenAuthorityFragment.a(this.a), paramBoolean);
    this.a.getActivity().runOnUiThread(new OpenAuthorityFragment.12.1(this, paramBoolean, paramGetVirtualListResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhsu
 * JD-Core Version:    0.7.0.1
 */