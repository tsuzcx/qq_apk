import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class avop
  extends akim
{
  public avop(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (paramBoolean)
    {
      if (!this.a.isAdded())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReceiptMessageReadMemberListContainerFragment", 2, "onUpdateTroopGetMemberList succ with fragment is detached");
        }
        return;
      }
      ReceiptMessageReadMemberListContainerFragment.a(this.a).getApp().getSharedPreferences("last_update_time" + ReceiptMessageReadMemberListContainerFragment.a(this.a).getCurrentAccountUin(), 4).edit().putLong("key_last_update_time" + ReceiptMessageReadMemberListContainerFragment.a(this.a), paramLong).apply();
      ReceiptMessageReadMemberListContainerFragment.a(this.a).sendEmptyMessage(4);
      ReceiptMessageReadMemberListContainerFragment.a(this.a).removeObserver(this);
      return;
    }
    ReceiptMessageReadMemberListContainerFragment.a(this.a).sendEmptyMessage(-1);
    QLog.d("ReceiptMessageReadMemberListContainerFragment", 1, "mTroopObserver onUpdateTroopGetMemberList fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avop
 * JD-Core Version:    0.7.0.1
 */