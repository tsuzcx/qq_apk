import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aszg
  extends asvt
{
  public aszg(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
  protected void a(boolean paramBoolean1, long paramLong, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<asxh> paramList, aswu paramaswu)
  {
    if (this.a.b != paramLong) {
      return;
    }
    try
    {
      ExtendFriendSearchFragment.a(this.a, 1);
      ExtendFriendSearchFragment.a(this.a, paramBoolean1, paramString, paramBoolean2, paramArrayOfByte, paramBoolean3, paramBoolean4, paramInt, paramList, paramaswu);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ExtendFriendSearchFragment", 1, "onGetSquareStrangerList exception", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aszg
 * JD-Core Version:    0.7.0.1
 */