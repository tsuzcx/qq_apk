import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.open.agent.CreateVirtualAccountFragment;
import mqq.app.QQPermissionCallback;

class bdaq
  implements QQPermissionCallback
{
  bdaq(bdap parambdap) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbdj.a(this.a.a.getActivity(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a.a = ProfileActivity.a(this.a.a.getActivity(), 257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdaq
 * JD-Core Version:    0.7.0.1
 */