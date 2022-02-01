import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_PAIR.sweet_pair_check_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class aobj
  extends anud
{
  protected aobj(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  protected aobj(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(long paramLong)
  {
    if ((this.app != null) && (paramLong > 0L))
    {
      SharedPreferences localSharedPreferences = this.app.getPreferences();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putLong("love_uin_for_current_user", paramLong).apply();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.app != null)
    {
      SharedPreferences localSharedPreferences = this.app.getPreferences();
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putInt("love_state_for_current_uin" + this.app.c(), paramInt).apply();
      }
    }
    notifyUI(1, true, Integer.valueOf(paramInt));
  }
  
  public void a(boolean paramBoolean, sweet_pair_check_rsp paramsweet_pair_check_rsp)
  {
    if ((paramBoolean) && (paramsweet_pair_check_rsp != null)) {
      if (paramsweet_pair_check_rsp.host_state != 3) {
        break label42;
      }
    }
    label42:
    for (int i = 1;; i = 0)
    {
      a(i);
      if (paramsweet_pair_check_rsp.req_comm != null) {
        a(paramsweet_pair_check_rsp.req_comm.loveuin);
      }
      return;
    }
  }
  
  protected Class<? extends anui> observerClass()
  {
    return aobk.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aobj
 * JD-Core Version:    0.7.0.1
 */