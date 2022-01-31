import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aqaq
  extends apxc
{
  public aqaq(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onUpdateCampusCertificateStatus isSuccess=%s scene=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if ((paramBoolean) && (paramInt == 1)) {
      ExtendFriendSquareFragment.b(this.a);
    }
    if (paramBoolean) {
      ExtendFriendSquareFragment.a(this.a);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, apyc paramapyc, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onMatchResponse success=%s match_op=%s retCode=%s info=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramapyc }));
    }
  }
  
  protected void a(boolean paramBoolean1, long paramLong, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<apyo> paramList, apyb paramapyb)
  {
    if (this.a.b != paramLong) {
      return;
    }
    try
    {
      ExtendFriendSquareFragment.a(this.a, 1);
      ExtendFriendSquareFragment.a(this.a, paramBoolean1, paramString, paramBoolean2, paramArrayOfByte, paramBoolean3, paramBoolean4, paramInt, paramList, paramapyb);
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
    ExtendFriendSquareFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqaq
 * JD-Core Version:    0.7.0.1
 */