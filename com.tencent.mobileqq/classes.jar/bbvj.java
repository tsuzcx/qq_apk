import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import mqq.app.QQPermissionCallback;

public class bbvj
  implements QQPermissionCallback
{
  public bbvj(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.a(this.a.getActivity(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.c = TroopHWJsPlugin.a(this.a.getActivity(), 260);
    bhoc.a(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvj
 * JD-Core Version:    0.7.0.1
 */