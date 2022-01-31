import android.content.ContentValues;
import android.os.Handler;
import android.os.Looper;
import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy.1;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy.2;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy.3;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy.4;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import java.util.ArrayList;
import java.util.List;

public class amjg
  extends amiz
{
  List<MpfileTaskRecord> a;
  
  public amjg(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  private String a(long paramLong, int paramInt)
  {
    String str = MpfileTaskRecord.tableName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * ").append("from " + str + " ");
    if (paramLong != -1L) {
      localStringBuilder.append("where " + str + ".msgId < ? ");
    }
    localStringBuilder.append("limit " + paramInt + " ");
    return localStringBuilder.toString();
  }
  
  public long a(MpfileTaskRecord paramMpfileTaskRecord)
  {
    ew localew = new ew(false, false);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      a(paramMpfileTaskRecord, null);
      return 0L;
    }
    new Handler(localLooper).post(new MpfileTaskProxy.4(this, paramMpfileTaskRecord, localew));
    localew.a(-1L);
    return 0L;
  }
  
  public List<MpfileTaskRecord> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      Object localObject = MpfileTaskRecord.tableName();
      awbw localawbw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localawbw.b("create index if not exists " + (String)localObject + "_index ON " + (String)localObject + "(fileId, msgId)");
      List localList = localawbw.a(MpfileTaskRecord.class, a(-1L, 15), null);
      localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilList = ((List)localObject);
      localawbw.a();
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected void a() {}
  
  public void a(awbv paramawbv, amji paramamji)
  {
    ew localew = new ew(false, false);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      paramawbv = ((MpfileTaskRecord)paramawbv).clone();
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, MpfileTaskRecord.tableName(), paramawbv, 0, paramamji);
      return;
    }
    new Handler(localLooper).post(new MpfileTaskProxy.1(this, paramawbv, paramamji, localew));
    localew.a(-1L);
  }
  
  public void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, amji paramamji)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, paramString1, paramContentValues, paramString2, paramArrayOfString, 1, paramamji);
      return;
    }
    new Handler(localLooper).post(new MpfileTaskProxy.2(this, paramString1, paramContentValues, paramString2, paramArrayOfString, paramamji));
  }
  
  public void a(String paramString1, String paramString2, String[] paramArrayOfString, amji paramamji)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, paramString1, paramString2, paramArrayOfString, 2, paramamji);
      return;
    }
    new Handler(localLooper).post(new MpfileTaskProxy.3(this, paramString1, paramString2, paramArrayOfString, paramamji));
  }
  
  protected void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amjg
 * JD-Core Version:    0.7.0.1
 */