import android.text.TextUtils;
import com.tencent.mobileqq.apollo.process.data.CmGameShareDataHandler.1;
import com.tencent.mobileqq.apollo.process.data.CmGameShareDataHandler.3;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class amzh
{
  private static amzh jdField_a_of_type_Amzh;
  private Comparator<amzj> jdField_a_of_type_JavaUtilComparator = new amzi(this);
  private List<amzj> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap<String, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private amzh()
  {
    ThreadManagerV2.executeOnFileThread(new CmGameShareDataHandler.1(this));
  }
  
  public static amzh a()
  {
    try
    {
      if (jdField_a_of_type_Amzh == null) {
        jdField_a_of_type_Amzh = new amzh();
      }
      amzh localamzh = jdField_a_of_type_Amzh;
      return localamzh;
    }
    finally {}
  }
  
  private void a()
  {
    Object localObject = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/gameShareResult.txt");
    if (((File)localObject).exists()) {}
    for (;;)
    {
      int i;
      try
      {
        localObject = angg.a((File)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          QLog.e("cmgame_process.CmGameShareDataHandler", 1, "initCache, ApolloClientUtil.readFileSafety null");
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameShareDataHandler", 2, new Object[] { "initCache content:", localObject });
        }
        localObject = new JSONArray((String)localObject);
        int j = ((JSONArray)localObject).length();
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          if (localJSONObject == null) {
            break label301;
          }
          amzj localamzj = new amzj();
          localamzj.d = localJSONObject.optInt("shareTo");
          localamzj.b = localJSONObject.optInt("activity");
          localamzj.c = localJSONObject.optInt("aioType");
          localamzj.jdField_a_of_type_Int = localJSONObject.optInt("gameId");
          localamzj.jdField_a_of_type_JavaLangString = localJSONObject.optString("uin");
          localamzj.jdField_a_of_type_Long = localJSONObject.optLong("shareTS");
          localamzj.e = localJSONObject.optInt("shareRet");
          this.jdField_a_of_type_JavaUtilList.add(localamzj);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localamzj.a(), Boolean.TRUE);
          break label301;
        }
        Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
        QLog.d("cmgame_process.CmGameShareDataHandler", 1, new Object[] { "initCache finish mShareResultCache.size():", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
        return;
      }
      catch (Exception localException)
      {
        QLog.e("cmgame_process.CmGameShareDataHandler", 1, "initCache e:", localException);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (!QLog.isColorLevel()) {
          break label300;
        }
      }
      QLog.e("cmgame_process.CmGameShareDataHandler", 1, localOutOfMemoryError, new Object[0]);
      return;
      QLog.e("cmgame_process.CmGameShareDataHandler", 1, "file gameShareResult.txt no exsit");
      label300:
      return;
      label301:
      i += 1;
    }
  }
  
  public void a(amzj paramamzj)
  {
    if (paramamzj == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameShareDataHandler", 2, new Object[] { "saveShareResult, result:", paramamzj });
    }
    this.jdField_a_of_type_JavaUtilList.add(0, paramamzj);
    if (this.jdField_a_of_type_JavaUtilList.size() > 100) {
      this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList(this.jdField_a_of_type_JavaUtilList.subList(0, 100));
    }
    ThreadManagerV2.executeOnFileThread(new CmGameShareDataHandler.3(this));
  }
  
  public boolean a(amzj paramamzj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameShareDataHandler", 1, new Object[] { "isDuplicateShare result:", paramamzj });
    }
    boolean bool1;
    if (paramamzj == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      paramamzj = (Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramamzj.a());
      if (paramamzj == null) {
        break;
      }
      bool2 = paramamzj.booleanValue();
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.CmGameShareDataHandler", 1, new Object[] { "isDuplicateShare sameValue:", Boolean.valueOf(bool2) });
    return bool2;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzh
 * JD-Core Version:    0.7.0.1
 */