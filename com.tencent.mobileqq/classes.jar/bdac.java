import android.support.v4.app.FragmentActivity;
import com.tencent.open.agent.CreateVirtualAccountFragment;
import com.tencent.open.agent.CreateVirtualAccountFragment.6.1;
import com.tencent.open.agent.CreateVirtualAccountFragment.6.2;
import com.tencent.open.model.CreateVirtualResult;
import com.tencent.qphone.base.util.QLog;

public class bdac
  extends bdnx
{
  public bdac(CreateVirtualAccountFragment paramCreateVirtualAccountFragment) {}
  
  protected void a(boolean paramBoolean, CreateVirtualResult paramCreateVirtualResult, int paramInt)
  {
    if (this.a.getActivity() == null)
    {
      QLog.e("CreateVirtualAccountFragment", 1, "onCreate activity is null");
      return;
    }
    this.a.getActivity().runOnUiThread(new CreateVirtualAccountFragment.6.2(this, paramBoolean, paramCreateVirtualResult, paramInt));
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (this.a.getActivity() == null)
    {
      QLog.e("CreateVirtualAccountFragment", 1, "onUploadAvatar activity is null");
      return;
    }
    this.a.getActivity().runOnUiThread(new CreateVirtualAccountFragment.6.1(this, paramBoolean, paramString1, paramString2, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdac
 * JD-Core Version:    0.7.0.1
 */