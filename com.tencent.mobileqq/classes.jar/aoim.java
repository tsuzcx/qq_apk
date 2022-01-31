import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aoim
  extends aoez
{
  public aoim(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, aofu paramaofu, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onMatchResponse success=%s match_op=%s retCode=%s info=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramaofu }));
    }
  }
  
  protected void a(boolean paramBoolean1, long paramLong, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<aogm> paramList, aoft paramaoft)
  {
    if (ExtendFriendSquareFragment.a(this.a) != paramLong) {
      return;
    }
    try
    {
      ExtendFriendSquareFragment.a(this.a, 1);
      ExtendFriendSquareFragment.a(this.a, paramBoolean1, paramString, paramBoolean2, paramArrayOfByte, paramBoolean3, paramBoolean4, paramInt, paramList, paramaoft);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ExtendFriendSquareFragment", 1, "onGetSquareStrangerList exception", paramString);
    }
  }
  
  protected void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onLimitChatResourceStateUpdate, isReady = " + paramBoolean);
    }
    if (ExtendFriendSquareFragment.a(this.a)) {
      ExtendFriendSquareFragment.b(this.a);
    }
    while (!ExtendFriendSquareFragment.c(this.a)) {
      return;
    }
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aoim
 * JD-Core Version:    0.7.0.1
 */