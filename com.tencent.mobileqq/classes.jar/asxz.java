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

public class asxz
{
  private static asxz jdField_a_of_type_Asxz;
  private ConcurrentLinkedQueue<String> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  public static asxz a()
  {
    try
    {
      if (jdField_a_of_type_Asxz == null) {
        jdField_a_of_type_Asxz = new asxz();
      }
      asxz localasxz = jdField_a_of_type_Asxz;
      return localasxz;
    }
    finally {}
  }
  
  public static void a(String paramString1, nlo paramnlo, String paramString2)
  {
    asye.b(paramString1, paramString2);
    if (paramnlo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "doDeleteItem bingo clearDistInfo  uin:" + paramString2);
      }
      paramString1 = paramnlo.a.iterator();
      while (paramString1.hasNext()) {
        asyf.b(((nlp)paramString1.next()).b);
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
        RecentUser localRecentUser = ((amnz)localObject).a(paramString, 10005);
        if (localRecentUser != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdvertisement", 2, "doDeleteItem bingo Recent  uin:" + paramString);
          }
          ajjj.a().a(localRecentUser.uin + "-" + localRecentUser.getType());
          ((amnz)localObject).b(localRecentUser);
          ajlb.b(paramQQAppInterface, paramString, 10005);
          paramQQAppInterface.a().c(paramString, 10005);
        }
      }
      localObject = asyc.a().a(paramString);
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break;
      }
      ThreadManager.executeOnFileThread(new ImaxAdDeleteManager.1(this, (nlo)localObject, paramQQAppInterface, paramString));
      return;
    }
    a(paramQQAppInterface.c(), (nlo)localObject, paramString);
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
    while (!TextUtils.isEmpty(asye.a(paramString1, "delete_st_" + paramString2))) {
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
      long l = Long.valueOf(asye.a(paramString, "delete_st_" + str)).longValue();
      if (NetConnInfoCenter.getServerTimeMillis() - l > 86400000L)
      {
        a(str);
        asye.a(paramString, "delete_st_" + str);
      }
    }
    asye.a(paramString, "delete_uin_list", a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxz
 * JD-Core Version:    0.7.0.1
 */