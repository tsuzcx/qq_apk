import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.open.agent.CreateVirtualAccountFragment;
import mqq.app.QQPermissionCallback;

class bjma
  implements QQPermissionCallback
{
  bjma(bjlz parambjlz) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.a(this.a.a.getActivity(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a.a = ProfileActivity.a(this.a.a.getActivity(), 257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjma
 * JD-Core Version:    0.7.0.1
 */