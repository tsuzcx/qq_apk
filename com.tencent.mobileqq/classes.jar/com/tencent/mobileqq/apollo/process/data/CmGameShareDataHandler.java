package com.tencent.mobileqq.apollo.process.data;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.store.webview.ApolloClientUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
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
import yyi;
import yyj;
import yyk;

public class CmGameShareDataHandler
{
  private static CmGameShareDataHandler jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameShareDataHandler;
  private Comparator jdField_a_of_type_JavaUtilComparator = new yyj(this);
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private CmGameShareDataHandler()
  {
    ThreadManagerV2.executeOnFileThread(new yyi(this));
  }
  
  public static CmGameShareDataHandler a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameShareDataHandler == null) {
        jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameShareDataHandler = new CmGameShareDataHandler();
      }
      CmGameShareDataHandler localCmGameShareDataHandler = jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameShareDataHandler;
      return localCmGameShareDataHandler;
    }
    finally {}
  }
  
  private void a()
  {
    Object localObject = new File(ApolloConstant.n + "gameShareResult.txt");
    if (((File)localObject).exists()) {}
    for (;;)
    {
      int i;
      try
      {
        localObject = ApolloClientUtil.a((File)localObject);
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
          CmGameShareDataHandler.GameShareResult localGameShareResult = new CmGameShareDataHandler.GameShareResult();
          localGameShareResult.d = localJSONObject.optInt("shareTo");
          localGameShareResult.b = localJSONObject.optInt("activity");
          localGameShareResult.c = localJSONObject.optInt("aioType");
          localGameShareResult.jdField_a_of_type_Int = localJSONObject.optInt("gameId");
          localGameShareResult.jdField_a_of_type_JavaLangString = localJSONObject.optString("uin");
          localGameShareResult.jdField_a_of_type_Long = localJSONObject.optLong("shareTS");
          localGameShareResult.e = localJSONObject.optInt("shareRet");
          this.jdField_a_of_type_JavaUtilList.add(localGameShareResult);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localGameShareResult.a(), Boolean.TRUE);
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
  
  public void a(CmGameShareDataHandler.GameShareResult paramGameShareResult)
  {
    if (paramGameShareResult == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameShareDataHandler", 2, new Object[] { "saveShareResult, result:", paramGameShareResult });
    }
    this.jdField_a_of_type_JavaUtilList.add(0, paramGameShareResult);
    if (this.jdField_a_of_type_JavaUtilList.size() > 100) {
      this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList(this.jdField_a_of_type_JavaUtilList.subList(0, 100));
    }
    ThreadManagerV2.executeOnFileThread(new yyk(this));
  }
  
  public boolean a(CmGameShareDataHandler.GameShareResult paramGameShareResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameShareDataHandler", 1, new Object[] { "isDuplicateShare result:", paramGameShareResult });
    }
    boolean bool1;
    if (paramGameShareResult == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      paramGameShareResult = (Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramGameShareResult.a());
      if (paramGameShareResult == null) {
        break;
      }
      bool2 = paramGameShareResult.booleanValue();
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.CmGameShareDataHandler", 1, new Object[] { "isDuplicateShare sameValue:", Boolean.valueOf(bool2) });
    return bool2;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameShareDataHandler
 * JD-Core Version:    0.7.0.1
 */