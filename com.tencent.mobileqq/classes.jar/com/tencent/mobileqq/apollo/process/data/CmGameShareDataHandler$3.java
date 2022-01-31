package com.tencent.mobileqq.apollo.process.data;

import ajcy;
import ajda;
import ajjc;
import ajms;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class CmGameShareDataHandler$3
  implements Runnable
{
  public CmGameShareDataHandler$3(ajcy paramajcy) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new File(ajms.s + "gameShareResult.txt");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        int j = ajcy.a(this.this$0).size();
        if (j == 0) {
          return;
        }
        localObject = new JSONArray();
        ajcy.a(this.this$0).clear();
        i = 0;
        if (i < j)
        {
          ajda localajda = (ajda)ajcy.a(this.this$0).get(i);
          if (localajda != null)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareTo", localajda.d);
            localJSONObject.put("activity", localajda.b);
            localJSONObject.put("aioType", localajda.c);
            localJSONObject.put("gameId", localajda.jdField_a_of_type_Int);
            localJSONObject.put("uin", localajda.jdField_a_of_type_JavaLangString);
            localJSONObject.put("shareTS", localajda.jdField_a_of_type_Long);
            localJSONObject.put("shareRet", localajda.e);
            ((JSONArray)localObject).put(localJSONObject);
            ajcy.a(this.this$0).put(localajda.a(), Boolean.TRUE);
          }
        }
        else
        {
          ajjc.a(ajms.s + "gameShareResult.txt", ((JSONArray)localObject).toString());
          QLog.d("cmgame_process.CmGameShareDataHandler", 1, "saveShareResult finish");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("cmgame_process.CmGameShareDataHandler", 1, "saveShareResult e:", localException);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("cmgame_process.CmGameShareDataHandler", 1, localOutOfMemoryError, new Object[0]);
        }
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameShareDataHandler.3
 * JD-Core Version:    0.7.0.1
 */