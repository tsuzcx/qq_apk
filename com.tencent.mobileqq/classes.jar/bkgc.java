import SWEET_NEW_COMM_SVR.sweet_comm_cfg_get_rsp;
import SWEET_NEW_COMM_SVR.sweet_comm_cfg_item;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.QzoneExternalRequest;
import java.util.Map;

public class bkgc
  extends bkfv
{
  private void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof sweet_comm_cfg_item)))
    {
      paramObject = (sweet_comm_cfg_item)paramObject;
      if (a() != null)
      {
        asig localasig = (asig)a().a(153);
        if (localasig != null) {
          localasig.a(true, paramObject.wording, paramObject.dynamic_value, paramObject.url);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (a() == null);
      paramObject = (asig)a().a(153);
    } while (paramObject == null);
    paramObject.a(false, null, null, null);
  }
  
  public QQAppInterface a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public QzoneExternalRequest a(Intent paramIntent)
  {
    return new bkgd(this, paramIntent);
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
    if (paramFromServiceMsg != null) {}
    for (int i = paramFromServiceMsg.getResultCode(); i == 1000; i = -1)
    {
      paramIntent = (sweet_comm_cfg_get_rsp)bjur.a(paramFromServiceMsg.getWupBuffer(), "GetCommCfg");
      if ((paramIntent != null) && (paramIntent.m_cfg_res != null))
      {
        paramIntent = (sweet_comm_cfg_item)paramIntent.m_cfg_res.get(new Long(1L));
        if (paramIntent != null) {
          bool = true;
        }
        a(bool, paramIntent);
      }
      return;
    }
    a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgc
 * JD-Core Version:    0.7.0.1
 */