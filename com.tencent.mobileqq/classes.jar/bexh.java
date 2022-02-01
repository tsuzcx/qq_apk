import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.TicketManager;
import mqq.util.WeakReference;

public class bexh
{
  private long jdField_a_of_type_Long;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<bexj> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  
  public bexh(bexj parambexj, String paramString, long paramLong1, long paramLong2, boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parambexj);
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    String str2 = paramQQAppInterface.getCurrentUin();
    Object localObject = (TicketManager)paramQQAppInterface.getManager(2);
    String str1;
    if (localObject != null)
    {
      str1 = ((TicketManager)localObject).getSkey(str2);
      localObject = ((TicketManager)localObject).getPskey(str2, "qun.qq.com");
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      HashMap localHashMap = new HashMap();
      localBundle.putString("bkn", "" + TroopUtils.getBknBySkey(str1));
      localBundle.putString("Cookie", "uin=o" + str2 + ";skey=" + str1 + ";p_uin=o" + str2 + ";p_skey=" + (String)localObject);
      localBundle.putString("gc", String.valueOf(this.jdField_a_of_type_JavaLangString));
      localBundle.putString("append_appid", String.valueOf(this.jdField_a_of_type_Long));
      localBundle.putString("add_type", "1");
      localBundle.putString("append_source", String.valueOf(this.b));
      localBundle.putString("qqver", "8.4.8.4810");
      localBundle.putString("platform", "2");
      if (this.jdField_a_of_type_Boolean) {}
      for (localObject = "1";; localObject = "0")
      {
        localBundle.putString("open_shortcut", (String)localObject);
        localHashMap.put("BUNDLE", localBundle);
        localHashMap.put("CONTEXT", paramQQAppInterface.getApp().getApplicationContext());
        new beze("https://app.qun.qq.com/cgi-bin/api/inner_setunifiedapp", "POST", new bexi(this), 1000, null).a(localHashMap);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AddTroopAppCgi", 2, "AddTroopAppCgi mTroopUin:" + this.jdField_a_of_type_JavaLangString + " append_appid:" + this.jdField_a_of_type_Long + " mNeedOpenShortCut:" + this.jdField_a_of_type_Boolean);
        return;
      }
      localObject = null;
      str1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bexh
 * JD-Core Version:    0.7.0.1
 */