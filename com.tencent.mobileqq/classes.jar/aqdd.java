import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class aqdd
  implements aqhr
{
  public aqdd(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  public void a()
  {
    aqhi.a(this.a.a);
  }
  
  public void a(int paramInt)
  {
    if (this.a.a == null)
    {
      QLog.d("ExtendFriendBaseFragment", 1, "sendMsgDirectly()-> showToast() mActivity is null just return");
      return;
    }
    aqhi.a(this.a.a, this.a.a.getString(paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    aqhi.a(this.a.a, paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    aqhi.a(this.a.a, paramBoolean, paramInt, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdd
 * JD-Core Version:    0.7.0.1
 */