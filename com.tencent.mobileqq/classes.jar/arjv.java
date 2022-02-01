import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class arjv
  implements aroz
{
  public arjv(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  public void enterAio(String paramString1, String paramString2)
  {
    aros.a(this.a.a, paramString1, paramString2);
  }
  
  public void showCampusVerifyDialog(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    aros.a(this.a.a, paramBoolean, paramInt, paramString1, paramString2);
  }
  
  public void showMatchCountDialog()
  {
    aros.a(this.a.a);
  }
  
  public void showToast(int paramInt)
  {
    if (this.a.a == null)
    {
      QLog.d("ExtendFriendBaseFragment", 1, "sendMsgDirectly()-> showToast() mActivity is null just return");
      return;
    }
    aros.a(this.a.a, this.a.a.getString(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjv
 * JD-Core Version:    0.7.0.1
 */