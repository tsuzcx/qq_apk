import android.text.TextUtils;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongCalendarSyncUtil;
import cooperation.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;

public final class amkp
  implements Runnable
{
  public amkp(DingdongPluginDataFactory.ScheduleSummaryData paramScheduleSummaryData) {}
  
  public void run()
  {
    String str1;
    String str2;
    String str3;
    String str4;
    long l1;
    long l2;
    if (DingdongCalendarSyncUtil.a())
    {
      str1 = this.a.id;
      str2 = this.a.title;
      str3 = DingdongCalendarSyncUtil.a(this.a);
      str4 = this.a.location;
      l1 = this.a.beginTime;
      l2 = this.a.endTime;
      if (!DingdongCalendarSyncUtil.a(str1)) {
        break label80;
      }
      DingdongCalendarSyncUtil.a(str1, str2, str3, str4, l1, l2);
    }
    label80:
    String str5;
    do
    {
      return;
      str5 = DingdongCalendarSyncUtil.a();
      if (!TextUtils.isEmpty(str5)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("DingdongCalendarSyncUtil", 2, "accountId not create");
    return;
    DingdongCalendarSyncUtil.a(str1, str5, str2, str3, str4, l1, l2);
    TroopReportor.a("Grp_edu", "Grp_notice", "NoticeSys_Set", 0, 0, new String[] { String.valueOf(this.a.sourceId) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkp
 * JD-Core Version:    0.7.0.1
 */