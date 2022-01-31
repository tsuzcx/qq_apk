import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class azoe
  extends azoc
  implements Handler.Callback
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = 300000L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private Map<Integer, azof> jdField_a_of_type_JavaUtilMap = new HashMap();
  private long jdField_b_of_type_Long = 1800000L;
  private long c = 3600000L;
  private long d = 300000L;
  private long jdField_e_of_type_Long = 180000L;
  private boolean jdField_e_of_type_Boolean = true;
  private long f;
  private long g;
  private long h;
  private long i;
  private long j;
  
  public azoe(azob paramazob, String paramString)
  {
    super(paramazob, paramString);
    if ((this.jdField_a_of_type_Array2dOfJavaLangString.length >= 1) && (this.jdField_a_of_type_Array2dOfJavaLangString[0].length >= 3))
    {
      this.jdField_a_of_type_Long = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][0]).intValue() * 60 * 1000L);
      this.jdField_b_of_type_Long = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][1]).intValue() * 60 * 1000L);
      this.c = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][2]).intValue() * 60 * 1000L);
    }
    if ((this.jdField_a_of_type_Array2dOfJavaLangString.length >= 2) && (this.jdField_a_of_type_Array2dOfJavaLangString[1].length >= 2))
    {
      this.d = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[1][0]).intValue() * 60 * 1000L);
      this.jdField_e_of_type_Boolean = this.jdField_a_of_type_Array2dOfJavaLangString[1][1].equals("1");
    }
    if ((this.jdField_a_of_type_Array2dOfJavaLangString.length >= 3) && (this.jdField_a_of_type_Array2dOfJavaLangString[2].length >= 1))
    {
      this.d = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[2][0]).intValue() * 60 * 1000L);
      this.jdField_a_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[2][1]).intValue();
    }
  }
  
  public void a()
  {
    this.f = alus.a("-1");
    if (azob.a())
    {
      this.g = alus.a("-2");
      localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, Long.valueOf(this.jdField_a_of_type_Long));
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.jdField_a_of_type_Long);
      localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, Long.valueOf(this.jdField_b_of_type_Long));
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.jdField_b_of_type_Long);
      localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, Long.valueOf(this.c));
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.c);
      return;
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, Long.valueOf(this.jdField_e_of_type_Long));
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.jdField_e_of_type_Long);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle.getInt("key_action") == 0)
    {
      int k = paramBundle.getInt("key_process_id");
      long l = paramBundle.getLong("key_cpu_usage");
      int m = paramBundle.getInt("key_monitor_secs");
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        azof localazof = (azof)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(k));
        paramBundle = localazof;
        if (localazof == null)
        {
          paramBundle = new azof(this, null);
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(k), paramBundle);
        }
        paramBundle.jdField_a_of_type_Long = (l + paramBundle.jdField_a_of_type_Long);
        paramBundle.jdField_a_of_type_Int += m;
        return;
      }
    }
  }
  
  public void b()
  {
    super.b();
    if ((azob.a()) && (this.jdField_a_of_type_Int > 0))
    {
      this.j = System.currentTimeMillis();
      this.h = alus.a("-1");
      this.i = alus.a("-2");
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, this.d);
    }
  }
  
  public void c()
  {
    super.c();
    if (azob.a()) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l1;
    long l2;
    int k;
    if (paramMessage.what == 0)
    {
      l1 = alus.a("-1");
      if (azob.a())
      {
        l2 = alus.a("-2");
        StringBuilder localStringBuilder = azny.a();
        synchronized (this.jdField_a_of_type_JavaUtilMap)
        {
          localStringBuilder.ensureCapacity(this.jdField_a_of_type_JavaUtilMap.size() * 10);
          Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
          if (localIterator.hasNext())
          {
            Integer localInteger = (Integer)localIterator.next();
            if (localStringBuilder.length() > 0) {
              localStringBuilder.append("#");
            }
            localStringBuilder.append("[").append(localInteger).append(",").append(((azof)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).jdField_a_of_type_Int).append(",").append(((azof)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).jdField_a_of_type_Long).append("]");
          }
        }
        k = (int)(((Long)paramMessage.obj).longValue() / 1000L);
        azob.a(this.jdField_b_of_type_Azob, "cpu, onStartup " + k + "sec: " + (l1 - this.f) + "|" + (l2 - this.g) + "|" + localStringBuilder.toString(), true);
        azob.a(this.jdField_b_of_type_Azob, new String[] { "cpu|fg|", String.valueOf(k), "|", String.valueOf(l1 - this.f), "|", String.valueOf(l2 - this.g), "|", localStringBuilder.toString() });
        if (k == 1800) {
          azob.b(this.jdField_b_of_type_Azob, new String[] { "fg30Cpu", "|", String.valueOf(l1 - this.f), "|", String.valueOf(l2 - this.g), "|", localStringBuilder.toString() });
        }
      }
    }
    for (;;)
    {
      return false;
      k = (int)(((Long)paramMessage.obj).longValue() / 1000L);
      paramMessage = new Bundle();
      paramMessage.putInt("key_action", 0);
      paramMessage.putLong("key_cpu_usage", l1 - this.f);
      paramMessage.putInt("key_monitor_secs", k);
      aznw.a().a(paramMessage);
      if (this.jdField_e_of_type_Boolean)
      {
        this.f = l1;
        paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, Long.valueOf(this.jdField_e_of_type_Long));
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, this.jdField_e_of_type_Long);
        continue;
        this.jdField_a_of_type_Int -= 1;
        if (System.currentTimeMillis() - this.j < this.d + 5000L)
        {
          l1 = alus.a("-1");
          l2 = alus.a("-2");
          k = (int)(this.d / 1000L);
          azob.a(this.jdField_b_of_type_Azob, "cpu, bg" + k + "sec: " + (l1 - this.h) + "/" + (l2 - this.i), true);
          azob.a(this.jdField_b_of_type_Azob, new String[] { "cpu|bg|", String.valueOf(k), "|", String.valueOf(l1 - this.h), "|", String.valueOf(l2 - this.i) });
          if (k == 300) {
            azob.b(this.jdField_b_of_type_Azob, new String[] { "bg5Cpu", "|", String.valueOf(l1 - this.f), "|", String.valueOf(l2 - this.g) });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azoe
 * JD-Core Version:    0.7.0.1
 */