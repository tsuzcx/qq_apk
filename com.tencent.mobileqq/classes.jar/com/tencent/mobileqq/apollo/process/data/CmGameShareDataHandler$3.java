package com.tencent.mobileqq.apollo.process.data;

import akuk;
import akum;
import alao;
import alef;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class CmGameShareDataHandler$3
  implements Runnable
{
  public CmGameShareDataHandler$3(akuk paramakuk) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new File(alef.s + "gameShareResult.txt");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        int j = akuk.a(this.this$0).size();
        if (j == 0) {
          return;
        }
        localObject = new JSONArray();
        akuk.a(this.this$0).clear();
        i = 0;
        if (i < j)
        {
          akum localakum = (akum)akuk.a(this.this$0).get(i);
          if (localakum != null)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareTo", localakum.d);
            localJSONObject.put("activity", localakum.b);
            localJSONObject.put("aioType", localakum.c);
            localJSONObject.put("gameId", localakum.jdField_a_of_type_Int);
            localJSONObject.put("uin", localakum.jdField_a_of_type_JavaLangString);
            localJSONObject.put("shareTS", localakum.jdField_a_of_type_Long);
            localJSONObject.put("shareRet", localakum.e);
            ((JSONArray)localObject).put(localJSONObject);
            akuk.a(this.this$0).put(localakum.a(), Boolean.TRUE);
          }
        }
        else
        {
          alao.a(alef.s + "gameShareResult.txt", ((JSONArray)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameShareDataHandler.3
 * JD-Core Version:    0.7.0.1
 */