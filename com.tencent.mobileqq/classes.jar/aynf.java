import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class aynf
{
  aynf(aymu paramaymu) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    bglp.a(aymu.a(this.a), 2131697627, 2131697628).setOnDismissListener(new ayng(this));
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    ((aypj)aymu.a(this.a).getManager(369)).a(9);
    aymu.a(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynf
 * JD-Core Version:    0.7.0.1
 */