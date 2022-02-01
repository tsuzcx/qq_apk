import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import mqq.app.QQPermissionCallback;

public class bfqi
  implements QQPermissionCallback
{
  public bfqi(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(this.a.getActivity(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.c = TroopHWJsPlugin.a(this.a.getActivity(), 260);
    bkxz.a(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfqi
 * JD-Core Version:    0.7.0.1
 */