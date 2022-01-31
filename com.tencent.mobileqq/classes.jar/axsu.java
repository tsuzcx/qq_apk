import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.QLog.ILogCallback;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class axsu
  extends axso
  implements QLog.ILogCallback
{
  private int jdField_a_of_type_Int = 20;
  private long jdField_a_of_type_Long = 2000L;
  private axte jdField_a_of_type_Axte;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_b_of_type_Int = 50;
  private long jdField_b_of_type_Long;
  private Map<String, HashSet<Pair<Long, Integer>>> jdField_b_of_type_JavaUtilMap = new HashMap();
  private int jdField_c_of_type_Int = 100;
  private Map<String, HashSet<Pair<Long, Integer>>> jdField_c_of_type_JavaUtilMap = new HashMap();
  
  public axsu(axsn paramaxsn, String paramString)
  {
    super(paramaxsn, paramString);
    QLog.setLogCallback(this);
    if ((this.jdField_a_of_type_Array2dOfJavaLangString.length >= 1) && (this.jdField_a_of_type_Array2dOfJavaLangString[0].length >= 4))
    {
      this.jdField_a_of_type_Long = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][0]).intValue() * 1000L);
      this.jdField_b_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][1]).intValue();
      this.jdField_c_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][2]).intValue();
      this.jdField_a_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][3]).intValue();
    }
    this.jdField_a_of_type_Axte = new axte(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_JavaUtilMap.put("MSF.D.MonitorSocket", Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilMap.put("Q.msg.MsgProxy|addMsgQueue", Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilMap.put("Q.db.Cache|writeRunable", Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilMap.put("Q.msg.MsgProxy|writeRunable", Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilMap.put("Q.db.Cache|addMsgQueue", Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilMap.put("SQLiteOpenHelper| getWritableDatabase", Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilMap.put("SQLiteOpenHelper| getReadableDatabase", Integer.valueOf(0));
  }
  
  public void a(Bundle paramBundle)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while (paramBundle.getInt("key_action") != 6) {
      return;
    }
    String str = paramBundle.getString("key_log");
    int i = paramBundle.getInt("key_count");
    if (QLog.isColorLevel()) {
      QLog.d("BatteryStats", 2, "LOG.onOtherProcReport：" + str + ", count:" + i);
    }
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      HashSet localHashSet;
      if (this.jdField_b_of_type_Boolean)
      {
        localHashSet = (HashSet)this.jdField_b_of_type_JavaUtilMap.get(str);
        paramBundle = localHashSet;
        if (localHashSet == null)
        {
          paramBundle = new HashSet();
          this.jdField_b_of_type_JavaUtilMap.put(str, paramBundle);
        }
        paramBundle.add(new Pair(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)));
      }
      if ((this.jdField_c_of_type_Boolean) && (this.d))
      {
        localHashSet = (HashSet)this.jdField_c_of_type_JavaUtilMap.get(str);
        paramBundle = localHashSet;
        if (localHashSet == null)
        {
          paramBundle = new HashSet();
          this.jdField_c_of_type_JavaUtilMap.put(str, paramBundle);
        }
        paramBundle.add(new Pair(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i)));
      }
      return;
    }
  }
  
  public void b()
  {
    super.b();
    synchronized (this.jdField_b_of_type_JavaUtilMap)
    {
      this.jdField_c_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  public void e()
  {
    super.e();
    if ((axsn.a()) && (this.jdField_a_of_type_Boolean)) {}
    label290:
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilMap)
      {
        Iterator localIterator1 = this.jdField_b_of_type_JavaUtilMap.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        axsn.b(this.jdField_b_of_type_Axsn, new String[] { "fg30LogCount", "|", String.valueOf(i) });
        localIterator1 = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          StringBuilder localStringBuilder = axsk.a();
          HashSet localHashSet = (HashSet)this.jdField_b_of_type_JavaUtilMap.get(str);
          Iterator localIterator2 = localHashSet.iterator();
          i = 0;
          if (localIterator2.hasNext())
          {
            Pair localPair = (Pair)localIterator2.next();
            localStringBuilder.append(localPair.first).append(",").append(localPair.second);
            i += 1;
            if (i >= localHashSet.size()) {
              break label290;
            }
            localStringBuilder.append("#");
            break label290;
          }
          axsn.b(this.jdField_b_of_type_Axsn, new String[] { "fg30LogAlarm", "|", str, "|", localStringBuilder.toString() });
        }
      }
      this.jdField_b_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  public void f()
  {
    super.f();
    if ((axsn.a()) && (this.jdField_a_of_type_Boolean)) {}
    label292:
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilMap)
      {
        Iterator localIterator1 = this.jdField_c_of_type_JavaUtilMap.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        axsn.b(this.jdField_b_of_type_Axsn, new String[] { "bg5LogCount", "|", String.valueOf(i) });
        localIterator1 = this.jdField_c_of_type_JavaUtilMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          HashSet localHashSet = (HashSet)this.jdField_c_of_type_JavaUtilMap.get(str);
          StringBuilder localStringBuilder = axsk.a();
          Iterator localIterator2 = localHashSet.iterator();
          i = 0;
          if (localIterator2.hasNext())
          {
            Pair localPair = (Pair)localIterator2.next();
            localStringBuilder.append(localPair.first).append(",").append(localPair.second);
            i += 1;
            if (i >= localHashSet.size()) {
              break label292;
            }
            localStringBuilder.append("#");
            break label292;
          }
          axsn.b(this.jdField_b_of_type_Axsn, new String[] { "bg5LogAlarm", "|", str, "|", localStringBuilder.toString() });
        }
      }
      this.jdField_c_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  public void onWriteLog(String paramString1, String paramString2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Axte.a();
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      this.jdField_a_of_type_Axte.a(paramString1 + "|" + paramString2);
    } while (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long <= this.jdField_a_of_type_Long);
    Map localMap = this.jdField_a_of_type_Axte.a();
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Axte.a();
    Object localObject;
    if (localMap != null)
    {
      paramString1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        localObject = localMap.keySet().iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((String)((Iterator)localObject).next()).contains(paramString2)) {
            ((Iterator)localObject).remove();
          }
        }
      }
    }
    int i;
    if ((localMap != null) && (localMap.size() > 0))
    {
      localObject = new StringBuilder(localMap.size() * 20 + 10);
      paramString1 = null;
      Iterator localIterator = localMap.keySet().iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        paramString2 = (String)localIterator.next();
        if (((StringBuilder)localObject).length() > 0) {
          ((StringBuilder)localObject).append("#");
        }
        ((StringBuilder)localObject).append("[").append(paramString2).append(",").append(localMap.get(paramString2)).append("]");
        if (((Integer)localMap.get(paramString2)).intValue() <= i) {
          break label549;
        }
        i = ((Integer)localMap.get(paramString2)).intValue();
        paramString1 = paramString2;
      }
    }
    label549:
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_action", 6);
      localBundle.putString("key_log", paramString2);
      localBundle.putInt("key_count", ((Integer)localMap.get(paramString2)).intValue());
      if (!axsn.a()) {
        axsi.a().a(localBundle);
      }
      for (;;)
      {
        break;
        a(localBundle);
      }
      axsn.a(this.jdField_b_of_type_Axsn, new String[] { "log|", ((StringBuilder)localObject).toString() });
      paramString2 = this.jdField_b_of_type_Axsn;
      if (i > this.jdField_c_of_type_Int) {}
      for (int j = 1;; j = 0)
      {
        axsn.a(paramString2, 2, 0, j, ajyc.a(2131701070) + paramString1, "2秒钟日志打印次数：" + i);
        return;
      }
      if ((axsn.a(this.jdField_b_of_type_Axsn) == null) || (!QLog.isColorLevel())) {
        break;
      }
      axsn.a(this.jdField_b_of_type_Axsn, "No high frequnecy log in last 2seconds");
      return;
    }
  }
  
  public void onWriteLog(String paramString, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axsu
 * JD-Core Version:    0.7.0.1
 */