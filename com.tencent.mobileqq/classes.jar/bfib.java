import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.3.1;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.3.2;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class bfib
  implements bghi
{
  bfib(bfhz parambfhz) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        if (paramJSONObject.optInt("retcode") == 0) {
          break label760;
        }
        i = paramJSONObject.optInt("ec");
        if (i == 0) {
          break label760;
        }
        i = 0;
        if (i == 0)
        {
          if ((paramInt == 1000) || (paramInt == 1002))
          {
            bfhz.e(this.a);
            this.a.notifyObservers(Integer.valueOf(103));
            if (paramInt == 1002) {
              this.a.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopFeedsDataManager", 2, "cgi end(failed): " + System.currentTimeMillis());
          }
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle = paramBundle;
        paramBundle.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("TroopFeedsDataManager", 2, "cgi end(suc): " + System.currentTimeMillis());
        }
        if (paramInt == 1000)
        {
          ThreadManager.getSubThreadHandler().post(new TroopFeedsDataManager.3.1(this, paramJSONObject));
          return;
        }
      }
      finally {}
      if (paramInt == 1002)
      {
        ThreadManager.getSubThreadHandler().post(new TroopFeedsDataManager.3.2(this, paramJSONObject));
        return;
      }
      if (paramInt == 1007)
      {
        this.a.b = paramJSONObject;
        bfhz.f(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("TroopFeedsDataManager", 2, "cgi return. requestCode: GET_TROOP_NOTICE, msg = NOTIFY_REMIND_NOTICE");
        }
        this.a.notifyObservers(Integer.valueOf(1011));
        return;
      }
      Object localObject;
      JSONObject localJSONObject;
      if ((paramInt == 1004) || (paramInt == 1003))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopFeedsDataManager", 2, "cgi return. requestCode: GET_NOR_NOTICE");
        }
        localObject = paramJSONObject.optJSONArray("feeds");
        paramBundle = paramJSONObject.optJSONArray("inst");
        if ((localObject != null) && (((JSONArray)localObject).length() == 1))
        {
          localJSONObject = ((JSONArray)localObject).optJSONObject(0);
          this.a.b = localJSONObject;
          this.a.jdField_a_of_type_Int = paramJSONObject.optInt("ad");
          paramInt = 1;
        }
      }
      for (;;)
      {
        i = paramInt;
        if (paramBundle != null)
        {
          i = paramInt;
          if (paramBundle.length() > 0)
          {
            paramBundle = paramBundle.optJSONObject(0);
            long l2 = paramBundle.optLong("pubt");
            long l1 = 0L;
            if (this.a.b != null) {
              l1 = this.a.b.optLong("pubt");
            }
            i = paramInt;
            if (l2 > l1)
            {
              this.a.b = paramBundle;
              this.a.jdField_a_of_type_Int = paramJSONObject.optInt("ad");
              i = 1;
            }
          }
        }
        if (i != 0)
        {
          bfhz.g(this.a);
          if (QLog.isColorLevel()) {
            QLog.d("TroopFeedsDataManager", 2, "cgi return. NOTIFY_NOR_NOTICE");
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopFeedsDataManager", 2, "NOTIFY_NOR_NOTICE : " + this.a.countObservers());
          }
          this.a.notifyObservers(Integer.valueOf(1007));
          return;
          if ((localObject != null) && (((JSONArray)localObject).length() == 2))
          {
            localJSONObject = ((JSONArray)localObject).optJSONObject(0);
            localObject = ((JSONArray)localObject).optJSONObject(1);
            if (localJSONObject.optLong("pubt") >= ((JSONObject)localObject).optLong("pubt")) {
              this.a.b = localJSONObject;
            }
            for (this.a.jdField_a_of_type_Int = paramJSONObject.optInt("ad");; this.a.jdField_a_of_type_Int = paramJSONObject.optInt("ad"))
            {
              paramInt = 1;
              break;
              this.a.b = ((JSONObject)localObject);
            }
          }
        }
        else
        {
          bfhz.h(this.a);
          this.a.notifyObservers(Integer.valueOf(1012));
          return;
          if ((paramInt != 1005) && (paramInt != 1006)) {
            break;
          }
          paramJSONObject = bfhq.a(paramJSONObject, "" + this.a.jdField_a_of_type_JavaLangLong, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          paramBundle = (List)paramJSONObject[0];
          paramJSONObject = (List)paramJSONObject[1];
          this.a.jdField_a_of_type_JavaUtilList = paramJSONObject;
          bfhz.i(this.a);
          if (paramInt == 1005)
          {
            this.a.notifyObservers(Integer.valueOf(1008));
            return;
          }
          this.a.notifyObservers(Integer.valueOf(1009));
          return;
        }
        paramInt = 0;
      }
      label760:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfib
 * JD-Core Version:    0.7.0.1
 */