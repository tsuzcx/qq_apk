import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import mqq.app.QQPermissionCallback;

public class azxa
  implements QQPermissionCallback
{
  public azxa(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbdj.a(this.a.getActivity(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.c = TroopHWJsPlugin.a(this.a.getActivity(), 260);
    bfni.a(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azxa
 * JD-Core Version:    0.7.0.1
 */