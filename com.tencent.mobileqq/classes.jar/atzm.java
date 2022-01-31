import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.NowPushMsg;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class atzm
  implements Manager
{
  private QQAppInterface a;
  
  public atzm(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private boolean a(NowPushMsgList.NowPushMsg paramNowPushMsg)
  {
    if ((paramNowPushMsg.uint32_version.get() == 0L) && (paramNowPushMsg.uint64_start_time.get() == 0L) && (paramNowPushMsg.uint64_end_time.get() == 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NowHongbaoPushManager", 2, "发送wns日志请求");
      }
      ((arik)this.a.getManager(306)).c();
      return true;
    }
    return false;
  }
  
  private void c(NowPushMsgList.NowPushMsg paramNowPushMsg)
  {
    if (a(paramNowPushMsg)) {}
  }
  
  public void a(NowPushMsgList.NowPushMsg paramNowPushMsg)
  {
    QLog.i("NowHongbaoPushManager", 1, "receiveOnLinePush ： type=" + paramNowPushMsg.uint32_type.get() + ", show=" + paramNowPushMsg.uint32_switch.get() + ", startTime=" + paramNowPushMsg.uint64_start_time.get() + ", endTime=" + paramNowPushMsg.uint64_end_time.get() + ",taskId =" + paramNowPushMsg.uint32_task_id.get() + ",version =" + paramNowPushMsg.uint32_version.get());
    c(paramNowPushMsg);
  }
  
  public void b(NowPushMsgList.NowPushMsg paramNowPushMsg)
  {
    QLog.i("NowHongbaoPushManager", 1, "receiveOfflinePush ： type=" + paramNowPushMsg.uint32_type.get() + ", show=" + paramNowPushMsg.uint32_switch.get() + ", startTime=" + paramNowPushMsg.uint64_start_time.get() + ", endTime=" + paramNowPushMsg.uint64_end_time.get() + ",taskId =" + paramNowPushMsg.uint32_task_id.get() + ",version =" + paramNowPushMsg.uint32_version.get());
    c(paramNowPushMsg);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atzm
 * JD-Core Version:    0.7.0.1
 */