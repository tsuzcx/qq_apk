import android.os.Bundle;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.nearby.now.nearby_now_anchor.AnchorStatus;
import tencent.nearby.now.nearby_now_anchor.RspBatchGetAnchorStatus;

public abstract class apeh
  extends nac
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    Object localObject = null;
    nearby_now_anchor.RspBatchGetAnchorStatus localRspBatchGetAnchorStatus;
    boolean bool1;
    if (paramInt == 0)
    {
      localRspBatchGetAnchorStatus = new nearby_now_anchor.RspBatchGetAnchorStatus();
      bool1 = bool4;
    }
    for (;;)
    {
      try
      {
        localRspBatchGetAnchorStatus.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = localObject;
        bool2 = bool3;
        bool1 = bool4;
        if (localRspBatchGetAnchorStatus.uint32_result.has())
        {
          paramArrayOfByte = localObject;
          bool2 = bool3;
          bool1 = bool4;
          if (localRspBatchGetAnchorStatus.uint32_result.get() == 0)
          {
            bool1 = true;
            bool2 = true;
            paramArrayOfByte = localRspBatchGetAnchorStatus.msg_anchor_stats.get();
          }
        }
      }
      catch (Exception localException)
      {
        paramArrayOfByte = localObject;
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.msg_box.protocol", 2, localException.toString());
        paramArrayOfByte = localObject;
        bool2 = bool1;
        continue;
      }
      a(bool2, paramArrayOfByte, paramBundle);
      return;
      paramArrayOfByte = localObject;
      boolean bool2 = bool3;
      if (QLog.isColorLevel())
      {
        QLog.w("Q.msg_box.protocol", 2, "getNowState failed, errorCode=" + paramInt);
        paramArrayOfByte = localObject;
        bool2 = bool3;
      }
    }
  }
  
  public abstract void a(boolean paramBoolean, List<nearby_now_anchor.AnchorStatus> paramList, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apeh
 * JD-Core Version:    0.7.0.1
 */