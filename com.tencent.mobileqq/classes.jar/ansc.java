import android.os.Bundle;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment.2.1;
import com.tencent.qphone.base.util.QLog;

public class ansc
  extends ajjh
{
  public ansc(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onUpdateAddFriend isSuccess=%s addSuccess=%s reqestUin=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString }));
    }
    paramString = this.a.a.a(this.a.c);
    if ((paramString != null) && (!paramString.mAddFriendVerified))
    {
      paramString.mAddFriendVerified = true;
      ExtendFriendSquareFragment.a(this.a).post(new ExtendFriendSquareFragment.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ansc
 * JD-Core Version:    0.7.0.1
 */