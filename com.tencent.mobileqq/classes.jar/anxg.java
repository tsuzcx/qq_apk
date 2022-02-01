import android.text.format.Time;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.QQConfMeetingLogReportHelper.2;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class anxg
{
  static anxg jdField_a_of_type_Anxg;
  private bczp jdField_a_of_type_Bczp = new anxh(this);
  ShareAppLogHelper jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  anxg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public static anxg a(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_Anxg = new anxg(paramQQAppInterface);
    return jdField_a_of_type_Anxg;
  }
  
  private void a(String paramString)
  {
    QLog.w("QQConfMeetingLogReportHelper", 1, "sendFile begin, path[" + paramString + "], Thread[" + Thread.currentThread().getId() + "]");
    ThreadManager.post(new QQConfMeetingLogReportHelper.2(this, paramString), 2, null, true);
  }
  
  protected int a(long paramLong)
  {
    Time localTime = new Time();
    localTime.set(paramLong);
    return localTime.hour;
  }
  
  protected String a(long paramLong)
  {
    Time localTime = new Time();
    localTime.set(paramLong);
    return localTime.year + "-" + (localTime.month + 1) + "-" + localTime.monthDay;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    long l2 = System.currentTimeMillis();
    long l1 = paramLong1;
    if (paramLong2 - paramLong1 < 1800000L) {
      l1 = paramLong2 - 1800000L;
    }
    Object localObject2 = String.format("%02d", new Object[] { Integer.valueOf(a(l1)) });
    Object localObject1 = String.format("%02d", new Object[] { Integer.valueOf(a(paramLong2)) });
    String str2 = a(l1);
    String str1 = a(paramLong2);
    localObject2 = ShareAppLogHelper.a(str2 + "-" + (String)localObject2, "-");
    localObject1 = ShareAppLogHelper.a(str1 + "-" + (String)localObject1, "-");
    this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper = new ShareAppLogHelper(((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getApplication().getBaseContext());
    this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper.a(this.jdField_a_of_type_Bczp);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper.a((Time)localObject2, (Time)localObject1, true);
    paramLong1 = System.currentTimeMillis();
    QLog.w("QQConfMeetingLogReportHelper", 1, "doReportLocalLog, ret[" + bool + "], startTime[" + localObject2 + "], endTime[" + localObject1 + "], cost[" + (paramLong1 - l2) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxg
 * JD-Core Version:    0.7.0.1
 */