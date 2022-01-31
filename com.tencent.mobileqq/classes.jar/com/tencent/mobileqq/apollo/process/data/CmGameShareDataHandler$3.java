package com.tencent.mobileqq.apollo.process.data;

import ajda;
import ajdc;
import ajje;
import ajmu;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class CmGameShareDataHandler$3
  implements Runnable
{
  public CmGameShareDataHandler$3(ajda paramajda) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new File(ajmu.s + "gameShareResult.txt");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        int j = ajda.a(this.this$0).size();
        if (j == 0) {
          return;
        }
        localObject = new JSONArray();
        ajda.a(this.this$0).clear();
        i = 0;
        if (i < j)
        {
          ajdc localajdc = (ajdc)ajda.a(this.this$0).get(i);
          if (localajdc != null)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareTo", localajdc.d);
            localJSONObject.put("activity", localajdc.b);
            localJSONObject.put("aioType", localajdc.c);
            localJSONObject.put("gameId", localajdc.jdField_a_of_type_Int);
            localJSONObject.put("uin", localajdc.jdField_a_of_type_JavaLangString);
            localJSONObject.put("shareTS", localajdc.jdField_a_of_type_Long);
            localJSONObject.put("shareRet", localajdc.e);
            ((JSONArray)localObject).put(localJSONObject);
            ajda.a(this.this$0).put(localajdc.a(), Boolean.TRUE);
          }
        }
        else
        {
          ajje.a(ajmu.s + "gameShareResult.txt", ((JSONArray)localObject).toString());
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