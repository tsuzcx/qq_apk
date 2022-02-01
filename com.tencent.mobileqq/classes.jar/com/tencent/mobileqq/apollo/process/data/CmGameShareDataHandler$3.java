package com.tencent.mobileqq.apollo.process.data;

import alyr;
import alyt;
import amey;
import amip;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class CmGameShareDataHandler$3
  implements Runnable
{
  public CmGameShareDataHandler$3(alyr paramalyr) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new File(amip.s + "gameShareResult.txt");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        int j = alyr.a(this.this$0).size();
        if (j == 0) {
          return;
        }
        localObject = new JSONArray();
        alyr.a(this.this$0).clear();
        i = 0;
        if (i < j)
        {
          alyt localalyt = (alyt)alyr.a(this.this$0).get(i);
          if (localalyt != null)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("shareTo", localalyt.d);
            localJSONObject.put("activity", localalyt.b);
            localJSONObject.put("aioType", localalyt.c);
            localJSONObject.put("gameId", localalyt.jdField_a_of_type_Int);
            localJSONObject.put("uin", localalyt.jdField_a_of_type_JavaLangString);
            localJSONObject.put("shareTS", localalyt.jdField_a_of_type_Long);
            localJSONObject.put("shareRet", localalyt.e);
            ((JSONArray)localObject).put(localJSONObject);
            alyr.a(this.this$0).put(localalyt.a(), Boolean.TRUE);
          }
        }
        else
        {
          amey.a(amip.s + "gameShareResult.txt", ((JSONArray)localObject).toString());
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