import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class axtg
{
  axtg(axsv paramaxsv) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    bfur.a(axsv.a(this.a), 2131697857, 2131697858).setOnDismissListener(new axth(this));
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    ((axvk)axsv.a(this.a).getManager(369)).a(9);
    axsv.a(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtg
 * JD-Core Version:    0.7.0.1
 */