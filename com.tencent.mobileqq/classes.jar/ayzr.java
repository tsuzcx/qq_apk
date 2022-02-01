import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class ayzr
{
  ayzr(ayzg paramayzg) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    bhdj.a(ayzg.a(this.a), 2131698140, 2131698141).setOnDismissListener(new ayzs(this));
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    ((azbv)ayzg.a(this.a).getManager(QQManagerFactory.ONLINE_STATUS_MANAGER)).a(9);
    ayzg.a(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzr
 * JD-Core Version:    0.7.0.1
 */