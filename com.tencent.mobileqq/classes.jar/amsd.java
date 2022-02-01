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

public class amsd
{
  private static amsd jdField_a_of_type_Amsd;
  private Comparator<amsf> jdField_a_of_type_JavaUtilComparator = new amse(this);
  private List<amsf> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap<String, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private amsd()
  {
    ThreadManagerV2.executeOnFileThread(new CmGameShareDataHandler.1(this));
  }
  
  public static amsd a()
  {
    try
    {
      if (jdField_a_of_type_Amsd == null) {
        jdField_a_of_type_Amsd = new amsd();
      }
      amsd localamsd = jdField_a_of_type_Amsd;
      return localamsd;
    }
    finally {}
  }
  
  private void a()
  {
    Object localObject = new File(ancb.s + "gameShareResult.txt");
    if (((File)localObject).exists()) {}
    for (;;)
    {
      int i;
      try
      {
        localObject = amyk.a((File)localObject);
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
            break label320;
          }
          amsf localamsf = new amsf();
          localamsf.d = localJSONObject.optInt("shareTo");
          localamsf.b = localJSONObject.optInt("activity");
          localamsf.c = localJSONObject.optInt("aioType");
          localamsf.jdField_a_of_type_Int = localJSONObject.optInt("gameId");
          localamsf.jdField_a_of_type_JavaLangString = localJSONObject.optString("uin");
          localamsf.jdField_a_of_type_Long = localJSONObject.optLong("shareTS");
          localamsf.e = localJSONObject.optInt("shareRet");
          this.jdField_a_of_type_JavaUtilList.add(localamsf);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localamsf.a(), Boolean.TRUE);
          break label320;
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
          break label319;
        }
      }
      QLog.e("cmgame_process.CmGameShareDataHandler", 1, localOutOfMemoryError, new Object[0]);
      return;
      QLog.e("cmgame_process.CmGameShareDataHandler", 1, "file gameShareResult.txt no exsit");
      label319:
      return;
      label320:
      i += 1;
    }
  }
  
  public void a(amsf paramamsf)
  {
    if (paramamsf == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameShareDataHandler", 2, new Object[] { "saveShareResult, result:", paramamsf });
    }
    this.jdField_a_of_type_JavaUtilList.add(0, paramamsf);
    if (this.jdField_a_of_type_JavaUtilList.size() > 100) {
      this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList(this.jdField_a_of_type_JavaUtilList.subList(0, 100));
    }
    ThreadManagerV2.executeOnFileThread(new CmGameShareDataHandler.3(this));
  }
  
  public boolean a(amsf paramamsf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameShareDataHandler", 1, new Object[] { "isDuplicateShare result:", paramamsf });
    }
    boolean bool1;
    if (paramamsf == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      paramamsf = (Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramamsf.a());
      if (paramamsf == null) {
        break;
      }
      bool2 = paramamsf.booleanValue();
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.CmGameShareDataHandler", 1, new Object[] { "isDuplicateShare sameValue:", Boolean.valueOf(bool2) });
    return bool2;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsd
 * JD-Core Version:    0.7.0.1
 */