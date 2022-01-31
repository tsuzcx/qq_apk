import SWEET_NEW_BASE.sweet_rsp_comm;
import SWEET_NEW_PAIR.sweet_pair_byebye_rsp;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.QzoneExternalRequest;

public class bhzx
  extends bhzs
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
    return new bhzy(this, paramIntent);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("currentUin", paramLong1);
    localIntent.putExtra("friendUin", paramLong2);
    a(localIntent);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = a();
    int i;
    if (localObject != null)
    {
      localObject = (aqkh)((QQAppInterface)localObject).a(153);
      paramIntent = String.valueOf(paramIntent.getLongExtra("friendUin", -1L));
      if (paramFromServiceMsg == null) {
        break label98;
      }
      i = paramFromServiceMsg.getResultCode();
    }
    while (i == 1000)
    {
      paramFromServiceMsg = (sweet_pair_byebye_rsp)bhoz.a(paramFromServiceMsg.getWupBuffer(), "sweet_pair_byebye");
      if (paramFromServiceMsg != null)
      {
        paramFromServiceMsg = paramFromServiceMsg.rsp_comm;
        if (paramFromServiceMsg.retcode == 0) {
          ((aqkh)localObject).a(true, paramFromServiceMsg.retcode, paramFromServiceMsg.errmsg, paramIntent);
        }
      }
      else
      {
        return;
        label98:
        i = -1;
        continue;
      }
      ((aqkh)localObject).a(false, paramFromServiceMsg.retcode, paramFromServiceMsg.errmsg, paramIntent);
      return;
    }
    ((aqkh)localObject).a(false, -1, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhzx
 * JD-Core Version:    0.7.0.1
 */