import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class azfy
{
  azfy(azfn paramazfn) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    bhlq.a(azfn.a(this.a), 2131697711, 2131697712).setOnDismissListener(new azfz(this));
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    ((azic)azfn.a(this.a).getManager(369)).a(9);
    azfn.a(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfy
 * JD-Core Version:    0.7.0.1
 */