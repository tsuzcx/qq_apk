import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;

public class aycz
{
  public long a;
  private boolean a;
  public long b;
  private boolean b;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long = -1L;
  private boolean jdField_d_of_type_Boolean;
  private long e = -1L;
  
  public aycz()
  {
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Long = (aydq.a("gifWifiPreDownloadLimit", 1000L) * 1024L * 1024L);
    this.jdField_b_of_type_Long = (aydq.a("gifXgPreDownloadLimit", 32L) * 1024L * 1024L);
    if (QLog.isColorLevel()) {
      QLog.d("GIFPreDownloadLimit", 2, new Object[] { "initConfig, gifWifiPreDownloadLimit=", Long.valueOf(this.jdField_a_of_type_Long), " gifXgPreDownloadLimit=", Long.valueOf(this.jdField_b_of_type_Long) });
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    int i = -1;
    int j;
    if (paramBoolean1)
    {
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = true;
        i = 4;
      }
      j = i;
      if (!paramBoolean2) {
        break label277;
      }
      j = i;
      if (this.jdField_a_of_type_Boolean) {
        break label277;
      }
      this.jdField_a_of_type_Boolean = true;
      j = 2;
    }
    for (;;)
    {
      label62:
      label106:
      HashMap localHashMap;
      if (i > 0)
      {
        if (paramBoolean1)
        {
          str = "gifWifiFirstFlag";
          aydq.a(str, 1L);
          bcef.b(null, "dc00898", "", "", "0X800B3BA", "0X800B3BA", i, 0, "", "", "", "");
        }
      }
      else
      {
        if (j > 0)
        {
          if (!paramBoolean1) {
            break label256;
          }
          str = "gifWifiOverFlag";
          aydq.a(str, 1L);
          bcef.b(null, "dc00898", "", "", "0X800B3BA", "0X800B3BA", j, 0, "", "", "", "");
        }
        localHashMap = new HashMap();
        if (!paramBoolean1) {
          break label263;
        }
        str = "Wifi";
        label154:
        localHashMap.put("NetworkType", str);
        if (!paramBoolean2) {
          break label270;
        }
      }
      label256:
      label263:
      label270:
      for (String str = "1";; str = "0")
      {
        localHashMap.put("OverLimit", str);
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "AioGifPreDownload", true, -1L, paramLong, localHashMap, null);
        return;
        if (!this.jdField_d_of_type_Boolean)
        {
          this.jdField_d_of_type_Boolean = true;
          i = 3;
        }
        j = i;
        if (!paramBoolean2) {
          break label277;
        }
        j = i;
        if (this.jdField_b_of_type_Boolean) {
          break label277;
        }
        this.jdField_b_of_type_Boolean = true;
        j = 1;
        break;
        str = "gifXgFirstFlag";
        break label62;
        str = "gifXgOverFlag";
        break label106;
        str = "XG";
        break label154;
      }
      label277:
      int k = -1;
      i = j;
      j = k;
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
  
  public static boolean a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {}
    while ((paramMessageForPic.mNotPredownloadReason != -11) && (paramMessageForPic.mNotPredownloadReason != 2)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(MessageForPic paramMessageForPic, boolean paramBoolean, int paramInt)
  {
    if (paramMessageForPic == null) {
      if ((!paramBoolean) || (paramInt != 5)) {}
    }
    while ((bkkh.a(paramMessageForPic.imageType)) && (paramInt == 5))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {
      this.jdField_c_of_type_Long += paramLong;
    }
    for (;;)
    {
      aydq.a("gifWifiPreDownloadFlow", this.jdField_c_of_type_Long);
      aydq.a("gifXgPreDownloadFlow", this.jdField_d_of_type_Long);
      aydq.a("gifPreDownloadTimestamp", this.e);
      return;
      this.jdField_d_of_type_Long += paramLong;
    }
  }
  
  public boolean a(boolean paramBoolean, long paramLong)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.jdField_c_of_type_Long < 0L) || (this.jdField_d_of_type_Long < 0L) || (this.e < 0L))
    {
      this.jdField_c_of_type_Long = aydq.a("gifWifiPreDownloadFlow", 0L);
      this.jdField_d_of_type_Long = aydq.a("gifXgPreDownloadFlow", 0L);
      this.e = aydq.a("gifPreDownloadTimestamp", 0L);
      if (this.e == 0L) {
        this.e = System.currentTimeMillis();
      }
      if (aydq.a("gifWifiOverFlag", 0L) == 1L)
      {
        bool1 = true;
        this.jdField_a_of_type_Boolean = bool1;
        if (aydq.a("gifXgOverFlag", 0L) != 1L) {
          break label254;
        }
        bool1 = true;
        label110:
        this.jdField_b_of_type_Boolean = bool1;
        if (aydq.a("gifWifiFirstFlag", 0L) != 1L) {
          break label260;
        }
        bool1 = true;
        label130:
        this.jdField_c_of_type_Boolean = bool1;
        if (aydq.a("gifXgFirstFlag", 0L) != 1L) {
          break label266;
        }
        bool1 = true;
        label150:
        this.jdField_d_of_type_Boolean = bool1;
      }
    }
    else
    {
      if (!a(this.e, System.currentTimeMillis()))
      {
        this.jdField_c_of_type_Long = 0L;
        this.jdField_d_of_type_Long = 0L;
        this.e = System.currentTimeMillis();
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = false;
        this.jdField_c_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = false;
      }
      if (!paramBoolean) {
        break label278;
      }
      if (this.jdField_c_of_type_Long <= this.jdField_a_of_type_Long) {
        break label272;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      if (!bool1) {
        a(paramBoolean, paramLong);
      }
      a(paramBoolean, bool1, paramLong);
      return bool1;
      bool1 = false;
      break;
      label254:
      bool1 = false;
      break label110;
      label260:
      bool1 = false;
      break label130;
      label266:
      bool1 = false;
      break label150;
      label272:
      bool1 = false;
      continue;
      label278:
      bool1 = bool2;
      if (this.jdField_d_of_type_Long <= this.jdField_b_of_type_Long) {
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycz
 * JD-Core Version:    0.7.0.1
 */