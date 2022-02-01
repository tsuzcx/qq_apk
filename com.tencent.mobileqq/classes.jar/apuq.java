import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class apuq
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public int c;
  public int d;
  public int e;
  
  public apuq()
  {
    a();
  }
  
  public static apuq a(String paramString)
  {
    QLog.d("TroopNotificationConfig.config", 1, "onUpdate, newConf = " + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = 0;
    int j = 0;
    long l2 = 0L;
    int k = 0;
    n = 0;
    l4 = 0L;
    int i4 = 0;
    l1 = l4;
    m = n;
    i1 = k;
    long l3 = l2;
    int i2 = j;
    int i3 = i;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        l1 = l4;
        m = n;
        i1 = k;
        l3 = l2;
        i2 = j;
        i3 = i;
        i = paramString.optInt("globalOpen", 0);
        l1 = l4;
        m = n;
        i1 = k;
        l3 = l2;
        i2 = j;
        i3 = i;
        j = paramString.optInt("totalRemindCntOfOneWeak", 0);
        l1 = l4;
        m = n;
        i1 = k;
        l3 = l2;
        i2 = j;
        i3 = i;
        l2 = paramString.optLong("intervelShowTime", 0L);
        l1 = l4;
        m = n;
        i1 = k;
        l3 = l2;
        i2 = j;
        i3 = i;
        k = paramString.optInt("totalRemindCntOfOneDay");
        l1 = l4;
        m = n;
        i1 = k;
        l3 = l2;
        i2 = j;
        i3 = i;
        n = paramString.optInt("todoGroupVerifyMsgLevel", 0);
        l1 = l4;
        m = n;
        i1 = k;
        l3 = l2;
        i2 = j;
        i3 = i;
        l4 = paramString.optLong("cleanExpiredTime", 0L);
        l1 = l4;
        m = n;
        i1 = k;
        l3 = l2;
        i2 = j;
        i3 = i;
        int i5 = paramString.optInt("maxFetchMsgCnt", 300);
        m = i5;
        paramString.printStackTrace();
      }
      catch (JSONException paramString)
      {
        try
        {
          i1 = paramString.optInt("showUnreadBk", 0);
          i3 = n;
          l1 = l4;
          i2 = m;
          n = i1;
          paramString = new apuq();
          if (i != 1) {
            break label423;
          }
          bool = true;
          paramString.jdField_a_of_type_Boolean = bool;
          paramString.jdField_a_of_type_Int = j;
          paramString.jdField_a_of_type_Long = l2;
          paramString.jdField_b_of_type_Int = k;
          paramString.c = i3;
          paramString.jdField_b_of_type_Long = l1;
          paramString.d = i2;
          paramString.e = n;
          return paramString;
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            boolean bool;
            i1 = m;
            l1 = l4;
            m = n;
          }
        }
        paramString = paramString;
        n = 0;
        i = i3;
        j = i2;
        l2 = l3;
        k = i1;
        i1 = n;
      }
      n = i4;
      i2 = i1;
      i3 = m;
      continue;
      label423:
      bool = false;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 100;
    this.jdField_a_of_type_Long = 60L;
    this.jdField_b_of_type_Int = 100;
    this.c = 10;
    this.jdField_b_of_type_Long = 1209600L;
    this.d = 300;
    this.e = 0;
  }
  
  public String toString()
  {
    return "TroopNotificationConfig{isGlobalOpen=" + this.jdField_a_of_type_Boolean + ", totalRemindCntOfOneWeak=" + this.jdField_a_of_type_Int + ", intervelShowTime=" + this.jdField_a_of_type_Long + ", totalRemindCntOfOneDay=" + this.jdField_b_of_type_Int + ", todoGroupVerifyMsgLevel=" + this.c + ", cleanExpiredTime=" + this.jdField_b_of_type_Long + ", maxFetchMsgCnt=" + this.d + ", showUnreadBk=" + this.e + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apuq
 * JD-Core Version:    0.7.0.1
 */