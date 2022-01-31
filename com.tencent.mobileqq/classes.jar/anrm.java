import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class anrm
  extends anoj
{
  public anrm(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
  protected void a(boolean paramBoolean1, long paramLong, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<anpv> paramList, anpd paramanpd)
  {
    if (ExtendFriendSearchFragment.a(this.a) != paramLong) {
      return;
    }
    try
    {
      ExtendFriendSearchFragment.a(this.a, 1);
      ExtendFriendSearchFragment.a(this.a, paramBoolean1, paramString, paramBoolean2, paramArrayOfByte, paramBoolean3, paramBoolean4, paramInt, paramList, paramanpd);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ExtendFriendSearchFragment", 1, "onGetSquareStrangerList exception", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anrm
 * JD-Core Version:    0.7.0.1
 */