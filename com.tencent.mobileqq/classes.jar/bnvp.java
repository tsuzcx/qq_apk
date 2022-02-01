import SWEET_NEW_BASE.sweet_rsp_comm;
import SWEET_NEW_PAIR.sweet_pair_check_rsp;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.QzoneExternalRequest;

public class bnvp
  extends bnvr
{
  public QQAppInterface a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public QzoneExternalRequest a(Intent paramIntent)
  {
    return new bnvq(this, paramIntent);
  }
  
  public void a(long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("currentUin", paramLong);
    a(localIntent);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool = false;
    paramIntent = a();
    if (paramIntent != null)
    {
      paramIntent = (aobj)paramIntent.a(172);
      if (paramIntent != null) {
        if (paramFromServiceMsg == null) {
          break label90;
        }
      }
    }
    label90:
    for (int i = paramFromServiceMsg.getResultCode(); i == 1000; i = -1)
    {
      paramFromServiceMsg = (sweet_pair_check_rsp)bnke.a(paramFromServiceMsg.getWupBuffer(), "getPairState");
      if (paramFromServiceMsg == null) {
        break;
      }
      sweet_rsp_comm localsweet_rsp_comm = paramFromServiceMsg.rsp_comm;
      if (localsweet_rsp_comm == null) {
        break;
      }
      if (localsweet_rsp_comm.retcode == 0) {
        bool = true;
      }
      paramIntent.a(bool, paramFromServiceMsg);
      return;
    }
    paramIntent.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnvp
 * JD-Core Version:    0.7.0.1
 */