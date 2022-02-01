import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imaxad.ImaxAdDeleteManager.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class avxu
{
  private static avxu jdField_a_of_type_Avxu;
  private ConcurrentLinkedQueue<String> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public static avxu a()
  {
    try
    {
      if (jdField_a_of_type_Avxu == null) {
        jdField_a_of_type_Avxu = new avxu();
      }
      avxu localavxu = jdField_a_of_type_Avxu;
      return localavxu;
    }
    finally {}
  }
  
  public static void a(String paramString1, nwf paramnwf, String paramString2)
  {
    avxz.b(paramString1, paramString2);
    if (paramnwf != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "doDeleteItem bingo clearDistInfo  uin:" + paramString2);
      }
      paramString1 = paramnwf.a.iterator();
      while (paramString1.hasNext()) {
        avya.b(((nwg)paramString1.next()).b);
      }
    }
  }
  
  private boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramString);
    }
    return false;
  }
  
  public String a()
  {
    localJSONArray = new JSONArray();
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("senderUin", str);
        if (localJSONObject != null) {
          localJSONArray.put(localJSONObject);
        }
      }
      return localJSONArray.toString();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "doDeleteItem  uin:" + paramString);
    }
    Object localObject = (ProxyManager)paramQQAppInterface.getManager(18);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((ProxyManager)localObject).a())
    {
      if (localObject != null)
      {
        RecentUser localRecentUser = (RecentUser)((apaw)localObject).findRecentUserByUin(paramString, 10005);
        if (localRecentUser != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdvertisement", 2, "doDeleteItem bingo Recent  uin:" + paramString);
          }
          alni.a().a(localRecentUser.uin + "-" + localRecentUser.getType());
          ((apaw)localObject).delRecentUser(localRecentUser);
          alpb.b(paramQQAppInterface, paramString, 10005);
          paramQQAppInterface.a().c(paramString, 10005);
        }
      }
      localObject = avxx.a().a(paramString);
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break;
      }
      ThreadManager.executeOnFileThread(new ImaxAdDeleteManager.1(this, (nwf)localObject, paramQQAppInterface, paramString));
      return;
    }
    a(paramQQAppInterface.c(), (nwf)localObject, paramString);
  }
  
  public void a(String paramString)
  {
    if (!b(paramString)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramString);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (b(paramString2)) {}
    while (!TextUtils.isEmpty(avxz.a(paramString1, "delete_st_" + paramString2))) {
      return true;
    }
    return false;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "convertStringToList  str:" + paramString);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.clear();
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        a(paramString.getJSONObject(i).getString("senderUin"));
        i += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void c(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      long l = Long.valueOf(avxz.a(paramString, "delete_st_" + str)).longValue();
      if (NetConnInfoCenter.getServerTimeMillis() - l > 86400000L)
      {
        a(str);
        avxz.a(paramString, "delete_st_" + str);
      }
    }
    avxz.a(paramString, "delete_uin_list", a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxu
 * JD-Core Version:    0.7.0.1
 */