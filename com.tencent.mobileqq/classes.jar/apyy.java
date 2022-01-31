import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment;
import com.tencent.qphone.base.util.QLog;

public class apyy
  extends apxc
{
  public apyy(ExtendFriendCampusFragment paramExtendFriendCampusFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusFragment", 2, String.format("onUpdateCampusCertificateStatus isSuccess=%s scene=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if ((paramBoolean) && (paramInt == 1)) {
      ExtendFriendCampusFragment.a(this.a);
    }
    if ((paramBoolean) && (ExtendFriendCampusFragment.a(this.a) != null)) {
      ExtendFriendCampusFragment.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apyy
 * JD-Core Version:    0.7.0.1
 */