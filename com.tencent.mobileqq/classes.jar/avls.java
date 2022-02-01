import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.protocol.GetArkTailReq;
import com.tencent.mobileqq.gamecenter.protocol.ReportTypeReq;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.observer.BusinessObserver;

public class avls
{
  private static volatile avls jdField_a_of_type_Avls;
  private Map<MessageRecord, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static avls a()
  {
    if (jdField_a_of_type_Avls == null) {}
    try
    {
      if (jdField_a_of_type_Avls == null) {
        jdField_a_of_type_Avls = new avls();
      }
      return jdField_a_of_type_Avls;
    }
    finally {}
  }
  
  public void a(long paramLong, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Object localObject = (Long)this.jdField_a_of_type_JavaUtilMap.get(paramMessageRecord);
    if (localObject == null) {}
    for (long l1 = 0L;; l1 = ((Long)localObject).longValue())
    {
      long l2 = NetConnInfoCenter.getServerTimeMillis();
      if (l2 - Long.valueOf(l1).longValue() <= 30000L) {
        break;
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramMessageRecord, Long.valueOf(l2));
      localObject = alil.a();
      if (localObject == null) {
        break;
      }
      GetArkTailReq localGetArkTailReq = new GetArkTailReq();
      localGetArkTailReq.appid = (paramLong + "");
      localGetArkTailReq.tt = 1;
      localGetArkTailReq.scene_id = 1;
      localGetArkTailReq.qq_version = bhlo.c();
      akxq.a(localGetArkTailReq, new avlu(this, paramMessageRecord, new WeakReference(localObject)));
      return;
    }
  }
  
  public void a(long paramLong, BusinessObserver paramBusinessObserver)
  {
    GetArkTailReq localGetArkTailReq = new GetArkTailReq();
    localGetArkTailReq.appid = (paramLong + "");
    localGetArkTailReq.tt = 1;
    localGetArkTailReq.scene_id = 3;
    localGetArkTailReq.qq_version = bhlo.c();
    akxq.a(localGetArkTailReq, paramBusinessObserver);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ReportTypeReq localReportTypeReq = new ReportTypeReq();
    localReportTypeReq.appid = paramString;
    localReportTypeReq.type = paramInt1;
    localReportTypeReq.sub_type = paramInt2;
    localReportTypeReq.tt = 1;
    akxq.a(localReportTypeReq, new avlt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avls
 * JD-Core Version:    0.7.0.1
 */