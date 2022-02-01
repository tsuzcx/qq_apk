import android.support.v4.app.FragmentActivity;
import com.tencent.open.agent.OpenSelectPermissionFragment;
import com.tencent.open.agent.OpenSelectPermissionFragment.4.1;
import com.tencent.qphone.base.util.QLog;

public class bhuc
  extends bhvf
{
  public bhuc(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public void a(boolean paramBoolean, int paramInt, bhvg parambhvg)
  {
    QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, new Object[] { "-->onDoAuthorize isSuccess=", Boolean.valueOf(paramBoolean), ", code=", Integer.valueOf(paramInt) });
    if (this.a.getActivity() == null)
    {
      QLog.e("SDK_LOGIN.OpenSelectPermissionFragment", 1, "onDoAuthorize activity is null");
      return;
    }
    this.a.getActivity().runOnUiThread(new OpenSelectPermissionFragment.4.1(this, paramBoolean, parambhvg, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhuc
 * JD-Core Version:    0.7.0.1
 */